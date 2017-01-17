package Proyecto.Cluedo.Logica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.stream.IIOByteBuffer;
import javax.imageio.stream.ImageInputStream;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;

import Proyecto.Cluedo.Datos.*;

public class GestionBaseDeDatos {

	/**
	 * Parametro que contiene el logger para ir viendo lo que pasa
	 */

	private static Logger logger = Logger.getLogger(GestionBaseDeDatos.class.getName());

	/**
	 * Parametro que contiene el driver para utilizar la base de datos de heroku
	 */

	private static final String DRIVER = "org.postgresql.Driver";

	/**
	 * Parametro que contiene el enlace a la base de datos
	 */

	private static final String URL = "jdbc:postgresql://ec2-54-228-214-46.eu-west-1.compute.amazonaws.com:5432/d1uo969itg8nsu?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

	/**
	 * Parametro que contiene el nombre de usuario
	 */

	private static final String USERNAME = "ssdiyqrzfdvpfe";

	/**
	 * Parametro que contiene la contraseña
	 */

	private static final String PASSWORD = "M8Wk6yhGomz7HKFTBopcsYpMfM";

	/**
	 * Metodo que devuelve un statement para usar la base de datos
	 * 
	 * @param con
	 *            Parametro que contiene la conexion con la base
	 * @return Devuelve un statement para usar con la base
	 */

	public static Statement usarBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			return statement;
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error en el establecimiento de la conexion con la base");
			return null;
		}
	}

	/**
	 * Metodo que sirve para inicializar la base de datos
	 * 
	 * @return Devuelve la conexion con la base de datos
	 */

	public static Connection inicializarLaBase() {
		try {
			Class.forName(DRIVER);

			Connection conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			logger.log(Level.INFO, "Inicializada la base de datos");
			return conexion;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error en la inicializacion de la base de datos");
			return null;
		}
	}

	/**
	 * Metodo que sirve para introducir un update
	 * 
	 * @param creacion
	 *            Parametro que contiene el comando SQL
	 * @param conexion
	 *            Parametro que contiene la conexion con la base de datos
	 * @return Devuelve el statement que genera el update
	 */

	public static Statement crearTabla(String creacion, Connection conexion) {

		try {
			Statement statement = conexion.createStatement();
			statement.setQueryTimeout(30);

			statement.executeUpdate(creacion);

			logger.log(Level.INFO, "Creada la tabla: " + creacion);

			return statement;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error en la creacion de la tabla");
			e.printStackTrace();
			return null;
		}

	}

	public static void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null) {
				st.close();
				logger.log(Level.INFO, "Se ha cerrado el statement");
			}

			if (con != null) {
				con.close();
				logger.log(Level.INFO, "Se ha cerrado la conexion");
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha podido realizar la operacion de cierre");
		}
	}

	public void modificar(Connection conexion, String tabla, String actualizacion, String condicion) {
		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "UPDATE " + tabla + " SET " + actualizacion + " WHERE " + condicion;

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha modificado la linea: " + sql);

			statement.close();

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error a la hora de modificar la tabla");
			e.printStackTrace();

		}

	}

	// TABLA USUARIO

	/**
	 * Metodo que sirve para crear la tabla de usuario
	 * 
	 * @param conexion
	 *            Parametro que contiene la conexion con la base de datos
	 * @return Devuelve el statament que crea la tabla
	 */

	public static Statement crearTablaUsuario(Connection conexion) {

		try {

			Statement statement = conexion.createStatement();

			try {
				statement.executeUpdate(
						"CREATE TABLE USUARIO (NOMBRE text,APELLIDO text,NOMBREUSUARIO text not null primary key,EMAIL text,CONTRASEÑA text,GENERO text,FECHANACIMIENTO bigint,PREGUNTA integer,RESPUESTA text, FECHAULTIMOLOGIN bigint,IMAGENPERFIL bytea,PUNTUACION bigint)");
			} catch (SQLException h) {
				logger.log(Level.WARNING, "La tabla ya esta creada");
				return null;
			}
			logger.log(Level.INFO, "Se ha creado una tabla");
			return statement;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error en la creacion de la tabla");
			return null;
		}
	}

	public static boolean insertarUsuario(Connection conexion, Usuario u) {

		try {

			Image image = u.getImagenPerfil().getImage();
			BufferedImage bImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			Graphics bg = bImage.getGraphics();
			bg.drawImage(image, 0, 0, null);
			bg.dispose();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpeg", out);
			byte[] buf = out.toByteArray();
			ByteArrayInputStream inStream = new ByteArrayInputStream(buf);

			/*
			 * File file = new
			 * File(u.getImagenPerfil().toString().substring(6));
			 * FileInputStream fils = new FileInputStream(file);
			 */
			PreparedStatement ps = conexion
					.prepareStatement("INSERT INTO USUARIO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, u.getNombre());
			ps.setString(2, u.getApellidos());
			ps.setString(3, u.getUsuario());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getContraseña());
			ps.setString(6, "" + u.getGenero());
			ps.setLong(7, u.getFechaNacimeinto().getTime());
			ps.setInt(8, u.getPregunta());
			ps.setString(9, u.getRespuesta());
			ps.setLong(10, u.getConexion().getTime());

			ps.setBinaryStream(11, inStream, inStream.available());
			ps.setLong(12, u.getPuntuacion());
			ps.executeUpdate();
			ps.close();

			logger.log(Level.INFO, "Se ha añadido la fila");
			return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error al insertar la fila");
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Usuario> consultaATabla(Connection conexion, String seleccion) {

		ArrayList<Usuario> ret = new ArrayList<>();

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT * FROM USUARIO";

			if (seleccion != null && !seleccion.equals(""))

				sentSQL = sentSQL + " WHERE " + seleccion;

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {
				Usuario u = new Usuario();

				u.setNombre(rs.getString("NOMBRE"));
				u.setContraseña(rs.getString("CONTRASEÑA"));
				u.setApellidos(rs.getString("APELLIDO"));
				u.setUsuario(rs.getString("NOMBREUSUARIO"));
				u.setEmail(rs.getString("EMAIL"));
				u.setPregunta(rs.getInt("PREGUNTA"));
				u.setRespuesta(rs.getString("RESPUESTA"));
				if (rs.getString("GENERO").equals("HOMBRE")) {
					u.setGenero(Genero.HOMBRE);
				} else {
					u.setGenero(Genero.MUJER);
				}
				u.setConexion(new Date(rs.getLong("FECHAULTIMOLOGIN")));
				u.setFechaNacimeinto(new Date(rs.getLong("FECHANACIMIENTO")));

				ImageIcon imagen = new ImageIcon();
				/**
				 * Blob blob = rs.getBlob("IMAGENPERFIL"); byte[] data =
				 * blob.getBytes(1, (int)blob.length()); img = ImageIO.read(new
				 * ByteArrayInputStream(data)); try { img = ImageIO.read(new
				 * ByteArrayInputStream(data)); } catch (IOException ex) {
				 * 
				 * }
				 */

				byte[] imgBytes = rs.getBytes(11);

				BufferedImage img = null;
				img = ImageIO.read(new ByteArrayInputStream(imgBytes));

				imagen.setImage(img);

				u.setImagenPerfil(imagen);

				u.setPuntuacion(rs.getLong("PUNTUACION"));

				ret.add(u);
			}
			rs.close();
			return ret;
		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Usuario> consultaATablaOrdenadoNombreUsuario(Connection conexion) {

		ArrayList<Usuario> ret = new ArrayList<>();

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT * FROM USUARIO ORDER BY NOMBREUSUARIO";

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {
				Usuario u = new Usuario();

				u.setNombre(rs.getString("NOMBRE"));
				u.setContraseña(rs.getString("CONTRASEÑA"));
				u.setApellidos(rs.getString("APELLIDO"));
				u.setUsuario(rs.getString("NOMBREUSUARIO"));
				u.setEmail(rs.getString("EMAIL"));
				u.setPregunta(rs.getInt("PREGUNTA"));
				u.setRespuesta(rs.getString("RESPUESTA"));
				if (rs.getString("GENERO").equals("HOMBRE")) {
					u.setGenero(Genero.HOMBRE);
				} else {
					u.setGenero(Genero.MUJER);
				}
				u.setConexion(new Date(rs.getLong("FECHAULTIMOLOGIN")));
				u.setFechaNacimeinto(new Date(rs.getLong("FECHANACIMIENTO")));

				ImageIcon imagen = new ImageIcon();
				/**
				 * Blob blob = rs.getBlob("IMAGENPERFIL"); byte[] data =
				 * blob.getBytes(1, (int)blob.length()); img = ImageIO.read(new
				 * ByteArrayInputStream(data)); try { img = ImageIO.read(new
				 * ByteArrayInputStream(data)); } catch (IOException ex) {
				 * 
				 * }
				 */

				byte[] imgBytes = rs.getBytes(11);

				BufferedImage img = null;
				img = ImageIO.read(new ByteArrayInputStream(imgBytes));

				imagen.setImage(img);

				u.setImagenPerfil(imagen);

				u.setPuntuacion(rs.getLong("PUNTUACION"));

				ret.add(u);
			}
			rs.close();
			return ret;
		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Usuario> consultaATablaOrdenadoPuntuacion(Connection conexion) {

		ArrayList<Usuario> ret = new ArrayList<>();

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT * FROM USUARIO ORDER BY PUNTUACION DESC";

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {
				Usuario u = new Usuario();

				u.setNombre(rs.getString("NOMBRE"));
				u.setContraseña(rs.getString("CONTRASEÑA"));
				u.setApellidos(rs.getString("APELLIDO"));
				u.setUsuario(rs.getString("NOMBREUSUARIO"));
				u.setEmail(rs.getString("EMAIL"));
				u.setPregunta(rs.getInt("PREGUNTA"));
				u.setRespuesta(rs.getString("RESPUESTA"));
				if (rs.getString("GENERO").equals("HOMBRE")) {
					u.setGenero(Genero.HOMBRE);
				} else {
					u.setGenero(Genero.MUJER);
				}
				u.setConexion(new Date(rs.getLong("FECHAULTIMOLOGIN")));
				u.setFechaNacimeinto(new Date(rs.getLong("FECHANACIMIENTO")));

				ImageIcon imagen = new ImageIcon();
				/**
				 * Blob blob = rs.getBlob("IMAGENPERFIL"); byte[] data =
				 * blob.getBytes(1, (int)blob.length()); img = ImageIO.read(new
				 * ByteArrayInputStream(data)); try { img = ImageIO.read(new
				 * ByteArrayInputStream(data)); } catch (IOException ex) {
				 * 
				 * }
				 */

				byte[] imgBytes = rs.getBytes(11);

				BufferedImage img = null;
				img = ImageIO.read(new ByteArrayInputStream(imgBytes));

				imagen.setImage(img);

				u.setImagenPerfil(imagen);

				u.setPuntuacion(rs.getLong("PUNTUACION"));

				ret.add(u);
			}
			rs.close();
			return ret;

		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}

	}

	public HashMap<String, Integer> consultaATablaHash(Connection conexion, String seleccion) {

		HashMap<String, Integer> ret = new HashMap<>();

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT NOMBREUSUARIO,PUNTUACION FROM USUARIO";

			if (seleccion != null && !seleccion.equals(""))

				sentSQL = sentSQL + " WHERE " + seleccion;

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {
				ret.put(rs.getString("NOMBREUSUARIO"), (int) rs.getFloat("PUNTUACION"));

			}
			rs.close();
			return ret;
		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}
	}

	public boolean borrarUsuario(Connection conexion, Usuario u) {

		String sql = "";

		try {

			sql = "DELETE FROM USUARIO WHERE NOMBREUSUARIO='" + u.getUsuario() + "'";

			Statement statement = conexion.createStatement();

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha borrado correctamente:" + sql);

			statement.close();
			return true;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "Ha habido un error a la hora de borrar a: " + sql);
			e.printStackTrace();
			return false;
		}
	}

	public void cambiarFoto(Connection conexion, Usuario u) {

		String sql = "";

		try {

			Image image = u.getImagenPerfil().getImage();

			BufferedImage bImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			Graphics bg = bImage.getGraphics();
			bg.drawImage(image, 0, 0, null);
			bg.dispose();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpeg", out);
			byte[] buf = out.toByteArray();
			ByteArrayInputStream inStream = new ByteArrayInputStream(buf);

			Statement statement = conexion.createStatement();

			PreparedStatement ps = conexion.prepareStatement("UPDATE USUARIO SET IMAGENPERFIL=? WHERE NOMBREUSUARIO=?");

			ps.setBinaryStream(1, inStream, inStream.available());
			ps.setString(2, u.getUsuario());
			ps.executeUpdate();
			ps.close();

			logger.log(Level.INFO, "Se ha modificado correctamente la foto" + sql);

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se ha podido cambiar la foto " + sql);

			e.printStackTrace();
		}

	}

	// TABLA PARTIDA

	/**
	 * Metodo que sirve para insertar una partida a la base de datos
	 * 
	 * @param conexion
	 *            Parametro que contiene la conexion con la base de datos
	 * @param p
	 *            Parametro que contiene la partida que se desea añadir
	 * @return Devuelve true si se añade
	 */

	public boolean insertarPartida(Connection conexion, Partida p) {

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "INSERT INTO PARTIDA VALUES ('" + p.getNombre() + "'," + p.getCodigo() + ","
					+ p.getNumeroJugadoresMaximo() + "," + p.getNumeroJugadoresActual() + "," + p.getPosicionBarco()
					+ ",'" + p.getMensajeCartel() + "'," + p.isOrientacion() + "," + p.isAccion() + ")";

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha añadido la partida: " + sql);

			statement.close();

			return true;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro el insertar la partida : " + sql);
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Metodo que sirve para borrar una lista de la base de datos
	 * 
	 * @param conexion
	 *            Parametro que contiene la conexion con la base
	 * @param tabla
	 *            Parametro que contiene de la tabla que se desea borrar
	 * @param condicion
	 *            Parametro que contiene la condicion para borrar
	 * @return Devuelve true si se ha borrado
	 */

	public boolean borrarPartida(Connection conexion, String tabla, String condicion) {

		String sql = "";

		try {

			sql = "DELETE FROM " + tabla + " WHERE " + condicion;

			Statement statement = conexion.createStatement();

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha borrado la partida: " + sql);

			statement.close();

			return true;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha conseguido borrar la partida");
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList<Integer> obtenerCodigoPartidas(Connection conexion) {

		ArrayList<Integer> listadeCodigos = new ArrayList<Integer>();

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "SELECT CODIGO FROM PARTIDA ORDER BY CODIGO";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				int indice = rs.getInt(1);
				// System.out.println(indice);
				listadeCodigos.add(indice);
			}

			rs.close();

			statement.close();
			return listadeCodigos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Integer> obtenerCodigoPartidasSinCompletar(Connection conexion, String usuario) {

		ArrayList<Integer> listadeCodigos = new ArrayList<Integer>();

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "SELECT CODIGO FROM PARTIDA WHERE NUMEROJUGADORESACTUAL<NUMEROJUGADORESMAXIMO EXCEPT SELECT COD_PARTIDA FROM JUGADOR WHERE NOMBRE_USUARIO='"
					+ usuario + "' ORDER BY 1";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				int indice = rs.getInt(1);
				// System.out.println(indice);
				listadeCodigos.add(indice);
			}

			rs.close();

			statement.close();
			return listadeCodigos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<String> obtenerNombrePartidas(Connection conexion, String usuario) {

		ArrayList<String> listadeNombre = new ArrayList<String>();

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "SELECT NOMBRE,CODIGO FROM PARTIDA WHERE NUMEROJUGADORESACTUAL<NUMEROJUGADORESMAXIMO  EXCEPT SELECT NOMBRE,CODIGO FROM PARTIDA, JUGADOR WHERE"
					+ " PARTIDA.CODIGO=JUGADOR.COD_PARTIDA AND JUGADOR.NOMBRE_USUARIO='" + usuario + "' ORDER BY 2";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String nombre = rs.getString(1);
				listadeNombre.add(nombre);
			}

			rs.close();

			statement.close();
			return listadeNombre;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Integer> obtenerJugadoresPartidas(Connection conexion, String columna,
			ArrayList<Integer> listaCodigosSinCompletar) {

		ArrayList<Integer> listadeJugadores = new ArrayList<Integer>();

		String sql = "";

		try {

			if (listaCodigosSinCompletar.size() > 0) {

				Statement statement = conexion.createStatement();

				sql = "SELECT " + columna
						+ " FROM PARTIDA WHERE NUMEROJUGADORESACTUAL<NUMEROJUGADORESMAXIMO AND CODIGO IN (";

				int contador = 0;
				for (Integer i : listaCodigosSinCompletar) {
					sql = sql + i;

					if (contador == listaCodigosSinCompletar.size() - 1) {

					} else {
						sql = sql + ",";
					}
					contador++;
				}

				sql = sql + ")ORDER BY CODIGO ";

				System.out.println(sql);
				ResultSet rs = statement.executeQuery(sql);

				while (rs.next()) {
					int jugador = rs.getInt(1);
					listadeJugadores.add(jugador);
				}

				rs.close();

				statement.close();
			}
			return listadeJugadores;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<String> obtenerNombreP(Connection conexion, ArrayList<Integer> partida) {

		ArrayList<String> listaNombre = new ArrayList<String>();

		String sql = "";

		try {
			Statement statement = conexion.createStatement();

			for (Integer i : partida) {

				sql = "SELECT NOMBRE FROM PARTIDA WHERE CODIGO=" + i;

				ResultSet rs = statement.executeQuery(sql);

				while (rs.next()) {

					String nombre = rs.getString(1);
					listaNombre.add(nombre);

				}
				rs.close();
			}

			statement.close();

			return listaNombre;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Partida obtenerPartida(Connection conexion, int codigo) {

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "SELECT * FROM PARTIDA WHERE CODIGO =" + codigo;

			ResultSet resultado = statement.executeQuery(sql);
			Partida p = new Partida();
			while (resultado.next()) {
				int CODIGO = resultado.getInt("CODIGO");
				String nombre = resultado.getString("NOMBRE");
				int jugadorActual = resultado.getInt("NUMEROJUGADORESACTUAL");
				int jugadorMaximo = resultado.getInt("NUMEROJUGADORESMAXIMO");

				double posicionBarco = resultado.getDouble("POSICIONBARCO");

				boolean orientacion = resultado.getBoolean("ORIENTACION");

				boolean accion = resultado.getBoolean("ACCION");

				String texto = resultado.getString("MENSAJECARTEL");

				p.setCodigo(CODIGO);
				p.setMensajeCartel(texto);
				p.setNombre(nombre);
				p.setNumeroJugadoresActual(jugadorActual);
				p.setNumeroJugadoresMaximo(jugadorMaximo);
				p.setPosicionBarco(posicionBarco);
				p.setOrientacion(orientacion);

				p.setAccion(accion);

			}

			resultado.close();

			logger.log(Level.INFO, "Se ha obtenido correctamente la partida " + codigo);

			return p;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "Ha habido un error a la hora de encontrar una partida :" + codigo);

			e.printStackTrace();

			return null;

		}
	}

	// Tabla jugador

	// INSERTAR JUGADORES

	public boolean insertarJugador(Connection conexion, Jugador j, Partida p, Usuario u) {

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "INSERT INTO JUGADOR VALUES (" + j.getCodigo() + "," + j.getCodigoPartida() + ",'" + j.getUsuario()
					+ "'," + j.getPosicionMuñeco() + "," + j.getLugar() + "," + j.getTurno() + ",'" + j.getFicha()
					+ "','" + j.isEnLinea() + "')";

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha añadido el jugador: " + sql);

			statement.close();

			return true;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro el insertar el jugador : " + sql);
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertarJugadorLugar(Connection conexion, Jugador j, Partida p, int lugar) {
		// String creacion2 = "CREATE TABLE JUGADOR(COD_JUG int NOT NULL PRIMARY
		// KEY,COD_PARTIDA int NOT NULL REFERENCES PARTIDA (CODIGO) ON DELETE
		// CASCADE,NOMBRE_USUARIO text NOT NULL REFERENCES
		// USUARIO(NOMBREUSUARIO),POS_MUÑECO NUMERIC(8,4),LUGAR INT,TURNO
		// int,MUÑECO text,DIBUJO bytea,ENLINEA boolean)";
		// gestion.crearTabla(creacion2,conexion);
		//
		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "UPDATE JUGADOR SET LUGAR=" + lugar + "WHERE COD_JUG=" + j.getCodigo();

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha añadido el jugador: " + sql);

			statement.close();

			return true;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro el insertar el jugador : " + sql);
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Jugador> consultaATablaJugador(Connection conexion, String seleccion) {

		ArrayList<Jugador> ret = new ArrayList<>();

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT * FROM JUGADOR";

			if (seleccion != null && !seleccion.equals(""))

				sentSQL = sentSQL + " WHERE " + seleccion;

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {
				Jugador j = new Jugador();

				j.setCodigo(rs.getInt("COD_JUG"));
				j.setLugar(rs.getInt("LUGAR"));
				j.setFicha(rs.getString("MUÑECO"));
				j.setPosicionMuñeco(rs.getDouble("POS_MUÑECO"));
				j.setTurno(rs.getInt("TURNO"));
				j.setUsuario(rs.getString("NOMBRE_USUARIO"));
				j.setCodigoPartida(rs.getInt("COD_PARTIDA"));

				j.setEnLinea(rs.getBoolean("ENLINEA"));

				ret.add(j);
			}
			rs.close();
			return ret;
		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Jugador> ObtenerJugadoresDePartidaordenadosPorCodigo(Partida p, Connection conexion) {

		ArrayList<Jugador> ret = new ArrayList<>();

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT * FROM JUGADOR WHERE COD_PARTIDA=" + p.getCodigo() + "ORDER BY COD_JUG";

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {
				Jugador j = new Jugador();

				j.setCodigo(rs.getInt("COD_JUG"));
				j.setLugar(rs.getInt("LUGAR"));
				j.setFicha(rs.getString("MUÑECO"));
				j.setPosicionMuñeco(rs.getDouble("POS_MUÑECO"));
				j.setTurno(rs.getInt("TURNO"));
				j.setUsuario(rs.getString("NOMBRE_USUARIO"));
				j.setCodigoPartida(rs.getInt("COD_PARTIDA"));

				j.setEnLinea(rs.getBoolean("ENLINEA"));

				ret.add(j);
			}
			rs.close();
			return ret;
		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}
	}

	public int ObtenerCodigoJugadorTurno(Connection conexion, Partida p) {
		int codigo = -1;
		try {

			Statement statement = conexion.createStatement();

			String sql = "SELECT COD_JUG FROM JUGADOR WHERE TURNO=" + 1 + "AND COD_PARTIDA=" + p.getCodigo();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				codigo = rs.getInt(1);

			}

			rs.close();

			statement.close();
			return codigo;
		} catch (Exception e) {

			e.printStackTrace();
			return -1;
		}

	}

	public ArrayList<Integer> obtenerCodigoPartidaJugador(Connection conexion, String usuario) {

		ArrayList<Integer> listadeCodigos = new ArrayList<Integer>();

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "SELECT COD_PARTIDA FROM JUGADOR WHERE NOMBRE_USUARIO='" + usuario + "' ORDER BY COD_PARTIDA";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int codigo = rs.getInt(1);
				listadeCodigos.add(codigo);
			}

			rs.close();

			statement.close();
			return listadeCodigos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Integer> obtenerCodigoJugador(Connection conexion) {

		ArrayList<Integer> listadeCodigos = new ArrayList<Integer>();

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "SELECT COD_JUG FROM JUGADOR ORDER BY COD_JUG";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				int indice = rs.getInt(1);
				// System.out.println(indice);
				listadeCodigos.add(indice);
			}

			rs.close();

			statement.close();
			return listadeCodigos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Jugador obtenerJu(Connection conexion, Partida p, Usuario u) {

		String SQL = "";
		Jugador j = new Jugador();
		;
		try {

			Statement statement = conexion.createStatement();

			SQL = "SELECT * FROM JUGADOR WHERE COD_PARTIDA=" + p.getCodigo() + " AND NOMBRE_USUARIO='" + u.getUsuario()
					+ "'";

			ResultSet rs = statement.executeQuery(SQL);

			while (rs.next()) {

				j.setCodigo(rs.getInt("COD_JUG"));
				j.setLugar(rs.getInt("LUGAR"));
				j.setFicha(rs.getString("MUÑECO"));
				j.setPosicionMuñeco(rs.getDouble("POS_MUÑECO"));
				j.setTurno(rs.getInt("TURNO"));
				j.setUsuario(rs.getString("NOMBRE_USUARIO"));
				j.setCodigoPartida(rs.getInt("COD_PARTIDA"));

				j.setEnLinea(rs.getBoolean("ENLINEA"));
			}

			rs.close();

			statement.close();
			return j;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se ha conseguido obtener el jugador a partir de de la partida y el usuario");

			e.printStackTrace();

			return null;
		}

	}

	// cartas
	public boolean insertarCarta(Connection conexion, Cartas c) {

		String sql = "";

		try {

			String creacion = "CREATE TABLE CARTA(NOMBRE text NOT NULL PRIMARY KEY,RUTAICONO text,CULPABLE int,TIPOCARTA int)";

			Statement statement = conexion.createStatement();

			sql = "INSERT INTO CARTA VALUES ('" + c.getNombre() + "','" + c.getRutaIcono() + "'," + c.isCulpable() + ","
					+ c.getTipo() + ")";

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha añadido el jugador: " + sql);

			statement.close();

			return true;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro el insertar la carta : " + sql);
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<String> obtenerJugadoresLinea(Connection conexion, Jugador j) {

		ArrayList<String> listaUsuarios = new ArrayList<String>();

		String SQL = "";

		try {

			Statement statement = conexion.createStatement();

			SQL = "SELECT NOMBRE_USUARIO FROM JUGADOR WHERE ENLINEA='t' AND COD_PARTIDA=" + j.getCodigoPartida();

			ResultSet rs = statement.executeQuery(SQL);

			while (rs.next()) {

				String nombreUsuario = rs.getString(1);

				listaUsuarios.add(nombreUsuario);

			}

			logger.log(Level.INFO, "Se han obtenido correctamente los datos de usuario");

			statement.close();

			return listaUsuarios;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "Ha habido un error a la hora de obtener los jugadores en linea: " + SQL);

			e.printStackTrace();

			return null;
		}

	}

	// TABLA CHAT

	public void insertarChat(Connection conexion, Chat c) {

		String SQL = "";

		try {

			Statement statement = conexion.createStatement();

			SQL = "INSERT INTO CHAT VALUES ('" + c.getMensaje() + "'," + c.getFechaEnvio().getTime() + ","
					+ c.getCodigoPartida() + "," + c.getCodigoJugador() + ",'" + c.getNombreUsuario() + "')";

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha añadido correctamente el chat " + SQL);

			statement.close();

		} catch (Exception e) {

			logger.log(Level.SEVERE, "Ha habido un eror a la hora de insertar el chat " + SQL);

			e.printStackTrace();
		}
	}

	public ArrayList<String> obtenerChats(Connection conexion, int codigoPartida) {

		ArrayList<String> listaMensajes = new ArrayList<String>();

		// ArrayList<String> listaUsuarios = new ArrayList<String>();
		//
		// ArrayList <String> listaChat = new ArrayList<>();

		String SQL = "";

		try {

			Statement statement = conexion.createStatement();

			SQL = "SELECT MENSAJE,NOMBREUSUARIO FROM CHAT WHERE CODIGOPARTIDA=" + codigoPartida;

			ResultSet rs = statement.executeQuery(SQL);

			while (rs.next()) {
				if (rs != null) {

					String mensaje = rs.getString(1);

					String usuario = rs.getString(2);

					listaMensajes.add("<br> &nbsp &nbsp &nbsp " + usuario + ": " + mensaje + " &nbsp &nbsp &nbsp <br>");
					// listaMensajes.add(mensaje);
				}
			}

			rs.close();
			statement.close();

			logger.log(Level.INFO, "Se han obtenido correctamente los mensajes");

			return listaMensajes;

			// SQL = "SELECT NOMBREUSUARIO FROM CHAT WHERE
			// CODIGOPARTIDA="+codigoPartida+" ORDER BY FECHAENVIO";
			//
			// ResultSet rsp= statement.executeQuery(SQL);
			//
			// while (rsp.next()){
			// if (rsp!=null){
			// String usuario = rsp.getString(1);
			//
			// listaUsuarios.add(usuario);
			// }
			// }
			//
			// rsp.close();
			//
			// logger.log(Level.INFO, "Se han obtenido correctamente los
			// usuarios");

			// for (int i=0;i<listaUsuarios.size();i++){
			//
			// listaChat.add("\n"+listaUsuarios.get(i)+":
			// "+listaMensajes.get(i));
			// }
			//
			// return listaChat;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se han podido obtener los chats" + SQL);

			e.printStackTrace();

			return null;
		}

	}

	// CARTAS
	//////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Cartas> consultaATablaCartas(Connection conexion, String seleccion) {
		ArrayList<Cartas> ret = new ArrayList<>();

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT * FROM CARTA";

			if (seleccion != null && !seleccion.equals(""))

				sentSQL = sentSQL + " WHERE " + seleccion;

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {
				Cartas c = new Cartas();

				c.setNombre(rs.getString("NOMBRE"));
				c.setRutaIcono(rs.getString("RUTAICONO"));
				c.setCulpable(rs.getInt("CULPABLE"));
				c.setTipo(rs.getInt("TIPOCARTA"));
				ret.add(c);
			}
			rs.close();
			statement.close();
			return ret;
		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> obtenerCartasDeJugador(Connection conexion, int codpartidda, int codjug, int tipo) {
		System.out.println("entro en obtener cartas de jugador");
		ArrayList<String> ret = new ArrayList<>();

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT NOMBRECARTA FROM JUEGA WHERE TIPOCARTA=" + tipo + "AND CODJUGADOR=" + codjug
					+ "AND CODPARTIDA=" + codpartidda;

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {

				ret.add(rs.getString("NOMBRECARTA"));
				System.out.println(rs.getString("NOMBRECARTA"));
			}
			rs.close();
			statement.close();
			return ret;
		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}
	}

	public void modificarEstado(Connection conexion, Jugador j) {
		String SQL = "";

		try {

			Statement statement = conexion.createStatement();

			SQL = "UPDATE JUGADOR SET ENLINEA='" + j.isEnLinea() + "' WHERE COD_JUG=" + j.getCodigo();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha modificado correctamente el estado" + SQL);

			statement.close();

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha modificado correctamente");
			e.printStackTrace();
		}

	}

	public double pasarxyAdecimal(int y, int x) {
		int res = y;
		int k = 0;
		while (((int) res) > 0) {
			k = k + 1;
			res = res / 10;

		}

		while (k < 4) {
			k = k + 1;
		}
		double numero = x + (y / (Math.pow(10, k)));

		System.out.println(numero);
		return numero;
	}

	public Point pasarDeDecimalAxy(double x) {
		int num = (int) x;
		int k = 0;
		double numero = x;
		double decimal = numero - num;

		System.out.println(decimal - (int) decimal);
		while ((decimal - (int) decimal) > 0.000001 && k < 4) {
			k = k + 1;
			decimal = decimal * 10;
			if (k == 4) {
				if ((decimal - (int) decimal) > 0.8) {
					decimal = decimal + 1;
				}
			}

		}

		int numeroP = Integer.parseInt("3");
		String numeroPO = "" + numeroP;

		int y = (int) decimal;
		System.out.println("punto" + num + " " + y);
		Point p = new Point(num, y);

		return p;
	}

	public void modificarCoordenada(Connection conexion, Jugador j, int x, int y) {
		double numero = pasarxyAdecimal(y, x);
		String SQL = "";

		try {

			Statement statement = conexion.createStatement();

			SQL = "UPDATE JUGADOR SET POS_MUÑECO=" + numero + "WHERE COD_JUG=" + j.getCodigo();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha modificado correctamente el estado" + SQL);

			statement.close();

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha modificado correctamente");
			e.printStackTrace();
		}

	}

	public Point ObtenerCoordenada(Connection conexion, Jugador j) {
		System.out.println("entro obtener coordenada");
		double coor = 99;
		String sql = "";
		Point punto = new Point();

		try {

			Statement statement = conexion.createStatement();

			sql = "SELECT POS_MUÑECO FROM JUGADOR WHERE COD_JUG=" + j.getCodigo();

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				coor = rs.getDouble(1);
				punto = pasarDeDecimalAxy(coor);
				System.out.println(punto);

				logger.log(Level.INFO, "la coordenada es" + coor);
			}

			rs.close();

			statement.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return punto;
	}

	public String lugarAcusacion(Connection conexion, Jugador j) {
		String lugar;
		int luugar = 0;

		String sql = "";

		try {

			Statement statement = conexion.createStatement();

			sql = "SELECT LUGAR FROM JUGADOR WHERE COD_JUG=" + j.getCodigo();

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				luugar = rs.getInt(0);
				logger.log(Level.INFO, "el numero del lugar es" + luugar);
			}

			rs.close();

			statement.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return CambioDeNumeroALugar(luugar);
	}

	public String CambioDeNumeroALugar(int num) {
		if (num == 0) {
			return "Deusto";
		} else if (num == 1) {
			return "F. Ingenieria";
		} else if (num == 2) {
			return "La Comercial";
		} else if (num == 3) {
			return "la L";

		} else if (num == 4) {
			return "La Capilla";
		} else if (num == 5) {
			return "Edificio centenario";
		} else if (num == 6) {
			return "Edificio de letras";
		} else if (num == 7) {
			return "Biblioteca";
		} else if (num == 8) {
			return "Campo";
		} else if (num == 9) {
			return "Zubiarte";
		} else {
			return "";
		}
	}

	public int CambioDeLugarANumero(String lugar) {
		if (lugar == "Deusto") {
			return 0;
		} else if (lugar == "F. Ingenieria") {
			return 1;
		} else if (lugar == "La Comercial") {
			return 2;
		} else if (lugar == "la L") {
			return 3;

		} else if (lugar == "La Capilla") {
			return 4;
		} else if (lugar == "Edificio centenario") {
			return 5;
		} else if (lugar == "Edificio de letras") {
			return 6;
		} else if (lugar == "Biblioteca") {
			return 7;
		} else if (lugar == "Campo") {
			return 8;
		} else if (lugar == "Zubiarte") {
			return 9;
		} else {
			return 10;
		}
	}

	public ArrayList<Cartas> obtenerCartasEnviadas(Connection conexion, int codpartidda, int codjugordestino) {
		System.out.println("entro en obtener cartan enviadas");
		ArrayList<String> ret = new ArrayList<>();
		ArrayList<Cartas> arr = new ArrayList<Cartas>();
		// String crearecibircartas = "CREATE TABLE RECIBIRCARTAS(NOMBRECARTA
		// text ,CODJUGADORORIGEN int NOT NULL REFERENCES JUGADOR (COD_JUG) ON
		// DELETE CASCADE,CODJUGADORDESTINO int NOT NULL REFERENCES JUGADOR
		// (COD_JUG) ON DELETE CASCADE,CODPARTIDA int NOT NULL REFERENCES
		// PARTIDA(CODIGO) ON DELETE CASCADE,TIEMPO bigint NOT NULL,PRIMARY
		// KEY(CODJUGADORORIGEN,CODJUGADORDESTINO,CODPARTIDA,TIEMPO) )";

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT NOMBRECARTA FROM RECIBIRCARTAS WHERE CODPARTIDA=" + codpartidda
					+ "AND CODJUGADORDESTINO=" + codjugordestino;
			logger.log(Level.INFO, sentSQL);

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {
				logger.log(Level.INFO, "entro en el while de obtener cartas enviadas");
				ret.add(rs.getString("NOMBRECARTA"));
				System.out.println(rs.getString("NOMBRECARTA") + "obtenercartasenviadas");

			}

			rs.close();
			statement.close();

			for (int i = 0; i < ret.size(); i++) {
				arr = consultaATablaCartas(conexion, "NOMBRE='" + ret.get(i) + "'");

				logger.log(Level.WARNING, "Construyo array Cartas");

			}
			return arr;

		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}

	}

	public void modificarPanel(Connection conexion, String mensaje, Partida p) {
		// String creacion = "CREATE TABLE PARTIDA (NOMBRE text, CODIGO int NOT
		// NULL PRIMARY KEY, NUMEROJUGADORESMAXIMO int , NUMEROJUGADORESACTUAL
		// int,POSICIONBARCO real,MENSAJECARTEL text)";

		String SQL = "";

		try {

			Statement statement = conexion.createStatement();

			SQL = "UPDATE PARTIDA SET MENSAJECARTEL='" + mensaje + "' WHERE CODIGO=" + p.getCodigo();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha modificado correctamente el mensaje del panel" + SQL);
			statement.close();

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha modificado correctamente");
			e.printStackTrace();
		}

	}

	public String ObtenerPanel(Connection conexion, Partida p) {

		String ret = "";

		String SQL = "";

		try {

			Statement statement = conexion.createStatement();

			SQL = "SELECT MENSAJECARTEL FROM PARTIDA WHERE CODIGO=" + p.getCodigo();

			ResultSet rs = statement.executeQuery(SQL);

			while (rs.next()) {
				ret = rs.getString("MENSAJECARTEL");

			}

			rs.close();

			statement.close();
			return ret;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha modificado correctamente");
			e.printStackTrace();
			return null;
		}

	}

	public boolean borrarCartasEnviadas(Connection conexion) {
		// String crearecibircartas = "CREATE TABLE RECIBIRCARTAS(NOMBRECARTA
		// text ,CODJUGADORORIGEN int NOT NULL REFERENCES JUGADOR (COD_JUG) ON
		// DELETE CASCADE,CODJUGADORDESTINO int NOT NULL REFERENCES JUGADOR
		// (COD_JUG) ON DELETE CASCADE,CODPARTIDA int NOT NULL REFERENCES
		// PARTIDA(CODIGO) ON DELETE CASCADE,TIEMPO bigint NOT NULL,PRIMARY
		// KEY(CODJUGADORORIGEN,CODJUGADORDESTINO,CODPARTIDA,TIEMPO) )";

		String sql = "";

		try {

			sql = "DELETE FROM RECIBIRCARTAS WHERE CODJUGADORORIGEN>0";

			Statement statement = conexion.createStatement();

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha borrado correctamente:" + sql);

			statement.close();
			return true;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "Ha habido un error a la hora de borrar a: " + sql);
			e.printStackTrace();
			return false;
		}
	}

	public boolean borrarJugadores(Connection conexion) {
		// String creacion = "CREATE TABLE JUGADOR(COD_JUG int NOT NULL PRIMARY
		// KEY,
		// COD_PARTIDA int NOT NULL REFERENCES PARTIDA (CODIGO) ON DELETE
		// CASCADE,
		// NOMBRE_USUARIO text NOT NULL REFERENCES
		// USUARIO(NOMBREUSUARIO),POS_MUÑECO real,LUGAR INT,
		// TURNO int,MUÑECO text,DIBUJO bytea,ENLINEA boolean)";

		String sql = "";

		try {

			sql = "DELETE FROM JUGADOR WHERE COD_JUG>0";

			Statement statement = conexion.createStatement();

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha borrado correctamente:" + sql);

			statement.close();
			return true;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "Ha habido un error a la hora de borrar a: " + sql);
			e.printStackTrace();
			return false;
		}
	}

	public void modificarturno(Connection conexion, int jugCod, int turno) {

		String SQL = "";

		try {

			Statement statement = conexion.createStatement();

			SQL = "UPDATE JUGADOR SET TURNO=" + turno + " WHERE COD_JUG=" + jugCod;

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha modificado correctamente el turno" + SQL);

			statement.close();

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha modificado correctamente");
			e.printStackTrace();
		}

	}

	public int obtenerTurno(Connection conexion, Jugador j) {

		String SQL = "";

		int numero = -1;

		try {

			SQL = "SELECT TURNO FROM JUGADOR WHERE COD_JUG=" + j.getCodigo();

			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {

				numero = resultado.getInt(1);
			}

			// logger.log(Level.INFO, "Se ha obtenido correctamente el turno del
			// jugador: " + numero);
			return numero;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se ha conseguido obtener el turno correctamente");
			e.printStackTrace();

			return -1;

		}
	}

	public boolean borrarCartas(Connection conexion, Partida p, int codjugordestino) {

		String sql = "";

		try {

			sql = "DELETE FROM RECIBIRCARTAS WHERE CODPARTIDA=" + p.getCodigo() + "AND CODJUGADORDESTINO="
					+ codjugordestino;

			Statement statement = conexion.createStatement();

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha borrado correctamente:" + sql);

			statement.close();
			return true;

		} catch (Exception e) {

			logger.log(Level.SEVERE, "Ha habido un error a la hora de borrar a: " + sql);
			e.printStackTrace();
			return false;
		}
	}

	public BufferedImage obtenerDibujoNotas(Connection conexion, Jugador j) {

		BufferedImage imagen = null;

		try {

			Statement statement = conexion.createStatement();

			String sentSQL = "SELECT DIBUJO FROM JUGADOR WHERE COD_JUG=" + j.getCodigo();

			ResultSet rs = statement.executeQuery(sentSQL);

			while (rs.next()) {

				/**
				 * Blob blob = rs.getBlob("IMAGENPERFIL"); byte[] data =
				 * blob.getBytes(1, (int)blob.length()); img = ImageIO.read(new
				 * ByteArrayInputStream(data)); try { img = ImageIO.read(new
				 * ByteArrayInputStream(data)); } catch (IOException ex) {
				 * 
				 * }
				 */

				byte[] imgBytes = rs.getBytes(1);

				imagen = ImageIO.read(new ByteArrayInputStream(imgBytes));

			}
			rs.close();
			return imagen;

		} catch (Exception e) {
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			e.printStackTrace();
			return null;
		}

	}

	public void insertarDibujoNotas(Connection conexion, Jugador j, BufferedImage imagen) {

		String sql = "";

		try {

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(imagen, "jpeg", out);
			byte[] buf = out.toByteArray();
			ByteArrayInputStream inStream = new ByteArrayInputStream(buf);

			Statement statement = conexion.createStatement();

			PreparedStatement ps = conexion.prepareStatement("UPDATE JUGADOR SET DIBUJO=? WHERE COD_JUG=?");

			ps.setBinaryStream(1, inStream, inStream.available());
			ps.setInt(2, j.getCodigo());
			ps.executeUpdate();
			ps.close();

			logger.log(Level.INFO, "Se ha modificado correctamente la foto" + sql);

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se ha podido cambiar la foto " + sql);

			e.printStackTrace();
		}

	}

	// TABLA NOTAS

	public void insertarNota(Connection conexion, Notas nota, Jugador j) {

		String SQL = "";

		try {

			SQL = "INSERT INTO NOTAS VALUES ('" + nota.getMensaje() + "'," + j.getCodigo() + "," + nota.getLinea() + ","
					+ nota.getTabla() + ")";

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha añadido correctamente la nota");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se ha podido insertar la nota en la base de datos");

			e.printStackTrace();

		}
	}

	// public void borrarNotas (Connection conexion, Jugador j){
	//
	// String SQL = "";
	//
	// try{
	//
	// SQL = "DELETE FROM NOTAS WHERE COD_JUG="+j.getCodigo();
	//
	// Statement statement = conexion.createStatement();
	//
	// statement.executeUpdate(SQL);
	//
	// logger.log(Level.INFO, "Se ha borrado correctamente");
	//
	//
	// }catch (Exception e){
	// logger.log(Level.SEVERE, "No se ha podido borrar las notas");
	// }
	// }
	//
	// public ArrayList <Notas> obtenerNotas (Connection conexion, Jugador j){
	//
	// String SQL = "";
	// ArrayList <Notas> listaNotas = new ArrayList<>();
	//
	// try{
	//
	// SQL = "SELECT * FROM NOTAS WHERE COD_JUG="+j.getCodigo();
	//
	// Statement statement = conexion.createStatement();
	// ResultSet resultado = statement.executeQuery(SQL);
	//
	// while (resultado.next()){
	// Notas n = new Notas();
	//
	// n.setLinea(resultado.getInt("LINEA"));
	//
	// n.setMensaje(resultado.getString("MENSAJE"));
	//
	// n.setTabla(resultado.getInt("TABLA"));
	//
	// listaNotas.add(n);
	// }
	//
	// logger.log(Level.INFO, "Se han obtenido correctamente las notas");
	// return listaNotas;
	// }catch (Exception e){
	//
	//
	// logger.log(Level.SEVERE, "No ee ha conseguido obtener las notas");
	//
	// e.printStackTrace();
	//
	// return null;
	// }
	//
	//
	// }
	//
	// TABLA TICKS

	// public void insertarTICKS (Connection conexion, int linea,int tabla,
	// Jugador j){
	//
	// String SQL="";
	//
	// try{
	//
	// SQL ="INSERT INTO TICKS VALUES ("+tabla+","+linea+","+j.getCodigo()+")";
	//
	// Statement statement = conexion.createStatement();
	//
	// statement.executeUpdate(SQL);
	//
	// logger.log(Level.INFO, "Se ha añadido correctamente la nota");
	//
	//
	// }catch (Exception e){
	//
	// logger.log(Level.SEVERE,"No se ha podido insertar la nota en la base de
	// datos");
	//
	// e.printStackTrace();
	//
	//
	//
	// }
	// }

	// public void borrarTicks (Connection conexion, Jugador j){
	//
	// String SQL = "";
	//
	// try{
	//
	// SQL = "DELETE FROM TICKS WHERE COD_JUG="+j.getCodigo();
	//
	// Statement statement = conexion.createStatement();
	//
	// statement.executeUpdate(SQL);
	//
	// logger.log(Level.INFO, "Se ha borrado correctamente");
	//
	//
	// }catch (Exception e){
	// logger.log(Level.SEVERE, "No se ha podido borrar las notas");
	// }
	// }

	// public ArrayList <Integer[]> obtenerTicks (Connection conexion, Jugador
	// j){
	//
	// String SQL = "";
	// ArrayList <Integer []> listaTicks = new ArrayList<>();
	//
	// try{
	//
	// SQL = "SELECT * FROM TICKS WHERE COD_JUG="+j.getCodigo();
	//
	// Statement statement = conexion.createStatement();
	// ResultSet resultado = statement.executeQuery(SQL);
	//
	// while (resultado.next()){
	// Integer [] array = new Integer[2];
	//
	// array[0]=resultado.getInt("LINEA");
	//
	//
	// array[1]=resultado.getInt("TABLA");
	//
	// listaTicks.add(array);
	// }
	//
	// logger.log(Level.INFO, "Se han obtenido correctamente las notas");
	// return listaTicks;
	// }catch (Exception e){
	//
	//
	// logger.log(Level.SEVERE, "No ee ha conseguido obtener las notas");
	//
	// e.printStackTrace();
	//
	// return null;
	// }
	//
	//
	// }

	// =======
	//
	// statement.executeUpdate(SQL);
	//
	// logger.log(Level.INFO, "Se ha añadido correctamente la nota");
	// >>>>>>> branch 'master' of https://github.com/ander26/Proyecto-Cluedo.git
	//
	// <<<<<<< HEAD
	// =======
	// } catch (Exception e) {
	//
	// logger.log(Level.SEVERE, "No se ha podido insertar la nota en la base de
	// datos");
	//
	// e.printStackTrace();
	//
	// }
	// }

	public void borrarNotas(Connection conexion, Jugador j) {

		String SQL = "";

		try {

			SQL = "DELETE FROM NOTAS WHERE COD_JUG=" + j.getCodigo();

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha borrado correctamente");

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha podido borrar las notas");
		}
	}

	public ArrayList<Notas> obtenerNotas(Connection conexion, Jugador j) {

		String SQL = "";
		ArrayList<Notas> listaNotas = new ArrayList<>();

		try {

			SQL = "SELECT * FROM NOTAS WHERE COD_JUG=" + j.getCodigo();

			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {
				Notas n = new Notas();

				n.setLinea(resultado.getInt("LINEA"));

				n.setMensaje(resultado.getString("MENSAJE"));

				n.setTabla(resultado.getInt("TABLA"));

				listaNotas.add(n);
			}

			logger.log(Level.INFO, "Se han obtenido correctamente las notas");
			return listaNotas;
		} catch (Exception e) {

			logger.log(Level.SEVERE, "No ee ha conseguido obtener las notas");

			e.printStackTrace();

			return null;
		}

	}

	// TABLA TICKS

	public void insertarTICKS(Connection conexion, int linea, int tabla, Jugador j) {

		String SQL = "";

		try {

			SQL = "INSERT INTO TICKS VALUES (" + tabla + "," + linea + "," + j.getCodigo() + ")";

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha añadido correctamente la nota");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se ha podido insertar la nota en la base de datos");

			e.printStackTrace();

		}
	}

	public void borrarTicks(Connection conexion, Jugador j) {

		String SQL = "";

		try {

			SQL = "DELETE FROM TICKS WHERE COD_JUG=" + j.getCodigo();

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha borrado correctamente");

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha podido borrar las notas");
		}
	}

	public ArrayList<Integer[]> obtenerTicks(Connection conexion, Jugador j) {

		String SQL = "";
		ArrayList<Integer[]> listaTicks = new ArrayList<>();

		try {

			SQL = "SELECT * FROM TICKS WHERE COD_JUG=" + j.getCodigo();

			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {
				Integer[] array = new Integer[2];

				array[0] = resultado.getInt("LINEA");

				array[1] = resultado.getInt("TABLA");

				listaTicks.add(array);
			}

			logger.log(Level.INFO, "Se han obtenido correctamente las notas");
			return listaTicks;
		} catch (Exception e) {

			logger.log(Level.SEVERE, "No ee ha conseguido obtener las notas");

			e.printStackTrace();

			return null;
		}

	}

	public int posicionBarco(Connection conexion, Partida p) {

		String SQL = "";

		try {

			int numero = 0;

			double numeroD = 0;

			SQL = "SELECT POSICIONBARCO FROM PARTIDA WHERE CODIGO=" + p.getCodigo();

			Statement statement = conexion.createStatement();

			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {

				numeroD = resultado.getDouble("POSICIONBARCO");

			}
			numero = (int) numeroD;
			// logger.log(Level.INFO, "Se ha obtenido correctamente la posicion
			// del barco " + numero);

			return numero;

		} catch (Exception n) {

			logger.log(Level.SEVERE, "No se ha conseguido obtener la posicion del barco");

			n.printStackTrace();

			return 0;
		}

	}

	public boolean obtenerOrientacion(Connection conexion, Partida p) {

		String SQL = "";

		boolean orientacion = false;

		try {

			SQL = "SELECT ORIENTACION FROM PARTIDA WHERE CODIGO=" + p.getCodigo();

			Statement statement = conexion.createStatement();

			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {

				orientacion = resultado.getBoolean("ORIENTACION");

			}

			// logger.log(Level.INFO, "Se ha obtenido correctamente la
			// orientacion del barco " + orientacion);

			return orientacion;

		} catch (Exception n) {

			logger.log(Level.SEVERE, "No se ha conseguido obtener la posicion del barco");

			n.printStackTrace();

			return orientacion;
		}
	}

	public void modificarOrientacion(Connection conexion, Partida p, boolean orientacion) {

		String SQL = "";

		try {

			SQL = "UPDATE PARTIDA SET ORIENTACION=" + orientacion;

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			// logger.log(Level.INFO, "Se ha modificado correctamente la
			// orientacion");

		} catch (Exception q) {

			logger.log(Level.SEVERE, "No se ha podido modificar la orientacion");
		}

	}

	public boolean obtenerAccion(Connection conexion, Partida p) {

		String SQL = "";

		boolean accion = false;

		try {

			SQL = "SELECT ACCION FROM PARTIDA WHERE CODIGO=" + p.getCodigo();

			Statement statement = conexion.createStatement();

			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {

				accion = resultado.getBoolean("ACCION");

			}

			// logger.log(Level.INFO, "Se ha obtenido correctamente la
			// orientacion del barco " + accion);

			return accion;

		} catch (Exception n) {

			logger.log(Level.SEVERE, "No se ha conseguido obtener la posicion del barco");

			n.printStackTrace();

			return accion;
		}
	}

	public void modificarBarco(Connection conexion, Partida p, int posicion) {

		String SQL = "";

		try {

			SQL = "UPDATE PARTIDA SET POSICIONBARCO=" + posicion;

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);
			//
			// logger.log(Level.INFO, "Se ha modificado correctamente la
			// orientacion"+posicion);

		} catch (Exception q) {

			logger.log(Level.SEVERE, "No se ha podido modificar la orientacion");
		}

	}

	public void modificarAccion(Connection conexion, Partida p, boolean accion) {

		String SQL = "";

		try {

			SQL = "UPDATE PARTIDA SET ACCION=" + accion;

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			// logger.log(Level.INFO, "Se ha modificado correctamente la
			// orientacion");

		} catch (Exception q) {

			logger.log(Level.SEVERE, "No se ha podido modificar la orientacion");
		}

	}

	// Tabla sospechoso

	public String[] obtenerSospechosos(Connection conexion, int codigo) {

		String[] resolucion = new String[3];

		String SQL = "";
		try {

			SQL = "SELECT ASESINO,LUGAR,ARMA FROM SOSPECHOSO WHERE CODPARTIDA= " + codigo;

			Statement statement = conexion.createStatement();

			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {

				resolucion[2] = resultado.getString("ASESINO");
				resolucion[0] = resultado.getString("LUGAR");
				resolucion[1] = resultado.getString("ARMA");

			}

			logger.log(Level.INFO, "Se han obtendo correctamente los sospechosos");
			return resolucion;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha conseguido obtener a los sospechosos");
			e.printStackTrace();
			return null;
		}
	}

	// Para modificar la puntuacion del usuario

	public void modificarPuntuacion(Connection conexion, String nombreUsuario, int cantidad, String operacion) {

		String SQL = "";

		try {

			SQL = "UPDATE USUARIO SET PUNTUACION=PUNTUACION" + operacion + cantidad + " WHERE NOMBREUSUARIO='"
					+ nombreUsuario + "'";

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha modificado correctamente la puntuacion");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se ha modificado la puntuacion");
			e.printStackTrace();

		}

	}

	// Para el borrado final
	public void borradoFinal(Connection conexion, int codigo) {

		String SQL = "";

		try {

			SQL = " DELETE FROM PARTIDA WHERE CODIGO=" + codigo;

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			SQL = " DELETE FROM JUGADOR WHERE COD_PARTIDA=" + codigo;

			statement.executeUpdate(SQL);

			SQL = " DELETE FROM CHAT WHERE CODIGOPARTIDA=" + codigo;

			statement.executeUpdate(SQL);

			SQL = " DELETE FROM SOSPECHOSO WHERE CODPARTIDA=" + codigo;

			statement.executeUpdate(SQL);

			SQL = " DELETE FROM RECIBIRCARTAS WHERE CODPARTIDA=" + codigo;

			statement.executeUpdate(SQL);

			SQL = " DELETE FROM JUEGA WHERE CODPARTIDA=" + codigo;

			statement.executeUpdate(SQL);

			SQL = " DELETE FROM SOSPECHA WHERE CODPARTIDA=" + codigo;

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha realizado el borrado completo correctamente");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "No se ha conseguido realizar el borrado completo");

			e.printStackTrace();
		}

	}

	public void insertarGanador(Connection conexion, String usuario, int ganar, int partida) {

		String SQL = "";

		try {

			SQL = "INSERT INTO GANADOR VALUES (" + partida + ",'" + usuario + "'," + ganar + ")";

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha insertado correctamente al ganador");

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha podido modificar al ganador");
			e.printStackTrace();
		}

	}

	public void borrarGanador(Connection conexion, int partida) {

		String SQL = "";

		try {

			SQL = " DELETE FROM GANADOR WHERE CODPARTIDA=" + partida;
			Statement statement = conexion.createStatement();
			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha realizado el borrado completo correctamente");
			

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha podido modificar al ganador");
			e.printStackTrace();
		}

	}

	public void modificarGanador(Connection conexion, String usuario, int ganar, int partida) {

		String SQL = "";

		try {

			SQL = "UPDATE GANADOR SET USUARIO='" + usuario + "',GANAR=" + ganar + " WHERE CODPARTIDA=" + partida;

			Statement statement = conexion.createStatement();

			statement.executeUpdate(SQL);

			logger.log(Level.INFO, "Se ha insertado correctamente al ganador");

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha podido modificar al ganador");
			e.printStackTrace();
		}

	}

	public int obtenerGanador(Connection conexion, int partida) {

		String SQL = "";

		int seleccion = -1;

		try {

			SQL = "SELECT GANAR FROM GANADOR WHERE CODPARTIDA=" + partida;

			Statement statement = conexion.createStatement();

			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {
				seleccion = resultado.getInt("GANAR");
			}
			// logger.log(Level.INFO, "Se ha obtenido correctamente al
			// ganador");
			return seleccion;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha podido modificar al ganador");
			e.printStackTrace();
			return seleccion;
		}

	}

	public String obtenerUsuarioGanador(Connection conexion, int partida) {

		String SQL = "";

		String seleccion = "";

		try {

			SQL = "SELECT USUARIO FROM GANADOR WHERE CODPARTIDA=" + partida;

			Statement statement = conexion.createStatement();

			ResultSet resultado = statement.executeQuery(SQL);

			while (resultado.next()) {
				seleccion = resultado.getString("USUARIO");
			}
			logger.log(Level.INFO, "Se ha insertado correctamente al ganador");
			return seleccion;

		} catch (Exception e) {
			logger.log(Level.SEVERE, "No se ha podido modificar al ganador");
			e.printStackTrace();
			return seleccion;
		}

	}

}

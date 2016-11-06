package Proyecto.Cluedo.Logica;

import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import Proyecto.Cluedo.Datos.*;



public class GestionBaseDeDatos {

	private static Logger logger = Logger.getLogger(GestionBaseDeDatos.class.getName());
	
	/**
	 * Metodo que devuelve un statement para usar la base de datos
	 * @param con Parametro que contiene la conexion con la base 
	 * @return Devuelve un statement para usar con la base 
	 */
	
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			logger.log( Level.SEVERE, "Error en el establecimiento de la conexion con la base");
			return null;
		}
	}
	
	
	/**
	 * Metodo que sirve para inicializar la base de datos
	 * @param nombreBase Nombre de la base de datos
	 * @return Devuelve la conexion con la base de datos 
	 */
	
	public static Connection inicializarLaBase (String nombreBase){
		try{
			Class.forName("org.sqlite.JDBC");
			
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:"+nombreBase);
			logger.log(Level.INFO, "Inicializada la base de datos");
			return conexion;
			
		}catch (Exception e){
			logger.log(Level.SEVERE,"Error en la inicializacion de la base de datos");
			return null;
		}
	}
	
	public static Statement crearTabla (String creacion , Connection conexion){
		
		try{
			Statement statement = conexion.createStatement();
			statement.setQueryTimeout(30);
			try{
			statement.executeUpdate(creacion);
			}catch (SQLException h){
				logger.log(Level.WARNING, "La tabla ya esta creada");
				return null;
			}
			
			return statement;
		}catch (Exception e){
			logger.log(Level.SEVERE, "Error en la creacion de la tabla");
			return null;
		}
		
	}
	
	public static Statement crearTablaUsuario (Connection conexion){

		try{
			Statement statement = conexion.createStatement();
			statement.setQueryTimeout(30);
			try{
			statement.executeUpdate("create table usuario (nombre string,apellido string,nombreUsuario string not null primary key,email string,contraseña string,genero string,fechaNacimiento bigint,pregunta int,respuesta string, fechaUltimoLogin bigint)");
			}catch (SQLException h){
				logger.log(Level.WARNING, "La tabla ya esta creada");
				return null;
			}
			logger.log(Level.INFO,"Se ha creado una tabla" );
			return statement;
		}catch (Exception e){
			logger.log(Level.SEVERE, "Error en la creacion de la tabla");
			return null;
		}
	}
	
	
	public static boolean insertarUsuario( Statement st, Usuario u ) {
		String sentSQL ="";
		try {
			
			sentSQL="INSERT INTO usuario VALUES('"+u.getNombre()+"','"+u.getApellidos()+"','"+u.getUsuario()+"','"+u.getEmail()+"','"+u.getContraseña()+"','"+u.getGenero()+"',"+u.getFechaNacimeinto().getTime()+","+u.getPregunta()+",'"+u.getRespuesta()+"',"+u.getConexion().getTime()+")";
			int val = st.executeUpdate( sentSQL );
			
			
			if (val!=1) {  
				logger.log( Level.SEVERE, "Error al insertar la fila: "+sentSQL );
				return false;  
			}
			
			logger.log( Level.INFO, "Se ha añadido la fila : "+sentSQL);
			return true;
		} catch (Exception e) {
			logger.log( Level.SEVERE, "Error al insertar la fila: "+sentSQL);
			return false;
		}
	}
	
	public static void cerrarBD (Connection con, Statement st){
		try {
			if (st!=null){
				st.close();
				logger.log(Level.INFO, "Se ha cerrado el statement");
			}
			
			if (con!=null){
				con.close();
				logger.log(Level.INFO, "Se ha cerrado la conexion");
			}
		}catch (Exception e){
			logger.log(Level.SEVERE, "No se ha podido realizar la operacion de cierre");
		}
	}
	
	
	 
	public  ArrayList<Usuario> consultaATabla( Statement st, String seleccion ) {
		
		ArrayList<Usuario> ret = new ArrayList<>();
		
		try {
			
			String sentSQL = "select * from usuario";
			
			if (seleccion!=null && !seleccion.equals(""))
				
				sentSQL = sentSQL + " where " + seleccion;
			
			
			ResultSet rs = st.executeQuery( sentSQL );
			
			while (rs.next()) {
				Usuario u = new Usuario();
				
				u.setNombre( rs.getString( "nombre" ));
				u.setContraseña(rs.getString( "contraseña" ));
				u.setApellidos( rs.getString( "apellido" ));
				u.setUsuario( rs.getString( "nombreUsuario" ));
				u.setContraseña(rs.getString( "contraseña" ));
				u.setEmail( rs.getString( "email" ));
				u.setPregunta(rs.getInt("pregunta"));
				u.setRespuesta(rs.getString("respuesta"));
				if (rs.getString("genero").equals("HOMBRE")){
					u.setGenero(Genero.HOMBRE);
				}else{
					u.setGenero(Genero.MUJER);
				}
				u.setConexion(new Date(rs.getLong("fechaUltimoLogin")));
				u.setFechaNacimeinto(new Date (rs.getLong("fechaNacimiento")));
				
				ret.add( u );
			}
			rs.close();
			return ret;
		} catch (IllegalArgumentException e) {  
			logger.log(Level.WARNING, "No se entiende la expresion que se introduce");
			return null;
		} catch (SQLException e) {
			return null;
		}
	}
	
	
}

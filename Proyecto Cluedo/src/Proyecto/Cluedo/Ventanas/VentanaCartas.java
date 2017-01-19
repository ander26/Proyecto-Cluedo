package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Logica.Propiedades;

public class VentanaCartas extends JFrame {

	// private JTabbedPane ptabbed=new JTabbedPane();
	
	private JPanel pprincipal = new JPanel();
	private int r = 50;
	private panelrosa pventana;
	private JPanel pcentrar = new JPanel();
	private int poscartas = 0;
	private int numCartas;
	private static Logger logger = Logger.getLogger(VentanaCartas.class.getName());
	
	private JLabel noCartas;

	private ArrayList<CartasTorcidas> cartas = new ArrayList<CartasTorcidas>();

	// private panelrosa psospechosos;
	// private JPanel pdsospechosos=new JPanel();
	// private panelrosa parmas;
	// private JPanel pdarmas=new JPanel();
	// private panelrosa plugares;
	// private JPanel pdlugares=new JPanel();
	// private JPanel pcomodines=new JPanel();
	// private JLabel lenviar;
	//
	// public VentanaCartas(GestionBaseDeDatos base,Jugador j,Partida
	// p,Connection con){
	// setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	// setSize( 1330, 730 );
	//
	// setMinimumSize(new Dimension(900,500));
	// setResizable( true );
	// //Poner fondo a los paneles
	// ImageIcon imagearma = new
	// ImageIcon(ventana.class.getResource("Imagenes/claustro.jpg"));
	// parmas=new panelrosa(imagearma.getImage());
	// ImageIcon imagelugares = new
	// ImageIcon(ventana.class.getResource("Imagenes/violencia.png"));
	// plugares=new panelrosa(imagelugares.getImage());
	// ImageIcon imagesospechosos = new
	// ImageIcon(ventana.class.getResource("Imagenes/asesino.jpg"));
	// psospechosos=new panelrosa(imagesospechosos.getImage());
	// pcomodines=new JPanel();
	// //parmas
	//
	// JPanel pmesa=new JPanel();
	// JLabel lmesa=new JLabel();
	//
	// ImageIcon iconomesa = new
	// ImageIcon(ventana.class.getResource("Imagenes/mesa.png"));
	// lmesa.setSize(800,100);
	// Icon iconomesaa = new
	// ImageIcon(iconomesa.getImage().getScaledInstance(lmesa.getWidth() ,
	// lmesa.getHeight(), Image.SCALE_DEFAULT));
	// lmesa.setIcon(iconomesaa);
	// pmesa.add(lmesa);
	// pmesa.setOpaque(false);
	//
	//
	// //crear los iconos
	// ImageIcon iconoarma = new
	// ImageIcon(ventana.class.getResource("Imagenes/iconoarmas.png"));
	// ImageIcon iconolugares = new
	// ImageIcon(ventana.class.getResource("Imagenes/iconolugares.png"));
	// ImageIcon iconosospechosos = new
	// ImageIcon(ventana.class.getResource("Imagenes/iconosospechosos.png"));
	// ImageIcon iconocomodines = new
	// ImageIcon(ventana.class.getResource("Imagenes/iconocomodines.png"));
	//
	// //crear ptabbed
	// ptabbed.addTab("", iconoarma, parmas,"");
	// ptabbed.setMnemonicAt(0, KeyEvent.VK_1);
	// ptabbed.addTab("", iconolugares, plugares,"");
	// ptabbed.setMnemonicAt(1, KeyEvent.VK_2);
	// ptabbed.addTab("", iconosospechosos,psospechosos,"");
	// ptabbed.setMnemonicAt(2, KeyEvent.VK_3);
	// ptabbed.addTab("", iconocomodines, pcomodines,"");
	// ptabbed.setMnemonicAt(0, KeyEvent.VK_4);
	// //ptabbed.setTabPlacement(JTabbedPane.BOTTOM);
	// ptabbed.setBorder(null);
	// pprincipal.setLayout(new BorderLayout());
	// ImageIcon iconoenviar = new
	// ImageIcon(ventana.class.getResource("Imagenes/BOTONENVIAR.png"));
	// lenviar=new JLabel();
	// lenviar.setSize(170,113);
	// Icon icono = new
	// ImageIcon(iconoenviar.getImage().getScaledInstance(lenviar.getWidth() ,
	// lenviar.getHeight(), Image.SCALE_DEFAULT));
	// lenviar.setIcon(icono);
	// //Añadir layout a los paneles
	// parmas.setLayout(new BorderLayout());
	//
	// parmas.add(BorderLayout.SOUTH,pmesa);
	//
	// pdlugares.setLayout(new BorderLayout());
	// pdlugares.setOpaque(false);
	//
	// pcomodines.setLayout(new BorderLayout());
	// pdsospechosos.setLayout(new BorderLayout());
	// pdsospechosos.setOpaque(false);
	//
	// //Añadir los paneles a sus respectivos paneles
	// JLabel hueco=new JLabel();
	// JLabel hueco2=new JLabel();
	// JLabel hueco3=new JLabel();
	// hueco.setSize(new Dimension(300,200));
	// ImageIcon vacio = new
	// ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
	// Icon iconovacio = new
	// ImageIcon(vacio.getImage().getScaledInstance(hueco.getWidth() ,
	// hueco.getHeight(), Image.SCALE_DEFAULT));
	// hueco.setIcon(iconovacio);
	// hueco2.setIcon(iconovacio);
	// hueco3.setIcon(iconovacio);
	//
	//
	//
	//
	// plugares.setLayout(new BorderLayout());
	// plugares.add(pdlugares,BorderLayout.CENTER);
	// plugares.add(hueco2,BorderLayout.WEST);
	// //plugares.add(hueco,BorderLayout.WEST);
	//
	// psospechosos.setLayout(new BorderLayout());
	// psospechosos.add(pdsospechosos,BorderLayout.CENTER);
	// psospechosos.add(hueco3,BorderLayout.WEST);
	// //psospechosos.add(hueco,BorderLayout.WEST);
	//
	//
	//// Jugador a=new Jugador();
	//// Jugador b=new Jugador();
	//// Jugador [] arrjug=new Jugador [2];
	//// arrjug[0]=a;
	//// arrjug[1]=b;
	//// Propiedades prop =new Propiedades(6,8,7,2);
	//// prop.repartirCartas(arrjug);
	//// meterCartas(a,prop,0,pdarmas);
	//// meterCartas(a,prop,1,pdlugares);
	//// meterCartas(a,prop,2,pdsospechosos);
	//// meterCartas(a,prop,3,pcomodines);
	// meterCartas(j,p,0,parmas,base,con,0,hueco,hueco2);
	// meterCartas(j,p,1,pdlugares,base,con,1,hueco2,hueco);
	// meterCartas(j,p,2,pdsospechosos,base,con,2,hueco3,hueco);
	// //meterCartas(j,p,3,pcomodines,base,con,3);
	// pprincipal.add(BorderLayout.SOUTH,lenviar);
	// pprincipal.add(BorderLayout.CENTER,ptabbed);
	// getContentPane().add(pprincipal);
	//
	// }
	// public static void meterCartas(Jugador jugador,Partida p,int panel,JPanel
	// pan,GestionBaseDeDatos base,Connection con,int tipo,JLabel hueco,JLabel
	// hueco2){
	// ArrayList<String> cartasdepalo=base.obtenerCartasDeJugador(con,
	// p.getCodigo(), jugador.getCodigo(), tipo);
	// int k=0;
	// for(int i=0;i<cartasdepalo.size();i++){
	// System.out.println(cartasdepalo.get(i));
	// String
	// ruta=base.consultaATablaCartas(con,"NOMBRE="+"'"+cartasdepalo.get(i)+"'").get(0).getRutaIcono();
	//// for(int j=0;j<jugador.getMisCartas().get(panel).size();j++){
	//// String
	// ruta=p.getBaraja().get(panel).get(jugador.getMisCartas().get(panel).get(j)).getRutaIcono();
	// JLabel label=new JLabel();
	// System.out.println(ruta);
	// ImageIcon iconocarta = new ImageIcon(ventana.class.getResource(ruta));
	// label.setSize(227,283);
	// Icon icono = new
	// ImageIcon(iconocarta.getImage().getScaledInstance(label.getWidth() ,
	// label.getHeight(), Image.SCALE_DEFAULT));
	// label.setIcon(icono);
	// JPanel panelcentrado=new JPanel();
	// panelcentrado.add(label);
	// if(k==0){
	// pan.add(panelcentrado, BorderLayout.CENTER);
	// }else if(k==1){
	// panelcentrado.setBackground(Color.BLUE);
	// JPanel panelnoesquina=new JPanel();
	// panelnoesquina.setLayout(new BorderLayout());
	// panelnoesquina.add(hueco,BorderLayout.EAST);
	// panelnoesquina.add(panelcentrado,BorderLayout.CENTER);
	// pan.add(panelnoesquina, BorderLayout.EAST);
	//
	// }else if(k==2){
	// panelcentrado.setBackground(Color.BLUE);
	// JPanel panelnoesquina=new JPanel();
	// panelnoesquina.setLayout(new BorderLayout());
	// panelnoesquina.add(hueco2,BorderLayout.WEST);
	// panelnoesquina.add(panelcentrado,BorderLayout.CENTER);
	// pan.add(panelnoesquina, BorderLayout.WEST);
	// }
	//
	// k=k+1;
	//
	// }
	//
	//
	//
	// }
	// public static void main (String [] args){
	// VentanaCartas ventana = new VentanaCartas();
	// ventana.setVisible(true);
	// }
	
	public VentanaCartas(GestionBaseDeDatos base, Jugador j, Partida p, Connection con) {
	
		ImageIcon imageestrellas = new ImageIcon(ventana.class.getResource("Imagenes/mesa2.png"));
		
		pventana = new panelrosa(imageestrellas.getImage());
		
		// =======
		// private JTabbedPane ptabbed=new JTabbedPane();
		// private JPanel pprincipal=new JPanel();
		// private panelrosa psospechosos;
		// private JPanel pdsospechosos=new JPanel();
		// private panelrosa parmas;
		// private JPanel pdarmas=new JPanel();
		// private panelrosa plugares;
		// private JPanel pdlugares=new JPanel();
		// private JPanel pcomodines=new JPanel();
		// private JLabel lenviar;
		//
		// public VentanaCartas(GestionBaseDeDatos base,Jugador j,Partida
		// p,Connection con){
		// >>>>>>> branch 'master' of
		// https://github.com/ander26/Proyecto-Cluedo.git
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1330, 1030);
		setMinimumSize(new Dimension(900, 500));
		pprincipal.setLayout(null);
		pprincipal.setSize(r + 300, 2 * r + 50);
		meterCartas(base, con, p, j);
		pventana.setLayout(new BorderLayout());
		pventana.add(pprincipal, BorderLayout.CENTER);
		getContentPane().add(pventana);
		pprincipal.setOpaque(false);
		pprincipal.repaint();
		JPanel pbotonera = new JPanel();
//		pbotonera.setLayout(new BoxLayout(pbotonera, BoxLayout.X_AXIS));
		JLabel flechaderecha = new JLabel();
		flechaderecha.setSize(100, 100);
		JLabel flechaizquierda = new JLabel();
		flechaizquierda.setSize(100, 100);
		JLabel lsend = new JLabel();
		
		noCartas= new JLabel();
		
		noCartas.setSize(100,100);
		ImageIcon imagenNocarta = new ImageIcon(ventana.class.getResource("Imagenes/no cartas.png"));
		Icon iamgenNoCarta = new ImageIcon(imagenNocarta.getImage().getScaledInstance(noCartas.getWidth(),
				noCartas.getHeight(), Image.SCALE_DEFAULT));
		
		noCartas.setIcon(iamgenNoCarta);
		ImageIcon iiflechaderecha = new ImageIcon(ventana.class.getResource("Imagenes/flechaderecha.png"));
		Icon iflechaderecha = new ImageIcon(iiflechaderecha.getImage().getScaledInstance(flechaderecha.getWidth(),
				flechaizquierda.getHeight(), Image.SCALE_DEFAULT));
		ImageIcon iiflechaizquierda = new ImageIcon(ventana.class.getResource("Imagenes/flechaizquierda.png"));
		Icon iflechaizquierda = new ImageIcon(iiflechaizquierda.getImage().getScaledInstance(flechaizquierda.getWidth(),
				flechaizquierda.getHeight(), Image.SCALE_DEFAULT));
		flechaderecha.setIcon(iflechaderecha);

		flechaizquierda.setIcon(iflechaizquierda);
		//
		// setMinimumSize(new Dimension(900,500));
		// setResizable( true );
		// //Poner fondo a los paneles
		// ImageIcon imagearma = new
		// ImageIcon(ventana.class.getResource("Imagenes/claustro.jpg"));
		// parmas=new panelrosa(imagearma.getImage());
		// ImageIcon imagelugares = new
		// ImageIcon(ventana.class.getResource("Imagenes/violencia.png"));
		// plugares=new panelrosa(imagelugares.getImage());
		// ImageIcon imagesospechosos = new
		// ImageIcon(ventana.class.getResource("Imagenes/asesino.jpg"));
		// psospechosos=new panelrosa(imagesospechosos.getImage());
		// pcomodines=new JPanel();
		// //parmas
		//
		// JPanel pmesa=new JPanel();
		// JLabel lmesa=new JLabel();
		//
		// ImageIcon iconomesa = new
		// ImageIcon(ventana.class.getResource("Imagenes/mesa.png"));
		// lmesa.setSize(800,100);
		// Icon iconomesaa = new
		// ImageIcon(iconomesa.getImage().getScaledInstance(lmesa.getWidth() ,
		// lmesa.getHeight(), Image.SCALE_DEFAULT));
		// lmesa.setIcon(iconomesaa);
		// pmesa.add(lmesa);
		// pmesa.setOpaque(false);
		//
		// >>>>>>> branch 'master' of
		// https://github.com/ander26/Proyecto-Cluedo.git

		pbotonera.add(flechaizquierda);
		
		lsend.setSize(170, 100);
		ImageIcon iisend = new ImageIcon(ventana.class.getResource("Imagenes/boton send.png"));
		Icon isend = new ImageIcon(
				iisend.getImage().getScaledInstance(lsend.getWidth(), lsend.getHeight(), Image.SCALE_DEFAULT));
		lsend.setIcon(isend);
		pbotonera.add(lsend);
		
		pbotonera.add(flechaderecha);
		
		pbotonera.add(noCartas);
		JLabel lmano = new JLabel();
		
		lmano.setSize(300, 300);
		
		ImageIcon iimano = new ImageIcon(ventana.class.getResource("Imagenes/mano.png"));
		
		Icon imano = new ImageIcon(
				iimano.getImage().getScaledInstance(lmano.getWidth(), lmano.getHeight(), Image.SCALE_DEFAULT));
		
		lmano.setIcon(imano);
		
		getContentPane().add(pbotonera,BorderLayout.SOUTH);
		
		pventana.add(lmano, BorderLayout.EAST);
		
		pventana.add(pcentrar, BorderLayout.SOUTH);
		
		
		
		// escuchadores
		flechaizquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (poscartas > 0) {
					poscartas = poscartas - 1;
					cartas.get(poscartas).setOscuro(true);
					if (poscartas < numCartas - 1) {
						cartas.get(poscartas + 1).setOscuro(false);

					}
					pprincipal.repaint();

					// meterCartas(prop,1,pclugar,labell);

				} else {

				}
			}
		});
		flechaderecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (poscartas < numCartas - 1) {
					poscartas = poscartas + 1;
					cartas.get(poscartas).setOscuro(true);
					if (poscartas > 0) {
						cartas.get(poscartas - 1).setOscuro(false);

					}
					pprincipal.repaint();

				}

			}

		});
		lsend.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (poscartas >= 0 && poscartas < numCartas) {
					
					String [] lista = base.obtenerAcusacion(con, p.getCodigo());
					
						
						if(lista[0].equals(cartas.get(poscartas).getNombre())||lista[1].equals(cartas.get(poscartas).getNombre())||lista[2].equals(cartas.get(poscartas).getNombre())){
							
						}else{
							base.modificarTrampa(con, j.getUsuario(), p.getCodigo(), 1);
						}
						
					
					
					SubirAbaseCartaElegida(j, p, con, base);
					dispose();
				}

			}

		});
		
		noCartas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
					noSubirCarta(j, p, con, base);
					
					if(haceTrampa(base, con, p.getCodigo())){
						base.modificarTrampa(con, j.getUsuario(), p.getCodigo(), 1);
					}
					
					dispose();

			}

		});

	}
	
	public boolean haceTrampa (GestionBaseDeDatos base,Connection conexion,int codigo){
		
		String [] lista = base.obtenerAcusacion(conexion, codigo);
		for (CartasTorcidas ca: cartas){
			
			if(lista[0].equals(ca.getNombre())||lista[1].equals(ca.getNombre())||lista[2].equals(ca.getNombre())){
				return true;
			}
		}
		
		return false;
	}

	public void meterCartas(GestionBaseDeDatos base, Connection con, Partida p, Jugador jugador) {
		ArrayList<String> cartassitios = base.obtenerCartasDeJugador(con, p.getCodigo(), jugador.getCodigo(), 0);
		ArrayList<String> cartassospechosos = base.obtenerCartasDeJugador(con, p.getCodigo(), jugador.getCodigo(), 1);
		ArrayList<String> cartasarmas = base.obtenerCartasDeJugador(con, p.getCodigo(), jugador.getCodigo(), 2);
		ArrayList<String> cartascomodin = base.obtenerCartasDeJugador(con, p.getCodigo(), jugador.getCodigo(), 3);
		ArrayList<String> cartasdepalo = new ArrayList<String>();
		cartasdepalo.addAll(cartassitios);
		cartasdepalo.addAll(cartassospechosos);
		cartasdepalo.addAll(cartasarmas);
		cartasdepalo.addAll(cartascomodin);
		cartasdepalo.addAll(cartasdepalo);
		numCartas = cartassitios.size() + cartassospechosos.size() + cartasarmas.size() + cartascomodin.size();
		double alfa = Math.PI / numCartas;
		double beta = 0;
		//
		// //crear ptabbed
		// ptabbed.addTab("", iconoarma, parmas,"");
		// ptabbed.setMnemonicAt(0, KeyEvent.VK_1);
		// ptabbed.addTab("", iconolugares, plugares,"");
		// ptabbed.setMnemonicAt(1, KeyEvent.VK_2);
		// ptabbed.addTab("", iconosospechosos,psospechosos,"");
		// ptabbed.setMnemonicAt(2, KeyEvent.VK_3);
		// ptabbed.addTab("", iconocomodines, pcomodines,"");
		// ptabbed.setMnemonicAt(0, KeyEvent.VK_4);
		// //ptabbed.setTabPlacement(JTabbedPane.BOTTOM);
		// ptabbed.setBorder(null);
		// pprincipal.setLayout(new BorderLayout());
		// ImageIcon iconoenviar = new
		// ImageIcon(ventana.class.getResource("Imagenes/BOTONENVIAR.png"));
		// lenviar=new JLabel();
		// lenviar.setSize(170,113);
		// Icon icono = new
		// ImageIcon(iconoenviar.getImage().getScaledInstance(lenviar.getWidth()
		// , lenviar.getHeight(), Image.SCALE_DEFAULT));
		// lenviar.setIcon(icono);
		// //Añadir layout a los paneles
		// parmas.setLayout(new BorderLayout());
		//
		// parmas.add(BorderLayout.SOUTH,pmesa);
		//
		// pdlugares.setLayout(new BorderLayout());
		// pdlugares.setOpaque(false);
		// >>>>>>> branch 'master' of
		// https://github.com/ander26/Proyecto-Cluedo.git

		int PCcircunferencia = getWidth() / 2;
		for (int i = 0; i < numCartas; i++) {
			System.out.println(beta);
			double x = r * Math.cos(beta) + r + 100;
			double y = r - (r * Math.sin(beta)) + 50;
			double inclinacion = 90 - beta;
			String ruta = base.consultaATablaCartas(con, "NOMBRE=" + "'" + cartasdepalo.get(i) + "'").get(0)
					.getRutaIcono();
			CartasTorcidas c;
			System.out.println(x + " " + y);
			try {
				System.out.println(ruta);
				c = new CartasTorcidas(ruta, inclinacion, cartasdepalo.get(i));
				cartas.add(c);
				// c.setBounds((int)x, (int)y, 20, 20);
				pprincipal.add(c);
				pprincipal.repaint();

				c.setLocation((int) x, (int) y);

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// =======
				// pcomodines.setLayout(new BorderLayout());
				// pdsospechosos.setLayout(new BorderLayout());
				// pdsospechosos.setOpaque(false);
				//
				// //Añadir los paneles a sus respectivos paneles
				// JLabel hueco=new JLabel();
				// JLabel hueco2=new JLabel();
				// JLabel hueco3=new JLabel();
				// hueco.setSize(new Dimension(300,200));
				// ImageIcon vacio = new
				// ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
				// Icon iconovacio = new
				// ImageIcon(vacio.getImage().getScaledInstance(hueco.getWidth()
				// , hueco.getHeight(), Image.SCALE_DEFAULT));
				// hueco.setIcon(iconovacio);
				// hueco2.setIcon(iconovacio);
				// hueco3.setIcon(iconovacio);
				//
				//
				//
				//
				// plugares.setLayout(new BorderLayout());
				// plugares.add(pdlugares,BorderLayout.CENTER);
				// plugares.add(hueco2,BorderLayout.WEST);
				// //plugares.add(hueco,BorderLayout.WEST);
				//
				// psospechosos.setLayout(new BorderLayout());
				// psospechosos.add(pdsospechosos,BorderLayout.CENTER);
				// psospechosos.add(hueco3,BorderLayout.WEST);
				// //psospechosos.add(hueco,BorderLayout.WEST);
				//
				//
				//// Jugador a=new Jugador();
				//// Jugador b=new Jugador();
				//// Jugador [] arrjug=new Jugador [2];
				//// arrjug[0]=a;
				//// arrjug[1]=b;
				//// Propiedades prop =new Propiedades(6,8,7,2);
				//// prop.repartirCartas(arrjug);
				//// meterCartas(a,prop,0,pdarmas);
				//// meterCartas(a,prop,1,pdlugares);
				//// meterCartas(a,prop,2,pdsospechosos);
				//// meterCartas(a,prop,3,pcomodines);
				// meterCartas(j,p,0,parmas,base,con,0,hueco,hueco2);
				// meterCartas(j,p,1,pdlugares,base,con,1,hueco2,hueco);
				// meterCartas(j,p,2,pdsospechosos,base,con,2,hueco3,hueco);
				// //meterCartas(j,p,3,pcomodines,base,con,3);
				// pprincipal.add(BorderLayout.SOUTH,lenviar);
				// pprincipal.add(BorderLayout.CENTER,ptabbed);
				// getContentPane().add(pprincipal);
				//
				// >>>>>>> branch 'master' of
				// https://github.com/ander26/Proyecto-Cluedo.git
			}

			beta = beta + alfa;
		}
	}

	public void SubirAbaseCartaElegida(Jugador j, Partida p, Connection conexion, GestionBaseDeDatos base) {
		// String crearecibircartas = "CREATE TABLE RECIBIRCARTAS(NOMBRECARTA
		// text ,CODJUGADORORIGEN int NOT NULL REFERENCES JUGADOR (COD_JUG) ON
		// DELETE CASCADE,CODJUGADORDESTINO int NOT NULL REFERENCES JUGADOR
		// (COD_JUG) ON DELETE CASCADE,CODPARTIDA int NOT NULL REFERENCES
		// PARTIDA(CODIGO) ON DELETE CASCADE,TIEMPO bigint NOT NULL,PRIMARY
		// KEY(CODJUGADORORIGEN,CODJUGADORDESTINO,CODPARTIDA,TIEMPO) )";
		//

		try {
			int codigo = base.ObtenerCodigoJugadorTurno(conexion, p);
			Statement statement = conexion.createStatement();
			String sql = "INSERT INTO RECIBIRCARTAS VALUES ('" + cartas.get(poscartas).getNombre() + "',"
					+ j.getCodigo() + "," + codigo + "," + p.getCodigo() + "," + System.currentTimeMillis() + ")";

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha añadido la carta en recibircartas: " + sql);

			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void noSubirCarta(Jugador j, Partida p, Connection conexion, GestionBaseDeDatos base) {
		// String crearecibircartas = "CREATE TABLE RECIBIRCARTAS(NOMBRECARTA
		// text ,CODJUGADORORIGEN int NOT NULL REFERENCES JUGADOR (COD_JUG) ON
		// DELETE CASCADE,CODJUGADORDESTINO int NOT NULL REFERENCES JUGADOR
		// (COD_JUG) ON DELETE CASCADE,CODPARTIDA int NOT NULL REFERENCES
		// PARTIDA(CODIGO) ON DELETE CASCADE,TIEMPO bigint NOT NULL,PRIMARY
		// KEY(CODJUGADORORIGEN,CODJUGADORDESTINO,CODPARTIDA,TIEMPO) )";
		//

		try {
			int codigo = base.ObtenerCodigoJugadorTurno(conexion, p);
			Statement statement = conexion.createStatement();
			String sql = "INSERT INTO RECIBIRCARTAS VALUES ('no carta',"
					+ j.getCodigo() + "," + codigo + "," + p.getCodigo() + "," + System.currentTimeMillis() + ")";

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha añadido la carta en recibircartas: " + sql);

			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// =======
	// public static void meterCartas(Jugador jugador,Partida p,int panel,JPanel
	// pan,GestionBaseDeDatos base,Connection con,int tipo,JLabel hueco,JLabel
	// hueco2){
	// ArrayList<String> cartasdepalo=base.obtenerCartasDeJugador(con,
	// p.getCodigo(), jugador.getCodigo(), tipo);
	// int k=0;
	// for(int i=0;i<cartasdepalo.size();i++){
	// System.out.println(cartasdepalo.get(i));
	// String
	// ruta=base.consultaATablaCartas(con,"NOMBRE="+"'"+cartasdepalo.get(i)+"'").get(0).getRutaIcono();
	//// for(int j=0;j<jugador.getMisCartas().get(panel).size();j++){
	//// String
	// ruta=p.getBaraja().get(panel).get(jugador.getMisCartas().get(panel).get(j)).getRutaIcono();
	// JLabel label=new JLabel();
	// System.out.println(ruta);
	// ImageIcon iconocarta = new ImageIcon(ventana.class.getResource(ruta));
	// label.setSize(227,283);
	// Icon icono = new
	// ImageIcon(iconocarta.getImage().getScaledInstance(label.getWidth() ,
	// label.getHeight(), Image.SCALE_DEFAULT));
	// label.setIcon(icono);
	// JPanel panelcentrado=new JPanel();
	// panelcentrado.add(label);
	// if(k==0){
	// pan.add(panelcentrado, BorderLayout.CENTER);
	// }else if(k==1){
	// panelcentrado.setBackground(Color.BLUE);
	// JPanel panelnoesquina=new JPanel();
	// panelnoesquina.setLayout(new BorderLayout());
	// panelnoesquina.add(hueco,BorderLayout.EAST);
	// panelnoesquina.add(panelcentrado,BorderLayout.CENTER);
	// pan.add(panelnoesquina, BorderLayout.EAST);
	//
	// }else if(k==2){
	// panelcentrado.setBackground(Color.BLUE);
	// JPanel panelnoesquina=new JPanel();
	// panelnoesquina.setLayout(new BorderLayout());
	// panelnoesquina.add(hueco2,BorderLayout.WEST);
	// panelnoesquina.add(panelcentrado,BorderLayout.CENTER);
	// pan.add(panelnoesquina, BorderLayout.WEST);
	// }
	//
	// k=k+1;
	//
	// }
	//
	//
	//
	// }
	//
	// >>>>>>> branch 'master' of https://github.com/ander26/Proyecto-Cluedo.git
}

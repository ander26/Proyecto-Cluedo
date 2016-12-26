package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.ImageCapabilities;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Hilo.HiloTurno;
import Proyecto.Cluedo.Hilo.hiloPìntado;
import Proyecto.Cluedo.Logica.Animacion;
import Proyecto.Cluedo.Logica.FicheroCoordenadasPosiciones;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Logica.Propiedades;
import Proyecto.Cluedo.Logica.busquedaposicion;

public class VentanaTablero extends JFrame {
	private JLabel Label1 = new JLabel();
	private JLabel Label2 = new JLabel();
	private JLabel Label3 = new JLabel();
	private JLabel Label4 = new JLabel();
	private JLabel Label5 = new JLabel();
	private JLabel[] arrfichas = new JLabel[5];
	private ArrayList<Point> fichasrojas;

	private HiloTurno hTurno = null;

	private boolean mostradoI = true;

	private boolean mostradoD = true;

	private Icon icono;

	private ImageIcon imagen = new ImageIcon();

	private ArrayList<Point> arpunto = new ArrayList<Point>();
	private Panelcirculos pposiciones = new Panelcirculos();

	private static final int ANCHURA = 1920;

	private static final int ALTURA = 1040;


	private int barcoX = -20000;
	private ArrayList<Jugador> arrjugadores;

	private static final int ALTURAM = 1020;

	

	// private static int[][] mibaraja=new int[3][4];

	// public static void main(String[] args) {
	//
	// VentanaTablero ventana = new VentanaTablero();
	//
	// ventana.setVisible(true);
	//
	// }

	public VentanaTablero(Connection conexion, Jugador j, Usuario u, GestionBaseDeDatos base, Partida p,
			Propiedades prop) {

		arrfichas[0]=Label1;
		arrfichas[1]=Label2;
		arrfichas[2]=Label3;
		arrfichas[3]=Label4;
		arrfichas[4]=Label5;
		arrjugadores=base.ObtenerJugadoresDePartidaordenadosPorCodigo(p, conexion);
//		meterFicha(arrjugadores);
//		colocarFichaInicio(arrjugadores);
		


		// Establecemos el formato

		this.setExtendedState(MAXIMIZED_BOTH);

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

		Dimension screenDimension = env.getMaximumWindowBounds().getSize();

		Insets insets = getInsets();

		final int left = insets.left;

		final int right = insets.right;

		final int top = insets.top;

		final int bottom = insets.bottom;

		final int anchura = screenDimension.width - left - right;

		final int altura = screenDimension.height - top - bottom;
		
		System.out.println("altura"+altura);


		System.out.println("anchura"+anchura);

		// System.out.println("BOTOOM : "+bottom);

		

		meterFicha(arrjugadores, anchura, altura);
		colocarFichaInicio(arrjugadores, anchura, altura);

		// System.out.println(altura);
		//
		// System.out.println(anchura);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 700);

		setResizable(true);

		// Generamos los compoenentes

		JLabel semaforo;

		JLabel flechaD = new JLabel();

		JLabel flechaI = new JLabel();

		JLabel labelDado = new JLabel();

		JLabel labelAcusar = new JLabel();

		LabelPerfil usuario;

		JLabel labelNotas = new JLabel();

		JLabel labelChat = new JLabel();

		JLabel labelCartas = new JLabel();

		JLabel labelDenunciar = new JLabel();

		JLabel jugador1 = new JLabel();

		JPanel panelSemaforo = new JPanel();
		
		jugador1.setSize(reajustarTamañoAnch(50, anchura), reajustarTamañoAltMaider(60, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/barco.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(jugador1.getWidth(), jugador1.getHeight(), Image.SCALE_DEFAULT));
		
		

		jugador1.setIcon(icono);

		
		labelDado.setBounds(reajustarAnchura(100, anchura), reajustarAltura(130, altura),
				reajustarTamañoAnch(80, anchura), reajustarTamañoAlt(80, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/dado.gif").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(labelDado.getWidth(), labelDado.getHeight(), Image.SCALE_DEFAULT));

		labelDado.setIcon(icono);

		labelAcusar.setBounds(reajustarAnchura(100, anchura), reajustarAltura(235, altura),
				reajustarTamañoAnch(80, anchura), reajustarTamañoAlt(80, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/pusharriba.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(), labelAcusar.getHeight(),
				Image.SCALE_DEFAULT));

		labelAcusar.setIcon(icono);

		labelDenunciar.setBounds(reajustarAnchura(105, anchura), reajustarAltura(345, altura),
				reajustarTamañoAnch(70, anchura), reajustarTamañoAlt(70, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/denuncia.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDenunciar.getWidth(), labelDenunciar.getHeight(),
				Image.SCALE_DEFAULT));

		labelDenunciar.setIcon(icono);

		usuario = new LabelPerfil(u.getImagenPerfil(), reajustarAnchura(130, anchura), reajustarAltura(80, altura),
				reajustarTamañoAnch(80, anchura), reajustarTamañoAlt(80, altura));

		labelNotas.setBounds(reajustarAnchura(260, anchura), reajustarAltura(80, altura),
				reajustarTamañoAnch(80, anchura), reajustarTamañoAlt(80, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/notes-1.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(labelNotas.getWidth(), labelNotas.getHeight(),
				Image.SCALE_DEFAULT));

		labelNotas.setIcon(icono);

		labelChat.setBounds(reajustarAnchura(390, anchura), reajustarAltura(80, altura),
				reajustarTamañoAnch(80, anchura), reajustarTamañoAlt(80, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/messages-icon.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(labelChat.getWidth(), labelChat.getHeight(), Image.SCALE_DEFAULT));

		labelChat.setIcon(icono);

		labelCartas.setBounds(reajustarAnchura(520, anchura), reajustarAltura(80, altura),
				reajustarTamañoAnch(100, anchura), reajustarTamañoAlt(80, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/cards.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(labelCartas.getWidth(), labelCartas.getHeight(),
				Image.SCALE_DEFAULT));

		labelCartas.setIcon(icono);

		flechaI.setBounds(reajustarAnchura(200, anchura), reajustarAltura(550 / 2 - 25, altura),
				reajustarTamañoAnch(50, anchura), reajustarTamañoAlt(50, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/transparente.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(flechaI.getWidth(), flechaI.getHeight(), Image.SCALE_DEFAULT));

		flechaI.setIcon(icono);

		flechaD.setBounds(reajustarAnchura(340, anchura), reajustarAltura(10, altura), reajustarTamañoAnch(55, anchura),
				reajustarTamañoAlt(55, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/transparente.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(flechaD.getWidth(), flechaD.getHeight(), Image.SCALE_DEFAULT));

		flechaD.setIcon(icono);

		try {

			imagen = new ImageIcon(
					VentanaTablero.class.getResource("Imagenes/definitivosinlugaresysinpuntos.jpg").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		panelrosa fondo = new panelrosa(imagen.getImage());

		semaforo = new JLabel();

		panelSemaforo.setBounds(reajustarAnchura((int) 1920 / 2 - 90, anchura), reajustarAltura(60, altura),
				reajustarTamañoAnch(220, anchura), reajustarTamañoAlt(90, altura));

		panelSemaforo.setOpaque(false);

		semaforo.setBounds(0, 0, reajustarTamañoAnch(220, anchura), reajustarTamañoAlt(90, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/semafororojot.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(semaforo.getWidth(), semaforo.getHeight(), Image.SCALE_DEFAULT));

		semaforo.setIcon(icono);

		JLabel cuadradoI = new JLabel();

		JPanel panelI = new JPanel();

		panelI.setBounds(reajustarAnchura(-90, anchura), reajustarAltura(1040 / 2 - 270, altura),
				reajustarTamañoAnch(250, anchura), reajustarTamañoAlt(550, altura));

		panelI.setOpaque(false);

		cuadradoI.setBounds(0, 0, reajustarTamañoAnch(250, anchura), reajustarTamañoAlt(550, altura));
		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/cuadrado.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(cuadradoI.getWidth(), cuadradoI.getHeight(), Image.SCALE_DEFAULT));

		cuadradoI.setIcon(icono);

		JPanel panelD = new JPanel();

		panelD.setBounds(reajustarAnchura(1920 / 2 - 320, anchura), reajustarAltura(1040 - 200, altura),
				reajustarTamañoAnch(750, anchura), reajustarTamañoAlt(300, altura));

		panelD.setOpaque(false);

		JLabel cuadradoD = new JLabel();

		cuadradoD.setBounds(0, 0, reajustarTamañoAnch(750, anchura), reajustarTamañoAlt(300, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/cuadradoGirado.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(cuadradoD.getWidth(), cuadradoD.getHeight(), Image.SCALE_DEFAULT));

		cuadradoD.setIcon(icono);

		JLabel trainera = new JLabel();

		int posicion = base.posicionBarco(conexion, p);
		
		trainera.setSize(reajustarTamañoAnch(250, anchura),reajustarTamañoAlt(95, altura));

		if (posicion == -2000) {
			base.modificarBarco(conexion, p, 1920);
			trainera.setLocation(anchura, reajustarAltura(510, altura));
		} else {
			if (base.obtenerAccion(conexion, p)) {

			} else {
				trainera.setLocation(reajustarAnchura(posicion, anchura), reajustarAltura(510, altura));
			}
		}

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/traineradeusto.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(trainera.getWidth(), trainera.getHeight(), Image.SCALE_DEFAULT));

		trainera.setIcon(icono);

		JLabel puentedeusto = new JLabel();

		puentedeusto.setBounds(reajustarAnchura(15, anchura), reajustarAltura(460, altura),
				reajustarTamañoAnch(250, anchura), reajustarTamañoAlt(200, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/puentedeusto.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(puentedeusto.getWidth(), puentedeusto.getHeight(),
				Image.SCALE_DEFAULT));

		puentedeusto.setIcon(icono);

		JLabel puentecrai = new JLabel();

		puentecrai.setBounds(reajustarAnchura(1198, anchura), reajustarAltura(455, altura),
				reajustarTamañoAnch(246, anchura), reajustarTamañoAlt(250, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/puentecrai.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(puentecrai.getWidth(), puentecrai.getHeight(),
				Image.SCALE_DEFAULT));

		puentecrai.setIcon(icono);

		LabelLugares campo = new LabelLugares("Imagenes/campofutbol.png", "campo", reajustarAnchura(23, anchura),
				reajustarAltura(23, altura), reajustarTamañoAnch(263, anchura), reajustarTamañoAlt(267, altura));
		LabelLugares ade = new LabelLugares("Imagenes/ade.png", "ade", reajustarAnchura(334, anchura),
				reajustarAltura(15, altura), reajustarTamañoAnch(276, anchura), reajustarTamañoAlt(188, altura));
		LabelLugares l = new LabelLugares("Imagenes/la l.png", "l", reajustarAnchura(729, anchura),
				reajustarAltura(65, altura), reajustarTamañoAnch(162, anchura), reajustarTamañoAlt(185, altura));
		LabelLugares centenario = new LabelLugares("Imagenes/centenario.png", "centenario",
				reajustarAnchura(1106, anchura), 0, reajustarTamañoAnch(500, anchura), reajustarTamañoAlt(356, altura));
		LabelLugares deLetras = new LabelLugares("Imagenes/de letras.png", "letras", reajustarAnchura(1562, anchura),
				reajustarAltura(3, altura), reajustarTamañoAnch(350, anchura), reajustarTamañoAlt(253, altura));
		LabelLugares capilla = new LabelLugares("Imagenes/capilla.png", "capilla", reajustarAnchura(1676, anchura),
				reajustarAltura(237, altura), reajustarTamañoAnch(177, anchura), reajustarTamañoAlt(160, altura));
		LabelLugares crai = new LabelLugares("Imagenes/crai.png", "crai", reajustarAnchura(1380, anchura),
				reajustarAltura(640, altura), reajustarTamañoAnch(260, anchura), reajustarTamañoAlt(250, altura));
		LabelLugares zubi = new LabelLugares("Imagenes/zubi.png", "zubi", reajustarAnchura(398, anchura),
				reajustarAltura(660, altura), reajustarTamañoAnch(494, anchura), reajustarTamañoAlt(265, altura));

		campo.setToolTipText("Campo de futbol");
		ade.setToolTipText("Edificio Business School");
		l.setToolTipText("La L");
		centenario.setToolTipText("Edificio Centenario");
		deLetras.setToolTipText("Edificio de letras");
		capilla.setToolTipText("La capilla");
		crai.setToolTipText("CRAI");
		zubi.setToolTipText("Zubiarte");

		JLabel rio = new JLabel();

		rio.setBounds(reajustarAnchura(1475, anchura), reajustarAltura(482, altura), reajustarTamañoAnch(250, anchura),
				reajustarTamañoAlt(118, altura));

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/rioAzul.png").toURI().toURL());
		} catch (Exception q) {

		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(rio.getWidth(), rio.getHeight(), Image.SCALE_DEFAULT));

		rio.setIcon(icono);

		JLabel traineraUPV = new JLabel();
		
		traineraUPV.setSize(reajustarTamañoAnch(250, anchura),reajustarTamañoAlt(95, altura));

		if (posicion == -2000) {
			traineraUPV.setLocation(anchura+(2*trainera.getWidth()), reajustarAltura(510, altura));
		} else {
			if (base.obtenerAccion(conexion, p)) {

			} else {
				traineraUPV.setLocation((reajustarAnchura(posicion,anchura)+(2*trainera.getWidth())), reajustarAltura(510, altura));
			}
		}
		
	

		try {

			imagen = new ImageIcon(
					VentanaTablero.class.getResource("Imagenes/traineraUPVInvertida.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(), traineraUPV.getHeight(),
				Image.SCALE_DEFAULT));

		traineraUPV.setIcon(icono);
		
		



		// Establecemos el formato
		//
		// 101.0/454.0
		// 129.0/491.0
		// 160.0/522.0
		// 174.0/554.0
		// 191.0/592.0
		// 1266.0/635.0
		// 1282.0/610.0
		// 1305.0/582.0
		// 1317.0/550.0
		// 1331.0/516.0
		// 1343.0/485.0
		// 1358.0/458.0
		// 1371.0/433.0
		// 1391.0/397.0

		fondo.setLayout(new BorderLayout());
		pposiciones.setLayout(null);
		pposiciones.add(panelI);
		pposiciones.add(panelD);
		pposiciones.add(panelSemaforo);
		panelSemaforo.add(semaforo);
		pposiciones.add(campo);
		pposiciones.add(ade);
		pposiciones.add(l);
		pposiciones.add(centenario);
		pposiciones.add(deLetras);
		pposiciones.add(capilla);
		pposiciones.add(crai);
		pposiciones.add(zubi);

		panelI.setLayout(null);
		panelD.setLayout(null);

		panelI.add(flechaI);

		panelI.add(labelDado);

		panelI.add(labelAcusar);

		panelI.add(labelDenunciar);

		panelI.add(cuadradoI);

		panelD.add(flechaD);

		panelD.add(usuario);

		panelD.add(labelChat);

		panelD.add(labelNotas);

		panelD.add(labelCartas);

		panelD.add(cuadradoD);

		pposiciones.add(jugador1);

		pposiciones.add(puentedeusto);
		pposiciones.add(puentecrai);
		pposiciones.add(trainera);
		pposiciones.add(traineraUPV);
		pposiciones.add(rio);
		pposiciones.add(Label1);
		pposiciones.add(Label2);
		pposiciones.add(Label3);
		pposiciones.add(Label4);
		pposiciones.add(Label5);
		fondo.add(pposiciones);
		getContentPane().setLayout(new BorderLayout());

		getContentPane().add(fondo, BorderLayout.CENTER);

		System.out.println("llego aqui");

		hTurno = new HiloTurno();
		hTurno.setBase(base);
		hTurno.setJugador(j);
		hTurno.setPartida(p);
		hTurno.setCon(conexion);

		hTurno.start();

		pposiciones.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println(reajustarAnchura(e.getX(), anchura));
				System.out.println(reajustarImagen(e.getY(), altura));
				// Point punto=new Point(e.getX(),e.getY());
				// System.out.println(punto.getX()+" "+punto.getY());
				// if(punto.getX()==0){
				//// FicheroCoordenadasPosiciones fcoor=new
				// FicheroCoordenadasPosiciones();
				//// fcoor.escribirAFicheroConBarras("cordeenadascirculos.txt",
				// arpunto);
				// }
				// else{
				// if(punto!=null){
				// arpunto.add(punto);
				// System.out.println(punto);
				// }
				// }

				System.out.println("entro en el mouse clicked");
				if(hTurno.getCodigoJugadorConTurno()==j.getCodigo()){
					System.out.println("entro en el if del pposiciones mouse click");
					Point puntoSeleccionado=BuscarPuntoPinchado(e.getX(),e.getY(),anchura,altura);
					if(estaEn(puntoSeleccionado,fichasrojas)){
						pposiciones.volverAColorOriginal(fichasrojas);
						pposiciones.meterOcupado(puntoSeleccionado);
						pposiciones.repaint();
					}
					fichasrojas=new ArrayList<Point>();
					base.modificarCoordenada(conexion, j,((int)puntoSeleccionado.getX()),((int)puntoSeleccionado.getY()));
					ObtenerFichaDeJugador(arrjugadores, j).setLocation(reajustarAnchuraFicha((int)puntoSeleccionado.getX()-28, anchura),reajustarAlturaFicha((int)puntoSeleccionado.getY()-32,pposiciones.getHeight()));
				
					hTurno.CambiarTurno();
					
					}
					
					
					}

				// if(hTurno.getCodigoJugadorConTurno()==j.getCodigo()){
				// Point
				// puntoSeleccionado=BuscarPuntoPinchado(e.getX(),e.getY(),anchura,altura);
				// if(estaEn(puntoSeleccionado,fichasrojas)){
				// pposiciones.meterOcupado(puntoSeleccionado);
				// pposiciones.repaint();
				// }
				// fichasrojas=new ArrayList<Point>();
				// base.modificarCoordenada(conexion,
				// j,(int)(puntoSeleccionado.getY()),((int)puntoSeleccionado.getX()));
				// ObtenerFichaDeJugador(arrjugadores,
				// j).setLocation((int)(puntoSeleccionado.getX()-28),(int)(puntoSeleccionado.getY()-16));
				//
				// hTurno.CambiarTurno();
				//
				// }
				//
				//
				// }
			

		});

		flechaI.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(1);

				Dimension size = new Dimension(reajustarTamañoAnch(250, anchura), reajustarTamañoAlt(550, altura));

				Rectangle from = new Rectangle(reajustarAnchura(-90, anchura),
						reajustarAltura((1040 / 2) - 270, altura), size.width, size.height);
				Rectangle to = new Rectangle(reajustarAnchura(-200, anchura), reajustarAltura((1040 / 2) - 270, altura),
						size.width, size.height);
				if (mostradoI) {
					Animacion animate = new Animacion(panelI, from, to);
					animate.start();
					mostradoI = false;
				} else {
					Animacion animate = new Animacion(panelI, to, from);
					animate.start();
					mostradoI = true;
				}
			}
		});

		flechaD.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(1);

				Dimension size = new Dimension(reajustarTamañoAnch(750, anchura), reajustarTamañoAlt(300, altura));

				Rectangle from = new Rectangle(reajustarAnchura((1920 / 2) - 320, anchura),
						reajustarAltura(1040 - 200, altura), size.width, size.height);
				Rectangle to = new Rectangle(reajustarAnchura((1920 / 2) - 320, anchura),
						reajustarAltura(1040 - 80, altura), size.width, size.height);
				if (mostradoD) {
					Animacion animate = new Animacion(panelD, from, to);
					animate.start();
					mostradoD = false;
				} else {
					Animacion animate = new Animacion(panelD, to, from);
					animate.start();
					mostradoD = true;
				}

			}
		});

		// addComponentListener(new ComponentAdapter() {
		// @Override
		// public void componentResized(ComponentEvent e) {
		//
		// double escalaX = getContentPane().getWidth() / (double) anchura; //
		// Nueva
		// // escala
		// // X
		// double escalaY = getContentPane().getHeight() / (double) altura; //
		// Nueva
		// // escala
		// // Y
		//
		// semaforo.setBounds((int) (((int) anchura / 2 - 90) * escalaX), (int)
		// (60 * escalaY),
		//// (int) (220 * escalaX), (int) (90 * escalaY));
		////
		//// try {
		////
		//// imagen = new ImageIcon(
		//// VentanaTablero.class.getResource("Imagenes/semafororojot.png").toURI().toURL());
		//// } catch (Exception o) {
		////
		//// System.out.println("No se ha encontrado el archivo");
		//// }
		////
		//// icono = new
		// ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(),
		// semaforo.getHeight(),
		//// Image.SCALE_DEFAULT));
		////
		//// semaforo.setIcon(icono);
		////
		////
		//// fondo.repaint();
		// }

		// });

		labelAcusar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (hTurno.isPulsado()) {

					// meterImgEnlabel("Imagenes/pushbajo.png", labelAcusar,
					// 100, 100);
					Jugador a = new Jugador();
					a.setLugar(2);
					// mete el fondo del lugar en el que este
					String[] aimglug = new String[8];
					aimglug[0] = "Imagenes/ingenieria.jpg";
					aimglug[1] = "Imagenes/comercial.jpg";
					aimglug[2] = "Imagenes/capilla.JPG";
					aimglug[3] = "Imagenes/centenario.jpg";
					aimglug[4] = "Imagenes/letras.jpg";
					aimglug[5] = "Imagenes/biblioteca.jpeg";
					aimglug[6] = "Imagenes/zubiarte.jpg";
					aimglug[7] = "Imagenes/zubiarte.jpg";

					VentanaAcusar f = new VentanaAcusar(base, conexion, j, p, hTurno);
					f.setVisible(true);
				}

			}

			// public void mouseEntered(MouseEvent e) {
			// meterImgEnlabel("Imagenes/pushbajo.png", labelAcusar, 100, 100);
			// }
			//
			// public void mouseExited(MouseEvent e) {
			// meterImgEnlabel("Imagenes/pusharriba.png", labelAcusar, 100,
			// 100);
			// }

		});
		labelCartas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				VentanaCartas ventana = new VentanaCartas(base, j, p, conexion);
				ventana.setVisible(true);
			}

		});

		labelNotas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				ventana g = new ventana(prop, base, conexion, j, p);
				g.setVisible(true);
			}

		});

		labelChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VentanaChat ventana = new VentanaChat(conexion, j, u);
				ventana.setVisible(true);
			}

		});

		fondo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println(e.getX());
				System.out.println(e.getY());

			}
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				VentanaMenu ventana = new VentanaMenu(conexion, u, base);
				ventana.setVisible(true);
			}

		});

		labelDado.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int turno = base.obtenerTurno(conexion, j);
				int numero;

				 if (turno == 1) {
				
				 if (!(hTurno.isPulsado())) {

				Random r = new Random();

				
				numero=r.nextInt(7);

				hTurno.setDado(numero);

				while (hTurno.getDado() == 0) {
					hTurno.setDado(r.nextInt(7));
				}

				numero=hTurno.getDado();

				System.out.println(hTurno.getDado());

				try {

					imagen = new ImageIcon(
							VentanaTablero.class.getResource("Imagenes/" + hTurno.getDado() + ".png").toURI().toURL());

				} catch (Exception o) {

					System.out.println("No se ha encontrado el archivo");
				}

				icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(), labelDado.getHeight(),
						Image.SCALE_DEFAULT));

				labelDado.setIcon(icono);

				barcoX = trainera.getX();

				System.out.println(barcoX);
				
				hTurno.setPulsado(true);

				
					System.out.println("codigoturno"+hTurno.getCodigoJugadorConTurno()+" "+j.getCodigo());
					busquedaposicion ponercircrojos=new busquedaposicion();
					fichasrojas=new ArrayList<Point>();
					ArrayList<Point> camino=new ArrayList();
					System.out.println("voy a obtener coordenada");
					Point coord=base.ObtenerCoordenada(conexion,j);
					camino.add(coord);		
					if(coord.equals(new Point(129,876))){
						numero=numero-1;
					}
					ponercircrojos.MoverA(coord, numero, camino, fichasrojas);
					System.out.println("ya he hecho mover a");
					pposiciones.meterPosibilidades(fichasrojas);
					System.out.println("pinto fichas azulessssssssssssssssssssssssssssss");
					pposiciones.repaint();
					System.out.println("acaba repaint");
			
				 
				 }
			 
				 }}
			 

		});

		hiloPìntado pintar = new hiloPìntado(semaforo, labelDado, labelAcusar, trainera, p, j, conexion, anchura,

				traineraUPV,arrjugadores,arrfichas,altura,pposiciones);

			

		if (base.obtenerOrientacion(conexion, p)) {
			pintar.setOrientacion(true);

		} else {
			pintar.setOrientacion(false);
			
			

			try {

				imagen = new ImageIcon(
						VentanaTablero.class.getResource("Imagenes/traineradeustoInvertida.png"));
			} catch (Exception i) {
			}
			icono = new ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
					trainera.getHeight(), Image.SCALE_DEFAULT));

			trainera.setIcon(icono);

			try {

				imagen = new ImageIcon(
						VentanaTablero.class.getResource("Imagenes/traineraUPV.png"));
			} catch (Exception i) {
			}
			icono = new ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
					traineraUPV.getHeight(), Image.SCALE_DEFAULT));


			traineraUPV.setIcon(icono);
		}


		// if (base.obtenerOrientacion(conexion, p)){
		// pintar.setOrientacion(true);
		// }else{
		// pintar.setOrientacion(false);
		// }

		pintar.start();

		// addWindowFocusListener(new WindowFocusListener() {
		//
		// @Override
		// public void windowLostFocus(WindowEvent e) {
		//
		//
		// }
		//
		// @Override
		// public void windowGainedFocus(WindowEvent e) {
		//
		// int CodigoJugadorConTurno=base.ObtenerCodigoJugadorTurno(conexion,
		// p);
		//
		//
		// if (j.getCodigo()==CodigoJugadorConTurno){
		//
		// System.out.println("HACE");
		//
		// ImageIcon imagen = new ImageIcon();
		//
		// Icon icono;
		//
		// try{
		//
		// imagen=new
		// ImageIcon(HiloTurno.class.getResource("Imagenes/semaforoverde.png").toURI().toURL());
		//
		// }catch (Exception p){
		//
		// System.out.println("No se ha encontrado al archivo");
		// }
		//
		// icono = new
		// ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(),
		// semaforo.getHeight(), Image.SCALE_DEFAULT));
		//
		// semaforo.setIcon(icono);
		//
		// semaforo.repaint();
		//
		// semaforo.revalidate();
		//
		// try{
		//
		// imagen=new
		// ImageIcon(HiloTurno.class.getResource("Imagenes/dado.gif").toURI().toURL());
		//
		// }catch (Exception p){
		//
		// System.out.println("No se ha encontrado al archivo");
		// }
		//
		// icono = new
		// ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(),
		// labelDado.getHeight(), Image.SCALE_DEFAULT));
		//
		// labelDado.setIcon(icono);
		//
		// labelDado.repaint();
		//
		// try{
		//
		// imagen=new
		// ImageIcon(HiloTurno.class.getResource("Imagenes/pusharriba.png").toURI().toURL());
		//
		// }catch (Exception p){
		//
		// System.out.println("No se ha encontrado al archivo");
		// }
		//
		// icono = new
		// ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(),
		// labelAcusar.getHeight(), Image.SCALE_DEFAULT));
		//
		// labelAcusar.setIcon(icono);
		//
		// labelAcusar.repaint();
		//
		//
		// }else{
		//
		// System.out.println("NO HACE");
		//
		// ImageIcon imagen = new ImageIcon();
		//
		// Icon icono;
		//
		// try{
		//
		// imagen=new
		// ImageIcon(HiloTurno.class.getResource("Imagenes/semafororojot.png").toURI().toURL());
		//
		// }catch (Exception p){
		//
		// System.out.println("No se ha encontrado al archivo");
		// }
		//
		// icono = new
		// ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(),
		// semaforo.getHeight(), Image.SCALE_DEFAULT));
		//
		// semaforo.setIcon(icono);
		//
		// semaforo.repaint();
		//
		// semaforo.revalidate();
		//
		//
		// try{
		//
		// imagen=new
		// ImageIcon(HiloTurno.class.getResource("Imagenes/dadoNegro.gif").toURI().toURL());
		//
		// }catch (Exception p){
		//
		// System.out.println("No se ha encontrado al archivo");
		// }
		//
		// icono = new
		// ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(),
		// labelDado.getHeight(), Image.SCALE_DEFAULT));
		//
		// labelDado.setIcon(icono);
		//
		// labelDado.repaint();
		//
		//
		// try{
		//
		// imagen=new
		// ImageIcon(HiloTurno.class.getResource("Imagenes/pusharribaNegro.png").toURI().toURL());
		//
		// }catch (Exception p){
		//
		// System.out.println("No se ha encontrado al archivo");
		// }
		//
		// icono = new
		// ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(),
		// labelAcusar.getHeight(), Image.SCALE_DEFAULT));
		//
		// labelAcusar.setIcon(icono);
		//
		// labelAcusar.repaint();
		//
		// }
		//
		//
		//
		// }
		// });

		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {
				int CodigoJugadorConTurno = base.ObtenerCodigoJugadorTurno(conexion, p);

				if (j.getCodigo() == CodigoJugadorConTurno) {

					System.out.println("HACE");

					ImageIcon imagen = new ImageIcon();

					Icon icono;

					try {

						imagen = new ImageIcon(
								HiloTurno.class.getResource("Imagenes/semaforoverde.png").toURI().toURL());

					} catch (Exception p) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(), semaforo.getHeight(),
							Image.SCALE_DEFAULT));

					semaforo.setIcon(icono);

					semaforo.repaint();

					semaforo.revalidate();

					if (hTurno.getDado() == -1) {
						try {

							imagen = new ImageIcon(HiloTurno.class.getResource("Imagenes/dado.gif").toURI().toURL());

						} catch (Exception p) {

							System.out.println("No se ha encontrado al archivo");
						}

						icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(),
								labelDado.getHeight(), Image.SCALE_DEFAULT));

						labelDado.setIcon(icono);

						labelDado.repaint();
					} else {

						try {

							imagen = new ImageIcon(VentanaTablero.class
									.getResource("Imagenes/" + hTurno.getDado() + ".png").toURI().toURL());

						} catch (Exception o) {

							System.out.println("No se ha encontrado el archivo");
						}

						icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(),
								labelDado.getHeight(), Image.SCALE_DEFAULT));

						labelDado.setIcon(icono);

					}

					try {

						imagen = new ImageIcon(HiloTurno.class.getResource("Imagenes/pusharriba.png").toURI().toURL());

					} catch (Exception p) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(),
							labelAcusar.getHeight(), Image.SCALE_DEFAULT));

					labelAcusar.setIcon(icono);

					labelAcusar.repaint();

				} else {

					System.out.println("NO HACE");

					ImageIcon imagen = new ImageIcon();

					Icon icono;

					try {

						imagen = new ImageIcon(
								HiloTurno.class.getResource("Imagenes/semafororojot.png").toURI().toURL());

					} catch (Exception p) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(), semaforo.getHeight(),
							Image.SCALE_DEFAULT));

					semaforo.setIcon(icono);

					semaforo.repaint();

					semaforo.revalidate();

					try {

						imagen = new ImageIcon(HiloTurno.class.getResource("Imagenes/dadoNegro.gif").toURI().toURL());

					} catch (Exception p) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(),
							labelDado.getHeight(), Image.SCALE_DEFAULT));

					labelDado.setIcon(icono);

					labelDado.repaint();

					try {

						imagen = new ImageIcon(
								HiloTurno.class.getResource("Imagenes/pusharribaNegro.png").toURI().toURL());

					} catch (Exception p) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(),
							labelAcusar.getHeight(), Image.SCALE_DEFAULT));

					labelAcusar.setIcon(icono);

					labelAcusar.repaint();

				}

			}

			@Override
			public void windowClosed(WindowEvent e) {
				hTurno.acaba();
				pintar.acabar();
				System.out.println("Se ha cerrado la ventana");
			}

		});

		labelDenunciar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				jugador1.setLocation(reajustarAnchura(86 - 28, anchura), reajustarAlturaFicha(414 - 32, pposiciones.getHeight()));
				if (barcoX > reajustarAnchura(-110, anchura) && barcoX < reajustarAnchura(250, anchura)) {
					if (jugador1.getX() == reajustarAnchura(216 - 28, anchura)
							&& jugador1.getY() == reajustarAlturaFicha(637 - 32, pposiciones.getHeight())) {

						pintar.setSeguir(false);

						int numero = JOptionPane.showConfirmDialog(getContentPane(),
								"Tienes la oportunidad de coger el barco, ¿quieres montarte?", "Barco",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

						if (numero == JOptionPane.YES_OPTION) {

							pintar.setSeguir(true);

							if (pintar.isOrientacion()) {

								pintar.setFicha(jugador1);

								try {

									imagen = new ImageIcon(
											VentanaTablero.class.getResource("Imagenes/traineradeustoInvertida.png"));
								} catch (Exception p) {
								}
								icono = new ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
										trainera.getHeight(), Image.SCALE_DEFAULT));

								trainera.setIcon(icono);

								trainera.setLocation(reajustarAnchura(29, anchura), trainera.getY());
								try {

									imagen = new ImageIcon(
											VentanaTablero.class.getResource("Imagenes/traineraUPV.png"));
								} catch (Exception p) {
								}
								icono = new ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
										traineraUPV.getHeight(), Image.SCALE_DEFAULT));

								traineraUPV.setLocation((trainera.getX() + (2*traineraUPV.getWidth())),
										trainera.getY());

								traineraUPV.setIcon(icono);

								base.modificarOrientacion(conexion, p, false);

								pintar.setOrientacion(false);

								pintar.setAnimacion1(true);

								base.modificarAccion(conexion, p, true);
								
							} else {

								trainera.setLocation(reajustarAnchura(29, anchura), trainera.getY());
								trainera.repaint();
								traineraUPV.setLocation((trainera.getX() + (2*traineraUPV.getWidth())),
										trainera.getY());
								traineraUPV.repaint();
								pintar.setFicha(jugador1);
								pintar.setAnimacion1(true);
								
								base.modificarAccion(conexion, p, true);

							}
						} else {
							pintar.setSeguir(true);
						}
					} else if (jugador1.getX() == reajustarAnchura(86 - 28, anchura)
							&& jugador1.getY() == reajustarAlturaFicha(414 - 32, pposiciones.getHeight())) {

						pintar.setSeguir(false);

						int numero = JOptionPane.showConfirmDialog(getContentPane(),
								"Tienes la oportunidad de coger el barco, ¿quieres montarte?", "Barco",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

						if (numero == JOptionPane.YES_OPTION) {

							pintar.setSeguir(true);

							if (pintar.isOrientacion()) {

								pintar.setFicha(jugador1);

								try {

									imagen = new ImageIcon(
											VentanaTablero.class.getResource("Imagenes/traineradeustoInvertida.png"));
								} catch (Exception p) {
								}
								icono = new ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
										trainera.getHeight(), Image.SCALE_DEFAULT));

								trainera.setIcon(icono);

								trainera.setLocation(reajustarAnchura(29, anchura), trainera.getY());
								
								System.out.println(reajustarAnchura(29,anchura));
								try {

									imagen = new ImageIcon(
											VentanaTablero.class.getResource("Imagenes/traineraUPV.png"));
								} catch (Exception p) {
								}
								icono = new ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
										traineraUPV.getHeight(), Image.SCALE_DEFAULT));

								traineraUPV.setLocation((trainera.getX() + (2*traineraUPV.getWidth())),
										trainera.getY());

								traineraUPV.setIcon(icono);

								base.modificarOrientacion(conexion, p, false);

								pintar.setOrientacion(false);

								pintar.setAnimacion3(true);
								
								base.modificarAccion(conexion, p, true);

							} else {

								trainera.setLocation(reajustarAnchura(29, anchura), trainera.getY());
								trainera.repaint();
								traineraUPV.setLocation((trainera.getX() + (2*traineraUPV.getWidth())),
										trainera.getY());
								traineraUPV.repaint();
								pintar.setFicha(jugador1);
								pintar.setAnimacion3(true);
								
								base.modificarAccion(conexion, p, true);

							}
						} else {
							pintar.setSeguir(true);
						}

					}

					// if (pintar.isOrientacion()){
					//
					// try{
					//
					// imagen = new
					// ImageIcon(VentanaTablero.class.getResource("Imagenes/traineradeustoInvertida.png"));
					// }catch (Exception p){
					// }
					// icono=new
					// ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
					// trainera.getHeight(), Image.SCALE_DEFAULT));
					//
					//
					//
					// trainera.setIcon(icono);
					//
					// try{
					//
					// imagen = new
					// ImageIcon(VentanaTablero.class.getResource("Imagenes/traineraUPV.png"));
					// }catch (Exception p){
					// }
					// icono=new
					// ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
					// traineraUPV.getHeight(), Image.SCALE_DEFAULT));
					//
					// traineraUPV.setIcon(icono);
					//
					// pintar.setOrientacion(false);
					// }else{
					//
					//
					// try{
					//
					// imagen = new
					// ImageIcon(VentanaTablero.class.getResource("Imagenes/traineradeusto.png"));
					// }catch (Exception p){
					// }
					// icono=new
					// ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
					// trainera.getHeight(), Image.SCALE_DEFAULT));
					//
					//
					//
					// trainera.setIcon(icono);
					//
					// try{
					//
					// imagen = new
					// ImageIcon(VentanaTablero.class.getResource("Imagenes/traineraUPVInvertida.png"));
					// }catch (Exception p){
					// }
					// icono=new
					// ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
					// traineraUPV.getHeight(), Image.SCALE_DEFAULT));
					//
					// traineraUPV.setIcon(icono);
					//
					// pintar.setOrientacion(true);
					//
					//
					// }
				} else if (barcoX > reajustarAnchura(1090, anchura) && barcoX < reajustarAnchura(1490, anchura)) {

					if (jugador1.getX() == reajustarAnchura(1391 - 28, anchura)
							&& jugador1.getY() == reajustarAlturaFicha(397 - 32, pposiciones.getHeight())) {

						pintar.setSeguir(false);

						int numero = JOptionPane.showConfirmDialog(getContentPane(),
								"Tienes la oportunidad de coger el barco, ¿quieres montarte?", "Barco",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

						if (numero == JOptionPane.YES_OPTION) {

							pintar.setSeguir(true);

							if (pintar.isOrientacion()) {

								trainera.setLocation(reajustarAnchura(1250, anchura), trainera.getY());
								trainera.repaint();
								traineraUPV.setLocation((trainera.getX() + (2*traineraUPV.getWidth())),
										trainera.getY());
								traineraUPV.repaint();
								pintar.setFicha(jugador1);
								pintar.setAnimacion2(true);
								
								base.modificarAccion(conexion, p, true);

							} else {

								pintar.setFicha(jugador1);

								try {

									imagen = new ImageIcon(
											VentanaTablero.class.getResource("Imagenes/traineradeusto.png"));
								} catch (Exception p) {
								}
								icono = new ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
										trainera.getHeight(), Image.SCALE_DEFAULT));

								trainera.setIcon(icono);

								trainera.setLocation(reajustarAnchura(1250, anchura), trainera.getY());
								try {

									imagen = new ImageIcon(
											VentanaTablero.class.getResource("Imagenes/traineraUPVInvertida.png"));
								} catch (Exception p) {
								}
								icono = new ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
										traineraUPV.getHeight(), Image.SCALE_DEFAULT));

								traineraUPV.setLocation((trainera.getX() + (2*traineraUPV.getWidth())),
										traineraUPV.getY());

								traineraUPV.setIcon(icono);

								base.modificarOrientacion(conexion, p, true);

								pintar.setOrientacion(true);

								pintar.setAnimacion2(true);
								
								base.modificarAccion(conexion, p, true);

							}
						} else {
							pintar.setSeguir(true);
						}
					} else if (jugador1.getX() == reajustarAnchura(1251 - 28, anchura)
							&& jugador1.getY() == reajustarAlturaFicha(673 - 32, pposiciones.getHeight())) {

						pintar.setSeguir(false);

						int numero = JOptionPane.showConfirmDialog(getContentPane(),
								"Tienes la oportunidad de coger el barco, ¿quieres montarte?", "Barco",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

						if (numero == JOptionPane.YES_OPTION) {

							pintar.setSeguir(true);

							if (pintar.isOrientacion()) {

								trainera.setLocation(reajustarAnchura(1250, anchura), trainera.getY());
								trainera.repaint();
								traineraUPV.setLocation((trainera.getX() + (2*traineraUPV.getWidth())),
										traineraUPV.getY());
								traineraUPV.repaint();
								pintar.setFicha(jugador1);
								pintar.setAnimacion4(true);
								
								base.modificarAccion(conexion, p, true);

							} else {

								pintar.setFicha(jugador1);

								try {

									imagen = new ImageIcon(
											VentanaTablero.class.getResource("Imagenes/traineradeusto.png"));
								} catch (Exception p) {
								}
								icono = new ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
										trainera.getHeight(), Image.SCALE_DEFAULT));

								trainera.setIcon(icono);

								trainera.setLocation(reajustarAnchura(1250, anchura), trainera.getY());
								
								try {

									imagen = new ImageIcon(
											VentanaTablero.class.getResource("Imagenes/traineraUPVInvertida.png"));
								} catch (Exception p) {
								}
								icono = new ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
										traineraUPV.getHeight(), Image.SCALE_DEFAULT));

								traineraUPV.setLocation((trainera.getX() +(2*traineraUPV.getWidth())),
										traineraUPV.getY());

								traineraUPV.setIcon(icono);

								base.modificarOrientacion(conexion, p, true);

								pintar.setOrientacion(true);

								pintar.setAnimacion4(true);

								base.modificarAccion(conexion, p, true);
								
							}
						} else {
							pintar.setSeguir(true);
						}

					}
				}
			}
		}

		);

		// campo.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// campo.setSeleccionado(false);
		// campo.repaint();
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// campo.setSeleccionado(true);
		// campo.setC1(0);
		// campo.setC2(0);
		// campo.setC3(255);
		// campo.repaint();
		//
		// }
		//
		//
		// });
		//
		// ade.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// ade.setSeleccionado(false);
		// ade.repaint();
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// ade.setSeleccionado(true);
		// ade.setC1(247);
		// ade.setC2(191);
		// ade.setC3(190);
		// ade.repaint();
		//
		// }
		//
		//
		// });
		//
		// capilla.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// capilla.setSeleccionado(false);
		// capilla.repaint();
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// capilla.setSeleccionado(true);
		// capilla.setC1(247);
		// capilla.setC2(153);
		// capilla.setC3(133);
		// capilla.repaint();
		//
		// }
		//
		//
		// });
		//
		// l.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// l.setSeleccionado(false);
		// l.repaint();
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// l.setSeleccionado(true);
		// l.setC1(179);
		// l.setC2(223);
		// l.setC3(83);
		// l.repaint();
		//
		// }
		//
		//
		// });
		//
		// deLetras.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// deLetras.setSeleccionado(false);
		// deLetras.repaint();
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// deLetras.setSeleccionado(true);
		// deLetras.setC1(128);
		// deLetras.setC2(128);
		// deLetras.setC3(128);
		// deLetras.repaint();
		//
		// }
		//
		//
		// });
		//
		//
		// crai.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// crai.setSeleccionado(false);
		// crai.repaint();
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// crai.setSeleccionado(true);
		// crai.setC1(22);
		// crai.setC2(170);
		// crai.setC3(76);
		// crai.repaint();
		//
		// }
		//
		//
		// });
		//
		// centenario.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// centenario.setSeleccionado(false);
		// centenario.repaint();
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// centenario.setSeleccionado(true);
		// centenario.setC1(102);
		// centenario.setC2(15);
		// centenario.setC3(130);
		// centenario.repaint();
		//
		// }
		//
		//
		// });
		//
		//
		// zubi.addMouseListener(new MouseAdapter() {
		//
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// zubi.setSeleccionado(false);
		// zubi.repaint();
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// zubi.setSeleccionado(true);
		// zubi.setC1(192);
		// zubi.setC2(0);
		// zubi.setC3(64);
		// zubi.repaint();
		//
		// }
		//
		//
		// });

	}

	
	public void meterImgEnlabel(String ruta, JLabel label, int largo, int ancho) {
		ImageIcon imicon = new ImageIcon(ventana.class.getResource(ruta));
		label.setSize(largo, ancho);
		Icon icono = new ImageIcon(
				imicon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
	}

	public int reajustarAltura(int coordenada, int altura) {

		double escala =(double) altura / (double) ALTURA;

		return (int) (coordenada * escala);

	}
	
	public int reajustarAlturaPunto(int coordenada,int altura) {

		double escala =953 /  pposiciones.getBounds().getHeight();
		
		System.out.println(pposiciones.getBounds().getHeight()+"pposiciones.getBounds().getHeight()");

		return (int) (coordenada * escala);

	}
	public int reajustarAnchuraPunto(int coordenada) {

		double escala = 1920 / pposiciones.getBounds().getWidth() ;

		return (int) (coordenada * escala);

	}

	public int reajustarAnchura(int coordenada, int anchura) {

		double escala = (double) anchura / (double) ANCHURA;

		return (int) (coordenada * escala);

	}

	public int reajustarTamañoAlt(int tamañoY, int altura) {

		double escala = (double) altura / (double) ALTURA;

		return (int) (tamañoY * escala);

	}

	public int reajustarTamañoAnch(int tamañoX, int anchura) {

		double escala = (double) anchura / (double) ANCHURA;

		return (int) (tamañoX * escala);

	}

	public int reajustarImagen(int tamañoX, int altura) {

		double escala = (double) 973 / (double) (altura);

		return (int) (tamañoX * escala);

	}

	public JLabel ObtenerFichaDeJugador(ArrayList<Jugador> arrjug, Jugador j) {
		for (int i = 0; i < arrjug.size(); i++) {
			if (j.getCodigo() == arrjug.get(i).getCodigo()) {
				return arrfichas[i];

			}
		}
		return null;

	}

	public int reajustarTamañoAltMaider(int tamañoY, int altura) {

		double escala = (double)altura / (double) ALTURAM;

		return (int) (tamañoY * escala);

	}

	public int reajustarAlturaMaider(int coordenada, int altura) {

		double escala = (double)altura / (double) ALTURAM;

		return (int) (coordenada * escala);

	}

	public void meterFicha(ArrayList<Jugador> arrjug, int anchura, int altura) {
		for (int i = 0; i < arrjug.size(); i++) {
			meterImgEnlabel(arrjug.get(i).getFicha(), arrfichas[i], reajustarTamañoAnch(50, anchura),
					reajustarTamañoAltMaider(60, altura));
		}
	}

	public void colocarFichaInicio(ArrayList<Jugador> arrjug, int anchura, int altura) {
		Point[] arr = new Point[5];
		arr[0] = new Point(reajustarAnchura(66, anchura), reajustarAlturaMaider(735, altura));
		arr[1] = new Point(reajustarAnchura(66, anchura), reajustarAlturaMaider(785, altura));
		arr[2] = new Point(reajustarAnchura(66, anchura), reajustarAlturaMaider(835, altura));
		arr[3] = new Point(reajustarAnchura(116, anchura), reajustarAlturaMaider(735, altura));
		arr[4] = new Point(reajustarAnchura(116, anchura), reajustarAlturaMaider(785, altura));
		for (int i = 0; i < arrjug.size(); i++) {
			arrfichas[i].setLocation(arr[i]);
		}
		
	
	}

	public Point BuscarPuntoPinchado(int x,int y,int anchura,int altura){
		System.out.println("xy"+x+" "+y);
		int yy=reajustarAlturaPunto(y,altura);
		int xx=reajustarAnchuraPunto(x);
		System.out.println("xy ajustado"+xx+" "+yy);
		
		Point punto=new Point(xx,yy);
		//ArrayList<Point> puntos=pposiciones.arrayBuscar();
		ArrayList<Point> puntos=fichasrojas;		
		for(int i=0;i<puntos.size();i++){
			double ak=Math.abs(puntos.get(i).getX()-xx);
			double kk=Math.abs(puntos.get(i).getY()-yy);
			System.out.println("ak"+ak+" "+"kk"+kk);
			
//			if(Math.sqrt(Math.pow(ak,2)+Math.pow(kk, 2))<28){
//				return puntos.get(i);
//			}
			if(ak<28 && kk<16){
				System.out.println("punto del array"+puntos.get(i));

				return puntos.get(i);
				
			}
		}
		return new Point(0, 0);
	}

	public boolean estaEn(Point punto, ArrayList<Point> array) {
		for (int i = 0; i < array.size(); i++) {
			if (punto.equals(array.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public int reajustarAlturaFicha(int coordenada, int altura) {

		double escala = altura / (double) 953;

		return (int) (coordenada * escala);

	}
	public int reajustarAnchuraFicha(int coordenada, int anchura) {

		double escala = anchura / (double) 1920;

		return (int) (coordenada * escala);

	}

}

//
// import java.awt.BorderLayout;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Image;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
// import java.sql.Connection;
//
// import javax.swing.BorderFactory;
// import javax.swing.BoxLayout;
// import javax.swing.Icon;
// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.border.Border;
//
// import Proyecto.Cluedo.Datos.Partida;
// import Proyecto.Cluedo.Datos.Usuario;
// import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
// import Proyecto.Cluedo.Logica.Jugador;
// import Proyecto.Cluedo.Logica.Propiedades;
//
// public class VentanaTablero extends JFrame {
//
// private JPanel pprincipal=new JPanel();
//
// private JPanel parriba=new JPanel();
//
// private static panelrosa pabajo;
//
// private panelrosa pderecha;
//
// private panelrosa ptablero;
//
// private JLabel lcartel=new JLabel();
//
// private JLabel ltextocartel=new JLabel();
//
// private JLabel lsemaforo=new JLabel();
//
// private JLabel lacusar=new JLabel();
//
// private JLabel lenviar=new JLabel();
//
// private JLabel lnotas=new JLabel();
//
// private JLabel lchat=new JLabel();
//
// private JLabel lusuario=new JLabel();
//
// private JLabel ldado=new JLabel();
//
// private JPanel pcartel=new JPanel();
//
// private static int[][] mibaraja=new int[3][4];
//
// private JFrame g;
//
// private VentanaChat ventana;
//
//
//
//
// public VentanaTablero(Connection conexion, Jugador j,Usuario
// u,GestionBaseDeDatos base,Partida p,Propiedades prop){
//
//
// this.setExtendedState(MAXIMIZED_BOTH);
// setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
// //setSize( 1330, 730 );
// setResizable( true );
// Border blackline = BorderFactory.createLineBorder(Color.DARK_GRAY,8);
// ImageIcon imagefondo = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/tablero - copia -
// copia.jpg"));
// ptablero=new panelrosa(imagefondo.getImage());
// ImageIcon imagefondocartel = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/fondocartel.jpg"));
// ptablero.setBorder(blackline);
// ImageIcon imagefondomadera = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/fondomadera.jpg"));
//
// pabajo=new panelrosa(imagefondomadera.getImage());
// pderecha=new panelrosa(imagefondocartel.getImage());
// meterImgEnlabel("Imagenes/cartel.png",lcartel,500,600);
// meterImgEnlabel("Imagenes/semafororojot.png",lsemaforo,200,150);
// meterImgEnlabel("Imagenes/pusharriba.png",lacusar,100,100);
// meterImgEnlabel("Imagenes/dado.gif",ldado,100,100);
// meterImgEnlabel("Imagenes/chat.png",lchat,80,80);
// meterImgEnlabel("Imagenes/cartel.png",lusuario,80,80);
// meterImgEnlabel("Imagenes/notas.png",lnotas,80,80);
// meterImgEnlabel("Imagenes/ENVIAR2.png",lenviar,80,80);
// pprincipal.setLayout(new BorderLayout());
// getContentPane().add(pprincipal);
// parriba.setBackground(Color.black);
// parriba.setLayout(new BoxLayout(parriba,BoxLayout.X_AXIS));
// parriba.add(lusuario,parriba);
// parriba.add(lnotas,parriba);
// parriba.add(lchat,parriba);
// parriba.add(lenviar,parriba);
// pprincipal.add(parriba,BorderLayout.NORTH);
// pderecha.setLayout(new BoxLayout(pderecha,BoxLayout.Y_AXIS));
// pderecha.add(lsemaforo);
// pderecha.setBorder(blackline);
// lsemaforo.setAlignmentX(CENTER_ALIGNMENT);
// lcartel.setAlignmentX(CENTER_ALIGNMENT);
// //
// pcartel.setOpaque(false);
// pcartel.add(lcartel);
// pcartel.add(ltextocartel);
// pderecha.add(pcartel);
// ltextocartel.setForeground(Color.blue);
// ltextocartel.setSize(new Dimension(500,300));
// ltextocartel.setLocation(0,0);
// pprincipal.add(pderecha, BorderLayout.EAST);
// pprincipal.add(ptablero,BorderLayout.CENTER);
// //pabajo.setLayout(null);
// pabajo.add(lacusar);
// pabajo.add(ldado);
// pabajo.setBackground(Color.DARK_GRAY);
// pprincipal.add(pabajo,BorderLayout.SOUTH);
// //Escuchadores
// lacusar.addMouseListener( new MouseAdapter() {
// @Override
// public void mousePressed(MouseEvent e) {
// meterImgEnlabel("Imagenes/pushbajo.png",lacusar,100,100);
// Jugador a =new Jugador();
// a.setLugar(2);
// //mete el fondo del lugar en el que este
// String [] aimglug=new String [8];
// aimglug[0]="Imagenes/ingenieria.jpg";
// aimglug[1]="Imagenes/comercial.jpg";
// aimglug[2]="Imagenes/capilla.JPG";
// aimglug[3]="Imagenes/centenario.jpg";
// aimglug[4]="Imagenes/letras.jpg";
// aimglug[5]="Imagenes/biblioteca.jpeg";
// aimglug[6]="Imagenes/zubiarte.jpg";
// aimglug[7]="Imagenes/zubiarte.jpg";
//
// JFrame f=new VentanaAcusar(aimglug[a.getLugar()],prop);
// f.setVisible(true);
// }
//
// public void mouseEntered(MouseEvent e){
// meterImgEnlabel("Imagenes/pushbajo.png",lacusar,100,100);
// }
// public void mouseExited(MouseEvent e){
// meterImgEnlabel("Imagenes/pusharriba.png",lacusar,100,100);
// }
//
// });
// lenviar.addMouseListener( new MouseAdapter() {
// @Override
// public void mousePressed(MouseEvent e) {
//
// VentanaCartas ventana = new VentanaCartas(base,j,p,conexion);
// ventana.setVisible(true);
// }
//
//
//
// });
// lnotas.addMouseListener( new MouseAdapter() {
// @Override
// public void mousePressed(MouseEvent e) {
//
// mibaraja[0][0]=5;
// mibaraja[0][1]=1;
// mibaraja[0][2]=2;
// mibaraja[0][3]=3;
// mibaraja[1][0]=4;
// mibaraja[1][1]=5;
// mibaraja[1][2]=1;
// mibaraja[1][3]=2;
// mibaraja[2][0]=3;
// mibaraja[2][1]=4;
// mibaraja[2][2]=5;
// mibaraja[2][3]=0;
//
//
// g=new ventana(prop, base, conexion, j, p);
// g.setVisible(true);
// }
//
//
//
// });
// lchat.addMouseListener( new MouseAdapter() {
// @Override
// public void mousePressed(MouseEvent e) {
// ventana= new VentanaChat(conexion, j, u);
// ventana.setVisible(true);
// }
//
//
//
// });
//
//
//
//
//
// }
// public void meterImgEnlabel(String ruta,JLabel label,int largo,int ancho){
// ImageIcon imicon = new ImageIcon(ventana.class.getResource(ruta));
// label.setSize(largo,ancho);
// Icon icono = new
// ImageIcon(imicon.getImage().getScaledInstance(label.getWidth() ,
// label.getHeight(), Image.SCALE_DEFAULT));
// label.setIcon(icono);
// }
// public void cambiarNumDado(int num){
// if (num==1){
// meterImgEnlabel("Imagenes/dado1.png",ldado,100,100);
// }else if(num==2){
// meterImgEnlabel("Imagenes/dado2.png",ldado,100,100);
// }else if(num==3){
// meterImgEnlabel("Imagenes/dado3.png",ldado,100,100);
// }else if(num==4){
// meterImgEnlabel("Imagenes/dado4.png",ldado,100,100);
// }else if(num==5){
// meterImgEnlabel("Imagenes/dado5.png",ldado,100,100);
// }else{
// meterImgEnlabel("Imagenes/dado6.png",ldado,100,100);
// }
// }
//
//
//
// }
//
// package Proyecto.Cluedo.Ventanas;
//
// import java.awt.BorderLayout;
// import java.awt.Component;
// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.GraphicsEnvironment;
// import java.awt.Image;
// import java.awt.ImageCapabilities;
// import java.awt.Insets;
// import java.awt.Rectangle;
// import java.awt.event.ComponentAdapter;
// import java.awt.event.ComponentEvent;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;
// import java.awt.event.WindowAdapter;
// import java.awt.event.WindowEvent;
// import java.awt.event.WindowListener;
// import java.sql.Connection;
// import java.util.HashMap;
// import java.util.Random;
//
// import javax.swing.Icon;
// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.border.Border;
//
// import Proyecto.Cluedo.Datos.LabelPerfil;
// import Proyecto.Cluedo.Datos.Partida;
// import Proyecto.Cluedo.Datos.Usuario;
// import Proyecto.Cluedo.Hilo.HiloTurno;
// import Proyecto.Cluedo.Logica.Animacion;
// import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
// import Proyecto.Cluedo.Logica.Jugador;
// import Proyecto.Cluedo.Logica.Propiedades;
//
//
// public class VentanaTablero extends JFrame {
//
// private HiloTurno hTurno = null;
//
// private boolean mostradoI = true;
//
// private boolean mostradoD = true;
//
// private Icon icono;
//
// private ImageIcon imagen = new ImageIcon();
//
// private JLabel semaforo=new JLabel();
//
//
// //private static int[][] mibaraja=new int[3][4];
//
// // public static void main(String[] args) {
// //
// // VentanaTablero ventana = new VentanaTablero();
// //
// // ventana.setVisible(true);
// //
// // }
//
// public VentanaTablero(Connection conexion, Jugador j, Usuario u,
// GestionBaseDeDatos base, Partida p,
// Propiedades prop) {
//
// hTurno = new HiloTurno();
// hTurno.setBase(base);
// hTurno.setJugador(j);
// hTurno.setPartida(p);
// hTurno.setCon(conexion);
// hTurno.setPulsado(false);
//
//
// // Establecemos el formato
//
// this.setExtendedState(MAXIMIZED_BOTH);
//
// GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
//
// Dimension screenDimension = env.getMaximumWindowBounds().getSize();
//
// Insets insets = getInsets();
//
// final int left = insets.left;
//
// final int right = insets.right;
//
// final int top = insets.top;
//
// final int bottom = insets.bottom;
//
// final int anchura = screenDimension.width - left - right;
//
// final int altura = screenDimension.height - top - bottom;
//
// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// setSize(900, 700);
// setResizable(true);
//
// // Generamos los compoenentes
//
// JLabel flechaD = new JLabel();
//
// JLabel flechaI = new JLabel();
//
// JLabel labelDado = new JLabel();
//
// JLabel labelAcusar = new JLabel();
//
// LabelPerfil usuario;
//
// JLabel labelNotas = new JLabel();
//
// JLabel labelChat = new JLabel();
//
// JLabel labelCartas = new JLabel();
//
// JLabel labelDenunciar = new JLabel();
//
// JLabel jugador1 = new JLabel();
//
//
// jugador1.setBounds(170, 750, 80 , 80);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/barco.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new ImageIcon(
// imagen.getImage().getScaledInstance(jugador1.getWidth(),
// jugador1.getHeight(), Image.SCALE_DEFAULT));
//
// jugador1.setIcon(icono);
//
// labelDado.setBounds(100, 130, 80, 80);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/dado.gif").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new ImageIcon(
// imagen.getImage().getScaledInstance(labelDado.getWidth(),
// labelDado.getHeight(), Image.SCALE_DEFAULT));
//
// labelDado.setIcon(icono);
//
// labelAcusar.setBounds(100, 235, 80, 80);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/pusharriba.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new
// ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(),
// labelAcusar.getHeight(),
// Image.SCALE_DEFAULT));
//
// labelAcusar.setIcon(icono);
//
// labelDenunciar.setBounds(105, 345, 70, 70);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/denuncia.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new
// ImageIcon(imagen.getImage().getScaledInstance(labelDenunciar.getWidth(),
// labelDenunciar.getHeight(),
// Image.SCALE_DEFAULT));
//
// labelDenunciar.setIcon(icono);
//
//
// usuario = new LabelPerfil(u.getImagenPerfil(), 130, 80, 80, 80);
//
// labelNotas.setBounds(260, 80, 80, 80);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/notes-1.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new
// ImageIcon(imagen.getImage().getScaledInstance(labelNotas.getWidth(),
// labelNotas.getHeight(),
// Image.SCALE_DEFAULT));
//
// labelNotas.setIcon(icono);
//
// labelChat.setBounds(390, 80, 80, 80);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/messages-icon.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new ImageIcon(
// imagen.getImage().getScaledInstance(labelChat.getWidth(),
// labelChat.getHeight(), Image.SCALE_DEFAULT));
//
// labelChat.setIcon(icono);
//
// labelCartas.setBounds(520, 80, 100, 80);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/cards.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new
// ImageIcon(imagen.getImage().getScaledInstance(labelCartas.getWidth(),
// labelCartas.getHeight(),
// Image.SCALE_DEFAULT));
//
// labelCartas.setIcon(icono);
//
// flechaI.setBounds(200, 550 / 2 - 25, 50, 50);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/transparente.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new ImageIcon(
// imagen.getImage().getScaledInstance(flechaI.getWidth(), flechaI.getHeight(),
// Image.SCALE_DEFAULT));
//
// flechaI.setIcon(icono);
//
// flechaD.setBounds(340, 10, 55, 55);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/transparente.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new ImageIcon(
// imagen.getImage().getScaledInstance(flechaD.getWidth(), flechaD.getHeight(),
// Image.SCALE_DEFAULT));
//
// flechaD.setIcon(icono);
//
// try {
//
// imagen = new ImageIcon(
// VentanaTablero.class.getResource("Imagenes/definitivo.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// panelrosa fondo = new panelrosa(imagen.getImage());
//
// semaforo = new JLabel();
//
// semaforo.setBounds((int) anchura / 2 - 90, 60, 220, 90);
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/semafororojot.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new ImageIcon(
// imagen.getImage().getScaledInstance(semaforo.getWidth(),
// semaforo.getHeight(), Image.SCALE_DEFAULT));
//
// semaforo.setIcon(icono);
//
//
//
//
// JLabel cuadradoI = new JLabel();
//
// JPanel panelI = new JPanel();
//
// panelI.setBounds(-90, altura / 2 - 270, 250, 550);
//
// panelI.setOpaque(false);
//
// cuadradoI.setBounds(0, 0, 250, 550);
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/cuadrado.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new ImageIcon(
// imagen.getImage().getScaledInstance(cuadradoI.getWidth(),
// cuadradoI.getHeight(), Image.SCALE_DEFAULT));
//
// cuadradoI.setIcon(icono);
//
// JPanel panelD = new JPanel();
//
// panelD.setBounds(anchura / 2 - 320, altura - 200, 750, 300);
//
// panelD.setOpaque(false);
//
// JLabel cuadradoD = new JLabel();
//
// cuadradoD.setBounds(0, 0, 750, 300);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/cuadradoGirado.png").toURI().toURL());
// } catch (Exception e) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new ImageIcon(
// imagen.getImage().getScaledInstance(cuadradoD.getWidth(),
// cuadradoD.getHeight(), Image.SCALE_DEFAULT));
//
// cuadradoD.setIcon(icono);
//
// hTurno.setLabelSemaforo(semaforo);
//
// hTurno.setLabelAcusar(labelAcusar);
//
// hTurno.setLabelDado(labelDado);
//
// hTurno.start();
//
// // Establecemos el formato
//
// getContentPane().setLayout(new BorderLayout());
//
// getContentPane().add(fondo, BorderLayout.CENTER);
//
// fondo.setLayout(null);
//
// fondo.add(semaforo);
// panelI.setLayout(null);
// panelD.setLayout(null);
//
// panelI.add(flechaI);
//
// panelI.add(labelDado);
//
// panelI.add(labelAcusar);
//
// panelI.add(labelDenunciar);
//
// panelI.add(cuadradoI);
//
// fondo.add(panelI);
//
// panelD.add(flechaD);
//
// panelD.add(usuario);
//
// panelD.add(labelChat);
//
// panelD.add(labelNotas);
//
// panelD.add(labelCartas);
//
// panelD.add(cuadradoD);
//
// fondo.add(panelD);
//
// fondo.add(jugador1);
//
// flechaI.addMouseListener(new MouseAdapter() {
//
// @Override
// public void mouseClicked(MouseEvent e) {
// System.out.println(1);
//
// Dimension size = new Dimension(250, 550);
//
// Rectangle from = new Rectangle(-90, altura / 2 - 270, size.width,
// size.height);
// Rectangle to = new Rectangle(-200, altura / 2 - 270, size.width,
// size.height);
// if (mostradoI) {
// Animacion animate = new Animacion(panelI, from, to);
// animate.start();
// mostradoI = false;
// } else {
// Animacion animate = new Animacion(panelI, to, from);
// animate.start();
// mostradoI = true;
// }
// }
// });
//
// flechaD.addMouseListener(new MouseAdapter() {
//
// @Override
// public void mouseClicked(MouseEvent e) {
// System.out.println(1);
//
// Dimension size = new Dimension(750, 300);
//
// Rectangle from = new Rectangle(anchura / 2 - 320, altura - 200, size.width,
// size.height);
// Rectangle to = new Rectangle(anchura / 2 - 320, altura - 80, size.width,
// size.height);
// if (mostradoD) {
// Animacion animate = new Animacion(panelD, from, to);
// animate.start();
// mostradoD = false;
// } else {
// Animacion animate = new Animacion(panelD, to, from);
// animate.start();
// mostradoD = true;
// }
//
// }
// });
//
// addComponentListener(new ComponentAdapter() {
// @Override
// public void componentResized(ComponentEvent e) {
//
// double escalaX = getContentPane().getWidth() / (double) anchura; // Nueva
// // escala
// // X
// double escalaY = getContentPane().getHeight() / (double) altura; // Nueva
// // escala
// // Y
//
// semaforo.setBounds((int) (((int) anchura / 2 - 90) * escalaX), (int) (60 *
// escalaY),
// (int) (220 * escalaX), (int) (90 * escalaY));
//
// try {
//
// imagen = new ImageIcon(
// VentanaTablero.class.getResource("Imagenes/semafororojot.png").toURI().toURL());
// } catch (Exception o) {
//
// System.out.println("No se ha encontrado el archivo");
// }
//
// icono = new
// ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(),
// semaforo.getHeight(),
// Image.SCALE_DEFAULT));
//
// semaforo.setIcon(icono);
//
//
// fondo.repaint();
// }
//
// });
//
// labelAcusar.addMouseListener(new MouseAdapter() {
// @Override
// public void mousePressed(MouseEvent e) {
//// meterImgEnlabel("Imagenes/pushbajo.png", labelAcusar, 100, 100);
// Jugador a = new Jugador();
// a.setLugar(2);
// // mete el fondo del lugar en el que este
// String[] aimglug = new String[8];
// aimglug[0] = "Imagenes/ingenieria.jpg";
// aimglug[1] = "Imagenes/comercial.jpg";
// aimglug[2] = "Imagenes/capilla.JPG";
// aimglug[3] = "Imagenes/centenario.jpg";
// aimglug[4] = "Imagenes/letras.jpg";
// aimglug[5] = "Imagenes/biblioteca.jpeg";
// aimglug[6] = "Imagenes/zubiarte.jpg";
// aimglug[7] = "Imagenes/zubiarte.jpg";
//
// VentanaAcusar f = new VentanaAcusar(base,conexion,j,p);
// f.setVisible(true);
// }
//
//// public void mouseEntered(MouseEvent e) {
//// meterImgEnlabel("Imagenes/pushbajo.png", labelAcusar, 100, 100);
//// }
////
//// public void mouseExited(MouseEvent e) {
//// meterImgEnlabel("Imagenes/pusharriba.png", labelAcusar, 100, 100);
//// }
//
// });
// labelCartas.addMouseListener(new MouseAdapter() {
// @Override
// public void mousePressed(MouseEvent e) {
//
// VentanaCartas ventana = new VentanaCartas(base, j, p, conexion);
// ventana.setVisible(true);
// }
//
// });
//
// labelNotas.addMouseListener(new MouseAdapter() {
// @Override
// public void mousePressed(MouseEvent e) {
//
//
//
// ventana g = new ventana(prop, base, conexion, j, p);
// g.setVisible(true);
// }
//
// });
//
// labelChat.addMouseListener(new MouseAdapter() {
// @Override
// public void mousePressed(MouseEvent e) {
// VentanaChat ventana = new VentanaChat(conexion, j, u);
// ventana.setVisible(true);
// }
//
// });
//
// fondo.addMouseListener(new MouseAdapter() {
//
// @Override
// public void mouseClicked(MouseEvent e) {
//
// System.out.println(e.getX());
// System.out.println(e.getY());
//
// }
// });
//
// addWindowListener(new WindowAdapter() {
//
//
// @Override
// public void windowClosed(WindowEvent arg0) {
// VentanaMenu ventana = new VentanaMenu(conexion, u, base);
// ventana.setVisible(true);
// }
//
// });
//
// labelDado.addMouseListener(new MouseAdapter() {
//
//
// @Override
// public void mouseClicked(MouseEvent e) {
//
// int turno = base.obtenerTurno(conexion, j);
//
// if (turno==1){
//
// if (!(hTurno.isPulsado())){
//
// Random r= new Random();
//
// int numero = r.nextInt(7);
//
// while (numero==0){
// numero = r.nextInt(7);
// }
//
// System.out.println(numero);
//
// try {
//
// imagen = new
// ImageIcon(VentanaTablero.class.getResource("Imagenes/"+numero+".png").toURI().toURL());
//
// }catch (Exception o){
//
// System.out.println("No se ha encontrado el archivo");
// }
//
//
// icono = new
// ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(),
// labelDado.getHeight(), Image.SCALE_DEFAULT));
//
// labelDado.setIcon(icono);
//
// hTurno.setPulsado(true);
// }
//
//
//
// }
//
// }
// });
//
// addWindowListener(new WindowAdapter() {
//
//
// @Override
// public void windowClosed(WindowEvent e) {
// hTurno.acaba();
// System.out.println("Se ha cerrado la ventana");
// }
//
// });
// }
//
// public void meterImgEnlabel(String ruta, JLabel label, int largo, int ancho)
// {
// ImageIcon imicon = new ImageIcon(ventana.class.getResource(ruta));
// label.setSize(largo, ancho);
// Icon icono = new ImageIcon(
// imicon.getImage().getScaledInstance(label.getWidth(), label.getHeight(),
// Image.SCALE_DEFAULT));
// label.setIcon(icono);
// }
//
//
//
// }
//
//
//
//
//
////
//// import java.awt.BorderLayout;
//// import java.awt.Color;
//// import java.awt.Dimension;
//// import java.awt.Image;
//// import java.awt.event.MouseAdapter;
//// import java.awt.event.MouseEvent;
//// import java.sql.Connection;
////
//// import javax.swing.BorderFactory;
//// import javax.swing.BoxLayout;
//// import javax.swing.Icon;
//// import javax.swing.ImageIcon;
//// import javax.swing.JFrame;
//// import javax.swing.JLabel;
//// import javax.swing.JPanel;
//// import javax.swing.border.Border;
////
//// import Proyecto.Cluedo.Datos.Partida;
//// import Proyecto.Cluedo.Datos.Usuario;
//// import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
//// import Proyecto.Cluedo.Logica.Jugador;
//// import Proyecto.Cluedo.Logica.Propiedades;
////
//// public class VentanaTablero extends JFrame {
////
//// private JPanel pprincipal=new JPanel();
////
//// private JPanel parriba=new JPanel();
////
//// private static panelrosa pabajo;
////
//// private panelrosa pderecha;
////
//// private panelrosa ptablero;
////
//// private JLabel lcartel=new JLabel();
////
//// private JLabel ltextocartel=new JLabel();
////
//// private JLabel lsemaforo=new JLabel();
////
//// private JLabel lacusar=new JLabel();
////
//// private JLabel lenviar=new JLabel();
////
//// private JLabel lnotas=new JLabel();
////
//// private JLabel lchat=new JLabel();
////
//// private JLabel lusuario=new JLabel();
////
//// private JLabel ldado=new JLabel();
////
//// private JPanel pcartel=new JPanel();
////
//// private static int[][] mibaraja=new int[3][4];
////
//// private JFrame g;
////
//// private VentanaChat ventana;
////
////
////
////
//// public VentanaTablero(Connection conexion, Jugador j,Usuario
//// u,GestionBaseDeDatos base,Partida p,Propiedades prop){
////
////
//// this.setExtendedState(MAXIMIZED_BOTH);
//// setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
//// //setSize( 1330, 730 );
//// setResizable( true );
//// Border blackline = BorderFactory.createLineBorder(Color.DARK_GRAY,8);
//// ImageIcon imagefondo = new
//// ImageIcon(VentanaTablero.class.getResource("Imagenes/tablero - copia -
//// copia.jpg"));
//// ptablero=new panelrosa(imagefondo.getImage());
//// ImageIcon imagefondocartel = new
//// ImageIcon(VentanaTablero.class.getResource("Imagenes/fondocartel.jpg"));
//// ptablero.setBorder(blackline);
//// ImageIcon imagefondomadera = new
//// ImageIcon(VentanaTablero.class.getResource("Imagenes/fondomadera.jpg"));
////
//// pabajo=new panelrosa(imagefondomadera.getImage());
//// pderecha=new panelrosa(imagefondocartel.getImage());
//// meterImgEnlabel("Imagenes/cartel.png",lcartel,500,600);
//// meterImgEnlabel("Imagenes/semafororojot.png",lsemaforo,200,150);
//// meterImgEnlabel("Imagenes/pusharriba.png",lacusar,100,100);
//// meterImgEnlabel("Imagenes/dado.gif",ldado,100,100);
//// meterImgEnlabel("Imagenes/chat.png",lchat,80,80);
//// meterImgEnlabel("Imagenes/cartel.png",lusuario,80,80);
//// meterImgEnlabel("Imagenes/notas.png",lnotas,80,80);
//// meterImgEnlabel("Imagenes/ENVIAR2.png",lenviar,80,80);
//// pprincipal.setLayout(new BorderLayout());
//// getContentPane().add(pprincipal);
//// parriba.setBackground(Color.black);
//// parriba.setLayout(new BoxLayout(parriba,BoxLayout.X_AXIS));
//// parriba.add(lusuario,parriba);
//// parriba.add(lnotas,parriba);
//// parriba.add(lchat,parriba);
//// parriba.add(lenviar,parriba);
//// pprincipal.add(parriba,BorderLayout.NORTH);
//// pderecha.setLayout(new BoxLayout(pderecha,BoxLayout.Y_AXIS));
//// pderecha.add(lsemaforo);
//// pderecha.setBorder(blackline);
//// lsemaforo.setAlignmentX(CENTER_ALIGNMENT);
//// lcartel.setAlignmentX(CENTER_ALIGNMENT);
//// //
//// pcartel.setOpaque(false);
//// pcartel.add(lcartel);
//// pcartel.add(ltextocartel);
//// pderecha.add(pcartel);
//// ltextocartel.setForeground(Color.blue);
//// ltextocartel.setSize(new Dimension(500,300));
//// ltextocartel.setLocation(0,0);
//// pprincipal.add(pderecha, BorderLayout.EAST);
//// pprincipal.add(ptablero,BorderLayout.CENTER);
//// //pabajo.setLayout(null);
//// pabajo.add(lacusar);
//// pabajo.add(ldado);
//// pabajo.setBackground(Color.DARK_GRAY);
//// pprincipal.add(pabajo,BorderLayout.SOUTH);
//// //Escuchadores
//// lacusar.addMouseListener( new MouseAdapter() {
//// @Override
//// public void mousePressed(MouseEvent e) {
//// meterImgEnlabel("Imagenes/pushbajo.png",lacusar,100,100);
//// Jugador a =new Jugador();
//// a.setLugar(2);
//// //mete el fondo del lugar en el que este
//// String [] aimglug=new String [8];
//// aimglug[0]="Imagenes/ingenieria.jpg";
//// aimglug[1]="Imagenes/comercial.jpg";
//// aimglug[2]="Imagenes/capilla.JPG";
//// aimglug[3]="Imagenes/centenario.jpg";
//// aimglug[4]="Imagenes/letras.jpg";
//// aimglug[5]="Imagenes/biblioteca.jpeg";
//// aimglug[6]="Imagenes/zubiarte.jpg";
//// aimglug[7]="Imagenes/zubiarte.jpg";
////
//// JFrame f=new VentanaAcusar(aimglug[a.getLugar()],prop);
//// f.setVisible(true);
//// }
////
//// public void mouseEntered(MouseEvent e){
//// meterImgEnlabel("Imagenes/pushbajo.png",lacusar,100,100);
//// }
//// public void mouseExited(MouseEvent e){
//// meterImgEnlabel("Imagenes/pusharriba.png",lacusar,100,100);
//// }
////
//// });
//// lenviar.addMouseListener( new MouseAdapter() {
//// @Override
//// public void mousePressed(MouseEvent e) {
////
//// VentanaCartas ventana = new VentanaCartas(base,j,p,conexion);
//// ventana.setVisible(true);
//// }
////
////
////
//// });
//// lnotas.addMouseListener( new MouseAdapter() {
//// @Override
//// public void mousePressed(MouseEvent e) {
////
//// mibaraja[0][0]=5;
//// mibaraja[0][1]=1;
//// mibaraja[0][2]=2;
//// mibaraja[0][3]=3;
//// mibaraja[1][0]=4;
//// mibaraja[1][1]=5;
//// mibaraja[1][2]=1;
//// mibaraja[1][3]=2;
//// mibaraja[2][0]=3;
//// mibaraja[2][1]=4;
//// mibaraja[2][2]=5;
//// mibaraja[2][3]=0;
////
////
//// g=new ventana(prop, base, conexion, j, p);
//// g.setVisible(true);
//// }
////
////
////
//// });
//// lchat.addMouseListener( new MouseAdapter() {
//// @Override
//// public void mousePressed(MouseEvent e) {
//// ventana= new VentanaChat(conexion, j, u);
//// ventana.setVisible(true);
//// }
////
////
////
//// });
////
////
////
////
////
//// }
//// public void meterImgEnlabel(String ruta,JLabel label,int largo,int ancho){
//// ImageIcon imicon = new ImageIcon(ventana.class.getResource(ruta));
//// label.setSize(largo,ancho);
//// Icon icono = new
//// ImageIcon(imicon.getImage().getScaledInstance(label.getWidth() ,
//// label.getHeight(), Image.SCALE_DEFAULT));
//// label.setIcon(icono);
//// }
//// public void cambiarNumDado(int num){
//// if (num==1){
//// meterImgEnlabel("Imagenes/dado1.png",ldado,100,100);
//// }else if(num==2){
//// meterImgEnlabel("Imagenes/dado2.png",ldado,100,100);
//// }else if(num==3){
//// meterImgEnlabel("Imagenes/dado3.png",ldado,100,100);
//// }else if(num==4){
//// meterImgEnlabel("Imagenes/dado4.png",ldado,100,100);
//// }else if(num==5){
//// meterImgEnlabel("Imagenes/dado5.png",ldado,100,100);
//// }else{
//// meterImgEnlabel("Imagenes/dado6.png",ldado,100,100);
//// }
//// }
////
////
////
//// }//// }
package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.ImageCapabilities;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Hilo.HiloTurno;
import Proyecto.Cluedo.Logica.Animacion;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Logica.Propiedades;


public class VentanaTablero extends JFrame {
	
	private HiloTurno hTurno = null; 
	
	private boolean mostradoI = true;

	private boolean mostradoD = true;

	private Icon icono;
	
	private ImageIcon imagen = new ImageIcon();
	
	private JLabel semaforo=new JLabel();
	

	//private static int[][] mibaraja=new int[3][4];
	
	// public static void main(String[] args) {
	//
	// VentanaTablero ventana = new VentanaTablero();
	//
	// ventana.setVisible(true);
	//
	// }

	public VentanaTablero(Connection conexion, Jugador j, Usuario u, GestionBaseDeDatos base, Partida p,
			Propiedades prop) {
		
		hTurno = new HiloTurno();
		hTurno.setBase(base);
		hTurno.setJugador(j);
		hTurno.setPartida(p);
		hTurno.setCon(conexion);
		hTurno.setPulsado(false);
		
		
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

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 700);
		setResizable(true);

		// Generamos los compoenentes

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
		
		
		jugador1.setBounds(170, 750, 80	, 80);
		
		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/barco.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(jugador1.getWidth(), jugador1.getHeight(), Image.SCALE_DEFAULT));

		jugador1.setIcon(icono);
		
		labelDado.setBounds(100, 130, 80, 80);
		
		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/dado.gif").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(labelDado.getWidth(), labelDado.getHeight(), Image.SCALE_DEFAULT));

		labelDado.setIcon(icono);

		labelAcusar.setBounds(100, 235, 80, 80);

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/pusharriba.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(), labelAcusar.getHeight(),
				Image.SCALE_DEFAULT));

		labelAcusar.setIcon(icono);

		labelDenunciar.setBounds(105, 345, 70, 70);

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/denuncia.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDenunciar.getWidth(), labelDenunciar.getHeight(),
				Image.SCALE_DEFAULT));

		labelDenunciar.setIcon(icono);


		usuario = new LabelPerfil(u.getImagenPerfil(), 130, 80, 80, 80);

		labelNotas.setBounds(260, 80, 80, 80);

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/notes-1.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(labelNotas.getWidth(), labelNotas.getHeight(),
				Image.SCALE_DEFAULT));

		labelNotas.setIcon(icono);

		labelChat.setBounds(390, 80, 80, 80);

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/messages-icon.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(labelChat.getWidth(), labelChat.getHeight(), Image.SCALE_DEFAULT));

		labelChat.setIcon(icono);

		labelCartas.setBounds(520, 80, 100, 80);

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/cards.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(imagen.getImage().getScaledInstance(labelCartas.getWidth(), labelCartas.getHeight(),
				Image.SCALE_DEFAULT));

		labelCartas.setIcon(icono);

		flechaI.setBounds(200, 550 / 2 - 25, 50, 50);

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/transparente.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(flechaI.getWidth(), flechaI.getHeight(), Image.SCALE_DEFAULT));

		flechaI.setIcon(icono);

		flechaD.setBounds(340, 10, 55, 55);

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
					VentanaTablero.class.getResource("Imagenes/definitivo.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		panelrosa fondo = new panelrosa(imagen.getImage());

		semaforo = new JLabel();

		semaforo.setBounds((int) anchura / 2 - 90, 60, 220, 90);
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

		panelI.setBounds(-90, altura / 2 - 270, 250, 550);

		panelI.setOpaque(false);

		cuadradoI.setBounds(0, 0, 250, 550);
		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/cuadrado.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(cuadradoI.getWidth(), cuadradoI.getHeight(), Image.SCALE_DEFAULT));

		cuadradoI.setIcon(icono);

		JPanel panelD = new JPanel();

		panelD.setBounds(anchura / 2 - 320, altura - 200, 750, 300);

		panelD.setOpaque(false);

		JLabel cuadradoD = new JLabel();

		cuadradoD.setBounds(0, 0, 750, 300);

		try {

			imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/cuadradoGirado.png").toURI().toURL());
		} catch (Exception e) {

			System.out.println("No se ha encontrado el archivo");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(cuadradoD.getWidth(), cuadradoD.getHeight(), Image.SCALE_DEFAULT));

		cuadradoD.setIcon(icono);
		
		hTurno.setLabelSemaforo(semaforo);
		
		hTurno.start();

		// Establecemos el formato

		getContentPane().setLayout(new BorderLayout());

		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);

		fondo.add(semaforo);
		panelI.setLayout(null);
		panelD.setLayout(null);

		panelI.add(flechaI);

		panelI.add(labelDado);

		panelI.add(labelAcusar);

		panelI.add(labelDenunciar);

		panelI.add(cuadradoI);

		fondo.add(panelI);

		panelD.add(flechaD);

		panelD.add(usuario);

		panelD.add(labelChat);

		panelD.add(labelNotas);

		panelD.add(labelCartas);

		panelD.add(cuadradoD);

		fondo.add(panelD);

		fondo.add(jugador1);
		
		flechaI.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(1);

				Dimension size = new Dimension(250, 550);

				Rectangle from = new Rectangle(-90, altura / 2 - 270, size.width, size.height);
				Rectangle to = new Rectangle(-200, altura / 2 - 270, size.width, size.height);
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

				Dimension size = new Dimension(750, 300);

				Rectangle from = new Rectangle(anchura / 2 - 320, altura - 200, size.width, size.height);
				Rectangle to = new Rectangle(anchura / 2 - 320, altura - 80, size.width, size.height);
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

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {

				double escalaX = getContentPane().getWidth() / (double) anchura; // Nueva
				// escala
				// X
				double escalaY = getContentPane().getHeight() / (double) altura; // Nueva
				// escala
				// Y

				semaforo.setBounds((int) (((int) anchura / 2 - 90) * escalaX), (int) (60 * escalaY),
						(int) (220 * escalaX), (int) (90 * escalaY));

				try {

					imagen = new ImageIcon(
							VentanaTablero.class.getResource("Imagenes/semafororojot.png").toURI().toURL());
				} catch (Exception o) {

					System.out.println("No se ha encontrado el archivo");
				}

				icono = new ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(), semaforo.getHeight(),
						Image.SCALE_DEFAULT));

				semaforo.setIcon(icono);
				
				
				fondo.repaint();
			}

		});

		labelAcusar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				meterImgEnlabel("Imagenes/pushbajo.png", labelAcusar, 100, 100);
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

				VentanaAcusar f = new VentanaAcusar(base,conexion,j,p);
				f.setVisible(true);
			}

//			public void mouseEntered(MouseEvent e) {
//				meterImgEnlabel("Imagenes/pushbajo.png", labelAcusar, 100, 100);
//			}
//
//			public void mouseExited(MouseEvent e) {
//				meterImgEnlabel("Imagenes/pusharriba.png", labelAcusar, 100, 100);
//			}

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
				
				if (turno==1){
					
					if (!(hTurno.isPulsado())){
						
						Random r= new Random();
						
						int numero = r.nextInt(7);
						
						while (numero==0){
							numero = r.nextInt(7);
						}
						
						System.out.println(numero);

						try {
							
							imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/"+numero+".png").toURI().toURL());
							
						}catch (Exception o){
							
							System.out.println("No se ha encontrado el archivo");
						}
						
						
						icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(), labelDado.getHeight(), Image.SCALE_DEFAULT));
						
						labelDado.setIcon(icono);
						
						hTurno.setPulsado(true);
					}
					
				
					
				}
				
			}
		});
		
		addWindowListener(new WindowAdapter() {
			

			@Override
			public void windowClosed(WindowEvent e) {
				hTurno.acaba();
				
			}
			
		});
	}

	public void meterImgEnlabel(String ruta, JLabel label, int largo, int ancho) {
		ImageIcon imicon = new ImageIcon(ventana.class.getResource(ruta));
		label.setSize(largo, ancho);
		Icon icono = new ImageIcon(
				imicon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
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

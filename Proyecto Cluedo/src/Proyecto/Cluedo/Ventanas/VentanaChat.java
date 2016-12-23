package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.channels.NetworkChannel;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.text.html.HTMLDocument;

import Proyecto.Cluedo.Datos.Chat;
import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Hilo.chatHilo;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;

public class VentanaChat extends JFrame {

	
	private JLabel usuariosLinea;

	private int contadorUsuarios = 0;

	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();

	// public VentanaChat(Connection conexion,Jugador j,Usuario u){
	//
	// j.setEnLinea(true);
	//
	//
	// gestion.modificarEstado(conexion, j);
	//
	// //Inicializamos el frame
	// j.setEnLinea(true);
	// setUndecorated(false);
	// setResizable(false);
	// setSize(new Dimension(802, 633));
	// setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	// setLocationRelativeTo(null);
	//
	// //Creamos los compoenntes
	//
	//
	//
	// ImageIcon imagen= new ImageIcon ();
	//
	// usuariosLinea=new JLabel();
	//
	// JLabel labelEnviar = new JLabel ();
	//
	// Icon iconoEnviar;
	//
	// JTextArea mensaje= new JTextArea();
	//
	// JEditorPane principal = new JEditorPane("text/html","");
	//
	// JList <String> usuarios = new JList<String>();
	//
	// LabelPerfil labelPerfil;
	//
	// JLabel nombre = new JLabel (j.getUsuario());
	//
	// String [] contenido ={"En linea","Desconectado"};
	//
	// JComboBox<String> estado = new JComboBox<String>(contenido);
	//
	//
	// //JLabel labelSalir = new JLabel();
	//
	// //Icon iconoSalir;
	//
	// JLabel labelFondo= new JLabel();
	//
	// Icon iconoFondo;
	//
	// JScrollPane panelLista = new JScrollPane(usuarios);
	//
	// JScrollPane panelMensajes= new JScrollPane(principal);
	//
	// //Establecemos el formato
	//
	//
	//
	// getContentPane().setLayout(new BorderLayout());
	//
	// labelEnviar.setBounds(660, 528, 136, 70);
	//
	// try{
	// imagen= new
	// ImageIcon(VentanaChat.class.getResource("Imagenes/enviar.png").toURI().toURL());
	// }catch (Exception e){
	// System.out.println("No se ha encontrado el archivo");
	// }
	//
	// iconoEnviar= new
	// ImageIcon(imagen.getImage().getScaledInstance(labelEnviar.getWidth(),
	// labelEnviar.getHeight(), Image.SCALE_DEFAULT));
	//
	// labelEnviar.setIcon(iconoEnviar);
	//
	// mensaje.setBounds(184, 528, 475, 72);
	//
	// mensaje.setText("Introduzca aqui su mensaje");
	//
	// mensaje.setForeground(Color.lightGray);
	//
	// panelMensajes.setBounds(184,83,612,442);
	//
	// principal.setEditable(false);
	//
	//
	// Font font = UIManager.getFont("Label.font");
	//
	// String bodyRule = "body { font-family: "+font.getFamily()+";
	// "+"font-size: "+font.getSize()+"pt; }";
	//
	// ((HTMLDocument)principal.getDocument()).getStyleSheet().addRule(bodyRule);
	//
	// panelLista.setBounds(0,130,185,470);
	//
	// usuarios.setEnabled(false);
	//
	// usuariosLinea.setBounds(0, 84, 185, 46);
	//
	// usuariosLinea.setFont(new Font("System", Font.BOLD, 16));
	//
	// usuariosLinea.setForeground(new Color(237, 81, 30));
	//
	// usuariosLinea.setBackground(Color.lightGray);
	//
	// labelFondo.setBounds(0, 0, 800, 85);
	//
	// try{
	// imagen= new ImageIcon(VentanaChat.class.getResource("Imagenes/Fondo
	// Negro.jpg").toURI().toURL());
	// }catch (Exception e){
	// System.out.println("No se encuentra el archivo");
	// }
	//
	// iconoFondo= new
	// ImageIcon(imagen.getImage().getScaledInstance(labelFondo.getWidth(),
	// labelFondo.getHeight(), Image.SCALE_DEFAULT));
	//
	// labelFondo.setIcon(iconoFondo);
	//
	//
	//
	// estado.setBounds(110, 47, 87, 25);
	//
	// nombre.setBounds(110,20,57,17);
	//
	// nombre.setForeground(Color.white);
	//
	// labelPerfil=new LabelPerfil(u.getImagenPerfil(), 28, 14, 65, 65);
	//
	//// labelPerfil.setBounds(28, 14, 65, 65);
	////
	//// try{
	//// imagen= new
	// ImageIcon(VentanaChat.class.getResource("Imagenes/user.png").toURI().toURL());
	//// }catch (Exception e){
	//// System.out.println("No se encuentra el archivo");
	//// }
	////
	//// iconoPerfil= new
	// ImageIcon(imagen.getImage().getScaledInstance(labelPerfil.getWidth(),
	// labelPerfil.getHeight(), Image.SCALE_DEFAULT));
	////
	//// labelPerfil.setIcon(iconoPerfil);
	//
	// /*labelSalir.setBounds(742,33,25,25);
	//
	// try{
	// imagen= new
	// ImageIcon(VentanaChat.class.getResource("Imagenes/cierre.png").toURI().toURL());
	// }catch (Exception e){
	// System.out.println("No se encuentra el archivo");
	// }
	//
	// iconoSalir= new
	// ImageIcon(imagen.getImage().getScaledInstance(labelSalir.getWidth(),
	// labelSalir.getHeight(), Image.SCALE_DEFAULT));
	//
	// labelSalir.setIcon(iconoSalir);*/
	//
	// mensaje.setBorder(BorderFactory.createLineBorder(Color.black));
	//
	// principal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	//
	// usuariosLinea.setBorder(BorderFactory.createLineBorder(Color.black));
	//
	//// ArrayList<String> listadeConectados=new ArrayList<String>();
	////
	//// DefaultListModel modelo = new DefaultListModel();
	////
	//// for(int i = 1; i<=50; i++){
	//// modelo.addElement(i);
	//// }
	////
	//// usuarios.setModel(modelo);
	//
	//
	//
	//
	// //Lo añadimos al panel
	//
	// getContentPane().setLayout(null);
	//
	//
	//
	// getContentPane().add(labelEnviar);
	//
	// getContentPane().add(usuariosLinea);
	//
	// getContentPane().add(estado);
	//
	//
	//
	// getContentPane().add(nombre);
	//
	// getContentPane().add(labelPerfil);
	//
	// //getContentPane().add(labelSalir);
	//
	// getContentPane().add(mensaje);
	//
	// getContentPane().add(labelFondo);
	//
	// getContentPane().add(panelMensajes);
	//
	// getContentPane().add(panelLista);
	//
	// chatHilo hilo= new chatHilo(conexion, j, usuariosLinea, principal,
	// usuarios,panelMensajes,getContentPane());
	//
	//
	// hilo.start();
	//
	//
	//
	//
	//
	//
	// //Generamos los eventos
	//
	// mensaje.addFocusListener(new FocusListener() {
	//
	// @Override
	// public void focusLost(FocusEvent arg0) {
	// if (mensaje.getText().length()==0){
	// mensaje.setText("Introduzca aqui su mensaje");
	// mensaje.setForeground(Color.lightGray);
	// }
	//
	// }
	//
	// @Override
	// public void focusGained(FocusEvent arg0) {
	// if (mensaje.getText().equals("Introduzca aqui su mensaje")){
	// mensaje.setText("");
	// mensaje.setForeground(Color.BLACK);
	// }
	//
	// }
	// });
	//
	// labelEnviar.addMouseListener(new MouseAdapter() {
	//
	// @Override
	// public void mouseClicked(MouseEvent e) {
	//
	// if (mensaje.getText().trim().length()>0){
	//
	// Chat c= new Chat(mensaje.getText(), j.getCodigoPartida(),
	// j.getCodigo(),j.getUsuario());
	// gestion.insertarChat(conexion, c);
	//
	// mensaje.setText("");
	// }else{
	// JOptionPane.showMessageDialog(getContentPane(), "No se ha introducido
	// ningun texto","Aviso",JOptionPane.INFORMATION_MESSAGE);
	// }
	// }
	// });
	//
	// mensaje.addKeyListener(new KeyAdapter() {
	//
	//
	// @Override
	// public void keyReleased(KeyEvent e) {
	// if (e.getKeyCode()==KeyEvent.VK_ENTER){
	//
	// if (mensaje.getText().trim().length()>0){
	//
	// Chat c= new Chat(mensaje.getText(), j.getCodigoPartida(),
	// j.getCodigo(),j.getUsuario());
	// gestion.insertarChat(conexion, c);
	//
	// mensaje.setText("");
	// }else{
	// JOptionPane.showMessageDialog(getContentPane(), "No se ha introducido
	// ningun texto","Aviso",JOptionPane.INFORMATION_MESSAGE);
	// mensaje.setText("");
	// }
	//
	// }
	//
	// }
	//
	//
	//
	//
	//
	// });
	//
	// estado.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	//
	// String linea= (String) estado.getSelectedItem();
	//
	// if (linea.equals("En linea")){
	//
	// j.setEnLinea(true);
	//
	// gestion.modificarEstado(conexion, j);
	//
	// ArrayList <String> listaUsuarios=gestion.obtenerJugadoresLinea(conexion,
	// j);
	//
	// DefaultListModel modelo = new DefaultListModel();
	//
	// for (String s: listaUsuarios){
	// modelo.addElement(s);
	// }
	//
	// usuarios.setModel(modelo);
	//
	//
	// usuariosLinea.setText(" Usuarios en linea: "+listaUsuarios.size());
	//
	// usuariosLinea.repaint();
	// chatHilo hilo = new chatHilo(conexion, j, labelFondo, principal,
	// usuarios,panelMensajes,getContentPane());
	//
	// hilo.start();
	//
	// }else{
	//
	// JOptionPane.showMessageDialog(getContentPane(), "Si estas desconectado,
	// no recibiras ningun chat ni apareceras entre los usuarios en linea");
	//
	// j.setEnLinea(false);
	//
	// gestion.modificarEstado(conexion, j);
	//
	// ArrayList <String> listaUsuarios=gestion.obtenerJugadoresLinea(conexion,
	// j);
	//
	// DefaultListModel modelo = new DefaultListModel();
	//
	// for (String s: listaUsuarios){
	// modelo.addElement(s);
	// }
	//
	// usuarios.setModel(modelo);
	//
	//
	// usuariosLinea.setText(" Usuarios en linea: "+listaUsuarios.size());
	//
	// usuariosLinea.repaint();
	//
	// }
	//
	// }
	// });
	//
	//
	// addWindowListener(new WindowAdapter() {
	//
	//
	// @Override
	// public void windowClosed(WindowEvent e) {
	// j.setEnLinea(false);
	//
	// gestion.modificarEstado(conexion, j);
	//
	// }
	//
	//
	// });
	// /*labelSalir.addMouseListener(new MouseAdapter() {
	//
	// @Override
	// public void mouseClicked(MouseEvent e) {
	// dispose();
	//
	// }
	// });*/
	//
	// }
	//

	public VentanaChat(Connection conexion, Jugador j, Usuario u) {

		j.setEnLinea(true);

		gestion.modificarEstado(conexion, j);

		// Inicializamos el frame

		setUndecorated(false);
		setResizable(true);
		setSize(new Dimension(802, 633));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// Creamos los compoenntes

		panelrosa cabecera;

		JPanel panelIzquierdo = new JPanel();

		JPanel panelCentro = new JPanel();

		JPanel panelAbajo = new JPanel();

		JPanel panel = new JPanel();

		JPanel panelLinea = new JPanel();
		
		JPanel panelA = new JPanel();
		
		JPanel panelB= new JPanel();

		ImageIcon imagen = new ImageIcon();

		usuariosLinea = new JLabel();

		JLabel labelEnviar = new JLabel();

		Icon iconoEnviar;

		JTextArea mensaje = new JTextArea();

		JEditorPane principal = new JEditorPane("text/html", "");

		JList<String> usuarios = new JList<String>();

		LabelPerfil labelPerfil;

		JLabel nombre = new JLabel(j.getUsuario());

		String[] contenido = { "En linea", "Desconectado" };

		JComboBox<String> estado = new JComboBox<String>(contenido);

		JLabel hueco1 = new JLabel(" ");

		JLabel hueco2 = new JLabel(" ");
		
		JLabel hueco3 = new JLabel(" ");
		
		JLabel hueco4 = new JLabel(" ");
		
		JLabel hueco5 = new JLabel(" ");
		
		
		

		// JLabel labelSalir = new JLabel();

		// Icon iconoSalir;

		JLabel labelFondo = new JLabel();

		Icon iconoFondo;

		JScrollPane panelLista = new JScrollPane(usuarios);

		JScrollPane panelMensajes = new JScrollPane(principal);
		
		JLabel labelInfo = new JLabel();

		Icon iconoInfo;
		
		// Establecemos el formato
		
		try {
			imagen = new ImageIcon(VentanaChat.class.getResource("Imagenes/info.png").toURI().toURL());
		} catch (Exception e) {
			System.out.println("No se ha encontrado el archivo");
		}

		iconoInfo=new ImageIcon(imagen.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		
		labelInfo.setIcon(iconoInfo);
		try {
			imagen = new ImageIcon(VentanaChat.class.getResource("Imagenes/enviar.png").toURI().toURL());
		} catch (Exception e) {
			System.out.println("No se ha encontrado el archivo");
		}

		iconoEnviar = new ImageIcon(imagen.getImage().getScaledInstance(136, 70, Image.SCALE_DEFAULT));

		labelEnviar.setIcon(iconoEnviar);

		mensaje.setText("Introduzca aqui su mensaje");

		mensaje.setForeground(Color.lightGray);

		mensaje.setSize(475, 72);
		mensaje.setMinimumSize(new Dimension(475, 72));

		principal.setEditable(false);

		Font font = UIManager.getFont("Label.font");

		String bodyRule = "body { font-family: " + font.getFamily() + "; " + "font-size: " + font.getSize() + "pt; }";

		((HTMLDocument) principal.getDocument()).getStyleSheet().addRule(bodyRule);

		panelIzquierdo.setMinimumSize(new Dimension(185, 516));

		try {
			imagen = new ImageIcon(VentanaChat.class.getResource("Imagenes/Fondo Negro.jpg").toURI().toURL());
		} catch (Exception e) {
			System.out.println("No se encuentra el archivo");
		}

		
		cabecera=new panelrosa(imagen.getImage());
		
		
		usuarios.setEnabled(false);

		usuariosLinea.setFont(new Font("System", Font.BOLD, 16));

		usuariosLinea.setForeground(new Color(237, 81, 30));

		usuariosLinea.setBackground(Color.lightGray);

		nombre.setForeground(Color.white);
		
		nombre.setOpaque(false);

		labelPerfil = new LabelPerfil(null, 0, 0, 65, 65);

		labelPerfil.setSize(65, 65);
		Icon icono = new ImageIcon(u.getImagenPerfil().getImage().getScaledInstance(labelPerfil.getWidth(),
				labelPerfil.getHeight(), Image.SCALE_DEFAULT));
		labelPerfil.setIcon(icono);

		// labelPerfil.setBounds(28, 14, 65, 65);
		//
		// try{
		// imagen= new
		// ImageIcon(VentanaChat.class.getResource("Imagenes/user.png").toURI().toURL());
		// }catch (Exception e){
		// System.out.println("No se encuentra el archivo");
		// }
		//
		// iconoPerfil= new
		// ImageIcon(imagen.getImage().getScaledInstance(labelPerfil.getWidth(),
		// labelPerfil.getHeight(), Image.SCALE_DEFAULT));
		//
		// labelPerfil.setIcon(iconoPerfil);

		/*
		 * labelSalir.setBounds(742,33,25,25);
		 * 
		 * try{ imagen= new
		 * ImageIcon(VentanaChat.class.getResource("Imagenes/cierre.png").toURI(
		 * ).toURL()); }catch (Exception e){
		 * System.out.println("No se encuentra el archivo"); }
		 * 
		 * iconoSalir= new
		 * ImageIcon(imagen.getImage().getScaledInstance(labelSalir.getWidth(),
		 * labelSalir.getHeight(), Image.SCALE_DEFAULT));
		 * 
		 * labelSalir.setIcon(iconoSalir);
		 */

		panelAbajo.setBorder(BorderFactory.createLineBorder(Color.black));

		panelCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		panelLinea.setBorder(BorderFactory.createLineBorder(Color.black));

		panelLista.setBorder(BorderFactory.createLineBorder(Color.black));

		
		
		labelPerfil.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		
		labelInfo.setToolTipText("<html><body>Este chat dispone de las siguientes caracteristicas: <br>"
				+"Emoticonos : <br>:) Cara sonriente <br>:)) Carcajada <br>:( Cara triste<br>>:( Enfado<br>(^^^) Tiburon<br> &lt 3 Corazon<br>0:) Angel<br>;) Cara Picara<br> Este chat no acepta insultos y seran restringidos ");
		// ArrayList<String> listadeConectados=new ArrayList<String>();
		//
		// DefaultListModel modelo = new DefaultListModel();
		//
		// for(int i = 1; i<=50; i++){
		// modelo.addElement(i);
		// }
		//
		// usuarios.setModel(modelo);

		// Lo añadimos al panel

		getContentPane().setLayout(new BorderLayout());

		panelIzquierdo.setLayout(new BorderLayout());

		panelLinea.add(usuariosLinea, BorderLayout.CENTER);

		panelLinea.add(hueco1, BorderLayout.NORTH);

		panelLinea.add(hueco2, BorderLayout.SOUTH);

		panelIzquierdo.add(panelLinea, BorderLayout.NORTH);

		panelIzquierdo.add(panelLista);

		getContentPane().add(panelIzquierdo, BorderLayout.WEST);

		panelCentro.setLayout(new BorderLayout());

		panelCentro.add(panelMensajes, BorderLayout.CENTER);

		panelAbajo.setLayout(new BorderLayout());

		panelAbajo.add(mensaje, BorderLayout.CENTER);

		panelAbajo.add(labelEnviar, BorderLayout.EAST);

		panelCentro.add(panelAbajo, BorderLayout.SOUTH);

		getContentPane().add(panelCentro, BorderLayout.CENTER);

		getContentPane().add(cabecera, BorderLayout.NORTH);

		cabecera.setLayout(new BorderLayout());
		
		cabecera.add(panelA,BorderLayout.WEST);
		
		cabecera.add(panelB,BorderLayout.EAST);
		
		panelB.setOpaque(false);
		
		panelB.setLayout(new BorderLayout());
		
		panelB.add(labelInfo,BorderLayout.CENTER);
		
		panelB.add(hueco5,BorderLayout.EAST);
		
		panelA.setOpaque(false);

		panelA.add(hueco3);
		
		panelA.add(labelPerfil);

		panelA.add(hueco4);
		
		panelA.add(panel);

		panel.setOpaque(false);
		
		panel.setLayout(new BorderLayout());

		panel.add(nombre, BorderLayout.CENTER);

		panel.add(estado, BorderLayout.SOUTH);

		
		// getContentPane().add(labelSalir);

		chatHilo hilo = new chatHilo(conexion, j, usuariosLinea, principal, usuarios, panelMensajes, getContentPane());

		hilo.start();

		// Generamos los eventos

		mensaje.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if (mensaje.getText().length() == 0) {
					mensaje.setText("Introduzca aqui su mensaje");
					mensaje.setForeground(Color.lightGray);
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (mensaje.getText().equals("Introduzca aqui su mensaje")) {
					mensaje.setText("");
					mensaje.setForeground(Color.BLACK);
				}

			}
		});

		labelEnviar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (mensaje.getText().trim().length() > 0) {

					Chat c = new Chat(mensaje.getText(), j.getCodigoPartida(), j.getCodigo(), j.getUsuario());
					gestion.insertarChat(conexion, c);

					mensaje.setText("");
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "No se ha introducido ningun texto", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		mensaje.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					if (mensaje.getText().trim().length() > 0) {

						Chat c = new Chat(mensaje.getText(), j.getCodigoPartida(), j.getCodigo(), j.getUsuario());
						gestion.insertarChat(conexion, c);

						mensaje.setText("");
					} else {
						JOptionPane.showMessageDialog(getContentPane(), "No se ha introducido ningun texto", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						mensaje.setText("");
					}

				}

			}

		});

		estado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String linea = (String) estado.getSelectedItem();

				if (linea.equals("En linea")) {

					j.setEnLinea(true);

					gestion.modificarEstado(conexion, j);

					ArrayList<String> listaUsuarios = gestion.obtenerJugadoresLinea(conexion, j);

					DefaultListModel modelo = new DefaultListModel();

					for (String s : listaUsuarios) {
						modelo.addElement(s);
					}

					usuarios.setModel(modelo);

					usuariosLinea.setText("  Usuarios en linea: " + listaUsuarios.size());

					usuariosLinea.repaint();
					chatHilo hilo = new chatHilo(conexion, j, labelFondo, principal, usuarios, panelMensajes,
							getContentPane());

					hilo.start();

				} else {

					JOptionPane.showMessageDialog(getContentPane(),
							"Si estas desconectado, no recibiras ningun chat ni apareceras entre los usuarios en linea");

					j.setEnLinea(false);

					gestion.modificarEstado(conexion, j);

					ArrayList<String> listaUsuarios = gestion.obtenerJugadoresLinea(conexion, j);

					DefaultListModel modelo = new DefaultListModel();

					for (String s : listaUsuarios) {
						modelo.addElement(s);
					}

					usuarios.setModel(modelo);

					usuariosLinea.setText("  Usuarios en linea: " + listaUsuarios.size());

					usuariosLinea.repaint();

				}

			}
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				j.setEnLinea(false);

				gestion.modificarEstado(conexion, j);

			}

		});
		/*
		 * labelSalir.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { dispose();
		 * 
		 * } });
		 */

	}

	

}

package Proyecto.Cluedo.Ventanas;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;

import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import Proyecto.Cluedo.Datos.Genero;
import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;


public class VentanaRegistro extends JFrame {
	
	
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();
	
	private JRadioButton hombre= new JRadioButton("Hombre",true);
	
	private JRadioButton mujer = new JRadioButton("Mujer",false);
	
	private Usuario u;

	private JLabel botonRegistrar;
	
	
	private JLabel botonCancelar;
	
	private JTextField textoNombre;
	
	private JTextField textoApellido;
	
	private JTextField textoUsuario;
	
	private JTextField textoEmail;
	
	private JTextField textoRespuesta;
	
	private JPasswordField textoContraseña;

	private JPasswordField textoContraseña2;
	
	private JDateChooser fechas;
	
	private Icon iconoPerfil;
	
	private ImageIcon imagenPerfil = new ImageIcon();
	
	
	
	public VentanaRegistro (Connection conexion){
		
		//Inicializamos el frame
		
		setUndecorated(true);
		setResizable(false);
		setSize(new Dimension(600, 900));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		//Generamos los componentes
		
		JLabel nombre = new JLabel("Nombre: ");
		
		JLabel apellido = new JLabel("Apellido: ");
		
		JLabel usuario = new JLabel("Usuario: ");
		
		JLabel email = new JLabel("E-mail: ");
		
		JLabel fecha = new JLabel("Fecha Nacimiento: ");
		
		JLabel seguridad = new JLabel("Pregunta Seguridad: ");
		
		JLabel respuesta = new JLabel("Respuesta: ");
		
		
		
		JLabel genero = new JLabel("Genero: ");
		
		JLabel contraseña = new JLabel("Contraseña: ");
		
		JLabel contraseña2= new JLabel("Repite contraseña: ");
		
		
		
		
		textoApellido= new JTextField();
		
		textoContraseña= new JPasswordField();
		
		textoContraseña2= new JPasswordField();
		
		textoEmail= new JTextField();
		
		textoNombre= new JTextField();
		
		textoRespuesta= new JTextField();
		
		textoUsuario= new JTextField();
		
		
		
		botonRegistrar= new JLabel();
		
		botonCancelar= new JLabel();
		
		
		
		String [] preguntas = {"¿Como se llamaba tu primera mascota?","¿Como se llamaba tu primer profesor?","¿Donde hiciste el primer viaje en avion?"};
		
		JComboBox<String> listaPreguntas = new JComboBox<String>(preguntas);
		
		ImageIcon imagen = new ImageIcon();
		
		
		
		//JLabel labelPerfil= new JLabel();
		LabelPerfil labelPerfil;
		
		Icon iconoRegistrar;
		
		fechas= new JDateChooser();
		
		Icon iconoCancelar;
		
		//Establecemos el formato 
		
		getContentPane().setLayout(null);
		
		ButtonGroup botones= new ButtonGroup();
		
		botones.add(hombre);
		botones.add(mujer);
		
		hombre.setBounds(245, 594, 79, 23);
		
		
		mujer.setBounds(384, 594, 70, 23);
		
		
		try{
		imagenPerfil= new ImageIcon(VentanaRegistro.class.getResource("Imagenes/user.png"));
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		labelPerfil =  new LabelPerfil(imagenPerfil, 210, 57, 200, 200);
		
		//labelPerfil.setBounds(210, 57, 200, 200);
		
		//iconoPerfil= new ImageIcon(imagen.getImage().getScaledInstance(labelPerfil.getWidth(), labelPerfil.getHeight(), Image.SCALE_DEFAULT));
		
		//labelPerfil.setIcon(iconoPerfil);
		
		
		
		nombre.setFont(new Font("System", Font.PLAIN, 12));
		
		apellido.setFont(new Font("System", Font.PLAIN, 12));
		
		usuario.setFont(new Font("System", Font.PLAIN, 12));
		
		email.setFont(new Font("System", Font.PLAIN, 12));
		
		contraseña.setFont(new Font("System", Font.PLAIN, 12));
		
		contraseña2.setFont(new Font("System", Font.PLAIN, 12));
		
		genero.setFont(new Font("System", Font.PLAIN, 12));
		
		fecha.setFont(new Font("System", Font.PLAIN, 12));
		
		seguridad.setFont(new Font("System", Font.PLAIN, 12));
		
		respuesta.setFont(new Font("System", Font.PLAIN, 12));
		
		textoNombre.setBounds(226, 310, 296, 25);
		
		textoApellido.setBounds(226, 355, 296, 25);
		
		textoUsuario.setBounds(226, 405, 296, 25);
		
		textoEmail.setBounds(226, 457, 296, 25);
		
		textoContraseña.setBounds(226, 501, 296, 25);
		
		textoContraseña2.setBounds(226, 547, 296, 25);
		
		textoRespuesta.setBounds(226, 732, 296, 25);
		
		botonRegistrar.setBounds(138, 798, 170, 50);
		
		botonCancelar.setBounds(338	, 793, 178, 52);
		
		
		nombre.setBounds(115, 309, 65, 27);
		
		genero.setBounds(115,594,65,27);
		
		apellido.setBounds(115, 354, 65, 27);
		
		usuario.setBounds(115, 404, 98, 27);
		
		email.setBounds(115, 456, 65, 27);
		
		contraseña.setBounds(115, 500, 84, 27);
		
		contraseña2.setBounds(115, 546, 114, 27);
		
		fecha.setBounds(115, 641, 145, 17);
		
		seguridad.setBounds(115, 687, 145, 27);
		
		respuesta.setBounds(115,736,154,17);
		
		listaPreguntas.setBounds(237, 688, 285, 25);
		
		hombre.setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		mujer.setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		try {
			imagen = new ImageIcon(VentanaLogin.class.getResource("Imagenes/Iocno registro.png").toURI().toURL());
		} catch (Exception e) {
			System.out.println("No se ha encontrado el archivo");
		}
		
		
		
		iconoRegistrar= new ImageIcon(imagen.getImage().getScaledInstance(botonRegistrar.getWidth(), botonRegistrar.getHeight(), Image.SCALE_DEFAULT));
		
		botonRegistrar.setIcon(iconoRegistrar);
		
		fechas.setBounds(226, 641, 296, 25);

		fechas.setMaxSelectableDate(new Date(System.currentTimeMillis()));
		

		try {
			imagen = new ImageIcon(VentanaLogin.class.getResource("Imagenes/botonCancelar.png").toURI().toURL());
		} catch (Exception e) {
			System.out.println("No se ha encontrado el archivo");
		}
		
		
		
		iconoCancelar= new ImageIcon(imagen.getImage().getScaledInstance(botonCancelar.getWidth(), botonCancelar.getHeight(), Image.SCALE_DEFAULT));
		
		botonCancelar.setIcon(iconoCancelar);
		
		//Añadimos al panel
		
		getContentPane().add(textoApellido);
		
		getContentPane().add(textoContraseña);
		
		getContentPane().add(textoContraseña2);
		
		getContentPane().add(textoEmail);
		
		getContentPane().add(textoNombre);
		
		getContentPane().add(textoRespuesta);
		
		getContentPane().add(textoUsuario);
		
		getContentPane().add(nombre);
		
		getContentPane().add(apellido);
		
		getContentPane().add(fecha);
		
		getContentPane().add(usuario);
		
		getContentPane().add(contraseña);
		
		getContentPane().add(contraseña2);
		
		getContentPane().add(email);
		
		getContentPane().add(respuesta);
		
		getContentPane().add(listaPreguntas);
		
		getContentPane().add(hombre);
		
		getContentPane().add(mujer);
		
		getContentPane().add(genero);
		
		getContentPane().add(seguridad);
		
		getContentPane().add(labelPerfil);
		
		getContentPane().add(botonCancelar);
		
		getContentPane().add(botonRegistrar);
		
		getContentPane().add(fechas);
		
		
		
		
		
		//Eventos
		
		botonCancelar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				
			}
		});
		
	
	labelPerfil.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			
			JFileChooser elegidor= new JFileChooser();
			
			
			
			FileNameExtensionFilter filtro = new FileNameExtensionFilter(
				    "Imagenes", ImageIO.getReaderFileSuffixes());
			
			
			
			elegidor.setFileFilter(filtro);
			
			int valor = elegidor.showOpenDialog(null);
			
			if (valor==JFileChooser.APPROVE_OPTION){
				
				File fichero=elegidor.getSelectedFile();
				BufferedImage master= null;
				try {
					master= ImageIO.read(fichero);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "La imagen introducida no es correcta");
				}
				
			 
				imagenPerfil = new ImageIcon(master);
			
		        
		       // iconoPerfil= new ImageIcon(master.getScaledInstance(labelPerfil.getWidth(), labelPerfil.getHeight(), Image.SCALE_DEFAULT));
				
				labelPerfil.setImagen(imagenPerfil);
				

				
			}else{
				
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			ImageIcon imagenU= new ImageIcon();
			
			try{
				imagenU= new ImageIcon(VentanaRegistro.class.getResource("Imagenes/userSeleccionado.png").toURI().toURL());
			}catch (Exception e){
				System.out.println("No se ha encontrado el archivo");
			}
			
			
			//Icon iconoPulsado= new ImageIcon(imagenU.getImage().getScaledInstance(labelPerfil.getWidth(), labelPerfil.getHeight(), Image.SCALE_DEFAULT));
			labelPerfil.setImagen(imagenU);
			
			
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
			labelPerfil.setImagen(imagenPerfil);
			
		}

		
	});
	
	botonRegistrar.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			boolean correccion= comprobacion();
			
			if (correccion){
				Usuario u = new Usuario(textoNombre.getText(), textoApellido.getText(), textoUsuario.getText(), obtenerContraseña(textoContraseña.getPassword()), obtenerGenero (), fechas.getDate(), textoRespuesta.getText(),listaPreguntas.getSelectedIndex(), textoEmail.getText(), imagenPerfil,0);
				u.setConexion(new Date(System.currentTimeMillis()));
				
				if (gestion.insertarUsuario(conexion, u)){
					JOptionPane.showMessageDialog(getContentPane(), "Se ha registrado correctamente, empiece a jugar", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else{
					JOptionPane.showMessageDialog(getContentPane(), "El nombre de usuario ya esta cogido", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		}
	});
	
	
		
	}
	
	public boolean comprobacion(){
		
		String texto = null;
		boolean correcto=true;
		
		
		if (textoNombre.getText().trim().length()==0){
			texto = "No se ha introducido el nombre, compruebelo de nuevo";
			correcto=false;
		}else if (textoApellido.getText().trim().length()==0){
			texto= "No se ha introducido el apellido, compruebelo de nuevo";
			correcto=false;
		}else if (textoUsuario.getText().trim().length()==0){
			texto= "No se ha introducido el usuario, compruebelo de nuevo";
			correcto=false;
		}else if (textoEmail.getText().trim().length()==0){
			texto= "No se ha introducido el e-mail, compruebelo de nuevo";
			correcto=false;
		}else if (obtenerContraseña(textoContraseña.getPassword()).trim().length()==0){
			texto= "No se ha introducido la contraseña, compruebelo de nuevo";
			correcto=false;
		}else if (obtenerContraseña(textoContraseña2.getPassword()).trim().length()==0){
			texto= "No se ha introducido la verificacion de la contraseña, compruebelo de nuevo";
			correcto=false;
		}else if (textoRespuesta.getText().trim().length()==0){
			texto= "No se ha introducido la respuesta a la pregunta de seguridad, compruebelo de nuevo";
			correcto=false;
		}else if (!(obtenerContraseña(textoContraseña.getPassword()).equals(obtenerContraseña(textoContraseña2.getPassword())))){
			texto="No coinciden las contraseñas compruebelo de nuevo";
			correcto=false;
		}else if (fechas.getDate()==null){
			texto="Introduzca la fecha de nacimiento";
			correcto=false;
		}
		
		if (!(correcto)){
			JOptionPane.showMessageDialog(null, texto,"Comprobacion" , JOptionPane.INFORMATION_MESSAGE);
			return correcto;
		}else{
			return correcto;
		}
	}
	
	private Genero obtenerGenero (){
		if (hombre.isSelected()){
			return Genero.HOMBRE;
			
		}else{
			return Genero.MUJER;
		}
	}
	
	private String obtenerContraseña(char[] contraseña) {
		String contraseñaTexto = "";

		for (int i = 0; i < contraseña.length; i++) {
			contraseñaTexto = contraseñaTexto + contraseña[i];
		}

		return contraseñaTexto;
	}
}
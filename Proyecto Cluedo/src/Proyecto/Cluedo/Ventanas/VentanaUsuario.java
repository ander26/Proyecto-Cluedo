package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;

public class VentanaUsuario extends JFrame {

	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();

	private LabelPerfil labelPerfil;

	private JLabel labelBorrar = new JLabel();

	private JLabel labelModificar = new JLabel();

	private JLabel labelHueco = new JLabel();

	private static final int ANCHURA = 500;

	private static final int ALTURA = 420;

	private static final int ANCHURALABEL = 235;

	private static final int ALTURALABEL = 235;

	private static final int XLABEL = 133;

	private static final int YLABEL = 7;

	private ImageIcon imagenPerfil = new ImageIcon();

	public VentanaUsuario(Connection conexion, Usuario u) {
		
		

		// Establecemos el formato del panel

		setSize(new Dimension(ANCHURA, ALTURA));

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setResizable(true);

		setLocation(new Point(1400, 30));

		setMinimumSize(new Dimension(ANCHURA, ALTURA));

		// Generamos los componentes
		imagenPerfil = u.getImagenPerfil();
		
		ImageIcon imicon = new ImageIcon(VentanaUsuario.class.getResource("Imagenes/8145561.jpg"));

		panelrosa panelCentro = new panelrosa(imicon.getImage());

		imicon = new ImageIcon(VentanaUsuario.class.getResource("Imagenes/black 5.jpg"));

		panelrosa panelBotonera = new panelrosa(imicon.getImage());

		ImageIcon imagen = new ImageIcon();

		// 100,5,300,300
		labelPerfil = new LabelPerfil(u.getImagenPerfil(), 133, 7, 218, 218);

		// Establecemos el formato

		panelCentro.setBackground(Color.white);

		imicon = new ImageIcon(VentanaUsuario.class.getResource("Imagenes/borrar.png"));

		labelBorrar.setSize(60, 60);
		Icon icono = new ImageIcon(imicon.getImage().getScaledInstance(labelBorrar.getWidth(), labelBorrar.getHeight(),
				Image.SCALE_DEFAULT));
		labelBorrar.setIcon(icono);

		imicon = new ImageIcon(ventana.class.getResource("Imagenes/modificar.png"));
		labelModificar.setSize(50, 55);
		icono = new ImageIcon(imicon.getImage().getScaledInstance(labelModificar.getWidth(), labelModificar.getHeight(),
				Image.SCALE_DEFAULT));
		labelModificar.setIcon(icono);

		labelHueco.setSize(60, 60);

		labelHueco.setText("       ");

		labelPerfil.setAlignmentY(CENTER_ALIGNMENT);

		// Añadimos los paneles

		getContentPane().setLayout(new BorderLayout());

		panelCentro.setLayout(null);

		
		
		getContentPane().add(panelCentro, BorderLayout.CENTER);

		getContentPane().add(panelBotonera, BorderLayout.SOUTH);

		panelBotonera.add(labelBorrar);

		panelBotonera.add(labelHueco);
		panelBotonera.add(labelModificar);
		
		panelCentro.add(labelPerfil);

		// Generamos los eventos
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) { // Al
																// redimensionarse
																// el panel,
																// reajustamos
																// sus
																// componentes

				double escalaX = getContentPane().getWidth() / (double) ANCHURA; // Nueva
																					// escala
																					// X
				double escalaY = (getContentPane().getHeight() - 60) / (double) (ALTURA - 60); // Nueva
																								// escala
																								// Y

				panelCentro.remove(labelPerfil);
				labelPerfil = new LabelPerfil(u.getImagenPerfil(), (int) (XLABEL * escalaX), (int) (YLABEL * escalaY),
						(int) (ANCHURALABEL * escalaY), (int) (ALTURALABEL * escalaX));
				
				panelCentro.add(labelPerfil);
				
				labelPerfil.addMouseListener(new MouseAdapter(){

					@Override
					public void mouseExited(MouseEvent e) {
						labelPerfil.setImagen(imagenPerfil);

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						
						ImageIcon imagenU= new ImageIcon();
						
						try{
							imagenU= new ImageIcon(VentanaRegistro.class.getResource("Imagenes/userSeleccionado.png").toURI().toURL());
						}catch (Exception t){
							System.out.println("No se ha encontrado el archivo");
						}
						
						
						//Icon iconoPulsado= new ImageIcon(imagenU.getImage().getScaledInstance(labelPerfil.getWidth(), labelPerfil.getHeight(), Image.SCALE_DEFAULT));
						labelPerfil.setImagen(imagenU);
						

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						JFileChooser elegidor = new JFileChooser();

						FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes",
								ImageIO.getReaderFileSuffixes());

						elegidor.setFileFilter(filtro);

						int valor = elegidor.showOpenDialog(null);

						if (valor == JFileChooser.APPROVE_OPTION) {

							File fichero = elegidor.getSelectedFile();
							BufferedImage master = null;
							try {
								master = ImageIO.read(fichero);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "La imagen introducida no es correcta");
							}

							imagenPerfil = new ImageIcon(master);

							// iconoPerfil= new
							// ImageIcon(master.getScaledInstance(labelPerfil.getWidth(),
							// labelPerfil.getHeight(), Image.SCALE_DEFAULT));

							labelPerfil.setImagen(imagenPerfil);

							u.setImagenPerfil(imagenPerfil);

							gestion.cambiarFoto(conexion, u);

						}
					}
					
				});
				
				
			}
		});
		
//		labelPerfil.addMouseListener(new MouseAdapter(){
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				labelPerfil.setImagen(imagenPerfil);
//
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				System.out.println(1);
//				ImageIcon imagenU= new ImageIcon();
//				
//				try{
//					imagenU= new ImageIcon(VentanaRegistro.class.getResource("Imagenes/userSeleccionado.png").toURI().toURL());
//				}catch (Exception t){
//					System.out.println("No se ha encontrado el archivo");
//				}
//				
//				
//				//Icon iconoPulsado= new ImageIcon(imagenU.getImage().getScaledInstance(labelPerfil.getWidth(), labelPerfil.getHeight(), Image.SCALE_DEFAULT));
//				labelPerfil.setImagen(imagenU);
//				
//
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				JFileChooser elegidor = new JFileChooser();
//
//				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes",
//						ImageIO.getReaderFileSuffixes());
//
//				elegidor.setFileFilter(filtro);
//
//				int valor = elegidor.showOpenDialog(null);
//
//				if (valor == JFileChooser.APPROVE_OPTION) {
//
//					File fichero = elegidor.getSelectedFile();
//					BufferedImage master = null;
//					try {
//						master = ImageIO.read(fichero);
//					} catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, "La imagen introducida no es correcta");
//					}
//
//					imagenPerfil = new ImageIcon(master);
//
//					// iconoPerfil= new
//					// ImageIcon(master.getScaledInstance(labelPerfil.getWidth(),
//					// labelPerfil.getHeight(), Image.SCALE_DEFAULT));
//
//					labelPerfil.setImagen(imagenPerfil);
//
//					u.setImagenPerfil(imagenPerfil);
//
//					gestion.cambiarFoto(conexion, u);
//
//				}
//			}
//		});
//
//
		labelBorrar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int valor = JOptionPane.showConfirmDialog(getContentPane(),
						"¿Estas seguro de querer borrar definitivamente el usuario?", "Aviso",
						JOptionPane.YES_NO_OPTION);

				if (valor == JOptionPane.YES_OPTION) {
					gestion.borrarUsuario(conexion, u);

					for (Window window : Window.getWindows()) {
						window.dispose();
					}

					VentanaLogin ventana = new VentanaLogin(conexion);
					ventana.setVisible(true);

				}
			}

		});

		labelModificar.addMouseListener(new MouseAdapter() {

			String [] opciones ={"Nombre","Apellido","Contraseña","Email"};
			@Override
			public void mouseClicked(MouseEvent e) {

			    String cambio = (String) JOptionPane.showInputDialog(getContentPane(), 
			            "¿Que valor desea modificar?",
			            "Cambio",
			            JOptionPane.QUESTION_MESSAGE, 
			            null, 
			            opciones, 
			            opciones[0]);
			    if (cambio!=null){
			    switch (cambio){
			    
			    case "Nombre": 
			    	String name = JOptionPane.showInputDialog(getContentPane(), "Introduzca el nombre: ");
			    	
			    	if (name.trim().length()>0){
			    		
			    		gestion.modificar(conexion, "USUARIO", "NOMBRE='"+name+"'", "NOMBREUSUARIO='"+u.getUsuario()+"'");
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Se ha modificado correctamente el nombre");
			    		
			    	}else {
			    		JOptionPane.showMessageDialog(getContentPane(), "No se ha introducido ningun valor");
			    	}
			    	break;
			    
			    case "Apellido":
			    	
			    	String apellido = JOptionPane.showInputDialog(getContentPane(), "Introduzca el apellido: ");
			    	
			    	if (apellido.trim().length()>0){
			    		
			    		gestion.modificar(conexion, "USUARIO", "APELLIDO='"+apellido+"'", "NOMBREUSUARIO='"+u.getUsuario()+"'");
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Se ha modificado correctamente el apellido");
			    		
			    	}else {
			    		JOptionPane.showMessageDialog(getContentPane(), "No se ha introducido ningun valor");
			    	}
			    	break;
			    	
			    case "Contraseña":
			    	String contraseña = JOptionPane.showInputDialog(getContentPane(), "Introduzca la contraseña: ");
			    	
			    	if (contraseña.trim().length()>0){
			    		
			    		gestion.modificar(conexion, "USUARIO", "CONTRASEÑA='"+contraseña+"'", "NOMBREUSUARIO='"+u.getUsuario()+"'");
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Se ha modificado correctamente la contraseña");
			    	}else {
			    		JOptionPane.showMessageDialog(getContentPane(), "No se ha introducido ningun valor");
			    	}
			    	break;
			    	
			    case "Email":
			    	
			    	String email = JOptionPane.showInputDialog(getContentPane(), "Introduzca el email: ");
			    	
			    	if (email.trim().length()>0){
			    		gestion.modificar(conexion, "USUARIO", "EMAIL='"+email+"'", "NOMBREUSUARIO='"+u.getUsuario()+"'");
			    		
			    		JOptionPane.showMessageDialog(getContentPane(), "Se ha modificado correctamente el email");
			    	}else {
			    		JOptionPane.showMessageDialog(getContentPane(), "No se ha introducido ningun valor");
			    	}
			    	break;
			    
			    }
			    
			}
			    }
			
			
		});




	}

}

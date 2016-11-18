package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;

public class VentanaUsuario extends JFrame{
	
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();

	private LabelPerfil labelPerfil;
	
	private JLabel labelBorrar = new JLabel();
	
	private JLabel labelModificar = new JLabel();
	
	private JLabel labelHueco = new JLabel();
	
	private static final int ANCHURA = 500;
	
	private static final int ALTURA = 420;
	
	
	
	
	
	public VentanaUsuario (Connection conexion, Usuario u){
		
		//Establecemos el formato del panel 
		
		setSize(new Dimension(ANCHURA, ALTURA));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setResizable(true);
		
		setLocation(new Point(1400, 30));
		
		setMinimumSize(new Dimension(ANCHURA, ALTURA));
		
		//Generamos los componentes
		
		ImageIcon imicon = new ImageIcon(VentanaUsuario.class.getResource("Imagenes/8145561.jpg"));		
		
		
		panelrosa panelCentro = new panelrosa(imicon.getImage());
		
		imicon = new ImageIcon(VentanaUsuario.class.getResource("Imagenes/black 5.jpg"));
		
		panelrosa panelBotonera = new panelrosa(imicon.getImage());
		
		JPanel panelPerfil = new JPanel();
	
		
		ImageIcon imagen= new ImageIcon ();
		
		//100,5,300,300
		labelPerfil= new LabelPerfil(u.getImagenPerfil(),133, 7, 218, 218);
		
		
		//Establecemos el formato
		
		panelCentro.setBackground(Color.white);
		
		
		
		imicon = new ImageIcon(VentanaUsuario.class.getResource("Imagenes/borrar.png"));		
		
		labelBorrar.setSize(60,60);
		Icon icono = new ImageIcon(imicon.getImage().getScaledInstance(labelBorrar.getWidth()	, labelBorrar.getHeight(), Image.SCALE_DEFAULT));
		labelBorrar.setIcon(icono);

		imicon = new ImageIcon(ventana.class.getResource("Imagenes/modificar.png"));		
		labelModificar.setSize(50,55);
		icono = new ImageIcon(imicon.getImage().getScaledInstance(labelModificar.getWidth()	, labelModificar.getHeight(), Image.SCALE_DEFAULT));
		labelModificar.setIcon(icono);
		
		labelHueco.setSize(60	,60);
		
		labelHueco.setText("       ");
		
		panelPerfil.setBackground(null);
		
		labelPerfil.setAlignmentY(CENTER_ALIGNMENT);
		
		
		//Añadimos los paneles
		
		getContentPane().setLayout(new BorderLayout());
		
		panelCentro.setLayout(null);
		
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		getContentPane().add(panelBotonera, BorderLayout.SOUTH);
		
		panelBotonera.add(labelBorrar);
		
		panelBotonera.add(labelHueco);
		panelBotonera.add(labelModificar);
		
		
		panelCentro.add(labelPerfil);
		
		
		
		//Generamos los eventos 
		
		
		labelBorrar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int valor = JOptionPane.showConfirmDialog(getContentPane(), "¿Estas seguro de querer borrar definitivamente el usuario?","Aviso",JOptionPane.YES_NO_CANCEL_OPTION);
				
				if (valor==JOptionPane.YES_OPTION){
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

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
	}
	
}


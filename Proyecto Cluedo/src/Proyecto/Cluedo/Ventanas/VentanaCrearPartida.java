package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Hilo.comprobador;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Logica.Propiedades;

public class VentanaCrearPartida extends JFrame {
	
	/**
	 * Atributo a traves del cual se gestiona la base de datos 
	 */
	
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();
	
	/**
	 * Parametro que contiene la foto de las fichas
	 */
	
	private ImageIcon [] listaDeFichas = {new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/coche.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/barco.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/dedal.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/sombrero.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/perro.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/zapato.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/plancha.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/carretilla.png"))
			};

	
	/**
	 * Parametro que contiene el nombre de las fichas 
	 */
	
	private String [] listaTipos = {"Imagenes/coche.png","Imagenes/barco.png","Imagenes/dedal.png","Imagenes/sombrero.png",
			"Imagenes/perro.png","Imagenes/zapato.png","Imagenes/plancha.png","Imagenes/carretilla.png"};
	
	
	private String [] fichas = {"Coche","Barco","Dedal","Sombrero","Perro","Zapato","Plancha","Carretilla"};
	
	/**
	 * Parametro que contiene la ficha seleccionada 
	 */
	
	private int contador =1;
	
	private ImageIcon imagen = new ImageIcon();
	
	private JLabel labelSeleccionado= new JLabel();
	
	private Icon iconoSeleccionado;
	

	public VentanaCrearPartida (Connection conexion, Usuario u,GestionBaseDeDatos base){
		
		//Inicializamos el frame
		
		setSize(new Dimension(900, 630));
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		getContentPane().setLayout(null);
		
		setResizable(false);
		//setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		//setUndecorated (true)
		//Generamos los componentes
		
		JFrame v=this;
		
		JLabel labelFondo = new JLabel();
		
		Icon iconoFondo;
		
		JLabel titulo = new JLabel("CREACION DE PARTIDA");
		
		JLabel labelNombre = new JLabel("Nombre partida: ");
		
		JLabel labelJugadores = new JLabel("Jugadores: ");
		
		JTextField textoNombre = new JTextField();
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 2, 5, 3);
		
		JLabel labelPodium = new JLabel();
		
		Icon iconoPodium;
		
		
		JLabel labelSlider = new JLabel();
		
		Icon iconoSlider;
		
		JLabel labelSliderGirado = new JLabel();
		
		Icon iconoSliderGirado;
		
		JLabel labelEtiqueta = new JLabel();
		
		Icon iconoEtiqueta;
		
		JLabel labelTipo = new JLabel();
		
		JLabel labelCrear = new JLabel();
		
		Icon iconoCrear;
		
		
		
		JLabel labelCancelar = new JLabel();
		
		Icon iconoCancelar;
		
		//Damos formato a los componentes
		
		//slider.setBackground(Color.white);
		
		Hashtable labelTable = new Hashtable();
		
		labelTable.put( new Integer( 2 ), new JLabel("2") );
		labelTable.put( new Integer( 3 ), new JLabel("3") );
		labelTable.put( new Integer( 4 ), new JLabel("4") );
		labelTable.put( new Integer( 5 ), new JLabel("5") );
		
		slider.setLabelTable( labelTable );
		
		titulo.setFont(new Font ("Berlin Sans FB Demi",Font.BOLD,38));
		
		titulo.setBounds(240, 105, 448, 55);
		
		labelNombre.setFont(new Font("System", Font.BOLD, 13));
		
		labelNombre.setBounds(174, 172, 121, 17);
		
		textoNombre.setBounds(321, 170, 268, 25);
		
		labelJugadores.setBounds(175,211,121,17);
		
		labelJugadores.setFont(new Font("System", Font.BOLD, 13));
		
		slider.setBounds(316,208,283,38);
		
		slider.setPaintLabels(true);
		
		labelFondo.setBounds(0, 0, 900, 600);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/fondo.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		iconoFondo= new ImageIcon(imagen.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
		
		labelFondo.setIcon(iconoFondo);
		
		labelPodium.setBounds(264, 388, 352, 219);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/podium.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		iconoPodium= new ImageIcon(imagen.getImage().getScaledInstance(labelPodium.getWidth(), labelPodium.getHeight(), Image.SCALE_DEFAULT));
		
		labelPodium.setIcon(iconoPodium);
		
		labelSeleccionado.setBounds(335, 239, 200,200 );
		
		try{
			imagen= new ImageIcon(listaDeFichas[contador].getImage());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		iconoSeleccionado= new ImageIcon(imagen.getImage().getScaledInstance(labelSeleccionado.getWidth(), labelSeleccionado.getHeight(), Image.SCALE_DEFAULT));
		
		labelSeleccionado.setIcon(iconoSeleccionado);
		
		
		
		labelEtiqueta.setBounds(226, 442, 428, 60);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/etiqueta.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		iconoEtiqueta= new ImageIcon(imagen.getImage().getScaledInstance(labelEtiqueta.getWidth(), labelEtiqueta.getHeight(), Image.SCALE_DEFAULT));
		
		labelEtiqueta.setIcon(iconoEtiqueta);
		
		
		labelSliderGirado.setBounds(80, 281, 173, 158);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/slider girado.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		
		iconoSliderGirado= new ImageIcon(imagen.getImage().getScaledInstance(labelSliderGirado.getWidth(), labelSliderGirado.getHeight(), Image.SCALE_DEFAULT));
		
		labelSliderGirado.setIcon(iconoSliderGirado);
		
		labelSlider.setBounds(648, 281, 173, 158);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/slider.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		
		iconoSlider= new ImageIcon(imagen.getImage().getScaledInstance(labelSlider.getWidth(), labelSlider.getHeight(), Image.SCALE_DEFAULT));
		
		labelSlider.setIcon(iconoSlider);
		
		labelTipo.setBounds(408, 465, 110, 17);
		
		
		
		labelTipo.setText(fichas[contador]);
		
		labelTipo.setForeground(Color.white);
		
		labelTipo.setFont(new Font("System", Font.BOLD, 22));
		
		labelCrear.setBounds(370, 530, 75, 75);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/create.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		
		iconoCrear= new ImageIcon(imagen.getImage().getScaledInstance(labelCrear.getWidth(), labelCrear.getHeight(), Image.SCALE_DEFAULT));
		
		labelCrear.setIcon(iconoCrear);
		
		labelCancelar.setBounds(440, 546, 43, 43);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/back.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		
		iconoCancelar= new ImageIcon(imagen.getImage().getScaledInstance(labelCancelar.getWidth(), labelCancelar.getHeight(), Image.SCALE_DEFAULT));
		
		labelCancelar.setIcon(iconoCancelar);
		
		//Añadimos al panel
		
		getContentPane().add(labelCancelar);
		getContentPane().add(labelCrear);
		getContentPane().add(labelSeleccionado);
		getContentPane().add(labelTipo);
		getContentPane().add(labelEtiqueta);
		
		getContentPane().add(titulo);
		getContentPane().add(labelNombre);
		getContentPane().add(labelJugadores);
		
		getContentPane().add(slider);
		getContentPane().add(textoNombre);
		
		getContentPane().add(labelCrear);
		getContentPane().add(labelPodium);
		//getContentPane().add(labelSiguiente);
		//getContentPane().add(labelAnterior);
		getContentPane().add(labelSlider);
		
		getContentPane().add(labelSliderGirado);
		getContentPane().add(labelFondo);
		
		//Generamos los eventos
		
		labelCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textoNombre.getText().trim().equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "Debe introducir el nombre de la partida para poder crear una","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else{
					
					Insets insets2 = v.getInsets();

					System.out.println(insets2.top);
					for (Window window : Window.getWindows()) {
					    window.dispose();
					}
					
					Partida p= new Partida(slider.getValue(), textoNombre.getText(),conexion);
					
					gestion.insertarPartida(conexion, p);
					
					Jugador j = new Jugador(listaTipos[contador],u.getUsuario(),p.getCodigo(),conexion);
					
					gestion.insertarJugador(conexion, j, p, u);
					
					VentanaConectando ventana = new VentanaConectando();
					
					Propiedades prop=new Propiedades(6,8,7,p.getNumeroJugadoresMaximo(),conexion,gestion,p);
					

					
					comprobador comp= new comprobador(p,conexion,j,u,base,prop,insets2.top);
					
					
					
					
					comp.start();
					
					
					
					ventana.setVisible(true);
					
					ventana.revalidate();
					

					
//					
//					if (! (comp.isAlive())){
//						
//					}
//					
				
					
					
					
				}
			}
		});
		
		labelCancelar.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
		});
		
		labelSlider.addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contador++;
				
				if (contador>7){
					contador=0;
				}
				
				
				try{
					imagen= new ImageIcon(listaDeFichas[contador].getImage());
				}catch (Exception a){
					System.out.println("No se ha encontrado el recurso");
				}
				
				
				iconoSeleccionado= new ImageIcon(imagen.getImage().getScaledInstance(labelSeleccionado.getWidth(), labelSeleccionado.getHeight(), Image.SCALE_DEFAULT));
				
				labelSeleccionado.setIcon(iconoSeleccionado);
				
				
				labelTipo.setText(fichas[contador]);
				
			}
		});
		
		labelSliderGirado.addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contador--;
				
				if (contador<0){
					contador=7;
				}
				
				
				try{
					imagen= new ImageIcon(listaDeFichas[contador].getImage());
				}catch (Exception a){
					System.out.println("No se ha encontrado el recurso");
				}
				
				
				iconoSeleccionado= new ImageIcon(imagen.getImage().getScaledInstance(labelSeleccionado.getWidth(), labelSeleccionado.getHeight(), Image.SCALE_DEFAULT));
				
				labelSeleccionado.setIcon(iconoSeleccionado);
				
				
				labelTipo.setText(fichas[contador]);
				
			}
		});
	}
	
}
//	
//	class pintar extends Thread {
//		
//		/**
//		 * Parametro que le indica al hilo cuando acabar 
//		 */
//		
//		public boolean acabar;
//		
//		private VentanaConectando ventana=new VentanaConectando();
//	
//		
//		public pintar (boolean acabar){
//			this.acabar=acabar;
//		}
//		
//		public void run (){
//		
//			while (acabar){
//				ventana.setVisible(true);
//			}
//	
//	
//	}
//	
//		public void setAcabar (boolean acabar){
//			this.acabar=acabar;
//		}
//	}
	



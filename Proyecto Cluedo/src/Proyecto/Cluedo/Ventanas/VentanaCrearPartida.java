package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.attribute.FileOwnerAttributeView;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class VentanaCrearPartida extends JFrame {
	
	private ImageIcon [] listaDeFichas = {new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/coche.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/barco.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/dedal.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/sombrero.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/perro.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/zapato.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/plancha.png")),
			new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/carretilla.png"))
			};

	
	private String [] listaTipos = {"Coche","Barco","Dedal","Sombrero","Perro","Zapato","Plancha","Carretilla"};
	
	private int contador =1;
	
	private ImageIcon imagen = new ImageIcon();
	
	private JLabel labelSeleccionado= new JLabel();
	
	private Icon iconoSeleccionado;
	
	private JLabel labelAnterior = new JLabel();
	
	private Icon iconoAnterior;
	
	private JLabel labelSiguiente = new JLabel();
	
	private Icon iconoSiguiente;
	
	public static void main (String [] args){
		
		VentanaCrearPartida ventana= new VentanaCrearPartida();
		ventana.setVisible(true);
		
	}
	
	public VentanaCrearPartida (){
		
		//Inicializamos el frame
		
		setSize(new Dimension(900, 600));
		
		setUndecorated(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		//Generamos los componentes
		
		
		
		JLabel labelFondo = new JLabel();
		
		Icon iconoFondo;
		
		JLabel titulo = new JLabel("CREACION DE PARTIDA");
		
		JLabel labelNombre = new JLabel("Nombre partida: ");
		
		JLabel labelJugadores = new JLabel("Jugadores: ");
		
		JTextField textoNombre = new JTextField();
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 2, 4, 3);
		
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
		
		titulo.setFont(new Font ("Berlin Sans FB Demi",Font.BOLD,38));
		
		titulo.setBounds(224, 89, 448, 55);
		
		labelNombre.setFont(new Font("System", Font.BOLD, 13));
		
		labelNombre.setBounds(174, 172, 121, 17);
		
		textoNombre.setBounds(321, 159, 268, 25);
		
		labelJugadores.setBounds(175,211,121,17);
		
		labelJugadores.setFont(new Font("System", Font.BOLD, 13));
		
		slider.setBounds(316,208,283,38);
		
		slider.setPaintLabels(true);
		
		labelFondo.setBounds(0, 0, 900, 600);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/fondo.jpg").toURI().toURL());
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
		
		labelSeleccionado.setBounds(335, 243, 214,229 );
		
		try{
			imagen= new ImageIcon(listaDeFichas[contador].getImage());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		iconoSeleccionado= new ImageIcon(imagen.getImage().getScaledInstance(labelSeleccionado.getWidth(), labelSeleccionado.getHeight(), Image.SCALE_DEFAULT));
		
		labelSeleccionado.setIcon(iconoSeleccionado);
		
		labelSiguiente.setBounds(562, 294, 141, 146);
		
		try{
			imagen= new ImageIcon(listaDeFichas[contador+1].getImage());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		iconoSiguiente= new ImageIcon(imagen.getImage().getScaledInstance(labelSiguiente.getWidth(), labelSiguiente.getHeight(), Image.SCALE_DEFAULT));
		
		labelSiguiente.setIcon(iconoSiguiente);
		
		labelAnterior.setBounds(200, 294, 141, 146);
		
		try{
			imagen= new ImageIcon(listaDeFichas[contador-1].getImage());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		iconoAnterior= new ImageIcon(imagen.getImage().getScaledInstance(labelAnterior.getWidth(), labelAnterior.getHeight(), Image.SCALE_DEFAULT));
		
		labelAnterior.setIcon(iconoAnterior);
		
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
		
		labelTipo.setBounds(408, 460, 91, 17);
		
		labelTipo.setText(listaTipos[contador]);
		
		labelTipo.setForeground(Color.white);
		
		labelTipo.setFont(new Font("System", Font.BOLD, 22));
		
		labelCrear.setBounds(349, 503, 91, 85);
		
		try{
			imagen= new ImageIcon(VentanaCrearPartida.class.getResource("Imagenes/create.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el recurso");
		}
		
		
		iconoCrear= new ImageIcon(imagen.getImage().getScaledInstance(labelCrear.getWidth(), labelCrear.getHeight(), Image.SCALE_DEFAULT));
		
		labelCrear.setIcon(iconoCrear);
		
		labelCancelar.setBounds(459, 518, 59, 55);
		
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
		getContentPane().add(labelSiguiente);
		getContentPane().add(labelAnterior);
		getContentPane().add(labelSlider);
		
		getContentPane().add(labelSliderGirado);
		
		
		
		
		
		
		
		
		getContentPane().add(labelFondo);
		
		//Generamos los eventos
		
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
					imagen= new ImageIcon(listaDeFichas[contador-1].getImage());
				}catch (Exception a){
					System.out.println("No se ha encontrado el recurso");
				}
				
				
				iconoAnterior= new ImageIcon(imagen.getImage().getScaledInstance(labelAnterior.getWidth(), labelAnterior.getHeight(), Image.SCALE_DEFAULT));
				
				labelAnterior.setIcon(iconoAnterior);
				
				try{
					imagen= new ImageIcon(listaDeFichas[contador].getImage());
				}catch (Exception a){
					System.out.println("No se ha encontrado el recurso");
				}
				
				
				iconoSeleccionado= new ImageIcon(imagen.getImage().getScaledInstance(labelSeleccionado.getWidth(), labelSeleccionado.getHeight(), Image.SCALE_DEFAULT));
				
				labelSeleccionado.setIcon(iconoSeleccionado);
				
				try{
					imagen= new ImageIcon(listaDeFichas[contador+1].getImage());
				}catch (Exception a){
					System.out.println("No se ha encontrado el recurso");
				}
				
				
				iconoSiguiente= new ImageIcon(imagen.getImage().getScaledInstance(labelSiguiente.getWidth(), labelSiguiente.getHeight(), Image.SCALE_DEFAULT));
				
				labelSiguiente.setIcon(iconoSiguiente);
				
				labelTipo.setText(listaTipos[contador]);
				
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
					imagen= new ImageIcon(listaDeFichas[contador-1].getImage());
				}catch (Exception a){
					System.out.println("No se ha encontrado el recurso");
				}
				
				
				iconoAnterior= new ImageIcon(imagen.getImage().getScaledInstance(labelAnterior.getWidth(), labelAnterior.getHeight(), Image.SCALE_DEFAULT));
				
				labelAnterior.setIcon(iconoAnterior);
				
				try{
					imagen= new ImageIcon(listaDeFichas[contador].getImage());
				}catch (Exception a){
					System.out.println("No se ha encontrado el recurso");
				}
				
				
				iconoSeleccionado= new ImageIcon(imagen.getImage().getScaledInstance(labelSeleccionado.getWidth(), labelSeleccionado.getHeight(), Image.SCALE_DEFAULT));
				
				labelSeleccionado.setIcon(iconoSeleccionado);
				
				try{
					imagen= new ImageIcon(listaDeFichas[contador+1].getImage());
				}catch (Exception a){
					System.out.println("No se ha encontrado el recurso");
				}
				
				
				iconoSiguiente= new ImageIcon(imagen.getImage().getScaledInstance(labelSiguiente.getWidth(), labelSiguiente.getHeight(), Image.SCALE_DEFAULT));
				
				labelSiguiente.setIcon(iconoSiguiente);
				
				labelTipo.setText(listaTipos[contador]);
				
			}
		});
	}
}

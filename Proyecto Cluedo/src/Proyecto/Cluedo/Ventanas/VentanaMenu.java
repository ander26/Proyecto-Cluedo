package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaMenu extends JFrame{

	public static void main (String [] args){
		VentanaMenu ventana = new VentanaMenu();
		ventana.setVisible(true);
	}
	
	public VentanaMenu(){
		
		//Inicializamos el frame 
		setSize(600,400);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		
		//Generamos los componentes
		
		ImageIcon imagen= new ImageIcon ();
		
		JLabel labelFoto= new JLabel();
		
		Icon iconoFoto;
		
		JLabel labelTitulo= new JLabel();
		
		Icon iconoTitulo;
		
		JLabel labelEmpezar= new JLabel();
		
		Icon iconoEmpezar;
		
		JLabel labelConfiguracion= new JLabel();
		
		Icon iconoConfiguracion;
		
		JLabel labelEstadistica= new JLabel();
		
		Icon iconoEstadistica;
		
		JLabel labelPerfil= new JLabel();
		
		Icon iconoPerfil;
		
		JLabel labelCerrar= new JLabel();
		
		Icon iconoCerrar;
		
		//Establecemos el formato
		
		labelFoto.setBounds(67, 154, 466, 265);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/Menu.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoFoto= new ImageIcon(imagen.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
		
		labelFoto.setIcon(iconoFoto);
		
		labelTitulo.setBounds(143, 0, 320, 170);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/multiplayer.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoTitulo= new ImageIcon(imagen.getImage().getScaledInstance(labelTitulo.getWidth(), labelTitulo.getHeight(), Image.SCALE_DEFAULT));
		
		labelTitulo.setIcon(iconoTitulo);
		
		labelEmpezar.setBounds(266, 130, 68, 60);
		

		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/play.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoEmpezar= new ImageIcon(imagen.getImage().getScaledInstance(labelEmpezar.getWidth(), labelEmpezar.getHeight(), Image.SCALE_DEFAULT));
		
		labelEmpezar.setIcon(iconoEmpezar);
		
		labelConfiguracion.setBounds(555, 67, 24, 24);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/configuracion.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoConfiguracion= new ImageIcon(imagen.getImage().getScaledInstance(labelConfiguracion.getWidth(), labelConfiguracion.getHeight(), Image.SCALE_DEFAULT));
		
		labelConfiguracion.setIcon(iconoConfiguracion);
		
		labelEstadistica.setBounds(556, 108, 24, 24);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/trofeo.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoEstadistica= new ImageIcon(imagen.getImage().getScaledInstance(labelEstadistica.getWidth(), labelEstadistica.getHeight(), Image.SCALE_DEFAULT));
		
		labelEstadistica.setIcon(iconoEstadistica);
		
		labelPerfil.setBounds(556, 26, 24, 24);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/user.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoPerfil= new ImageIcon(imagen.getImage().getScaledInstance(labelPerfil.getWidth(), labelPerfil.getHeight(), Image.SCALE_DEFAULT));
		
		labelPerfil.setIcon(iconoPerfil);
		
		labelCerrar.setBounds(29, 26, 24, 24);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/cierre.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoCerrar= new ImageIcon(imagen.getImage().getScaledInstance(labelCerrar.getWidth(), labelCerrar.getHeight(), Image.SCALE_DEFAULT));
		
		labelCerrar.setIcon(iconoCerrar);
		
		//Añadimos al panel
		
		getContentPane().setLayout(null);
		
		getContentPane().add(labelCerrar);
		getContentPane().add(labelConfiguracion);
		getContentPane().add(labelEmpezar);
		getContentPane().add(labelEstadistica);
		getContentPane().add(labelFoto);
		getContentPane().add(labelPerfil);
		getContentPane().add(labelTitulo);
		
		//Eventos
		
		labelCerrar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaLogin ventana= new VentanaLogin();
				ventana.setVisible(true);
				dispose();
				
			}
		});
		
		labelEmpezar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				labelEmpezar.setIcon(iconoEmpezar);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon imagenBoton= new ImageIcon();
				try{
					imagenBoton= new ImageIcon(VentanaMenu.class.getResource("Imagenes/play seleccion.png").toURI().toURL());
				}catch (Exception a){
					System.out.println("No se encuentra el archivo");
				}
				
				Icon icono= new ImageIcon(imagenBoton.getImage().getScaledInstance(labelEmpezar.getWidth()-4, labelEmpezar.getHeight()-7, Image.SCALE_DEFAULT));
				
				
				labelEmpezar.setIcon(icono);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}

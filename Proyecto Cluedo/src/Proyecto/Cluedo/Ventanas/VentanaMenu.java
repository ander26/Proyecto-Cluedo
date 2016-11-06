package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.*;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Usuario;

public class VentanaMenu extends JFrame{

	public VentanaMenu(Connection conexion, Usuario u){
		
		//Inicializamos el frame 
		
		//600,400
		
		setSize(900,700);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		
		//Generamos los componentes
		
		JLabel labelHierba = new JLabel();
		
		JLabel titulo1= new JLabel("CREAR PARTIDA");
		
		titulo1.setBounds(360,157,187,42);
		
		titulo1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 23));
		
		titulo1.setForeground(Color.white);
		
		JLabel titulo2= new JLabel("BUSCAR PARTIDA");
		
		titulo2.setBounds(357,244,187,42);
		
		titulo2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 22));
		
		titulo2.setForeground(Color.white);
		
		Icon iconoHierba;
		
		JLabel labelfondo= new JLabel ();
		
		Icon iconoFondo;
		
		ImageIcon imagen= new ImageIcon ();
		
		JLabel labelFoto= new JLabel();
		
		Icon iconoFoto;
		
		JLabel labelTitulo= new JLabel("MENU PRINCIPAL");
		
		JLabel labelEmpezar= new JLabel("Buscar Partida");
		
		Icon iconoEmpezar;
		
		JLabel labelCrear= new JLabel("Crear Partida");
		
		Icon iconoCrear;
		
		
		JLabel labelConfiguracion= new JLabel();
		
		Icon iconoConfiguracion;
		
		JLabel labelEstadistica= new JLabel();
		
		Icon iconoEstadistica;
		
		LabelPerfil labelPerfil;
		
		
		
		JLabel labelCerrar= new JLabel();
		
		Icon iconoCerrar;
		
		//Establecemos el formato
		
		try{
			imagen=new ImageIcon (VentanaMenu.class.getResource("Imagenes/fondo.jpg").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el fondo");
		}
		
		
		labelfondo.setBounds(0, 0, getWidth(), getHeight());
		
		iconoFondo=new ImageIcon(imagen.getImage().getScaledInstance(labelfondo.getWidth(), labelfondo.getHeight(), Image.SCALE_DEFAULT));
		
		labelfondo.setIcon(iconoFondo);
		
		//67,154,466,265
		
		labelFoto.setBounds(104,273, 692, 392);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/Menu.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoFoto= new ImageIcon(imagen.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
		
		labelFoto.setIcon(iconoFoto);
		
		labelTitulo.setBounds(248, 34, 415, 99);
		
		labelTitulo.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 50));
		
		labelEmpezar.setBounds(296, 145, 309, 80);
		

		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/button_green.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoEmpezar= new ImageIcon(imagen.getImage().getScaledInstance(labelEmpezar.getWidth(), labelEmpezar.getHeight(), Image.SCALE_DEFAULT));
		
		labelEmpezar.setIcon(iconoEmpezar);
		
		labelCrear.setBounds(296, 233, 309, 80);
		

		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/button_green.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoCrear= new ImageIcon(imagen.getImage().getScaledInstance(labelCrear.getWidth(), labelCrear.getHeight(), Image.SCALE_DEFAULT));
		
		labelCrear.setIcon(iconoCrear);
		
		labelConfiguracion.setBounds(800, 150, 50, 50);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/configuracion.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoConfiguracion= new ImageIcon(imagen.getImage().getScaledInstance(labelConfiguracion.getWidth(), labelConfiguracion.getHeight(), Image.SCALE_DEFAULT));
		
		labelConfiguracion.setIcon(iconoConfiguracion);
		
		labelEstadistica.setBounds(800, 220, 50, 50);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/trofeo.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoEstadistica= new ImageIcon(imagen.getImage().getScaledInstance(labelEstadistica.getWidth(), labelEstadistica.getHeight(), Image.SCALE_DEFAULT));
		
		labelEstadistica.setIcon(iconoEstadistica);
		
		
		
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/user.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		labelPerfil=new LabelPerfil(imagen, 800, 70, 50, 50);
		
		
		labelCerrar.setBounds(20, 26, 24, 24);
		
		try{
			imagen= new ImageIcon(VentanaMenu.class.getResource("Imagenes/cierre.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoCerrar= new ImageIcon(imagen.getImage().getScaledInstance(labelCerrar.getWidth(), labelCerrar.getHeight(), Image.SCALE_DEFAULT));
		
		labelCerrar.setIcon(iconoCerrar);
		

		try{
			imagen=new ImageIcon (VentanaMenu.class.getResource("Imagenes/hierba.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el fondo");
		}
		
		//0,150,600,400
		
		labelHierba.setBounds(0,193,920 ,507 );
		
		iconoHierba=new ImageIcon(imagen.getImage().getScaledInstance(labelHierba.getWidth(), labelHierba.getHeight(), Image.SCALE_DEFAULT));
		
		labelHierba.setIcon(iconoHierba);
		
		//Añadimos al panel
		
		getContentPane().setLayout(null);
		
		getContentPane().add(labelCerrar);
		getContentPane().add(labelConfiguracion);
		
		getContentPane().add(labelEstadistica);
		getContentPane().add(labelFoto);
		getContentPane().add(labelPerfil);
		getContentPane().add(labelTitulo);
		getContentPane().add(labelHierba);
		
		getContentPane().add(titulo1);
		
		getContentPane().add(titulo2);
		
		getContentPane().add(labelCrear);
		getContentPane().add(labelEmpezar);
		
		
		//getContentPane().add(labelfondo);
		
		//Eventos
		
		labelCerrar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de querer cerrar sesion?", "Aviso de cierre de sesion", JOptionPane.YES_NO_OPTION);
				
				if (opcion==JOptionPane.OK_OPTION){
				VentanaLogin ventana= new VentanaLogin(conexion);
				ventana.setVisible(true);
				dispose();
				}
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
					imagenBoton= new ImageIcon(VentanaMenu.class.getResource("Imagenes/boton seleccionado.png").toURI().toURL());
				}catch (Exception a){
					System.out.println("No se encuentra el archivo");
				}
				
				Icon icono= new ImageIcon(imagenBoton.getImage().getScaledInstance(labelEmpezar.getWidth(), labelEmpezar.getHeight(), Image.SCALE_DEFAULT));
				
				
				labelEmpezar.setIcon(icono);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				

				VentanaCrearPartida ventanas= new VentanaCrearPartida();
				ventanas.setVisible(true);
			}
		});
		
		labelCrear.addMouseListener(new MouseListener() {
			
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
				labelCrear.setIcon(iconoCrear);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon imagenBoton= new ImageIcon();
				try{
					imagenBoton= new ImageIcon(VentanaMenu.class.getResource("Imagenes/boton seleccionado.png").toURI().toURL());
				}catch (Exception a){
					System.out.println("No se encuentra el archivo");
				}
				
				Icon icono= new ImageIcon(imagenBoton.getImage().getScaledInstance(labelCrear.getWidth(), labelCrear.getHeight(), Image.SCALE_DEFAULT));
				
				
				labelCrear.setIcon(icono);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
	
}

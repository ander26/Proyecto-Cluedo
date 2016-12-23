package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class pruebaventana extends JFrame{

	
	public pruebaventana(){
		
		setSize(100,100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		ImageIcon imagen=new ImageIcon();
		
		ImageIcon imagen2=new ImageIcon();
		
		ImageIcon imagen3=new ImageIcon();
		
		try{
			
			imagen=new ImageIcon(pruebaventana.class.getResource("Imagenes/pruueba.jpg").toURI().toURL());
			
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		try{
			
			imagen2=new ImageIcon(pruebaventana.class.getResource("Imagenes/pruueba2.png").toURI().toURL());
			
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		try{
			
			imagen3=new ImageIcon(pruebaventana.class.getResource("Imagenes/pruueba3.png").toURI().toURL());
			
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		panelrosa panel = new panelrosa(imagen.getImage());
		
		panelrosa panel2 = new panelrosa(imagen2.getImage());
		
		panelrosa panel3 = new panelrosa(imagen3.getImage());
		
		
		getContentPane().setLayout(new BorderLayout());
		
		panel.setLayout(new BorderLayout());
		
		panel2.setLayout(new BorderLayout());
		
		panel3.setLayout(null);
		
		
		getContentPane().add(panel, BorderLayout.CENTER);
		

		panel.add(panel2, BorderLayout.CENTER);

		panel2.add(panel3, BorderLayout.CENTER);
		
		
		

		
		
	}
	
	
	public static void main (String [] args){
		
		pruebaventana prueba = new pruebaventana();
		prueba.setVisible(true);
	}
}

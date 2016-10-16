package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaChat extends JFrame {

	
	public static void main (String [] args){
		VentanaChat ventana= new VentanaChat();
		ventana.setVisible(true);
		
	}
	
	public VentanaChat(){
		
		//Inicializamos el frame
		
		setUndecorated(false);
		setResizable(false);
		setSize(new Dimension(600, 400));
		
		//Creamos los compoenntes
		
		
		//Establecemos el formato
		
		getContentPane().setLayout(new BorderLayout());
		
	}
	
}

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
		
		setUndecorated(true);
		setResizable(false);
		setSize(new Dimension(600, 400));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Creamos los compoenntes
		
		
		//Establecemos el formato
		
		getContentPane().setLayout(new BorderLayout());
		
		
		
	}
	
}

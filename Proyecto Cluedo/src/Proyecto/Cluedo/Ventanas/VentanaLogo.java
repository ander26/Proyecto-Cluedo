package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaLogo extends JFrame {

	private ImageIcon imagenLogo;
	
	public static void main (String [] args){
		VentanaLogo ventana = new VentanaLogo ();
		ventana.setVisible(true);
	}
	
	public VentanaLogo (){
		
		//Inicializamos el frame
		
		setSize(new Dimension(700, 600));
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//Generamos los componentes
		
		JPanel panelLogo= new JPanel();
		
		JLabel labelLogo = new JLabel();
		imagenLogo= new ImageIcon(VentanaLogo.class.getResource("Imagenes/LOGO DEUSTLUEDO.png"));
		
		//Damos el formato
		
		labelLogo.setIcon(imagenLogo);
		
		panelLogo.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		panelLogo.setOpaque(false);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panelLogo, BorderLayout.CENTER);
		panelLogo.add(labelLogo);
		
	}
}

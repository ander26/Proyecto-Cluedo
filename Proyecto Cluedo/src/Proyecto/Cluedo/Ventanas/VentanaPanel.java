package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPanel  extends JFrame{

	
	public static void main (String [] args){
		
		
		VentanaPanel ventana= new VentanaPanel();
		ventana.setVisible(true);
		
	}
	
	public VentanaPanel (){
		
		//Establecemos el formato
		
		setSize(600,600);
		
		setUndecorated(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		
		//Generamos los componentes
		
		
		
		ImageIcon imagen =new ImageIcon() ;
		
		JLabel mensaje = new JLabel("<html><body><DIV ALIGN=center><br>maideribarra<br> esta jugando</div></body><html>");
		
		
		try{
			imagen=new ImageIcon(VentanaPanel.class.getResource("Imagenes/calle bilbao.png").toURI().toURL());
		}catch (Exception e){
			
			System.out.println("No se ha encontrado la foto de fondo");
		}
		
		
		panelrosa panel = new panelrosa(imagen.getImage());
		
		
		mensaje.setFont(new Font("Calisto MT", Font.BOLD, 50));
		
		mensaje.setForeground(Color.WHITE);
		
		mensaje.setHorizontalAlignment(JLabel.CENTER);
		
		mensaje.setVerticalAlignment(JLabel.CENTER);
		
		
		
		//Establecemos el formato
		
		panel.setLayout(new BorderLayout());
		
		panel.add(mensaje,BorderLayout.CENTER);
	
		getContentPane().add(panel, BorderLayout.CENTER);
		
		
		
		
		
	}
}

package Proyecto.Cluedo.Ventanas;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaCartas extends JFrame{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new VentanaCartas();
		f.setVisible(true);
	}
	public VentanaCartas(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 480 );
		setMinimumSize(new Dimension(750,300));
		setResizable( true );
		ImageIcon image;		
		image = new ImageIcon(ventana.class.getResource("Imagenes/pizarra.png"));
		panelPizarra p=new panelPizarra(image.getImage());
		getContentPane().add(p);
	}

}

package Proyecto.Cluedo.Ventanas;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaCartas extends JFrame{
	private JTabbedPane ptabbed=new JTabbedPane();
	private JPanel pprincipal=new JPanel();
	private panelrosa psospechosos;
	private panelrosa parmas;
	private panelrosa plugares;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		JFrame f=new VentanaCartas();
		
		f.setVisible(true);
	}
	public VentanaCartas(){
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		
		setSize( 1330, 730 );		
		setMinimumSize(new Dimension(900,500));		
		setResizable( true );
		//Poner fondo a los paneles
		ImageIcon imagearma = new ImageIcon(ventana.class.getResource("Imagenes/fondoarmas.jpg"));
		parmas=new panelrosa(imagearma.getImage());
		ImageIcon imagelugares = new ImageIcon(ventana.class.getResource("Imagenes/escenacrimen.jpg"));
		plugares=new panelrosa(imagelugares.getImage());
		ImageIcon imagesospechosos = new ImageIcon(ventana.class.getResource("Imagenes/asesino.jpg"));
		psospechosos=new panelrosa(imagesospechosos.getImage());
		//crear los iconos 
		ImageIcon iconoarma = new ImageIcon(ventana.class.getResource("Imagenes/iconoarmas.png"));
		ImageIcon iconolugares = new ImageIcon(ventana.class.getResource("Imagenes/iconolugares.png"));
		ImageIcon iconosospechosos = new ImageIcon(ventana.class.getResource("Imagenes/iconosospechosos.png"));
		//crear ptabbed
		
		ptabbed.addTab("", iconoarma, parmas,"");
		ptabbed.setMnemonicAt(0, KeyEvent.VK_1);		
		ptabbed.addTab("", iconolugares, plugares,"");
		ptabbed.setMnemonicAt(1, KeyEvent.VK_2);
		ptabbed.addTab("", iconosospechosos,psospechosos,"");
		ptabbed.setMnemonicAt(2, KeyEvent.VK_3);
		ptabbed.
		getContentPane().add(ptabbed);

			}

}

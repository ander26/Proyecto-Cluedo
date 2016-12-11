package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanAcusardos {
	public JPanel pprincipal=new JPanel();
	public JTabbedPane ptabbed=new JTabbedPane(JTabbedPane.LEFT);
	public sospechoso psospechoso=new sospechoso();
	public armas parmas=new armas();
	public JPanel pbotonera=new JPanel();
	public JLabel lbAcusar=new JLabel();
	public JLabel lbResolver=new JLabel();
	public VentanaArrrcusar(){
		//crear los iconos 
		ImageIcon iconoarma = new ImageIcon(ventana.class.getResource("Imagenes/iconoarmas.png"));
		ImageIcon iconosospechosos = new ImageIcon(ventana.class.getResource("Imagenes/iconosospechosos.png"));
		//hacer tabbedpane
		ptabbed.addTab("", iconoarma, parmas,"");
		ptabbed.setMnemonicAt(0, KeyEvent.VK_1);		
		ptabbed.addTab("", iconosospechosos,psospechoso,"");
		ptabbed.setMnemonicAt(2, KeyEvent.VK_3);
		//ventana
		pprincipal.setLayout(new BorderLayout());
		pprincipal.add(ptabbed,BorderLayout.CENTER);
		ImageIcon iconobacusar = new ImageIcon(ventana.class.getResource("Imagenes/bacusar.png"));		
		lbAcusar.setSize(200,150);		
		Icon iconoacu = new ImageIcon(iconobacusar.getImage().getScaledInstance(lbAcusar.getWidth()	, lbAcusar.getHeight(), Image.SCALE_DEFAULT));
		lbAcusar.setIcon(iconoacu);
		ImageIcon iconobresolver = new ImageIcon(ventana.class.getResource("Imagenes/Bresolver.png"));		
		lbResolver.setSize(200,150);
		Icon iconores = new ImageIcon(iconobresolver.getImage().getScaledInstance(lbResolver.getWidth()	, lbResolver.getHeight(), Image.SCALE_DEFAULT));
		lbResolver.setIcon(iconores);
		pbotonera.add(lbAcusar);
		pbotonera.add(lbResolver);
		pprincipal.add(pbotonera,BorderLayout.NORTH);
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f=new VentanaAcusar();	
		f.setSize(1200,1200);	
		f.setVisible(true);

	}

}

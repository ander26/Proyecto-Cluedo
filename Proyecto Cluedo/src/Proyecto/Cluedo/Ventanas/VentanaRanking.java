package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import Proyecto.Cluedo.Logica.GestionBaseDeDatos;

public class VentanaRanking extends JFrame{
	private JList lusuarios=new JList();
	private JPanel pcopa=new JPanel();
	private JPanel pderecho =new JPanel();
	private JPanel pizquierdo=new JPanel();
	private JLabel lprimero=new JLabel();
	private JLabel lsegundo=new JLabel();
	private JLabel ltercero=new JLabel();
	private JLabel lcopas=new JLabel();
	private JPanel pprincipal=new JPanel();
	private panelrosa pteatro;
	
	
	//public VentanaRanking(Connection conexion,GestionBaseDeDatos gestion){
		public VentanaRanking(){
		ImageIcon image = new ImageIcon(VentanaRanking.class.getResource("Imagenes/teatro.jpg"));
		pteatro=new panelrosa(image.getImage());
		pprincipal.setLayout(new BorderLayout());		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 1330, 730 );
		setResizable( true );
		pcopa.setLayout(null);
		ImageIcon iconocopas = new ImageIcon(ventana.class.getResource("Imagenes/copa.png"));		
		lcopas.setSize(227,283);
		Icon icono = new ImageIcon(iconocopas.getImage().getScaledInstance(lcopas.getWidth()	, lcopas.getHeight(), Image.SCALE_DEFAULT));
		lcopas.setIcon(icono);
		lcopas.setLocation(80,30);
		pcopa.add(lcopas,pcopa);
		lprimero.setBackground(Color.blue);
		lprimero.setText("copa1");
		lprimero.setSize(50,50);
		lprimero.setLocation(110, 0);
		lsegundo.setBackground(Color.green);
		lsegundo.setText("copa2");
		lsegundo.setSize(50,50);
		ltercero.setBackground(Color.orange);
		ltercero.setSize(50,50);
		lsegundo.setLocation(180,0);
		ltercero.setLocation(240,0);
		ltercero.setText("copa3");
		pcopa.add(lprimero,pcopa);
		pcopa.add(lsegundo,pcopa);
		pcopa.add(ltercero, pcopa);
		getContentPane().add(pprincipal);
		pizquierdo.setLayout(new BoxLayout(pizquierdo,BoxLayout.Y_AXIS));
		pizquierdo.add(pcopa);
		pizquierdo.add(lusuarios);
		pprincipal.add(pizquierdo,BorderLayout.CENTER);
		pteatro.setLayout(new BoxLayout(pteatro,BoxLayout.Y_AXIS));
		pteatro.add(comp)
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new VentanaRanking();
		
		f.setVisible(true);

	}

}

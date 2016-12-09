package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class armas extends panelrosa{
	public JPanel pbocata=new JPanel();
	public JPanel pchip=new JPanel();
	public JPanel pbotella=new JPanel();
	public JPanel columna1=new JPanel();
	public JPanel columna2=new JPanel();
	public JPanel columna3=new JPanel();
	public JPanel centrar1=new JPanel();
	public JPanel centrar2=new JPanel();
	public JLabel lseparador=new JLabel("                           ");
	public artilugio lbocata=new artilugio("Imagenes/bocadillo.png","Bocata envenenado");
	public artilugio lbotella=new artilugio("Imagenes/botella.png","Botella");
	public artilugio lchip=new artilugio("Imagenes/chip.png","Chip");
	public artilugio lbiblia=new artilugio("Imagenes/biblia.png","Biblia");
	public artilugio lsarten=new artilugio("Imagenes/sarten.png","Sarten");
	public artilugio lpistola=new artilugio("Imagenes/revolver.png","Pistola");
	public artilugio [] arrarmas=new artilugio[6];
	
	public int apuntador=9;
	
	
	public armas(){
		
		ImageIcon imagefondo = new ImageIcon(sospechoso.class.getResource("Imagenes/silueta.jpg"));
		setImagen(imagefondo.getImage());
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		arrarmas[0]=lbocata;
		arrarmas[1]=lbotella;
		arrarmas[2]=lchip;
		arrarmas[3]=lbiblia;
		arrarmas[4]=lsarten;
		arrarmas[5]=lpistola;
		pbocata.add(lbocata);
		pbocata.setOpaque(false);
		pchip.add(lchip);
		pchip.setOpaque(false);
		pbotella.add(lbotella);
		pbotella.setOpaque(false);
		columna1.setOpaque(false);
		columna2.setOpaque(false);
		columna3.setOpaque(false);
		centrar1.setOpaque(false);
		centrar2.setOpaque(false);
//		add(pbocata,BorderLayout.NORTH);
//		add(pbotella,BorderLayout.SOUTH);
//		add(pchip,BorderLayout.CENTER);
//		add(lbiblia,BorderLayout.EAST);
//		add(lsarten,BorderLayout.WEST);
		columna1.setLayout(new BoxLayout(columna1,BoxLayout.Y_AXIS));
		columna3.setLayout(new BoxLayout(columna3,BoxLayout.Y_AXIS));
		columna1.add(lbocata);
		columna1.add(lbotella);
		columna3.add(lchip);
		columna3.add(lbiblia);
		columna2.setLayout(new BoxLayout(columna2,BoxLayout.X_AXIS));
		centrar1.setLayout(new BorderLayout());
		centrar2.setLayout(new BorderLayout());
		centrar1.add(lsarten,BorderLayout.SOUTH);
		centrar2.add(lpistola,BorderLayout.SOUTH);
		columna2.add(centrar1);
		columna2.add(lseparador);
		columna2.add(centrar2);
		add(columna1);
		add(columna2);
		add(columna3);
		arrarmas[0].addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(apuntador==9){
					arrarmas[0].setSeleccionado(true);
					
					
					
				}
				
				
				else{
					
					arrarmas[0].setSeleccionado(true);
					arrarmas[apuntador].setSeleccionado(false);
							
					
					
					
					
				}
				
				System.out.println(apuntador);
				apuntador=0;
				
				
				repaint();
				
				
			}
			
	});
	arrarmas[1].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrarmas[1].setSeleccionado(true);
				
				
			}
			
			
			else{
				
				arrarmas[1].setSeleccionado(true);
				arrarmas[apuntador].setSeleccionado(false);
						
				
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=1;
			
			
			
			repaint();
			
			
		}
});
	arrarmas[2].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrarmas[2].setSeleccionado(true);
				
				
			}
			
			
			else{
				
				arrarmas[2].setSeleccionado(true);
				arrarmas[apuntador].setSeleccionado(false);
						
				
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=2;
			
			
			repaint();
			
			
		}
});
	arrarmas[3].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrarmas[3].setSeleccionado(true);
				
				
			}
			
			
			else{
				
				arrarmas[3].setSeleccionado(true);
				arrarmas[apuntador].setSeleccionado(false);
						
				
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=3;
			
			repaint();
			
			
		}
});
	arrarmas[4].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrarmas[4].setSeleccionado(true);
				
				
			}
			
			
			else{
				
				arrarmas[4].setSeleccionado(true);
				arrarmas[apuntador].setSeleccionado(false);
						
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=4;
			
			
			repaint();
			
			
		}
});
	arrarmas[5].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrarmas[5].setSeleccionado(true);
				
				
			}
			
			
			else{
				
				arrarmas[5].setSeleccionado(true);
				arrarmas[apuntador].setSeleccionado(false);
						
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=5;
			
			
			repaint();
			
			
		}
});
	
	
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana=new JFrame();
		ventana.setSize(1200,1200);		
		armas s=new armas();
		ventana.getContentPane().add(s);
		ventana.setVisible(true);
		
			
	}

}

package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class sospechoso extends panelrosa {
	
	public panelrosa pabajo;
	public int apuntador=9;
	public panelrosa pventana;
	public JPanel psospechoso=new JPanel();
	public JPanel pbotonera=new JPanel();
	public JLabel marcoizql=new JLabel("              ");
	public JLabel marcoIzquierda=new JLabel("              ");
	public JLabel labelabajo=new JLabel("<html><body> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> </body></html>");	
	public JLabel lbotonizq=new JLabel();
	public JLabel lbotonder=new JLabel();
	
	public JLabel lpushabajo=new JLabel();
	public JLabel lpusharriba=new JLabel();
	public JPanel pizquierdo=new JPanel();
	public JPanel plampara=new JPanel();
	public JLabel llampara=new JLabel();
	public JPanel phueco1=new JPanel();
	public JPanel phueco2=new JPanel();
	public JPanel phueco3=new JPanel();
	public JPanel phueco4=new JPanel();
	public JPanel phueco5=new JPanel();
	public JPanel phueco6=new JPanel();
	public JPanel phueco7=new JPanel();
	public JLabel hueco1=new JLabel();
	public JLabel hueco2=new JLabel();
	public JLabel hueco3=new JLabel();
	public JLabel hueco4=new JLabel();
	public JLabel hueco5=new JLabel();
	public JLabel hueco6=new JLabel();
	public JLabel hueco7=new JLabel();
	public JPanel pcentrar=new JPanel();
	public JPanel pcentrarlamparas=new JPanel();
	public personaje [] arrsospechoso= new personaje[7];
	public JLabel lventana=new JLabel("<html><body> <br> <br> <br> <br> </body></html>");
	public JLabel lizquierda=new JLabel("          ");
	public JLabel [] arrhueco=new JLabel[7];
	public JPanel [] arrpaneles=new JPanel[7];
	private String sospechoso=null;
	
	
	public sospechoso(){
	pabajo=meterfondo(pabajo,"mesalampara.png");
	pabajo.add(labelabajo);
	plampara.setLayout(new BoxLayout(plampara,BoxLayout.X_AXIS));
	plampara.setOpaque(false);
	pcentrar.setOpaque(false);
	pcentrarlamparas.setOpaque(false);
	ImageIcon imagefondo = new ImageIcon(sospechoso.class.getResource("Imagenes/foncarcel.jpg"));
	setImagen(imagefondo.getImage());
	setBackground(Color.BLUE);
	
	pventana=meterfondo(pventana,"marconegro.png");	
	
	pbotonera.setLayout(new BorderLayout());
	pizquierdo.setOpaque(false);
	pbotonera.setOpaque(false);
	setLayout(new BorderLayout());
	add(marcoIzquierda, BorderLayout.EAST);
	add(lizquierda, BorderLayout.WEST);
	//add(labelabajo,BorderLayout.SOUTH);
	
	add(pventana,BorderLayout.CENTER);	
	meterfotoEnLabel(lpusharriba,"hueco.png",50,50);
	meterfotoEnLabel(lpushabajo,"hueco.png",50,50);
	meterfotoEnLabel(lbotonder,"hueco.png",50,50);
	meterfotoEnLabel(lbotonizq,"hueco.png",50,50);
	meterfotoEnLabel(hueco1,"hueco.png",145,100);
	meterfotoEnLabel(hueco2,"hueco.png",145,100);
	meterfotoEnLabel(hueco3,"hueco.png",145,100);
	meterfotoEnLabel(hueco4,"hueco.png",145,100);
	meterfotoEnLabel(hueco5,"hueco.png",145,100);
	meterfotoEnLabel(hueco6,"hueco.png",145,100);
	meterfotoEnLabel(hueco7,"hueco.png",145,100);
	meterfotoEnLabel(llampara,"lampara.png",150,100);
	
	phueco1.add(hueco1);
	phueco1.setOpaque(false);
	phueco2.add(hueco2);
	phueco2.setOpaque(false);
	
	phueco3.add(hueco3);
	phueco3.setOpaque(false);
	
	phueco4.add(hueco4);
	phueco4.setOpaque(false);
	
	phueco5.add(hueco5);
	phueco5.setOpaque(false);
	
	phueco6.add(hueco6);
	phueco6.setOpaque(false);
	
	phueco7.add(hueco7);
	phueco7.setOpaque(false);
	
	arrpaneles[0]=phueco1;
	arrpaneles[1]=phueco2;
	arrpaneles[2]=phueco3;
	arrpaneles[3]=phueco4;
	arrpaneles[4]=phueco5;
	arrpaneles[5]=phueco6;
	arrpaneles[6]=phueco7;
	
	plampara.add(phueco1);
	arrhueco[0]=hueco1;
	plampara.add(phueco2);
	arrhueco[1]=hueco2;
	plampara.add(phueco3);
	arrhueco[2]=hueco3;
	plampara.add(phueco4);
	arrhueco[3]=hueco4;
	plampara.add(phueco5);
	arrhueco[4]=hueco5;
	plampara.add(phueco6);
	arrhueco[5]=hueco6;
	plampara.add(phueco7);
	arrhueco[6]=hueco7;
	pbotonera.add(lbotonizq,BorderLayout.EAST);
	pbotonera.add(lbotonder,BorderLayout.WEST);
	pbotonera.add(lpusharriba,BorderLayout.SOUTH);
	pizquierdo.add(pbotonera);
	//add(pizquierdo,BorderLayout.WEST);
	personaje Gadget=new personaje("Imagenes/InspectorGadget.png","Inspector Gadget");
	personaje Paris=new personaje ("Imagenes/parisHilton.png","Paris Hilton");
	personaje Bolt=new personaje ("Imagenes/usainbolt.png","Usain  Bolt");
	personaje Socrates=new personaje("Imagenes/Socrates.png","Socrates");
	personaje Papa=new personaje("Imagenes/papaa.png","El Papa");
	personaje Minerva=new personaje("Imagenes/Minerva.png","Minerva");
	personaje Momia=new personaje("Imagenes/momia.png","La Momia");
	arrsospechoso[0]=Gadget;
	arrsospechoso[1]=Paris;
	arrsospechoso[2]=Bolt;
	arrsospechoso[3]=Socrates;
	arrsospechoso[4]=Papa;
	arrsospechoso[5]=Minerva;
	arrsospechoso[6]=Momia;
	psospechoso.setLayout(new BoxLayout(psospechoso,BoxLayout.X_AXIS));
	psospechoso.setOpaque(false);
	pventana.setLayout(new BorderLayout());	
	meterFotoAventana();
	add(lventana,BorderLayout.NORTH);
	pcentrar.add(psospechoso);
	pventana.add(pcentrar,BorderLayout.CENTER);
	pcentrarlamparas.add(plampara);
	pventana.add(pcentrarlamparas,BorderLayout.NORTH);
	pventana.repaint();
	add(pabajo,BorderLayout.SOUTH);
	arrsospechoso[0].addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(apuntador==9){
					arrsospechoso[0].setSeleccionado(true);					
				}
				
				
				else{
					ImageIcon iiconoHUECO = new ImageIcon(sospechoso.class.getResource("Imagenes/hueco.png"));				
					Icon iconoHUECO = new ImageIcon(iiconoHUECO.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
					arrsospechoso[0].setSeleccionado(true);
					arrsospechoso[apuntador].setSeleccionado(false);							
					arrhueco[apuntador].setIcon(iconoHUECO);
					arrpaneles[apuntador].add(arrhueco[apuntador]);					
				}
				
				System.out.println(apuntador);
				apuntador=0;
				ImageIcon iicono = new ImageIcon(sospechoso.class.getResource("Imagenes/lampara.png"));		
				
				Icon icono = new ImageIcon(iicono.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
				arrhueco[apuntador].setIcon(icono);
				arrpaneles[apuntador].add(arrhueco[apuntador]);
				sospechoso=arrsospechoso[0].getNombre();
				psospechoso.repaint();
				plampara.revalidate();
				plampara.repaint();
				
				
			}
	});
	arrsospechoso[1].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrsospechoso[1].setSeleccionado(true);
				
				
			}
			
			
			else{
				ImageIcon iiconoHUECO = new ImageIcon(sospechoso.class.getResource("Imagenes/hueco.png"));				
				Icon iconoHUECO = new ImageIcon(iiconoHUECO.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
				arrsospechoso[1].setSeleccionado(true);
				arrsospechoso[apuntador].setSeleccionado(false);
						
				arrhueco[apuntador].setIcon(iconoHUECO);
				arrpaneles[apuntador].add(arrhueco[apuntador]);
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=1;
			ImageIcon iicono = new ImageIcon(sospechoso.class.getResource("Imagenes/lampara.png"));		
			
			Icon icono = new ImageIcon(iicono.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
			arrhueco[apuntador].setIcon(icono);
			arrpaneles[apuntador].add(arrhueco[apuntador]);
			sospechoso=arrsospechoso[1].getNombre();
			
			psospechoso.repaint();
			plampara.revalidate();
			plampara.repaint();
			
		}
});
	arrsospechoso[2].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrsospechoso[2].setSeleccionado(true);
				
				
			}
			
			
			else{
				ImageIcon iiconoHUECO = new ImageIcon(sospechoso.class.getResource("Imagenes/hueco.png"));				
				Icon iconoHUECO = new ImageIcon(iiconoHUECO.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
				arrsospechoso[2].setSeleccionado(true);
				arrsospechoso[apuntador].setSeleccionado(false);
						
				arrhueco[apuntador].setIcon(iconoHUECO);
				arrpaneles[apuntador].add(arrhueco[apuntador]);
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=2;
			ImageIcon iicono = new ImageIcon(sospechoso.class.getResource("Imagenes/lampara.png"));		
			
			Icon icono = new ImageIcon(iicono.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
			arrhueco[apuntador].setIcon(icono);
			arrpaneles[apuntador].add(arrhueco[apuntador]);
			sospechoso=arrsospechoso[2].getNombre();
			
			psospechoso.repaint();
			plampara.revalidate();
			plampara.repaint();
			
		}
});
	arrsospechoso[3].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrsospechoso[3].setSeleccionado(true);
				
				
			}
			
			
			else{
				ImageIcon iiconoHUECO = new ImageIcon(sospechoso.class.getResource("Imagenes/hueco.png"));				
				Icon iconoHUECO = new ImageIcon(iiconoHUECO.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
				arrsospechoso[3].setSeleccionado(true);
				arrsospechoso[apuntador].setSeleccionado(false);
						
				arrhueco[apuntador].setIcon(iconoHUECO);
				arrpaneles[apuntador].add(arrhueco[apuntador]);
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=3;
			ImageIcon iicono = new ImageIcon(sospechoso.class.getResource("Imagenes/lampara.png"));		
			
			Icon icono = new ImageIcon(iicono.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
			arrhueco[apuntador].setIcon(icono);
			arrpaneles[apuntador].add(arrhueco[apuntador]);
			sospechoso=arrsospechoso[3].getNombre();
			
			psospechoso.repaint();
			plampara.revalidate();
			plampara.repaint();
			
		}
});
	arrsospechoso[4].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrsospechoso[4].setSeleccionado(true);
				
				
			}
			
			
			else{
				ImageIcon iiconoHUECO = new ImageIcon(sospechoso.class.getResource("Imagenes/hueco.png"));				
				Icon iconoHUECO = new ImageIcon(iiconoHUECO.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
				arrsospechoso[4].setSeleccionado(true);
				arrsospechoso[apuntador].setSeleccionado(false);
						
				arrhueco[apuntador].setIcon(iconoHUECO);
				arrpaneles[apuntador].add(arrhueco[apuntador]);
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=4;
			ImageIcon iicono = new ImageIcon(sospechoso.class.getResource("Imagenes/lampara.png"));		
			
			Icon icono = new ImageIcon(iicono.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
			arrhueco[apuntador].setIcon(icono);
			arrpaneles[apuntador].add(arrhueco[apuntador]);
			sospechoso=arrsospechoso[4].getNombre();
			
			psospechoso.repaint();
			plampara.revalidate();
			plampara.repaint();
			
		}
});
	arrsospechoso[5].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrsospechoso[5].setSeleccionado(true);
				
				
			}
			
			
			else{
				ImageIcon iiconoHUECO = new ImageIcon(sospechoso.class.getResource("Imagenes/hueco.png"));				
				Icon iconoHUECO = new ImageIcon(iiconoHUECO.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
				arrsospechoso[5].setSeleccionado(true);
				arrsospechoso[apuntador].setSeleccionado(false);
						
				arrhueco[apuntador].setIcon(iconoHUECO);
				arrpaneles[apuntador].add(arrhueco[apuntador]);
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=5;
			ImageIcon iicono = new ImageIcon(sospechoso.class.getResource("Imagenes/lampara.png"));		
			
			Icon icono = new ImageIcon(iicono.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
			arrhueco[apuntador].setIcon(icono);
			arrpaneles[apuntador].add(arrhueco[apuntador]);
			sospechoso=arrsospechoso[5].getNombre();
			
			psospechoso.repaint();
			plampara.revalidate();
			plampara.repaint();
			
		}
});
	arrsospechoso[6].addMouseListener(new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(apuntador==9){
				arrsospechoso[6].setSeleccionado(true);
				
				
			}
			
			
			else{
				ImageIcon iiconoHUECO = new ImageIcon(sospechoso.class.getResource("Imagenes/hueco.png"));				
				Icon iconoHUECO = new ImageIcon(iiconoHUECO.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
				arrsospechoso[6].setSeleccionado(true);
				arrsospechoso[apuntador].setSeleccionado(false);
						
				arrhueco[apuntador].setIcon(iconoHUECO);
				arrpaneles[apuntador].add(arrhueco[apuntador]);
				
				
				
			}
			
			System.out.println(apuntador);
			apuntador=6;
			ImageIcon iicono = new ImageIcon(sospechoso.class.getResource("Imagenes/lampara.png"));		
			
			Icon icono = new ImageIcon(iicono.getImage().getScaledInstance(arrhueco[apuntador].getWidth()	, arrhueco[apuntador].getHeight(), Image.SCALE_DEFAULT));
			arrhueco[apuntador].setIcon(icono);
			arrpaneles[apuntador].add(arrhueco[apuntador]);
			sospechoso=arrsospechoso[6].getNombre();
			
			psospechoso.repaint();
			plampara.revalidate();
			plampara.repaint();
			
		}
});
	
	}
	
	public String getSospechoso() {
		return sospechoso;
	}
	public void setSospechoso(String sospechoso) {
		this.sospechoso = sospechoso;
	}
	public panelrosa meterfondo(panelrosa panel,String foto){
		ImageIcon imagefondo = new ImageIcon(sospechoso.class.getResource("Imagenes/"+foto));
		panel=new panelrosa(imagefondo.getImage());
		return panel;
	}
	public void meterfotoEnLabel(JLabel label,String foto,int anchura,int largura){
		
		ImageIcon iicono = new ImageIcon(sospechoso.class.getResource("Imagenes/"+foto));		
		label.setSize(anchura,largura);
		Icon icono = new ImageIcon(iicono.getImage().getScaledInstance(label.getWidth()	, label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
	}
	public void meterFotoAventana(){
		for(int i=0;i<arrsospechoso.length;i++){
			psospechoso.add(arrsospechoso[i]);
		
		}
		
		psospechoso.repaint();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana=new JFrame();
		ventana.setSize(1200,1200);		
		sospechoso s=new sospechoso();
		ventana.getContentPane().add(s);
		ventana.setVisible(true);
		
			
	}

	

}

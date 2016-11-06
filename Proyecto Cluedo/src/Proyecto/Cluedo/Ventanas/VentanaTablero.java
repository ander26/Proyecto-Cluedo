package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Proyecto.Cluedo.Logica.Jugador;

public class VentanaTablero extends JFrame {
	JPanel pprincipal=new JPanel();
	JPanel parriba=new JPanel();
	panelrosa pabajo;
	panelrosa pderecha;
	panelrosa ptablero;	
	JLabel lcartel=new JLabel();
	JLabel ltextocartel=new JLabel();
	JLabel lsemaforo=new JLabel();
	JLabel lacusar=new JLabel();
	JLabel lenviar=new JLabel();
	JLabel lnotas=new JLabel();
	JLabel lchat=new JLabel();
	JLabel lusuario=new JLabel();
	JLabel ldado=new JLabel();
	JPanel pcartel=new JPanel();
	private static int[][] mibaraja=new int[3][4];
	JFrame g=new ventana();
	VentanaChat ventana= new VentanaChat();
	
	

	
public static void main(String[] args) {
		
		// TODO Auto-generated method stub		
																	
		JFrame f=new VentanaTablero();		
		f.setVisible(true);
	}
	public VentanaTablero(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		
		setSize( 1330, 730 );				
		setResizable( true );
		Border blackline = BorderFactory.createLineBorder(Color.DARK_GRAY,8);		
		ImageIcon imagefondo = new ImageIcon(VentanaTablero.class.getResource("Imagenes/tablero - copia - copia.jpg"));
		ptablero=new panelrosa(imagefondo.getImage());
		ImageIcon imagefondocartel = new ImageIcon(VentanaTablero.class.getResource("Imagenes/fondocartel.jpg"));
		ptablero.setBorder(blackline);
		ImageIcon imagefondomadera = new ImageIcon(VentanaTablero.class.getResource("Imagenes/fondomadera.JPG"));
		pabajo=new panelrosa(imagefondomadera.getImage());
		pderecha=new panelrosa(imagefondocartel.getImage());
		meterImgEnlabel("Imagenes/cartel.png",lcartel,500,600);
		meterImgEnlabel("Imagenes/semafororojot.png",lsemaforo,200,150);
		meterImgEnlabel("Imagenes/pusharriba.png",lacusar,100,100);
		meterImgEnlabel("Imagenes/dado.gif",ldado,100,100);
		meterImgEnlabel("Imagenes/chat.png",lchat,80,80);
		meterImgEnlabel("Imagenes/cartel.png",lusuario,80,80);
		meterImgEnlabel("Imagenes/notas.png",lnotas,80,80);
		meterImgEnlabel("Imagenes/ENVIAR2.png",lenviar,80,80);		
		pprincipal.setLayout(new BorderLayout());
		getContentPane().add(pprincipal);
		parriba.setBackground(Color.black);
		parriba.setLayout(new BoxLayout(parriba,BoxLayout.X_AXIS));
		parriba.add(lusuario,parriba);
		parriba.add(lnotas,parriba);
		parriba.add(lchat,parriba);
		parriba.add(lenviar,parriba);
		pprincipal.add(parriba,BorderLayout.NORTH);
		pderecha.setLayout(new BoxLayout(pderecha,BoxLayout.Y_AXIS));
		pderecha.add(lsemaforo);
		pderecha.setBorder(blackline);
		lsemaforo.setAlignmentX(CENTER_ALIGNMENT);
		lcartel.setAlignmentX(CENTER_ALIGNMENT);
		pcartel.setOpaque(false);
		pcartel.add(lcartel);
		pcartel.add(ltextocartel);		
		pderecha.add(pcartel);
		ltextocartel.setForeground(Color.blue);
		ltextocartel.setSize(new Dimension(500,300));
		ltextocartel.setLocation(0,0);
		pprincipal.add(pderecha, BorderLayout.EAST);
		pprincipal.add(ptablero,BorderLayout.CENTER);
		//pabajo.setLayout(null);
		pabajo.add(lacusar);
		pabajo.add(ldado);
		pabajo.setBackground(Color.DARK_GRAY);
		pprincipal.add(pabajo,BorderLayout.SOUTH);
		//Escuchadores
		lacusar.addMouseListener( new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				meterImgEnlabel("Imagenes/pushbajo.png",lacusar,100,100);
				Jugador a =new Jugador();
				a.setLugar(2);
				//mete el fondo del lugar en el que este
				String [] aimglug=new String [8];
				aimglug[0]="Imagenes/ingenieria.jpg";
				aimglug[1]="Imagenes/comercial.jpg";
				aimglug[2]="Imagenes/capilla.JPG";
				aimglug[3]="Imagenes/centenario.jpg";
				aimglug[4]="Imagenes/letras.jpg";
				aimglug[5]="Imagenes/biblioteca.jpeg";
				aimglug[6]="Imagenes/zubiarte.jpg";
				aimglug[7]="Imagenes/zubiarte.jpg";
																				
				JFrame f=new VentanaAcusar(aimglug[a.getLugar()]);		
				f.setVisible(true);
			}
			
			public void mouseEntered(MouseEvent e){
				meterImgEnlabel("Imagenes/pushbajo.png",lacusar,100,100);
			}
			public void mouseExited(MouseEvent e){
				meterImgEnlabel("Imagenes/pusharriba.png",lacusar,100,100);
			}
			
		});
		lenviar.addMouseListener( new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
																						
				VentanaCartas ventana = new VentanaCartas();
				ventana.setVisible(true);
			}
			
			
			
		});
		lnotas.addMouseListener( new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
																						
				mibaraja[0][0]=5;
				mibaraja[0][1]=1;
				mibaraja[0][2]=2;
				mibaraja[0][3]=3;
				mibaraja[1][0]=4;
				mibaraja[1][1]=5;
				mibaraja[1][2]=1;
				mibaraja[1][3]=2;
				mibaraja[2][0]=3;
				mibaraja[2][1]=4;
				mibaraja[2][2]=5;
				mibaraja[2][3]=0;
				
				
				g.setVisible(true);
			}
			
			
			
		});
		lchat.addMouseListener( new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
																						
				ventana.setVisible(true);
			}
			
			
			
		});
		
		
		
		
		
	}
	public void meterImgEnlabel(String ruta,JLabel label,int largo,int ancho){
		ImageIcon imicon = new ImageIcon(ventana.class.getResource(ruta));		
		label.setSize(largo,ancho);
		Icon icono = new ImageIcon(imicon.getImage().getScaledInstance(label.getWidth()	, label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
	}
	public void cambiarNumDado(int num){
		if (num==1){
			meterImgEnlabel("Imagenes/dado1.png",ldado,100,100);
		}else if(num==2){
			meterImgEnlabel("Imagenes/dado2.png",ldado,100,100);
		}else if(num==3){
			meterImgEnlabel("Imagenes/dado3.png",ldado,100,100);
		}else if(num==4){
			meterImgEnlabel("Imagenes/dado4.png",ldado,100,100);
		}else if(num==5){
			meterImgEnlabel("Imagenes/dado5.png",ldado,100,100);
		}else{
			meterImgEnlabel("Imagenes/dado6.png",ldado,100,100);
		}
	}
	
	

}

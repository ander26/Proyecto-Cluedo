package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Proyecto.Cluedo.Logica.FicheroCoordenadasPosiciones;

public class Panelcirculos extends JPanel{
	
	public Point [] arrpuertas={new Point(1391,397),new Point(241,120),new Point(209,255),new Point(504,196),new Point(629,113),new Point(1097,289),new Point(1621,185),new Point(1650,325),new Point(1846,174),new Point(1880,334),new Point(1320,771),new Point(573,876),new Point(855,261)};
	private ArrayList<Point>arrpuntmarrones=new ArrayList<Point>();	
	private HashMap<Point,String> hm=new HashMap();

	public Panelcirculos(){
		FicheroCoordenadasPosiciones fcoordenadas=new FicheroCoordenadasPosiciones();
		arrpuntmarrones=fcoordenadas.leerDeFicheroConBarras("cordeenadascirculos.txt");
		
		for(int i=0;i<arrpuntmarrones.size();i++){
			hm.put(arrpuntmarrones.get(i),"marron" );
			
		}
		for(int j=0;j<arrpuertas.length;j++){
			hm.put(arrpuertas[j],"verde" );
		}
	}
	@Override
	public void paint(Graphics g) {
		BufferedImage imagen;
		try {
			imagen = ImageIO.read(getClass().getResource("Imagenes/fondocirculos.png"));
			
			Graphics g3=imagen.getGraphics();
			//Graphics2D g2 = (Graphics2D) g;  
			
			for(Point key:hm.keySet()){
			   String color=hm.get(key);
			 if(color=="marron"){
				 g3.setColor(new Color(170,158,117,255));//Color marron
				 System.out.println("marron");
				 
			}else if(color=="verde"){
				g3.setColor(new Color(24,205,95,255));
				
				 
				
			}else if(color=="rojo"){
				g3.setColor(new Color(219,91,125,255));
				
			}else if(color=="azul"){
				g3.setColor(new Color(57,69,207,255));
				
			}
				
				
			g3.drawOval((int)key.getX()-28,(int)key.getY()-16,55,32 );
			g3.fillOval((int)key.getX()-28,(int)key.getY()-16,55,32 );
			}
			//g2.drawImage( imagen, 0,0, getWidth(), getHeight(), this );
			g.drawImage( imagen, 0,0, getWidth(), getHeight(), this );
			revalidate();
		} catch (IOException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		setOpaque(false);
		super.paint(g);
		
	}
	public void meterOcupado(Point p){
		hm.put(p,"rojo" );
	}
	public void meterPosibilidades(ArrayList<Point> p){
		for(int i=0;i<p.size();i++){
			hm.put(p.get(i),"azul" );
		}
		
	}
	public ArrayList<Point> arrayBuscar(){
		ArrayList<Point> resultado=new ArrayList<Point>();
		for(Point key:hm.keySet()){
			resultado.add(key);
		}return resultado;
	}

}

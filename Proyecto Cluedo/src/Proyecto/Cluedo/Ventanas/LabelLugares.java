package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelLugares extends JLabel{
	
	public boolean seleccionado;
	public String ruta;
	private String nombre;
	private int x;
	private int y;
	private int ancho;
	private int largo;
	
	public LabelLugares(String ruta,String nombre,int x,int y,int ancho,int largo){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.largo=largo;
		setBounds(x, y, ancho, largo);
		ImageIcon iconocarta = new ImageIcon(LabelLugares.class.getResource(ruta));	
		
		Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(this.getWidth()	, this.getHeight(), Image.SCALE_DEFAULT));
		this.setIcon(icono);
		this.setForeground(Color.CYAN);		
		this.ruta=ruta;
		this.seleccionado=false;
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	@Override
	protected void paintComponent(Graphics g) {
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;  
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		if(seleccionado==false){
//			System.out.println("entro");			
			g2.drawImage( img, 0,0,getWidth() ,getHeight(), this );
		}else{
			
			
		}
	}

}

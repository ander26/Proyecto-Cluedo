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

public class personaje extends JLabel {
	public boolean seleccionado;
	public String ruta;
	private String nombre;
	
	public personaje(String ruta,String nombre){
		ImageIcon iconocarta = new ImageIcon(personaje.class.getResource(ruta));	
		setSize(150,250);
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
			System.out.println("entro");			
			g2.drawImage( img, 0,0, 150,250, null );
		}else{
			System.out.println("entro2");
			BufferedImage imagen;
			try {
				imagen = ImageIO.read(getClass().getResource(ruta));
				Graphics g3=imagen.getGraphics();
				g3.setColor(new Color(255,255,0,100));
//				g3.fillRect(0,0,200,350);
				g3.drawOval(0,0,imagen.getWidth(),imagen.getHeight()*2 );
				g3.fillOval(0,0,imagen.getWidth(),imagen.getHeight()*2);
			
				g2.drawImage( imagen, 0,0, 150,250, null );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

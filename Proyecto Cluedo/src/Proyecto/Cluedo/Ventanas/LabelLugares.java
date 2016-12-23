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

//public class LabelLugares extends JLabel{
//	
//	public boolean seleccionado;
//	public String ruta;
//	private String nombre;
//	private int x;
//	private int y;
//	private int ancho;
//	private int largo;
//	
//	public LabelLugares(String ruta,String nombre,int x,int y,int ancho,int largo){
//		this.x=x;
//		this.y=y;
//		this.ancho=ancho;
//		this.largo=largo;
//		setBounds(x, y, ancho, largo);
//		ImageIcon iconocarta = new ImageIcon(LabelLugares.class.getResource(ruta));	
//		
//		Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(this.getWidth()	, this.getHeight(), Image.SCALE_DEFAULT));
//		this.setIcon(icono);
//		this.setForeground(Color.CYAN);		
//		this.ruta=ruta;
//		this.seleccionado=false;
//		this.nombre=nombre;
//	}
//	public String getNombre() {
//		return nombre;
//	}
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//	public boolean isSeleccionado() {
//		return seleccionado;
//	}
//	public void setSeleccionado(boolean seleccionado) {
//		this.seleccionado = seleccionado;
//	}
//	@Override
//	protected void paintComponent(Graphics g) {
//		Image img = ((ImageIcon)getIcon()).getImage();
//		Graphics2D g2 = (Graphics2D) g;  
//		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//		if(seleccionado==false){
//			System.out.println("entro");			
//			g2.drawImage( img, 0,0,getWidth() ,getHeight(), this );
//		}else{
//			
//			
//		}

import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelLugares extends JLabel {

	
	public boolean seleccionado;
	public String ruta;
	private String nombre;
	private int x;
	private int y;
	private int ancho;
	private int largo;

	private BufferedImage imagen;
	
	private int c1=0;
	
	private int c2=0;
	
	private int c3=0;
	
	

	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public int getC3() {
		return c3;
	}

	public void setC3(int c3) {
		this.c3 = c3;
	}

	public LabelLugares(String ruta, String nombre, int x, int y, int ancho, int largo) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.largo = largo;
		setBounds(x, y, ancho, largo);
		ImageIcon iconocarta = new ImageIcon(LabelLugares.class.getResource(ruta));
		//
		// Icon icono = new
		// ImageIcon(iconocarta.getImage().getScaledInstance(this.getWidth() ,
		// this.getHeight(), Image.SCALE_DEFAULT));
		//
		//
		// this.setIcon(icono);

		// this.setForeground(Color.CYAN);

		try {
			imagen = ImageIO.read(getClass().getResource(ruta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.ruta = ruta;
		this.seleccionado = false;
		this.nombre = nombre;
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
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (seleccionado == false) {
			// System.out.println("entro");
		

			try {
				imagen = ImageIO.read(getClass().getResource(ruta));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		} else {
			imagen = colorImage(imagen,c1,c2,c3);
			g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		}
	}

	private static BufferedImage colorImage(BufferedImage image,int c1,int c2,int c3) {
		int width = image.getWidth();
		int height = image.getHeight();
		WritableRaster raster = image.getRaster();

		for (int xx = 0; xx < width; xx++) {
			for (int yy = 0; yy < height; yy++) {
				int[] pixels = raster.getPixel(xx, yy, (int[]) null);
				pixels[0] = c1;
				pixels[1] = c2;
				pixels[2] = c3;
				
				
				raster.setPixel(xx, yy, pixels);
			}
		}
		return image;

	}

}

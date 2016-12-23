package Proyecto.Cluedo.Datos;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class LabelPerfil extends JLabel{

	private int altura;
	
	private int anchura;
	
	private ImageIcon imagen;
	
	
	public LabelPerfil(){
		
	}
	
	public LabelPerfil(ImageIcon imagen,int x,int y,int altura,int anchura) {
		
		this.altura=altura;
		
		this.anchura=anchura;
		
		
		setBounds(x,y,anchura,altura);
		
		this.imagen=imagen;
		
		try {
			setIcon(this.imagen );
		} catch (Exception e) {
			System.out.println( "Error en carga de recurso" );
			e.printStackTrace();
		}
		
		
		
	}
	
	public void setImagen (ImageIcon imagen){
		this.imagen=imagen;
		
		try {
			setIcon(this.imagen );
		} catch (Exception e) {
			System.out.println( "Error en carga de recurso" );
			e.printStackTrace();
		}
		
		
	}
	
	@Override

	protected void paintComponent(Graphics g) {
		
		
		Image img = ((ImageIcon) getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g; 
		
		
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		 
		Ellipse2D ellipse = new Ellipse2D.Float();
		Rectangle2D rect = new Rectangle2D.Float();
		
		ellipse.setFrame(0, 0, anchura, altura);
		g2.setClip(ellipse);
		rect.setRect(0, 0, anchura, altura);
		g2.clip(rect);
		
		g2.drawImage(img, 0, 0, anchura, altura, null);
		
		
		
		
	}
	


		public void cambiarTamaño (int anchura, int altura){
				setSize(new Dimension(anchura, altura));
			}
			
			public void cambiarPosicion (int X, int Y){
				setLocation(X,Y);
			}
			
			
	
	
}

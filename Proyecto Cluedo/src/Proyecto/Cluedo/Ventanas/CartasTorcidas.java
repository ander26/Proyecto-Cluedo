package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class CartasTorcidas extends JLabel {
	double beta;
	boolean oscuro=false;
	String ruta;
	
	
	public CartasTorcidas(String ruta,double beta) throws MalformedURLException, URISyntaxException{
		ImageIcon iconocarta = new ImageIcon(ventana.class.getResource(ruta));	
		setSize(800,1000);
		Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(this.getWidth()	, this.getHeight(), Image.SCALE_DEFAULT));
		this.setIcon(icono);
		//setIcon( new ImageIcon( CartasTorcidas.class.getResource( ruta)) );
		// setBorder( BorderFactory.createLineBorder( Color.yellow, 4 ));
		this.beta=beta;
		this.ruta=ruta;
	}
	@Override
	protected void paintComponent(Graphics g) {		
System.out.println("entro en paint componet");
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;  
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
       	g2.rotate( beta,  getIcon().getIconWidth()/2, getIcon().getIconHeight()/2 ); // getIcon().getIconWidth()/2, getIcon().getIconHeight()/2 );
        // Dibujado de la imagen  
       	if(oscuro==false){
        g2.drawImage( img, 50,200, 200,300, null );
       	}else{        
       //	BufferedImage bfimg;
       		g2.drawImage( img, 50, 0, 200,300, null );
           	
//        ColorConvertOp ccop=new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY),null);
//		Image imgb=ccop.filter(bfimg,null);
		 //g2.drawImage( img, 50, 50, 200,300, null ); 
       	}
	}
	public boolean isOscuro() {
		return oscuro;
	}
	public void setOscuro(boolean oscuro) {
		this.oscuro = oscuro;
	}
}

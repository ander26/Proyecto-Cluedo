package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.sun.image.codec.*;



public class CartasTorcidas extends JLabel {
	double beta;
	boolean oscuro=false;
	private String nombre;
	String ruta;
	
	
	public CartasTorcidas(String ruta,double beta,String nombre) throws MalformedURLException, URISyntaxException{
		ImageIcon iconocarta = new ImageIcon(CartasTorcidas.class.getResource(ruta));	
		setSize(850,650);
		Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(this.getWidth()	, this.getHeight(), Image.SCALE_DEFAULT));
		this.setIcon(icono);
		//setIcon( new ImageIcon( CartasTorcidas.class.getResource( ruta)) );
		// setBorder( BorderFactory.createLineBorder( Color.yellow, 4 ));
		this.beta=beta;
		this.ruta=ruta;
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
       		BufferedImage imagen;
       		try {
				imagen = ImageIO.read(getClass().getResource(ruta));
				Graphics g3=imagen.getGraphics();
				g3.setColor(new Color(255,255,0,100));
				g3.fillRect(0,0,100,150);
				
//				JPEGImageDecoder decoder=JPEGCodec.createJPEGDecoder(getClass().getResource(ruta));
//				RescaleOp rop= new RescaleOp(componentes,desplazamiento,null);
//				BufferedImage destino=rop.filter(imagen, null);
	    		//Color c2=new Color(blue+20,green,red);
	    		//.setRGB(0,0, blue);	    		
				g2.drawImage( imagen, 550,320, 100,150, null );
	           	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//       		BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
//       		        BufferedImage.TYPE_INT_RGB);
    		
    		
    		//bufferedImage.setRGB(0,0,50);
    			
    		
        //g2.drawImage( img, 550,320, 100,150, null );
       	}else{        
       //	BufferedImage bfimg;
       		g2.drawImage( img, 550, 120, 125,175, null );
           	
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

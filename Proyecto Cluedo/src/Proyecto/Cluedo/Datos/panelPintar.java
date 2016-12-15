package Proyecto.Cluedo.Datos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class panelPintar extends JPanel{

	private BufferedImage imagen;
	
	
	public panelPintar ( int tamHor, int tamVer) {
		
		setOpaque(false);
		
		imagen = new BufferedImage( tamHor, tamVer, BufferedImage.TYPE_INT_ARGB );
		
		// ((Graphics2D)(imagen.getGraphics())).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	public Graphics2D getGraphics() {
		return (Graphics2D) imagen.getGraphics();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (imagen!=null) {
			Graphics2D gr2 = (Graphics2D) g;
			gr2.drawImage(imagen, 0, 0, null);
		}
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

	
	
}

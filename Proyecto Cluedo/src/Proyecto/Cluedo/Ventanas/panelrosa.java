 package Proyecto.Cluedo.Ventanas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
//...

public class panelrosa extends JPanel{

	 
	
	
	
	private Image imagen;
	
    
	    
	 
	    public panelrosa(Image imagen) {
		
		this.imagen = imagen;
		
	}




		//...
	 
	    @Override
	    public void paint(Graphics g) {
	        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
	                        this);
	 
	        setOpaque(false);
	        super.paint(g);
	    }
	 
	    //...
	}



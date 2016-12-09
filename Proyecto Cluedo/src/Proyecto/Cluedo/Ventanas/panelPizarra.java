package Proyecto.Cluedo.Ventanas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class panelPizarra extends JPanel {
	

		 
		
		
		
		private Image imagen;
		private Point pAnt = null;
		private boolean pintando=false;
		
		
		private Point x;
	    
		    
		 
		    public panelPizarra() {
			
			this.imagen = imagen;
			this.addMouseMotionListener( new MouseMotionListener() {
				
				@Override
				public void mouseDragged(MouseEvent e) {
					x=e.getPoint();
					System.out.println(x+""+pAnt);
					repaint();
					
				}
				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}




			//...
		 
		    @Override
		    public void paint(Graphics g) {
		    	
		        //g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
		                        //this);
		    	g.drawLine( 2,5,9,10 );
		       // setOpaque(false);
		       // super.paint(g);
		    	Logger.getLogger(getClass().getName()).log(Level.INFO, "pintando");
    			
		        	g.setColor( Color.green );
					// g.setStroke( new BasicStroke( 1.5f ) );
					if (pAnt!=null) {
						Logger.getLogger(getClass().getName()).log(Level.INFO, "dentro del if");
		    			
						g.drawLine( pAnt.x, pAnt.y,(int) x.getX(), (int)x.getY() ); 
						
		    			
						// Dibuja líneas al arrastrar
					}
					pAnt = x;
		        
		        super.paint(g);
		    }
		 
		    //...
		    public static void main(String[] args) {
				JFrame frame = new JFrame("Mini Tennis");
				frame.add(new panelPizarra());
				frame.setSize(300, 300);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}



package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ventanaSocial extends JFrame{

	
	public static void main(String [] args){
		
		ventanaSocial ventana = new ventanaSocial();
		
		ventana.setVisible(true);
		
	}
	
	public ventanaSocial(){
		
		
		//Establecemos el formato
		
		setSize(320,160);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		//Generamos los componentes
		
		JLabel labelFacebook = new JLabel();
		
		JLabel labelTwitter = new JLabel();
		
		ImageIcon imagen = new ImageIcon();
		
		Icon icono;
		
		labelFacebook.setSize(300,70);
		
		try{
			imagen=new ImageIcon(ventanaSocial.class.getResource("Imagenes/facebook.png").toURI().toURL());
		}catch(Exception e){
			
		}
		
		icono= new ImageIcon(imagen.getImage().getScaledInstance(labelFacebook.getWidth(), labelFacebook.getHeight(), Image.SCALE_DEFAULT));
		
		labelFacebook.setIcon(icono);
		
		labelTwitter.setSize(300,50);
		
		
		
		try{
			imagen=new ImageIcon(ventanaSocial.class.getResource("Imagenes/twitter.gif").toURI().toURL());
		}catch(Exception e){
			
		}
		
		icono= new ImageIcon(imagen.getImage().getScaledInstance(labelTwitter.getWidth(), labelTwitter.getHeight(), Image.SCALE_DEFAULT));
		
		labelTwitter.setIcon(icono);
		
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		
	
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		panel.add(labelFacebook);
		
		panel.add(labelTwitter);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		
		labelFacebook.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			    try {

		            Desktop.getDesktop().browse(new URI("http://www.facebook.com"));

		        } catch (URISyntaxException ex) {

		            System.out.println(ex);

		        }catch(IOException r){

		            System.out.println(e);

		        }
			}
		});
		
		labelTwitter.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
			    try {

		            Desktop.getDesktop().browse(new URI("http://www.twitter.com"));

		        } catch (URISyntaxException ex) {

		            System.out.println(ex);

		        }catch(IOException r){

		            System.out.println(e);

		        }
				
			}
		});
	}
}

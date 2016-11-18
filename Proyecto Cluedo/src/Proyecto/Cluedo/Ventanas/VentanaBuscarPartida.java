package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaBuscarPartida extends JFrame{

	public static void main (String [] args){
		
		VentanaBuscarPartida ventana= new VentanaBuscarPartida();
		ventana.setVisible(true);
		
	}
	
	public VentanaBuscarPartida (){
		
		//Establecemos el formato al panel 
		
		setResizable(false);
		
		setSize(new Dimension(800, 600));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		getContentPane().setBackground(Color.WHITE);
		
		//Generamos los componentes
		
		ImageIcon imagen= new ImageIcon();
		
		Icon icono;
		
		JLabel carretera= new JLabel();
		
		JLabel carreteraInvertida= new JLabel();
		
		JLabel poste= new JLabel();
		
		JLabel fondo= new JLabel();
		
		JLabel labelTitulo= new JLabel();
		
		JLabel labelTitulo2= new JLabel();
		
		ScrollPane panelIzquierdo = new ScrollPane();
		
		ScrollPane panelDerecho = new ScrollPane();
		
		JLabel label = new JLabel("Adentrate en un mundo misterioso");
		
		
		
		//Establecemos el formato
		
		carretera.setBounds(14, 269, 386, 332);
		
		try{
			imagen=new ImageIcon(VentanaBuscarPartida.class.getResource("Imagenes/carreteraInvertida.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		icono= new ImageIcon(imagen.getImage().getScaledInstance(carretera.getWidth(), carretera.getHeight(), Image.SCALE_DEFAULT));
		
		carretera.setIcon(icono);
	
	
		carreteraInvertida.setBounds(380,269, 404, 332);
		
		try{
			imagen=new ImageIcon(VentanaBuscarPartida.class.getResource("Imagenes/carretera.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		icono= new ImageIcon(imagen.getImage().getScaledInstance(carreteraInvertida.getWidth(), carreteraInvertida.getHeight(), Image.SCALE_DEFAULT));
		
		carreteraInvertida.setIcon(icono);
		
		
		poste.setBounds(305, 245, 207, 274);
		try{
			imagen=new ImageIcon(VentanaBuscarPartida.class.getResource("Imagenes/arbol.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		icono= new ImageIcon(imagen.getImage().getScaledInstance(poste.getWidth(), poste.getHeight(), Image.SCALE_DEFAULT));
		
		poste.setIcon(icono);
	
		fondo.setBounds(0, 52, 800, 297);
		
		try{
			imagen=new ImageIcon(VentanaBuscarPartida.class.getResource("Imagenes/skyline.jpg").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		icono= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
		
		fondo.setIcon(icono);
		
		String[] columnNames = {"Nombre Partida", "N. Actual", "N.Maximo","Unirse"};
		Object[][] data =
		{
		    {"Homer", "Simpson", "delete Homer"},
		    {"Madge", "Simpson", "delete Madge"},
		    {"Bart",  "Simpson", "delete Bart"},
		    {"Lisa",  "Simpson", "delete Lisa"},
		};
		 
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable( model );
	
		panelIzquierdo.setBounds(45, 178, 244, 256);
		
		panelDerecho.setBounds(518, 178, 244, 256);
		
		label.setBounds(148,32, 531, 41);
		
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
		
		//Añadimos al panel
		
		getContentPane().setLayout(null);
		
		
		

		panelIzquierdo.add(table);
		
		panelDerecho.add(table);
		
		getContentPane().add(label);
		
		getContentPane().add(panelIzquierdo);
		
		getContentPane().add(panelDerecho);
		
		getContentPane().add(carretera);

		getContentPane().add(carreteraInvertida);

		getContentPane().add(poste);

		getContentPane().add(fondo);
		
		
	}
}

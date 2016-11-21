package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;

public class VentanaRanking2 extends JFrame{
	
	private static final int ANCHURA=900;
	
	private static final int ALTURA = 600;

	private JList<String> lista;
	
	private ArrayList<Usuario> ALUsuarios;
	
	private GestionBaseDeDatos base = new GestionBaseDeDatos();
	
	private JScrollPane panel = new JScrollPane();
	
	private LabelPerfil labelFotoP;
	
	private JLabel labelPuntuacion = new JLabel ();
	
	private static HashMap<Object,Rectangle> tamComponentes = new HashMap<>();
	
	public VentanaRanking2 (Connection conexion){
		
		
		//Establecemos el formato
		
		setSize(900,600);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//Generamos los componentes
		
		LabelPerfil labelFoto1;
		
		LabelPerfil labelFoto2;
		
		LabelPerfil labelFoto3;
		
		ImageIcon imagen= new ImageIcon();
		
		Icon icono;
		
		//Establecemos el formato
		
		ALUsuarios=base.consultaATablaOrdenadoPuntuacion(conexion);	
		
		RellenarLista(ALUsuarios);
				
		
		lista.setCellRenderer(miListRenderer);;
		
		
		
		
		try {
			imagen = new ImageIcon(VentanaRanking2.class.getResource("Imagenes/fondoRanking.png").toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panelrosa panelCentro = new panelrosa (imagen.getImage());
		
		panel.setBounds(47, 158, 142, 342);
		
		panel.add(lista);
		
		
		
		try {
			imagen = new ImageIcon(ALUsuarios.get(0).getImagenPerfil().getImage());
		} catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		labelFoto1 = new LabelPerfil(imagen, 736, 470, 95, 95);
		
		
		
		
		
		try {
			imagen = new ImageIcon(ALUsuarios.get(1).getImagenPerfil().getImage());
		} catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		labelFoto2= new LabelPerfil(imagen, 667, 463, 76, 79);
		
		
		
		
		try {
			imagen = new ImageIcon(ALUsuarios.get(2).getImagenPerfil().getImage());
		} catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		labelFoto3=new LabelPerfil(imagen, 827, 485, 66, 66);
		
		try {
			imagen = new ImageIcon(ALUsuarios.get(0).getImagenPerfil().getImage());
		} catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		labelFotoP= new LabelPerfil(imagen, 350, 200, 200, 200);
		
	
		
		labelPuntuacion.setText("<html><body><DIV ALIGN=center>"+ALUsuarios.get(0).getNombre()+"<br>"+"Puntuacion: "+ALUsuarios.get(0).getPuntuacion()+"</div></body></html>");
		
		labelPuntuacion.setBounds(387, 56, 128, 65);
		
		labelPuntuacion.setForeground(Color.YELLOW.darker());
		
		labelPuntuacion.setFont(new Font("System", Font.BOLD, 24));
	
		//Añadimos al panel
		
		getContentPane().setLayout(new BorderLayout());
		
		panelCentro.setLayout(null);
		
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		panelCentro.add(labelFoto1);
		
		panelCentro.add(labelFoto2);
		
		panelCentro.add(labelFoto3);
		
		panelCentro.add(labelFotoP);
		
		panelCentro.add(labelPuntuacion);
		
		panelCentro.add(panel);
		
		// Eventos para gestionar el reescalado
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {  // Al activarse la ventana almacenamos el tamaño del panel
				
				for (Component c : panelCentro.getComponents()) {
					tamComponentes.put( c, c.getBounds() );  // Guardamos el tamaño y posición inicial de cada componente para luego escalarlo con él
				}
			}
		});
		
		
		//Generamos los eventos 
		
		addComponentListener( new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {  // Al redimensionarse el panel, reajustamos sus componentes
				
					double escalaX = getContentPane().getWidth() /(double)ANCHURA ;   // Nueva escala X
					double escalaY = getContentPane().getHeight() /(double) ALTURA; // Nueva escala Y
					
					
					for (Component c : panelCentro.getComponents()) {
						Rectangle tamanyoInicial = tamComponentes.get( c );
						if (c!=null) {
							panelCentro.remove(c);
							c.setBounds( (int) (tamanyoInicial.getX() * escalaX), (int) (tamanyoInicial.getY() * escalaY),
						(int) (tamanyoInicial.getWidth() * escalaX), (int) (tamanyoInicial.getHeight()* escalaY));
							panelCentro.add(c);
							
						}
					}
					
					lista.addListSelectionListener(new ListSelectionListener() {
					      public void valueChanged(ListSelectionEvent evt) {
					    	  int num=lista.getSelectedIndex();
					    	 
					    	  
								
					    	  
					    	  labelFotoP.setImagen(ALUsuarios.get(num).getImagenPerfil());
					    	  

					  		labelPuntuacion.setText("<html><body><DIV ALIGN=center>"+ALUsuarios.get(0).getNombre()+"<br>"+"Puntuacion: "+ALUsuarios.get(0).getPuntuacion()+"</div></body></html>");
					  		
							  panelCentro.revalidate();
							 						
					      }
					      });
				}
			
	});
		
		
	}
	
	
	public void RellenarLista(ArrayList<Usuario> arrayl){			
		lista=new JList<String>();
		String []arr=new String[arrayl.size()];
		for(int i=0;i<arrayl.size();i++){
			arr[i]=arrayl.get(i).getUsuario();
		}
		lista.setListData(arr);
	}
	
	//Codigo cogido de la practica 1
	
	private DefaultListCellRenderer miListRenderer = new DefaultListCellRenderer() {
		private static final long serialVersionUID = 1L;
		@Override
		public Component getListCellRendererComponent(
				JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			JLabel miComp = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			 miComp.setForeground( Color.red.darker() );
			 miComp.setFont(new Font("System", Font.BOLD, 14));
			 miComp.setBackground(Color.WHITE);
			return miComp;
		}
	};


}

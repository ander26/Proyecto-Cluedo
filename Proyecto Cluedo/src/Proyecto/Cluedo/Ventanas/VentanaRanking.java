
package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.Renderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Proyecto.Cluedo.Datos.Genero;
import Proyecto.Cluedo.Datos.LabelPerfil;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;


//<<<<<<< HEAD
//
//
//// Establecemos el formato
//
//setSize(915, 634);
//
//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//
//setMinimumSize(new Dimension(915,634));
//
//// Generamos los componentes
//
//
//
//ImageIcon imagen = new ImageIcon();
//
//Icon icono;
//
//// Establecemos el formato
//
//ALUsuarios = base.consultaATablaOrdenadoPuntuacion(conexion);
//
//RellenarLista(ALUsuarios);
//
//lista.setCellRenderer(miListRenderer);
//;
//
//// lista.setOpaque(false);
//
//try {
//	imagen = new ImageIcon(VentanaRanking.class.getResource("Imagenes/fondoRanking.png").toURI().toURL());
//} catch (MalformedURLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} catch (URISyntaxException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
//panelrosa panelCentro = new panelrosa(imagen.getImage());
//
//JScrollPane panel = new JScrollPane(lista);
//panel.setBounds(47, 158, 142, 342);
//panel.setBackground(Color.white);
//
//try {
//	imagen = new ImageIcon(ALUsuarios.get(0).getImagenPerfil().getImage());
//} catch (Exception e) {
//	System.out.println("No se encuentra el archivo");
//}
//
//labelFoto1 = new LabelPerfil(imagen, 736, 470, 95, 95);
//
//try {
//	imagen = new ImageIcon(ALUsuarios.get(1).getImagenPerfil().getImage());
//} catch (Exception e) {
//	System.out.println("No se encuentra el archivo");
//}
//
//labelFoto2 = new LabelPerfil(imagen, 667, 463, 76, 79);
//
//try {
//	imagen = new ImageIcon(ALUsuarios.get(2).getImagenPerfil().getImage());
//} catch (Exception e) {
//	System.out.println("No se encuentra el archivo");
//}
//
//labelFoto3 = new LabelPerfil(imagen, 827, 485, 66, 66);
//
//try {
//	imagen = new ImageIcon(ALUsuarios.get(0).getImagenPerfil().getImage());
//} catch (Exception e) {
//	System.out.println("No se encuentra el archivo");
//}
//
//labelFotoP = new LabelPerfil(imagen, 340, 185, 220, 220);
//
//labelPuntuacion.setText("<html><body><DIV ALIGN=center>" + ALUsuarios.get(0).getNombre() + "<br>"
//		+ "Puntuacion <br>" + ALUsuarios.get(0).getPuntuacion() + "</div></body></html>");
//
//labelPuntuacion.setBounds(384, 40, 140, 90);
//
//labelPuntuacion.setForeground(Color.YELLOW.darker());
//
//labelPuntuacion.setFont(new Font("System", Font.BOLD, 24));
//
//// Añadimos al panel
//
//getContentPane().setLayout(new BorderLayout());
//
//panelCentro.setLayout(null);
//
//getContentPane().add(panelCentro, BorderLayout.CENTER);
//
//panelCentro.add(labelFoto1);
//
//panelCentro.add(labelFoto2);
//
//panelCentro.add(labelFoto3);
//
//panelCentro.add(labelFotoP);
//
//panelCentro.add(labelPuntuacion);
//
//panelCentro.add(panel);
//
//
//
//// Generamos los eventos
//
//addComponentListener(new ComponentAdapter() {
//	@Override
//	public void componentResized(ComponentEvent e) { // Al
//														// redimensionarse
//														// el panel,
//														// reajustamos
//														// sus
//														// componentes
//
//		double escalaX = getContentPane().getWidth() / (double) ANCHURA; // Nueva
//		// escala
//		// X
//		double escalaY = getContentPane().getHeight()  / (double) ALTURA ; // Nueva
//					// escala
//					// Y
//
//		panelCentro.remove(panel);
//			
//		panel.setBounds((int) (X[0] * escalaX), (int) (Y[0] * escalaY),
//					(int) (Anchura[0] * escalaX), (int) (Altura[0] * escalaY));
//		
//		panelCentro.add(panel);
//		
//		panelCentro.remove(labelPuntuacion);
//		
//		
//		
//		labelPuntuacion.setLocation((getContentPane().getWidth()/2-Anchura[1]/2), (int) (Y[1] * (escalaY)));
//	
//		
//		panelCentro.add(labelPuntuacion);
//		
//		panelCentro.remove(labelFotoP);
//		
//		labelFotoP= new LabelPerfil (ALUsuarios.get(contador).getImagenPerfil(),(int) (X[2] * escalaX), (int) (Y[2] * escalaY),
//				(int) (Anchura[2] * escalaY), (int) (Altura[2] * escalaX));
//		
//		panelCentro.add(labelFotoP);
//		
//		panelCentro.remove(labelFoto1);
//		
//		labelFoto1= new LabelPerfil(ALUsuarios.get(0).getImagenPerfil(),(int) (X[4] * escalaX), (int) (Y[4] * escalaY),
//				(int) (Anchura[4] * escalaY), (int) (Altura[4] * escalaX));
//		
//		panelCentro.add(labelFoto1);
//		
//		panelCentro.remove(labelFoto2);
//		
//		labelFoto2=new LabelPerfil(ALUsuarios.get(1).getImagenPerfil(),(int) (X[3] * escalaX), (int) (Y[3] * escalaY),
//				(int) (Anchura[3] * escalaY), (int) (Altura[3] * escalaX));
//		
//		panelCentro.add(labelFoto2);
//		
//		panelCentro.remove(labelFoto3);
//		
//		labelFoto3=new LabelPerfil(ALUsuarios.get(2).getImagenPerfil(),(int) (X[5] * escalaX), (int) (Y[5] * escalaY),
//				(int) (Anchura[5] * escalaY), (int) (Altura[5] * escalaX));
//		
//		panelCentro.add(labelFoto3);
//		
//	
//		 }
//});
//
//lista.addListSelectionListener(new ListSelectionListener() {
//	public void valueChanged(ListSelectionEvent evt) {
//		int num = lista.getSelectedIndex();
//
//		contador = num;
//		
//		labelFotoP.setImagen(ALUsuarios.get(num).getImagenPerfil());
//
//		labelPuntuacion.setText("<html><body><DIV ALIGN=center>" + ALUsuarios.get(num).getNombre() + "<br>"
//				+ "Puntuacion <br>" + ALUsuarios.get(num).getPuntuacion() + "</div></body></html>");
//
//		panelCentro.revalidate();
//		
//
//	}
//
//});
//}
//
//public void RellenarLista(ArrayList<Usuario> arrayl) {
//lista = new JList<String>();
//String[] arr = new String[arrayl.size()];
//for (int i = 0; i < arrayl.size(); i++) {
//	arr[i] = arrayl.get(i).getUsuario();
//}
//lista.setListData(arr);
//}

// Codigo cogido de la practica 1

class miListRenderer implements ListCellRenderer {
	  protected static Border noFocusBorder = new EmptyBorder(15, 1, 1, 1);

	  protected static TitledBorder focusBorder = new TitledBorder(LineBorder.createGrayLineBorder(),
	      "Seleccionado");

	  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	  public Component getListCellRendererComponent(JList list, Object value, int index,
	      boolean isSelected, boolean cellHasFocus) {


	    JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
	        isSelected, cellHasFocus);
	    renderer.setBackground(Color.white);
	    if (cellHasFocus){
	    renderer.setForeground(Color.black);	
	    }else{
	    renderer.setForeground(Color.red.darker());
	    }
	    
	    renderer.setFont(new Font("System", Font.BOLD, 14));
	    renderer.setBorder(cellHasFocus ? focusBorder : noFocusBorder);
	    return renderer;
	  }

}



public class VentanaRanking extends JFrame{
	
	private JPanel pderecho=new JPanel();
	private JPanel pmedio=new JPanel();
	private JPanel pizquierdo=new JPanel();
	private panelrosa pprincipal;
	private JPanel patriloro=new JPanel();
	private JPanel patrilbronce=new JPanel();
	private JPanel patrilplata=new JPanel();
	private JLabel lcopaoro=new JLabel();
	private JLabel lcopabronce =new JLabel();
	private JLabel lcopaplata=new JLabel();
	private JLabel latriloro=new JLabel();
	private JLabel latrilbronce=new JLabel();
	private JLabel latrilplata=new JLabel();
	private JLabel lpodium=new JLabel();
	private JLabel lcartel=new JLabel();
	private panelrosa plista;
	private panelrosa pcartel;
	private JLabel puntos=new JLabel("<html><body> <br> <br> <br> <br> &nbsp;&nbsp; &nbsp;&nbsp;       PUNTOS &nbsp;&nbsp;&nbsp;&nbsp;       <br>  <br> <br>  </body></html>");
	private JPanel parriba=new JPanel();
	private JList<String> lista;
	private ScrollPane pslista=new ScrollPane();
	private JPanel ppodium=new JPanel();
	
	private JPanel pfotodos=new JPanel();
	private JPanel pfoto=new JPanel();
	private JLabel marcoArriba=new JLabel("<html><body> <br> <br> </body></html>");
	private JLabel marcoAbajo=new JLabel("<html><body> <br> <br> </body></html>");
	private JLabel marcoDerecha=new JLabel("                ");
	private JLabel marcoIzquierda=new JLabel("           ");
	
	//private JPanel ppodium=new JPanel();
	private int num;
	
	private LabelPerfil foto=new LabelPerfil(null,0,0,200,200);
	
	
	private GestionBaseDeDatos base=new GestionBaseDeDatos();
	private ArrayList<Usuario> ALUsuarios;
	//Codigo cogido de la practica 1
	
	
	
	
	
	//public VentanaRanking(Connection conexion,GestionBaseDeDatos gestion){
		public VentanaRanking(Connection con){
			ALUsuarios=base.consultaATablaOrdenadoPuntuacion(con);	
			RellenarLista(ALUsuarios);
			PonerGanadores();			
			
			ListCellRenderer renderer = new miListRenderer();
			
			lista.setCellRenderer(renderer);
			
			lista.setSelectedIndex(0);
			
			
			setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );	
			setSize( 1330, 830 );					
			setResizable( true );
			ImageIcon imagefondo = new ImageIcon(VentanaRanking.class.getResource("Imagenes/fondo2.jpg"));
			ImageIcon imagecartel = new ImageIcon(VentanaRanking.class.getResource("Imagenes/cartel.png"));
			//ImageIcon imagefondopodium = new ImageIcon(VentanaRanking.class.getResource("Imagenes/podiumrojo.png"));
								
			//Layout
			pslista.setBackground(Color.WHITE);
			lista.setOpaque(false);
		
			puntos.setFont(new Font("ITALIC",Font.BOLD,30));
			puntos.setForeground(Color.YELLOW);
			pfoto.add(foto);
			ppodium.add(lpodium);
			pprincipal=new panelrosa(imagefondo.getImage());
			pcartel=new panelrosa(imagecartel.getImage());
			//pmedio=new panelrosa(imagefondopodium.getImage());
			pprincipal.setOpaque(false);
			pderecho.setOpaque(false);
			//foto.setAlignmentX(LEFT_ALIGNMENT);
			pfotodos.setLayout(new BorderLayout());
			pfotodos.setOpaque(false);
			ppodium.setOpaque(false);
			pmedio.setOpaque(false);
			//pmedio.setBackground(Color.BLACK);
			pizquierdo.setOpaque(false);
			patriloro.setOpaque(false);
			patrilbronce.setOpaque(false);
			patrilplata.setOpaque(false);
			pcartel.setOpaque(true);			
			pfoto.setOpaque(false);
			parriba.setOpaque(false);
			ImageIcon imagefondolista = new ImageIcon(VentanaRanking.class.getResource("Imagenes/panel.png"));
			plista=new panelrosa(imagefondolista.getImage());
			plista.setLayout(new BorderLayout());
			plista.add(marcoArriba,BorderLayout.NORTH);
			plista.add(marcoAbajo,BorderLayout.SOUTH);
			plista.add(marcoDerecha,BorderLayout.EAST);
			plista.add(marcoIzquierda,BorderLayout.WEST);			
			pslista.add(lista);
			pslista.setSize(200,600);
			plista.add(pslista,BorderLayout.CENTER);
			pprincipal.setLayout(new BoxLayout(pprincipal,BoxLayout.X_AXIS));
			//pderecho.setLayout(null);
			pmedio.setLayout(new BoxLayout(pmedio,BoxLayout.Y_AXIS));
			pizquierdo.setAlignmentX(LEFT_ALIGNMENT);
			pderecho.setAlignmentX(RIGHT_ALIGNMENT);
			pmedio.setAlignmentX(CENTER_ALIGNMENT);			
			pizquierdo.setLayout(new BoxLayout(pizquierdo,BoxLayout.X_AXIS));
			patriloro.setLayout(new BoxLayout(patriloro,BoxLayout.Y_AXIS));
			patrilbronce.setLayout(new BoxLayout(patrilbronce,BoxLayout.Y_AXIS));
			patrilplata.setLayout(new BoxLayout(patrilplata,BoxLayout.Y_AXIS));
			meterImgEnlabel("Imagenes/copa.png",lcopaoro,100,100);
			meterImgEnlabel("Imagenes/bronce.png",lcopabronce,100,100);
			meterImgEnlabel("Imagenes/plata.png",lcopaplata,100,100);
			meterImgEnlabel("Imagenes/columna.png",latriloro,100,300);
			meterImgEnlabel("Imagenes/columna.png",latrilplata,100,300);
			meterImgEnlabel("Imagenes/columna.png",latrilbronce,100,300);
			meterImgEnlabel("Imagenes/podium.png",lpodium,600,400);
			meterImgEnlabel("Imagenes/cartel.png",lcartel,300,200);
			//add
		
			pcartel.add(puntos);
			parriba.add(pcartel);
			//Icon icono = new ImageIcon(u.getImagenPerfil().getImage().getScaledInstance(foto.getWidth()	, foto.getHeight(), Image.SCALE_DEFAULT));
			//foto.setIcon(icono);
			//foto.setAlignmentX(CENTER_ALIGNMENT);			
			patrilplata.add(lcopaoro);
			patrilplata.add(latrilplata);
			patriloro.add(lcopaplata);
			patriloro.add(latriloro);
			patrilbronce.add(lcopabronce);
			patrilbronce.add(latrilbronce);
			pizquierdo.add(patriloro);
			pizquierdo.add(patrilplata);
			pizquierdo.add(patrilbronce);
			//pmedio.add(lcartel);
			//ppodium.add(lpodium);
			pfotodos.add(pfoto,BorderLayout.SOUTH);
			pderecho.add(plista);
			pmedio.add(parriba);
			pmedio.add(pfotodos);
			pmedio.add(ppodium);			
			//pmedio.add(ppodium,BorderLayout.SOUTH);
			//pprincipal.add(pcartel);
			
//			pprincipal.add(parriba, BorderLayout.NORTH);
			pprincipal.add(pizquierdo);
			pprincipal.add(pmedio);					
			pprincipal.add(pderecho);			
			getContentPane().add(pprincipal);
			
			foto.setSize(200,200);	
			
	    	  Icon icono = new ImageIcon(ALUsuarios.get(0).getImagenPerfil().getImage().getScaledInstance(foto.getWidth()	, foto.getHeight(), Image.SCALE_DEFAULT));
			  foto.setIcon(icono);
			  
			  foto.setAlignmentX(CENTER_ALIGNMENT);	
			  
			  
			  pfoto.add(foto);
			  
			  
			  puntos.setText("<html><body> <br> <br> <P ALIGN=center> "+ALUsuarios.get(num).getPuntuacion()+"<br> <br> &nbsp;&nbsp; &nbsp;&nbsp;       PUNTOS &nbsp;&nbsp;&nbsp;&nbsp;       <br>  <br> <br></body></html> ");
			  pprincipal.revalidate();
			  
			lista.addListSelectionListener(new ListSelectionListener() {
			      public void valueChanged(ListSelectionEvent evt) {
			    	  num=lista.getSelectedIndex();
			    	 
			    	  foto.setSize(200,200);	
						
			    	  Icon icono = new ImageIcon(ALUsuarios.get(num).getImagenPerfil().getImage().getScaledInstance(foto.getWidth()	, foto.getHeight(), Image.SCALE_DEFAULT));
					  foto.setIcon(icono);
					  
					  foto.setAlignmentX(CENTER_ALIGNMENT);	
					  
					  
					  pfoto.add(foto);
					  
					  
					  puntos.setText("<html><body> <br> <br> <P ALIGN=center> "+ALUsuarios.get(num).getPuntuacion()+"<br> <br> &nbsp;&nbsp; &nbsp;&nbsp;       PUNTOS &nbsp;&nbsp;&nbsp;&nbsp;       <br>  <br> <br></body></html> ");
					  pprincipal.revalidate();
					 						
					  System.out.println(ALUsuarios.get(num).getUsuario());
			      }
			      });
		
	}
		public void meterImgEnlabel(String ruta,JLabel label,int largo,int ancho){
			ImageIcon imicon = new ImageIcon(VentanaRanking.class.getResource(ruta));		
			label.setSize(largo,ancho);
			Icon icono = new ImageIcon(imicon.getImage().getScaledInstance(label.getWidth()	, label.getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(icono);
		}
		public void RellenarLista(ArrayList<Usuario> arrayl){			
			lista=new JList<String>();
			String []arr=new String[arrayl.size()];
			for(int i=0;i<arrayl.size();i++){
				arr[i]=arrayl.get(i).getUsuario();
			}
			lista.setListData(arr);
		}
		
		public void PonerGanadores(){
			for(int i=0;i<3;i++){
				JLabel espacio= new JLabel("<html><body>&nrsp</body><html> ");
				espacio.setOpaque(true);
				espacio.setForeground(new Color (0.0f,0.0f,0.0f,0.0f));
				LabelPerfil a=new LabelPerfil(null,0, 0, 50	, 50);
				JPanel pa=new JPanel();
				
				JPanel pabajo=new JPanel();
				pabajo.setLayout(new BorderLayout());
				
				
				pa.setOpaque(false);
				pabajo.setOpaque(false);
				a.setSize(50,50);
				Icon icono = new ImageIcon(ALUsuarios.get(i).getImagenPerfil().getImage().getScaledInstance(a.getWidth()	, a.getHeight(), Image.SCALE_DEFAULT));
				a.setIcon(icono);
				pa.add(espacio);
				pa.add(a);
				
				pabajo.add(pa,BorderLayout.SOUTH);
				if(i==0){
					patrilplata.add(pabajo);
				}else if(i==1){
					patriloro.add(pabajo);
				}else if(i==2){
					patrilbronce.add(pabajo);
				}
				
				
			}
			
		}
		
		
		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionBaseDeDatos base=new GestionBaseDeDatos();
		Connection cone =base.inicializarLaBase();
		JFrame f=new VentanaRanking(cone);
		f.setVisible(true);
		

	}

}
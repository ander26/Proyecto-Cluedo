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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Proyecto.Cluedo.Datos.Genero;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;

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
	
	private JLabel foto=new JLabel();
	
	
	private GestionBaseDeDatos base=new GestionBaseDeDatos();
	private ArrayList<Usuario> ALUsuarios;
	//Codigo cogido de la practica 1
	private DefaultListCellRenderer miListRenderer = new DefaultListCellRenderer() {
		private static final long serialVersionUID = 1L;
		@Override
		public Component getListCellRendererComponent(
				JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			JLabel miComp = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			 miComp.setForeground( java.awt.Color.RED );
			 miComp.setBackground(Color.black);
			return miComp;
		}
	};
	
	
	
	
	//public VentanaRanking(Connection conexion,GestionBaseDeDatos gestion){
		public VentanaRanking(Connection con){
			ALUsuarios=base.consultaATablaOrdenadoPuntuacion(con);	
			RellenarLista(ALUsuarios);
			PonerGanadores();			
			
			lista.setCellRenderer(miListRenderer);;
			setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );	
			setSize( 1330, 830 );					
			setResizable( true );
			ImageIcon imagefondo = new ImageIcon(VentanaRanking.class.getResource("Imagenes/fondo2.jpg"));
			ImageIcon imagecartel = new ImageIcon(VentanaRanking.class.getResource("Imagenes/cartel.png"));
			//ImageIcon imagefondopodium = new ImageIcon(VentanaRanking.class.getResource("Imagenes/podiumrojo.png"));
								
			//Layout
			pslista.setBackground(Color.BLACK);
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
			pprincipal.add(pizquierdo);
			pprincipal.add(pmedio);					
			pprincipal.add(pderecho);			
			getContentPane().add(pprincipal);
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
				JLabel a=new JLabel();
				JPanel pa=new JPanel();
				
				JPanel pabajo=new JPanel();
				pabajo.setLayout(new BorderLayout());
				
				
				pa.setOpaque(false);
				pabajo.setOpaque(false);
				a.setSize(50,50);
				Icon icono = new ImageIcon(ALUsuarios.get(i).getImagenPerfil().getImage().getScaledInstance(a.getWidth()	, a.getHeight(), Image.SCALE_DEFAULT));
				a.setIcon(icono);
				
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

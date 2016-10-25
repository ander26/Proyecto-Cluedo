package Proyecto.Cluedo.Ventanas;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import Proyecto.Cluedo.Datos.Arma;
import Proyecto.Cluedo.Datos.Cartas;
import Proyecto.Cluedo.Datos.Lugar;
import Proyecto.Cluedo.Datos.Sospechoso;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.Propiedades;


public class VentanaApuntes  extends JFrame{
	private JPanel pprincipal=new JPanel();
	private JPanel ptabla=new JPanel();
	private JPanel pdibujar=new JPanel();
	private JPanel pventana=new JPanel();
	private JPanel ppizarra=new JPanel();
	private JTable tabla=new JTable( new MyTableModel());
	//private JPanel phoja=new JPanel();
	private JPanel phojatabla=new JPanel();
	private JLabel lhoja=new JLabel();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f=new VentanaApuntes();
		f.setVisible(true);
	}
	public VentanaApuntes(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 480 );
		setMinimumSize(new Dimension(1500, 750));
		setResizable( true );
		getContentPane().add(pventana);
		pdibujar.setSize(900,720);
		ppizarra.add(pdibujar);
		pventana.setLayout( new BorderLayout() );
		ImageIcon image;
		
			image = new ImageIcon(VentanaApuntes.class.getResource("Imagenes/pizarra.png"));
			JLabel lpizarra=new JLabel();
	        lpizarra.setSize(753,586);
	        Icon icono = new ImageIcon(image.getImage().getScaledInstance(lpizarra.getWidth(), lpizarra.getHeight(), Image.SCALE_DEFAULT));
	        lpizarra.setIcon(icono);
	        pdibujar.add(lpizarra);
	        pventana.add(ppizarra,BorderLayout.WEST);
			//pdibujar.setSize(40,300);
			pprincipal.setLayout(new BoxLayout(pprincipal,BoxLayout.X_AXIS));
			pprincipal.add(ptabla);
			
	        ImageIcon imagehoja;
			
			imagehoja = new ImageIcon(VentanaApuntes.class.getResource("Imagenes/hojarosa.png"));
			//lhoja.setSize(753,700);
	        //Icon iconohoja = new ImageIcon(imagehoja.getImage().getScaledInstance(lhoja.getWidth(), lhoja.getHeight(), Image.SCALE_DEFAULT));
		//lhoja.setIcon(iconohoja);
			panelrosa phoja=new panelrosa(imagehoja.getImage().getScaledInstance(753,700 , Image.SCALE_DEFAULT));
		//phoja.add(lhoja);
		//phojatabla.setLayout(new BorderLayout());
		
		pprincipal.setOpaque(false);
		phojatabla.add(pprincipal);
		phojatabla.add(phoja);
		phoja.setLayout(new BoxLayout(pprincipal,BoxLayout.X_AXIS));
		phoja.add(ptabla);
	
	
		pventana.add(phoja,BorderLayout.CENTER);
        
		
		
		JLabel tit=new JLabel("Mis notas");
		
		

		
		
		
		//ptabla.add(new JScrollPane(tabla));
		ptabla.setLayout(new BorderLayout());
		ptabla.add(tabla.getTableHeader(),BorderLayout.NORTH);
		tabla.getColumn("Notas").setPreferredWidth(300);
		tabla.getColumn("Sospechosos").setPreferredWidth(100);
		
		

		
		//crearTabla(p);
		ptabla.add(tabla,BorderLayout.CENTER);
		pdibujar.addMouseMotionListener( new MouseMotionListener() {
			private Point pAnt = null;
			@Override
			public void mouseDragged(MouseEvent e) {
				Graphics2D g2 = (Graphics2D) pdibujar.getGraphics();
				g2.setColor( Color.green );
				g2.setStroke( new BasicStroke( 1.5f ) );
				if (pAnt!=null) {
					g2.drawLine( pAnt.x, pAnt.y, e.getX(), e.getY() );  // Dibuja líneas al arrastrar
				}
				pAnt = e.getPoint();
			}
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		}
		
		
	}

class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"Mio","Sospechosos",
                                    "     ","Notas"};
    private Object[][] data = {
    		{"",new String ("Inspector gadgets"),new Boolean(false),""},{"",new String("Paris Hilton"),new Boolean(false),""},{"",new String("Usain Bolt"),new Boolean(false),""},{"",new String("Socrates"),new Boolean(false),""},{"",new String("Amuriza"),new Boolean(false),""},{"","Minerva McGonagall",new Boolean(false),""},
         	{"","La Momia",new Boolean(false),""},{"","Jueza Alaya",new Boolean(false),""}};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    


}


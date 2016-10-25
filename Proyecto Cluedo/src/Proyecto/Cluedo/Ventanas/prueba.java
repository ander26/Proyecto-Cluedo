
package Proyecto.Cluedo.Ventanas;

/*
 * TableSelectionDemo.java requires no other files.
 */

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import prog3.pr00.simulador.iu.ventana.MyTableModel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class prueba extends JFrame{
	private JPanel pventana=new JPanel();
	private JPanel pdibujar=new JPanel();
	private JPanel ppizarra=new JPanel();
	private JPanel ptabla=new JPanel();
	private JTable tabla=new JTable(new MyTableModel() );
	private panelrosa phoja;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f=new prueba();
		f.setVisible(true);
	}
	public prueba(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 480 );
		setMinimumSize(new Dimension(1500, 750));
		setResizable( true );
//		ImageIcon imagehoja = new ImageIcon(VentanaApuntes.class.getResource("Imagenes/hojarosa.png"));
//		panelrosa phoja=new panelrosa(imagehoja.getImage().getScaledInstance(753,700 , Image.SCALE_DEFAULT));
//		getContentPane().add(phoja);
		//pventana es el mayor panel de la ventana dividida en dos partes
		getContentPane().add(pventana);
		pventana.setLayout( new BorderLayout() );
		//crear el panel donde se puede dibujar
		pdibujar.setSize(900,720);
		//pdibujar panel principal de la parte izquierda
		ppizarra.add(pdibujar);
		ImageIcon image;		
		image = new ImageIcon(VentanaApuntes.class.getResource("Imagenes/pizarra.png"));
		JLabel lpizarra=new JLabel();
        lpizarra.setSize(753,586);
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(lpizarra.getWidth(), lpizarra.getHeight(), Image.SCALE_DEFAULT));
        lpizarra.setIcon(icono);
        pdibujar.add(lpizarra);
        pventana.add(ppizarra,BorderLayout.WEST);
        //tabla
        ptabla.setLayout(new BorderLayout());
		ptabla.add(tabla.getTableHeader(),BorderLayout.NORTH);
		tabla.getColumn("Notas").setPreferredWidth(300);
		tabla.getColumn("Sospechosos").setPreferredWidth(100);
		tabla.setBackground(Color.YELLOW);
		ptabla.add(tabla,BorderLayout.CENTER);
		//panel de fondo de la tabla
		  ImageIcon imagehoja;			
		  imagehoja = new ImageIcon(VentanaApuntes.class.getResource("Imagenes/hojarosa.png"));
		  phoja=new panelrosa(imagehoja.getImage().getScaledInstance(753,700 , Image.SCALE_DEFAULT));
		  phoja.setLayout(new BorderLayout(0, 0));
		  ptabla.setOpaque(false);
		  phoja.add(ptabla);
		  pventana.add(phoja);
        //escuchador del panel para dibujar
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
}

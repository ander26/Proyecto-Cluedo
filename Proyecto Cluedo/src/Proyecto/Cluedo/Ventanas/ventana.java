package Proyecto.Cluedo.Ventanas;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;


import Proyecto.Cluedo.Ventanas.panelrosa;


public class ventana extends JFrame{
	private JPanel pventana=new JPanel();
	private panelrosa pdibujar;
	private JPanel ppizarra=new JPanel();
	private JPanel ptabla=new JPanel();
	private JTable tabla=new JTable(new MyTableModel() );
	private JTable tabarmas=new JTable(new MyTableModelArmas());
	private JTable tablugares=new JTable(new MyTableModelLugares());
	private JPanel ptablugares=new JPanel();
	private JSplitPane spventana;	
	private JPanel ptabarmas=new JPanel();
	private JLabel ltitulo=new JLabel();
	private panelrosa phojap;
	private JScrollPane scrollphojap;
	private JPanel phoja=new JPanel();
	private static int[][] mibaraja=new int[3][4];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mibaraja[0][0]=0;
		mibaraja[0][1]=1;
		mibaraja[0][2]=2;
		mibaraja[0][3]=3;
		mibaraja[1][0]=4;
		mibaraja[1][1]=5;
		mibaraja[1][2]=1;
		mibaraja[1][3]=2;
		mibaraja[2][0]=3;
		mibaraja[2][1]=4;
		mibaraja[2][2]=5;
		mibaraja[2][3]=0;
		JFrame f=new ventana();
		f.setVisible(true);
	}
	public ventana(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 480 );
		setMinimumSize(new Dimension(750,300));
		setResizable( true );
		//pventana es el mayor panel de la ventana dividida en dos partes
		//getContentPane().add(pventana);
		//pventana.setLayout( new BorderLayout() );
		//crear el panel donde se puede dibujar
		//pdibujar.setSize(900,720);
		//pdibujar panel principal de la parte izquierda
		//ppizarra.add(pdibujar);
		ppizarra.setBackground(Color.white);
		//fondo ppizarra
		ImageIcon image;		
		image = new ImageIcon(ventana.class.getResource("Imagenes/pizarra.png"));
		pdibujar=new panelrosa(image.getImage());
//		ImageIcon image;		
//		image = new ImageIcon(VentanaApuntes.class.getResource("Imagenes/pizarra.png"));
//		JLabel lpizarra=new JLabel();
//        lpizarra.setSize(753,586);
//        Icon icono = new ImageIcon(image.getImage().getScaledInstance(lpizarra.getWidth(), lpizarra.getHeight(), Image.SCALE_DEFAULT));
//        lpizarra.setIcon(icono);
//        pdibujar.add(lpizarra);
        //pventana.add(ppizarra,BorderLayout.WEST);
        //tabla armas
        ptabarmas.setLayout(new BorderLayout());
		ptabarmas.add(tabarmas.getTableHeader(),BorderLayout.NORTH);		
		tabarmas.getColumn("Notas").setPreferredWidth(300);
		tabarmas.getColumn("Sospechosos").setPreferredWidth(100);
		tabarmas.getColumn("Mio").setPreferredWidth(20);	
		tabarmas.getColumn("     ").setPreferredWidth(20);
		tabarmas.setOpaque(false);
		tabarmas.setSize(new Dimension(753,700));		
		ptabarmas.add(tabarmas,BorderLayout.CENTER);
		ponerCandado(mibaraja,tabarmas,0);
		//tabla asesinos
		ptabla.setLayout(new BorderLayout());
		ptabla.add(tabla.getTableHeader(),BorderLayout.NORTH);		
		tabla.getColumn("Notas").setPreferredWidth(300);
		tabla.getColumn("Sospechosos").setPreferredWidth(100);
		tabla.getColumn("Mio").setPreferredWidth(20);	
		tabla.getColumn("     ").setPreferredWidth(20);			
		tabla.setOpaque(false);
		tabla.setSize(new Dimension(753,700));
		DefaultTableCellRenderer renderer =new DefaultTableCellRenderer();
		renderer.setOpaque(false);
		tabla.setDefaultRenderer(Object.class, renderer);
		
		
		ptabla.add(tabla,BorderLayout.CENTER);
		ponerCandado(mibaraja,tabla,2);
		//tabla lugares
		ptablugares.setLayout(new BorderLayout());
		ptablugares.add(tablugares.getTableHeader(),BorderLayout.NORTH);		
		tablugares.getColumn("Notas").setPreferredWidth(300);
		tablugares.getColumn("Sospechosos").setPreferredWidth(100);
		tablugares.getColumn("Mio").setPreferredWidth(20);	
		tablugares.getColumn("     ").setPreferredWidth(20);
		tablugares.setOpaque(false);
		tablugares.setSize(new Dimension(753,700));		
		DefaultTableCellRenderer rendererlug =new DefaultTableCellRenderer();
		rendererlug.setOpaque(false);
		tablugares.setDefaultRenderer(Object.class, rendererlug);
		DefaultTableCellRenderer renderertit =new DefaultTableCellRenderer();
		renderertit.setBackground(Color.CYAN);
		tablugares.getTableHeader().setDefaultRenderer(renderertit);
		tabla.getTableHeader().setDefaultRenderer(renderertit);
		ptablugares.add(tablugares,BorderLayout.CENTER);
		ponerCandado(mibaraja,tablugares,1);
		
		//panel de fondo de la tabla
		  ImageIcon imagehoja;			
		  imagehoja = new ImageIcon(ventana.class.getResource("Imagenes/POSIT.jpg"));
		 // phoja=new panelrosa(imagehoja.getImage().getScaledInstance(750,1000 , Image.SCALE_DEFAULT));
		  phojap=new panelrosa(imagehoja.getImage());
		  
			 
		  // phoja.setLayout(new BoxLayout(phoja,BoxLayout.X_AXIS));
		  phoja.setLayout(new BoxLayout(phoja,BoxLayout.Y_AXIS));
		  ptabla.setOpaque(false);
		  ptablugares.setOpaque(false);
		  ptabarmas.setOpaque(false);
		  DefaultTableCellRenderer rendererarmas =new DefaultTableCellRenderer();
		  rendererarmas.setOpaque(false);
		  tabarmas.setDefaultRenderer(Object.class, rendererarmas);
		  tabarmas.getTableHeader().setDefaultRenderer(renderertit);
		  phoja.add(ptabla);
		  phoja.add(ptabarmas);
		  phoja.add(ptablugares);
		  phoja.setOpaque(false);
		  phojap.setLayout(new BoxLayout(phojap,BoxLayout.X_AXIS));
		  phojap.add(phoja);
		  //pventana.add(phoja,BorderLayout.CENTER);
		  //titulo
		  ImageIcon imagetit = new ImageIcon(ventana.class.getResource("Imagenes/TITMISNOTAS.png"));
		  ltitulo.setSize(200,200);
	      Icon iconotit = new ImageIcon(imagetit.getImage().getScaledInstance(ltitulo.getWidth(), ltitulo.getHeight(), Image.SCALE_DEFAULT));
	      ltitulo.setIcon(iconotit);
	      //añadir boligrafo
	      ImageIcon imageboli = new ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
		  JLabel lboli=new JLabel();
		  lboli.setSize(100,600);		  
	      Icon iconoboli = new ImageIcon(imageboli.getImage().getScaledInstance(lboli.getWidth(), lboli.getHeight(), Image.SCALE_DEFAULT));
	      ImageIcon imagegarabato = new ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
		  JLabel lgarabato=new JLabel();
		  lgarabato.setSize(100,600);		  
	      Icon iconogarabato = new ImageIcon(imagegarabato.getImage().getScaledInstance(lgarabato.getWidth(), lgarabato.getHeight(), Image.SCALE_DEFAULT));
	      lgarabato.setIcon(iconogarabato);
	      phojap.add(lgarabato,0);
	      lboli.setIcon(iconoboli);	      
	      phoja.add(ltitulo,0);	  
	      phojap.add(phoja);
	      phojap.add(lboli);
	      phojap.repaint();
	      scrollphojap=new JScrollPane(phojap);
	      
	      //splitpane
	      spventana=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollphojap,pdibujar);
	      getContentPane().add(spventana);			
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
        
        //Poner canddado y bloquear 
        public  void ponerCandado(int[][]cartas,JTable tabla,int tipo){
        	for (int i=0;i<tabla.getRowCount();i++){
        	if(tipo==0){
        	if (((MyTableModelArmas) tabla.getModel()).isCellEditable(i, 2)==false){
        		ImageIcon image= new ImageIcon(ventana.class.getResource("Imagenes/Candado.png"));
        		JLabel lpizarra=new JLabel();
                lpizarra.setSize(10,10);
                Icon icono = new ImageIcon(image.getImage().getScaledInstance(lpizarra.getWidth(), lpizarra.getHeight(), Image.SCALE_DEFAULT));
                tabla.setValueAt(icono,i,0);
        	}
        	}
        	if(tipo==1){
            	if (((MyTableModelLugares) tabla.getModel()).isCellEditable(i, 2)==false){
            		//
            		ImageIcon image= new ImageIcon(ventana.class.getResource("Imagenes/Candado.png"));
            		JLabel lpizarra=new JLabel();
                    lpizarra.setSize(10,10);
                    lpizarra.setOpaque(false);                    
                    Icon icono = new ImageIcon(image.getImage().getScaledInstance(lpizarra.getWidth(), lpizarra.getHeight(), Image.SCALE_DEFAULT));
                    tabla.setValueAt(icono,i,0);
            	}
        		
        	}
        	if(tipo==2){
            	if (((MyTableModel) tabla.getModel()).isCellEditable(i, 2)==false){
            		ImageIcon image= new ImageIcon(ventana.class.getResource("Imagenes/Candado.png"));
            		JLabel lpizarra=new JLabel();
                    lpizarra.setSize(10,10);
                    Icon icono = new ImageIcon(image.getImage().getScaledInstance(lpizarra.getWidth(), lpizarra.getHeight(), Image.SCALE_DEFAULT));
                    tabla.setValueAt(icono,i,0);
            	}
        	}
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
	        	for (int i:mibaraja[2]){
	        		if(row==i){
	        			Logger.getLogger(getClass().getName()).log(Level.INFO, "no editable fila"+row);
	        			return false;
	        		}
	        	}
	        	
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
	class MyTableModelArmas extends AbstractTableModel {
	    private String[] columnNames = {"Mio","Sospechosos",
	                                    "     ","Notas"};
	    private Object[][] data = {
	    		{"",new String ("Pistola"),new Boolean(false),""},{"",new String("Biblia"),new Boolean(false),""},{"",new String("Bocata envenenado"),new Boolean(false),""},{"",new String("Chip"),new Boolean(false),""},{"",new String("Botella"),new Boolean(false),""},{"","Sarten",new Boolean(false),""},
	   };

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
	        	for (int i:mibaraja[0]){
	        		if(row==i){
	        			return false;
	        		}
	        		
	        	}
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
	class MyTableModelLugares extends AbstractTableModel {
	    private String[] columnNames = {"Mio","Sospechosos",
	                                    "     ","Notas"};
	    private Object[][] data = {
	    		{"",new String ("Facultad ingeniería"),new Boolean(false),""},{"",new String("La Comercial"),new Boolean(false),""},{"",new String("La L"),new Boolean(false),""},{"",new String("La capilla"),new Boolean(false),""},{"",new String("Edificio Centenario"),new Boolean(false),""},{"","Edificio de letras",new Boolean(false),""},
	    		{"","Biblioteca",new Boolean(false),""},{"","Zubiarte",new Boolean(false),""}};

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
	        	for (int i:mibaraja[1]){
	        		if(row==i){
	        			return false;
	        		}
	        	}
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

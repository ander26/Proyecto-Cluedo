package Proyecto.Cluedo.Ventanas;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Proyecto.Cluedo.Datos.Arma;
import Proyecto.Cluedo.Datos.Cartas;
import Proyecto.Cluedo.Datos.Lugar;
import Proyecto.Cluedo.Datos.Sospechoso;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.Propiedades;

public class VentanaApuntes  extends JFrame{
	private JPanel pcartas=new JPanel();
	private JPanel ptabla=new JPanel();
	private JPanel plugares=new JPanel();
	private JPanel parmas=new JPanel();
	private JPanel psospechosos=new JPanel();
	private JTable tabla=new JTable( new MyTableModel());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario Pepe=new Usuario(32,1);
		Propiedades prop=new Propiedades(12,8,12,1);
		Arma a1=new Arma("Imagenes/CIMG1094.JPG","a1",false);
		Arma a2=new Arma("Imagenes/CIMG1095.JPG","a2",false);
		Arma a3=new Arma("Imagenes/CIMG1096.JPG","a3",false);
		Arma a4=new Arma("Imagenes/CIMG1097.JPG","a12",false);
		Arma a5=new Arma("Imagenes/CIMG1098.JPG","a4",false);
		Arma a6=new Arma("Imagenes/CIMG1182.JPG","a5",false);
		Arma a7=new Arma("Imagenes/CIMG1183.JPG","a6",false);
		Arma a8=new Arma("Imagenes/CIMG1184.JPG","a7",false);
		Arma a9=new Arma("Imagenes/CIMG1185.JPG","a8",false);
		Arma a10=new Arma("Imagenes/CIMG1186.JPG","a9",false);
		Arma a11=new Arma("Imagenes/CIMG1187.JPG","a10",false);
		Arma a12=new Arma("Imagenes/CIMG1188.JPG","a11",false);
		Sospechoso s1=new Sospechoso("Imagenes/DSCF0651.JPG","s1",false);
		Sospechoso s2=new Sospechoso("Imagenes/DSCF0652.JPG","s2",false);
		Sospechoso s3=new Sospechoso("Imagenes/DSCF0653.JPG","s3",false);
		Sospechoso s4=new Sospechoso("Imagenes/DSCF0654.JPG","s4",false);
		Sospechoso s5=new Sospechoso("Imagenes/DSCF0655.JPG","s5",false);
		Sospechoso s6=new Sospechoso("Imagenes/DSCF0656.JPG","s6",false);
		Sospechoso s7=new Sospechoso("Imagenes/DSCF0657.JPG","s7",false);
		Sospechoso s8=new Sospechoso("Imagenes/DSCF0658.JPG","s8",false);
		Sospechoso s9=new Sospechoso("Imagenes/DSCF0659.JPG","s9",false);
		Sospechoso s10=new Sospechoso("Imagenes/DSCF0660.JPG","s10",false);
		Sospechoso s11=new Sospechoso("Imagenes/DSCF0661.JPG","s11",false);
		Sospechoso s12=new Sospechoso("Imagenes/DSCF0664.JPG","s12",false);
		Lugar l1=new Lugar("Imagenes/P1000744.JPG","l1",false);
		Lugar l2=new Lugar("Imagenes/P1000745.JPG","l2",false);
		Lugar l3=new Lugar("Imagenes/P1000746.JPG","l3",false);
		Lugar l4=new Lugar("Imagenes/P1000747.JPG","l4",false);
		Lugar l5=new Lugar("Imagenes/P1000748.JPG","l5",false);
		Lugar l6=new Lugar("Imagenes/P1000749.JPG","l6",false);
		Lugar l7=new Lugar("Imagenes/P1000750.JPG","l7",false);
		Lugar l8=new Lugar("Imagenes/P1000751.JPG","l8",false);
		Cartas [][] a=new Cartas[3][12];
		a[0][0]=a1;
		a[0][1]=a2;
		a[0][2]=a3;
		a[0][3]=a4;
		a[0][4]=a5;
		a[0][5]=a6;
		a[0][6]=a7;
		a[0][7]=a8;
		a[0][8]=a9;
		a[0][9]=a10;
		a[0][10]=a11;
		a[0][11]=a12;
		a[1][0]=s1;
		a[1][1]=s2;
		a[1][2]=s3;
		a[1][3]=s4;
		a[1][4]=s5;
		a[1][5]=s6;
		a[1][6]=s7;
		a[1][7]=s8;
		a[1][8]=s9;
		a[1][9]=s10;
		a[1][10]=s11;
		a[1][11]=s12;
		a[2][0]=l1;
		a[2][1]=l2;
		a[2][2]=l3;
		a[2][3]=l4;
		a[2][4]=l5;
		a[2][5]=l6;
		a[2][6]=l7;
		a[2][7]=l8;
		prop.setBaraja(a);
		int [] b={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		
		Pepe.setACartas(b);		
		JFrame f=new VentanaApuntes(Pepe,prop);
		f.setVisible(true);
	}
	public VentanaApuntes(Usuario U1,Propiedades p){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 480 );
		setResizable( true );
		getContentPane().setLayout( new BorderLayout() );		
		getContentPane().add(pcartas,BorderLayout.CENTER);
		getContentPane().add(ptabla,BorderLayout.WEST);
		JLabel tit=new JLabel("Mis notas");
		
		pcartas.setLayout(new BoxLayout(pcartas,BoxLayout.X_AXIS));
		pcartas.add(plugares);
		pcartas.add(parmas);
		pcartas.add(psospechosos);
		plugares.setLayout(new BoxLayout(plugares,BoxLayout.Y_AXIS));
		parmas.setLayout(new BoxLayout(parmas,BoxLayout.Y_AXIS));
		psospechosos.setLayout(new BoxLayout(psospechosos,BoxLayout.Y_AXIS));
		//meterCartas(U1);
		
		
		ptabla.setLayout(new BorderLayout());
		ptabla.add(tit,BorderLayout.NORTH);
		
		//crearTabla(p);
		ptabla.add(tabla,BorderLayout.CENTER);
		
		
	}
//	public void meterCartas(Usuario U){
//		
//		for (Cartas c :U.getACartas()){
//			JPanel a=new JPanel();
//			a.setLayout(new BorderLayout());
//			if(c instanceof Arma){
//				JLabel b=new JLabel(c.getNombre());
//				
//				a.add(b,BorderLayout.NORTH);
//				a.add(c.getIcono(),BorderLayout.CENTER);
//				parmas.add(a);
//			}
//			else if(c instanceof Lugar){
//				JLabel b=new JLabel(c.getNombre());
//				
//				a.add(b,BorderLayout.NORTH);
//				a.add(c.getIcono(),BorderLayout.CENTER);
//				plugares.add(a);
//			}
//			else if(c instanceof Sospechoso){
//				JLabel b=new JLabel(c.getNombre());
//				
//				a.add(b,BorderLayout.NORTH);
//				a.add(c.getIcono(),BorderLayout.CENTER);
//				psospechosos.add(a);
//			}
//			
//		}
//	}
//	public void crearTabla(Propiedades p){
//		System.out.println("num tot cartas "+p.getNumTotCartas());
//		//tabla=new JTable(p.getNumTotCartas()+3,2);
//		//tabla.setEditingColumn(1);
//		for(int i=1;i<p.getNumTotCartas()+3;i++){
//			tabla.setValueAt(new Boolean(true),i,1);
//			System.out.println(i);
//		
//		}
//		tabla.setValueAt("Armas",0, 0);
//		for(int i=1;i<p.getNumTotArmas()+1;i++){			
//			tabla.setValueAt(((p.getBaraja())[0][i-1]).getNombre(),i, 0);
//			
//		}
//		tabla.setValueAt("Sospechoso",p.getNumTotArmas()+1, 0);
//		for(int i=p.getNumTotArmas()+2;i<(p.getNumTotSospechosos()+p.getNumTotArmas()+2);i++){
//			tabla.setValueAt((p.getBaraja())[1][i-2-p.getNumTotArmas()].getNombre(),i, 0);
//			
//		}
//		tabla.setValueAt("Lugares",(p.getNumTotSospechosos()+p.getNumTotArmas()+3), 0);
//		for(int i=p.getNumTotSospechosos()+p.getNumTotArmas()+3;i<(p.getNumTotSospechosos()+p.getNumTotArmas()+p.getNumTotLugares()+3);i++){
//			tabla.setValueAt((p.getBaraja())[2][i-3-p.getNumTotSospechosos()-p.getNumTotArmas()].getNombre(),i, 0);
//			System.out.println((p.getBaraja())[2][i-3-p.getNumTotSospechosos()-p.getNumTotArmas()].getNombre());
//		}
//		//ptabla.add(tabla,BorderLayout.CENTER);
//		
		
		
		
		
	}
//	class MyTableModel extends AbstractTableModel {
//		Propiedades prop=new Propiedades(12,8,12,1);
//        private String[] columnNames={"Armas"," "} ;
//       // private Object[][] data =new Object[prop.getNumTotCartas()+3][2];
//        
//        private Object[][] data ={{new String ("Inspector gadgets"),new Boolean(false)},{new String("Paris Hilton"),new Boolean(false)},{new String("Usain Bolt"),new Boolean(false)},{new String("Socrates"),new Boolean(false)},{new String("Amuriza"),new Boolean(false)},{"Minerva McGonagall",new Boolean(false)},
//        	{"La Momia",new Boolean(false)},{"Jueza Alaya",new Boolean(false)}};
//	       
//
//        public int getColumnCount() {
//            return columnNames.length;
//        }
//
//        public int getRowCount() {
//            return data.length;
//        }
//
//        public String getColumnName(int col) {
//            return columnNames[col];
//        }
//
//        public Object getValueAt(int row, int col) {
//            return data[row][col];
//        }
//
//        /*
//         * JTable uses this method to determine the default renderer/
//         * editor for each cell.  If we didn't implement this method,
//         * then the last column would contain text ("true"/"false"),
//         * rather than a check box.
//         */
////        public Class getColumnClass(int c) {
////            return getValueAt(0, c).getClass();
////        }
//
//        /*
//         * Don't need to implement this method unless your table's
//         * editable.
//         */
//        public boolean isCellEditable(int row, int col) {
//            //Note that the data/cell address is constant,
//            //no matter where the cell appears onscreen.
//            if (col < 2) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//
//        /*
//         * Don't need to implement this method unless your table's
//         * data can change.
//         */
//        public void setValueAt(Object value, int row, int col) {
//            data[row][col] = value;
//            fireTableCellUpdated(row, col);
//        }
//
//
//    }
//
//
class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"First Name",
                                    "Last Name"};
    private Object[][] data = {
    		{new String ("Inspector gadgets"),new Boolean(false)},{new String("Paris Hilton"),new Boolean(false)},{new String("Usain Bolt"),new Boolean(false)},{new String("Socrates"),new Boolean(false)},{new String("Amuriza"),new Boolean(false)},{"Minerva McGonagall",new Boolean(false)},
         	{"La Momia",new Boolean(false)},{"Jueza Alaya",new Boolean(false)}};

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
        if (col < 1) {
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


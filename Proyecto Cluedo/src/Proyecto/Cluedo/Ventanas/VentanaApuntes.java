import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaApuntes  extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new VentanaApuntes();
		f.setVisible(true);
	}
	public VentanaApuntes(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 480 );
		setResizable( true );
		getContentPane().setLayout( new BorderLayout() );
		JPanel pcartas=new JPanel();
		JPanel ptabla=new JPanel();
		getContentPane().add(pcartas,BorderLayout().EAST);
		MAIDER
		
	}

}

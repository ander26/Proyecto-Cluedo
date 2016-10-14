import Proyecto.Cluedo.Ventanas.VentanaLogin;
import Proyecto.Cluedo.Ventanas.VentanaLogo;

public class Main {

	
	public static void main (String [] args){
		VentanaLogo ventana = new VentanaLogo();
		ventana.setVisible(true);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ventana.dispose();
		
		VentanaLogin ventanaPrincipal = new VentanaLogin();
		ventanaPrincipal.setVisible(true);
		
	}
}

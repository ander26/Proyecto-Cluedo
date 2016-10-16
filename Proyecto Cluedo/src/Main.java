import Proyecto.Cluedo.Ventanas.VentanaLogin;
import Proyecto.Cluedo.Ventanas.VentanaLogo;

public class Main {

	
	public static void main (String [] args){
		VentanaLogo ventana = new VentanaLogo();
		ventana.setVisible(true);
		
		
		VentanaLogin ventanaPrincipal = new VentanaLogin();
		
		while (ventanaPrincipal.isValid()){
			
		}
		
		ventana.dispose();
		
		ventanaPrincipal.setVisible(true);
	}
}

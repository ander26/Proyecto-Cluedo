package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaConectando extends JFrame {

	/**
	 * Label que contiene la imagen de deusto
	 */
	private JLabel etiqueta = new JLabel();

	/**
	 * Imagen de deusto
	 */

	private ImageIcon imageIcon;
	

	public static void main(String[] args) {
		VentanaConectando ventana = new VentanaConectando();
		ventana.setVisible(true);
	}

	public VentanaConectando() {

		// Inicializamos el JFrame

		setSize(new Dimension(700, 500));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBackground(new Color(1.0f,1.0f,1.0f,0.95f));

		// Generamos los componentes

		imageIcon = new ImageIcon();

		/**
		 * Label que contiene el texto Conectando
		 */

		JLabel conectando = new JLabel("Esperando a jugadores...");

		// Establecemos el formato

		getContentPane().setLayout(null);
		getContentPane().add(etiqueta);
		getContentPane().add(conectando);

		conectando.setBounds(100, 130, 550, 500);

		conectando.setForeground(Color.BLUE);

		conectando.setFont(new Font("Tahoma", Font.BOLD, 40));

		etiqueta.setBounds(50, 20, 600, 400);

		try {
			imageIcon = new ImageIcon(VentanaConectando.class.getResource("Imagenes/Gif Deusto.gif").toURI().toURL());
		} catch (Exception e) {
			System.out.println("No se ha encontrado el archivo");
		}

		etiqueta.setIcon(imageIcon);

	}

}

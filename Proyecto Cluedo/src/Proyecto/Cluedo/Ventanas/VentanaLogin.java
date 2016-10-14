package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class VentanaLogin extends JFrame {
	
	/**
	 * Boton que sirve para comenzar el proceso de registro
	 */

	private JButton registrar;
	
	/**
	 * Boton que sirve para entrar en la aplicacion
	 */
	
	private JButton entrar;
	
	/**
	 * Campo que sirve para introducir el usuario
	 */
	
	private JTextField usuario;
	
	/**
	 * Parametro que sirve para introducir la contraseña
	 */
	
	private JPasswordField contraseña;
	
	/**
	 * Parametro que sirve para salir
	 */
	
	private JLabel botonSalir;
	
	
	
	
	public static void main (String [] args){
		
		VentanaLogin ventana =new VentanaLogin();
		ventana.setVisible(true);
		
	}
	
	public VentanaLogin(){
		
		//Incializamos el frame 
		
		setSize(new Dimension(900, 700));
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		
		
		
		//Generamos los componentes
		
		
		registrar= new JButton("Registrarse");
		
		entrar= new JButton("Entrar");
		
		/**
		 * Label que guarda la imagen del logo
		 */
		
		JLabel imagenLogo = new JLabel();
		
		/**
		 * Label que contiene la explicacion para el registro
		 */
		
		JLabel explicacion= new JLabel ("<html><body>¡Bienvenido!<br>Estas apunto de adrentarte en un mundo muy misterioso,<br>¿Seras capaz de convertirte en el nuevo Sherlock Holmes?<br> Entra y descubrelo</body></html>");
		
		/**
		 * Label que contiene el titulo
		 */
		
		JLabel titulo=new JLabel("DEUSTLUEDO");
		
		/**
		 * Label que contiene la imagen del logo
		 */
		
		ImageIcon imagen= new ImageIcon();
		
		/**
		 * Label que contiene el icono del logo
		 */
		Icon icono;
		
		/**
		 * Label que indica que es el proceso para entrar
		 */
		
		JLabel labelEntrar= new JLabel("Entrar");
		
		/**
		 * Label que indica que es el proceso para registrar
		 */
		
		JLabel labelRegistrar= new JLabel("Registrar");
		
		/**
		 * Atributo que contiene el icono para salir
		 */
		
		Icon iconoSalir;
		
		/**
		 * Label para contener el boton de salir
		 */
		
		JLabel salir= new JLabel();
		
		/**
		 * Compoenente que sirve para escribir el nombre de usuario
		 */
		
		usuario= new JTextField();
		
		/**
		 * Parametro que sirve para escribir la contraseña
		 */
		
		contraseña= new JPasswordField();
		
		/**
		 * Atributo que contiene el separador entre las dos partes
		 */
		
		JSeparator separador= new JSeparator(SwingConstants.VERTICAL);
		
		
		JPanel panel= new JPanel();
		
		//Establecemos el formato
		
		titulo.setFont(new Font("Agency FB", Font.BOLD, 75));
		
		titulo.setForeground(new Color(44, 91, 201));
		
		titulo.setBounds(408, 97, 360, 165);
		
		imagenLogo.setBounds(186, 46, 213, 266);
		
		try {
			imagen = new ImageIcon(VentanaLogin.class.getResource("Imagenes/LOGO DEUSTLUEDO.png").toURI().toURL());
		} catch (Exception e) {
			System.out.println("No se ha encontrado el archivo");
		}
		
		
		
		icono = new ImageIcon(imagen.getImage().getScaledInstance(imagenLogo.getWidth()	, imagenLogo.getHeight(), Image.SCALE_DEFAULT));
		
		
		imagenLogo.setIcon(icono);
		
		entrar.setBounds(144,513,224,56);
		
		registrar.setBounds(537,513, 224, 56);
		
		explicacion.setBounds(537, 368, 224, 150);
		
		explicacion.setFont(new Font("System", Font.PLAIN, 12));
		
		usuario.setBounds(144, 402, 224, 25);
		
		usuario.setText("Usuario");
		
		usuario.setForeground(Color.LIGHT_GRAY);
		
		
		
		contraseña.setBounds(144,457,224,25);
		
		contraseña.setText("Contraseña");
		
		contraseña.setForeground(Color.lightGray);
		
		labelEntrar.setBounds(144, 350, 100, 17);
		
		labelEntrar.setFont(new Font("System", Font.PLAIN, 23));
		
		labelEntrar.setForeground(new Color(21, 87, 221));
		
		labelRegistrar.setBounds(538,350,100,30);
		
		labelRegistrar.setForeground(new Color(21, 87, 221));
		
		labelRegistrar.setFont(new Font("System", Font.PLAIN, 23));
		
		try {
			imagen = new ImageIcon(VentanaLogin.class.getResource("Imagenes/Cerrar.png").toURI().toURL());
		} catch (Exception e) {
			System.out.println("No se ha encontrado el archivo");
		}
		
		salir.setBounds(768,628,120,56);
		
		iconoSalir= new ImageIcon(imagen.getImage().getScaledInstance(salir.getWidth(), salir.getHeight(), Image.SCALE_DEFAULT));
		
		salir.setIcon(iconoSalir);
		
		separador.setBounds(450, 370, JSeparator.WIDTH, 200);
		
		panel.setBounds(105, 255, 691, 350);
		
		panel.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		
		//Añadimos al panel
		
		getContentPane().setLayout(null);
		
		getContentPane().add(imagenLogo);
		
		getContentPane ().add(entrar);
		
		getContentPane().add(labelRegistrar);
		
		getContentPane().add(labelEntrar);
		
		getContentPane().add(separador);
		
		getContentPane().add(titulo);
		
		getContentPane().add(explicacion);
		
		getContentPane().add(salir);
		
		getContentPane().add(registrar);
		
		getContentPane().add(usuario);
		
		getContentPane().add(contraseña);

		
		
		getContentPane().add(panel);
		
		//Eventos
		
		salir.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				//Custom button text
				Object[] options = {"Si",
				                    "No"};
				int n = JOptionPane.showOptionDialog(getContentPane(),
				    "¿Estas seguro de que quieres salir?",
				    "Salir", JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[1]);
				if (n==JOptionPane.YES_OPTION){
				dispose();
				}
			}
		});
		
		usuario.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if (usuario.getText().equals("")){
				usuario.setText("Usuario");
				usuario.setForeground(Color.lightGray);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				usuario.setForeground(Color.black);
				if (usuario.getText().equals("Usuario")){
				usuario.setText("");
				}
				
			}
		});
		
		contraseña.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if (contraseña.getPassword().length==0){
					contraseña.setText("Contraseña");
					contraseña.setForeground(Color.lightGray);
				}
				
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				contraseña.setForeground(Color.black);
				char [] caracteres= contraseña.getPassword();
				char [] equivalente= {'C','o','n','t','r','a','s','e','ñ','a'};
				if (caracteres.length==equivalente.length){
				for (int i=0;i<caracteres.length;i++){
				if (caracteres[i]==equivalente[i]){
				contraseña.setText("");
				}
			}}}
		});
		
		
	}
	
	
}

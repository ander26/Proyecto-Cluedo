package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageFilter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;

public class ventanaDenunciar extends JFrame {

	
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();
	
	public ventanaDenunciar(Connection conexion,ArrayList<Jugador> arrjugadores,int codigo) {

		// Establecemos el formato

		setSize(700, 500);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setResizable(false);
		
		setLocationRelativeTo(null);
		
		// Generamos los compoenentes

		JLabel policia = new JLabel();

		JLabel fondo = new JLabel();

		JPanel cuadrado = new JPanel();

		JLabel titulo = new JLabel("DENUNCIAR");

		JLabel usuario = new JLabel("Usuarios: ");

		JLabel motivo = new JLabel("Motivos: ");

		JTextArea texto = new JTextArea();
		
		String [] lista = transformacion(arrjugadores);

		JComboBox<String> combo = new JComboBox<String>(lista);

		JLabel enviar = new JLabel();

		ImageIcon imagen = new ImageIcon();

		Icon icono;

		// Establecemos un formato

		policia.setBounds(0,0,517, 500);

		try {

			imagen = new ImageIcon(ventanaDenunciar.class.getResource("Imagenes/policia.png").toURI().toURL());

		} catch (Exception e) {
			System.out.println("No se ha encontrado la foto");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(policia.getWidth(), policia.getHeight(), Image.SCALE_DEFAULT));

		policia.setIcon(icono);

		fondo.setBounds(0,0,700, 500);

		try {

			imagen = new ImageIcon(ventanaDenunciar.class.getResource("Imagenes/fondoDenunciar.png").toURI().toURL());

		} catch (Exception e) {
			System.out.println("No se ha encontrado la foto");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));

		fondo.setIcon(icono);

		enviar.setBounds(417,323,80, 80);

		try {

			imagen = new ImageIcon(ventanaDenunciar.class.getResource("Imagenes/enviarDenunciar.png").toURI().toURL());

		} catch (Exception e) {
			System.out.println("No se ha encontrado la foto");
		}

		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(enviar.getWidth(), enviar.getHeight(), Image.SCALE_DEFAULT));

		enviar.setIcon(icono);

		cuadrado.setOpaque(true);
		
		cuadrado.setBounds(305,33,289, 387);

		cuadrado.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.85f));
		
		texto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		titulo.setFont(new Font("System", Font.BOLD, 32));

		titulo.setBounds(363,51,188,47);
		
		usuario.setBounds(333, 112, 70, 17);

		motivo.setBounds(333,141,70,17);
		
		texto.setBounds(333	, 176, 247, 132);
		
		combo.setBounds(390, 112, 190, 17);
		
		//Añadimos al contenedor
		
		getContentPane().setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		getContentPane().add(motivo);
		
		
		getContentPane().add(combo);
		
		
		
		getContentPane().add(enviar);
		
		
		getContentPane().add(texto);
		getContentPane().add(usuario);
		getContentPane().add(titulo);
		
		getContentPane().add(cuadrado);
		
		
		getContentPane().add(policia);
		getContentPane().add(fondo);
		
		//Generamos los eventos
		
		enviar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				gestion.insertarDenuncia(conexion, (String)combo.getSelectedItem(), codigo, texto.getText());
//				
				if(gestion.obtenerTrampa(conexion, codigo, (String)combo.getSelectedItem())==1){
					
					gestion.modificarPuntuacion(conexion, (String)combo.getSelectedItem(), 200, "-");
					
					JOptionPane.showMessageDialog(null, "¡¡Enhorabuena!! Has descubierto las trampas de "+(String)combo.getSelectedItem()+", se le han quitado 200 puntos", "DENUNCIA", JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				}else{
					JOptionPane.showMessageDialog(null, "No hemos descubierto ningun tipo de trampa por parte de dicho usuario,lo siento", "DENUNCIA", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				
			}
		});
		
	}
	
	public String [] transformacion (ArrayList<Jugador> arrjugadores){
		
		String [] lista = new String [arrjugadores.size()];
		int contador =0;
		for (Jugador j: arrjugadores){
			lista[contador]=j.getUsuario();
			contador++;
		}
		
		return lista;
	}

	
//	public static void main (String [] args){
//		
//		ventanaDenunciar ventana = new ventanaDenunciar();
//		
//		ventana.setVisible(true);
//	}
}

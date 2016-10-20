package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints.Key;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class VentanaChat extends JFrame {

	JLabel usuariosLinea;
	
	int contadorUsuarios=0;
	
	public static void main (String [] args){
		VentanaChat ventana= new VentanaChat();
		ventana.setVisible(true);
		
	}
	
	public VentanaChat(){
		
		//Inicializamos el frame
		
		setUndecorated(true);
		setResizable(false);
		setSize(new Dimension(800, 600));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Creamos los compoenntes
		
		
		
		ImageIcon imagen= new ImageIcon ();
		
		usuariosLinea=new JLabel("  Usuarios en linea: "+contadorUsuarios);
		
		JLabel labelEnviar = new JLabel ();
		
		Icon iconoEnviar;
		
		JTextArea mensaje= new JTextArea();
		
		JTextArea principal = new JTextArea();
		
		JList <String> usuarios = new JList<String>();
		
		JLabel labelPerfil = new JLabel();
		
		Icon iconoPerfil;
		
		JLabel nombre = new JLabel ("Pepe");
		
		String [] contenido ={"En linea","Desconectado"};
		
		JComboBox<String> estado = new JComboBox<String>(contenido);
		
		
		
		JLabel labelSalir = new JLabel();
		
		Icon iconoSalir;
		
		JLabel labelFondo= new JLabel();
		
		Icon iconoFondo;
		
		JScrollPane panelLista = new JScrollPane(usuarios);
		
		JScrollPane panelMensajes= new JScrollPane(principal);
		
		//Establecemos el formato
		
		
		
		getContentPane().setLayout(new BorderLayout());
		
		labelEnviar.setBounds(660, 528, 136, 70);
		
		try{
			imagen= new ImageIcon(VentanaChat.class.getResource("Imagenes/enviar.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		iconoEnviar= new ImageIcon(imagen.getImage().getScaledInstance(labelEnviar.getWidth(), labelEnviar.getHeight(), Image.SCALE_DEFAULT));
		
		labelEnviar.setIcon(iconoEnviar);
		
		mensaje.setBounds(184, 528, 475, 72);
		
		mensaje.setText("Introduzca aqui su mensaje");
		
		mensaje.setForeground(Color.lightGray);
		
		panelMensajes.setBounds(184,83,616,442);
		
		principal.setEnabled(false);
		
		panelLista.setBounds(0,130,185,470);
		
		usuarios.setEnabled(false);
		
		usuariosLinea.setBounds(0, 84, 185, 46);
		
		usuariosLinea.setFont(new Font("System", Font.BOLD, 16));
		
		usuariosLinea.setForeground(new Color(237, 81, 30));
		
		usuariosLinea.setBackground(Color.lightGray);
		
		labelFondo.setBounds(0, 0, 800, 85);
		
		try{
			imagen= new ImageIcon(VentanaChat.class.getResource("Imagenes/Fondo Negro.jpg").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoFondo= new ImageIcon(imagen.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
		
		labelFondo.setIcon(iconoFondo);
		
		
		
		estado.setBounds(110, 47, 87, 25);
		
		nombre.setBounds(110,20,57,17);
		
		nombre.setForeground(Color.white);
		
		labelPerfil.setBounds(28, 14, 65, 65);
		
		try{
			imagen= new ImageIcon(VentanaChat.class.getResource("Imagenes/user.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoPerfil= new ImageIcon(imagen.getImage().getScaledInstance(labelPerfil.getWidth(), labelPerfil.getHeight(), Image.SCALE_DEFAULT));
		
		labelPerfil.setIcon(iconoPerfil);
		
		labelSalir.setBounds(742,33,25,25);
		
		try{
			imagen= new ImageIcon(VentanaChat.class.getResource("Imagenes/cierre.png").toURI().toURL());
		}catch (Exception e){
			System.out.println("No se encuentra el archivo");
		}
		
		iconoSalir= new ImageIcon(imagen.getImage().getScaledInstance(labelSalir.getWidth(), labelSalir.getHeight(), Image.SCALE_DEFAULT));
		
		labelSalir.setIcon(iconoSalir);
		
		mensaje.setBorder(BorderFactory.createLineBorder(Color.black));
		
		principal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		usuariosLinea.setBorder(BorderFactory.createLineBorder(Color.black));
		
		ArrayList<String> listadeConectados=new ArrayList<String>();
		
		DefaultListModel modelo = new DefaultListModel();
		
		for(int i = 1; i<=50; i++){
		        modelo.addElement(i);
		}
		
		usuarios.setModel(modelo);
		
		
		//Lo añadimos al panel
		
		getContentPane().setLayout(null);
		
		
		
		getContentPane().add(labelEnviar);
		
		getContentPane().add(usuariosLinea);
		
		getContentPane().add(estado);
		
		
		
		getContentPane().add(nombre);
		
		getContentPane().add(labelPerfil);
		
		getContentPane().add(labelSalir);
		
		getContentPane().add(mensaje);
		
		getContentPane().add(labelFondo);
		
		getContentPane().add(panelMensajes);
	
		getContentPane().add(panelLista);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Generamos los eventos
		
		mensaje.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (mensaje.getText().length()==0){
					mensaje.setText("Introduzca aqui su mensaje");
					mensaje.setForeground(Color.lightGray);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if (mensaje.getText().equals("Introduzca aqui su mensaje")){
					mensaje.setText("");
					mensaje.setForeground(Color.BLACK);
				}
				
			}
		});
		
		labelEnviar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				principal.setText(principal.getText()+"\n"+"Pepe"+": "+mensaje.getText());
				mensaje.setText("");
				
			}
		});
		
		mensaje.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					principal.setText(principal.getText()+"\n"+"Pepe"+": "+mensaje.getText());
					mensaje.setText("");
					
				}
				
			}
		
			
			
			
			
		});
		
		labelSalir.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
		});
		
	}
	
}

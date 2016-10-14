package Proyecto.Cluedo.Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class VentanaRegistro extends JFrame {

	private JButton botonRegistrar;
	
	private JButton botonCancelar;
	
	private JTextField textoNombre;
	
	private JTextField textoApellido;
	
	private JTextField textoUsuario;
	
	private JTextField textoEmail;
	
	private JTextField textoRespuesta;
	
	private JTextField textoContraseña;

	private JTextField textoContraseña2;
	
	
	
	
	
	
	public static void main (String [] args){
		VentanaRegistro ventana= new VentanaRegistro();
		ventana.setVisible(true);
	}
	
	public VentanaRegistro (){
		
		//Inicializamos el frame
		
		setUndecorated(true);
		setResizable(false);
		setSize(new Dimension(600, 900));
		setLocationRelativeTo(null);
		
		setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		//Generamos los componentes
		
		JLabel nombre = new JLabel("Nombre: ");
		
		JLabel apellido = new JLabel("Apellido: ");
		
		JLabel usuario = new JLabel("Usuario: ");
		
		JLabel email = new JLabel("E-mail: ");
		
		JLabel fecha = new JLabel("Fecha Nacimiento: ");
		
		JLabel seguridad = new JLabel("Pregunta Seguridad: ");
		
		JLabel respuesta = new JLabel("Respuesta: ");
		
		
		
		JLabel genero = new JLabel("Genero: ");
		
		JLabel contraseña = new JLabel("Contraseña: ");
		
		JLabel contraseña2= new JLabel("Repite contraseña: ");
		
		
		
		
		textoApellido= new JTextField();
		
		textoContraseña= new JTextField();
		
		textoContraseña2= new JTextField();
		
		textoEmail= new JTextField();
		
		textoNombre= new JTextField();
		
		textoRespuesta= new JTextField();
		
		textoUsuario= new JTextField();
		
		
		
		botonRegistrar= new JButton("Registrar");
		
		botonCancelar= new JButton("Cancelar");
		
		JRadioButton hombre= new JRadioButton("Hombre",true);
		
		JRadioButton mujer = new JRadioButton("Mujer",false);
		
		String [] preguntas = {"¿Como se llamaba tu primera mascota?","¿Como se llamaba tu primer profesor?","¿Donde hiciste el primer viaje en avion?"};
		
		JComboBox<String> listaPreguntas = new JComboBox<String>(preguntas);
		
		ImageIcon imagen = new ImageIcon();
		
		Icon iconoPerfil;
		
		JLabel labelPerfil= new JLabel();
		
		//Establecemos el formato 
		
		getContentPane().setLayout(null);
		
		ButtonGroup botones= new ButtonGroup();
		
		botones.add(hombre);
		botones.add(mujer);
		
		hombre.setBounds(245, 594, 79, 23);
		
		
		mujer.setBounds(384, 594, 70, 23);
		
		
		try{
		imagen= new ImageIcon(VentanaRegistro.class.getResource("Imagenes/user.png"));
		}catch (Exception e){
			System.out.println("No se ha encontrado el archivo");
		}
		
		labelPerfil.setBounds(210, 57, 200, 200);
		
		iconoPerfil= new ImageIcon(imagen.getImage().getScaledInstance(labelPerfil.getWidth(), labelPerfil.getHeight(), Image.SCALE_DEFAULT));
		
		labelPerfil.setIcon(iconoPerfil);
		
		
		
		nombre.setFont(new Font("System", Font.PLAIN, 12));
		
		apellido.setFont(new Font("System", Font.PLAIN, 12));
		
		usuario.setFont(new Font("System", Font.PLAIN, 12));
		
		email.setFont(new Font("System", Font.PLAIN, 12));
		
		contraseña.setFont(new Font("System", Font.PLAIN, 12));
		
		contraseña2.setFont(new Font("System", Font.PLAIN, 12));
		
		genero.setFont(new Font("System", Font.PLAIN, 12));
		
		fecha.setFont(new Font("System", Font.PLAIN, 12));
		
		seguridad.setFont(new Font("System", Font.PLAIN, 12));
		
		respuesta.setFont(new Font("System", Font.PLAIN, 12));
		
		textoNombre.setBounds(226, 310, 296, 25);
		
		textoApellido.setBounds(226, 355, 296, 25);
		
		textoUsuario.setBounds(226, 405, 296, 25);
		
		textoEmail.setBounds(226, 457, 296, 25);
		
		textoContraseña.setBounds(226, 501, 296, 25);
		
		textoContraseña2.setBounds(226, 547, 296, 25);
		
		textoRespuesta.setBounds(226, 732, 296, 25);
		
		botonRegistrar.setBounds(138, 798, 145, 57);
		
		botonCancelar.setBounds(338	, 798, 145, 57);
		
		
		nombre.setBounds(115, 309, 65, 27);
		
		genero.setBounds(115,594,65,27);
		
		apellido.setBounds(115, 354, 65, 27);
		
		usuario.setBounds(115, 404, 98, 27);
		
		email.setBounds(115, 456, 65, 27);
		
		contraseña.setBounds(115, 500, 84, 27);
		
		contraseña2.setBounds(115, 546, 114, 27);
		
		fecha.setBounds(115, 641, 145, 17);
		
		seguridad.setBounds(115, 687, 145, 27);
		
		respuesta.setBounds(115,736,154,17);
		
		listaPreguntas.setBounds(237, 688, 281, 25);
		
		hombre.setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		mujer.setBackground(new Color(1.0f,1.0f,1.0f,0.95f));
		
		//Añadimos al panel
		
		getContentPane().add(textoApellido);
		
		getContentPane().add(textoContraseña);
		
		getContentPane().add(textoContraseña2);
		
		getContentPane().add(textoEmail);
		
		getContentPane().add(textoNombre);
		
		getContentPane().add(textoRespuesta);
		
		getContentPane().add(textoUsuario);
		
		getContentPane().add(nombre);
		
		getContentPane().add(apellido);
		
		getContentPane().add(fecha);
		
		getContentPane().add(usuario);
		
		getContentPane().add(contraseña);
		
		getContentPane().add(contraseña2);
		
		getContentPane().add(email);
		
		getContentPane().add(respuesta);
		
		getContentPane().add(listaPreguntas);
		
		getContentPane().add(hombre);
		
		getContentPane().add(mujer);
		
		getContentPane().add(genero);
		
		getContentPane().add(seguridad);
		
		getContentPane().add(labelPerfil);
		
		getContentPane().add(botonCancelar);
		
		getContentPane().add(botonRegistrar);
		
		
		
		//Eventos
		
		botonCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		JSpinner spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerNumberModel(23, 1, 31, 1));
		spinnerDia.setBounds(395, 637, 65, 25);
		getContentPane().add(spinnerDia);
		
		JSpinner spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(5, 1, 12, 1));
		
		spinnerMes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int)spinnerMes.getValue()==1||(int)spinnerMes.getValue()==3||(int)spinnerMes.getValue()==5||(int)spinnerMes.getValue()==7||(int)spinnerMes.getValue()==8||(int)spinnerMes.getValue()==10||(int)spinnerMes.getValue()==12){
					spinnerDia.setModel(new SpinnerNumberModel(23, 1, 31, 1));
				}else if ((int)spinnerMes.getValue()==2){
					spinnerDia.setModel(new SpinnerNumberModel(23, 1, 28, 1));
				}else {
					spinnerDia.setModel(new SpinnerNumberModel(23, 1, 30, 1));
				}
			
			}
		});
		spinnerMes.setBounds(321, 637, 65, 25);
		getContentPane().add(spinnerMes);
		
		JSpinner spinnerAño = new JSpinner();
		spinnerAño.setModel(new SpinnerNumberModel(new Integer(2016), new Integer(0), null, new Integer(1)));
		spinnerAño.setBounds(245, 637, 65, 25);
		getContentPane().add(spinnerAño);
		
		
	}
}

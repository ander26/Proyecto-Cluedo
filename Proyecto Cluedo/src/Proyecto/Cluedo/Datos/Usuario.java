package Proyecto.Cluedo.Datos;

import java.util.ArrayList;
import java.util.Date;

import Proyecto.Cluedo.Interfaces.Logineable;

public class Usuario implements Logineable {
	
	//Generamos las variables
	
	/**
	 * Array que contiene las preguntas de seguridad 
	 */
	
	private static final String [] LISTA_PREGUNTAS = {"¿Como se llamaba tu primera mascota?","¿Como se llamaba tu primer profesor?","¿Donde hiciste el primer viaje en avion?"};
	
	
	
	/**
	 * Atributo que contiene el nombre del usuario
	 */
	
	private String nombre;
	
	/**
	 * Atributo que contiene los apellidos del usuario
	 */
	
	private String apellidos;
	
	
	/**
	 * Atributo que contiene el nombre de usuario del usuario
	 */
	
	private String usuario;
	
	/**
	 * Atributo que contiene la contraseña del usuario
	 */
	
	private String contraseña;

	/**
	 * Atributo que contiene el genero del usuario
	 */
	
	private char genero;
	
	/**
	 * Atributo que contiene la fecha de nacimiento del usuario
	 */
	
	private Date fechaNacimeinto;
	
	/**
	 * Atributo que contiene la respuesta a la pregunta de seguridad
	 */
	
	private String respuesta;
	
	/**
	 * Atributo que contiene la pregunta elegida por el usuario
	 */
	
	private int pregunta;
	
	/**
	 * Atributo que contiene el email del usuario
	 */
	
	private String email;
	
	
	/**
	 * Construcor con parametros
	 * @param nombre Parametro que contiene el nombre del usuario 
	 * @param apellidos Parametro que contiene los apellidos del usuario
	 * @param usuario Parametro que contiene el nombre del usuario
	 * @param contraseña Parametro que contiene la contraseña 
	 * @param genero Parametro que contiene el genero del usuario
	 * @param fechaNacimeinto Parametro que contiene la fecha de nacimiento del usuario 
	 * @param respuesta Parametro que contiene la respuesta de seguridad
	 * @param pregunta Parametro que contiene la posicion de la pregunta de seguridad del usuario 
	 * @param email Parametro que contiene el email del usuario 
	 */
	

	public Usuario(String nombre, String apellidos, String usuario, String contraseña, char genero,
			Date fechaNacimeinto, String respuesta, int pregunta,String email) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.genero = genero;
		this.fechaNacimeinto = fechaNacimeinto;
		this.respuesta = respuesta;
		this.pregunta = pregunta;
		this.email=email;
		
	}

	

	/**
	 * Sirve para recuperar la contraseña del usuario
	 * @param usuario Parametro que contiene el nombre de usuario que ha perdido la contraseña
	 * @param listaDeUsuarios Array List que contiene todos los usuarios
	 * @return Devuelve la contraseña si se responde correctamente a la pregunta
	 */
	
	public String recuperarContraseña(String usuario, String respuesta, ArrayList<Usuario> listaDeUsuarios) {
		
		for (Usuario u: listaDeUsuarios){
			if (u.getUsuario().equals(usuario)){
				if (u.getRespuesta().equals(respuesta)){
					return u.getContraseña();
				}
			}
		}
		
		return null;
	}

	/**
	 * Indica que el login del paciente es correcto
	 * @param usuario Parametro que contiene el nombre de usuario 
	 * @param contraseña Parametro que contiene la contraseña del usuario
	 * @param listaDeUsuarios ArrayList que contiene los usuarios del juego
	 * @return Devuelve true si el login es correcto
	 */
	
	@Override
	public boolean loginUsuario(String usuario, String contraseña, ArrayList<Usuario> listaDeUsuarios) {
		
		for (Usuario u: listaDeUsuarios){
			if (u.getUsuario().equals(usuario)){
				if (u.getContraseña().equals(contraseña)){
					return true;
				}
			}
			
		}
		
		return false;
	}

	/**
	 * Metodo que sirve para saber si el registro de un usuario es correcto 
	 * @param usuario Parametro que contiene los datos de un usuario
	 * @param listadeUsuarios Parametro que contiene una lista con los usuarios
	 * @return Devuelve true si el registro es correcto
	 */
	
	
	@Override
	public boolean registroUsuario(Usuario usuario, ArrayList<Usuario> listadeUsuarios) {
		for (Usuario u: listadeUsuarios){
			if (usuario.getUsuario().equals(u.getUsuario())){
				if (usuario.getEmail().equals(u.getEmail())){
					return false;
				}
				
			}
		}
		return true;
	}
	
	/**
	 * Metodo que sirve para obtener la pregunta de seguridad del usuario
	 * @param usuario Parametro que contiene el nombre de usuario
	 * @param listaDeUsuarios Parametro que contiene la lista de los usuarios
	 * @return Devuelve el string con la pregunta del usuario
	 */

	@Override
	public String recuperarPreguntaUsuario(String usuario, ArrayList<Usuario> listaDeUsuarios) {
		for (Usuario u: listaDeUsuarios){
			if (u.getUsuario().equals(usuario)){
				return LISTA_PREGUNTAS[u.getPregunta()];
			}
		}
		return null;
	}

	/**
	 * Metodo que sirve para obtener el nombre del usuario 
	 * @return Devuelve el nombre del usuario
	 */

	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que sirve para establecer el nombre del usuario 
	 * @param nombre Parametro que contiene el nombre del usuario 
	 */


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que sirve para obtener el apellido del usuario 
	 * @return Devuelve el apellido del usuario 
	 */

	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Metodo que sirve para establecer el apellido 
	 * @param apellidos Parametro que contiene los apellidos
	 */

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Metodo que sirve para obtener el nombre de usuario
	 * @return Devuelve el nombre de usuario
	 */

	public String getUsuario() {
		return usuario;
	}

	/**
	 * Metood que sirve para establecer el nombre de usuario
	 * @param usuario Parametro que contiene el nombre de usuario
	 */
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo que sirve para obtener la contraseña
	 * @return Devuelve la contraseña
	 */

	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Metodo que sirve para establecer la contraseña
	 * @param contraseña Parametro que contiene la contraseña
	 */

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * Metodo que sirve para obtener el genero
	 * @return Devuelve el genero
	 */

	public char getGenero() {
		return genero;
	}
	
	/**
	 * Metodo que sirve para establecer el genero 
	 * @param genero Parametro que contiene el genero 
	 */


	public void setGenero(char genero) {
		this.genero = genero;
	}

	/**
	 * Parametro que devuelve la fecha de nacimiento 
	 * @return Devuelve la fecha de nacimeinto 
	 */

	public Date getFechaNacimeinto() {
		return fechaNacimeinto;
	}


	/**
	 * Metodo que sirve para establecer la fecha de nacimiento
	 * @param fechaNacimeinto Parametro que contiene la fecha de nacimeinto 
	 */
	
	public void setFechaNacimeinto(Date fechaNacimeinto) {
		this.fechaNacimeinto = fechaNacimeinto;
	}
	
	/**
	 * Metodo que sirve para obtener la respuesta
	 * @return Devuelve la respuesta
	 */

	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * Metodo que sirve para establecer la respuesta
	 * @param respuesta Parametro que contiene la respuesta
	 */

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Metodo que sirve para obtener la pregunta
	 * @return Devuelve la pregunta
	 */

	public int getPregunta() {
		return pregunta;
	}

	/**
	 * Metodo que sirve para establecer la pregunta
	 * @param pregunta Parametro que contiene la pregunta
	 */

	public void setPregunta(int pregunta) {
		this.pregunta = pregunta;
	}


	/**
	 * Metodo que sirve para obtener el email
	 * @return Devuelve el email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que sirve para establecer el email
	 * @param email Parametro que contiene el email 
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}

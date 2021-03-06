package Proyecto.Cluedo.Interfaces;

import java.util.ArrayList;

import Proyecto.Cluedo.Datos.Usuario;

public interface Logineable {

	
	/**
	 * Sirve para recuperar la contraseņa del usuario
	 * @param usuario Parametro que contiene el nombre de usuario que ha perdido la contraseņa
	 * @param listaDeUsuarios Array List que contiene todos los usuarios
	 * @return Devuelve la contraseņa si se responde correctamente a la pregunta
	 */
	
	public String recuperarContraseņa (String usuario,String respuesta,ArrayList <Usuario> listaDeUsuarios);

	
	/**
	 * Indica que el login del paciente es correcto
	 * @param usuario Parametro que contiene el nombre de usuario 
	 * @param contraseņa Parametro que contiene la contraseņa del usuario
	 * @param listaDeUsuarios ArrayList que contiene los usuarios del juego
	 * @return Devuelve true si el login es correcto
	 */
	
	public boolean loginUsuario (String usuario, String contraseņa, ArrayList<Usuario> listaDeUsuarios);
	
	/**
	 * Metodo que sirve para saber si el registro de un usuario es correcto 
	 * @param usuario Parametro que contiene los datos de un usuario
	 * @param listadeUsuarios Parametro que contiene una lista con los usuarios
	 * @return Devuelve true si el registro es correcto
	 */
	
	public boolean registroUsuario (Usuario usuario, ArrayList<Usuario> listadeUsuarios);
	
	/**
	 * Metodo que sirve para obtener la pregunta de seguridad del usuario
	 * @param usuario Parametro que contiene el nombre de usuario
	 * @param listaDeUsuarios Parametro que contiene la lista de los usuarios
	 * @return Devuelve el string con la pregunta del usuario
	 */
	
	public String recuperarPreguntaUsuario (String usuario, ArrayList<Usuario> listaDeUsuarios);
	

	
}

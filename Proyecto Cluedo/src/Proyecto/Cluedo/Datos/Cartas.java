package Proyecto.Cluedo.Datos;

import javax.swing.JLabel;

public abstract class Cartas {
	protected String nombre;
	protected String rutaIcono;
	protected JLabel icono=new JLabel();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRutaIcono() {
		return rutaIcono;
	}
	public void setRutaIcono(String rutaIcono) {
		this.rutaIcono = rutaIcono;
	}
	public JLabel getIcono() {
		return icono;
	}
	public void setIcono(JLabel icono) {
		this.icono = icono;
	}
	
	

}

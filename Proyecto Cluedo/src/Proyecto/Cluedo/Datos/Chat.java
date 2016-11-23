package Proyecto.Cluedo.Datos;

import java.sql.Date;

public class Chat {

	private String mensaje;
	
	private Date fechaEnvio;
	
	private int CodigoPartida;
	
	private int CodigoJugador;

	
	
	public Chat (String mensaje,int CodigoPartida,int CodigoJugador){
		this.mensaje=mensaje;
		this.fechaEnvio=new Date(System.currentTimeMillis());
		this.CodigoJugador=CodigoJugador;
		this.CodigoPartida=CodigoPartida;
	}
	
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public int getCodigoPartida() {
		return CodigoPartida;
	}

	public void setCodigoPartida(int codigoPartida) {
		CodigoPartida = codigoPartida;
	}

	public int getCodigoJugador() {
		return CodigoJugador;
	}

	public void setCodigoJugador(int codigoJugador) {
		CodigoJugador = codigoJugador;
	}
	
	
}

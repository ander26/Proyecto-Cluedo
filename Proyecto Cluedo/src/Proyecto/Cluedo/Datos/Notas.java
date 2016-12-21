package Proyecto.Cluedo.Datos;

public class Notas {

	private int linea;
	
	private int tabla;
	
	private String mensaje;
	
	public Notas (int linea,int tabla,String mensaje){
		
		this.linea=linea;
		
		this.tabla=tabla;
			
		this.mensaje=mensaje;
		
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public int getTabla() {
		return tabla;
	}

	public void setTabla(int tabla) {
		this.tabla = tabla;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Notas(){
		
	}
	
}
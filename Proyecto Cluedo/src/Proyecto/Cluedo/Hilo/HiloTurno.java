package Proyecto.Cluedo.Hilo;

import java.awt.Image;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Proyecto.Cluedo.Datos.Cartas;
import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Ventanas.VentanaEnviar;
import Proyecto.Cluedo.Ventanas.VentanaPanel;


public class HiloTurno extends Thread {
	
	private boolean jugando=true;
	private GestionBaseDeDatos base;
	private Partida partida;
	private Connection con;
	private boolean pulsado; 
	

	
	
	

	public boolean isPulsado() {
		return pulsado;
	}

	public void setPulsado(boolean pulsado) {
		this.pulsado = pulsado;
	}



	public GestionBaseDeDatos getBase() {
		return base;
	}
	public void setBase(GestionBaseDeDatos base) {
		this.base = base;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int turno=0;
	public int CodigoJugadorConTurno;
	public Jugador jugador;
	public ArrayList<Jugador> arrjugadores=new ArrayList<Jugador>();
	public String mensajePanel;
	
	
	public VentanaPanel vpanel=new VentanaPanel();
	public Logger logger = Logger.getLogger(HiloTurno.class.getName());
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(jugando==true){
			arrjugadores=base.ObtenerJugadoresDePartidaordenadosPorCodigo(partida, con);
			mensajePanel=base.ObtenerPanel(con,partida);
			
			CodigoJugadorConTurno=base.ObtenerCodigoJugadorTurno(con, partida);
			
			//al inicializar el progrma el jugador con menor codigo tiene el turno
			
			if(CodigoJugadorConTurno==-1){
				if(jugador.getCodigo()==arrjugadores.get(0).getCodigo()){
				base.modificarturno(con,arrjugadores.get(0).getCodigo(), 1);
				System.out.println("es el turno de"+arrjugadores.get(0).getUsuario());
//				try {
//					Thread.sleep( 5000 );
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
			}}
		
			
			//esperamos a que cambie el panel
			while(base.ObtenerPanel(con,partida).equals(mensajePanel)){
				
				try {
					Thread.sleep( 5000 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(mensajePanel);				
			}
			System.out.println(mensajePanel+" "+base.ObtenerPanel(con,partida));
			mensajePanel=base.ObtenerPanel(con,partida);
			vpanel.setMensaje(mensajePanel);
			vpanel.setVisible(true);
			logger.log(Level.INFO, "MENSAJE INTRODUCIDO EN EL PANEL 1");
			CodigoJugadorConTurno=base.ObtenerCodigoJugadorTurno(con, partida);			
			ArrayList<Cartas> arrcartas=base.obtenerCartasEnviadas(con, partida.getCodigo(),CodigoJugadorConTurno );
			//esperamos a que todos los jugadores envien la carta o le den al boton de no enviar nada
			
			while(arrcartas.size()!=(arrjugadores.size()-1)){
				
				System.out.println( "arrcartas.size"+arrcartas.size()+"arrjugadores.size"+(arrjugadores.size()-1));
				try {
					Thread.sleep( 5000 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				arrcartas=base.obtenerCartasEnviadas(con, partida.getCodigo(),CodigoJugadorConTurno );
				
				logger.log(Level.INFO, "compruebo si hay cartas");
			}
			if(CodigoJugadorConTurno==jugador.getCodigo()){
				VentanaEnviar vcartasrecibidas=new VentanaEnviar(base, con, partida, jugador);
				vcartasrecibidas.setVisible(true);
				//borrar de la base las cartas enviadas
			}
			//esperamos un tiempo a que ventanaenviar modifique el mensaje
			while(base.ObtenerPanel(con,partida).equals(mensajePanel)){
				try {
					Thread.sleep( 5000 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			vpanel.setMensaje(mensajePanel);
			vpanel.setVisible(true);
			logger.log(Level.INFO, "MENSAJE INTRODUCIDO EN EL PANEL 2");
			
			mensajePanel=base.ObtenerPanel(con,partida);
			//esperamos un tiempo y cambiamos de turno
			try {
				Thread.sleep( 5000 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			if(CodigoJugadorConTurno==jugador.getCodigo()){
				CambiarTurno();
				pulsado=false;
			}
					
		try {
			Thread.sleep( 40 );
		} catch (Exception e) {
		}
		}
	}
	public void acaba() {
		jugando = false;
	}
	public void CambiarTurno(){
		for(int i=0;i<arrjugadores.size();i++){
			if(CodigoJugadorConTurno==arrjugadores.get(i).getCodigo()){
				base.modificarturno(con,arrjugadores.get(i).getCodigo(), 0);
				base.modificarturno(con,arrjugadores.get(i+1).getCodigo(), 1);
				System.out.println("es el turno de"+arrjugadores.get(i+1).getUsuario());
				
			}
		}
	}
		
	
	
	


};

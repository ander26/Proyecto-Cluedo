package Proyecto.Cluedo.Hilo;

import java.awt.Image;
import java.awt.Point;
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
import Proyecto.Cluedo.Ventanas.LabelLugares;
import Proyecto.Cluedo.Ventanas.VentanaEnviar;
import Proyecto.Cluedo.Ventanas.VentanaPanel;


public class HiloTurno extends Thread {
	

	
	
	private boolean jugando=true;
	private GestionBaseDeDatos base;
	private Partida partida;
	private Connection con;
	private boolean pulsado=false; 
	private boolean acusar=false;
	private int dado=-1;
	
		
	private Point [] arrpuertas={new Point(1391,397),new Point(241,120),new Point(209,255),new Point(504,196),new Point(629,113),new Point(1097,289),new Point(1621,185),new Point(1650,325),new Point(1846,174),new Point(1880,334),new Point(1320,771),new Point(573,876),new Point(855,261),new Point(295,104)};
		
	private int CodigoJugadorConTurnoAntiguo;
	private boolean MonigoteMovida=false;
	
	private LabelLugares lugar;
	
	public LabelLugares getLugar() {
		return lugar;
	}

	public void setLugar(LabelLugares lugar) {
		this.lugar = lugar;
	}
	
	public Point[] getArrpuertas() {
		return arrpuertas;
	}

	

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public boolean isAcusar() {
		return acusar;
	}

	public void setAcusar(boolean acusar) {
		this.acusar = acusar;
	}

	
	
	
	
	public boolean isMonigoteMovida() {
		return MonigoteMovida;
	}

	public void setMonigoteMovida(boolean monigoteMovida) {
		MonigoteMovida = monigoteMovida;
	}

	

	

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
	
	public int getCodigoJugadorConTurno() {
		return CodigoJugadorConTurno;
	}

	public void setCodigoJugadorConTurno(int codigoJugadorConTurno) {
		CodigoJugadorConTurno = codigoJugadorConTurno;
	}
	public ArrayList<Jugador> arrjugadores=new ArrayList<Jugador>();
	public String mensajePanel;
	
	public VentanaEnviar vcartasrecibidas;
	public VentanaPanel vpanel=new VentanaPanel();
	public Logger logger = Logger.getLogger(HiloTurno.class.getName());
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(jugando==true){
			arrjugadores=base.ObtenerJugadoresDePartidaordenadosPorCodigo(partida, con);
			System.out.println("tamaño"+arrjugadores.size());
			mensajePanel=base.ObtenerPanel(con,partida);
			
			CodigoJugadorConTurno=base.ObtenerCodigoJugadorTurno(con, partida);
			System.out.println(CodigoJugadorConTurno+"CodigoJugadorConTurno");
			
			//al inicializar el progrma el jugador con menor codigo tiene el turno
			if(CodigoJugadorConTurno==-1){
				if(jugador.getCodigo()==arrjugadores.get(0).getCodigo()){
				base.modificarturno(con,arrjugadores.get(0).getCodigo(), 1);
				System.out.println("es el turno de"+arrjugadores.get(0).getUsuario());
//				try {
//					Thread.sleep( 30000 );
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
			}}else{
			CodigoJugadorConTurno=base.ObtenerCodigoJugadorTurno(con, partida);
			CodigoJugadorConTurnoAntiguo=CodigoJugadorConTurno;
			
			System.out.println(CodigoJugadorConTurno);
			
			//El codigo hasta aqui solo lo tiene que hacer una vez al cambiar el turno.
			
			//cambio de turno si el jugador va a acusar
			Jugador jug=BusacarJugadorConCodigo(CodigoJugadorConTurno,arrjugadores);
			Point punto= base.ObtenerCoordenada(con, jug);
			
			while(base.ObtenerPanel(con,partida).equals(mensajePanel) && CodigoJugadorConTurnoAntiguo==base.ObtenerCodigoJugadorTurno(con, partida)){
			while(punto==base.ObtenerCoordenada(con, jug)){
				try {
					Thread.sleep( 3000 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				if(estaEn(punto,arrpuertas)){
			//esperamos a que cambie el panel
			while(base.ObtenerPanel(con,partida).equals(mensajePanel)){
				System.out.println("primer while");
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
			if (jugador.getCodigo()!=CodigoJugadorConTurno){
			vpanel.setVisible(true);
			}
			vpanel.repaint();
			logger.log(Level.INFO, "MENSAJE INTRODUCIDO EN EL PANEL 1");
			CodigoJugadorConTurno=base.ObtenerCodigoJugadorTurno(con, partida);			
			ArrayList<Cartas> arrcartas=base.obtenerCartasEnviadas(con, partida.getCodigo(),CodigoJugadorConTurno );
			//esperamos a que todos los jugadores envien la carta o le den al boton de no enviar nada
			if (jugador.getCodigo()==CodigoJugadorConTurno){
			while(arrcartas.size()!=(arrjugadores.size()-1)){
				System.out.println("segundo while");
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
			
				vcartasrecibidas=new VentanaEnviar(base, con, partida, jugador);
				vcartasrecibidas.setVisible(true);
				
				try {
				Thread.sleep( 8000 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else{
				while(base.ObtenerPanel(con,partida).equals(mensajePanel)){
					System.out.println("segundo while");
					try {
						Thread.sleep( 8000 );
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(mensajePanel);				
				}
				System.out.println(mensajePanel+" "+base.ObtenerPanel(con,partida));
				
			}
			
			mensajePanel=base.ObtenerPanel(con,partida);
			vpanel.setMensaje(mensajePanel);
			mensajePanel=base.ObtenerPanel(con,partida);
			
			vpanel.setVisible(true);
			vpanel.repaint();
			logger.log(Level.INFO, "MENSAJE INTRODUCIDO EN EL PANEL 2");
			
			//esperamos un tiempo y cambiamos de turno
//			try {
//				Thread.sleep( 120000 );
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			int CodigoJugadorConTurnoAntiguo=CodigoJugadorConTurno;
			if(CodigoJugadorConTurno==jugador.getCodigo()){
				System.out.println(CodigoJugadorConTurno);
				//borrar de la base las cartas enviadas
				base.borrarCartas(con, partida,CodigoJugadorConTurno );
				CambiarTurno();
				
				

			}else{
				while(CodigoJugadorConTurnoAntiguo==base.ObtenerCodigoJugadorTurno(con, partida)){
					System.out.println("4 while");
					try {
						Thread.sleep( 8000 );
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}
			//esperamos un tiempo a que se borren las cartas
			arrcartas=base.obtenerCartasEnviadas(con, partida.getCodigo(),CodigoJugadorConTurnoAntiguo);
			while(arrcartas.size()!=0){
				System.out.println("tercer while");
				try {
					Thread.sleep( 8000 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				arrcartas=base.obtenerCartasEnviadas(con, partida.getCodigo(),CodigoJugadorConTurno );
				
			}
			}
			//cambio de turno si el jugador no va a acusar
			//se hace en el tablero mediante getters y setters, el hilo tiene que esperar a que pase ese cambio
//			else{
//				while(CodigoJugadorConTurnoAntiguo==base.ObtenerCodigoJugadorTurno(con, partida)){
//					System.out.println("6 while");
//					
//					try {
//						Thread.sleep( 8000 );
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					
//				}
//				
//
//			}
			try {
			Thread.sleep( 8000 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
			}
		}
		}
//		try {
//			Thread.sleep( 40 );
//		} catch (Exception e) {
//		}
		
	
	public void acaba() {
		jugando = false;
	}
	public void CambiarTurno(){
		for(int i=0;i<arrjugadores.size();i++){
			if(CodigoJugadorConTurno==arrjugadores.get(i).getCodigo()){
				base.modificarturno(con,arrjugadores.get(i).getCodigo(), 0);
				if(i==(arrjugadores.size()-1)){
					base.modificarturno(con,arrjugadores.get(0).getCodigo(), 1);
					System.out.println("es el turno de"+arrjugadores.get(0).getUsuario());
				}else{
					base.modificarturno(con,arrjugadores.get(i+1).getCodigo(), 1);
					System.out.println("es el turno de"+arrjugadores.get(i+1).getUsuario());
				}
				pulsado=false;
				acusar=false;
				dado=-1;

				lugar.setSeleccionado(false);
				lugar.repaint();
				
			}
		}
	}
	public boolean estaEn(Point punto,Point [] array){
		for(int i=0;i<array.length;i++){
			if(punto.equals(array[i])){
				return true;
			}
		}return false;
	}
	public Jugador BusacarJugadorConCodigo(int codigo,ArrayList<Jugador> array){
		for(int i=0;i<array.size();i++){
			if(codigo==array.get(i).getCodigo()){
				return array.get(i);
			}
		}return null;
	}
		
	
	
	


};

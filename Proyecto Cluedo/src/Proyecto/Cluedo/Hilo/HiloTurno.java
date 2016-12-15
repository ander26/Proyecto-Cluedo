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
	
	public boolean jugando=true;
	
	public GestionBaseDeDatos base;
	
	public Partida partida;
	
	public Connection con;
	
	public boolean pulsado; 
	
	private JLabel labelSemaforo;
	
	
	private JLabel labelDado;
	
	private JLabel labelAcusar;
	
	
	
	
	public JLabel getLabelDado() {
		return labelDado;
	}

	public void setLabelDado(JLabel labelDado) {
		this.labelDado = labelDado;
	}

	public JLabel getLabelAcusar() {
		return labelAcusar;
	}

	public void setLabelAcusar(JLabel labelAcusar) {
		this.labelAcusar = labelAcusar;
	}

	public boolean isPulsado() {
		return pulsado;
	}

	public void setPulsado(boolean pulsado) {
		this.pulsado = pulsado;
	}

	public JLabel getLabelSemaforo() {
		return labelSemaforo;
	}

	public void setLabelSemaforo(JLabel labelSemaforo) {
		this.labelSemaforo = labelSemaforo;
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
		
		
		
		while(jugando){
			
			arrjugadores=base.ObtenerJugadoresDePartidaordenadosPorCodigo(partida, con);
			
			mensajePanel=base.ObtenerPanel(con,partida);
			
			CodigoJugadorConTurno=base.ObtenerCodigoJugadorTurno(con, partida);
			
			//al inicializar el progrma el jugador con menor codigo tiene el turno
			
			if(CodigoJugadorConTurno==100){
			
				if(jugador.getCodigo()==arrjugadores.get(0).getCodigo()){
				
					base.modificarturno(con,arrjugadores.get(0).getCodigo(), 1);
				
					System.out.println("es el turno de"+arrjugadores.get(0).getUsuario());
			
					try {
					
						Thread.sleep( 30000 );
				
					} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}}
			
			
			if (jugador.getCodigo()==CodigoJugadorConTurno){
				
				ImageIcon imagen = new ImageIcon();
				
				Icon icono;
			
				try{
					
					imagen=new ImageIcon(HiloTurno.class.getResource("Imagenes/semaforoverde.png").toURI().toURL());
					
				}catch (Exception e){
					
					System.out.println("No se ha encontrado al archivo");
				}
				
				icono = new ImageIcon(imagen.getImage().getScaledInstance(labelSemaforo.getWidth(), labelSemaforo.getHeight(), Image.SCALE_DEFAULT));
			
				labelSemaforo.setIcon(icono);
				
				labelSemaforo.repaint();
				
				try{
					
					imagen=new ImageIcon(HiloTurno.class.getResource("Imagenes/dado.gif").toURI().toURL());
					
				}catch (Exception e){
					
					System.out.println("No se ha encontrado al archivo");
				}
				
				icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(), labelDado.getHeight(), Image.SCALE_DEFAULT));
			
				labelDado.setIcon(icono);
				
				labelDado.repaint();
				
				try{
					
					imagen=new ImageIcon(HiloTurno.class.getResource("Imagenes/pusharriba.png").toURI().toURL());
					
				}catch (Exception e){
					
					System.out.println("No se ha encontrado al archivo");
				}
				
				icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(), labelAcusar.getHeight(), Image.SCALE_DEFAULT));
			
				labelAcusar.setIcon(icono);
				
				labelAcusar.repaint();
				
				
			}else{
				
				ImageIcon imagen = new ImageIcon();
				
				Icon icono;
			
				try{
					
					imagen=new ImageIcon(HiloTurno.class.getResource("Imagenes/semafororojot.png").toURI().toURL());
					
				}catch (Exception e){
					
					System.out.println("No se ha encontrado al archivo");
				}
				
				icono = new ImageIcon(imagen.getImage().getScaledInstance(labelSemaforo.getWidth(), labelSemaforo.getHeight(), Image.SCALE_DEFAULT));
			
				labelSemaforo.setIcon(icono);
				
				labelSemaforo.repaint();
				
				
				try{
					
					imagen=new ImageIcon(HiloTurno.class.getResource("Imagenes/dadoNegro.gif").toURI().toURL());
					
				}catch (Exception e){
					
					System.out.println("No se ha encontrado al archivo");
				}
				
				icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(), labelDado.getHeight(), Image.SCALE_DEFAULT));
			
				labelDado.setIcon(icono);
				
				labelDado.repaint();
				
				
				try{
					
					imagen=new ImageIcon(HiloTurno.class.getResource("Imagenes/pusharribaNegro.png").toURI().toURL());
					
				}catch (Exception e){
					
					System.out.println("No se ha encontrado al archivo");
				}
				
				icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(), labelAcusar.getHeight(), Image.SCALE_DEFAULT));
			
				labelAcusar.setIcon(icono);
				
				labelAcusar.repaint();
				
			}
			
			//esperamos a que cambie el panel
			
			while(base.ObtenerPanel(con,partida).equals(mensajePanel)){
				
				try {
					Thread.sleep( 30000 );
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
			
			logger.log(Level.INFO, "MENSAJE INTRODUCIDO EN EL PANEL");
			
			CodigoJugadorConTurno=base.ObtenerCodigoJugadorTurno(con, partida);			
			
			ArrayList<Cartas> arrcartas=base.obtenerCartasEnviadas(con, partida.getCodigo(),CodigoJugadorConTurno );
			
			//esperamos a que todos los jugadores envien la carta o le den al boton de no enviar nada
			
			while(arrcartas.size()!=(arrjugadores.size()-1)){
				System.out.println( "arrcartas.size"+arrcartas.size()+"arrjugadores.size"+(arrjugadores.size()-1));
				try {
					Thread.sleep( 30000 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				arrcartas=base.obtenerCartasEnviadas(con, partida.getCodigo(),CodigoJugadorConTurno );
				
				logger.log(Level.INFO, "compruebo si hay cartas");
			}
			
			if(CodigoJugadorConTurno==jugador.getCodigo()){
				VentanaEnviar vcartasrecibidas=new VentanaEnviar(base, con, partida, jugador);
			}
			
			//esperamos un tiempo a que ventanaenviar modifique el mensaje
			
			while(base.ObtenerPanel(con,partida).equals(mensajePanel)){
				try {
					Thread.sleep( 30000 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			vpanel.setMensaje(mensajePanel);
			vpanel.repaint();
			logger.log(Level.INFO, "MENSAJE INTRODUCIDO EN EL PANEL");
			
			mensajePanel=base.ObtenerPanel(con,partida);
			
			//esperamos un tiempo y cambiamos de turno
			
			try {
				Thread.sleep( 120000 );
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
	
	
	/**
	 * Metodo que sirve para finalizar el hilo 
	 */
	
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

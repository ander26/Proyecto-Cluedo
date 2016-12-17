package Proyecto.Cluedo.Hilo;

import java.awt.Image;
import java.sql.Connection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;

public class hiloPìntado extends Thread{

	private boolean acabado=true;
	
	private JLabel labelSemaforo;
	
	
	private JLabel labelDado;
	
	private JLabel labelAcusar;
	
	private JLabel trainera;
	
	private JLabel traineraUPV;
	
	private GestionBaseDeDatos base = new GestionBaseDeDatos();
	
	private Partida p;
	
	private Jugador j;
	
	private Connection conexion;
	
	private int anchura;
	
	private int turno;
	
	public hiloPìntado(JLabel labelSemaforo, JLabel labelDado, JLabel labelAcusar, JLabel trainera, Partida p,
			Jugador j, Connection conexion,int anchura,JLabel traineraUPV) {
		this.labelSemaforo = labelSemaforo;
		this.labelDado = labelDado;
		this.labelAcusar = labelAcusar;
		this.trainera = trainera;
		this.p = p;
		this.j = j;
		this.conexion = conexion;
		this.anchura=anchura;
		this.traineraUPV=traineraUPV;
		turno=-1;
	}

	public void run(){
		
		while (acabado){
			
			if (turno!=base.ObtenerCodigoJugadorTurno(conexion, p)){
			
			turno=base.ObtenerCodigoJugadorTurno(conexion, p);
			
			
			
			if (j.getCodigo()==turno){
				
				System.out.println("HACE");
				
				ImageIcon imagen = new ImageIcon();
				
				Icon icono;
			
					
			
				
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
				
				
			
				try{
					
					imagen=new ImageIcon(HiloTurno.class.getResource("Imagenes/semaforoverde.png").toURI().toURL());
					
				}catch (Exception e){
					
					System.out.println("No se ha encontrado al archivo");
				}
				
				icono = new ImageIcon(imagen.getImage().getScaledInstance(labelSemaforo.getWidth(), labelSemaforo.getHeight(), Image.SCALE_DEFAULT));
			
				labelSemaforo.setIcon(icono);
				
				labelSemaforo.repaint();
				
				labelSemaforo.revalidate();
				
				
			}else{
				
				System.out.println("NO HACE");
				
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
				
				labelSemaforo.revalidate();
				
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
			}
			
			trainera.setBounds(trainera.getX()-1, trainera.getY(), 250, 100);
			
			trainera.repaint();
			
			
			traineraUPV.setBounds(traineraUPV.getX()-1, trainera.getY(), 250, 100);
			
			traineraUPV.repaint();
			
			if (trainera.getX()==-250){
				trainera.setLocation(anchura, trainera.getY());
				trainera.repaint();
			}
			
			if (traineraUPV.getX()==-250){
				traineraUPV.setLocation(anchura, traineraUPV.getY());
				traineraUPV.repaint();
			}
//			
//			try{
//				
//				Thread.sleep(1000);
//			}catch (Exception a){
//				
//				
//			}
			
			
		}
		
	}
	
	public void acabar (){
		
		acabado=false;
		
	}
}

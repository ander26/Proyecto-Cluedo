package Proyecto.Cluedo.Hilo;

import java.awt.Image;
import java.sql.Connection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Ventanas.Panelcirculos;

public class hiloPìntado extends Thread {

	private boolean acabado = true;

	private JLabel semaforo;

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

	private boolean orientacion = true;

	private boolean animacion1 = false;

	private JLabel ficha;

	
	
	public boolean isAnimacion1() {
		return animacion1;
	}

	public void setAnimacion1(boolean animacion1) {
		this.animacion1 = animacion1;
	}

	public JLabel getFicha() {
		return ficha;
	}

	public void setFicha(JLabel ficha) {
		this.ficha = ficha;
	}

	public boolean isOrientacion() {
		return orientacion;
	}

	public void setOrientacion(boolean orientacion) {
		this.orientacion = orientacion;
	}

	public hiloPìntado(JLabel semaforo, JLabel labelDado, JLabel labelAcusar, JLabel trainera, Partida p, Jugador j,
			Connection conexion, int anchura, JLabel traineraUPV) {
		this.semaforo = semaforo;
		this.labelDado = labelDado;
		this.labelAcusar = labelAcusar;
		this.trainera = trainera;
		this.p = p;
		this.j = j;
		this.conexion = conexion;
		this.anchura = anchura;
		this.traineraUPV = traineraUPV;
		

		turno = -1;
	}

	public void run() {

		while (acabado) {

			// System.out.println(turno);
			//
			// System.out.println(base.ObtenerCodigoJugadorTurno(conexion, p));

			if (turno != base.ObtenerCodigoJugadorTurno(conexion, p)) {

				turno = base.ObtenerCodigoJugadorTurno(conexion, p);

				if (j.getCodigo() == turno) {

					System.out.println("HACE");

					ImageIcon imagen = new ImageIcon();

					Icon icono;

					try {

						imagen = new ImageIcon(HiloTurno.class.getResource("Imagenes/dado.gif").toURI().toURL());

					} catch (Exception e) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(),
							labelDado.getHeight(), Image.SCALE_DEFAULT));

					labelDado.setIcon(icono);

					labelDado.repaint();

					try {

						imagen = new ImageIcon(HiloTurno.class.getResource("Imagenes/pusharriba.png").toURI().toURL());

					} catch (Exception e) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(),
							labelAcusar.getHeight(), Image.SCALE_DEFAULT));

					labelAcusar.setIcon(icono);

					labelAcusar.repaint();

					try {

						imagen = new ImageIcon(
								HiloTurno.class.getResource("Imagenes/semaforoverde.png").toURI().toURL());

					} catch (Exception e) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(), semaforo.getHeight(),
							Image.SCALE_DEFAULT));

					semaforo.setIcon(icono);

					semaforo.repaint();

				} else {

					System.out.println("NO HACE");

					ImageIcon imagen = new ImageIcon();

					Icon icono;

					try {

						imagen = new ImageIcon(
								HiloTurno.class.getResource("Imagenes/semafororojot.png").toURI().toURL());

					} catch (Exception e) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(semaforo.getWidth(), semaforo.getHeight(),
							Image.SCALE_DEFAULT));

					semaforo.setIcon(icono);

					semaforo.repaint();

					try {

						imagen = new ImageIcon(HiloTurno.class.getResource("Imagenes/dadoNegro.gif").toURI().toURL());

					} catch (Exception e) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(labelDado.getWidth(),
							labelDado.getHeight(), Image.SCALE_DEFAULT));

					labelDado.setIcon(icono);

					labelDado.repaint();

					try {

						imagen = new ImageIcon(
								HiloTurno.class.getResource("Imagenes/pusharribaNegro.png").toURI().toURL());

					} catch (Exception e) {

						System.out.println("No se ha encontrado al archivo");
					}

					icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAcusar.getWidth(),
							labelAcusar.getHeight(), Image.SCALE_DEFAULT));

					labelAcusar.setIcon(icono);

					labelAcusar.repaint();

				}
			}

			if (!animacion1) {
				if (orientacion) {
					trainera.setBounds(trainera.getX() - 10, trainera.getY(), 250, 100);

					trainera.repaint();

					traineraUPV.setBounds(traineraUPV.getX() - 10, trainera.getY(), 250, 100);

					traineraUPV.repaint();

					if (trainera.getX() == -250) {
						trainera.setLocation(anchura, trainera.getY());
						trainera.repaint();
					}

					if (traineraUPV.getX() == -250) {
						traineraUPV.setLocation(anchura, traineraUPV.getY());
						traineraUPV.repaint();
					}

				} else {
					trainera.setBounds(trainera.getX() + 10, trainera.getY(), 250, 100);

					trainera.repaint();

					traineraUPV.setBounds(traineraUPV.getX() + 10, trainera.getY(), 250, 100);

					traineraUPV.repaint();

					if (trainera.getX() == anchura) {
						trainera.setLocation(-250, trainera.getY());
						trainera.repaint();
					}

					if (traineraUPV.getX() == anchura) {
						traineraUPV.setLocation(-250, traineraUPV.getY());
						traineraUPV.repaint();
					}

				}
			} else {

				if (ficha.getY() > 520) {
					ficha.setLocation(ficha.getX() - 3 , ficha.getY() - 5);
					ficha.repaint();
				} else {
					
						if (ficha.getX() < 1300) {
							trainera.setLocation(trainera.getX() + 10, trainera.getY());

							trainera.repaint();
							
							traineraUPV.setLocation(traineraUPV.getX() + 10, traineraUPV.getY());

							traineraUPV.repaint();
							
							ficha.setLocation(ficha.getX() + 10, ficha.getY());
							
							ficha.repaint();
						
						} else {
							if (ficha.getY() > 397 - 20) {
								ficha.setLocation(ficha.getX()+3, ficha.getY() - 5);
								
								ficha.repaint();
								
							} else {
								animacion1 = false;
							}
						}
					
				}
			}
			//
			// try{
			//
			// Thread.sleep(1000);
			// }catch (Exception a){
			//
			//
			// }

		}

	}

	public void acabar() {

		acabado = false;

	}
}

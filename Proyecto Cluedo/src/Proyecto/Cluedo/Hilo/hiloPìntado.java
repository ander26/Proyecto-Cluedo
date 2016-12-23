package Proyecto.Cluedo.Hilo;

import java.awt.Image;
import java.awt.Point;
import java.sql.Connection;
import java.util.ArrayList;

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

	private boolean animacion2 = false;

	private boolean animacion3 = false;

	private boolean animacion4 = false;

	private boolean seguir = true;

	private boolean hecho = false;

	private boolean hecho1 = false;

	private JLabel ficha;
	
	private ArrayList<Jugador> arrjug;
	
	private JLabel [] arrfich;
	
	private int ancho;
	
	private int alto;
	
	private Panelcirculos panel;

	public boolean isAnimacion3() {
		return animacion3;
	}

	public void setAnimacion3(boolean animacion3) {
		this.animacion3 = animacion3;
	}

	public boolean isAnimacion4() {
		return animacion4;
	}

	public void setAnimacion4(boolean animacion4) {
		this.animacion4 = animacion4;
	}

	public boolean isAnimacion2() {
		return animacion2;
	}

	public void setAnimacion2(boolean animacion2) {
		this.animacion2 = animacion2;
	}

	public boolean isSeguir() {
		return seguir;
	}

	public void setSeguir(boolean seguir) {
		this.seguir = seguir;
	}

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
			Connection conexion, int anchura, JLabel traineraUPV,ArrayList<Jugador> arrjug,JLabel [] arrfich,int ancho,int alto,Panelcirculos panel) {
		this.semaforo = semaforo;
		this.labelDado = labelDado;
		this.labelAcusar = labelAcusar;
		this.trainera = trainera;
		this.p = p;
		this.j = j;
		this.conexion = conexion;
		this.anchura = anchura;
		this.traineraUPV = traineraUPV;
		this.arrfich=arrfich;
		this.arrjug=arrjug;
		this.ancho=ancho;
		this.alto=alto;
		this.panel=panel;

		turno = -1;
	}

	public void run() {

		while (acabado) {

			// System.out.println(turno);
			//
			// System.out.println(base.ObtenerCodigoJugadorTurno(conexion, p));

			if (turno != base.ObtenerCodigoJugadorTurno(conexion, p)) {
				colocarFicha(arrjug,arrfich);
				panel.repaint();

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

			if (seguir) {
				if (animacion1) {

					if (ficha.getY() > 520) {
						ficha.setLocation(ficha.getX() - 2, ficha.getY() - 5);
						ficha.repaint();
					} else {

						System.out.println(ficha.getX());
						if (ficha.getX() < 1300) {
							trainera.setLocation(trainera.getX() + 10, trainera.getY());

							trainera.repaint();

							traineraUPV.setLocation(traineraUPV.getX() + 10, traineraUPV.getY());

							traineraUPV.repaint();

							ficha.setLocation(ficha.getX() + 10, ficha.getY());

							ficha.repaint();

						} else {
							if (ficha.getY() > 397 - 5) {
								ficha.setLocation(ficha.getX() + 3, ficha.getY() - 5);

								ficha.repaint();

							} else {

								if (ficha.getX() > 1391 - 25) {
									ficha.setLocation(ficha.getX() - 1, ficha.getY());
								} else {
									animacion1 = false;
									ficha.setLocation(1391 - 25, 397 - 5);
									ficha.repaint();
								}
							}
						}

					}
				} else if (animacion2) {

					if (ficha.getX() < 1383 && !(hecho)) {
						ficha.setLocation(ficha.getX() + 1, ficha.getY());
						ficha.repaint();

					} else {
						hecho = true;
						if (ficha.getY() < 520) {

							ficha.setLocation(ficha.getX() - 3, ficha.getY() + 5);
							ficha.repaint();
						} else {

							if (ficha.getX() > 145 && !(hecho1)) {
								trainera.setLocation(trainera.getX() - 10, trainera.getY());

								trainera.repaint();

								traineraUPV.setLocation(traineraUPV.getX() - 10, traineraUPV.getY());

								traineraUPV.repaint();

								ficha.setLocation(ficha.getX() - 10, ficha.getY());

								ficha.repaint();

							} else {

								hecho1 = true;

								if (ficha.getY() < 637 - 2) {
									ficha.setLocation(ficha.getX() + 2, ficha.getY() + 5);
									ficha.repaint();
								} else {
									animacion2 = false;
									ficha.setLocation(216 - 25, 637 - 2);
									ficha.repaint();
								}
							}

						}
					}

				} else if (animacion3) {

					if (ficha.getY() < 520) {
						ficha.setLocation(ficha.getX() + 4, ficha.getY() + 5);
						ficha.repaint();
					} else {

						
						if (ficha.getX() < 1300 && (!hecho)) {
							trainera.setLocation(trainera.getX() + 10, trainera.getY());

							trainera.repaint();

							traineraUPV.setLocation(traineraUPV.getX() + 10, traineraUPV.getY());

							traineraUPV.repaint();

							ficha.setLocation(ficha.getX() + 10, ficha.getY());

							ficha.repaint();

						} else {

							hecho = true;

							if (ficha.getY() < 673 - 5) {
								ficha.setLocation(ficha.getX() - 3, ficha.getY() + 5);

								ficha.repaint();

							} else {
								
								if (ficha.getX() < 1251 - 25) {
									
									ficha.setLocation(ficha.getX() + 1, ficha.getY());
								} else {
									animacion3 = false;
									ficha.setLocation(1251 - 25, 673 - 5);
									ficha.repaint();

								}
							}
						}

					}

				} else if (animacion4) {
					
					if (ficha.getX() > 1220 && !(hecho)) {
						ficha.setLocation(ficha.getX() -1 , ficha.getY());
						ficha.repaint();

					} else {
						hecho = true;
						if (ficha.getY() > 520) {

							ficha.setLocation(ficha.getX() + 3, ficha.getY() - 5);
							ficha.repaint();
						} else {

							if (ficha.getX() > 145 && !(hecho1)) {
								trainera.setLocation(trainera.getX() - 10, trainera.getY());

								trainera.repaint();

								traineraUPV.setLocation(traineraUPV.getX() - 10, traineraUPV.getY());

								traineraUPV.repaint();

								ficha.setLocation(ficha.getX() - 10, ficha.getY());

								ficha.repaint();

							} else {

								hecho1 = true;

								if (ficha.getY() > 414 - 5) {
									ficha.setLocation(ficha.getX() - 2, ficha.getY() - 5);
									ficha.repaint();
								} else {
									
									if (ficha.getX()>86-25){
										ficha.setLocation(ficha.getX() - 1, ficha.getY());
										ficha.repaint();
									}else{
									animacion4 = false;
									ficha.setLocation(86 - 25, 414 - 5);
									ficha.repaint();
								}
							}}

						}
					}

				} else {

					hecho = false;

					hecho1 = false;

					if (orientacion) {
						trainera.setBounds(trainera.getX() - 1, trainera.getY(), 250, 100);

						trainera.repaint();

						traineraUPV.setBounds(traineraUPV.getX() - 1, trainera.getY(), 250, 100);

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
						trainera.setBounds(trainera.getX() + 1, trainera.getY(), 250, 100);

						trainera.repaint();

						traineraUPV.setBounds(traineraUPV.getX() + 1, trainera.getY(), 250, 100);

						traineraUPV.repaint();

						if (trainera.getX() >= anchura) {
							trainera.setLocation(-250, trainera.getY());
							trainera.repaint();
						}

						if (traineraUPV.getX() >= anchura) {
							traineraUPV.setLocation(-250, traineraUPV.getY());
							traineraUPV.repaint();
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
	public int reajustarAlturaFicha(int coordenada, int altura) {

		double escala = (double)altura / (double)1020;

		return (int) (coordenada * escala);

	}
	public int reajustarAnchuraFicha(int coordenada, int anchura) {

		double escala = (double)anchura / (double)1920;

		return (int) (coordenada * escala);

	}
	public void colocarFicha(ArrayList<Jugador> arrjug,JLabel [] arrfich){
		Point [] arr=new Point[arrjug.size()];
		
		for(int i=0;i<arrjug.size();i++){
			arr[i]=base.ObtenerCoordenada(conexion, arrjug.get(i));
		}
		for(int j=0;j<arrjug.size();j++){
			Point punto=new Point(reajustarAnchuraFicha((int)arr[j].getX(),ancho)-28,reajustarAlturaFicha((int)arr[j].getY(),alto)-16);
			arrfich[j].setLocation(punto);
		}
	}
}

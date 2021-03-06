package Proyecto.Cluedo.Hilo;

import java.awt.Image;
import java.awt.Point;
import java.sql.Connection;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Ventanas.LabelLugares;
import Proyecto.Cluedo.Ventanas.Panelcirculos;
import Proyecto.Cluedo.Ventanas.VentanaTablero;

public class hiloP�ntado extends Thread {

	private int contador = 0;

	private Clip clip;

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
	
	private HiloTurno hTurno;

	private boolean seguir = true;

	private boolean hecho = false;

	private boolean hecho1 = false;

	private boolean inicio;

	private JLabel ficha;

	private boolean comprobador;

	private ArrayList<Jugador> arrjug;

	private JLabel[] arrfich;

	private Panelcirculos panel;

	private static final int ANCHURA = 1920;

	private static final int ALTURA = 1040;

	private static final int ALTURAM = 1020;

	private int altura;

	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}

	public boolean isInicio() {
		return inicio;
	}

	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}

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

	public hiloP�ntado(JLabel semaforo, JLabel labelDado, JLabel labelAcusar, JLabel trainera, Partida p, Jugador j,

			Connection conexion, int anchura, JLabel traineraUPV, ArrayList<Jugador> arrjug, JLabel[] arrfich,
			int altura, Panelcirculos panel, boolean comprobador,HiloTurno hTurno) {

		this.semaforo = semaforo;
		this.labelDado = labelDado;
		this.labelAcusar = labelAcusar;
		this.trainera = trainera;
		this.p = p;
		this.j = j;
		this.conexion = conexion;
		this.anchura = anchura;
		this.traineraUPV = traineraUPV;
		this.arrfich = arrfich;
		this.arrjug = arrjug;
		this.panel = panel;

		this.altura = altura;
		
		this.hTurno=hTurno;

		this.comprobador = comprobador;

		turno = -1;
	}

	public void run() {
		if (comprobador) {
			System.out.println("entro");
			// meterFicha(arrjug, anchura, altura);
			System.out.println("tama�o" + arrjug.size());
			colocarFichaInicio(arrjug, anchura, altura);
			panel.repaint();
		}

		if (base.obtenerAccion(conexion, p)) {

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

			while (base.obtenerAccion(conexion, p)) {

			}

			int posicion = base.posicionBarco(conexion, p);

			trainera.setBounds(reajustarAnchura(posicion, anchura), reajustarAltura(510, altura),
					reajustarTama�oAnch(250, anchura), reajustarTama�oAlt(95, altura));

			traineraUPV.setBounds((reajustarAnchura(posicion, anchura) + 2 * traineraUPV.getWidth()),
					reajustarAltura(510, altura), reajustarTama�oAnch(250, anchura), reajustarTama�oAlt(100, altura));
		}

		while (acabado) {

			int entrada = base.obtenerTurno(conexion, j);

			if (entrada == 0 && base.obtenerAccion(conexion, p)) {

				boolean giro = base.obtenerOrientacion(conexion, p);

				if (orientacion == giro) {

					if (orientacion) {

						while (trainera.getX() > reajustarAnchura(145, anchura)) {
							trainera.setLocation(trainera.getX() - 5, trainera.getY());

							trainera.repaint();

							traineraUPV.setLocation(traineraUPV.getX() - 5, traineraUPV.getY());

							traineraUPV.repaint();

							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						int posicion = base.posicionBarco(conexion, p);

						trainera.setLocation(reajustarAnchura(posicion, anchura), trainera.getY());

						traineraUPV.setLocation((trainera.getX() + (2 * traineraUPV.getWidth())), traineraUPV.getY());

						seguir = true;

					} else {
						while ((trainera.getX() < reajustarAnchura(1300, anchura))) {
							trainera.setLocation(trainera.getX() + 5, trainera.getY());

							trainera.repaint();

							traineraUPV.setLocation(traineraUPV.getX() + 5, traineraUPV.getY());

							traineraUPV.repaint();

							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						int posicion = base.posicionBarco(conexion, p);

						trainera.setLocation(reajustarAnchura(posicion, anchura), trainera.getY());

						traineraUPV.setLocation((trainera.getX() + (2 * traineraUPV.getWidth())), traineraUPV.getY());

						seguir = true;
					}

				} else {

					if (orientacion) {

						ImageIcon imagen = new ImageIcon();
						Icon icono;

						try {

							imagen = new ImageIcon(
									VentanaTablero.class.getResource("Imagenes/traineradeustoInvertida.png"));
						} catch (Exception p) {
						}
						icono = new ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
								trainera.getHeight(), Image.SCALE_DEFAULT));

						trainera.setIcon(icono);

						trainera.setLocation(reajustarAnchura(29, anchura), trainera.getY());
						try {

							imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/traineraUPV.png"));
						} catch (Exception p) {
						}
						icono = new ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
								traineraUPV.getHeight(), Image.SCALE_DEFAULT));

						traineraUPV.setLocation((trainera.getX() + (2 * traineraUPV.getWidth())), trainera.getY());

						traineraUPV.setIcon(icono);

						seguir = false;

					} else {

						ImageIcon imagen = new ImageIcon();
						Icon icono;

						try {

							imagen = new ImageIcon(VentanaTablero.class.getResource("Imagenes/traineradeusto.png"));
						} catch (Exception p) {
						}
						icono = new ImageIcon(imagen.getImage().getScaledInstance(trainera.getWidth(),
								trainera.getHeight(), Image.SCALE_DEFAULT));

						trainera.setIcon(icono);

						trainera.setLocation(reajustarAnchura(1250, anchura), trainera.getY());
						try {

							imagen = new ImageIcon(
									VentanaTablero.class.getResource("Imagenes/traineraUPVInvertida.png"));
						} catch (Exception p) {
						}
						icono = new ImageIcon(imagen.getImage().getScaledInstance(traineraUPV.getWidth(),
								traineraUPV.getHeight(), Image.SCALE_DEFAULT));

						traineraUPV.setLocation((trainera.getX() + (2 * traineraUPV.getWidth())), trainera.getY());

						traineraUPV.setIcon(icono);

						seguir = false;

					}
					orientacion = !(orientacion);

				}

			}

			// System.out.println(turno);
			//
			// System.out.println(base.ObtenerCodigoJugadorTurno(conexion, p));

			if (turno != base.ObtenerCodigoJugadorTurno(conexion, p)) {
				
				if(animacion1||animacion2||animacion3||animacion4){
				
				}else{
					colocarFicha(arrjug, arrfich);
				panel.repaint();
				}
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

					if (ficha.getY() > reajustarAltura(520, altura)) {
						ficha.setLocation(ficha.getX() - 2, ficha.getY() - 5);
						ficha.repaint();
					} else {

						System.out.println(ficha.getX());
						if (ficha.getX() < reajustarAnchura(1300, anchura)) {
							trainera.setLocation(trainera.getX() + 10, trainera.getY());

							trainera.repaint();

							traineraUPV.setLocation(traineraUPV.getX() + 10, traineraUPV.getY());

							traineraUPV.repaint();

							ficha.setLocation(ficha.getX() + 10, ficha.getY());

							ficha.repaint();

						} else {
							if (ficha.getY() > reajustarAlturaFicha(397 - 32, panel.getHeight())) {
								ficha.setLocation(ficha.getX() + 3, ficha.getY() - 5);

								ficha.repaint();

							} else {

								if (ficha.getX() > reajustarAnchura(1391 - 25, anchura)) {
									ficha.setLocation(ficha.getX() - 1, ficha.getY());
								} else {
									animacion1 = false;
									clip.stop();
									ficha.setLocation(reajustarAnchura(1391 - 28, anchura),
											reajustarAlturaFicha(397 - 32, panel.getHeight()));
									ficha.repaint();
									base.modificarCoordenada(conexion, j, 1391, 397);
									base.modificarBarco(conexion, p, desajustarX(trainera.getX(), anchura));
									base.modificarAccion(conexion, p, false);
									hTurno.CambiarTurno();
								}
							}
						}

					}
				} else if (animacion2) {

					if (ficha.getX() < reajustarAnchura(1383, anchura) && !(hecho)) {
						ficha.setLocation(ficha.getX() + 1, ficha.getY());
						ficha.repaint();

					} else {
						hecho = true;
						if (ficha.getY() < reajustarAltura(520, altura)) {

							ficha.setLocation(ficha.getX() - 3, ficha.getY() + 5);
							ficha.repaint();
						} else {

							if (ficha.getX() > reajustarAnchura(145, anchura) && !(hecho1)) {
								trainera.setLocation(trainera.getX() - 10, trainera.getY());

								trainera.repaint();

								traineraUPV.setLocation(traineraUPV.getX() - 10, traineraUPV.getY());

								traineraUPV.repaint();

								ficha.setLocation(ficha.getX() - 10, ficha.getY());

								ficha.repaint();

							} else {

								hecho1 = true;

								if (ficha.getY() < reajustarAlturaFicha(637 - 32, panel.getHeight())) {
									ficha.setLocation(ficha.getX() + 2, ficha.getY() + 5);
									ficha.repaint();
								} else {
									animacion2 = false;
									clip.stop();
									ficha.setLocation(reajustarAnchura(216 - 28, anchura),
											reajustarAlturaFicha(637 - 32, panel.getHeight()));
									ficha.repaint();
									
									base.modificarCoordenada(conexion, j, 216, 637);
									base.modificarBarco(conexion, p, desajustarX(trainera.getX(), anchura));
									base.modificarAccion(conexion, p, false);
									hTurno.CambiarTurno();
								}
							}

						}
					}

				} else if (animacion3) {

					if (ficha.getY() < reajustarAltura(520, altura)) {
						ficha.setLocation(ficha.getX() + 4, ficha.getY() + 5);
						ficha.repaint();
					} else {

						if (ficha.getX() < reajustarAnchura(1300, anchura) && (!hecho)) {
							trainera.setLocation(trainera.getX() + 10, trainera.getY());

							trainera.repaint();

							traineraUPV.setLocation(traineraUPV.getX() + 10, traineraUPV.getY());

							traineraUPV.repaint();

							ficha.setLocation(ficha.getX() + 10, ficha.getY());

							ficha.repaint();

						} else {

							hecho = true;

							if (ficha.getY() < reajustarAlturaFicha(673 - 32, panel.getHeight())) {
								ficha.setLocation(ficha.getX() - 3, ficha.getY() + 5);

								ficha.repaint();

							} else {

								if (ficha.getX() < reajustarAnchura(1251 - 25, anchura)) {

									ficha.setLocation(ficha.getX() + 1, ficha.getY());
								} else {
									animacion3 = false;
									clip.stop();
									ficha.setLocation(reajustarAnchura(1251 - 28, anchura),
											reajustarAlturaFicha(673 - 32, panel.getHeight()));
									ficha.repaint();
									base.modificarCoordenada(conexion, j, 1251, 673);
									base.modificarAccion(conexion, p, false);
									base.modificarBarco(conexion, p, desajustarX(trainera.getX(), anchura));
									hTurno.CambiarTurno();

								}
							}
						}

					}

				} else if (animacion4) {

					if (ficha.getX() > reajustarAnchura(1220, anchura) && !(hecho)) {
						ficha.setLocation(ficha.getX() - 1, ficha.getY());
						ficha.repaint();

					} else {
						hecho = true;
						if (ficha.getY() > reajustarAltura(520, altura)) {

							ficha.setLocation(ficha.getX() + 3, ficha.getY() - 5);
							ficha.repaint();
						} else {

							if (ficha.getX() > reajustarAnchura(145, anchura) && !(hecho1)) {
								trainera.setLocation(trainera.getX() - 10, trainera.getY());

								trainera.repaint();

								traineraUPV.setLocation(traineraUPV.getX() - 10, traineraUPV.getY());

								traineraUPV.repaint();

								ficha.setLocation(ficha.getX() - 10, ficha.getY());

								ficha.repaint();

							} else {

								hecho1 = true;

								if (ficha.getY() > reajustarAlturaFicha(414 - 32, panel.getHeight())) {
									ficha.setLocation(ficha.getX() - 2, ficha.getY() - 5);
									ficha.repaint();
								} else {

									if (ficha.getX() > reajustarAnchura(86 - 28, anchura)) {
										ficha.setLocation(ficha.getX() - 1, ficha.getY());
										ficha.repaint();
									} else {
										animacion4 = false;
										clip.stop();
										ficha.setLocation(reajustarAnchura(86 - 28, anchura),
												reajustarAlturaFicha(414 - 32, panel.getHeight()));
										ficha.repaint();
										base.modificarCoordenada(conexion, j, 86, 414);
										base.modificarAccion(conexion, p, false);
										base.modificarBarco(conexion, p, desajustarX(trainera.getX(), anchura));
										
										hTurno.CambiarTurno();
										
									}
								}
							}

						}
					}
					

					
				} else {

					hecho = false;

					hecho1 = false;

					if (orientacion) {

						// if (anchura<ANCHURA){
						// trainera.setLocation(trainera.getX() - 1,
						// trainera.getY());
						//
						// trainera.repaint();
						//
						// traineraUPV.setLocation(traineraUPV.getX() - 1,
						// trainera.getY());
						//
						// traineraUPV.repaint();
						// }else{

						int posi = base.posicionBarco(conexion, p);

						trainera.setLocation((reajustarAnchura(posi, anchura) - 1), trainera.getY());

						trainera.repaint();
						if (reajustarAnchura(posi, anchura) < (anchura - (2 * reajustarAnchura(250, anchura)))
								|| inicio) {

							if (reajustarAnchura(posi, anchura) < (anchura - (2 * reajustarAnchura(250, anchura)))) {
								inicio = false;
							}

							traineraUPV.setLocation(
									((reajustarAnchura(posi, anchura) + (2 * traineraUPV.getWidth())) - 1),
									trainera.getY());

							traineraUPV.repaint();
						} else {
							traineraUPV.setLocation(
									reajustarAnchura(250, anchura) - (anchura - reajustarAnchura(posi, anchura)),
									trainera.getY());

							traineraUPV.repaint();
						}

						// }

						if (trainera.getX() <= reajustarAnchura(-250, anchura)) {
							trainera.setLocation(anchura, trainera.getY());
							trainera.repaint();
						}

						if (traineraUPV.getX() <= reajustarAnchura(-250, anchura)) {
							traineraUPV.setLocation(anchura, traineraUPV.getY());
							traineraUPV.repaint();
						}

					} else {

						// if (anchura<ANCHURA){
						// trainera.setLocation(trainera.getX() + 1,
						// trainera.getY());
						//
						// trainera.repaint();
						//
						// traineraUPV.setLocation(traineraUPV.getX() + 1,
						// trainera.getY());
						//
						// traineraUPV.repaint();
						//
						// }else{

						int posi2 = base.posicionBarco(conexion, p);

						trainera.setLocation((reajustarAnchura(posi2, anchura) + 1), trainera.getY());

						trainera.repaint();

						if (reajustarAnchura(posi2, anchura) < anchura - 2 * reajustarAnchura(250, anchura)) {

							traineraUPV.setLocation(
									((reajustarAnchura(posi2, anchura) + (2 * traineraUPV.getWidth())) + 1),
									trainera.getY());

							traineraUPV.repaint();
						} else {
							traineraUPV.setLocation(
									reajustarAnchura(250, anchura) - (anchura - reajustarAnchura(posi2, anchura)),
									trainera.getY());

							traineraUPV.repaint();
						}

						// }
						if (trainera.getX() >= anchura) {
							trainera.setLocation(reajustarAnchura(-250, anchura), trainera.getY());
							trainera.repaint();
						}

						if (traineraUPV.getX() >= anchura) {
							traineraUPV.setLocation(reajustarAnchura(-250, anchura), traineraUPV.getY());
							traineraUPV.repaint();
						}

					}

					base.modificarBarco(conexion, p, desajustarX(trainera.getX(), anchura));

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

	public void colocarFichaInicio(ArrayList<Jugador> arrjug, int anchura, int altura) {
		Point[] arr = new Point[5];
		arr[0] = new Point(66, 735);
		arr[1] = new Point(66, 785);
		arr[2] = new Point(66, 835);
		arr[3] = new Point(116, 735);
		arr[4] = new Point(116, 785);
		for (int i = 0; i < arrjug.size(); i++) {
			arrfich[i].setLocation(arr[i]);
			System.out.println(i);
			base.modificarCoordenada(conexion, arrjug.get(i), (int) (arr[i].getX()), (int) (arr[i].getY()));
		}
	}
	


	public int reajustarAltura(int coordenada, int altura) {

		double escala = (double) altura / (double) ALTURA;

		return (int) (coordenada * escala);

	}

	public int reajustarAnchura(int coordenada, int anchura) {

		double escala = (double) anchura / (double) ANCHURA;

		return (int) (coordenada * escala);

	}

	public int reajustarAlturaMaider(int coordenada, int altura) {

		double escala = (double) altura / (double) ALTURAM;

		return (int) (coordenada * escala);

	}

	public int reajustarTama�oAlt(int tama�oY, int altura) {

		double escala = (double) altura / (double) ALTURA;

		return (int) (tama�oY * escala);

	}

	public int reajustarTama�oAnch(int tama�oX, int anchura) {

		double escala = (double) anchura / (double) ANCHURA;

		return (int) (tama�oX * escala);

	}

	public int desajustarX(int coordenada, int anchura) {

		double escala = (double) ANCHURA / (double) anchura;

		return (int) (coordenada * escala);
	}

	public void acabar() {

		acabado = false;

	}

	public int reajustarAlturaFicha(int coordenada, int altura) {

		double escala = altura / (double) 953;

		return (int) (coordenada * escala);

	}

	public int reajustarAnchuraFicha(int coordenada, int anchura) {

		double escala = anchura / (double) 1920;

		return (int) (coordenada * escala);

	}

	public int reajustarTama�oAltMaider(int tama�oY, int altura) {

		double escala = (double) altura / (double) ALTURAM;

		return (int) (tama�oY * escala);

	}

	public void colocarFicha(ArrayList<Jugador> arrjug, JLabel[] arrfich) {
		Point[] arr = new Point[arrjug.size()];

		for (int i = 0; i < arrjug.size(); i++) {
			arr[i] = base.ObtenerCoordenada(conexion, arrjug.get(i));
		}
		for (int j = 0; j < arrjug.size(); j++) {
			Point punto = new Point(reajustarAnchuraFicha((int) arr[j].getX() - 28, anchura),
					reajustarAlturaFicha((int) (arr[j].getY() - 32), panel.getHeight()));
			arrfich[j].setLocation(punto);
		}
	}
}
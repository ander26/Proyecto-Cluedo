package Proyecto.Cluedo.Logica;

import java.util.ArrayList;

import Proyecto.Cluedo.Datos.Cartas;
import Proyecto.Cluedo.Datos.TipoCarta;
import Proyecto.Cluedo.Ventanas.VentanaCartas;

public class Propiedades {
	
	
	private static int numTotArmas;
	private static int numTotLugares;
	private static int numTotSospechosos;
	private static int numTotCartas;
	private static int numJugadores;
	
	private static ArrayList<ArrayList<Cartas>> baraja;
	
	/**
	 * Atributo que contiene el numero de cartas por usuario 
	 */
	
	private int [] [] cartasUsuario;
	
	public Propiedades(int numTotArmas, int numTotLugares, int numTotSospechosos, int numJugadores) {
		
		this.numTotArmas = numTotArmas;
		this.numTotLugares = numTotLugares;
		this.numTotSospechosos = numTotSospechosos;
		this.numTotCartas=numTotArmas+numTotLugares+numTotSospechosos;
		this.numJugadores = numJugadores;
		ArrayList<Cartas> alsospechoso=new ArrayList();
		alsospechoso.add(new Cartas ("Inspector Gadget","Imagenes/casinspecGadget.png",false,2));
		alsospechoso.add(new Cartas ("Paris Hilton", "Imagenes/casparish.png",false,2));
		alsospechoso.add(new Cartas ("Usain  Bolt", "Imagenes/casbolt.png",false,2));
		alsospechoso.add(new Cartas ("Socrates","Imagenes/cassocrates.png",false,2));
		alsospechoso.add(new Cartas ("Minerva", "Imagenes/casMCGONAGALL.png",false,2));
		alsospechoso.add(new Cartas ("La Momia","Imagenes/casLAmomia.png" ,false,2));
		alsospechoso.add(new Cartas ("El Papa","Imagenes/caspapa.png" ,false,2));
		ArrayList<Cartas> alarma=new ArrayList();
		alarma.add(new Cartas ("Pistola","Imagenes/carpistola.png",false,0));
		alarma.add(new Cartas ("Biblia","Imagenes/carbiblia.png",false,0));
		alarma.add(new Cartas ("Bocata envenenado","Imagenes/carbocata.png",false,0));
		alarma.add(new Cartas ("Chip","Imagenes/carchip.png",false,0));
		alarma.add(new Cartas ("Botella","Imagenes/carbotella.png",false,0));
		alarma.add(new Cartas ("Sarten","Imagenes/carpistola.png",false,0));
		ArrayList<Cartas> allugares=new ArrayList();
		allugares.add(new Cartas ("F. Ingenieria","Imagenes/clINGENIERIA.png",false,1));
		allugares.add(new Cartas ("La Comercial","Imagenes/clCOMERCIAL.png",false,1));
		allugares.add(new Cartas ("la L","Imagenes/clL.png",false,1));
		allugares.add(new Cartas ("La Capilla","Imagenes/clCAPILLA.png",false,1));
		allugares.add(new Cartas ("Edificio centenario","Imagenes/clCENTENARIO.png",false,1));
		allugares.add(new Cartas ("Edificio de letras","Imagenes/clFLETRAS.png",false,1));
		allugares.add(new Cartas ("Biblioteca","Imagenes/clBIBLIOTECA.png",false,1));
		allugares.add(new Cartas ("Zubiarte","Imagenes/clZUBIARTE.png",false,1));		
		ArrayList<Cartas> alcomodines=new ArrayList();
		alcomodines.add(new Cartas ("Comodin1","Imagenes/clINGENIERIA.png",false,3));
		alcomodines.add(new Cartas ("Comodin2","Imagenes/clINGENIERIA.png",false,3));		
		this.baraja = new ArrayList();
		this.baraja.add(alarma);
		this.baraja.add(allugares);
		this.baraja.add(alsospechoso);
		this.baraja.add(alcomodines);
	
	}
	//Escoje las 3 csrtas del asesinato y reparte las demas entre los jugadores
	public  void repartirCartas(Jugador [] arJugadores){
		
		//Seleccion de las crtas que hacen el asesinato(las que en la vida real se meten en un sobre)
		int [] contcartas=new int[arJugadores.length];
		for(int i=0;i<3;i++){
			int num=(int) (Math.random()*10);
			while(num>=baraja.get(i).size()){
				num=(int) (Math.random()*10);
			}
			baraja.get(i).get(num).setCulpable(true);
			baraja.get(i).get(num).setSeleccionada(true);
			;
		}
		
	for(int j=0;j<3;j++){
		for(int g=0;g<arJugadores.length;g++){
			ArrayList<Integer> alcartaspalo= new ArrayList();
			for(int h=0;h<(int)((baraja.get(j).size()-1)/arJugadores.length);h++){	
				
				boolean buscarmas=true;
				int num;
				while(buscarmas){
					num=(int) (Math.random()*10);
					if(num<baraja.get(j).size() && baraja.get(j).get(num).isSeleccionada()==false){
						baraja.get(j).get(num).setSeleccionada(true);
						alcartaspalo.add(num);
						System.out.println(num+" "+h);
						contcartas[g]=contcartas[g]+1;
						buscarmas=false;
						
						
					}
					
				}
				
				
			}
			arJugadores[g].getMisCartas().add(alcartaspalo);
			
			
		}
		
		if((baraja.get(j).size()-1)%numJugadores!=0){
			System.out.println("entro");
			//int numcarpepartir=baraja.get(j).size()%numJugadores;
			for(Cartas it:baraja.get(j)){
				
				if(it.isSeleccionada()==false){
					for(int l=1;l<arJugadores.length;l++){
						if(l==0){
							if(contcartas[l]<contcartas[l-1]){
								int numindice=baraja.get(j).indexOf(it);
								arJugadores[l].setCarta(j,numindice);
								contcartas[l]=contcartas[l]+1;	
								baraja.get(j).get(numindice).setSeleccionada(true);
								l=arJugadores.length;
								
							}
						}
						if(l==arJugadores.length-1){
							if(contcartas[l]<contcartas[l-1]){
								int numindice=baraja.get(j).indexOf(it);
								arJugadores[l].setCarta(j,numindice);
								contcartas[l]=contcartas[l]+1;	
								baraja.get(j).get(numindice).setSeleccionada(true);
							}
							else{
								int numindice=baraja.get(j).indexOf(it);
								arJugadores[0].setCarta(j,numindice);
								contcartas[0]=contcartas[0]+1;
								baraja.get(j).get(numindice).setSeleccionada(true);
							}
							
						}
						else{
							if(contcartas[l]<contcartas[l-1]){
								int numindice=baraja.get(j).indexOf(it);
								arJugadores[l].setCarta(j,numindice);
								contcartas[l]=contcartas[l]+1;								
								l=arJugadores.length;
								baraja.get(j).get(numindice).setSeleccionada(true);
							}
						}
					
				}
				}
				}
		
		
			
		}
	}
	for(int h=0;h<contcartas.length;h++){
		ArrayList<Integer> alcartaspalo= new ArrayList();
		arJugadores[h].getMisCartas().add(alcartaspalo);
		int numero=0;
		if(((numTotCartas-3)%numJugadores)!=0){
			numero=1;
		}
		if(contcartas[h]<(int)((numTotCartas-3)/numJugadores)+numero){
			System.out.println((numTotCartas-3)/numJugadores);
			System.out.println(numTotCartas-3);
			System.out.println(numJugadores);
			//System.out.println(contcartas[h]);
			arJugadores[h].setCarta(3,0);				
			contcartas[h]=contcartas[h]+1;
			
			
			
		}
	}
	
	}

	public int getNumTotArmas() {
		return numTotArmas;
	}

	public void setNumTotArmas(int numTotArmas) {
		this.numTotArmas = numTotArmas;
	}

	public int getNumTotLugares() {
		return numTotLugares;
	}

	public void setNumTotLugares(int numTotLugares) {
		this.numTotLugares = numTotLugares;
	}

	public int getNumTotSospechosos() {
		return numTotSospechosos;
	}

	public void setNumTotSospechosos(int numTotSospechosos) {
		this.numTotSospechosos = numTotSospechosos;
	}

	public int getNumTotCartas() {
		return numTotCartas;
	}

	public void setNumTotCartas(int numTotCartas) {
		this.numTotCartas = numTotCartas;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	public ArrayList<ArrayList<Cartas>> getBaraja() {
		return baraja;
	}

	public void setBaraja(ArrayList<ArrayList<Cartas>> baraja) {
		this.baraja = baraja;
	}

	public static void main (String [] args){
		Jugador a=new Jugador();
		Jugador b=new Jugador();
//		Jugador c=new Jugador();
//		Jugador d=new Jugador();
//		Jugador e=new Jugador();
		Jugador [] arrjug=new Jugador [2];
		arrjug[0]=a;
		arrjug[1]=b;
//		arrjug[2]=c;
//		arrjug[3]=d;
//		arrjug[4]=e;
		Propiedades prop =new Propiedades(7,8,7,2);
		prop.repartirCartas(arrjug);
		for(int i=0;i<arrjug.length;i++){
			
			for(int j=0;j<4;j++){
				for(int h=0;h<arrjug[i].getMisCartas().get(j).size();h++){
					System.out.println(arrjug[i].getMisCartas().get(j).get(h)+" "+j+" "+i);
				}
			}
		}
		
	}
	
	
	
	}

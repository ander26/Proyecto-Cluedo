import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;


import Proyecto.Cluedo.Datos.Cartas;
import Proyecto.Cluedo.Datos.TipoCarta;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Ventanas.VentanaLogin;
import Proyecto.Cluedo.Ventanas.VentanaLogo;

public class Main {
	

	
	public static void main (String [] args){
		
		GestionBaseDeDatos gestion = new GestionBaseDeDatos();
		Connection conexion = gestion.inicializarLaBase();
		
//		try{
//			Statement statement = conexion.createStatement();
//			statement.executeUpdate("DROP TABLE IF EXISTS CHAT");
//		}catch (Exception e){
//			
//		}
//		String creacion = "CREATE TABLE PARTIDA (NOMBRE text, CODIGO int NOT NULL PRIMARY KEY, NUMEROJUGADORESMAXIMO int , NUMEROJUGADORESACTUAL int,POSICIONBARCO real,MENSAJECARTEL text)";
//		
//		gestion.crearTabla(creacion, conexion);
//		String creacion = "CREATE TABLE JUGADOR(COD_JUG int NOT NULL PRIMARY KEY,COD_PARTIDA int NOT NULL REFERENCES PARTIDA (CODIGO) ON DELETE CASCADE,NOMBRE_USUARIO text NOT NULL REFERENCES USUARIO(NOMBREUSUARIO),POS_MUÑECO real,LUGAR INT,TURNO int,MUÑECO text,DIBUJO bytea,ENLINEA boolean)";
//		gestion.crearTabla(creacion,conexion);
		

//		
//		try{
//			Statement statament = conexion.createStatement();
//			
//			statament.executeUpdate("DELETE FROM CHAT");
//			
//			System.out.println("Se ha borrado todo");
//			
//			ArrayList <Integer> lista=gestion.obtenerCodigoPartidas(conexion);
//			
//			for (Integer i: lista){
//				System.out.println(i);
//			}
//		}catch (Exception e){
//			System.out.println("No se ha conseguido borrar");
//		}
//	
//		Statement statement;
//		try {
//			statement = conexion.createStatement();
//			statement.executeUpdate("DROP TABLE IF EXISTS CARTA");			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String creacion = "CREATE TABLE CARTA(NOMBRE text NOT NULL PRIMARY KEY,RUTAICONO text,CULPABLE int,TIPOCARTA int)";
//		gestion.crearTabla(creacion, conexion);


//		
//		try{
//			Statement statament = conexion.createStatement();
//			
//			statament.executeUpdate("DELETE FROM CHAT");
//			
//			System.out.println("Se ha borrado todo");
//			
//			ArrayList <Integer> lista=gestion.obtenerCodigoPartidas(conexion);
//			
//			for (Integer i: lista){
//				System.out.println(i);
//			}
//		}catch (Exception e){
//			System.out.println("No se ha conseguido borrar");
//		}
//	
		
//		String creacion = "CREATE TABLE CHAT(MENSAJE text,FECHAENVIO bigint NOT NULL,CODIGOPARTIDA int NOT NULL REFERENCES PARTIDA (CODIGO) ON DELETE CASCADE, CODIGOJUGADOR int NOT NULL REFERENCES JUGADOR (COD_JUG),NOMBREUSUARIO text,PRIMARY KEY (FECHAENVIO,CODIGOPARTIDA,CODIGOJUGADOR))";
//		gestion.crearTabla(creacion,conexion);
		
//		
//		Cartas a=new Cartas ("Inspector Gadget","Imagenes/casinspecGadget.png",false,TipoCarta.SOSPECHOSO);
//		Cartas b=new Cartas ("Paris Hilton", "Imagenes/casparish.png",false,TipoCarta.SOSPECHOSO);
//		Cartas c=new Cartas ("Usain  Bolt", "Imagenes/casbolt.png",false,TipoCarta.SOSPECHOSO);
//		Cartas d=new Cartas ("Socrates","Imagenes/cassocrates.png",false,TipoCarta.SOSPECHOSO);
//		Cartas e=new Cartas ("Minerva", "Imagenes/casMCGONAGALL.png",false,TipoCarta.SOSPECHOSO);
//		Cartas f=new Cartas ("La Momia","Imagenes/casLAmomia.png" ,false,TipoCarta.SOSPECHOSO);
//		Cartas g=new Cartas ("El Papa","Imagenes/caspapa.png" ,false,TipoCarta.SOSPECHOSO);
//		
//		Cartas h=new Cartas ("Pistola","Imagenes/carpistola.png",false,TipoCarta.ARMA);
//		Cartas i=new Cartas ("Biblia","Imagenes/carbiblia.png",false,TipoCarta.ARMA);
//		Cartas j=new Cartas ("Bocata envenenado","Imagenes/carbocata.png",false,TipoCarta.ARMA);
//		Cartas k=new Cartas ("Chip","Imagenes/carchip.png",false,TipoCarta.ARMA);
//		Cartas l=new Cartas ("Botella","Imagenes/carbotella.png",false,TipoCarta.ARMA);
//		Cartas m=new Cartas ("Sarten","Imagenes/sarten.jpg",false,TipoCarta.ARMA);
//	
//		Cartas n=new Cartas ("F. Ingenieria","Imagenes/clINGENIERIA.png",false,TipoCarta.LUGAR);
//		Cartas ñ=new Cartas ("La Comercial","Imagenes/clCOMERCIAL.png",false,TipoCarta.LUGAR);
//		Cartas o=new Cartas ("la L","Imagenes/clL.png",false,TipoCarta.LUGAR);
//		Cartas p=new Cartas ("La Capilla","Imagenes/clCAPILLA.png",false,TipoCarta.LUGAR);
//		Cartas q=new Cartas ("Edificio centenario","Imagenes/clCENTENARIO.png",false,TipoCarta.LUGAR);
//		Cartas r=new Cartas ("Edificio de letras","Imagenes/clFLETRAS.png",false,TipoCarta.LUGAR);
//		Cartas s=new Cartas ("Biblioteca","Imagenes/clBIBLIOTECA.png",false,TipoCarta.LUGAR);
//		Cartas t=new Cartas ("Zubiarte","Imagenes/clZUBIARTE.png",false,TipoCarta.LUGAR);		
//		
//		Cartas u=new Cartas ("Comodin1","Imagenes/comodin.png",false,TipoCarta.COMODIN);
//		Cartas v=new Cartas ("Comodin2","Imagenes/comodin.png",false,TipoCarta.COMODIN);	
//		Cartas [] array={a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v};
		
//		meterCartas(conexion,array,gestion);
//		
//		String crea = "CREATE TABLE SOSPECHOSO(CODPARTIDA int NOT NULL PRIMARY KEY REFERENCES PARTIDA (CODIGO) ON DELETE CASCADE,ASESINO text,LUGAR text ,ARMA text)";
//		gestion.crearTabla(crea, conexion);
		
//		String creajuega = "CREATE TABLE JUEGA(NOMBRECARTA text NOT NULL REFERENCES CARTA (NOMBRE) ,TIPOCARTA int,CODJUGADOR int NOT NULL REFERENCES JUGADOR (COD_JUG) ON DELETE CASCADE,CODPARTIDA int NOT NULL REFERENCES PARTIDA(CODIGO) ON DELETE CASCADE,PRIMARY KEY(NOMBRECARTA,CODJUGADOR,CODPARTIDA) )";
//		gestion.crearTabla(creajuega, conexion);
//		String crearecibircartas = "CREATE TABLE RECIBIRCARTAS(NOMBRECARTA text  ,CODJUGADORORIGEN int NOT NULL REFERENCES JUGADOR (COD_JUG) ON DELETE CASCADE,CODJUGADORDESTINO int NOT NULL REFERENCES JUGADOR (COD_JUG) ON DELETE CASCADE,CODPARTIDA int NOT NULL REFERENCES PARTIDA(CODIGO) ON DELETE CASCADE,TIEMPO bigint NOT NULL,PRIMARY KEY(CODJUGADORORIGEN,CODJUGADORDESTINO,CODPARTIDA,TIEMPO) )";
//		String crearsospecha = "CREATE TABLE SOSPECHA(NOMBRECARTALUGAR text NOT NULL REFERENCES CARTA (NOMBRE) ,NOMBRECARTAARMA text NOT NULL REFERENCES CARTA (NOMBRE),NOMBRECARTAASESINO text NOT NULL REFERENCES CARTA (NOMBRE),CODJUGADOR int NOT NULL REFERENCES JUGADOR (COD_JUG) ON DELETE CASCADE,CODPARTIDA int NOT NULL REFERENCES PARTIDA(CODIGO) ON DELETE CASCADE,TIEMPO bigint NOT NULL,PRIMARY KEY(NOMBRECARTALUGAR,NOMBRECARTAARMA,NOMBRECARTAASESINO,CODJUGADOR,CODPARTIDA,TIEMPO) )";

//		String creacion = "CREATE TABLE NOTAS(MENSAJE text,COD_JUG int NOT NULL REFERENCES JUGADOR(COD_JUG) ON DELETE CASCADE,LINEA int, TABLA int ,PRIMARY KEY (TABLA,LINEA,COD_JUG))";
//		gestion.crearTabla(creacion,conexion);
		
//		String creacion = "CREATE TABLE TICKS(TABLA int,LINEA int,COD_JUG int NOT NULL REFERENCES JUGADOR(COD_JUG) ON DELETE CASCADE,PRIMARY KEY (LINEA,TABLA,COD_JUG))";
//		gestion.crearTabla(creacion,conexion);


//		gestion.crearTabla(crearecibircartas, conexion);
//		gestion.crearTabla(crearsospecha, conexion);
		
		
		VentanaLogo ventana = new VentanaLogo();
		ventana.setVisible(true);
		
		
		VentanaLogin ventanaPrincipal = new VentanaLogin(conexion,gestion);
		
		while (ventanaPrincipal.isValid()){		
			
			
		}
		
		ventana.dispose();
		
		ventanaPrincipal.setVisible(true);
	}
	
	
	
	
	
	public static void meterCartas(Connection con,Cartas [] arr,GestionBaseDeDatos base ){
		for(int i=0;i<arr.length;i++){
			base.insertarCarta(con,arr[i]);
		}
		
	}
	
}
package Proyecto.Cluedo.Logica;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.sql.*;

public class FicheroCoordenadasPosiciones {


	
	// Ver test JUnit para ejemplo de funcionamiento:
	// TestEjemploFicheros (en este mismo paquete)


		
		public static ArrayList<Point> leerDeFicheroConBarras( String nomFic ) {
			ArrayList<Point> ret = new ArrayList<Point>();
			BufferedReader brFich = null;
			try {
				brFich = new BufferedReader( new
						InputStreamReader( new FileInputStream(nomFic) ) );
				String linea = brFich.readLine();
				while (linea != null) {
					// Proceso de línea
					StringTokenizer st = new StringTokenizer( linea, "/" );
					Point coor=new Point();
					int x=(int)Double.parseDouble(st.nextToken());
					int y=(int)Double.parseDouble(st.nextToken());
					coor.setLocation(x,y);
					ret.add( coor );
					linea = brFich.readLine();
				}
			} catch (Exception e) {  // FileNotFound, IO
				e.printStackTrace();
			} finally {
				if (brFich!=null)
					try {
						brFich.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			return ret;
		}
		
		
		public static void escribirAFicheroConBarras( String nomFic, ArrayList<Point> l ) {
			PrintStream fich = null;
			try {
				fich = new PrintStream(new FileOutputStream(nomFic));
				for (Point p : l) {
					String linea=p.getX()+"/"+p.getY();
					fich.println( linea  );
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fich!=null) fich.close();
			}
		}

}
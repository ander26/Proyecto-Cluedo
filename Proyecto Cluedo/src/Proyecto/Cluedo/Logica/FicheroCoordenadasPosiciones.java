package Proyecto.Cluedo.Logica;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.sql.*;

public class FicheroCoordenadasPosiciones {


	// Ver test JUnit para ejemplo de funcionamiento:
	// TestEjemploFicheros (en este mismo paquete)


		
		/** Lee los usuarios de un fichero de datos separado por comas y los devuelve
		 * @param nomFic	Nombre de fichero
		 * @return	Lista de usuarios del fichero, sólo formada por los usuarios leídos correctamente
		 */
		public static ArrayList<Point> leerDeFicheroConComas( String nomFic ) {
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
					Object x=st.nextElement();
					Object y=st.nextElement();
					coor.setLocation((int)x,(int) y);
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
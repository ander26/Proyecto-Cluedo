package Proyecto.Cluedo.Logica;

import java.awt.Point;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;

public class pruebas {
	public static Point pasarDeDecimalAxy(double x){
		int num=(int)x;
		int k=0;
		double numero=x;		
		double decimal=numero-num;
		System.out.println(decimal-(int)decimal);
		
		while((decimal-(int)decimal)>0.000001){
			k=k+1;
			decimal=decimal*10;
			System.out.println(decimal-(int)decimal);
			
		}
		int y=(int)decimal;
		System.out.println("punto"+num+" "+y);
		Point p=new Point(num,y);
		return p;
	}
	public static double pasarxyAdecimal(int y,int x){
		int res=y;
		int k=0;
		while (((int)res)>0){
			k=k+1;
			res=res/10;
			
		}
		System.out.println("decimal"+x+(y/10^(k-1)));
		return (x+(y/(Math.pow(10,k))));
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pasarxyAdecimal(123,89));
	}

}

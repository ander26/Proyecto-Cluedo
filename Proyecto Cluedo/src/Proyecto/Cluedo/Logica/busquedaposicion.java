package Proyecto.Cluedo.Logica;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class busquedaposicion {
	
	private FicheroCoordenadasPosiciones fichero=new FicheroCoordenadasPosiciones();
	private ArrayList<ArrayList<Point>> array=fichero.leerDeFicheroConBarrasYa("corordenadascambiocolor");
	private static HashMap<Point,ArrayList<Point>> hm=new HashMap();
	private ArrayList<Point> arrPunto=new ArrayList<Point>();
	public busquedaposicion(){
		for(int i=0;i<array.size();i++){
			for(int j=1;j<(array.get(i).size()-1);j++){
				ArrayList<Point> arr=new ArrayList<Point>();
				arr.add(array.get(i).get(j-1));
				arr.add(array.get(i).get(j+1));				
				hm.put(array.get(i).get(j),arr);
			}
		}
		ArrayList<Point> arr2= new ArrayList<Point>();
		arr2.add(new Point(211,682));
		arr2.add(new Point(86,414));
		hm.put(new Point(216,637), arr2);
		ArrayList<Point> arr11= new ArrayList<Point>();
		arr11.add(new Point(191,884));
		hm.put(new Point(129,876), arr11);
		ArrayList<Point> arr31= new ArrayList<Point>();
		arr31.add(new Point(1268,897));
		arr31.add(new Point(1133,881));
		arr31.add(new Point(1187,831));
		hm.put(new Point(1201,866), arr31);
		ArrayList<Point> arr9= new ArrayList<Point>();
		arr9.add(new Point(191,884));
		arr9.add(new Point(241,851));
		arr9.add(new Point(301,874));
		hm.put(new Point(251,879), arr9);
		ArrayList<Point> arr88= new ArrayList<Point>();
		arr88.add(new Point(1317,804));
		hm.put(new Point(1321,771), arr88);
		ArrayList<Point> arr36= new ArrayList<Point>();
		arr36.add(new Point(1232,708));
		arr36.add(new Point(1391,397));
		hm.put(new Point(1251,673), arr36);
		ArrayList<Point> arr45= new ArrayList<Point>();
		arr45.add(new Point(1891,295));
		arr45.add(new Point(1651,325));
		hm.put(new Point(1881,334), arr45);
		ArrayList<Point> arr40= new ArrayList<Point>();
		arr40.add(new Point(1662,291));
		arr40.add(new Point(1881,334));
		arr40.add(new Point(1611,376));
		hm.put(new Point(1651,325), arr40);
		ArrayList<Point> arr49= new ArrayList<Point>();
		arr49.add(new Point(1887,207));
		hm.put(new Point(1846,174), arr49);
		ArrayList<Point> arr44= new ArrayList<Point>();
		arr44.add(new Point(1669,218));
		arr44.add(new Point(1097,289));
		hm.put(new Point(1621,185), arr44);
		ArrayList<Point> arr50= new ArrayList<Point>();
		arr50.add(new Point(1029,279));
		arr50.add(new Point(1621,185));
		hm.put(new Point(1097,289), arr50);
		ArrayList<Point> arr53= new ArrayList<Point>();
		arr53.add(new Point(978,278));
		arr53.add(new Point(882,297));
		arr53.add(new Point(855,261));
		hm.put(new Point(912,267), arr53);
		ArrayList<Point> arr57= new ArrayList<Point>();
		arr57.add(new Point(835,304));
		arr57.add(new Point(727,295));
		arr57.add(new Point(748,335));
		hm.put(new Point(781,309), arr57);
		ArrayList<Point> arr65= new ArrayList<Point>();
		arr65.add(new Point(685,125));
		arr65.add(new Point(295,104));
		hm.put(new Point(629,113), arr65);
		ArrayList<Point> arr69= new ArrayList<Point>();
		arr69.add(new Point(581,269));
		arr69.add(new Point(613,345));
		arr69.add(new Point(537,343));
		hm.put(new Point(581,305), arr69);
		ArrayList<Point> arr72= new ArrayList<Point>();
		arr72.add(new Point(537,236));
		hm.put(new Point(504,196), arr72);
		ArrayList<Point> arr77= new ArrayList<Point>();
		arr77.add(new Point(373,402));
		arr77.add(new Point(291,366));
		arr77.add(new Point(274,407));
		hm.put(new Point(321,391), arr77);
		ArrayList<Point> arr82= new ArrayList<Point>();
		arr82.add(new Point(231,288));
		arr82.add(new Point(241,121));
		hm.put(new Point(209,255), arr82);
		ArrayList<Point> arr83= new ArrayList<Point>();
		arr83.add(new Point(295,104));
		arr83.add(new Point(209,255));
		hm.put(new Point(241,121), arr83);
		ArrayList<Point> arr84= new ArrayList<Point>();
		arr84.add(new Point(241,121));
		arr84.add(new Point(629,113));
		hm.put(new Point(295,104), arr84);
		ArrayList<Point> arr1= new ArrayList<Point>();
		arr1.add(new Point(216,637));
		arr1.add(new Point(174,426));
		hm.put(new Point(86,414), arr1);
		ArrayList<Point> arr54= new ArrayList<Point>();
		arr54.add(new Point(912,267));
		hm.put(new Point(855,261), arr54);
		ArrayList<Point> arr89= new ArrayList<Point>();
		arr89.add(new Point(1476,386));
		hm.put(new Point(1391,397), arr89);
		ArrayList<Point> arrinicio1= new ArrayList<Point>();
		arrinicio1.add(new Point(129,876));
		hm.put(new Point(66,735), arrinicio1);
		ArrayList<Point> arrinicio2= new ArrayList<Point>();
		arrinicio2.add(new Point(129,876));
		hm.put(new Point(66,785), arrinicio2);
		ArrayList<Point> arrinicio3= new ArrayList<Point>();
		arrinicio3.add(new Point(129,876));
		hm.put(new Point(66,835), arrinicio3);
		ArrayList<Point> arrinicio4= new ArrayList<Point>();
		arrinicio4.add(new Point(129,876));
		hm.put(new Point(116,735), arrinicio4);
		ArrayList<Point> arrinicio5= new ArrayList<Point>();
		arrinicio5.add(new Point(129,876));
		hm.put(new Point(116,785), arrinicio5);
		ArrayList<Point> arrinicio17= new ArrayList<Point>();
		

	}
	public boolean estaEn(Point punto,ArrayList<Point> array){
		for(int i=0;i<array.size();i++){
			if(punto.equals(array.get(i))){
				return true;
			}
		}return false;
	}
	public void MoverA(Point posicion,int dado,ArrayList<Point> camino,ArrayList<Point> resultado){
		if(dado==0){
			resultado.add(posicion);
		}else{
			System.out.println("posicion"+posicion);
			for(int i=0;i<hm.get(posicion).size();i++){
				//System.out.println(hm.get(posicion).get(i));
				if(estaEn(hm.get(posicion).get(i),camino)==false){
					camino.add(hm.get(posicion).get(i));
					//System.out.println(hm.get(posicion).get(i));
					MoverA(hm.get(posicion).get(i),dado-1,camino,resultado);
				}
			}
		}
	}
	public static void main (String [] args){
		busquedaposicion aa=new busquedaposicion();
		ArrayList <Point> ar=new ArrayList<Point>();
		ar.add(new Point(1097,289));
		ArrayList<Point> res=new ArrayList<Point>();
		aa.MoverA(new Point(1097,289),6,ar,res);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
		System.out.println("camino");
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	
	}
	
}

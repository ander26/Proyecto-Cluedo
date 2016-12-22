package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Proyecto.Cluedo.Logica.FicheroCoordenadasPosiciones;

public class ventanaccodenadacirculos extends JFrame {
	
	public Point[] arrpuertas = { new Point(1391, 397), new Point(241, 120), new Point(209, 255), new Point(504, 196),
			new Point(629, 113), new Point(1097, 289), new Point(1621, 185), new Point(1650, 325), new Point(1846, 174),
			new Point(1880, 334), new Point(1320, 770), new Point(573, 876), new Point(855, 261) };
	
	private ArrayList<Point> arrpuntmarrones = new ArrayList<Point>();

	public ventanaccodenadacirculos() {
	
		setSize(1920, 1053);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel p = new JPanel();
		
		p.setLayout(null);
		
		FicheroCoordenadasPosiciones fcoordenadas = new FicheroCoordenadasPosiciones();
		
		arrpuntmarrones = fcoordenadas.leerDeFicheroConBarras("cordeenadascirculos.txt");
		
		Panelcirculos anel = new Panelcirculos();
		// Point [] arrpuertas={new Point(1391,397),new Point(241,120),new
		// Point(209,255),new Point(504,196),new Point(629,113),new
		// Point(1097,289),new Point(1621,185),new Point(1650,325),new
		// Point(1846,174),new Point(1880,334),new Point(1317,809),new
		// Point(573,876),new Point(855,261)};
		
		for (int i = 0; i < arrpuntmarrones.size(); i++) {
			JLabel a = new JLabel();
			a.setText(arrpuntmarrones.get(i).getX() + " " + arrpuntmarrones.get(i).getY());
			a.setLocation((int) arrpuntmarrones.get(i).getX(), (int) arrpuntmarrones.get(i).getY() - 88);
			a.setSize(200, 200);
			p.add(a);

		}
		
		for (int j = 0; j < arrpuertas.length; j++) {
			JLabel b = new JLabel();
			b.setText(arrpuntmarrones.get(j).getX() + " " + (arrpuntmarrones.get(j).getY()));

			b.setSize(200, 200);
			b.setLocation((int) arrpuntmarrones.get(j).getX()-28, (int) arrpuntmarrones.get(j).getY() - 16);

			p.add(b);
		}
		p.setOpaque(false);
		p.setSize(1920, 1040);
		anel.setSize(1920, 1053);
		anel.setOpaque(false);
		anel.setLayout(new BorderLayout());
		anel.add(p);
		// anel.repaint();
		// getContentPane().add(anel);
		getContentPane().add(anel);

	}

	public static void main(String[] args) {
		ventanaccodenadacirculos ventana = new ventanaccodenadacirculos();
		ventana.setVisible(true);
	}

}

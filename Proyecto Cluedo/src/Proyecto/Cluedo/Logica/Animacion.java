package Proyecto.Cluedo.Logica;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Animacion {

	public static final int TIEMPO = 1200;

	private JPanel panel;
	private Rectangle desde;
	private Rectangle hasta;

	private long tiempoComienzo;

	public Animacion(JPanel panel, Rectangle desde, Rectangle hasta) {
        this.panel = panel;
        this.desde = desde;
        this.hasta = hasta;
    }

	public void start() {
		Timer timer = new Timer(40, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long duracion = System.currentTimeMillis() - tiempoComienzo;
				double progreso = (double) duracion / (double) TIEMPO;
				if (progreso > 1f) {
					progreso = 1f;
					((Timer) e.getSource()).stop();
				}
				Rectangle target = calcularProgreso(desde, hasta, progreso);
				panel.setBounds(target);
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		tiempoComienzo = System.currentTimeMillis();
		timer.start();
	}



	public static Rectangle calcularProgreso(Rectangle startBounds, Rectangle targetBounds, double progreso) {

		Rectangle bounds = new Rectangle();

		if (startBounds != null && targetBounds != null) {

			bounds.setLocation(calcularProgreso(startBounds.getLocation(), targetBounds.getLocation(), progreso));
			bounds.setSize(calcularProgreso(startBounds.getSize(), targetBounds.getSize(), progreso));

		}

		return bounds;

	}

	public static Point calcularProgreso(Point startPoint, Point targetPoint, double progreso) {

		Point point = new Point();

		if (startPoint != null && targetPoint != null) {

			point.x = calcularProgreso(startPoint.x, targetPoint.x, progreso);
			point.y = calcularProgreso(startPoint.y, targetPoint.y, progreso);

		}

		return point;

	}

	public static int calcularProgreso(int startValue, int endValue, double fraction) {

		int value = 0;
		int distance = endValue - startValue;
		value = (int) Math.round((double) distance * fraction);
		value += startValue;

		return value;

	}

	public static Dimension calcularProgreso(Dimension startSize, Dimension targetSize, double progreso) {

		Dimension size = new Dimension();

		if (startSize != null && targetSize != null) {

			size.width = calcularProgreso(startSize.width, targetSize.width, progreso);
			size.height = calcularProgreso(startSize.height, targetSize.height, progreso);

		}

		return size;

	}
}

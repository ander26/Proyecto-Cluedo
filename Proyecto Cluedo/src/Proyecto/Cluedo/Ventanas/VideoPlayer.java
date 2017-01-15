package Proyecto.Cluedo.Ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;

import javax.swing.*;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Logica.Propiedades;



import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;

/**
 * Ventana donde se encuentra la clase del reproductor de video
 */
public class VideoPlayer extends JFrame {
	
	private static final long serialVersionUID = 1L;
	

	// Atributo de VLCj
	
	EmbeddedMediaPlayerComponent mediaPlayerComponent;
	EmbeddedMediaPlayer mediaPlayer;
	
	// Atributos manipulables de swing
	
	private JProgressBar pbVideo = null;      // Barra de progreso del vídeo en curso
	
	
	
	
	
	public VideoPlayer(Connection conexion, Jugador j, Usuario u, GestionBaseDeDatos base, Partida p,
			Propiedades prop, boolean inicio) {
		
		setUndecorated(true);
		
		
		pbVideo = new JProgressBar( 0, 10000 );
		
		
		JPanel panelVideo = new JPanel();
		JPanel pInferior = new JPanel();
		
		
		// Componente de VCLj
		
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent() {
			private static final long serialVersionUID = 1L;
			@Override
            protected FullScreenStrategy onGetFullScreenStrategy() {
                return new Win32FullScreenStrategy(VideoPlayer.this);
            }
        };
        mediaPlayer = mediaPlayerComponent.getMediaPlayer();

		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		
		pInferior.setLayout( new BorderLayout() );
		panelVideo.setLayout( new BorderLayout() );
		
		

		pInferior.add( pbVideo, BorderLayout.CENTER );
		
		panelVideo.add(mediaPlayerComponent,BorderLayout.CENTER);

		getContentPane().add( panelVideo, BorderLayout.CENTER );
		
		getContentPane().add( pInferior, BorderLayout.SOUTH );
		
		
		
		
		
		// Click en barra de progreso para saltar al tiempo del vídeo de ese punto
		pbVideo.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mediaPlayer.isPlayable()) {
					// Seek en el vídeo
					float porcentajeSalto = (float)e.getX() / pbVideo.getWidth();
					mediaPlayer.setPosition( porcentajeSalto );
			    	visualizaTiempoRep();
					// Otra manera de hacerlo con los milisegundos:
					// long milisegsSalto = mediaPlayer.getLength();
					// milisegsSalto = Math.round( milisegsSalto * porcentajeSalto );
					// mediaPlayer.setTime( milisegsSalto );
				}
			}
		});
		// Cierre del player cuando se cierra la ventana
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}

			

			@Override
			public void windowOpened(WindowEvent e) {
				lanzaVideo();
				
			}
			
			
		});
		
		// Eventos del propio player
		mediaPlayer.addMediaPlayerEventListener( 
			new MediaPlayerEventAdapter() {
				// El vídeo se acaba
				@Override
				public void finished(MediaPlayer mediaPlayer) {
					dispose();
					
					VentanaTablero ventana = new VentanaTablero(conexion, j, u, base, p, prop, inicio);
					ventana.setVisible(true);
				}
				// Hay error en el formato o en el fichero del vídeo
				@Override
				public void error(MediaPlayer mediaPlayer) {
					
				}
				// Evento que ocurre al cambiar el tiempo (cada 3 décimas de segundo aproximadamente
			    @Override
			    public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
			    	visualizaTiempoRep();
			    }
		});
	}
		private void visualizaTiempoRep() {
			pbVideo.setValue( (int) (10000.0 * 
					mediaPlayer.getTime() /
					mediaPlayer.getLength()) );
			pbVideo.repaint();
			
		}

	//
	// Métodos sobre el player de vídeo
	//
	
	// Para la reproducción del vídeo en curso
	private void paraVideo() {
		if (mediaPlayer!=null)
			mediaPlayer.stop();
	}
	
		
	private void lanzaVideo() {
		if (mediaPlayer!=null) {
			File ficVideo = new File("src/Proyecto/Cluedo/Ventanas/Videos/Cluedo 2.mp4");
			mediaPlayer.playMedia( 
				ficVideo.getAbsolutePath() );
			mediaPlayer.setVolume(60);
			
		} else {
		
		}
	}
	


}


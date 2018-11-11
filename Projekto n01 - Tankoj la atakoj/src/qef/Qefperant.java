package qef;

import qef.grafikj.Fenestr;
import qef.son.Son;

public class Qefperant {
	
	private boolean funkciante;//gxi devas esti volatile kiam mi aldonos alian threads-on
	
	private String titol;
	
//	private Fenestr fenestr;
	private Son fonmuzik;
	
	public static void main(String[] args) {
		//Nur por OpenGL en Mac/Linux
		//System.setProperty("sun.java2d.opengl", "True");
		
		/*
		 * Para Directx en Windows
		 * System.setProperty("sun.java2d.d3d", "True");
		 * System.setProperty("sun.java2d.ddforcevram", "True");
		 */
		
		//System.setProperty("sun.java2d.transaccel", "True");
		Qefperant qp = new Qefperant("Tankoj la atakoj", Konstantj.plejfenestrLargx, Konstantj.plejfenestrAlt);
		
		qp.ekLudn();
		qp.ekQefBukln();
	}
	
	private Qefperant(final String titolo, final int largx, final int alt) {
		titol = titolo;
	}
	
	private void desegn() {
		QefObjektj.superfic.desegn(QefObjektj.statp);
	}
	
	private void gxisdatig() {
		QefObjektj.statp.yangxNunStatn();
		QefObjektj.statp.gxisdatig();
		QefObjektj.superfic.muyn().gxisdatig();
	}
	
	private void ekLudn() {
		funkciante = true;
		
		definigad();
		fonmuzik.loop();
	}
	
	private void definigad() {
		fonmuzik = new Son(Konstantj.ITENER_SONJ_LUDANT + "pom.wav", 0);
		new Fenestr(titol);
	}
	
	private void ekQefBukln() {
		int fpsAkumulita = 0;
		int apsAkumulita = 0;
		
		final int NS_POR_SEGUNDO = 1000000000;
		final short APS_OBJETO = 60 * Konstantj.LUDRAPIDEC;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		
		double tiempoTranscurrido;
		double delta = 0;
		
		while (funkciante) {
			
			final long inicioBucle = System.nanoTime();
			
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			
			while (delta >= 1) {
				gxisdatig();
				apsAkumulita++;
				
				delta--;
			}
			
			desegn();
			fpsAkumulita++;
			
			if ((System.nanoTime() - referenciaContador) > NS_POR_SEGUNDO) {
				Konstantj.qiufps += fpsAkumulita;
				Konstantj.aps = apsAkumulita;
				Konstantj.fps = fpsAkumulita;
				Konstantj.sekundjPasita++;
				apsAkumulita = 0;
				fpsAkumulita = 0;
				referenciaContador = System.nanoTime();
				
			}
			
		}
	}
	
}
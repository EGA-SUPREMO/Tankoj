/** This program is free software: you can redistribute it and/or modify
  *  it under the terms of the GNU General Public License as published by
  *  the Free Software Foundation, either version 3 of the License, or
  *  (at your option) any later version.
  *
  *  This program is distributed in the hope that it will be useful,
  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  *  GNU General Public License for more details.
  *
  *  You should have received a copy of the GNU General Public License
  *  along with this program.  If not, see <https://www.gnu.org/licenses/>.*/

package qef;

import javax.swing.JOptionPane;

import qef.estazhj.vivazhj.kampfort.Kampfort;
import qef.estazhj.vivazhj.misil.Misileg;
import qef.grafikj.Fenestr;
import qef.ilj.Ludantperant;
import qef.son.Son;
import qef.uzantinterfac.suprmenu.Suprmenu;

public class Qefperant {
	
	private boolean funkciante;//gxi devas esti volatile kiam mi aldonos alian threads-on
	
	private String titol;
	
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
		Ludantperant.definigadj();
		fonmuzik = new Son(Konstantj.ITENER_SONJ_LUDANT + "pom.wav", 0);
		Misileg.definigadMisiljn();
		Kampfort.definigadj();
		QefObjektj.suprmenu = new Suprmenu();
		new Fenestr(titol);
	}
	
	private void ekQefBukln() {
		int fpsAkumulita = 0;
		int apsAkumulita = 0;
		
		final int NS_POR_SEGUNDO = 1000000000;
		final short APS_OBJETO = 20 * Konstantj.LUDRAPIDEC;
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
				try {//TODO forigu tion
					gxisdatig();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e, "Error: gxisdatig()", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				apsAkumulita++;
				
				delta--;
			}

			try {
				desegn();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error: desegn()", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
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
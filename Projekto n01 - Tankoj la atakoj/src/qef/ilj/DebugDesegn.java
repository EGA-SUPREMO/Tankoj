package qef.ilj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import qef.QefObjektj;

public class DebugDesegn {
	
	private static int objektjDesegnita;
	private static Graphics g;
	
	public static void definigad(final Graphics gg) {
		g = gg;
		objektjDesegnita = 0;
	}
	
	public static void desegnString(final String str, final int x, final int y) {
		objektjDesegnita++;
		g.drawString(str, x, y);
	}
	
	public static void desegnRectangle(final Rectangle rect) {
		objektjDesegnita++;
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public static void desegnMargxenRectangle(final Rectangle rect) {
		objektjDesegnita++;
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public static void desegnRectangle(final int x, final int y, final int largx, final int alt) {
		objektjDesegnita++;
		g.fillRect(x, y, largx, alt);
	}
	
	public static void desegnMargxenRectangle(final int x, final int y, final int largx, final int alt) {
		objektjDesegnita++;
		g.drawRect(x, y, largx, alt);
	}
	
	public static void desegnBildn(final BufferedImage bild, final int x, final int y) {
		objektjDesegnita++;
		g.drawImage(bild, x, y, null);
	}
	
	public static void desegnKolicijn() {
/*		for(int i = 0; i < QefObjektj.map.arejKolici.size(); i++) {
			objektjDesegnita++;
			desegnMargxenRectangle(QefObjektj.map.arejKolici.get(i));
	}*/
		
		for(int i = 0; i < 4; i++) {
			objektjDesegnita++;
			desegnRectangle(QefObjektj.ludant.LIMJN()[i]);
		}
		
	}
	
	public static void setColor(final Color c) {
		g.setColor(c);
	}
	
	public static int objektjDesegnitan() {
		return objektjDesegnita;
	}
	
}
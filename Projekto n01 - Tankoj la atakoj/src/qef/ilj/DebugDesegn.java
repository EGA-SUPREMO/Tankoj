package qef.ilj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;
import qef.uzantinterfac.Buton;

public class DebugDesegn {
	
	private static int objektjDesegnita;
	private static Graphics g;
	
	public static void definigad(final Graphics gg) {
		g = gg;
		objektjDesegnita = 0;
	}
	public static void yangxGrafikn() {
		if(Konstantj.altGrafik)
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
	}
	public static void yangxGrafikn(final boolean altGrafik) {
		if(altGrafik)
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		else
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_OFF);
	}
	
	public static void desegnString(final String str, final int x, final int y) {
		objektjDesegnita++;
		g.drawString(str, x, y);
	}
	public static void desegnString(final String str, final int x, final int y, final Color c) {
		objektjDesegnita++;
		g.setColor(c);
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
	
	public static void desegnKomponantn(final BufferedImage bild, final int x, final int y) {
		objektjDesegnita++;
		g.drawImage(bild, x, y, null);
	}
	
	public static void desegnRectangle(final Rectangle rect, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public static void desegnMargxenRectangle(final Rectangle rect, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public static void desegnRectangle(final int x, final int y, final int largx, final int alt, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.fillRect(x, y, largx, alt);
	}
	
	public static void desegnMargxenRectangle(final int x, final int y, final int largx, final int alt,
			final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.drawRect(x, y, largx, alt);
	}
	
	public static void desegnBildn(final BufferedImage bild, final int xo, final int y) {
		yangxGrafikn(false);
		if(xo + bild.getWidth() > QefObjektj.map.yn().length) {
			objektjDesegnita++;
			g.drawImage(bild, xo - QefObjektj.map.yn().length, y, null);
		}else {
			objektjDesegnita++;
			g.drawImage(bild, xo + QefObjektj.map.yn().length, y, null);
		}
		
		if(xo < QefObjektj.map.yn().length) {
			g.drawImage(bild, xo, y, null);
			objektjDesegnita++;
		}

		yangxGrafikn();
	}
	public static void desegnLine(final int x1, final int y1, final int x2, final int y2) {
		objektjDesegnita++;
		g.drawLine(x1, y1, x2, y2);
	}
	public static void desegnLine(final int x1, final int y1, final int x2, final int y2, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		g.drawLine(x1, y1, x2, y2);
	}
	public static void desegnOval(final int x, final int y, final int largx, final int alt) {
		objektjDesegnita++;
		if(x + largx > QefObjektj.map.yn().length)
			g.fillOval(x - QefObjektj.map.yn().length, y, largx, alt);
		else
			g.fillOval(x + QefObjektj.map.yn().length, y, largx, alt);
		
		if(x < QefObjektj.map.yn().length)
			g.fillOval(x, y, largx, alt);
		
	}
	public static void desegnOval(final int x, final int y, final int largx, final int alt, final Color kolor) {
		objektjDesegnita++;
		g.setColor(kolor);
		if(x + largx > QefObjektj.map.yn().length)//TODO MI POVAS FORIGI LA ALDONDADO KAJ ESTU LA KODO PLI RAPIDA
			//SED ANKAUX MALPLI EKZAKTA
			g.fillOval(x - QefObjektj.map.yn().length, y, largx, alt);
		else
			g.fillOval(x + QefObjektj.map.yn().length, y, largx, alt);
		
		if(x < QefObjektj.map.yn().length)
			g.fillOval(x, y, largx, alt);
	}
	
	public static void desegnKolicijn() {
		for(int i = 0; i < Vicperant.ludantj[Vicperant.nunLudantn()].LIMJN().length; i++)
			desegnRectangle(Vicperant.ludantj[Vicperant.nunLudantn()].LIMJN()[i]);
		
		for(Vivazh nun : QefObjektj.map.vivazhar)
			for(int i = 0; i < nun.LIMJN().length; i++)
				desegnMargxenRectangle((int) Kvantperant.koordenadXalekranPosicin(nun.LIMJN()[i].x), 
						(int) Kvantperant.koordenadYalekranPosicin(nun.LIMJN()[i].y), nun.LIMJN()[i].width,
						nun.LIMJN()[i].height);
		
	}
	public static void setFont(final Font font) {
		g.setFont(font);
	}
	public static Font Fontn() {
		return g.getFont();
	}
	public static Graphics Graphicsn() {
		return g;
	}
	public static void setColor(final Color c) {
		g.setColor(c);
	}
	
	public static int objektjDesegnitan() {
		return objektjDesegnita;
	}
	
}
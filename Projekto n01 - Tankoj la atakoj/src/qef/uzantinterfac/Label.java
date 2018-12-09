package qef.uzantinterfac;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.ilj.StringKvantil;

public class Label extends Komponant {
	
	private Font font;
	
	public Label(final int xo, final int yo, final int koloro, final Font fonto, final String texto) {
		super(xo, yo, 0, 1, koloro, texto);
		BufferedImage tempbild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration().createCompatibleImage(1, 1, Transparency.TRANSLUCENT);
		
		Graphics g = tempbild.getGraphics();
		g.setFont(fonto);
		alt = StringKvantil.altStringn(g, text);
		largx = StringKvantil.largxStringn(g, text);
		g.dispose();
		
		alt -= alt*7/16;
		font = fonto;
		definigBildn();
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnString(text, x, y, Konstantj.KOLORJ_BUTON[kolor]);
	}
	
	@Override
	public void gxisdatig() {
	}

	@Override
	public void definigBildn() {
		bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
				.createCompatibleImage(largx, alt, Transparency.TRANSLUCENT);
		Graphics g = bild.getGraphics();
		g.setFont(font);
		g.setColor(Konstantj.KOLORJ_BUTON[kolor]);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString(text, 0, alt);
		
		g.dispose();
		aldonAldonayjn(0);
	}
	
}
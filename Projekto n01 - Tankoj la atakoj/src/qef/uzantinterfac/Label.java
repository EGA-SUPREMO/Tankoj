package qef.uzantinterfac;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.ilj.StringKvantil;

public class Label extends Komponant {
	
	public int alt;
	
	public Label(final int xo, final int yo, final int koloro, final Font font, final String texto) {
		super(xo, yo, 0, koloro, texto);
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration().createCompatibleImage(1, 1, Transparency.TRANSLUCENT);
		
		Graphics g = bild.getGraphics();
		g.setFont(font);
		alt = StringKvantil.altStringn(g, text);
		largx = StringKvantil.largxStringn(g, text);
		g.dispose();
		y += alt;
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnString(text, x, y, Konstantj.KOLORJ_BUTON[kolor]);
	}
	
	@Override
	public void gxisdatig() {
	}
	
}
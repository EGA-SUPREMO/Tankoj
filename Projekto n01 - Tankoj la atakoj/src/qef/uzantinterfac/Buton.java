package qef.uzantinterfac;

import java.awt.image.BufferedImage;

import qef.ilj.Bildperant;

public class Buton {
	
	public final BufferedImage buton;
	public final int x, y;
	
	public Buton(final int xo, final int yo, final int largx, final int kolor, final String texto) {
		x = xo;
		y = yo;
		
		buton = Bildperant.kreButon(largx, kolor, 0, texto);
	}
	
}

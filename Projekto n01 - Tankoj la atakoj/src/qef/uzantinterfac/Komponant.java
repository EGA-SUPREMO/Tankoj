package qef.uzantinterfac;

import java.awt.image.BufferedImage;

public class Komponant {

	public BufferedImage buton;
	public final int x, largx;
	public int kolor;
	public int y;
	protected final String text;
	protected boolean qgxisdatig;
	
	public Komponant(final int xo, final int yo, final int largxo, final int koloro, final String texto) {
		x = xo;
		y = yo;
		largx = largxo;
		kolor = koloro;
		text = texto;
		qgxisdatig = true;
	}
	
	public void desegn() {}
	
}
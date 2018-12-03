package qef.uzantinterfac;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import qef.ilj.Bildperant;

public abstract class Komponant {

	protected BufferedImage bild;
	protected final int x;
	protected int largx;
	public int kolor;
	protected int y;
	public final String text;
	protected Rectangle kolici;
	protected boolean qgxisdatig;
	
	public Komponant(final int xo, final int yo, final int largxo, final int koloro, final String texto) {
		x = xo;
		y = yo;
		largx = largxo;
		kolor = koloro;
		text = texto;
		qgxisdatig = true;
	}
	
	public abstract void desegn();
	
	public abstract void gxisdatig();
	
	public void aldonKomponantn(final Komponant komponant) {
		Bildperant.aldonKomponantn(bild, komponant.bild, komponant.x - x, komponant.y - y);
	}
	
	
	public abstract void definigBildn();
	
	public int xn() {
		return x;
	}
	public int yn() {
		return y;
	}
	public int largxn() {
		return largx;
	}
	public void setLargxn(final int largxo) {
		largx = largxo;
		kolici.width = largx;
		qgxisdatig = true;
	}
	
	
}
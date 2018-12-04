package qef.uzantinterfac;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import qef.ilj.Bildperant;

public abstract class Komponant {

	protected BufferedImage[] aldonayj;
	protected BufferedImage bild;
	protected final int x;
	protected int largx, alt;
	public int kolor;
	protected int y;
	public final String text;
	protected Rectangle kolici;
	protected boolean qgxisdatig;
	
	public Komponant(final int xo, final int yo, final int largxo, final int kvant, final int koloro,
			final String texto) {
		x = xo;
		y = yo;
		largx = largxo;
		kolor = koloro;
		text = texto;
		aldonayj = new BufferedImage[kvant];
		qgxisdatig = true;
	}
	
	public abstract void desegn();
	
	public abstract void gxisdatig();

	public void aldonKomponantn(final Komponant komponant, final int i) {
		if(aldonayj[i]==null)
			aldonayj[i] = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration().createCompatibleImage(bild.getWidth(), bild.getHeight(),
							Transparency.TRANSLUCENT);
		Bildperant.aldonKomponantn(aldonayj[i], komponant.bild, komponant.x - x, komponant.y - y);
		aldonAldonayjn(i);
	}
	public void aldonKomponantn(final BufferedImage komponant, final int xo, final int yo, final int i) {
		if(aldonayj[i]==null)
			aldonayj[i] = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration().createCompatibleImage(bild.getWidth(), bild.getHeight(),
							Transparency.TRANSLUCENT);
		Bildperant.aldonKomponantn(aldonayj[i], komponant, xo, yo);
		aldonAldonayjn(i);
	}
	protected void aldonAldonayjn(final int i) {
		if(aldonayj[i]==null)
			aldonayj[i] = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration().createCompatibleImage(bild.getWidth(), bild.getHeight(),
							Transparency.TRANSLUCENT);
		Bildperant.aldonKomponantn(bild, aldonayj[i], 0, 0);
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
	public int altn() {
		return alt;
	}
	public void setLargxn(final int largxo) {
		largx = largxo;
		kolici.width = largx;
		for(int i = 0; i < aldonayj.length; i++)
			aldonayj[i] = null;
		qgxisdatig = true;
	}
	public void setAltn(final int alto) {
		alt = alto;
		kolici.height = alto;
		for(int i = 0; i < aldonayj.length; i++)
			aldonayj[i] = null;
		qgxisdatig = true;
	}
	public Rectangle kolicin() {
		return kolici;
	}
	//CAMEEEEEEEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRAAA
}
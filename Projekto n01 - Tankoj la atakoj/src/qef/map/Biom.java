package qef.map;

import java.awt.Color;

import qef.ilj.BruGeneril;

public class Biom {
	
	protected final int altgrandec;
	private final int[] frekvencij;
	private final float[] amplitudes;
	private final Color kolor;
	
	public Biom(final int[] frekvencioj, final float[] amplitudeso, final int altgrandeco, final Color koloro) {
		frekvencij = frekvencioj;
		amplitudes = amplitudeso;
		altgrandec = altgrandeco;
		kolor = koloro;
	}
	
	public double[] yn() {
		final double[] y = BruGeneril.generMapn(frekvencij, amplitudes, altgrandec);
		aldonAldonajxjnYn(y);
		return y;
	}
	protected void aldonAldonajxjnYn(final double[] yo) {
	}
	public Color kolorn() {
		return kolor;
	}
	
}
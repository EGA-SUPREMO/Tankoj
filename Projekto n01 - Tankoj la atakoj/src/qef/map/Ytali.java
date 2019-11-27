package qef.map;

import java.awt.Color;

import qef.Konstantj;
import qef.map.urb.Konstruazh;

public class Ytali extends Biom {
	static int[] zer = {0};
	static float[] zerf = {0};
	public Ytali(int altgrandeco, Color koloro) {
		super(zer, zerf, altgrandeco, 0, koloro);
	}
	@Override
	protected void aldonAldonajxjnYn(final double[] yo) {
		Konstruazh.kreKonstruazhjn(yo, (int) (Math.random()*Konstantj.mapgrandec/2),
				(int) (Math.random()*Konstantj.mapgrandec), altgrandec*14);
	}
	
}

package qef.map.urb;

import java.awt.Color;
import java.util.Random;

import qef.Konstantj;
import qef.map.Biom;

public class Urb extends Biom {
	
	public Urb(final int[] frekvencioj, final float[] amplitudeso, final int altgrandeco, final double mldureco,
			final Color koloro) {
		super(frekvencioj, amplitudeso, altgrandeco, mldureco, koloro);
	}
	
	@Override
	protected void aldonAldonajxjnYn(final double[] yo) {
		final Random r = new Random();
		
		final int hazard = (int) (r.nextDouble()*100);
		final int plejKonstruazhj = hazard<53? 4 : hazard<81? 5 : hazard<93? 3 : 1;
		final int distanc = Konstantj.mapgrandec/(plejKonstruazhj + 1);
		int akumilitX = 0;
		int x;
		
		for(int i = 0; i < plejKonstruazhj; i++) {
			x = (int) ((r.nextDouble()*distanc + akumilitX + 20));
			final int largx = (int) (90 + (r.nextDouble()*40));
			if(largx + x>Konstantj.mapgrandec)
				return;
			Konstruazh.kreKonstruazhjn(yo, x, largx, (int) (altgrandec*22 + (r.nextDouble()*40)));
			
			akumilitX = x + largx + 10;
		}
	}
}
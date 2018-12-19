package qef.map.mes;

import java.awt.Color;
import java.util.Random;

import qef.Konstantj;
import qef.map.Biom;

public class Mes extends Biom {
	
	private static Random r = new Random();
	
	public Mes(final int[] frekvencioj, final float[] amplitudeso, final int altgrandeco, final Color koloro) {
		super(frekvencioj, amplitudeso, altgrandeco, koloro);
		
	}
	
	@Override
	protected void aldonAldonajxjnYn(final double[] yo) {
		final int hazard = (int) (r.nextDouble()*100);
		final int plejMontj = hazard<53? 2 : hazard<81? 3 : hazard<93? 1 : 0;
		for(int i = 0; i < plejMontj; i++) {
			final double[] mont = Partmesmont.partmesmontn((int) (r.nextDouble()*Konstantj.mapgrandec/(plejMontj + 1)),
					altgrandec*2);
			
			for(int j = 0; j < mont.length; j++)
				yo[j] = yo[j] + mont[j];
		}
	}
	
}
package qef.map.mes;

import java.awt.Color;
import java.util.Random;

import qef.Konstantj;
import qef.map.Biom;
import qef.map.Vent;

public class Mes extends Biom {
	
	private static Random r = new Random();
	
	public Mes(final int[] frekvencioj, final float[] amplitudeso, final int altgrandeco, final double mldureco,
			final Color koloro) {
		super(frekvencioj, amplitudeso, altgrandeco, mldureco, koloro);
		
	}
	
	@Override
	protected void aldonAldonajxjnYn(final double[] yo) {
		final int hazard = (int) (r.nextDouble()*100);
		final int plejMontj = hazard<53? 2 : hazard<81? 3 : hazard<93? 1 : 0;
		for(int i = 0; i < plejMontj; i++) {
			
			final Mesmont mont = new Mesmont(
					(int) (yo.length/8 + r.nextDouble()*(Konstantj.mapgrandec/(plejMontj) - yo.length/8)),
					altgrandec);
			
			for(int j = 0; j < mont.y.length; j++)
				yo[j + i*mont.y.length] += mont.y[j];
		}
		Vent.forigBrun(yo);
		Vent.forigBrun(yo);
	}
	
}
package qef.estazhj.vivazhj;

import java.awt.geom.Point2D;
import java.util.ArrayDeque;

import qef.QefObjektj;

public abstract class Misilatingec extends Misil {

	private final static double margxenErar = Math.PI/2*0.04;
	private final static double plejmargexnErar = Math.PI/2 + margxenErar;
	private final static double mlplejmargexnErar = Math.PI/2 - margxenErar;
	static Point2D ACCELERATION;
	private static double nunX, nunY;
	
	private Misilatingec(int ekangulo, int potenco, int damagxo, double ekXo, double ekYo) {
		super(ekangulo, potenco, damagxo, ekXo, ekYo);
	}
	public static int[] atingecn (final int ekangulo, final int potenco, final double xo, final double yo) {
		final double ekangul = Math.toRadians(ekangulo);
		final double potenc = Math.sqrt(potenco)*6;
		ACCELERATION = new Point2D.Double(QefObjektj.map.ventn(), -9.81 * 0.1);
		
		ArrayDeque<Integer> punkt = new ArrayDeque<>();
		int nunx = (int) xo, nuny = (int) yo;
		final double vent;
		if(ekangul > mlplejmargexnErar && ekangul <plejmargexnErar)
			vent = 0;
		else
			vent = Math.random()/10-0.05;

		executShotn(1.3/200*potenc, vent);
		
		while(rapidecY > 0 && nuny >= QefObjektj.map.yn(nunx)) {
			
			int i = 0;
			b:
			while(nunx == (int) xo && nuny == (int) yo) {
				executShotn(1.3/200*potenc, vent);
				if(i++>60)
					break b;
			}
			nunx = (int) xo;
			nuny = (int) yo;
			punkt.add(nunx);
			punkt.add(nuny);
		}
		int[] punktj = new int[punkt.size()];
		for(int j = 0; j < punktj.length; j++)
			punktj[j] = punkt.poll();
		
		return punktj;
	}
	private static void atingecMov(final double dt) {
		nunX = scaleAddAssign(nunX, dt, rapidecX);
		nunY = scaleAddAssign(nunY, dt, rapidecY);
	}

	private static void executShotn(final double rapidec, final double vent) {
		kalkulRapidec(rapidec, vent, ACCELERATION.getY());
		atingecMov(rapidec);
	}
	
}
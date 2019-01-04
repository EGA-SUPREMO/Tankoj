package qef.estazhj.vivazhj.misil;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;

import qef.Konstantj;
import qef.QefObjektj;

public class KalkuliTrajektn {

	private final static double margxenErar = Math.PI/2*0.04;
	private final static double plejmargexnErar = Math.PI/2 + margxenErar;
	private final static double mlplejmargexnErar = Math.PI/2 - margxenErar;
	private final Misil misil;
	private Point2D ACCELERATION;
	private double ekangul;
	private double potenc;
	private Point2D nunrapidec;
	
	public KalkuliTrajektn(final Misil misilo, final double vent, final int ekangulo, final int potenco) {
		misil = misilo;
		ekangul = Math.toRadians(ekangulo);
		ACCELERATION = new Point2D.Double(vent, -9.81 * 0.1);
		potenc = Math.sqrt(potenco)*6;
		nunrapidec = AffineTransform.getRotateInstance(ekangul).transform(new Point2D.Double(1, 0), null);
		nunrapidec.setLocation(-nunrapidec.getX() * potenc * 0.5, nunrapidec.getY() * potenc * 0.5);
		misil.rapidecX = nunrapidec.getX();
		misil.rapidecY = nunrapidec.getY();
	}
	
	public void executShotn() {
		executShotn(1);
	}
	
	public void executShotn(final double faktor) {
		final double dt = Konstantj.MISILRAPIDEC*faktor;
		kalkulRapidec(dt, ACCELERATION.getX(), ACCELERATION.getY());
		mov(dt);
	}
	
	private void kalkulRapidec(final double dt, final double accelerationX, final double accelerationY) {
		misil.rapidecX = scaleAddAssign(misil.rapidecX, dt, accelerationX);
		misil.rapidecY = scaleAddAssign(misil.rapidecY, dt, accelerationY);
	}
	private void mov(final double dt) {
		misil.setXn(scaleAddAssign(misil.xn(), dt, misil.rapidecX));
		misil.setYn(scaleAddAssign(misil.yn(), dt, misil.rapidecY));
	}
	
	protected static double scaleAddAssign(final double x, final double faktor, final double aldon) {
		return (x + faktor * aldon);
	}
	
	public int[] atingecn () {
		
		ArrayDeque<Integer> punkt = new ArrayDeque<>();
		int nunx = (int) misil.xn(), nuny = (int) misil.yn();
		if(ekangul > mlplejmargexnErar && ekangul <plejmargexnErar)
			ACCELERATION.setLocation(0, ACCELERATION.getY());
		else
			ACCELERATION.setLocation(Math.random()/10-0.05, ACCELERATION.getY());

		executShotn(1.3*potenc);
		;
		while(misil.rapidecY > 0 && nuny >= QefObjektj.map.yn(nunx)) {
			
			int i = 0;
			b:
			while(nunx == (int) misil.xn() && nuny == (int) misil.yn()) {
				executShotn(1.3*potenc);
				if(i++>60)
					break b;
			}
			nunx = (int) misil.xn();
			nuny = (int) misil.yn();
			punkt.add(nunx);
			punkt.add(nuny);
		}
		int[] punktj = new int[punkt.size()];
		for(int j = 0; j < punktj.length; j++)
			punktj[j] = punkt.poll();
		
		return punktj;
	}
	
}
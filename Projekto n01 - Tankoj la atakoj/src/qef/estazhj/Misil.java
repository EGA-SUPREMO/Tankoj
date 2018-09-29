package qef.estazhj;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;

public class Misil extends Vivazh {
	
	private final static double margxenErar = Math.PI/2*0.04;
	private final static double plejmargexnErar = Math.PI/2 + margxenErar;
	private final static double mlplejmargexnErar = Math.PI/2 - margxenErar;
	private final double damagx = 150;
	private final int komencDamagxX = (int) (damagx/2);
	private final int damagxX = (int) (damagx/1.5);
	private int aerTemp;
	private double angleRad;
	private double potenc;
	private final Point2D ACCELERATION;
	private Point2D nunrapidec;
	long prevTime;
	
	public Misil(final int ekangulo, final int potenco, final int ekXo, final int ekYo) {
		super(1, Konstantj.ITENER_SON_MISIL);
		angleRad = Math.toRadians(ekangulo);
		ACCELERATION = new Point2D.Double(QefObjektj.map.ventn(), -9.81 * 0.1);
		potenc = Math.sqrt(potenco)*6;
		setXn(ekXo);
		setYn(ekYo + 8);
		nunrapidec = AffineTransform.getRotateInstance(angleRad).transform(new Point2D.Double(1, 0), null);
		nunrapidec.setLocation(-nunrapidec.getX() * potenc * 0.5, nunrapidec.getY() * potenc * 0.5);
		rapidecX = nunrapidec.getX();
		rapidecY = nunrapidec.getY();
		prevTime = System.nanoTime();
	}

	@Override
	public void gxisdatig() {
		if(yn() >= QefObjektj.map.yn()[(int) xn()] && yn()>0)
			executShotn();
		if(yn() >= QefObjektj.map.yn()[(int) xn()] && yn()>0)
			executShotn();
		else {
			Vicperant.nunludantn().m = null;
			exploci();
			Vicperant.venontNunLudantn(xn());
		}
	}
	@Override
	public void desegn() {
		DebugDesegn.desegnOval((int) Kvantperant.koordenadXalekranPosicin(xn()),
				(int) Kvantperant.koordenadYalekranPosicin(yn()), 3, 3, Color.BLACK);
	}
	
	public int[] atingecn () {
		ArrayDeque<Integer> punkt = new ArrayDeque<>();
		int i = 0;
		int nunx, nuny;
		final double vent;
		if(angleRad > mlplejmargexnErar && angleRad <plejmargexnErar)
			vent = 0;
		else
			vent = Math.random()/10-0.05;
		
		do {
			
			nunx = (int) xn();
			nuny = (int) yn();
			punkt.add(nunx);
			punkt.add(nuny);
			executShotn(1.3/200*potenc, vent);
			e:
			while(nunx == (int) xn() && nuny == (int) yn()) {
				executShotn(1.3/200*potenc, vent);
				if(i++>60)
					break e;
			}
		} while(rapidecY > 0 && nuny >= QefObjektj.map.yn(nunx));
		int[] punktj = new int[punkt.size()];
		for(int j = 0; j < punktj.length; j++)
			punktj[j] = punkt.poll();
		
		return punktj;
	}
	
	private void executShotn(final double rapidec, final double vent) {
		kalkulRapidec(rapidec, vent, ACCELERATION.getY());
		atingecMov(rapidec);
	}
	
	private void executShotn() {
		final long currentTime = System.nanoTime();
		final double dt = Konstantj.MISILRAPIDEC * (currentTime - prevTime) / 1e8;
		kalkulRapidec(dt, ACCELERATION.getX(), ACCELERATION.getY());
		mov(dt);
		
		prevTime = currentTime;
	}
	
	private void kalkulRapidec(final double dt, final double accelerationX, final double accelerationY) {
		rapidecX = scaleAddAssign(rapidecX, dt, accelerationX);
		rapidecY = scaleAddAssign(rapidecY, dt, accelerationY);
	}
	private void mov(final double dt) {
		setXn(scaleAddAssign(xn(), dt, rapidecX));
		setYn(scaleAddAssign(yn(), dt, rapidecY));
	}
	
	private void atingecMov(final double dt) {
		setSenmidifXn(scaleAddAssign(xn(), dt, rapidecX));
		setSenmidifYn(scaleAddAssign(yn(), dt, rapidecY));
	}
	
	private static double scaleAddAssign(final double x, final double faktor, final double aldon) {
		return (x + faktor * aldon);
	}
	
	public void exploci() {
		
		for(int i = -komencDamagxX; i < komencDamagxX; i++) {
			QefObjektj.map.setYn((int) xn() + i, QefObjektj.map.yn((int) xn() + i) -
					Math.sin(Math.PI*(i+komencDamagxX)/damagx)*damagxX);
		}
		QefObjektj.map.setQmodifitn(true);
	}
	
}
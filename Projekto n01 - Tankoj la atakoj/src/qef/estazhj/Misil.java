package qef.estazhj;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;

public class Misil extends Vivazh {
	
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
		potenc = Math.sqrt(potenco) * 10;
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
		if(yn() >= QefObjektj.map.yn()[(int) xn()])
			executShotn(Konstantj.MISILRAPIDEC);
		if(yn() >= QefObjektj.map.yn()[(int) xn()])
			executShotn(Konstantj.MISILRAPIDEC);
		else {
			Vicperant.venontNunLudantn();
			Vicperant.ludantj[Vicperant.nunLudantn()].m = null;
		}
	}
	@Override
	public void desegn() {
		DebugDesegn.desegnOval((int) Kvantperant.koordenadXalekranPosicin(xn()),
				(int) Kvantperant.koordenadYalekranPosicin(yn()), 3, 3, Color.BLACK);
	}
	
	public int[] atingecn () {
		int[] punkt = new int[5000];
		int i = 0;
		do {
			punkt[0 + i*2] = (int) xn();
			punkt[1 + i*2] = (int) yn();
			executShotn(Konstantj.MISILRAPIDEC*2);
			while(punkt[0 + i*2] == (int) xn() && punkt[1 + i*2] == (int) yn()) {
				executShotn(Konstantj.MISILRAPIDEC*2);
			}
			i++;
		} while(rapidecY > 0 && yn() >= QefObjektj.map.yn()[(int) xn()]);
		
		
		return punkt;
	}
	
	private void executShotn(final double rapidec) {
		final long currentTime = System.nanoTime();
		final double dt = rapidec * (currentTime - prevTime) / 1e8;
		kalkulRapidec(dt);
		mov(dt);
		
		prevTime = currentTime;
	}
	
	private void kalkulRapidec(final double dt) {
		rapidecX = scaleAddAssign(rapidecX, dt, ACCELERATION.getX());
		rapidecY = scaleAddAssign(rapidecY, dt, ACCELERATION.getY());
	}
	private void mov(final double dt) {
		setXn(scaleAddAssign(xn(), dt, rapidecX));
		setYn(scaleAddAssign(yn(), dt, rapidecY));
	}
	
	private static double scaleAddAssign(final double x, final double faktor, final double aldon) {
		return (x + faktor * aldon);
	}
}
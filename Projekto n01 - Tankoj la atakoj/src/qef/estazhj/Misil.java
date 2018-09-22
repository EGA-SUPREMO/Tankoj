package qef.estazhj;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;

public class Misil extends Vivazh {
	
	private int aerTemp;
	private double angleRad;
	private double potenc;
	private final Point2D ACCELERATION = new Point2D.Double(QefObjektj.map.ventn(), -9.81 * 0.1);
	private Point2D nunrapidec;
	long prevTime;
	public Misil(final int ekangulo, final int potenco, final int ekXo, final int ekYo) {
		super(1, Konstantj.ITENER_SON_MISIL);
		angleRad = Math.toRadians(ekangulo);
		potenc = potenco;
		setXn(ekXo);
		setYn(ekYo);
		nunrapidec = AffineTransform.getRotateInstance(angleRad).transform(new Point2D.Double(1, 0), null);
		nunrapidec.setLocation(-nunrapidec.getX() * potenc * 0.5, nunrapidec.getY() * potenc * 0.5);
		rapidecX = nunrapidec.getX();
		rapidecY = nunrapidec.getY();
		prevTime = System.nanoTime();
	}

	@Override
	public void gxisdatig() {
		executShotn();
		kalkuliRapidecn();
		mov();
	}

	private void kalkuliRapidecn() {
	}
	
	private void mov() {
		
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnOval((int) Kvantperant.koordenadXalekranPosicin(xn()),
				(int) -yn() + QefObjektj.map.offsetMap, 3, 3, Color.BLACK);
	}
	
	private void executShotn() {
		if(yn() >= QefObjektj.map.yn()[(int) xn()]) {
            long currentTime = System.nanoTime();
            double dt = 1 * (currentTime - prevTime) / 1e8;
			//final double dt = aerTemp++/Konstantj.MISILRAPIDEC;
			rapidecX = scaleAddAssign(rapidecX, dt, ACCELERATION.getX());
			rapidecY = scaleAddAssign(rapidecY, dt, ACCELERATION.getY());
			setXn(scaleAddAssign(xn(), dt, rapidecX));
			setYn(scaleAddAssign(yn(), dt, rapidecY));
            prevTime = currentTime;
		} else {
			//Vicperant.ludantj[Vicperant.nunLudantn()].m = null;
		}
	}
	
	private static double scaleAddAssign(final double x, final double faktor, final double aldon) {
		return (x + faktor * aldon);
	}
}
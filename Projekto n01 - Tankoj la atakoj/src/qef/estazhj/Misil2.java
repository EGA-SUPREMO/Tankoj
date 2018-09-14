package qef.estazhj;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;

public class Misil2 extends Vivazh {//TODO Misilo devas esti subklaso de Vivazh
	
	private int aerTemp;
	private double angleRad;
	private double potenc = 50;
	private final Point2D posici;
	private final Point2D rapidec;
	
	public Misil2(final int ekangulo, final int potenco, final int ekXo, final int ekYo) {
		angleRad = Math.toRadians(ekangulo);
		potenc = potenco;
		posici = new Point2D.Double(ekXo, ekYo);
		rapidec = new Point2D.Double();
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
		DebugDesegn.desegnBildn(Konstantj.MISILSPRITE, (int) Kvantperant.koordenadXalekranPosicin(posici.getX()),
				(int) -posici.getY() + QefObjektj.map.offsetMap);
	}
	
	private final Point2D ACCELERATION = new Point2D.Double(0, -9.81 * 0.1);
	
	private void executShotn() {
		Point2D nunrapidec = AffineTransform.getRotateInstance(angleRad).transform(new Point2D.Double(1,0), null);
		nunrapidec.setLocation(nunrapidec.getX() * potenc * 0.5, nunrapidec.getY() * potenc * 0.5);
		rapidec.setLocation(nunrapidec);
		
		if(posici.getY() >= QefObjektj.map.yn((int) posici.getX())) {
		//	final double dt = aerTemp++/Konstantj.MISILRAPIDEC;
		//	rapidec.setLocation(scaleAddAssign(rapidec, dt, ACCELERATION));
		//	posici.setLocation(scaleAddAssign(posici, dt, rapidec));
		}
	}
	
	//private static Point2D scaleAddAssign(Point2D rezult, double faktor, Point2D addend) {
	//	double x = rezult.getX() + faktor * addend.getX();////////////
	//	double y = rezult.getY() + faktor * addend.getY();
	//	return new Point2D.Double(x, y);
	//}
}
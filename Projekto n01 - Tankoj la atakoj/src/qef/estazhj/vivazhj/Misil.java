package qef.estazhj.vivazhj;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;

public class Misil extends Vivazh {//TODO Dividu cxi tiun klason en du, unu estas por kalkuli la trajekto kaj la
	//dua "extends" Vivazh kaj nomigxas misil
	
	private final double damagxLargxX;
	private final int komencDamagxX;
	private final int damagxaltec;
	private final double grandec;
	private double ekangul;
	private double potenc;
	private final Point2D ACCELERATION;
	private Point2D nunrapidec;
	long prevTime;
	private final int mlplejY;
	
	public Misil(final int ekangulo, final int potenco, final int damagxo, final double ekXo, final double ekYo) {
		super(1, damagxo, Konstantj.ITENER_SON_MISIL);
		
		grandec = Math.sqrt(damagx);
		
		damagxLargxX = damagx;
		komencDamagxX = (int) (damagxLargxX/2);
		damagxaltec = (int) (damagxLargxX/grandec*4);
		
		mlplejY =  QefObjektj.map.altMap - (int) (damagxLargxX);
		
		ekangul = Math.toRadians(ekangulo);
		ACCELERATION = new Point2D.Double(QefObjektj.map.ventn(), -9.81 * 0.1);
		potenc = Math.sqrt(potenco)*6;
		setXn(ekXo);
		setYn(ekYo + 8);
		nunrapidec = AffineTransform.getRotateInstance(ekangul).transform(new Point2D.Double(1, 0), null);
		nunrapidec.setLocation(-nunrapidec.getX() * potenc * 0.5, nunrapidec.getY() * potenc * 0.5);
		rapidecX = nunrapidec.getX();
		rapidecY = nunrapidec.getY();
		prevTime = System.nanoTime();
	}

	@Override
	public void gxisdatig() {
		if(yn() >= QefObjektj.map.yn()[(int) xn()] && yn()<mlplejY)
			executShotn();
		if(yn() >= QefObjektj.map.yn()[(int) xn()] && yn()<mlplejY)
			executShotn();
		else {
			Vicperant.nunludantn().m = null;
			exploci();
			for(int i = 0; i < Vicperant.ludantj.length; i++)
				Vicperant.ludantj[i].setYn(QefObjektj.map.yn()[(int) Vicperant.ludantj[i].xn()]);
			Vicperant.venontNunLudantn(xn());
		}
	}
	@Override
	public void desegn() {
		DebugDesegn.desegnOval((int) Kvantperant.koordenadXalekranPosicin(xn()),
				(int) Kvantperant.koordenadYalekranPosicin(yn()), (int) grandec, (int) grandec, Color.BLACK);
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
	
	protected static double scaleAddAssign(final double x, final double faktor, final double aldon) {
		return (x + faktor * aldon);
	}
	
	public void exploci() {
		for(int i = -komencDamagxX; i < komencDamagxX; i++)
			QefObjektj.map.setYn((int) xn() + i, QefObjektj.map.yn((int) xn() + i) -
					Math.sin(Math.PI*(i+komencDamagxX)/damagxLargxX)*damagxaltec);
		
		for(int i = 0; i < Vicperant.ludantj.length; i++)
			if(xn()-komencDamagxX<Vicperant.ludantj[i].xn() - (Vicperant.ludantj[i].largxVivazhn()>>1)
					&& xn()+komencDamagxX>Vicperant.ludantj[i].xn() - (Vicperant.ludantj[i].largxVivazhn()>>1) ||
					xn()-komencDamagxX<Vicperant.ludantj[i].xn() + (Vicperant.ludantj[i].largxVivazhn()>>1)
					&& xn()+komencDamagxX>Vicperant.ludantj[i].xn() + (Vicperant.ludantj[i].largxVivazhn()>>1))
				for(int x = -komencDamagxX; x < komencDamagxX; x++)
					//if()
						Vicperant.ludantj[i].mlgajnVivn(Math.sin(Math.PI*(x+komencDamagxX)/damagxLargxX)*2);
	}
	
}
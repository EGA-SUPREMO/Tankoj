package qef.estazhj;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;

public class Misil implements Estazh {
	
	private double xEkangul, yEkangul;
	private int potenc;
	private double x, y;
	private static final int PLEJPOTENC = 100;
	private static final int GRAVIT = 30;
	private int aereTemp;
	private double xRapidec, yRapidec;
	
	public Misil(final int ekangulo, final int potenco, final int ekXo, final int ekYo) {
		xEkangul = Math.cos(ekangulo);
		yEkangul = Math.sin(ekangulo);
		potenc = potenco;
		x = ekXo;
		y = ekYo;
		aereTemp = 0;
	}

	@Override
	public void gxisdatig() {executeShot();
		kalkuliRapidecn();
		mov();
		qatingis();
	}

	private void kalkuliRapidecn() {
		
		xRapidec = (potenc/PLEJPOTENC) - aereTemp*xEkangul;
		yRapidec = ((potenc - GRAVIT)/PLEJPOTENC - aereTemp)*yEkangul;
		//rapidec.y = (potenc - aereTemp)*ekangul/PLEJPONTENC;
		aereTemp++;
	}
	
	private void mov() {
		x += xRapidec;
		y -= yRapidec;
	}
	
	private void qatingis() {
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnBildn(Konstantj.MISILSPRITE, (int) Kvantperant.koordenadXalekranPosicin(x),
				(int) y + QefObjektj.map.offsetMap);
	}
	
    private double angleRad = Math.toRadians(45);
    private double power = 50;
    private final Point2D ACCELERATION = new Point2D.Double(0, -9.81 * 0.1);

    private final Point2D position = new Point2D.Double();
    private final Point2D velocity = new Point2D.Double();
    

    private void executeShot()
    {

        Point2D velocity = 
            AffineTransform.getRotateInstance(angleRad).
                transform(new Point2D.Double(1,0), null);
        velocity.setLocation(
            velocity.getX() * power * 0.5, 
            velocity.getY() * power * 0.5);
        this.velocity.setLocation(velocity);

        long prevTime = System.nanoTime();
        while (position.getY() >= 0)
        {
            long currentTime = System.nanoTime();
            double dt = 3 * (currentTime - prevTime) / 1e8;
            performTimeStep(dt);

            prevTime = currentTime;
        }
    }

    void performTimeStep(double dt)
    {
        scaleAddAssign(velocity, dt, ACCELERATION);
        scaleAddAssign(position, dt, velocity);
    }

    private void scaleAddAssign(
        Point2D result, double factor, Point2D addend)
    {
        double x = result.getX() + factor * addend.getX();
        double y = result.getY() + factor * addend.getY();
        result.setLocation(x, y);
    }

	
}
package qef.estazhj.vivazhj.misil;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;

public class Misil extends Vivazh {
	
	protected final double damagxLargxX;
	protected final int komencDamagxX;
	protected final int damagxaltec;
	protected final int grandec;
	public final KalkuliTrajektn trajekt;
	public final int ludant;
	protected final Rectangle[] kolicij;
	private boolean qeliris;
	private final Color kolor;

	public Misil(final int ekangulo, final int potenco, final int damagxo, final double ekXo, final double ekYo,
			final Color koloro) {
		super(1, damagxo, Konstantj.ITENER_SON_MISIL);
		
		grandec = (int) Math.sqrt(damagx);
		largxVivazh = grandec;
		altVivazh = grandec;
		
		damagxLargxX = damagx;
		komencDamagxX = (int) (damagxLargxX/2);
		damagxaltec = (int) (damagx*0.7 * QefObjektj.map.mldurec);
		ludant = Vicperant.nunLudantn();
		kolor = koloro;
		
		setXn(ekXo);
		setYn(ekYo);
		
		trajekt = new KalkuliTrajektn(this, QefObjektj.map.ventn(), ekangulo, potenco);
		
		qeliris = false;
		kolicij = new Rectangle[Vicperant.ludantj.length];
		for(int i = 0; i < Vicperant.ludantj.length; i++)
			kolicij[i] = Vicperant.ludantj[i].nunposiciare();
	}
	
	public Misil(final KalkuliTrajektn trajekto,final int damagxo, final double ekXo, final double ekYo,
			final Color koloro) {
		super(1, damagxo, Konstantj.ITENER_SON_MISIL);
		
		grandec = (int) Math.sqrt(damagx);
		largxVivazh = grandec;
		altVivazh = grandec;
		
		damagxLargxX = damagx;
		komencDamagxX = (int) (damagxLargxX/2);
		damagxaltec = (int) (damagx*0.7 * QefObjektj.map.mldurec);
		ludant = Vicperant.nunLudantn();
		kolor = koloro;
		
		setXn(ekXo);
		setYn(ekYo);
		
		trajekt = trajekto;
		
		qeliris = false;
		kolicij = new Rectangle[Vicperant.ludantj.length];
		for(int i = 0; i < Vicperant.ludantj.length; i++)
			kolicij[i] = Vicperant.ludantj[i].nunposiciare();
	}

	@Override
	public void gxisdatig() {
		for(int i = 0; i < 10; i++)
			if(yn() >= (QefObjektj.map.yn()[(int) xn()] + (grandec>>1)) && qnekolici()) {
				trajekt.executShotn();
			} else {
				exploci();
				
				for(int j = 0; j < Vicperant.ludantj.length; j++)
					Vicperant.ludantj[j].setYn(QefObjektj.map.yn()[(int) Vicperant.ludantj[j].xn()]);
				break;
			}
	}
	private boolean qnekolici() {
		final Rectangle misilR = new Rectangle((int) xn(), (int) yn(), grandec, grandec);
		for(int i = 0; i < kolicij.length; i++) {
			System.out.println(kolicij[i].x + " - " + kolicij[i].y + " - " + kolicij[i].width + " - " +
					kolicij[i].height);
			System.out.println(((int) xn()) + " - " + ((int) yn()) + " - " + grandec);
			System.out.println(kolicij[i].intersects(misilR));
			if(kolicij[i].intersects(misilR)) {
				System.out.println(kolicij[i].x + " - " + kolicij[i].y + " - " + kolicij[i].width + " - " +
						kolicij[i].height);
				System.out.println(((int) xn()) + " - " + ((int) yn()) + " - " + grandec);
				if(Vicperant.ludantj[i].vivn()>0) {
					System.out.println("Chocoo");
					if(i==ludant) {
						return !qeliris;
					} else
						return false;
				}
			} else if(i==ludant)
				qeliris = true;
		}
		return true;
	}

	@Override
	public void desegn() {
		DebugDesegn.desegnOval((int) Kvantperant.koordenadXalekranPosicin(xn()),
				(int) Kvantperant.koordenadYalekranPosicin(yn()), grandec, grandec, kolor);
	}
	
	public void exploci() {
		mlkonstruMapn();
		mlgajnVivDeludantj();
		venontVicn();
	}
	
	protected void mlkonstruMapn() {
		for(int i = -komencDamagxX; i < komencDamagxX; i++)
			QefObjektj.map.setYn((int) xn() + i, QefObjektj.map.yn((int) xn() + i) -
					Math.sin(Math.PI*(i+komencDamagxX)/damagxLargxX)*damagxaltec);
	}
	
	protected void mlgajnVivDeludantj() {
		for(int i = 0; i < Vicperant.ludantj.length; i++) {
			double distanc = Kvantperant.kakulDistancn((int) xn(), (int) yn(),
					(int) Vicperant.ludantj[i].xn(), (int) Vicperant.ludantj[i].yn());
			final double dudistanc = QefObjektj.map.yn().length - distanc;
			
			distanc = distanc<dudistanc? distanc: dudistanc;
			
			final double damagxX = damagxLargxX + (Vicperant.ludantj[i].largxVivazhn()>>1);
			
			if(distanc <= damagxX) {
				final double potenc = (damagxX - distanc)/damagxX;
				Vicperant.ludantj[i].mlgajnVivn(Math.pow(potenc*damagx, 2)/(damagx*damagx)*damagx, damagx, ludant);
			}
			
		}
	}
	protected void venontVicn() {
		Vicperant.setNunMisiln(null);
		Vicperant.venontNunLudantn();
	}
	
}
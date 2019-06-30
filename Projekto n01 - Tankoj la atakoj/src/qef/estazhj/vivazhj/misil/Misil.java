package qef.estazhj.vivazhj.misil;

import java.awt.Color;

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
	
	public Misil(final int ekangulo, final int potenco, final int damagxo, final double ekXo, final double ekYo) {
		super(1, damagxo, Konstantj.ITENER_SON_MISIL);
		
		grandec = (int) Math.sqrt(damagx);
		
		damagxLargxX = damagx;
		komencDamagxX = (int) (damagxLargxX/2);
		//damagxaltec = (int) (damagxLargxX*Math.sqrt(damagxLargxX)/grandec);
		damagxaltec = (int) (damagx*0.7 * QefObjektj.map.mldurec);
		
		//mlplejY =  QefObjektj.map.altMap - (int) (damagxLargxX);
		setXn(ekXo);
		setYn(ekYo + 10);
		
		trajekt = new KalkuliTrajektn(this, QefObjektj.map.ventn(), ekangulo, potenco);
		
	}

	@Override
	public void gxisdatig() {
		for(int i = 0; i < 10; i++)
			if(yn() >= QefObjektj.map.yn()[(int) xn()]) {
				trajekt.executShotn();
			} else {
				exploci();
				
				for(int j = 0; j < Vicperant.ludantj.length; j++)
					Vicperant.ludantj[j].setYn(QefObjektj.map.yn()[(int) Vicperant.ludantj[j].xn()]);
				break;
			}
	}
	@Override
	public void desegn() {
		DebugDesegn.desegnOval((int) Kvantperant.koordenadXalekranPosicin(xn()),
				(int) Kvantperant.koordenadYalekranPosicin(yn()), grandec, grandec, Color.BLACK);
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
				Vicperant.ludantj[i].mlgajnVivn(Math.pow(potenc*damagx, 2)/(damagx*damagx)*damagx);
				System.out.println(Math.pow(potenc*damagx, 2)/(damagx*damagx)*damagx + " - " + distanc + " - " + i);
			}
			
		}
	}
	protected void venontVicn() {
		Vicperant.setNunMisiln(null);
		Vicperant.venontNunLudantn();
	}
	
}
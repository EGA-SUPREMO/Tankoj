package qef.estazhj.vivazhj;

import java.awt.Color;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;

public class Misil extends Vivazh {
	
	private final double damagxLargxX;
	private final int komencDamagxX;
	private final int damagxaltec;
	private final double grandec;
	private final int mlplejY;
	public final KalkuliTrajektn trajekt;
	
	public Misil(final int ekangulo, final int potenco, final int damagxo, final double ekXo, final double ekYo) {
		super(1, damagxo, Konstantj.ITENER_SON_MISIL);
		
		grandec = Math.sqrt(damagx);
		
		damagxLargxX = damagx;
		komencDamagxX = (int) (damagxLargxX/2);
		//damagxaltec = (int) (damagxLargxX*Math.sqrt(damagxLargxX)/grandec);
		damagxaltec = (int) (damagx*0.7);
		
		mlplejY =  QefObjektj.map.altMap - (int) (damagxLargxX);
		
		setXn(ekXo);
		setYn(ekYo + 8);
		
		trajekt = new KalkuliTrajektn(this, QefObjektj.map.ventn(), ekangulo, potenco);
		
	}

	@Override
	public void gxisdatig() {
		if(yn() >= QefObjektj.map.yn()[(int) xn()] && yn()<mlplejY)
			trajekt.executShotn();
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
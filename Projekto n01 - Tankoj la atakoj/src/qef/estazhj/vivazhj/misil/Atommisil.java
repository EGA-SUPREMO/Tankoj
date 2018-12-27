package qef.estazhj.vivazhj.misil;

import java.awt.Transparency;

import qef.Konstantj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.YargxilAzhj;

public class Atommisil extends Misil {
	
	private int nunAngul;
	private double antawX, antawY;
	
	public Atommisil(final int ekangulo, final int potenco, final int damagxo, final double ekXo, final double ekYo) {
		super(ekangulo, potenco, damagxo, ekXo, ekYo);
		if(Konstantj.ATOMMISILSPRITE[0] == null) {
			Konstantj.ATOMMISILSPRITE[0] = YargxilAzhj.yargxSkalitBildn(Konstantj.ITENER_ATOMMISIL + "0.png",
					Transparency.TRANSLUCENT, 23);
			final int duonLong = Konstantj.ATOMMISILSPRITE.length/2;
			for(int i = -duonLong; i < duonLong; i++)
				Konstantj.ATOMMISILSPRITE[i + duonLong] = Bildperant.volvBildn(Konstantj.ATOMMISILSPRITE[0],
						-(Math.PI*2/Konstantj.ATOMMISILSPRITE.length*(i+135)));
			
		}
		nunAngul = ekangulo;
	}
	
	@Override
	public void gxisdatig() {
		antawX = xn();
		antawY = yn();
		super.gxisdatig();
		nunAngul = (int) Math.toDegrees(Math.atan2(antawY - yn(), antawX - xn())) + 180;
		//System.out.println(nunAngul + ": " + (antawY - yn()) + " - " + (antawX - xn()));
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnBildn(Konstantj.ATOMMISILSPRITE[nunAngul],
				(int) Kvantperant.koordenadXalekranPosicin(xn()), (int) Kvantperant.koordenadYalekranPosicin(yn()));
	}
	
}
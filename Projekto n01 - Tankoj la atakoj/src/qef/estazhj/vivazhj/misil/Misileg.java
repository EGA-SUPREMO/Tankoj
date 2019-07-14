package qef.estazhj.vivazhj.misil;

import java.awt.Color;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import qef.Konstantj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.YargxilAzhj;
import qef.kontrolj.Kontrolperant;

public class Misileg extends Misil {
	
	private final int spec;
	private static final int plejspec = 3;
	protected static final BufferedImage[] BILDJ = new BufferedImage[Konstantj.canonAngulnombr * plejspec];
	protected double antawX, antawY;
	
	public Misileg(final int ekangulo, final int potenco, final int damagxo, final double ekXo, final double ekYo,
			final int speco, final int grandec) {
		super(ekangulo, potenco, damagxo, ekXo, ekYo, null);
		
		spec = speco;
		nunBild = ekangulo;
	}
	
	@Override
	public void gxisdatig() {
		antawX = xn();
		antawY = yn();
		super.gxisdatig();
		nunBild = ((int) Math.toDegrees(Math.atan2(antawY - yn(), antawX - xn())) + 180) +
				spec*Konstantj.canonAngulnombr;
	}
	
	@Override
	public void desegn() {//TODO Forigu cxi tion
		try {
			DebugDesegn.desegnBildn(BILDJ[nunBild],
					(int) Kvantperant.koordenadXalekranPosicin(xn() - (BILDJ[nunBild].getWidth()>>1)),
					(int) Kvantperant.koordenadYalekranPosicin(yn() + (BILDJ[nunBild].getHeight()>>1)));
		} catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			DebugDesegn.desegnBildn(BILDJ[0],
					(int) Kvantperant.koordenadXalekranPosicin(xn() - (BILDJ[0].getWidth()>>1)),
					(int) Kvantperant.koordenadYalekranPosicin(yn() + (BILDJ[0].getHeight()>>1)));
		}
		if(Kontrolperant.klavar.debug)
			DebugDesegn.desegnMargxenRectangle(
					(int) Kvantperant.koordenadXalekranPosicin(xn() - (BILDJ[nunBild].getWidth()>>1)),
					(int) Kvantperant.koordenadYalekranPosicin(yn() + (BILDJ[nunBild].getHeight()>>1)),
					BILDJ[nunBild].getWidth(), BILDJ[nunBild].getHeight(), Color.BLUE);
	}
	
	public static void definigadMisiljn() {
		for(int speco = 0; speco < Konstantj.plejnombrspecmisileg; speco++)
			if(BILDJ[0 + speco*Konstantj.canonAngulnombr] == null) {
				BILDJ[0 + speco*Konstantj.canonAngulnombr] = YargxilAzhj.yargxSkalitBildn(Konstantj.ITENER_MISIL + speco +
						".png", Transparency.TRANSLUCENT, Konstantj.misileggrandecj[speco]);
				final int duonLong = (BILDJ.length/plejspec)/2;
				
				for(int i = -duonLong; i < duonLong; i++)
					BILDJ[(i + duonLong) + speco*Konstantj.canonAngulnombr] =
							Bildperant.volvBildn(BILDJ[0 + speco*Konstantj.canonAngulnombr],
							-(Math.PI*2/(BILDJ.length/plejspec)*(i + 135)));//FIXME ERaRO MaLBONa KaJ MISTERIOSO
				
			}
	}
}
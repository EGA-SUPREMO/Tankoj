package qef.estazhj.vivazhj.kampfort;

import java.awt.Color;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import qef.Konstantj;
import qef.estazhj.vivazhj.Ludant;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.YargxilAzhj;

public class Kampfort extends Vivazh implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	final Ludant ludant;
	final Color kolor;
	final BufferedImage bild;
	
	public Kampfort(final int vivo, final Ludant ludanto, final int spec, final String itenerSon) {
		super(1, 1, itenerSon);
		ludant = ludanto;
		kolor = ludant.dukolorn();
		bild = Bildperant.kopiBildn(Konstantj.KAMPFORTBILDJ[spec]);
		Bildperant.yangxTuteKolorjn(bild, kolor);
		largxVivazh = bild.getWidth();
		altVivazh = largxVivazh;
		setPlejvivn(vivo);
		viv = plejvivn();
		
	}
	
	@Override
	public void gxisdatig() {
		setXn(ludant.xn());
		setYn(ludant.yn());
	}
	
	public static void definigadj() {
		for(int i = 0; i < Konstantj.PLEJ_KAMPFORTJ; i++)
			Konstantj.KAMPFORTBILDJ[i] = YargxilAzhj.yargxBildn(Konstantj.ITENER_KAMPFORTJ + i + ".png", Transparency.TRANSLUCENT);
		
	}
	@Override
	public void desegn() {
		DebugDesegn.desegnBildn(bild, (int) Kvantperant.koordenadXalekranPosicin(ludant.xn()) - (largxVivazh>>1) +
				ludant.offsetLudantXn(), (int) Kvantperant.koordenadYalekranPosicin(ludant.yn()) -
				ludant.largxVivazhKolici - (largxVivazh>>1));
	}
	@Override
	public void mlpliVivn(double d) {
		viv -= d;
	}
	
}
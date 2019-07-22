package qef.ilj;

import java.awt.Color;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;

public class Ludantperant {

	public static void definigadj() {
		Ludant[] lj = YargxilAzhj.yargxLudantjn(1 + "i");
		if(lj != null) {
			Vicperant.ludantj = lj;
			
			Vicperant.ordigLudantjnlawMlplejmon();
		} else {
			Vicperant.ludantj = new Ludant[] {new Ludant(1, "EGA", Konstantj.ITENER_SONJ_LUDANT + "pom.wav",
				Color.GREEN, Konstantj.armil, Color.BLUE.brighter()),new Ludant(1, "Oveja",
				Konstantj.ITENER_SONJ_LUDANT + "pom.wav", Color.CYAN.darker(), Konstantj.armil, Color.ORANGE),
				new Ludant(1, "Lo que sea", Konstantj.ITENER_SONJ_LUDANT + "pom.wav", Color.GREEN.darker().darker(),
				Konstantj.armil, Color.MAGENTA.darker()), new Ludant(1, "EGA", Konstantj.ITENER_SONJ_LUDANT + "pom.wav",
				Color.GREEN, Konstantj.armil, Color.BLUE.brighter()),new Ludant(1, "Oveja",
				Konstantj.ITENER_SONJ_LUDANT + "pom.wav", Color.CYAN.darker(), Konstantj.armil, Color.ORANGE),
				new Ludant(1, "Lo que sea", Konstantj.ITENER_SONJ_LUDANT + "pom.wav", Color.GREEN.darker().darker(),
				Konstantj.armil, Color.MAGENTA.darker())};
		}
	}

	public static void teleir() {
		if(Vicperant.nunludantn().teleirazhj>0) {
			Vicperant.nunludantn().teleirazhj--;
			Vicperant.nunludantn().setXn(Kvantperant.koordenadEkranPosicialXn(QefObjektj.superfic.muyn().posicin().x + (Vicperant.nunludantn().largxVivazhn()>>1)));
			Vicperant.nunludantn().setSenmidifYn(Kvantperant.koordenadYalekranPosicin(QefObjektj.superfic.muyn().posicin().y));
			if(Vicperant.nunludantn().nunuzitKampfortn()!=null)
				Vicperant.nunludantn().nunuzitKampfortn().gxisdatig();
			Vicperant.nunludantn().gxisdatig();
			Vicperant.venontNunLudantn();
		}
	}
	
}

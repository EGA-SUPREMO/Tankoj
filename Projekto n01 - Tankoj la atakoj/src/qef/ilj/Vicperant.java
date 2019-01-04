package qef.ilj;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.estazhj.vivazhj.misil.Misil;

public class Vicperant {
	
	private static int nunLudant = 0;
	
	public static Ludant[] ludantj = new Ludant[] {new Ludant(1, Konstantj.ITENER_SONJ_LUDANT + "pom.wav",
			Ludant.ludantsprite0, Ludant.armil), new Ludant(1, Konstantj.ITENER_SONJ_LUDANT + "pom.wav", 
			Ludant.ludantsprite1, Ludant.armil), new Ludant(1, Konstantj.ITENER_SONJ_LUDANT + "pom.wav", 
			Ludant.ludantsprite2, Ludant.armil)};
	private static Misil nunMisil;

	public static int nunLudantn() {
		return nunLudant;
	}
	
	public static Ludant nunludantn() {
		return ludantj[nunLudant];
	}
	
	public static void setNunMisiln(final Misil misil) {
		nunMisil = misil;
	}
	public static Misil nunMisiln() {
		return nunMisil;
	}
	
	public static int venontNunLudantn() {//FIXME
		//Eble a maniero por fix cxi tion estas aldoni booleano en kiu estas true dum presado kaj false...
		//if(Kontrolperant.klavar.qatak)
		if(++nunLudant>=ludantj.length)
			nunLudant = 0;
		QefObjektj.map.venontVicn();
		
		return nunLudant;
	}
	
}
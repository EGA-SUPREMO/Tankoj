package qef.ilj;

import qef.Konstantj;
import qef.estazhj.vivazhj.Ludant;

public class Vicperant {
	
	private static int nunLudant = 0;
	
	public static Ludant[] ludantj = new Ludant[] {new Ludant(1, Konstantj.ITENER_SONJ_LUDANT + "pom.wav",
			Ludant.senarmatludantsprite, Ludant.armil), new Ludant(1, Konstantj.ITENER_SONJ_LUDANT + "pom.wav", 
					Ludant.senarmatludantsprite, Ludant.armil)};

	public static int nunLudantn() {
		return nunLudant;
	}
	
	public static int venontNunLudantn() {//FIXME TRE EGE STRANGAJ ERAROJ KIAM VI PRESOS MULTAJN FOJOJN LA KLAVO ' '
		//Eble a maniero por fix cxi tion estas aldoni booleano en kiu estas true dum presado kaj false...
		//if(Kontrolperant.klavar.qatak)
		if(++nunLudant>=ludantj.length)
			nunLudant = 0;
		
		return nunLudant;
	}
	
}
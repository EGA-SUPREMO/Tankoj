package qef.ilj;

import java.awt.Color;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.estazhj.vivazhj.misil.Misil;

public class Vicperant {
	
	private static int stat = 2;
	private static int neaktivLudantj = 0;
	private static int nunLudant = 0;
	
	public static Ludant[] ludantj = new Ludant[] {new Ludant(1, "EGA", Konstantj.ITENER_SONJ_LUDANT + "pom.wav",
			Color.GREEN.darker(), Ludant.armil), new Ludant(1, "Panchito", Konstantj.ITENER_SONJ_LUDANT + "pom.wav", 
			Color.RED, Ludant.armil), new Ludant(1, "Jaimito", Konstantj.ITENER_SONJ_LUDANT + "pom.wav",
			Color.CYAN.darker(), Ludant.armil)};
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
	public static int neaktivLudantjn() {
		return neaktivLudantj;
	}
	
	public static int venontNunLudantn() {
		if(++nunLudant>=ludantj.length)
			nunLudant = 0;
		qaktivLudant();
		QefObjektj.map.venontVicn();
		
		return nunLudant;
	}
	public static boolean qaktivLudant() {
		for(int i = 0; i < ludantj.length; i++)
			if(ludantj[i].vivn()<=0) {
				neaktivLudantj++;
				
				if(neaktivLudantj<ludantj.length - 1) {
				}else {
					stat = 7;
					nunLudant = i;
					
					neaktivLudantj = 0;
					return false;
				}
			}
		neaktivLudantj = 0;
		return true;
	}

	public static int statn() {
		return stat;
	}
	public static void sesStatn(final int stato) {
		stat = stato;
	}
}
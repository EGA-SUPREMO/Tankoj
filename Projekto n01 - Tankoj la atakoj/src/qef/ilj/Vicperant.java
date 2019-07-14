package qef.ilj;

import java.awt.Color;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.estazhj.vivazhj.misil.Misil;
import qef.map.Map;

public class Vicperant {
	
	private static int stat = 2;
	private static int neaktivLudantj = 0;
	private static int nunLudant = 0;
	
	public static Ludant[] ludantj = new Ludant[] {new Ludant(1, "EGA", Konstantj.ITENER_SONJ_LUDANT + "pom.wav",
			Color.GREEN.darker(), Ludant.armil, Color.BLUE.brighter()),new Ludant(1, "Oveja",
			Konstantj.ITENER_SONJ_LUDANT + "pom.wav", Color.CYAN.darker(), Ludant.armil, Color.ORANGE), //new Ludant(1,
			//"Jaimito", Konstantj.ITENER_SONJ_LUDANT + "pom.wav", Color.CYAN.darker(), Ludant.armil,
			};//Color.MAGENTA.darker())};
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
		if(ludantj[nunLudant].vivn()==0)
			if(qaktivLudant())
				venontNunLudantn();
		
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

	public static void venontLudadn() {
		ordigLudantjnlawMlplejmon();
		yangxMapn();
		revivLudantj();
		stat = 2;
		nunLudant = 0;
		nunMisil = null;
	}

	private static void revivLudantj() {
		for(int i = 0; i < ludantj.length; i++)
			ludantj[i].resetVivn();
		
	}

	private static void yangxMapn() {
		QefObjektj.map = new Map((int) (Math.random()*Konstantj.PLEJ_BIOMJ));
	}

	private static void ordigLudantjnlawMlplejmon() {//TODO sxangxu cxi tion
		Ludant templudant;
		boolean qyang = true;
		boolean qneyang = false;
		int lo = ludantj.length%2 == 0? 1: 2;
		int ii = 0;
		while(qyang && !qneyang && ii < 1) {
			qyang = true;
			qneyang = false;
			
			for(int j = 0; j < lo; j++)
				for(int i = 1 + j; i < ludantj.length; i+=2) {
					if(ludantj[i-1].monn()<ludantj[i].monn()) {
						qneyang = true;
					} else {
						templudant = ludantj[i - 1];
						ludantj[i-1] = ludantj[i];
						ludantj[i] = templudant;
						qyang = true;
					}
				}
			if(qyang && !qneyang)
				ii++;
		}
	}
}
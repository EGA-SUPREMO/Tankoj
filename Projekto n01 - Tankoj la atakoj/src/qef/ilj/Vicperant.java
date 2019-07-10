package qef.ilj;

import java.awt.Color;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.estazhj.vivazhj.misil.Misil;
import qef.map.Map;
import qef.statmayin.statj.butikMenu.ButikMenu;

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
		ButikMenu.q = true;
	}

	private static void revivLudantj() {
		for(int i = 0; i < ludantj.length; i++)
			ludantj[i].resetVivn();
		
	}

	private static void yangxMapn() {
		QefObjektj.map = new Map((int) (Math.random()*Konstantj.PLEJ_BIOMJ));
	}

	private static void ordigLudantjnlawMlplejmon() {//TODO sxangxu cxi tion
		System.out.println(ludantj[0].monn() + " - " + ludantj[0]);
		System.out.println(ludantj[1].monn() + " - " + ludantj[1]);
		System.out.println(ludantj[2].monn() + " - " + ludantj[2]);
		Ludant templudant;
		boolean qyang = true;
		boolean qneyang = false;
		int lo = ludantj.length%2 == 0? 1: 2;
		while(qyang && !qneyang) {
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
					System.out.println(i);
				}
			//if(ludantj.length%2!=0) {
			//	templudantj[ludantj.length - 1] = ludantj[ludantj.length - 1];
			//}
			
		}
		System.out.println(ludantj[0].monn() + " - " + ludantj[0].nomn() + " - " + ludantj[0]);
		System.out.println(ludantj[1].monn() + " - " + ludantj[1].nomn() + " - " + ludantj[1]);
		System.out.println(ludantj[2].monn() + " - " + ludantj[2].nomn() + " - " + ludantj[2]);
		/*if(ludantj.length%2!=0) {
			if(ludantj[ludantj.length-1].monn()<=ludantj[0].monn()) {
				templudantj[0] = ludantj[ludantj.length-1];
				for(int j = 1; j < ludantj.length; j++)
					templudantj[j] = ludantj[j];
				System.out.println("Estube equi");
			} else if(ludantj[ludantj.length-2].monn()<=ludantj[ludantj.length-1].monn()) {
				System.out.println("tmbien Estube equi");
			} else {
				for(int i = 0; i < ludantj.length-1; i++)
					if(ludantj[ludantj.length-1].monn()>ludantj[i].monn() &&
							ludantj[ludantj.length-1].monn()<ludantj[i + 1].monn()) {
						templudantj[i + 1] = ludantj[ludantj.length-1];
						for(int j = i + 1; j < ludantj.length; j++)
							templudantj[j] = ludantj[j + 1];
					}

				System.out.println("y Estube equi");
			}
		}
		ludantj = templudantj;*/
	}
}
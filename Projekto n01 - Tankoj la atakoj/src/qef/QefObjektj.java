package qef;

import qef.grafikj.Superficdesegn;
import qef.map.Map;
import qef.statmayin.Statperant;
import qef.uzantinterfac.map.Malhelec;
import qef.uzantinterfac.suprmenu.Suprmenu;

public class QefObjektj {//Objektoj de la ludoj

	public static Map map = new Map((int) (Math.random()*Konstantj.PLEJ_BIOMJ));
	public static Suprmenu suprmenu;
	public static Malhelec malhelec = new Malhelec();
	public static Superficdesegn superfic = new Superficdesegn();
	public static Statperant statp;
	
}
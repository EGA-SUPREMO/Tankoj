package qef.uzantinterfac.suprmenu;

import java.awt.Color;
import java.awt.Point;

import qef.ilj.DebugDesegn;
import qef.ilj.Vicperant;

public class Verg {
	
	private static final int VERTIKAL_MARGXEN = 4;
	private int MEZUR_VERTIKAL = 4;
	private final static int UNUGRANDEC_VERTIKAL = 11;
	private final static int DUGRANDEC_VERTIKAL = 1;
	private Color kolor, darkKolor;
//	private static int id = 0;
	private static int largx = 180;
	private Point posici;
	private Text text;
	
	public Verg(final Color kolor, final Text text) {
		
		this.kolor = kolor;
		this.darkKolor = kolor.darker();
		this.text = text;
		
		MEZUR_VERTIKAL = (UNUGRANDEC_VERTIKAL + VERTIKAL_MARGXEN)*text.ordinal();
		posici = new Point(Submenu.areXn() + 35, Submenu.areYn() + MEZUR_VERTIKAL + UNUGRANDEC_VERTIKAL + DUGRANDEC_VERTIKAL);
		//setPosicin();
		
	}
	
	public void desegn() {
		desegnVergn();
		desegnTextn();
	}
	
	private void desegnTextn() {
		DebugDesegn.desegnString(text.name(), posici.x - 19, posici.y + 8);
		DebugDesegn.desegnString("" + Vicperant.ludantj[Vicperant.nunLudantn()].potenc, posici.x + largx + 2, posici.y + 8);
	}
	
	private void desegnVergn() {
		DebugDesegn.desegnRectangle(posici.x, posici.y, Vicperant.nunludantn().potenc*largx/text.plejkvantn(), UNUGRANDEC_VERTIKAL, kolor);
		posici.y += UNUGRANDEC_VERTIKAL;
	
		DebugDesegn.desegnRectangle(posici.x, posici.y, Vicperant.nunludantn().potenc*largx/text.plejkvantn(), DUGRANDEC_VERTIKAL, darkKolor);
		posici.y -= UNUGRANDEC_VERTIKAL;
	}
	/*
	private void setPosicin() {
		id++;
		posici.setLocation(QefObjektj.submenu.areXn() + 35, QefObjektj.submenu.areYn() + MEZUR_VERTIKAL << id);
	}*/
	
}
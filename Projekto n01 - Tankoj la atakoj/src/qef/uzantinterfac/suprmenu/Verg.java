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
	
	int i = 0, pleji = 0;
	
	public Verg(final Color kolor, final Text text) {
		
		this.kolor = kolor;
		this.darkKolor = kolor.darker();
		this.text = text;
		
		MEZUR_VERTIKAL = (UNUGRANDEC_VERTIKAL + VERTIKAL_MARGXEN)*text.ordinal();
		posici = new Point(Submenu.areXn() + 35, Submenu.areYn() + MEZUR_VERTIKAL + UNUGRANDEC_VERTIKAL + DUGRANDEC_VERTIKAL);
		//setPosicin();
		if(text.ordinal()==0) {
			i = (int) Vicperant.nunludantn().vivn();
			pleji = 100;
		} else if(text.ordinal()==1) {
			i = Vicperant.nunludantn().nunanguln();
			pleji = 360;
		} else if(text.ordinal()==2) {
			i = Vicperant.nunludantn().potenc;
			pleji = Vicperant.nunludantn().plejpotenc;
		}
	}
	
	public void desegn() {
		desegnVergn();
		desegnTextn();
	}
	
	private void desegnTextn() {
		DebugDesegn.desegnString(text.name(), posici.x - 24, posici.y + 8);
		DebugDesegn.desegnString("" + i, posici.x + largx + 2, posici.y + 8);
	}
	
	private void desegnVergn() {
		if(text.ordinal()==0) {
			i = (int) Vicperant.nunludantn().vivn();
			pleji = 100;
		} else if(text.ordinal()==1) {
			i = Vicperant.nunludantn().nunanguln();
			pleji = 360;
		} else if(text.ordinal()==2) {
			i = Vicperant.nunludantn().potenc;
			pleji = Vicperant.nunludantn().plejpotenc;
		}
		DebugDesegn.desegnRectangle(posici.x, posici.y, i*largx/pleji, UNUGRANDEC_VERTIKAL, kolor);
		posici.y += UNUGRANDEC_VERTIKAL;
	
		DebugDesegn.desegnRectangle(posici.x, posici.y, i*largx/pleji, DUGRANDEC_VERTIKAL, darkKolor);
		posici.y -= UNUGRANDEC_VERTIKAL;
	}
	/*
	private void setPosicin() {
		id++;
		posici.setLocation(QefObjektj.submenu.areXn() + 35, QefObjektj.submenu.areYn() + MEZUR_VERTIKAL << id);
	}*/
	
}
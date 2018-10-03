package qef.uzantinterfac;

import java.awt.Color;
import java.awt.Point;

import qef.ilj.DebugDesegn;
import qef.ilj.Vicperant;

public class Verg {

	private int MEZUR_VERTIKAL = 4;
	private final static int GRANDEC_VERTIKAL = 4;
	private Color kolor, darkKolor;
//	private static int id = 0;
	private static int largx = 100;
	private Point posici;
	private Text text;
	
	public Verg(final Color kolor, final Text text) {
		
		this.kolor = kolor;
		this.darkKolor = kolor.darker();
		this.text = text;
		
		MEZUR_VERTIKAL = GRANDEC_VERTIKAL * (text.ordinal() * 4);
		posici = new Point(Submenu.areXn() + 35, Submenu.areYn() + MEZUR_VERTIKAL + GRANDEC_VERTIKAL);
		//setPosicin();
		
	}
	
	public void desegn() {
		desegnVergn();
		desegnTextn();
	}
	
	private void desegnTextn() {
		DebugDesegn.desegnString(text.name(), posici.x - 19, posici.y + 8);
		if(text.name()=="ATK")
			DebugDesegn.desegnString("" + Vicperant.ludantj[Vicperant.nunLudantn()].potenc, posici.x + 102, posici.y + 8);
		else if(text.name()=="ANG")
			DebugDesegn.desegnString("" + Vicperant.ludantj[Vicperant.nunLudantn()].nunanguln(), posici.x + 102, posici.y + 8);
		else if(text.name()=="VIV")
			DebugDesegn.desegnString(String.format("%.2f", Vicperant.ludantj[Vicperant.nunLudantn()].vivn()), posici.x + 102, posici.y + 8);
		else
			DebugDesegn.desegnString("" + text.kvantn(), posici.x + 102, posici.y + 8);
	}
	
	private void desegnVergn() {

		if(text.name()=="ATK") {
			DebugDesegn.desegnRectangle(posici.x, posici.y, Vicperant.ludantj[Vicperant.nunLudantn()].potenc * largx / text.plejkvantn(), GRANDEC_VERTIKAL, kolor);
		
			posici.y += GRANDEC_VERTIKAL;
		
			DebugDesegn.desegnRectangle(posici.x, posici.y, Vicperant.ludantj[Vicperant.nunLudantn()].potenc * largx / text.plejkvantn(), GRANDEC_VERTIKAL, darkKolor);
		
			posici.y -= GRANDEC_VERTIKAL;
		} else if(text.name()=="ANG") {
			final int angul = Vicperant.ludantj[Vicperant.nunLudantn()].nunanguln() - Vicperant.ludantj[Vicperant.nunLudantn()].mlplejangul;
			DebugDesegn.desegnRectangle(posici.x, posici.y, angul * largx / text.plejkvantn(), GRANDEC_VERTIKAL, kolor);
			
			posici.y += GRANDEC_VERTIKAL;
			
			DebugDesegn.desegnRectangle(posici.x, posici.y, angul * largx / text.plejkvantn(), GRANDEC_VERTIKAL, darkKolor);

			posici.y -= GRANDEC_VERTIKAL;
		} else if(text.name()=="VIV") {
			DebugDesegn.desegnRectangle(posici.x, posici.y, (int)(Vicperant.ludantj[Vicperant.nunLudantn()].vivn() * largx / text.plejkvantn()), GRANDEC_VERTIKAL, kolor);
			
			posici.y += GRANDEC_VERTIKAL;
			
			DebugDesegn.desegnRectangle(posici.x, posici.y, (int) (Vicperant.ludantj[Vicperant.nunLudantn()].vivn() * largx / text.plejkvantn()), GRANDEC_VERTIKAL, darkKolor);

			posici.y -= GRANDEC_VERTIKAL;
		} else {
			DebugDesegn.desegnRectangle(posici.x, posici.y, text.kvantn() * largx / text.plejkvantn(), GRANDEC_VERTIKAL, kolor);
			
			posici.y += GRANDEC_VERTIKAL;
			
			DebugDesegn.desegnRectangle(posici.x, posici.y, text.kvantn() * largx / text.plejkvantn(), GRANDEC_VERTIKAL, darkKolor);
			
			posici.y -= GRANDEC_VERTIKAL;
		}
		
	}
	/*
	private void setPosicin() {
		id++;
		posici.setLocation(QefObjektj.submenu.areXn() + 35, QefObjektj.submenu.areYn() + MEZUR_VERTIKAL << id);
	}*/
	
}
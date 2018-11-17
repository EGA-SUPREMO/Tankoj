package qef.uzantinterfac;

import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;

public class Buton extends Komponant {
	
	//public static int selektit = 0;
	private int spec;
	public final int unukolor, dukolor;
	
	public Buton(final int xo, final int yo, final int largxo, final int koloro, final int dukoloro,
			final String texto) {
		super(xo, yo, largxo, koloro, texto);
		unukolor = koloro;
		dukolor = dukoloro;
		spec = 0;
	}

	public void yangxKolor() {
		kolor = dukolor;
		qgxisdatig = true;
	}
	public void resetkolorn() {
		if(kolor == dukolor) {
			kolor = unukolor;
			y -= spec*4;
			spec = 0;
			qgxisdatig = true;
		}
	}
	public void setSpec(final int speco) {
		if(speco==1 && spec != speco) {
			y += 4;
			spec = speco;
			qgxisdatig = true;
		}
	}
	public void resetspecn() {
		if(spec == 1) {
			spec = 0;
			y -= 4;
			qgxisdatig = true;
		}
	}
	
	@Override
	public void desegn() {
		if(qgxisdatig) {
			buton = Bildperant.kreButon(largx, kolor, spec, kolor==dukolor ? 1:0, text);
			qgxisdatig = false;
		}
		DebugDesegn.desegnButon(buton, x, y);
	}
	
}
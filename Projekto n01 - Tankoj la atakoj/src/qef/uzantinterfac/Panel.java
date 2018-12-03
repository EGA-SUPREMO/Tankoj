package qef.uzantinterfac;

import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;

public class Panel extends Komponant {

	public final int alt;
	
	public Panel(final int xo, final int yo, final int largxo, final int alto, final int koloro, final String texto) {
		super(xo, yo, largxo, koloro, texto);
		alt = alto;
		definigBildn();
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnKomponantn(bild, x, y);
	}

	@Override
	public void gxisdatig() {
	}

	@Override
	public void definigBildn() {
		if(qgxisdatig) {
			bild = Bildperant.krePaneln(largx, alt, kolor, text);
			qgxisdatig = false;
		}
	}
}
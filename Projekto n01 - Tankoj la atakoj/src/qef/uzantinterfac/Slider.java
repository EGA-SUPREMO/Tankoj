package qef.uzantinterfac;

import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;

public class Slider extends Komponant {
	
	private final int mlplej;
	private int plej;
	
	public Slider(final int xo, final int yo, final int largxo, final int mlplejo, final int plejo,
			final int koloro) {
		super(xo, yo, largxo, koloro, "");
		
		mlplej = mlplejo;
		plej = plejo;
		
	}
	
	@Override
	public void desegn() {
		if(qgxisdatig) {
			bild = Bildperant.kreSlidern(largx, mlplej, plej, kolor);
			qgxisdatig = false;
		}
		DebugDesegn.desegnKomponantn(bild, x, y);
	}
}
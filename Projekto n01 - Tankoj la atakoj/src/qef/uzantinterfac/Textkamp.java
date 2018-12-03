package qef.uzantinterfac;

import qef.Konstantj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;

public class Textkamp extends Komponant {
	
	public Textkamp(final int xo, final int yo, final int largxo, final int spec,
			final String texto) {
		super(xo, yo, largxo, 0, texto);
		definigBildn();
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnKomponantn(bild, x, y);
	}
	
	@Override
	public void gxisdatig() {
		definigBildn();
	}

	@Override
	public void definigBildn() {
		if(qgxisdatig) {
			Konstantj.BUTON_SPRITE[Konstantj.BUTON_SPRITE.length-1] = Konstantj.TEXTKAMP_SPRITE.getSubimage(0, 0,
					Konstantj.TEXTKAMP_SPRITE.getWidth(), Konstantj.TEXTKAMP_SPRITE.getHeight());
			bild = Bildperant.kreButon(largx, Konstantj.BUTON_SPRITE.length-1, 0, 0, "");
			bild = Bildperant.aldonTextn(bild, 0, 0, Konstantj.KOLORJ_BUTON[5], text,
					Konstantj.KUTIM_FONT_BUTON.deriveFont(12f + 2f));
			qgxisdatig = false;
		}
	}
}
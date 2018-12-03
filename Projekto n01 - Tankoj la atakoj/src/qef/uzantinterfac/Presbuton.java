package qef.uzantinterfac;

import java.awt.Font;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.Bildperant;

public class Presbuton extends Buton {
	
	private String text2;
	private Font font;
	
	public Presbuton(final int xo, final int yo, final int largxo, final int koloro, final int dukoloro,
			final Font fonto, final String texto, final String texto2) {
		super(xo, yo, largxo, koloro, dukoloro, -1, texto);
		text2 = texto2;
		font = fonto;
		qgxisdatig = true;
		definigBildn();
	}
	
	@Override
	public void gxisdatig() {
		definigBildn();
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		if(muy.intersects(kolici)) {
			yangxKolor();
			if(QefObjektj.superfic.muyn().qclickn()) {
				setSpec(spec>0? 0 : 1);
			}
		} else if(spec==0)
			resetKolorn();
	}
	
	@Override
	public void definigBildn() {
		if(qgxisdatig) {
			final int qdukolora = kolor==dukolor ? 1:0;
			bild = Bildperant.aldonTextn(Bildperant.kreButon(largx, kolor, spec, qdukolora, ""), 0, (spec>0? 0 : 1)*4,
					Konstantj.KOLORJ_BUTON[(kolor + qdukolora)* qdukolora], spec>0? text2 : text, font);
			qgxisdatig = false;
		}
	}
}
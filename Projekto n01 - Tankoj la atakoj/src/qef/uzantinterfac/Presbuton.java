package qef.uzantinterfac;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.Bildperant;

public class Presbuton extends Buton {
	
	private String text2;
	
	public Presbuton(int xo, int yo, int largxo, int koloro, int dukoloro, String texto, final String texto2) {
		super(xo, yo, largxo, koloro, dukoloro, -1, texto);
		text2 = texto2;
	}
	
	@Override
	public void gxisdatig() {
		if(qgxisdatig) {
			final int qdukolora = kolor==dukolor ? 1:0;
			bild = Bildperant.aldonTextn(Bildperant.kreButon(largx, kolor, spec, qdukolora, ""), 0, (spec>0? 0 : 1)*4,
					Konstantj.KOLORJ_BUTON[(kolor + qdukolora)* qdukolora], spec>0? text2 : text, 16f + 2f);
			qgxisdatig = false;
		}
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		if(muy.intersects(kolici)) {
			yangxKolor();
			if(QefObjektj.superfic.muyn().qclickn()) {
				setSpec(spec>0? 0 : 1);
			}
		} else if(spec==0)
			resetKolorn();
	}
	
}
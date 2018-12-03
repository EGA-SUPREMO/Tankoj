package qef.uzantinterfac;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;

public class Buton extends Komponant {
	
	//public static int selektit = 0;
	protected int spec;
	public final int unukolor, dukolor;
	public int statDeLaMenu;
	public final static int LARGX_BUTON = Konstantj.ludLargx/3;//Konstantj.duonLudLargx;
	public boolean qalt;
	
	public Buton(final int xo, final int yo, final int largxo, final int koloro, final int dukoloro, final int stato,
			final String texto) {
		super(xo, yo, largxo, 2, koloro, texto);
		unukolor = koloro;
		dukolor = dukoloro;
		spec = 0;
		statDeLaMenu = stato;
		alt = Konstantj.KOMENC_MENU_ALT_BUTON;
		kolici = new Rectangle(xo, yo, largxo, alt);
		qalt = false;
		definigBildn();
	}
	public Buton(final int xo, final int yo, final int largxo, final int alto, final int koloro, final int dukoloro, final int stato,
			final String texto) {
		super(xo, yo, largxo, 2, koloro, texto);
		unukolor = koloro;
		dukolor = dukoloro;
		spec = 0;
		statDeLaMenu = stato;
		alt = alto;
		kolici = new Rectangle(xo, yo, largxo, alto);
		qalt = true;
		definigBildn();
	}
	
	public void yangxKolor() {
		if(kolor != dukolor) {
			kolor = dukolor;
			qgxisdatig = true;
		}
	}
	public void resetButonn() {
		if(kolor == dukolor) {
			kolor = unukolor;
			y -= spec*4;
			spec = 0;
			qgxisdatig = true;
		}
	}
	public void setSpec(final int speco) {
		if(spec == speco)
			return;
		if(speco==0) {
			y -= 4;
		}
		if(speco==1) {
			y += 4;
		}
		spec = speco;
		qgxisdatig = true;
	}
	public void resetSpecn() {
		if(spec == 1) {
			spec = 0;
			y -= 4;
			qgxisdatig = true;
		}
	}
	public void resetKolorn() {
		if(kolor == dukolor) {
			kolor = unukolor;
			qgxisdatig = true;
		}
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnKomponantn(bild, x, y);
	}

	@Override
	public void gxisdatig() {
		definigBildn();
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		if(muy.intersects(kolici)) {
			yangxKolor();
			if(QefObjektj.superfic.muyn().qclickn()) {
				setSpec(1);
			}
			
		} else
			resetButonn();
	}
	
	public int specn() {
		return spec;
	}
	@Override
	public void setAltn(final int alto) {
		super.setAltn(alto);
		qalt = true;
	}
	@Override
	public void definigBildn() {
		if(qgxisdatig) {
			
			bild = Bildperant.kreButon(largx, kolor, spec, kolor==dukolor ? 1:0, text);
			if(qalt)
				bild = Bildperant.yangxButonAltn(bild, alt, spec);
			
			aldonAldonayjn(spec);
			qgxisdatig = false;
		}
	}
	
}
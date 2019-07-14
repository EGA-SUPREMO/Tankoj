package qef.estazhj.vivazhj.kampfort;

import java.awt.Color;

import qef.estazhj.vivazhj.Ludant;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;

public class Kampfort extends Vivazh {
	
	final Ludant ludant;
	final Color kolor;
	
	public Kampfort(final int vivo, final Ludant ludanto, final String itenerSon) {
		super(1, 1, itenerSon);
		ludant = ludanto;
		kolor = ludant.dukolorn();
		largxVivazh = ludant.largxVivazhn()*2;
	}
	
	@Override
	public void gxisdatig() {
		setXn(ludant.xn());
		setYn(ludant.yn());
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnCirkl((int) Kvantperant.koordenadXalekranPosicin(xn()) - (largxVivazh>>1) +
				ludant.offsetLudantXn(), (int) Kvantperant.koordenadYalekranPosicin(yn()) -
				ludant.largxVivazhKolici - (largxVivazh>>1), largxVivazh, kolor);
	}
	
}
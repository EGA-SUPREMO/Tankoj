package qef.estazhj.vivazhj.kampfort;

import java.awt.Color;
import java.io.Serializable;

import qef.estazhj.vivazhj.Ludant;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;

public class Kampfort extends Vivazh implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	final Ludant ludant;
	final Color kolor;
	
	public Kampfort(final int vivo, final Ludant ludanto, final String itenerSon) {
		super(1, 1, itenerSon);
		ludant = ludanto;
		kolor = ludant.dukolorn();
		largxVivazh = ludant.largxVivazhn()*2;
		altVivazh = largxVivazh;
	}
	
	@Override
	public void gxisdatig() {
		setXn(ludant.xn());
		setYn(ludant.yn());
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnCirkl((int) Kvantperant.koordenadXalekranPosicin(ludant.xn()) - (largxVivazh>>1) +
				ludant.offsetLudantXn(), (int) Kvantperant.koordenadYalekranPosicin(ludant.yn()) -
				ludant.largxVivazhKolici - (largxVivazh>>1), largxVivazh, kolor);
	}
	
}
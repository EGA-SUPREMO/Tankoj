package qef.estazhj;

import java.awt.Point;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;

public class Misil implements Estazh {
	
	private int ekangul;
	private int potenc;
	private int x, y, ekX, ekY;
	private static final int PLEJPONTENC = 100;
	private static final int GRAVIT = 30;
	private int aereTemp;
	
	public Misil(final int ekangulo, final int potenco, final int ekXo, final int ekYo) {
		ekangul = ekangulo-90;
		potenc = potenco;
		ekX = ekXo;
		ekY = ekYo;
		x = ekX;
		y = ekY;
		aereTemp = 0;
	}

	@Override
	public void gxisdatig() {
		mov(kalkuliRapidecn());
		qatingis();
	}

	private Point kalkuliRapidecn() {
		Point rapidec = new Point();
		//FIXME cxi tiu funkcia se la la angulo estas inter 0 kaj 90

		rapidec.x = (potenc - aereTemp)*ekangul/PLEJPONTENC;
		rapidec.y = (potenc - GRAVIT - aereTemp)*ekangul/PLEJPONTENC;
		//rapidec.y = (potenc - aereTemp)*ekangul/PLEJPONTENC;
		aereTemp++;
		return rapidec;
	}
	
	private void mov(final Point rapidec) {
		x += rapidec.x;
		y += rapidec.y;
	}
	
	private void qatingis() {
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnBildn(Konstantj.MISILSPRITE, (int) Kvantperant.koordenadXalekranPosicin(x),
				y + QefObjektj.map.offsetMap);
	}
	
}
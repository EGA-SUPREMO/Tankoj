package qef.estazhj;

import java.awt.Point;

import javax.swing.JOptionPane;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;

public class Misil implements Estazh {//TODO Misilo devas esti subklaso de Vivazh
	
	private int ekangul;
	private int potenc;
	private static int id = 0;
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
		if(id++==17) {
			JOptionPane.showMessageDialog(null, "java.lang.IllegalArgumentException: Master Gain not supported" +
			"\n        at org.classpath.icedtea.pulseaudio.PulseAudioLine.getControl(PulseAudioLine.java:89)"  +
			"\n        at org.classpath.icedtea.pulseaudio.PulseAudioClip.getControl(PulseAudioClip.java:53)"  +
			"\n        at qef.ilj.YargxilAzhj.yargxSonn(YargxilAzhj.java:164)"                                 +
			"\n        at qef.son.Son.<init>(Son.java:13)"                                                     +
			"\n        at qef.inventar.armil.Armil.<init>(Armil.java:40)"                                      +
			"\n        at qef.inventar.armil.Pistol.<init>(Pistol.java:16)"                                    +
			"\n        at qef.inventar.Objektregistril.objektjn(Objektregistril.java:30)"                      +
			"\n        at qef.inventar.Inventar.<init>(Inventar.java:14)"                                      +
			"\n        at qef.QefObjektj.<clinit>(QefObjektj.java:19)"                                         +
			"\n        at qef.grafikj.Fenestr.agordFenestrn(Fenestr.java:42)"                                  +
			"\n        at qef.grafikj.Fenestr.<init>(Fenestr.java:30)"                                         +
			"\n        at qef.Qefperant.definigad(Qefperant.java:56)"                                          +
			"\n        at qef.Qefperant.ekLudn(Qefperant.java:50)"                                             +
			"\n        at qef.Qefperant.main(Qefperant.java:29)", "Error", 3);
			while(true);
		}
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
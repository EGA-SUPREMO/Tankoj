package qef.statmayin.statj.komencLudMenu;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.StringKvantil;
import qef.statmayin.Statlud;
import qef.uzantinterfac.Buton;
import qef.uzantinterfac.Panel;

public class KomencLudMenu implements Statlud {
	
	private int stat = 3, temp = 0;
	private Buton dawrigi, elir;
	private Panel qefpanel;
	private String ludantnombr;
	private String ailudantnombr;
	
	public KomencLudMenu() {
		ludantnombr = "Numero de jugadores:";
		ailudantnombr = "Numero de IA's:";
		
		qefpanel = new Panel(Konstantj.duonLudLargx>>1, Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2,
				Konstantj.duonLudLargx, Konstantj.ludAlt - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4, 4, "");
		
		final int x = qefpanel.x + 2 + Konstantj.KOMENC_MENU_ALT_BUTON + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*3;
		dawrigi = new Buton(x, qefpanel.y + qefpanel.alt - 2 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 -
				Konstantj.KOMENC_MENU_ALT_BUTON, qefpanel.largx - 2 - x + qefpanel.x -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 3, 3, "Continuar");
		elir = new Buton(qefpanel.x + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 + 2, dawrigi.y,
				Konstantj.KOMENC_MENU_ALT_BUTON, 1, 1, "");
	}
	
	@Override
	public void gxisdatig() {
		gxisdatigSelektatjn();
	}
		
	private void gxisdatigSelektatjn() {
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		if(QefObjektj.superfic.muyn().qclickn()) {
			if(muy.intersects(new Rectangle(dawrigi.x, dawrigi.y, dawrigi.largx, Konstantj.KOMENC_MENU_ALT_BUTON))) {
				dawrigi.setSpec(1);
				stat = 2;
			} else if(muy.intersects(new Rectangle(elir.x, elir.y, elir.largx, Konstantj.KOMENC_MENU_ALT_BUTON))) {
				elir.setSpec(1);
				stat = 0;
			}
		}
	}

	@Override
	public void desegn() {
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, Konstantj.ludAlt, Konstantj.KOLOR_FONKOMENCMENU);
		qefpanel.desegn();
		DebugDesegn.setFont(Konstantj.KUTIM_FONT.deriveFont(17f));
		DebugDesegn.desegnString(ludantnombr, qefpanel.x + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2,
				qefpanel.y + StringKvantil.altStringn(DebugDesegn.Graphicsn(), ludantnombr) +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, Konstantj.KOLORJ_BUTON[5]);

		DebugDesegn.setFont(Konstantj.KUTIM_FONT.deriveFont(12f));
		dawrigi.desegn();
		elir.desegn();
	}
	
	@Override
	public int nunStat() {
		if(stat!=3 && temp < 15) {
			temp++;
			return 3;
		}
		temp = 0;
		return stat;
	}
}

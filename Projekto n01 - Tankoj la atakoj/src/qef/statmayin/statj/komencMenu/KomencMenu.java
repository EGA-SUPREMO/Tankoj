package qef.statmayin.statj.komencMenu;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.kontrolj.Kontrolperant;
import qef.statmayin.Statlud;
import qef.uzantinterfac.Buton;
import qef.uzantinterfac.Panel;

public class KomencMenu implements Statlud {
	
	private Buton[] butonj;
	private Panel qefpanel, duapanel;
	private int stat, temp = 330;
	private final static int LARGX_BUTON = Konstantj.ludLargx/3;//Konstantj.duonLudLargx;
	public KomencMenu() {
		butonj = new Buton[4];
		
		butonj[0] = new Buton(Konstantj.duonLudLargx - (LARGX_BUTON>>1), Konstantj.ludAlt -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*7 - Konstantj.KOMENC_MENU_ALT_BUTON*4, LARGX_BUTON, 0, 2,
				"Iniciar partida");
		butonj[1] = new Buton(butonj[0].x, butonj[0].y + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, LARGX_BUTON, 0, 2, "Cargar partida");
		butonj[2] = new Buton(butonj[0].x, butonj[1].y + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, LARGX_BUTON, 0, 3, "Opciones");
		butonj[3] = new Buton(butonj[0].x, butonj[2].y + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, LARGX_BUTON, 0, 1, "Salir");
		
		qefpanel = new Panel(butonj[0].x - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 - 2,
				butonj[0].y - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 - 2, LARGX_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4 + 4, butonj[3].y + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4 - butonj[0].y + 4, 4, "");
		duapanel = new Panel(qefpanel.x, qefpanel.y - Konstantj.KOMENC_MENU_ALT_BUTON, qefpanel.largx,
				Konstantj.KOMENC_MENU_ALT_BUTON + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, 0, "Tankoj");
	}

	@Override
	public void gxisdatig() {
		gxisdatigKomponantjn();
		gxisdatigSelektatjn();
	}
	private void gxisdatigKomponantjn() {
		for(int i = 0; i < butonj.length; i++)
			butonj[i].gxisdatig();
		qefpanel.gxisdatig();
		duapanel.gxisdatig();
	}

	private void gxisdatigSelektatjn() {//MALBELEGA KODO
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		if(muy.intersects(new Rectangle(butonj[0].x, butonj[0].y, LARGX_BUTON, Konstantj.KOMENC_MENU_ALT_BUTON))) {
			butonj[0].yangxKolor();
			if(QefObjektj.superfic.muyn().qclickn()) {
				butonj[0].setSpec(1);
				stat = 3;
			}
			butonj[1].resetButonn();
			butonj[2].resetButonn();
			butonj[3].resetButonn();
		} else {
			butonj[0].resetButonn();
			if(muy.intersects(new Rectangle(butonj[1].x, butonj[1].y, LARGX_BUTON, Konstantj.KOMENC_MENU_ALT_BUTON))) {
				butonj[1].yangxKolor();
				if(QefObjektj.superfic.muyn().qclickn()) {
					butonj[1].setSpec(1);
					stat = 4;
				}
				butonj[2].resetButonn();
				butonj[3].resetButonn();
			} else {
				butonj[1].resetButonn();
				if(muy.intersects(new Rectangle(butonj[2].x, butonj[2].y, LARGX_BUTON, Konstantj.KOMENC_MENU_ALT_BUTON))) {
					butonj[2].yangxKolor();
					if(QefObjektj.superfic.muyn().qclickn()) {
						butonj[2].setSpec(1);
						stat = 5;
					}
					butonj[3].resetButonn();
				} else {
					butonj[2].resetButonn();
					if(muy.intersects(new Rectangle(butonj[3].x, butonj[3].y, LARGX_BUTON, Konstantj.KOMENC_MENU_ALT_BUTON))) {
						butonj[3].yangxKolor();
						if(QefObjektj.superfic.muyn().qclickn()) {
							Kontrolperant.klavar.elir();
						}
					} else {
						butonj[3].resetButonn();
					}
				}
			}
		}
	}
	@Override
	public int nunStat() {
		if(stat!=0 && temp < Konstantj.KOMENC_MENU_BUTONPLEJTEMP) {
			if(temp >= Konstantj.KOMENC_MENU_BUTONPLEJTEMP>>1)
				butonj[stat-3].resetspecn();
			temp++;
			return 0;
		}
		temp = 0;
		final int stat1 = stat;
		stat = 0;
		return stat1;
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, Konstantj.ludAlt, Konstantj.KOLOR_FONKOMENCMENU);
		duapanel.desegn();
		qefpanel.desegn();
		butonj[0].desegn();
		butonj[1].desegn();
		butonj[2].desegn();
		butonj[3].desegn();
	}
	
}
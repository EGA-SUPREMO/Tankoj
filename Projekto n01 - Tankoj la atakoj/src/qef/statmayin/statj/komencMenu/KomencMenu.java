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
	
	public KomencMenu() {
		butonj = new Buton[4];
		
		butonj[0] = new Buton(Konstantj.duonLudLargx - (Buton.LARGX_BUTON>>1), Konstantj.ludAlt -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*7 - Konstantj.KOMENC_MENU_ALT_BUTON*4, Buton.LARGX_BUTON, 0,
				2, 3, "Iniciar partida");
		butonj[1] = new Buton(butonj[0].xn(), butonj[0].yn() + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, Buton.LARGX_BUTON, 0, 2, 4, "Cargar partida");
		butonj[2] = new Buton(butonj[0].xn(), butonj[1].yn() + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, Buton.LARGX_BUTON, 0, 3, 5, "Opciones");
		butonj[3] = new Buton(butonj[0].xn(), butonj[2].yn() + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, Buton.LARGX_BUTON, 0, 1, -1, "Salir");
		
		qefpanel = new Panel(butonj[0].xn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 - 2,
				butonj[0].yn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 - 2, Buton.LARGX_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4 + 4, butonj[3].yn() + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4 - butonj[0].yn() + 4, 4, "");
		duapanel = new Panel(qefpanel.xn(), qefpanel.yn() - Konstantj.KOMENC_MENU_ALT_BUTON, qefpanel.largxn(),
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
		
		if(muy.intersects(new Rectangle(butonj[3].xn(), butonj[3].yn(), Buton.LARGX_BUTON,
				Konstantj.KOMENC_MENU_ALT_BUTON))) {
			if(QefObjektj.superfic.muyn().qclickn()) {
				Kontrolperant.klavar.elir();
			}
		} else {
			butonj[3].resetButonn();
		}
	}
	@Override
	public int nunStat() {
		for(int i = 0; i < butonj.length; i++)
			if(butonj[i].specn()==1) {
				stat = butonj[i].statDeLaMenu;
				break;
			}
		if(stat!=0 && temp < Konstantj.KOMENC_MENU_BUTONPLEJTEMP) {
			if(temp >= Konstantj.KOMENC_MENU_BUTONPLEJTEMP>>1)
				butonj[stat-3].resetSpecn();
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
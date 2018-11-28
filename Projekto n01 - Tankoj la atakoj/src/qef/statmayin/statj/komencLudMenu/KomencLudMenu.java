package qef.statmayin.statj.komencLudMenu;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.statmayin.Statlud;
import qef.uzantinterfac.Buton;
import qef.uzantinterfac.Presbuton;
import qef.uzantinterfac.Label;
import qef.uzantinterfac.Panel;
import qef.uzantinterfac.Slider;

public class KomencLudMenu implements Statlud {
	
	private int stat = 3, temp = 0;
	private Buton dawrigi, eliri;
	private Presbuton simplMod, kunVicjMod;
	private Panel qefpanel;
	private Label ludantnombr;
	private Label ailudantnombr;
	private Slider sliderLudantnombr;
	private Slider sliderAiludantnombr;
	
	public KomencLudMenu() {
		qefpanel = new Panel(Konstantj.duonLudLargx>>1, Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2,
				Konstantj.duonLudLargx, Konstantj.ludAlt - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4, 4, "");
		
		ludantnombr = new Label(qefpanel.x + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2,
				qefpanel.y + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 5, Konstantj.KUTIM_FONT.deriveFont(16f),
				"Numero de jugadores:");
		ailudantnombr = new Label(ludantnombr.x, ludantnombr.y + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, 5,
				Konstantj.KUTIM_FONT.deriveFont(16f), "Numero de IA's:");

		final int x = ludantnombr.x + ludantnombr.largx + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN;

		sliderLudantnombr = new Slider(x,
				ludantnombr.y, qefpanel.largx - 2 - x + qefpanel.x -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 2, 8, 2);
		sliderAiludantnombr = new Slider(x,
				sliderLudantnombr.y + sliderLudantnombr.alt + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN,
				qefpanel.largx - 2 - x + qefpanel.x - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 0,
				sliderLudantnombr.nun, 2);
		ludantnombr.y = sliderLudantnombr.y + sliderLudantnombr.alt/2 - ludantnombr.alt/2;
		ailudantnombr.y = sliderAiludantnombr.y + sliderAiludantnombr.alt/2 - ailudantnombr.alt/2;

		simplMod = new Presbuton(ludantnombr.x, sliderAiludantnombr.y + sliderAiludantnombr.alt +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, (int)
				(qefpanel.largx/2 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2.5), 0, 2, "Modo simple",
				"Modo complejo");
		kunVicjMod = new Presbuton(simplMod.x + simplMod.largx + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, simplMod.y,
				simplMod.largx, 0, 2, "Modo sin turnos", "Modo con turnos");
		
		final int butonX = qefpanel.x + 2 + Konstantj.KOMENC_MENU_ALT_BUTON + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*3;
		dawrigi = new Buton(butonX, qefpanel.y + qefpanel.alt - 2 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 -
				Konstantj.KOMENC_MENU_ALT_BUTON, qefpanel.largx - 2 - butonX + qefpanel.x -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 3, 3, 2, "Continuar");
		eliri = new Buton(qefpanel.x + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 + 2, dawrigi.y,
				Konstantj.KOMENC_MENU_ALT_BUTON, 1, 1, 0, "");
		
	}
	
	@Override
	public void gxisdatig() {
		gxisdatigKomponantjn();
		gxisdatigSelektatjn();
	}
		
	private void gxisdatigKomponantjn() {
		dawrigi.gxisdatig();
		eliri.gxisdatig();
		qefpanel.gxisdatig();
		sliderLudantnombr.gxisdatig();
		sliderAiludantnombr.gxisdatig();
		simplMod.gxisdatig();
		kunVicjMod.gxisdatig();
		sliderAiludantnombr.setPlejn(sliderLudantnombr.nun);
	}

	private void gxisdatigSelektatjn() {
	}

	@Override
	public void desegn() {
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, Konstantj.ludAlt, Konstantj.KOLOR_FONKOMENCMENU);
		qefpanel.desegn();
		sliderLudantnombr.desegn();
		sliderAiludantnombr.desegn();
		ludantnombr.desegn();
		ailudantnombr.desegn();
		simplMod.desegn();
		kunVicjMod.desegn();
		dawrigi.desegn();
		eliri.desegn();
	}
	
	@Override
	public int nunStat() {
		if(dawrigi.specn()==1)
			stat = dawrigi.statDeLaMenu;
		else if(eliri.specn()==1)
			stat = eliri.statDeLaMenu;
		
		if(stat!=3 && temp < Konstantj.KOMENC_MENU_BUTONPLEJTEMP) {
			if(temp >= Konstantj.KOMENC_MENU_BUTONPLEJTEMP>>1) {
				dawrigi.resetSpecn();
				eliri.resetSpecn();
			}
			temp++;
			return 3;
		}
		temp = 0;
		final int stat1 = stat;
		stat = 3;
		dawrigi.resetSpecn();
		eliri.resetSpecn();
		return stat1;
	}
}
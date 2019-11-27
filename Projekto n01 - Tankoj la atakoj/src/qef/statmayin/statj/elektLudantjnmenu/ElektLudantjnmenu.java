package qef.statmayin.statj.elektLudantjnmenu;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.statmayin.Statlud;
import qef.statmayin.statj.komencLudMenu.KomencLudMenu;
import qef.uzantinterfac.Buton;
import qef.uzantinterfac.Label;
import qef.uzantinterfac.Panel;

public class ElektLudantjnmenu implements Statlud {
	
	private final KomencLudMenu menu;
	
	private Panel qefpanel;
	private Buton[] ludantj;
	
	private Label ludant;
	private Label pli;
	
	private Buton dawrigi, eliri;
	private int stat = 6, temp = 0;
	
	public ElektLudantjnmenu(final KomencLudMenu menuo) {
		menu = menuo;
		
		qefpanel = new Panel(Konstantj.duonLudLargx>>1, Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2,
				Konstantj.duonLudLargx, Konstantj.ludAlt - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4, 4, "");
		
		
		final int butonX = qefpanel.xn() + 2 + Konstantj.KOMENC_MENU_ALT_BUTON - 1 +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*3;
		
		dawrigi = new Buton(butonX, qefpanel.yn() + qefpanel.altn() - 2 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 -
				Konstantj.KOMENC_MENU_ALT_BUTON, qefpanel.largxn() - 2 - butonX + qefpanel.xn() -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 3, 3, 2, "Continuar");
		dawrigi.aldonKomponantn(Konstantj.CHECK, (Konstantj.KOMENC_MENU_ALT_BUTON - 1 - Konstantj.IX.getWidth())/2,
				(Konstantj.KOMENC_MENU_ALT_BUTON - Konstantj.IX.getHeight() - 4)/2, 0);
		dawrigi.aldonKomponantn(Konstantj.CHECK, (Konstantj.KOMENC_MENU_ALT_BUTON - 1 - Konstantj.IX.getWidth())/2,
				(Konstantj.KOMENC_MENU_ALT_BUTON - Konstantj.CHECK.getHeight() - 4)/2, 1);
		
		eliri = new Buton(qefpanel.xn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 + 2, dawrigi.yn(),
				Konstantj.KOMENC_MENU_ALT_BUTON - 1, 1, 1, 3, "");
		eliri.aldonKomponantn(Konstantj.IX, (eliri.largxn() - Konstantj.IX.getWidth())/2,
				(Konstantj.KOMENC_MENU_ALT_BUTON - Konstantj.IX.getHeight() - 4)/2, 0);
		eliri.aldonKomponantn(Konstantj.IX, (eliri.largxn() - Konstantj.IX.getWidth())/2,
				(Konstantj.KOMENC_MENU_ALT_BUTON - Konstantj.IX.getHeight() - 4)/2, 1);
		
		ludant = new Label(eliri.xn(), qefpanel.yn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 + 2, 5,
				Konstantj.KUTIM_FONT.deriveFont(Konstantj.FONTGRANDEC), "Jugadores:");
		
		ludantj = new Buton[Konstantj.LUDANTPLEJNOMBR];
		
		final int largxPanel = (qefpanel.largxn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*5)/2 - 3;
		final int altPanel = (dawrigi.yn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*3 -
				(ludant.yn() + ludant.altn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN))/3;

		pli = new Label(0, 0, 0, Konstantj.KUTIM_FONT_BUTON.deriveFont(72f), " +");
		
		final int vicj = 2;
		b:
		for(int y = 0; ; y++)
			for(int x = 0; x < vicj; x++) {
				if(x + y*vicj>ludantj.length-1)
					break b;
				ludantj[x + y*vicj] = new Buton(
						ludant.xn() + (largxPanel + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN)*x,
						ludant.yn() + ludant.altn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN +
						y*(Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN + altPanel),
						largxPanel, altPanel, 0, 2, -1, "");
				ludantj[x + y*vicj].aldonCentritKomponantn(pli.bildn(), 0, -4, 0);
				ludantj[x + y*vicj].aldonCentritKomponantn(pli.bildn(), 0, -4, 1);
			}
			
		qefpanel.aldonKomponantn(ludant, 0);
		
	}

	@Override
	public void gxisdatig() {
		gxisdatigKomponantjn();
	}

	private void gxisdatigKomponantjn() {
		qefpanel.gxisdatig();
		dawrigi.gxisdatig();
		eliri.gxisdatig();
		ludant.gxisdatig();
		gxisdatigLudantjn();
	}
	
	private void gxisdatigLudantjn() {
		final int altPanel =
				(dawrigi.yn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*(int) (menu.nombrLudantn()/(float)2 + 0.99f) -
				(ludant.yn() + ludant.altn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN))/
				(int) (menu.nombrLudantn()/(float) 2 + 0.99f);
		
		if(altPanel==ludantj[0].altn()) {
			for(int i = 0; i < menu.nombrLudantn(); i++)
				ludantj[i].gxisdatig();
			
			return;
		}
		
		final int vicj = 2;
		b:
		for(int y = 0; ; y++)
			for(int x = 0; x < vicj; x++) {
				if(x + y*vicj>Konstantj.LUDANTPLEJNOMBR - 1)
					break b;
				ludantj[x + y*vicj].setYn(ludant.yn() + ludant.altn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN +
						y*(Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN + altPanel));
				ludantj[x + y*vicj].setAltn(altPanel);
				ludantj[x + y*vicj].gxisdatig();
				ludantj[x + y*vicj].aldonCentritKomponantn(pli.bildn(), 0, -4, 0);
				ludantj[x + y*vicj].aldonCentritKomponantn(pli.bildn(), 0, -4, 1);
				
			}
		
	}

	@Override
	public void desegn() {
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, Konstantj.ludAlt, Konstantj.KOLOR_FONKOMENCMENU);
		qefpanel.desegn();
		dawrigi.desegn();
		eliri.desegn();
		for(int i = 0; i < menu.nombrLudantn(); i++)
			ludantj[i].desegn();
	}

	@Override
	public int nunStat() {
		if(dawrigi.specn()==1)
			stat = dawrigi.statDeLaMenu;
		else if(eliri.specn()==1)
			stat = eliri.statDeLaMenu;
		
		if(stat!=6 && temp < Konstantj.KOMENC_MENU_BUTONPLEJTEMP) {
			temp++;
			return 6;
		}
		temp = 0;
		final int stat1 = stat;
		stat = 6;
		dawrigi.resetSpecn();
		eliri.resetSpecn();
		return stat1;
	}
	
}
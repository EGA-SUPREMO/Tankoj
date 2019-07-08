package qef.statmayin.statj.butikMenu;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.ilj.Vicperant;
import qef.statmayin.Statlud;
import qef.uzantinterfac.Buton;

public class ButikMenu implements Statlud {
	
	private Buton dawrigi;
	private int stat = 7, temp = 0;
	
	public ButikMenu() {
		dawrigi = new Buton(100, 100 - 2 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 -
				Konstantj.KOMENC_MENU_ALT_BUTON, 100 - 2 + 100 + 100 -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 3, 3, 2, "Continuar");
		dawrigi.aldonKomponantn(Konstantj.CHECK, (Konstantj.KOMENC_MENU_ALT_BUTON - 1 - Konstantj.IX.getWidth())/2,
				(Konstantj.KOMENC_MENU_ALT_BUTON - Konstantj.IX.getHeight() - 4)/2, 0);
		dawrigi.aldonKomponantn(Konstantj.CHECK, (Konstantj.KOMENC_MENU_ALT_BUTON - 1 - Konstantj.IX.getWidth())/2,
				(Konstantj.KOMENC_MENU_ALT_BUTON - Konstantj.CHECK.getHeight() - 4)/2, 1);
	}
	
	@Override
	public void gxisdatig() {
		dawrigi.gxisdatig();
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnString("Felicidade gano " + Vicperant.nunludantn().nomn() +
				"!!!, el mejor de la partida", 200, 200);
		dawrigi.desegn();
		
	}
	@Override
	public int nunStat() {
		if(dawrigi.specn()==1)
			stat = dawrigi.statDeLaMenu;
		
		if(stat!=7 && temp < Konstantj.KOMENC_MENU_BUTONPLEJTEMP) {
			temp++;
			return 7;
		}
		temp = 0;
		final int stat1 = stat;
		stat = 7;
		dawrigi.resetSpecn();
		return stat1;
	}
	
}

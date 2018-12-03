package qef.statmayin.statj.komencLudMenu;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.statmayin.Statlud;
import qef.uzantinterfac.Buton;
import qef.uzantinterfac.Presbuton;
import qef.uzantinterfac.Label;
import qef.uzantinterfac.Panel;
import qef.uzantinterfac.Slider;
import qef.uzantinterfac.Textkamp;

public class KomencLudMenu implements Statlud {
	
	private int stat = 3, temp = 0;
	private Buton dawrigi, eliri;
	private Presbuton simplMod, kunVicjMod;
	private Panel qefpanel;
	private Label ludantnombr;
	private Presbuton tempilvic;
	private Textkamp textnombr;
	private Slider sliderLudantnombr;
	private Label mapj;
	private Presbuton dezertmap;
	private Presbuton selvamap;
	private Presbuton mesamap;
	private Presbuton praderamap;
	private Presbuton negxmap;
	private Presbuton urbmap;
	private Presbuton metalmap;
	
	public KomencLudMenu() {
		qefpanel = new Panel(Konstantj.duonLudLargx>>1, Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2,
				Konstantj.duonLudLargx, Konstantj.ludAlt - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4, 4, "");
		
		ludantnombr = new Label(qefpanel.xn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 + 2,
				qefpanel.yn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 5, Konstantj.KUTIM_FONT.deriveFont(16f),
				"Numero de jugadores:");
		
		final int x = ludantnombr.xn() + ludantnombr.largxn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN;
		sliderLudantnombr = new Slider(x,
				ludantnombr.yn() + 2, qefpanel.largxn() - 5 - x + qefpanel.xn() -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 2, 8, 2);
		
		tempilvic = new Presbuton(ludantnombr.xn(), sliderLudantnombr.yn() + sliderLudantnombr.altn() +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, 
				qefpanel.largxn() - 3 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4, 0, 2,
				Konstantj.KUTIM_FONT.deriveFont(14 + 2f),
				"Temporizador de turnos desactivado", "Temporizador de turnos activado");
		final int textnombrLargx = 80;
		textnombr = new Textkamp(tempilvic.xn() + tempilvic.largxn() - textnombrLargx, tempilvic.yn(),
				textnombrLargx, 1, "2093");
		tempilvic.setLargxn(tempilvic.largxn() - textnombr.largxn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN);
		
		
		simplMod = new Presbuton(tempilvic.xn(), tempilvic.yn() + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, (int)
				(qefpanel.largxn()/2 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2.5 - 2.5), 0, 2,
				Konstantj.KUTIM_FONT_BUTON.deriveFont(14 + 2f), "Modo simple",
				"Modo complejo");
		kunVicjMod = new Presbuton(simplMod.xn() + simplMod.largxn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN,
				simplMod.yn(),
				simplMod.largxn(), 0, 2, Konstantj.KUTIM_FONT_BUTON.deriveFont(14 + 2f), "Modo sin turnos",
				"Modo con turnos");
		
		mapj = new Label(simplMod.xn(), simplMod.yn() + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, 5, Konstantj.KUTIM_FONT.deriveFont(24f), "Mapas:");
		
		
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
				Konstantj.KOMENC_MENU_ALT_BUTON - 1, 1, 1, 0, "");
		eliri.aldonKomponantn(Konstantj.IX, (eliri.largxn() - Konstantj.IX.getWidth())/2,
				(Konstantj.KOMENC_MENU_ALT_BUTON - Konstantj.IX.getHeight() - 4)/2, 0);
		eliri.aldonKomponantn(Konstantj.IX, (eliri.largxn() - Konstantj.IX.getWidth())/2,
				(Konstantj.KOMENC_MENU_ALT_BUTON - Konstantj.IX.getHeight() - 4)/2, 1);

		dezertmap = new Presbuton(simplMod.xn(), mapj.yn() + mapj.altn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN,
				(qefpanel.largxn() - 4 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4)/3,
				(dawrigi.yn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*3 -
						(mapj.yn() + mapj.altn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN))/3, 3, 2,
				Konstantj.KUTIM_FONT_BUTON, "", "");
		
		dezertmap.aldonKomponantn(Konstantj.FON1, (dezertmap.largxn() - Konstantj.FON1.getWidth())/2,
				(dezertmap.altn() - Konstantj.FON1.getHeight())/2, 0);
		dezertmap.aldonKomponantn(Konstantj.FON1, (dezertmap.largxn() - Konstantj.FON1.getWidth())/2,
				(dezertmap.altn() - Konstantj.FON1.getHeight())/2, 1);
		
		qefpanel.aldonKomponantn(ludantnombr, 0);
		qefpanel.aldonKomponantn(mapj, 0);
		
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
		simplMod.gxisdatig();
		kunVicjMod.gxisdatig();
		tempilvic.gxisdatig();
		textnombr.gxisdatig();
		dezertmap.gxisdatig();
	}

	private void gxisdatigSelektatjn() {
	}

	@Override
	public void desegn() {
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, Konstantj.ludAlt, Konstantj.KOLOR_FONKOMENCMENU);
		qefpanel.desegn();
		sliderLudantnombr.desegn();
		tempilvic.desegn();
		textnombr.desegn();
		simplMod.desegn();
		kunVicjMod.desegn();
		dezertmap.desegn();
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
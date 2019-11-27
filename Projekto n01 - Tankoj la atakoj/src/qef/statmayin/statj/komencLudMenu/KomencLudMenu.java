package qef.statmayin.statj.komencLudMenu;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
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
	private Buton tempnomo;
	private Presbuton tempnomo1;
	private Presbuton simplMod, kunVicjMod;
	private Panel qefpanel;
	private Label ludantnombr;
	private Presbuton tempilvic;
	private Textkamp textnombr;
	private Slider sliderLudantnombr;
	private Label map;
	private Presbuton[] mapj;
	
	public KomencLudMenu() {
		qefpanel = new Panel(Konstantj.duonLudLargx>>1, Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2,
				Konstantj.duonLudLargx, Konstantj.ludAlt - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*4, 4, "");
		
		mapj = new Presbuton[8];
		
		ludantnombr = new Label(qefpanel.xn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 + 2,
				qefpanel.yn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 5, Konstantj.KUTIM_FONT.deriveFont(16f),
				"Numero de jugadores:");
		
		final int sliderLudantX = ludantnombr.xn() + ludantnombr.largxn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN;
		sliderLudantnombr = new Slider(sliderLudantX,
				ludantnombr.yn() + 2, qefpanel.largxn() - 5 - sliderLudantX + qefpanel.xn() -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 2, Konstantj.LUDANTPLEJNOMBR, 0, 2);
		
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
				(qefpanel.largxn()/2 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2.5 - 2), 0, 2,
				Konstantj.KUTIM_FONT_BUTON.deriveFont(14 + 2f), "Modo simple",
				"Modo complejo");
		kunVicjMod = new Presbuton(simplMod.xn() + simplMod.largxn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN,
				simplMod.yn(),
				simplMod.largxn(), 0, 2, Konstantj.KUTIM_FONT_BUTON.deriveFont(14 + 2f), "Modo sin turnos",
				"Modo con turnos");
		
		map = new Label(simplMod.xn(), simplMod.yn() + Konstantj.KOMENC_MENU_ALT_BUTON +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN, 5,
				Konstantj.KUTIM_FONT.deriveFont(Konstantj.FONTGRANDEC), "Mapas:");
		
		
		final int butonX = qefpanel.xn() + 2 + Konstantj.KOMENC_MENU_ALT_BUTON - 1 +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*3;
		dawrigi = new Buton(butonX, qefpanel.yn() + qefpanel.altn() - 2 - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2 -
				Konstantj.KOMENC_MENU_ALT_BUTON, qefpanel.largxn() - 2 - butonX + qefpanel.xn() -
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*2, 3, 3, 6, "Continuar");
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
		
		final int largxMap = (qefpanel.largxn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*5)/3 - 3;
		final int altMap = (dawrigi.yn() - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN*3 -
				(map.yn() + map.altn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN))/3;
		
		final int vicj = 3;
		b:
		for(int y = 0; y < 3; y++)
			for(int x = 0; x < vicj; x++) {
				if(x + y*vicj>7)
					break b;
				mapj[x + y*vicj] = new Presbuton(
						simplMod.xn() + (largxMap + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN)*x - (x==2? 1 : 0),
						map.yn() + map.altn() + Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN +
						y*(Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN + altMap),
						largxMap - (x==2? 1 : 0), altMap, 0, 2, Konstantj.KUTIM_FONT_BUTON, "", "");
		
				mapj[x + y*vicj].aldonKomponantn(Konstantj.QEFFONETJ_BIOMJ[x + y*vicj],
						(largxMap - Konstantj.QEFFONETJ_BIOMJ[x + y*vicj].getWidth())/2,
						(altMap - Konstantj.QEFFONETJ_BIOMJ[x].getHeight() - 4)/2, 0);
				mapj[x + y*vicj].aldonKomponantn(Konstantj.QEFFONETJ_BIOMJ[x + y*vicj],
						(largxMap - Konstantj.QEFFONETJ_BIOMJ[x + y*vicj].getWidth())/2,
						(altMap - Konstantj.QEFFONETJ_BIOMJ[x].getHeight() - 4)/2, 1);
				mapj[x + y*vicj].setSpec(1);
			}
		
		tempnomo = new Buton(mapj[2].xn(), mapj[6].yn(), largxMap,
				(altMap - Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN)/2, 0, 2, -1, "Aleatorio");
		tempnomo1 = new Presbuton(tempnomo.xn(), tempnomo.yn() + tempnomo.altn() +
				Konstantj.KOMENC_MENU_VERTIKAL_MARGXEN/2, largxMap, tempnomo.altn(), 0, 2,
				Konstantj.KUTIM_FONT_BUTON.deriveFont(14 + 2f), "Todos", "Todos");
		tempnomo1.setSpec(1);
		
		qefpanel.aldonKomponantn(ludantnombr, 0);
		qefpanel.aldonKomponantn(map, 0);
		
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
		tempnomo.gxisdatig();
		tempnomo1.gxisdatig();
		for(int i = 0; i < mapj.length; i++)
			mapj[i].gxisdatig();
	}

	private void gxisdatigSelektatjn() {
		if(tempnomo1.specn()==1) {
			final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
			if(muy.intersects(tempnomo1.kolicin())) {
				for(int i = 0; i < mapj.length; i++)
					mapj[i].setSpec(1);
			} else for(int i = 0; i < mapj.length; i++)
				if(mapj[i].specn() == 0) {
					tempnomo1.setSpec(0);
					break;
				}
		}
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
		for(int i = 0; i < mapj.length; i++)
			mapj[i].desegn();
		tempnomo.desegn();
		tempnomo1.desegn();
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

	public int nombrLudantn() {
		return sliderLudantnombr.nun;
	}
	
	public int tempvicn() {
		return -1;
	}
	
}
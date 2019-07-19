package qef.statmayin.statj.butikMenu;

import java.awt.Color;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.ilj.Vicperant;
import qef.kontrolj.Kontrolperant;
import qef.statmayin.Statlud;
import qef.uzantinterfac.Buton;

public class ButikMenu implements Statlud {
	
	private Buton dawrigi;
	private int stat = 7, nunL = 0;
	private double elektazh1 = 0, elektazh2 = 0, elektazh = 0;
	
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
		if(Kontrolperant.klavar.mldextr.pulsitan()) {
			if(elektazh<1.99)
				elektazh += 0.10;
			else
				elektazh = 0;
		}
		if(Kontrolperant.klavar.sub.pulsitan()) {
			if(elektazh<1.1)
				if(elektazh1>0)
					elektazh1 -= 0.2;
				else
					elektazh1 = 5;
			else
				if(elektazh2>0)
					elektazh2 -= 0.2;
				else
					elektazh2 = 11;
		}
		if(Kontrolperant.klavar.supr.pulsitan()) {
			if(elektazh<1.1)
				if(elektazh1<5)
					elektazh1 += 0.2;
				else
					elektazh1 = 0;
			else
				if(elektazh2<11)
					elektazh2 += 0.2;
				else
					elektazh2 = 0;
		}
		if(Kontrolperant.klavar.aqeti) {
			aqet();
			Kontrolperant.klavar.aqeti = false;
		}
	}
	
	private void aqet() {
		if(elektazh==0)
			Vicperant.ludantj[nunL].aqetMisiln((int) elektazh1);
		else
			Vicperant.ludantj[nunL].aqetTankazhn((int) elektazh2);
	}

	@Override
	public void desegn() {
		DebugDesegn.setFont(DebugDesegn.Fontn().deriveFont(24f));
		DebugDesegn.desegnString("Felicidades al ganador!!1", 96, 200);
		DebugDesegn.desegnRectangle((int) elektazh*500, 32 + (1 - (int) elektazh)*280,
				434 + (1 - (int) elektazh)*40,
				22*6 + (int)elektazh*6*22, Color.DARK_GRAY.darker());
		if(elektazh<1)
			DebugDesegn.desegnRectangle(0, 312 + (int) (elektazh1)*22, 474, 22, Color.ORANGE.darker());
		else
			DebugDesegn.desegnRectangle(500, 32 + (int) (elektazh2)*22, 434, 22, Color.ORANGE.darker());
		dawrigi.desegn();
		for(int i = 0; i < Konstantj.kampfortnomj.length; i++)
			DebugDesegn.desegnString(Konstantj.kampfortnomj[i] + ": " + Vicperant.ludantj[nunL].kampfortnombrjn()[i],
					600, 226 + i*22, Color.WHITE);
		for(int i = 0; i < Konstantj.armilarkolorj.length; i++)
			DebugDesegn.desegnString(Konstantj.armilarnomj[i] + ": " +
				Vicperant.ludantj[nunL].armilarn()[i], 100, 330 + i*22,
				Color.GRAY.brighter());
		for(int i = 0; i < Konstantj.tankazhprecj.length; i++)
			DebugDesegn.desegnString(Konstantj.tankazhprecj[i] + " $", 506, 50 + i*22,
				Color.WHITE);
		for(int i = 0; i < Konstantj.armilarprecj.length; i++)
			DebugDesegn.desegnString(Konstantj.armilarprecj[i] + " $", 22, 330 + i*22,
				Color.WHITE);
		DebugDesegn.desegnString("Gasolina: " + Vicperant.ludantj[nunL].plejbrulazh, 600, 50, Color.WHITE);
		DebugDesegn.desegnString("Reparadores: " + Vicperant.ludantj[nunL].reviviln(), 600, 72, Color.WHITE);
		DebugDesegn.desegnString("Teletransportador: " + Vicperant.ludantj[nunL].teleirazhj, 600, 94, Color.WHITE);
		DebugDesegn.desegnString("Dinero: " + ((int) Vicperant.ludantj[nunL].monn()), 600, 116, Color.GREEN);
		DebugDesegn.desegnString("Vida: " + ((int) Vicperant.ludantj[nunL].plejvivn()), 600, 138, Color.WHITE);
		DebugDesegn.desegnString("Velocidad de motor: " + Vicperant.ludantj[nunL].eficientBrulazh, 600, 182, Color.WHITE);
		DebugDesegn.desegnString("Escalar montagnas: " + Vicperant.ludantj[nunL].movecn(), 600, 204, Color.WHITE);
		DebugDesegn.desegnString("Resistencia: " + Vicperant.ludantj[nunL].resistencn(), 600, 160, Color.WHITE);

		DebugDesegn.desegnBildn(Vicperant.ludantj[nunL].nunbildn(), 750, 400);
		DebugDesegn.desegnString(Vicperant.ludantj[nunL].nomn(), 750, 450 , Color.GRAY.brighter());
		
		
	}
	@Override
	public int nunStat() {
		if(dawrigi.pulsitn()) {
			nunL++;
			if(nunL == Vicperant.ludantj.length) {
				nunL = 0;
				stat = dawrigi.statDeLaMenu;
				Vicperant.venontLudadn();
			}
		}
		final int stat1 = stat;
		stat = 7;
		return stat1;
	}
	
}
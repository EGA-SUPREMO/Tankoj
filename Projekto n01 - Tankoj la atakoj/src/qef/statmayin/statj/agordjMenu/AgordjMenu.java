package qef.statmayin.statj.agordjMenu;

import java.awt.Color;

import qef.ilj.DebugDesegn;
import qef.statmayin.Statlud;

public class AgordjMenu implements Statlud {
	
	@Override
	public void gxisdatig() {
		
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnString("Gano alguien, felicidades. Cierren el juego por favor.", 322, 322, Color.RED);
	}

	@Override
	public int nunStat() {
		return 5;
	}
	
}

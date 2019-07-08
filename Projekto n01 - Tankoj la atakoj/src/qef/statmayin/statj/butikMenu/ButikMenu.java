package qef.statmayin.statj.butikMenu;

import qef.ilj.DebugDesegn;
import qef.ilj.Vicperant;
import qef.statmayin.Statlud;

public class ButikMenu implements Statlud {
	
	@Override
	public void gxisdatig() {
		
	}
	
	@Override
	public void desegn() {
		for(int i = 0; i < Vicperant.ludantj.length; i++)
			if(Vicperant.ludantj[i].vivn()!=0) {
				DebugDesegn.desegnString("Felicidade gano " + Vicperant.ludantj[i].nomn() +
						"!!!, el mejor de la partida", 200, 200);
				break;
			}
	}

	@Override
	public int nunStat() {
		return 7;
	}
	
}

package qef.statmayin.statj.lud;

import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.ilj.Vicperant;
import qef.kontrolj.Kontrolperant;
import qef.statmayin.Statlud;

public class Ludperant implements Statlud {
	
	@Override
	public void gxisdatig() {
		if(Kontrolperant.klavar.qatak) {
			//Vicperant.venontNunLudantn();
		}
		Vicperant.ludantj[Vicperant.nunLudantn()].gxisdatig();
		QefObjektj.map.gxisdatig();
	}
	
	@Override
	public void desegn() {
		
		QefObjektj.map.desegn();
		for(Ludant ludant: Vicperant.ludantj)
			ludant.desegn();
		QefObjektj.malhelec.desegn();
		QefObjektj.submenu.desegn();
		
	}
	
}

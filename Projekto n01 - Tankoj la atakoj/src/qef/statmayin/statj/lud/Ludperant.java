package qef.statmayin.statj.lud;

import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.ilj.Vicperant;
import qef.statmayin.Statlud;

public class Ludperant implements Statlud {
	
	@Override
	public void gxisdatig() {
		if(Vicperant.nunMisiln()==null)
			Vicperant.nunludantn().gxisdatig();
		else
			Vicperant.nunMisiln().gxisdatig();
		
		QefObjektj.map.gxisdatig();
	}
	
	@Override
	public void desegn() {
		QefObjektj.map.desegn();
		for(Ludant ludant: Vicperant.ludantj)
			ludant.desegn();
		if(Vicperant.nunMisiln()!=null)
			Vicperant.nunMisiln().desegn();
		QefObjektj.malhelec.desegn();
		QefObjektj.submenu.desegn();
	}

	@Override
	public int nunStat() {
		/*if(Kontrolperant.klavar.aktivInventari)
			return 1;
		else
			return 2;*/
		return Vicperant.statn();
	}
	
}

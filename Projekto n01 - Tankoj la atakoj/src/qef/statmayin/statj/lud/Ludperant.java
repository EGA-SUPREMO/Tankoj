package qef.statmayin.statj.lud;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.ilj.DebugDesegn;
import qef.ilj.Vicperant;
import qef.map.Map;
import qef.statmayin.Statlud;

public class Ludperant implements Statlud {
	
	public Ludperant() {
		Map.definigBildarn();
	}
	
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

		DebugDesegn.setFont(Konstantj.KUTIM_FONT.deriveFont(16f));
		for(int i = 0; i<Vicperant.ludantj.length; i++) {
			DebugDesegn.desegnString(Vicperant.ludantj[i].nomn(), Konstantj.ludLargx - 150, 78 + 14*i,
					Vicperant.ludantj[i].kolorn());
			DebugDesegn.desegnString(Vicperant.ludantj[i].monn() + "", Konstantj.ludLargx - 60, 78 + 14*i);
		}
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

package qef.statmayin;

import qef.statmayin.statj.agordjMenu.AgordjMenu;
import qef.statmayin.statj.elektLudantjnmenu.ElektLudantjnmenu;
import qef.statmayin.statj.komencLudMenu.KomencLudMenu;
import qef.statmayin.statj.komencMenu.KomencMenu;
import qef.statmayin.statj.lud.Ludperant;
import qef.statmayin.statj.ludMenu.Menuperant;
import qef.statmayin.statj.yargxLudMenu.YargxLudMenu;

public class Statperant {
	
	private Statlud[] statj;
	private Statlud nunStat;
	
	public Statperant() {
		ekStatj();
		definNunStatn();
	}

	private void ekStatj() {
		statj = new Statlud[7];
		statj[0] = new KomencMenu();
		statj[1] = new Menuperant();
		statj[2] = new Ludperant();
		statj[3] = new KomencLudMenu();
		statj[4] = new YargxLudMenu();
		statj[5] = new AgordjMenu();
		statj[6] = new ElektLudantjnmenu();
		//Aldunu pli da statoj kaj pliigu la nombron
	}
	
	private void definNunStatn() {
		nunStat = statj[0];
	}

	public void yangxNunStatn(final int posici) {
		nunStat = statj[posici];
	}
	
	public void yangxNunStatn() {
		nunStat = statj[nunStat.nunStat()];
	}

	public Statlud nunStatn() {
		return nunStat;
	}

	public boolean qStatludn() {
		return nunStat == statj[2];
	}
	
	public void gxisdatig() {
		nunStat.gxisdatig();
	}
	
	public void desegn() {
		nunStat.desegn();
	}
	
}
package qef.uzantinterfac.suprmenu;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;

public class Submenu {
	
	private static Rectangle are = new Rectangle(0, 0, Konstantj.ludLargx, Konstantj.altSubmenu);
	private Rectangle MargxenAre;
	private Verg[] vergj;
	private static int kvantElektebl = 3;
	
	public Submenu() {
		
		MargxenAre = new Rectangle(are.x, are.height, are.width, 1);
		
		vergj = new Verg[3];
		vergj[0] = new Verg(Color.BLUE, Text.VIV);
		vergj[1] = new Verg(Color.GREEN, Text.ANG);
		vergj[2] = new Verg(Color.RED, Text.ATK);
		
	}
	
	public void desegn() {
		desegnSubmenufonn();
		desegnVergjn();
	}
	
	private void desegnSubmenufonn() {
		DebugDesegn.setColor(Konstantj.KOLOR_FONSUBMENU);
		DebugDesegn.desegnRectangle(are);
		DebugDesegn.setColor(Color.BLACK);
		DebugDesegn.desegnRectangle(MargxenAre);
	}
	
	private void desegnVergjn() {
		for(int i = 0; i < vergj.length; i++)
			vergj[i].desegn();
	}
	
	static int kvantElektebln() {
		return kvantElektebl;
	}
	static int areXn() {
		return are.x;
	}
	static int areYn() {
		return are.y;
	}
	
}
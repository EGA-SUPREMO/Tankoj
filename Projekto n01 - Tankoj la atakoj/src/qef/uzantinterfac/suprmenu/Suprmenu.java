package qef.uzantinterfac.suprmenu;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDesegn;
import qef.ilj.Vicperant;

public class Suprmenu {
	
	private static Rectangle are = new Rectangle(0, 0, Konstantj.ludLargx, Konstantj.altSubmenu);
	private Rectangle MargxenAre;
	private Verg[] vergj;
	private static int kvantElektebl = 3;
	
	public Suprmenu() {
		
		MargxenAre = new Rectangle(are.x, are.height, are.width, 1);
		
		vergj = new Verg[3];
		vergj[0] = new Verg(Color.BLUE, Text.VIV);
		vergj[1] = new Verg(Color.GREEN, Text.ANG);
		vergj[2] = new Verg(Color.RED, Text.ATK);
		
	}
	
	public void desegn() {
		desegnSubmenufonn();
		desegnVergjn();
		DebugDesegn.setFont(DebugDesegn.Fontn().deriveFont(16f));
		DebugDesegn.desegnString(Konstantj.kampfortnomj[Vicperant.nunludantn().nunKampfortn()] + ": " +
				Vicperant.nunludantn().kampfortnombrjn()[Vicperant.nunludantn().nunKampfortn()], 300, 15,
				Color.BLACK);
		DebugDesegn.desegnString(Konstantj.armilarnomj[Vicperant.nunludantn().nunArmil] + ": " +
				Vicperant.nunludantn().armilarn()[Vicperant.nunludantn().nunArmil], 300, 30,
				Konstantj.armilarkolorj[Vicperant.nunludantn().nunArmil]);
		DebugDesegn.desegnString("Gasolina: " + Vicperant.nunludantn().brulazhn(), 300, 45, Color.BLACK);
		DebugDesegn.desegnString("Reparadores: " + Vicperant.nunludantn().reviviln(), 300, 60, Color.BLACK);
		DebugDesegn.desegnString("Teletransportador: " + Vicperant.nunludantn().teleirazhj, 550, 45, Color.BLACK);
		DebugDesegn.desegnString("Dinero: " + ((int) Vicperant.nunludantn().monn()), 550, 15, Color.BLACK);
		DebugDesegn.desegnString("Viento: " + QefObjektj.map.ventn()*200, 550, 60, Color.BLACK);
		DebugDesegn.desegnString("Vida: " + ((int) Vicperant.nunludantn().vivn()), 550, 30, Color.BLACK);

		DebugDesegn.desegnBildn(Vicperant.nunludantn().nunbildn(), 850, 10);
		DebugDesegn.desegnString(Vicperant.nunludantn().nomn(), 850, 50 , Vicperant.nunludantn().kolorn());
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
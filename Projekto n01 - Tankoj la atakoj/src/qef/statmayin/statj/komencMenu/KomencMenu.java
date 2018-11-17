package qef.statmayin.statj.komencMenu;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.kontrolj.Kontrolperant;
import qef.statmayin.Statlud;
import qef.uzantinterfac.Buton;

public class KomencMenu implements Statlud {
	
	private Buton komencLud;
	private Buton yargxLud;
	private Buton agordj;
	private Buton elir;
	private int stat, temp = 330;
	private final static int LARGX_BUTON = Konstantj.duonLudLargx;
	private final static int ALT_BUTON = 49;
	private final static int VERTIKAL_MARGXEN = ALT_BUTON/7;
	
	public KomencMenu() {
		komencLud = new Buton(Konstantj.duonLudLargx - (LARGX_BUTON>>1), Konstantj.ludAlt - VERTIKAL_MARGXEN*6 -
				ALT_BUTON*4, LARGX_BUTON, 0, 2,"Iniciar partida");
		yargxLud = new Buton(komencLud.x, komencLud.y + ALT_BUTON + VERTIKAL_MARGXEN, LARGX_BUTON, 0, 2,
				"Cargar partida");
		agordj = new Buton(komencLud.x, yargxLud.y + ALT_BUTON + VERTIKAL_MARGXEN, LARGX_BUTON, 0, 3, "Opciones");
		elir = new Buton(komencLud.x, agordj.y + ALT_BUTON + VERTIKAL_MARGXEN, LARGX_BUTON, 0, 1, "Salir");
	}

	@Override
	public void gxisdatig() {
		gxisdatigSelektatjn();
	}

	private void gxisdatigSelektatjn() {//MALBELEGA KODO
		if(komencLud.buton==null)
			return;
		
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		if(muy.intersects(new Rectangle(komencLud.x, komencLud.y, LARGX_BUTON, ALT_BUTON))) {
			komencLud.yangxKolor();
			if(QefObjektj.superfic.muyn().qclickn()) {
				komencLud.setSpec(1);
				stat = 3;
			}
			yargxLud.resetkolorn();
			agordj.resetkolorn();
			elir.resetkolorn();
		} else {
			komencLud.resetkolorn();
			if(muy.intersects(new Rectangle(yargxLud.x, yargxLud.y, LARGX_BUTON, ALT_BUTON))) {
				yargxLud.yangxKolor();
				if(QefObjektj.superfic.muyn().qclickn()) {
					yargxLud.setSpec(1);
					stat = 4;
				}
				elir.resetkolorn();
				agordj.resetkolorn();
			} else {
				yargxLud.resetkolorn();
				if(muy.intersects(new Rectangle(agordj.x, agordj.y, LARGX_BUTON, ALT_BUTON))) {
					agordj.yangxKolor();
					if(QefObjektj.superfic.muyn().qclickn()) {
						agordj.setSpec(1);
						stat = 5;
					}
					elir.resetkolorn();
				} else {
					agordj.resetkolorn();
					if(muy.intersects(new Rectangle(elir.x, elir.y, LARGX_BUTON, ALT_BUTON))) {
						elir.yangxKolor();
						if(QefObjektj.superfic.muyn().qclickn()) {
							Kontrolperant.klavar.elir();
						}
					} else {
						elir.resetkolorn();
					}
				}
			}
		}
	}
	@Override
	public int nunStat() {
		if(stat!=0 && temp < 15) {
			temp++;
			return 0;
		}
		return stat;
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, Konstantj.ludAlt, Konstantj.KOLOR_FONKOMENCMENU);
		//if(komencLud.buton==null && temp == 330) {
		DebugDesegn.desegnButon(Bildperant.krePaneln(LARGX_BUTON + VERTIKAL_MARGXEN*2,
				elir.y + ALT_BUTON + VERTIKAL_MARGXEN*8 - komencLud.y + 2, 4, ""), komencLud.x - VERTIKAL_MARGXEN,
				komencLud.y - VERTIKAL_MARGXEN*7);
		//temp = 0;
		//}
		//DebugDesegn.desegnButon(Bildperant.krePaneln(LARGX_BUTON, 300, 4, ""), 0, 0);
		komencLud.desegn();
		yargxLud.desegn();
		agordj.desegn();
		elir.desegn();
	}
	
}
package qef.statmayin.statj.komencMenu;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.statmayin.Statlud;

public class KomencMenu implements Statlud {

	private Point komencLud;
	private BufferedImage komencLudBild;
	private Point yargxLud;
	private BufferedImage yargxLudBild;
	private Point agordj;
	private BufferedImage agordjBild;
	private Point elir;
	private BufferedImage elirBild;
	private final static int LARGX_BUTON = Konstantj.duonLudLargx;
	private final static int ALT_BUTON = 49;
	private final static int VERTIKAL_MARGXEN = ALT_BUTON/3;
	
	public KomencMenu() {
		komencLud = new Point(Konstantj.duonLudLargx - (LARGX_BUTON>>1), Konstantj.ludAlt - VERTIKAL_MARGXEN*5 -
				ALT_BUTON*4);
		yargxLud = new Point(komencLud.x, komencLud.y + ALT_BUTON + VERTIKAL_MARGXEN);
		agordj = new Point(komencLud.x, yargxLud.y + ALT_BUTON + VERTIKAL_MARGXEN);
		elir = new Point(komencLud.x, agordj.y + ALT_BUTON + VERTIKAL_MARGXEN);
	}

	@Override
	public void gxisdatig() {
	}

	@Override
	public void desegn() {
		if(komencLudBild==null) {
			komencLudBild = Bildperant.kreButon(LARGX_BUTON, 0, 0, "Iniciar partida");
			yargxLudBild = Bildperant.kreButon(LARGX_BUTON, 0, 0, "Cargar partida");
			agordjBild = Bildperant.kreButon(LARGX_BUTON, 0, 0, "Opciones");
			elirBild = Bildperant.kreButon(LARGX_BUTON, 0, 0, "Salir");
		}
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, Konstantj.ludAlt, new Color(255, 204, 0));
		DebugDesegn.desegnButon(komencLudBild, komencLud.x, komencLud.y);
		DebugDesegn.desegnButon(yargxLudBild, yargxLud.x, yargxLud.y);
		DebugDesegn.desegnButon(agordjBild, agordj.x, agordj.y);
		DebugDesegn.desegnButon(elirBild, elir.x, elir.y);
	}
	
}

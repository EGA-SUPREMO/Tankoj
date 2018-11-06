package qef.statmayin.statj.komencMenu;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.ilj.DebugDesegn;
import qef.statmayin.Statlud;

public class KomencMenu implements Statlud {

	private Rectangle komencLud;
	private Rectangle yargxLud;
	private Rectangle agardj;
	private final static int LARGX_BUTON = 48;
	private final static int ALT_BUTON = 12;
	
	public KomencMenu() {
		komencLud = new Rectangle(Konstantj.duonLudLargx - (LARGX_BUTON>>1), Konstantj.VERTIKAL_MARGXEN, LARGX_BUTON, ALT_BUTON);
		yargxLud = new Rectangle(komencLud.x ,komencLud.y + komencLud.height + Konstantj.VERTIKAL_MARGXEN, LARGX_BUTON, ALT_BUTON);
	}

	@Override
	public void gxisdatig() {
	}

	@Override
	public void desegn() {
		DebugDesegn.desegnButon(null, komenc);
	}
	
}

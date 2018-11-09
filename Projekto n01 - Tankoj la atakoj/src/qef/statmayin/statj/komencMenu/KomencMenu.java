package qef.statmayin.statj.komencMenu;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.statmayin.Statlud;

public class KomencMenu implements Statlud {

	private Rectangle komencLud;
	private BufferedImage komencLudBild;
	private Rectangle yargxLud;
	private Rectangle agardj;
	private final static int LARGX_BUTON = 480;
	private final static int ALT_BUTON = 12;
	
	public KomencMenu() {
		komencLud = new Rectangle(Konstantj.duonLudLargx - (LARGX_BUTON>>1), Konstantj.VERTIKAL_MARGXEN, LARGX_BUTON, ALT_BUTON);
		
		yargxLud = new Rectangle(komencLud.x ,komencLud.y + komencLud.height + Konstantj.VERTIKAL_MARGXEN, LARGX_BUTON, ALT_BUTON);
	}

	@Override
	public void gxisdatig() {
	}

	@Override
	public void desegn() {komencLudBild = Bildperant.kreButon(komencLud.width, 0, "komenci ludon");
		DebugDesegn.desegnButon(komencLudBild, komencLud.x, komencLud.y);
	}
	
}

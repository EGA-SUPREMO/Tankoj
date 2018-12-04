package qef.uzantinterfac;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import qef.QefObjektj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;

public class Slider extends Komponant {
	
	private BufferedImage slider;
	public final int mlplej;
	private int plej;
	public int nun, qdukolora;
	public int mlplejOffsetX;
	private boolean qgxisdatigSlidern;
	private final int unukolor, dukolor;
	private int x2, y2;
	
	public Slider(final int xo, final int yo, final int largxo, final int mlplejo, final int plejo,
			final int unukoloro, final int dukoloro) {
		super(xo, yo, largxo, 1, unukoloro, "");
		
		mlplej = mlplejo;
		plej = plejo;
		qdukolora = 0;
		unukolor = unukoloro;
		dukolor = dukoloro;
		nun = mlplejo + (plejo - mlplejo)/2;
		qgxisdatigSlidern = true;
		y2 = yo + 4;
		definigBildn();
		
		alt = slider.getHeight() + 4;
		mlplejOffsetX = 0;
		x2 = (int) (xo + (double) (nun - 2)/(plejo - mlplejo)*largxo) - slider.getWidth()/2 + 2;
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnKomponantn(bild, x, y);
		DebugDesegn.desegnKomponantn(slider, x2, y2);
	}

	@Override
	public void gxisdatig() {
		definigBildn();
		gxisdatigSlidern();
	}

	private void gxisdatigSlidern() {
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		
		if(muy.intersects(new Rectangle(x + mlplejOffsetX, y, largx - mlplejOffsetX, slider.getHeight()))) {
			yangxKolor();
			if(QefObjektj.superfic.muyn().qpresiteclickn()) {
				x2 = muy.x - slider.getWidth()/2;
				
				gxisdatigNunn();
			}
			
		}else
			resetKolorn();
	}
	
	public void yangxKolor() {
		if(qdukolora == 0) {
			qdukolora = 1;
			kolor = dukolor;
			qgxisdatigSlidern = true;
		}
	}
	public void resetKolorn() {
		if(qdukolora == 1) {
			qdukolora = 0;
			kolor = unukolor;
			qgxisdatigSlidern = true;
		}
	}
	public void gxisdatigNunn() {
		int venontNun = (int)((float) (x2 - x + slider.getWidth()/2 + mlplejOffsetX)*(plej - mlplej + 1)/largx) + mlplej;
		if(venontNun>plej)
			venontNun--;
		if(venontNun!=nun) {
			nun = venontNun;
			qgxisdatigSlidern = true;
		}
	}
	public void setPlejn(final int plejo) {
		if(plej != plejo) {
			plej = plejo;
			gxisdatigNunn();
			qgxisdatig = true;
		}
	}
	public int plejn() {
		return plej;
	}

	@Override
	public void definigBildn() {
		if(qgxisdatig) {
			bild = Bildperant.kreLineoSlidern(this);
			aldonAldonayjn(0);
			qgxisdatig = false;
		}
		if(qgxisdatigSlidern) {
			slider = Bildperant.kreSlidern(nun, kolor, qdukolora);
			qgxisdatigSlidern = false;
		}
	}
}
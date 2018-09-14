package qef.estazhj.vivazhj;

import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.Misil;
import qef.ilj.DebugDesegn;
import qef.ilj.YargxilAzhj;
import qef.inventar.armil.Armil;
import qef.inventar.armil.Senarma;
import qef.kontrolj.Kontrolperant;
import qef.map.Map;
import qef.sprite.SpriteFoli;

public class Ludant extends Vivazh {
	
	private int radX1 = 5, radX2 = 27;
	private int offsetLudantY = 2;
	public Misil m;
	
	private int experienc = 100;
	public static final SpriteFoli armatludantsprite = new SpriteFoli(Konstantj.ITENER_LUDANT + 1 + ".png", 32,
			Transparency.TRANSLUCENT, 128);
	private static final SpriteFoli senarmatludantsprite = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32,
			Transparency.TRANSLUCENT);
	private static final BufferedImage armil = YargxilAzhj.yargxBildn(Konstantj.ITENER_LUDANT_CANON + 0 + ".png",
			Transparency.TRANSLUCENT, 36, 19);
	
	public Ludant() {
		super(1, 1, senarmatludantsprite, armil, Konstantj.ITENER_SONJ_LUDANT + "pom.wav");

		setXn(600);
		setYn(10);
		largxVivazh = 16;
		altVivazh = 16;
		
		LIMJ[0] = new Rectangle(Konstantj.duonLudLargx - largxVivazh + 1, Konstantj.duonLudAlt - altVivazh,
				Konstantj.SPRITELARGX - 2, 1);
		m = new Misil(900, 30, (int) xn(), (int) yn());
	}
	
	@Override
	public void gxisdatig() {
		m.gxisdatig();
		gxisdatigArmiljn();
		yangxMapn();
		yangxSpriten();
		mov();
		anim();
	}
	
	private void mov() {//1 = maldekstre, 2 = dekstre
		if(Kontrolperant.klavar.dextr.pulsitan() && !Kontrolperant.klavar.mldextr.pulsitan() && brulazh>0) {
			movante = true;
			direkt = 2;
			pliX();
			setYn(QefObjektj.map.yn()[(int) xn()]);
		}
		if(Kontrolperant.klavar.mldextr.pulsitan() && !Kontrolperant.klavar.dextr.pulsitan() && brulazh>0) {
			movante = true;
			direkt = 1;
			mlpliX();
			if(xn()<Konstantj.duonLudLargx)
				setYn(0);
			else setYn(QefObjektj.map.yn()[(int) xn()]);
		}
		if(Kontrolperant.klavar.supr.pulsitan() && !Kontrolperant.klavar.sub.pulsitan()) {
			if(++nunAngul>=Konstantj.canonAngulnombr)
				nunAngul--;
		}
		if(Kontrolperant.klavar.sub.pulsitan() && !Kontrolperant.klavar.supr.pulsitan()) {
			if(nunAngul>0)
				nunAngul--;
		}
		
	}
	
	private void yangxSpriten() {
		if(Konstantj.qyangxSpriteFoli) {
			Konstantj.qyangxSpriteFoli = false;
			if(vivazharmilar.armil1n() instanceof Senarma) {
				setSpriteFoli(senarmatludantsprite, 0);
				return;
			}
			if(vivazharmilar.armil1n() instanceof Armil)
				setSpriteFoli(armatludantsprite, 0);
		}
	}
	
	private void gxisdatigArmiljn() {
		if(vivazharmilar.armil1n() instanceof Senarma)
			return;
		
		vivazharmilar.armil1n().gxisdatig();
	}
	@Override
	protected void anim() {
		nunBild = statn();
		
		movante = false;
	}
	//TODO SXangxu la klaso de tiu metodo
	private int statn() {
		
		int x1 = (int) Map.xn((int) xn(), radX1);
		int x2 = (int) Map.xn((int) xn(), radX2);
		
		int y1 = QefObjektj.map.yn()[(int) (Map.xn((int) xn(), radX1))];
		int y2 = QefObjektj.map.yn()[(int) (Map.xn((int) xn(), radX2))];
		
		double angul = Math.atan2(y2 - y1, x2 - x1);
		
		for(int i = 0; i < KVANTSTATJ; i++)
			if(angul>rotaci*i && angul<rotaci*(i+1)) {
				return i;
			}
		
		return 0;
	}

	@Override
	public void desegn() {
		int posiciY = -(int)yn() + QefObjektj.map.offsetMap - bildj[nunBild].getHeight() + offsetLudantY;
		DebugDesegn.desegnBildn(bildj[nunBild], Konstantj.largxCentr, posiciY);
		
		DebugDesegn.desegnBildn(canonBildj[nunAngul], Konstantj.largxCentr, posiciY);
		m.desegn();
		//DebugDesegn.desegnLine((int) Konstantj.largxCentr + radX1,
		//		-QefObjektj.map.yn()[(int) (xn() + radX1 + Konstantj.duonLudLargx)] + QefObjektj.map.offsetMap,
		//		(int) Konstantj.largxCentr + radX1,
		//		QefObjektj.map.offsetMap -QefObjektj.map.yn()[(int) (xn() + radX1 + Konstantj.duonLudLargx)] + 5,
		//		Color.BLACK);
	}
	
	public int experiencn() {
		return experienc;
	}
	
}
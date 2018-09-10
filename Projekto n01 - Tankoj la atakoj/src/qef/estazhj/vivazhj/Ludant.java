package qef.estazhj.vivazhj;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Transparency;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.Bildperant;
import qef.ilj.BruGeneril;
import qef.ilj.DebugDesegn;
import qef.inventar.armil.Armil;
import qef.inventar.armil.Senarma;
import qef.kontrolj.Kontrolperant;
import qef.sprite.SpriteFoli;

public class Ludant extends Vivazh {
	
	private int radX1 = 5, radX2 = 27, radY = 30;
	private int offsetLudantY = 2;
	
	private int experienc = 100;
	public static final SpriteFoli armatludantsprite = new SpriteFoli(Konstantj.ITENER_LUDANT + 1 + ".png", 32,
			Transparency.TRANSLUCENT, 128);
	private static final SpriteFoli senarmatludantsprite = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32,
			Transparency.TRANSLUCENT);
	public Ludant() {
		super(1, 4, senarmatludantsprite, Konstantj.ITENER_SONJ_LUDANT + "pom.wav");

		setXn(QefObjektj.map.komencpunktX);
		setYn(0);
		largxVivazh = 16;
		altVivazh = 16;
		
		LIMJ[0] = new Rectangle(Konstantj.duonLudLargx - largxVivazh + 1, Konstantj.duonLudAlt - altVivazh,
				Konstantj.SPRITELARGX - 2, 1);
		LIMJ[1] = new Rectangle(Konstantj.duonLudLargx - largxVivazh + 1, Konstantj.duonLudAlt + altVivazh - 1,
				Konstantj.SPRITELARGX - 2, 1);
		LIMJ[2] = new Rectangle(Konstantj.duonLudLargx - largxVivazh, Konstantj.duonLudAlt - altVivazh + 1, 1,
				Konstantj.SPRITEALT - 2);
		LIMJ[3] = new Rectangle(Konstantj.duonLudLargx + largxVivazh, Konstantj.duonLudAlt - altVivazh + 1, 1,
				Konstantj.SPRITEALT - 2);
	}
	
	@Override
	public void gxisdatig() {
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
			setYn(QefObjektj.map.yn()[(int) xn() + Konstantj.duonLudLargx]);
		}
		if(Kontrolperant.klavar.mldextr.pulsitan() && !Kontrolperant.klavar.dextr.pulsitan() && brulazh>0) {
			movante = true;
			direkt = 1;
			mlpliX();
			setYn(QefObjektj.map.yn()[(int) xn() + Konstantj.duonLudLargx]);
		}
		if(Kontrolperant.klavar.supr.pulsitan() && !Kontrolperant.klavar.sub.pulsitan()) {
		}
		if(Kontrolperant.klavar.sub.pulsitan() && !Kontrolperant.klavar.supr.pulsitan()) {
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
		nunatingec = vivazharmilar.armil1n().atingec(this);
	}
	@Override
	protected void anim() {
		animacistat = statn();
		
		nunBild = animacistat;
		movante = false;
	}
	//TODO SXangxu la klaso de tiu metodo
	private int statn() {
		
		int x1 = (int) xn() + radX1;
		int x2 = (int) xn() + radX2;
		
		int y1 = QefObjektj.map.yn()[(int) (xn() + radX1 + Konstantj.duonLudLargx)];
		int y2 = QefObjektj.map.yn()[(int) (xn() + radX2 + Konstantj.duonLudLargx)];
		
		//Point centr = new Point(x1 - x1, y1 - y1);
		//Point punkt1 = new Point(x2 - x1, y2 - y1);
		
		double angul = Math.atan2(x2 - x1, y2 - y1);
		
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
		DebugDesegn.desegnLine(Konstantj.duonLudLargx, posiciY, Konstantj.largxCentr,
				posiciY-Konstantj.DUONSPRITEALT);
		
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
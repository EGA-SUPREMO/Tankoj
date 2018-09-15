package qef.estazhj.vivazhj;

import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.Misil;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.YargxilAzhj;
import qef.inventar.Objektregistril;
import qef.inventar.armil.Armil;
import qef.inventar.armil.Senarma;
import qef.kontrolj.Kontrolperant;
import qef.map.Map;
import qef.son.Son;
import qef.sprite.SpriteFoli;

public class Ludant extends Vivazh {

	protected BufferedImage[] bildj, canonBildj;
	private int radX1 = 5, radX2 = 27;
	private int offsetLudantY = 2;
	public Misil m;
	protected Vivazharmilar vivazharmilar;
	
	private int experienc = 100;
	public static final SpriteFoli armatludantsprite = new SpriteFoli(Konstantj.ITENER_LUDANT + 1 + ".png", 32,
			Transparency.TRANSLUCENT, 128);
	public static final SpriteFoli senarmatludantsprite = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32,
			Transparency.TRANSLUCENT);
	public static final BufferedImage armil = YargxilAzhj.yargxBildn(Konstantj.ITENER_LUDANT_CANON + 0 + ".png",
			Transparency.TRANSLUCENT, 36, 19);
	
	public Ludant(final int ordenSpec, final String itenerSon, final SpriteFoli sprite,
			final BufferedImage canonSprite) {
		super(1, itenerSon);
		
		setXn(600);
		setYn(QefObjektj.map.yn((int) xn()));
		largxVivazh = 16;
		altVivazh = 16;
		vivazharmilar = new Vivazharmilar((Armil) Objektregistril.objektjn(599));
		
		LIMJ[0] = new Rectangle((int) xn(), (int) yn(), largxVivazh, altVivazh);
		m = new Misil(nunAngul, 30, (int) xn(), (int) yn());
		
		ordenBildj(Konstantj.canonAngulnombr, canonSprite);
		ordenBildj(ordenSpec, sprite.spritejn());
	}
	
	protected void ordenBildj(final int spec, final BufferedImage[] tempbildj) {
		switch(spec) {
			case 0:
				break;
			case 1://TODO faru ke la bildoj generigxos kiam la ludanto acxetu la habilidad de escalar montoj
				bildj = new BufferedImage[rotaciplejNombr/2];
				bildj[0] = tempbildj[0];
				for(int i = 1; i < bildj.length/2; i++)
					bildj[i] = Bildperant.volvBildn(bildj[0], -(rotaci * i));
				for(int i = 0, j = bildj.length/2-1; i < bildj.length/2; i++, j--)
					bildj[i+bildj.length/2] = Bildperant.volvBildn(bildj[j], Math.PI/2);
				break;
		}
	}
	
	protected void ordenBildj(final int angulnombr, final BufferedImage tempbild) {//FIXME CXi tiu metodo estas ne efika
		canonBildj = new BufferedImage[angulnombr];
		double rotacij = Math.PI/angulnombr;
		for(int i = 0; i < canonBildj.length; i++)
			canonBildj[i] = Bildperant.volvBildn(tempbild, tempbild.getWidth()/2, tempbild.getHeight(),
					(rotacij * (i-90)));
	}
	
	@Override
	public void gxisdatig() {
		if(venontDamagxit > 0)
			venontDamagxit -= 1000000/60;
		m.gxisdatig();
		gxisdatigArmiljn();
		yangxMapn();
		yangxSpriten();
		mov();
		anim();
	}
	
	private void mov() {//1 = maldekstre, 2 = dekstre
		if(Kontrolperant.klavar.dextr.pulsitan() && !Kontrolperant.klavar.mldextr.pulsitan() && brulazh>0) {
			pliX();
			setYn(QefObjektj.map.yn()[(int) xn()]);
		}
		if(Kontrolperant.klavar.mldextr.pulsitan() && !Kontrolperant.klavar.dextr.pulsitan() && brulazh>0) {
			mlpliX();
			setYn(QefObjektj.map.yn()[(int) xn()]);
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
		DebugDesegn.desegnBildn(bildj[nunBild], (int) Kvantperant.koordenadXalekranPosicin(xn()), posiciY);
		
		DebugDesegn.desegnBildn(canonBildj[nunAngul], (int) Kvantperant.koordenadXalekranPosicin(xn()), posiciY);
		m.desegn();
	}

	public void setSpriteFoli(final SpriteFoli foli, final int ordenSpec) {
		ordenBildj(ordenSpec, foli.spritejn());
	}
	
	public int experiencn() {
		return experienc;
	}

	public Vivazharmilar vivazharmilarn() {
		return vivazharmilar;
	}
	
}
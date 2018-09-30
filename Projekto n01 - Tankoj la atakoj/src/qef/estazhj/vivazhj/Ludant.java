package qef.estazhj.vivazhj;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.Random;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.Misil;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;
import qef.ilj.YargxilAzhj;
import qef.inventar.Objektregistril;
import qef.inventar.armil.Armil;
import qef.kontrolj.Kontrolperant;
import qef.map.Map;
import qef.sprite.SpriteFoli;

public class Ludant extends Vivazh {

	protected BufferedImage[] bildj, canonBildj;
	private int radX1 = -10, radX2 = 11;
	private int offsetLudantY = 2;
	private int offsetLudantX = 0;
	private int offsetCanonX = -2, offsetCanonY = 1;
	private int plejAngul = Konstantj.canonAngulnombr/2;
	public Misil m;
	protected Vivazharmilar vivazharmilar;
	private boolean qatingec, qgxisdatigatingecn;
	private BufferedImage atingec;
	
	public final int plejpotenc = 100;
	public int potenc;
	public int nunangul;
	private int experienc = 100;
	public static final SpriteFoli ludantsprite0 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32,
			Transparency.TRANSLUCENT, Color.GREEN.darker());
	public static final SpriteFoli ludantsprite1 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32,
			Transparency.TRANSLUCENT, Color.RED);
	public static final SpriteFoli ludantsprite2 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png",
			Transparency.TRANSLUCENT, 32, 32, Color.CYAN.darker());
	public static final BufferedImage armil = YargxilAzhj.yargxBildn(Konstantj.ITENER_LUDANT_CANON + 0 + ".png",
			Transparency.TRANSLUCENT, 36, 19);
	
	public Ludant(final int ordenSpec, final String itenerSon, final SpriteFoli sprite,
			final BufferedImage canonSprite) {
		super(1, 100, itenerSon);
		
		nunangul = new Random().nextInt(plejAngul);
		setXn(new Random().nextInt(QefObjektj.map.yn().length));
		setYn(QefObjektj.map.yn((int) xn()));
		potenc = plejpotenc/4;
		vivazharmilar = new Vivazharmilar((Armil) Objektregistril.objektjn(599));
		qatingec = true;
		qgxisdatigatingecn = false;
		
		ordenBildj(Konstantj.canonAngulnombr, canonSprite);
		ordenBildj(ordenSpec, sprite.spritejn());
		
		largxVivazh = 32;
		altVivazh = 32;
		LIMJ[0] = new Rectangle((int) xn(), (int) yn(), largxVivazh, altVivazh);
	}
	
	protected void ordenBildj(final int spec, final BufferedImage[] tempbildj) {
		switch(spec) {
			case 0:
				break;
			case 1://TODO faru ke la bildoj generigxos kiam la ludanto acxetu la habilidad de escalar montoj(eble ne faru tion)
				bildj = new BufferedImage[rotaciplejNombr/2];
				for(int i = -bildj.length/2; i < bildj.length/2; i++)
					bildj[i + bildj.length/2] = Bildperant.volvBildn(tempbildj[0], -(rotaci * i));
				break;
		}
	}
	
	protected void ordenBildj(final int angulnombr, final BufferedImage tempbild) {//FIXME CXi tiu metodo estas ne efika
		canonBildj = new BufferedImage[angulnombr];
		double rotacij = 2*Math.PI/angulnombr;
		for(int i = 0; i < canonBildj.length; i++)
			canonBildj[i] = Bildperant.volvBildn(tempbild, tempbild.getWidth()/2, tempbild.getHeight() - 3,
					(rotacij * (i-90)));
	}
	
	@Override
	public void gxisdatig() {
		if(venontDamagxit > 0)
			venontDamagxit -= 1000000/60;
		if(m!=null)//FIXME
			m.gxisdatig();
		else {
			gxisdatigAtakn();
			yangxMapn();
			yangxSpriten();
			mov();
			anim();
		}
	}
	
	private void mov() {//1 = maldekstre, 2 = dekstre
		if(Kontrolperant.klavar.dextr.pulsitan() && !Kontrolperant.klavar.mldextr.pulsitan() && brulazh>0) {
			pliX();
			setYn(QefObjektj.map.yn()[(int) xn()]);
			if(qatingec)
				qgxisdatigatingecn = true;
			qmovant = true;
		}
		if(Kontrolperant.klavar.mldextr.pulsitan() && !Kontrolperant.klavar.dextr.pulsitan() && brulazh>0) {
			mlpliX();
			setYn(QefObjektj.map.yn()[(int) xn()]);
			if(qatingec)
				qgxisdatigatingecn = true;
			qmovant = true;
		}
		if(Kontrolperant.klavar.supr.pulsitan() && !Kontrolperant.klavar.sub.pulsitan()) {
			if(++nunangul>=Konstantj.canonAngulnombr)
				nunangul--;
			if(qatingec)
				qgxisdatigatingecn = true;
		}
		if(Kontrolperant.klavar.sub.pulsitan() && !Kontrolperant.klavar.supr.pulsitan()) {
			if(nunangul>0)
				nunangul--;
			if(qatingec)
				qgxisdatigatingecn = true;
		}
		if(Kontrolperant.klavar.subiPotenc && !Kontrolperant.klavar.supriPotenc) {
			if(potenc>0) {
				potenc--;
				if(qatingec)
					qgxisdatigatingecn = true;
			}
		}
		if(Kontrolperant.klavar.supriPotenc && !Kontrolperant.klavar.subiPotenc) {
			if(++potenc>plejpotenc)
				potenc--;
			
			if(qatingec)
				qgxisdatigatingecn = true;
			
		}
		if(qgxisdatigatingecn && !Kontrolperant.klavar.dextr.pulsitan() && !Kontrolperant.klavar.mldextr.pulsitan()
				 && !Kontrolperant.klavar.sub.pulsitan() && !Kontrolperant.klavar.supr.pulsitan()
				 && !Kontrolperant.klavar.subiPotenc && !Kontrolperant.klavar.supriPotenc) {
			atingec = Bildperant.atingecMisil(new Misil(nunangul, potenc, xn(), yn()).atingecn());
			qgxisdatigatingecn = false;
		}
	}
	
	private void yangxSpriten() {
	}
	
	private void gxisdatigAtakn() {
		if (Kontrolperant.klavar.qatak) {
			m = new Misil(nunangul, potenc, xn(), yn());
			Kontrolperant.klavar.qatak = false;
		}
	}
	@Override
	protected void anim() {
		if(qmovant) {
			nunBild = statn();
			//nunangul
			qmovant = false;
		}
	}
	//TODO SXangxu la klaso de tiu metodo
	private int statn() {
		
		int x1 = (int) Map.xn((int) xn(), radX1);
		int x2 = (int) Map.xn((int) xn(), radX2);
		
		double y1 = QefObjektj.map.yn()[(int) (Map.xn((int) xn(), radX1))];
		double y2 = QefObjektj.map.yn()[(int) (Map.xn((int) xn(), radX2))];
		
		double angul = Math.atan2(y2 - y1, x2 - x1);
			
		for(int i = -DUONKVANTSTATJ; i < DUONKVANTSTATJ; i++)
			if(angul>rotaci*i && angul<rotaci*(i+1)) {
				offsetLudantX = -i;
				return DUONKVANTSTATJ + i;
			}

		offsetLudantX = 0;
		return DUONKVANTSTATJ;
	}
	
	@Override
	public void desegn() {
		int posiciY = (int) Kvantperant.koordenadYalekranPosicin((int)yn()) - bildj[nunBild].getHeight() +
				offsetLudantY;
		DebugDesegn.desegnBildn(bildj[nunBild], (int) Kvantperant.koordenadXalekranPosicin(xn()) + offsetLudantX
				- (Vicperant.nunludantn().largxVivazhn()>>1), posiciY);
		
		DebugDesegn.desegnBildn(canonBildj[nunangul], (int) Kvantperant.koordenadXalekranPosicin(xn()) +
				offsetCanonX - (Vicperant.nunludantn().largxVivazhn()>>1), posiciY + offsetCanonY);
		if(m!=null)//FIXME
			m.desegn();
		if(atingec!=null && Vicperant.ludantj[Vicperant.nunLudantn()]==this) {
			if(nunangul>90)
				DebugDesegn.desegnBildn(atingec, (int) Kvantperant.koordenadXalekranPosicin(xn()),
						(int) Kvantperant.koordenadYalekranPosicin(yn()) - atingec.getHeight());
			else
				DebugDesegn.desegnBildn(atingec, (int) Kvantperant.koordenadXalekranPosicin(xn()) -
						atingec.getWidth(), (int) Kvantperant.koordenadYalekranPosicin(yn()) - atingec.getHeight());
			
			if(qgxisdatigatingecn)
				atingec = null;
		}
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
	@Override
	public void setYn(final double yo) {
		super.setYn(yo);
		qmovant = true;
		anim();
	}
	
}
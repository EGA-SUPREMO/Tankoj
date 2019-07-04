package qef.estazhj.vivazhj;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.Random;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.Estazhregistril;
import qef.estazhj.vivazhj.misil.Misil;
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
	private final static int ANTAWDEFINITRAD_X1 = -8, ANTAWDEFINITRAD_X2 = 8;
	private int radX1 = ANTAWDEFINITRAD_X1, radX2 = ANTAWDEFINITRAD_X2;
	private int offsetLudantY = 2;
	private double offsetLudantX = 0;
	@SuppressWarnings("unused")
	private int offsetCanonX = 0, offsetCanonY = 1, offsetCanonY2 = 3;
	private static final int ANTAWDEFINITPLEJANGUL = Konstantj.canonAngulnombr/2;
	public int plejangul, mlplejangul;
	protected Vivazharmilar vivazharmilar;
	private boolean qatingec, qgxisdatigatingecn;
	private BufferedImage atingec;
	
	private int movec = 0;//duonrotaciplejNombr>>4;
	public int plejpotenc = 100;
	public int potenc;
	private int nunangul;
	private int experienc = 100;
	@SuppressWarnings("unused")
	private int resistec;
	
	public int nunArmil = 1;
	
	public static final SpriteFoli ludantsprite0 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png",
			Transparency.TRANSLUCENT, 24, 24, Color.GREEN.darker());
	public static final SpriteFoli ludantsprite1 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png",
			Transparency.TRANSLUCENT, 24, 24, Color.RED);
	public static final SpriteFoli ludantsprite2 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png",
			Transparency.TRANSLUCENT, 24, 24, Color.CYAN.darker());
	public static final BufferedImage armil = YargxilAzhj.yargxBildn(Konstantj.ITENER_LUDANT_CANON + 0 + ".png",
			Transparency.TRANSLUCENT, 27, 29);
	
	public Ludant(final int ordenSpec, final String itenerSon, final SpriteFoli sprite,
			final BufferedImage canonSprite) {
		super(1, 100, itenerSon);
		Random r = new Random();
		setXn(r.nextInt(QefObjektj.map.yn().length));
		setYn(QefObjektj.map.yn((int) xn()));
		nunangul = r.nextInt(plejangul-90)+90;
		potenc = plejpotenc/4;
		vivazharmilar = new Vivazharmilar((Armil) Objektregistril.objektjn(500));
		qatingec = true;
		qgxisdatigatingecn = false;
		
		ordenBildj(Konstantj.canonAngulnombr, canonSprite);
		ordenBildj(ordenSpec, sprite.spritejn());
		
		largxVivazh = 24;
		altVivazh = 24;
		LIMJ[0] = new Rectangle((int) xn(), (int) yn(), largxVivazh, altVivazh);
	}
	
	protected void ordenBildj(final int spec, final BufferedImage[] tempbildj) {
		switch(spec) {
			case 0:
				break;
			case 1://TODO faru ke la bildoj generigxos kiam la ludanto acxetu la habilidad de escalar montoj(eble ne faru tion) kaj tio estas uzita en la metodo de la atoma misilo
				bildj = new BufferedImage[rotaciplejNombr/2];
				final int duonLong = bildj.length/2;
				for(int i = -duonLong; i < duonLong; i++)
					bildj[i + duonLong] = Bildperant.volvBildn(tempbildj[0], -(ROTACI * i));
				break;
		}
	}
	
	protected void ordenBildj(final int angulnombr, final BufferedImage tempbild) {//FIXME CXi tiu metodo estas ne efika
		canonBildj = new BufferedImage[angulnombr];
		double rotacij = 2*Math.PI/angulnombr;
		
		for(int i = 0; i < canonBildj.length; i++)
			canonBildj[i] = Bildperant.volvBildn(tempbild, tempbild.getWidth()/2, tempbild.getHeight()/2 - 2,
					rotacij * (i+180));
	}
	
	@Override
	public void gxisdatig() {
		if(vivn()<=0)
			return;
		if(venontDamagxit > 0)
			venontDamagxit -= 1000000/60;
		gxisdatigAtakn();
		yangxMapn();
		yangxSpriten();
		mov();
		anim();
	}
	
	private void mov() {
		if(Kontrolperant.klavar.dextr.pulsitan() && !Kontrolperant.klavar.mldextr.pulsitan() && brulazh>0) {
			
			pliX();
			nunBild = statn((int) xn());
			if(nunBild<movec || nunBild>duonrotaciplejNombr - movec) {
				mlpliX();
			}
			
			setYn(QefObjektj.map.yn()[(int) xn()]);
			if(qatingec)
				qgxisdatigatingecn = true;
		}
		if(Kontrolperant.klavar.mldextr.pulsitan() && !Kontrolperant.klavar.dextr.pulsitan() && brulazh>0) {
			mlpliX();
			nunBild = statn((int) xn());
			if(nunBild<movec || nunBild>duonrotaciplejNombr - movec) {
				pliX();
			}
			
			setYn(QefObjektj.map.yn()[(int) xn()]);
			if(qatingec)
				qgxisdatigatingecn = true;
		}
		if(Kontrolperant.klavar.supr.pulsitan() && !Kontrolperant.klavar.sub.pulsitan()) {
			plinunanguln();
			
			if(qatingec)
				qgxisdatigatingecn = true;
		}
		if(Kontrolperant.klavar.sub.pulsitan() && !Kontrolperant.klavar.supr.pulsitan()) {
			mlplinunanguln();
			
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
			atingec = Bildperant.atingecMisil(((Misil) Estazhregistril.estaezhjn(nunArmil)).trajekt.atingecn());
			qgxisdatigatingecn = false;
		}
		if(Kontrolperant.klavar.supriArmil) {
			if(++nunArmil>4)
				nunArmil--;
			Kontrolperant.klavar.supriArmil = false;
		}
		if(Kontrolperant.klavar.subiArmil) {
			if(nunArmil>0)
				nunArmil--;
			Kontrolperant.klavar.subiArmil = false;
		}
	}
	
	private void yangxSpriten() {
	}
	
	private void gxisdatigAtakn() {
		if (Kontrolperant.klavar.qatak) {
			Vicperant.setNunMisiln((Misil) Estazhregistril.estaezhjn(nunArmil));
			Kontrolperant.klavar.qatak = false;
		}
		if(Vicperant.nunMisiln()==null)
			Kontrolperant.klavar.qatak = false;
	}
	@Override
	protected void anim() {
		if(qmovant) {
			plejangul = ANTAWDEFINITPLEJANGUL + (int) Math.toDegrees((offsetLudantX*8)*ROTACI);
			mlplejangul = plejangul - 180;
			
			if(nunangul>plejangul)
				nunangul = plejangul;
			else if(nunangul<mlplejangul)
				nunangul = mlplejangul;
			
			qmovant = false;
		}
	}
	//TODO SXangxu la klaso de tiu metodo
	private int statn(final int x) {
		radX1 = (int) (ANTAWDEFINITRAD_X1 + offsetLudantX);
		radX2 = (int) (ANTAWDEFINITRAD_X2 + offsetLudantX);
		
		double y1 = QefObjektj.map.yn()[(int) (Map.xn(x, radX1))];
		double y2 = QefObjektj.map.yn()[(int) (Map.xn(x, radX2))];
		
		double angul = Math.atan2(y2 - y1, radX2 - radX1);
		
		for(int i = -DUONKVANTSTATJ; i < DUONKVANTSTATJ; i++)
			if(angul>ROTACI*i && angul<ROTACI*(i+1)) {
				offsetLudantX = -i/7;
				return DUONKVANTSTATJ + i;
			}
		
		offsetLudantX = 0;
		return DUONKVANTSTATJ;
	}
	
	@Override
	public void desegn() {
		if(vivn()<=0)
			return;
		int posiciY = (int) Kvantperant.koordenadYalekranPosicin((int)yn()) + offsetLudantY;
		DebugDesegn.desegnBildn(bildj[nunBild], (int) (Kvantperant.koordenadXalekranPosicin(xn()) + offsetLudantX
				- (largxVivazhn()>>1)), posiciY - bildj[nunBild].getHeight());
		
		DebugDesegn.desegnBildn(canonBildj[nunangul + 90], (int) (Kvantperant.koordenadXalekranPosicin(xn()) +
				offsetCanonX - (largxVivazhn()>>1) + offsetLudantX*0.9), posiciY - bildj[nunBild].getHeight());
		
		if(atingec!=null && Vicperant.nunMisiln() == null) {
			if(nunangul>90)
				DebugDesegn.desegnBildn(atingec, (int) Kvantperant.koordenadXalekranPosicin(xn()),
						(int) Kvantperant.koordenadYalekranPosicin(yn()) - atingec.getHeight());
			else {
				DebugDesegn.desegnBildn(atingec, (int) Kvantperant.koordenadXalekranPosicin(xn()) -
						atingec.getWidth(), (int) Kvantperant.koordenadYalekranPosicin(yn()) - atingec.getHeight());
			}
			if(qgxisdatigatingecn)
				atingec = null;
		}
		if(Kontrolperant.klavar.debug)
			DebugDesegn.desegnMargxenRectangle((int) (Kvantperant.koordenadXalekranPosicin(xn()) + offsetLudantX
					- (largxVivazhn()>>1)), posiciY - bildj[nunBild].getHeight(), bildj[nunBild].getWidth(),
					bildj[nunBild].getHeight(), Color.BLUE);
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
	public void mlplinunanguln() {
		if(nunangul>mlplejangul)
			nunangul--;
	}
	public void plinunanguln() {
		if(++nunangul>=plejangul)
			nunangul--;
	}
	public int nunanguln() {
		return nunangul;
	}
	@Override
	public void resetVivn() {
		super.resetVivn();
		plejpotenc = (int) viv;
	}
	@Override
	public void mlgajnVivn(final double vivo) {
		super.mlgajnVivn(vivo);
		if(plejpotenc>viv) {
			plejpotenc = (int) viv;
			if(potenc>plejpotenc)
				potenc = plejpotenc;
		}
	}
	@Override
	public void setYn(final double yo) {
		super.setYn(yo);
		qmovant = true;
		anim();
	}
	
	public int offsetLudantXn() {
		return (int) offsetLudantX;
	}
	
}
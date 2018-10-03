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
	private final static int ANTAWDEFINITRAD_X1 = -10, ANTAWDEFINITRAD_X2 = 11;
	private int radX1 = ANTAWDEFINITRAD_X1, radX2 = ANTAWDEFINITRAD_X2;
	private int offsetLudantY = 2;
	private int offsetLudantX = 0;
	private int offsetCanonX = -2, offsetCanonY = 1, offsetCanonY2 = 3;
	private static final int ANTAWDEFINITPLEJANGUL = Konstantj.canonAngulnombr/2;
	public int plejangul, mlplejangul;
	public Misil m;
	protected Vivazharmilar vivazharmilar;
	private boolean qatingec, qgxisdatigatingecn;
	private BufferedImage atingec;
	
	public int plejpotenc = 100;
	public int potenc;
	private int nunangul;
	private int experienc = 100;
	public static final SpriteFoli ludantsprite0 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32,
			Transparency.TRANSLUCENT, Color.GREEN.darker());
	public static final SpriteFoli ludantsprite1 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png", 32,
			Transparency.TRANSLUCENT, Color.RED);
	public static final SpriteFoli ludantsprite2 = new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png",
			Transparency.TRANSLUCENT, 32, 32, Color.CYAN.darker());
	public static final BufferedImage armil = YargxilAzhj.yargxBildn(Konstantj.ITENER_LUDANT_CANON + 0 + ".png",
			Transparency.TRANSLUCENT, 36, 38);
	
	public Ludant(final int ordenSpec, final String itenerSon, final SpriteFoli sprite,
			final BufferedImage canonSprite) {
		super(1, 100, itenerSon);
		Random r = new Random();
		setXn(r.nextInt(QefObjektj.map.yn().length));
		setYn(QefObjektj.map.yn((int) xn()));
		nunangul = r.nextInt(plejangul-90)+90;
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
				final int duonLong = bildj.length/2;
				for(int i = -bildj.length/2; i < duonLong; i++)
					bildj[i + bildj.length/2] = Bildperant.volvBildn(tempbildj[0], -(ROTACI * i));
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
		if(venontDamagxit > 0)
			venontDamagxit -= 1000000/60;
		if(m!=null) {//FIXME
			Kontrolperant.klavar.qatak = false;
			m.gxisdatig();
		} else {
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
		}
		if(Kontrolperant.klavar.mldextr.pulsitan() && !Kontrolperant.klavar.dextr.pulsitan() && brulazh>0) {
			mlpliX();
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
			atingec = Bildperant.atingecMisil(new Misil(nunangul, potenc, xn(), yn()).atingecn());
			qgxisdatigatingecn = false;
		}
	}
	
	private void yangxSpriten() {
	}
	
	private void gxisdatigAtakn() {
		if (Kontrolperant.klavar.qatak) {
			m = new Misil(nunangul, potenc, xn(), yn());
		}
	}
	@Override
	protected void anim() {
		if(qmovant) {
			nunBild = statn();
			plejangul = ANTAWDEFINITPLEJANGUL + (int) Math.toDegrees((offsetLudantX)*ROTACI);
			mlplejangul = plejangul - 180;
			
			if(nunangul>plejangul)
				nunangul = plejangul;
			else if(nunangul<mlplejangul)
				nunangul = mlplejangul;
			
			qmovant = false;
		}
	}
	//TODO SXangxu la klaso de tiu metodo
	private int statn() {
		radX1 = ANTAWDEFINITRAD_X1 + offsetLudantX;
		radX2 = ANTAWDEFINITRAD_X2 + offsetLudantX;
		
		int x1 = (int) Map.xn((int) xn(), radX1);
		int x2 = (int) Map.xn((int) xn(), radX2);
		
		double y1 = QefObjektj.map.yn()[(int) (Map.xn((int) xn(), radX1))];
		double y2 = QefObjektj.map.yn()[(int) (Map.xn((int) xn(), radX2))];
		
		double angul = Math.atan2(y2 - y1, x2 - x1);
		
		for(int i = -DUONKVANTSTATJ; i < DUONKVANTSTATJ; i++)
			if(angul>ROTACI*i && angul<ROTACI*(i+1)) {
				offsetLudantX = -i;
				return DUONKVANTSTATJ + i;
			}
		
		offsetLudantX = 0;
		return DUONKVANTSTATJ;
	}
	
	@Override
	public void desegn() {
		int posiciY = (int) Kvantperant.koordenadYalekranPosicin((int)yn()) + offsetLudantY;
		DebugDesegn.desegnBildn(bildj[nunBild], (int) Kvantperant.koordenadXalekranPosicin(xn()) + offsetLudantX
				- (Vicperant.nunludantn().largxVivazhn()>>1), posiciY - bildj[nunBild].getHeight());
		
		DebugDesegn.desegnBildn(canonBildj[nunangul + 90], (int) Kvantperant.koordenadXalekranPosicin(xn()) +
				offsetCanonX - (Vicperant.nunludantn().largxVivazhn()>>1), posiciY - bildj[nunBild].getHeight());
		
		if(m!=null)//FIXME
			m.desegn();
		if(atingec!=null && Vicperant.ludantj[Vicperant.nunLudantn()]==this) {
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
	
}
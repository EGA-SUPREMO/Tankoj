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
import qef.inventar.armil.Senarma;
import qef.kontrolj.Kontrolperant;
import qef.map.Map;
import qef.sprite.SpriteFoli;

public class Ludant extends Vivazh {

	protected BufferedImage[] bildj, canonBildj;
	private int radX1 = -10, radX2 = 11;
	private int offsetLudantY = 2;
	private int offsetCanonX = -2, offsetCanonY = 1;
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
		super(1, itenerSon);
		
		setXn(new Random().nextInt(QefObjektj.map.yn().length));
		setYn(QefObjektj.map.yn((int) xn()));
		nunangul = 46;
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
			gxisdatigArmiljn();
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
			atingec = Bildperant.atingecMisil(new Misil(nunangul, potenc, (int) xn(), (int) yn()).atingecn());
			qgxisdatigatingecn = false;
		}
	}
	
	private void yangxSpriten() {
		if(Konstantj.qyangxSpriteFoli) {
			Konstantj.qyangxSpriteFoli = false;
			if(vivazharmilar.armil1n() instanceof Senarma) {
				setSpriteFoli(ludantsprite1, 0);
				return;
			}
			if(vivazharmilar.armil1n() instanceof Armil)
				setSpriteFoli(ludantsprite0, 0);
		}
	}
	
	private void gxisdatigArmiljn() {
	}
	@Override
	protected void anim() {
		nunBild = statn();
	}
	//TODO SXangxu la klaso de tiu metodo
	private int statn() {
		
		int x1 = (int) Map.xn((int) xn(), radX1);
		int x2 = (int) Map.xn((int) xn(), radX2);
		
		double y1 = QefObjektj.map.yn()[(int) (Map.xn((int) xn(), radX1))];
		double y2 = QefObjektj.map.yn()[(int) (Map.xn((int) xn(), radX2))];
		
		double angul = Math.atan2(y2 - y1, x2 - x1);
		
		for(int i = 0; i < KVANTSTATJ; i++)
			if(angul>rotaci*i && angul<rotaci*(i+1)) {
				return i;
			}
		
		return 0;
	}
	
	@Override
	public void desegn() {
		int posiciY = (int) Kvantperant.koordenadYalekranPosicin((int)yn()) - bildj[nunBild].getHeight() +
				offsetLudantY;
		DebugDesegn.desegnBildn(bildj[nunBild], (int) Kvantperant.koordenadXalekranPosicin(xn()), posiciY);
		
		DebugDesegn.desegnBildn(canonBildj[nunangul], (int) Kvantperant.koordenadXalekranPosicin(xn()) +
				offsetCanonX, posiciY + offsetCanonY);
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
	
}
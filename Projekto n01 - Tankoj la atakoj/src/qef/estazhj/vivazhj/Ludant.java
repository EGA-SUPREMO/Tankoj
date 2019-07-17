package qef.estazhj.vivazhj;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Random;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.kampfort.Kampfort;
import qef.estazhj.vivazhj.kampfort.Kampfortregistril;
import qef.estazhj.vivazhj.misil.Misil;
import qef.estazhj.vivazhj.misil.Misilregistril;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;
import qef.kontrolj.Kontrolperant;
import qef.map.Map;
import qef.sprite.SpriteFoli;

public class Ludant extends Vivazh implements Externalizable {
	
	private static final long serialVersionUID = 1L;
	
	private final int id;
	private static int nunId = -1;
	
	private BufferedImage[] bildj, canonBildj;
	private final static int ANTAWDEFINITRAD_X1 = -8, ANTAWDEFINITRAD_X2 = 8;
	private int radX1 = ANTAWDEFINITRAD_X1, radX2 = ANTAWDEFINITRAD_X2;
	private int offsetLudantY = 2;
	private double offsetLudantX = 0;
	@SuppressWarnings("unused")
	private int offsetCanonX = 0, offsetCanonY = 1, offsetCanonY2 = 3;
	private static final int ANTAWDEFINITPLEJANGUL = Konstantj.canonAngulnombr/2;
	public int plejangul, mlplejangul;
	protected int[] armilar;
	private boolean qatingec, qgxisdatigatingecn;
	private BufferedImage atingec;
	private Color dukolor;
	
	private int movec = 0;//duonrotaciplejNombr>>4;
	public int plejpotenc = 100;
	public int potenc;
	private int nunangul;
	private double mon = 0;
	
	public int teleirazhj = 7;
	public int nunArmil = 1;
	private String nom;
	private Color kolor;
	public double mediRapidecX = 0.7;
	public double eficientBrulazh = 1;//0.05
	private int brulazh;
	public int plejbrulazh;
	private int revivil;
	public int largxVivazhKolici;
	public int altVivazhKolici;
	private int[] kampfortnombrj;
	private Kampfort nunuzitKampfort;
	private int nunKampfort = 0;
	
	public Ludant() {
		super(1, 100, null);
		
		nunId++;
		id = nunId;
		plejbrulazh = 3000;
		
		definigad();
		armilar = komnecarmilarn();
		kampfortnombrj = komencKampfortjn();
		qatingec = false;
		qgxisdatigatingecn = false;
		nom = "Joseph";
		kolor = Color.GRAY;
		revivil = 8;
		dukolor = Color.BLACK;
		
		ordenBildj(Konstantj.canonAngulnombr, Konstantj.armil);
		ordenBildj(1, new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png",
				Transparency.TRANSLUCENT, 24, 24, kolor).spritejn());

		largxVivazh = 24;
		altVivazh = 24;
		
		altVivazhKolici = altVivazh/2 - offsetLudantY*2;
		largxVivazhKolici = altVivazhKolici;
		LIMJ[0] = new Rectangle((int) xn(), (int) yn(), largxVivazh, altVivazh);
	}
	
	public Ludant(final int ordenSpec, final String nomo, final String itenerSon, final Color koloro,
			final BufferedImage canonSprite, final Color dukoloro) {
		super(1, 100, itenerSon);
		
		nunId++;
		id = nunId;
		plejbrulazh = 3000;
		
		definigad();
		armilar = komnecarmilarn();
		kampfortnombrj = komencKampfortjn();
		qatingec = false;
		qgxisdatigatingecn = false;
		nom = nomo;
		kolor = koloro;
		revivil = 8;
		dukolor = dukoloro;
		
		ordenBildj(Konstantj.canonAngulnombr, canonSprite);
		ordenBildj(ordenSpec, new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png",
				Transparency.TRANSLUCENT, 24, 24, kolor).spritejn());

		largxVivazh = 24;
		altVivazh = 24;
		
		//largxVivazhKolici = largxVivazh - offsetLudantY;
		altVivazhKolici = altVivazh/2 - offsetLudantY*2;
		largxVivazhKolici = altVivazhKolici;
		LIMJ[0] = new Rectangle((int) xn(), (int) yn(), largxVivazh, altVivazh);
	}
	
	private int[] komencKampfortjn() {
		final int[] novKampj = new int[Konstantj.PLEJ_KAMPFORTJ];
		
		for(int i = 0; i < novKampj.length; i++)
			novKampj[i] = 8;
		
		return novKampj;
	}

	private int[] komnecarmilarn() {
		final int[] novarmilar = new int[Konstantj.PLEJ_MISILJ];
		
		novarmilar[0] = 999999;
		novarmilar[1] = 50;
		novarmilar[2] = 25;
		novarmilar[3] = 5;
		novarmilar[4] = 1;
		novarmilar[5] = 10;
		
		
		return novarmilar;
	}

	protected void ordenBildj(final int spec, final BufferedImage[] tempbildj) {
		switch(spec) {
			case 0:
				break;
			case 1:
				bildj = new BufferedImage[duonrotaciplejNombr];
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
			yangxRapidec();
			pliXn();
			nunBild = statn((int) xn());
			if(nunBild<movec || nunBild>duonrotaciplejNombr - movec) {
				mlpliXn();
			}
			
			setYn(QefObjektj.map.yn()[(int) xn()]);
			if(qatingec)
				qgxisdatigatingecn = true;
		}
		if(Kontrolperant.klavar.mldextr.pulsitan() && !Kontrolperant.klavar.dextr.pulsitan() && brulazh>0) {
			yangxRapidec();
			mlpliXn();
			nunBild = statn((int) xn());
			if(nunBild<movec || nunBild>duonrotaciplejNombr - movec) {
				pliXn();
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
			atingec = Bildperant.atingecMisil(((Misil) Misilregistril.misiljn(nunArmil)).trajekt.atingecn());
			qgxisdatigatingecn = false;
		}
		if(Kontrolperant.klavar.supriArmil) {
			pliNunArmiln();
			Kontrolperant.klavar.supriArmil = false;
		}
		if(Kontrolperant.klavar.subiArmil) {
			mlpliNunArmiln();
			Kontrolperant.klavar.subiArmil = false;
		}
		if(Kontrolperant.klavar.supriKampfort) {
			pliNunKampfortn();
			Kontrolperant.klavar.supriKampfort = false;
		}
		if(Kontrolperant.klavar.subiKampfort) {
			mlpliNunKampfortn();
			Kontrolperant.klavar.subiKampfort = false;
		}
		if(nunuzitKampfort!=null)
			nunuzitKampfort.gxisdatig();
		else if(Kontrolperant.klavar.uziKampfort) {
			mlpliKampfortn();
			Kontrolperant.klavar.uziKampfort = false;
		}
		
		
	}
	public void uzReviviln() {
		if(revivil>0 && viv<plejviv) {
			revivil--;
			viv += 10;
			if(viv>plejviv)
				viv = plejviv;
			if(viv<100)
				plejpotenc = (int) viv;
			else
				plejpotenc = 100;
		}
	}
	private void yangxSpriten() {
	}
	
	private void gxisdatigAtakn() {
		if (Kontrolperant.klavar.qatak) {
			Vicperant.setNunMisiln(Misilregistril.misiljn(nunArmil));
			mlpliArmilarn();
			Kontrolperant.klavar.qatak = false;
		}
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
		
		for(int i = -KVANTSTATJ; i < KVANTSTATJ; i++)
			if(angul>ROTACI*i && angul<ROTACI*(i+1)) {
				offsetLudantX = -i/7;
				return KVANTSTATJ + i;
			}
		
		offsetLudantX = 0;
		return KVANTSTATJ;
	}
	private void yangxRapidec() {
		if(Kontrolperant.klavar.kuri) {
			rapidecX = mediRapidecX*4;
		}else {
			rapidecX = mediRapidecX;
		}
	}
	@Override
	public void desegn() {
		if(vivn()<=0)
			return;
		int posiciY = (int) Kvantperant.koordenadYalekranPosicin((int)yn());
		DebugDesegn.desegnBildn(bildj[nunBild], (int) (Kvantperant.koordenadXalekranPosicin(xn()) + offsetLudantX
				- (largxVivazhn()>>1)), posiciY - bildj[nunBild].getHeight());
		
		DebugDesegn.desegnBildn(canonBildj[nunangul + 90], (int) (Kvantperant.koordenadXalekranPosicin(xn()) +
				offsetCanonX - (largxVivazhn()>>1) + offsetLudantX*0.9), posiciY - bildj[nunBild].getHeight());
		
		if(nunuzitKampfort!=null)
			nunuzitKampfort.desegn();
		
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
		if(Kontrolperant.klavar.debug) {
			final Rectangle r = nunposiciare();
			if(nunuzitKampfort!=null)
				r.y += (nunuzitKampfort.largxVivazh);
			DebugDesegn.desegnMargxenRectangle((int) (Kvantperant.koordenadXalekranPosicin(r.x)),
					(int) (Kvantperant.koordenadYalekranPosicin(r.y)), r.width, r.height, Color.BLUE);
		}
	}

	public void setSpriteFoli(final SpriteFoli foli, final int ordenSpec) {
		ordenBildj(ordenSpec, foli.spritejn());
	}
	
	public double monn() {
		return mon;
	}
	@Override
	public void pliXn() {
		super.pliXn();
		brulazh -= rapidecX*rapidecX*eficientBrulazh;
	}
	@Override
	public void pliYn() {
		super.pliYn();
		brulazh -= rapidecY*eficientBrulazh;
	}
	@Override
	public void mlpliXn() {
		super.mlpliXn();
		brulazh -= rapidecX*rapidecX*eficientBrulazh;
	}
	@Override
	public void mlpliYn() {
		super.mlpliYn();
		brulazh -= rapidecY*eficientBrulazh;
	}

	public void mlplinunanguln() {
		nunangul -= Konstantj.ANGULRAPIDEC;
		if(nunangul<mlplejangul)
			nunangul = mlplejangul;
	}
	public void plinunanguln() {
		nunangul += Konstantj.ANGULRAPIDEC; 
		if(nunangul>=plejangul)
			nunangul -= Konstantj.ANGULRAPIDEC;
	}
	public int nunanguln() {
		return nunangul;
	}

	private void pliNunArmiln() {
		if(++nunArmil>=Konstantj.PLEJ_MISILJ)
			nunArmil = 0;
		if(armilar[nunArmil]<1)
			pliNunArmiln();
	}
	private void mlpliNunArmiln() {
		if(nunArmil>0)
			nunArmil--;
		else
			nunArmil = Konstantj.PLEJ_MISILJ-1;
		if(armilar[nunArmil]<1)
			mlpliNunArmiln();
	}
	private void mlpliArmilarn() {
		armilar[nunArmil]--;
		if(armilar[nunArmil]<1)
			pliNunArmiln();
	}
	private void pliNunKampfortn() {
		if(++nunKampfort>=Konstantj.PLEJ_KAMPFORTJ)
			nunKampfort = 0;
		if(havasKampfortjn())//TODO cxi tiu metodo povas esti plie efika
			if(armilar[nunArmil]<1)
				pliNunKampfortn();
	}

	private void mlpliNunKampfortn() {
		if(nunKampfort>0)
			nunKampfort--;
		else
			nunKampfort = Konstantj.PLEJ_KAMPFORTJ-1;
		if(armilar[nunArmil]<1)
			mlpliNunKampfortn();
	}
	private void mlpliKampfortn() {
		if(kampfortnombrj[nunKampfort] == 0)
			return;
		kampfortnombrj[nunKampfort]--;
		
		nunuzitKampfort = Kampfortregistril.kampfortjn(nunKampfort);
		if(kampfortnombrj[nunKampfort]<1)
			pliNunKampfortn();
	}
	private boolean havasKampfortjn() {
		for(int i = 0; i < Konstantj.PLEJ_KAMPFORTJ; i++)
			if(kampfortnombrj[i]>0)
				return true;
		return false;
	}
	public int[] armilarn() {
		return armilar;
	}
	public int[] kampfortnombrjn() {
		return kampfortnombrj;
	}
	public void pliMonn(final double mono) {
		mon += mono;
	}
	@Override
	public void resetVivn() {
		super.resetVivn();
		plejpotenc = (int) viv;
		definigad();
		nunuzitKampfort = null;
	}
	@Override
	public void mlgajnVivn(final double vivo, final int plejdamagx, final int nunLudant) {
		super.mlgajnVivn(vivo, plejdamagx, nunLudant);
		plejpotenc = (int) viv;
		if(potenc>viv)
			potenc = plejpotenc;
		
	}
	@Override
	public void setYn(final double yo) {
		super.setYn(yo - offsetLudantY);
		brulazh -= (yn() > yo? yn() - yo : yo - yn())*eficientBrulazh;
		qmovant = true;
		anim();
	}
	@Override
	public void setXn(final double xo) {
		super.setXn(xo);
		qmovant = true;
		anim();
	}
	public String nomn() {
		return nom;
	}
	public int offsetLudantXn() {
		return (int) offsetLudantX;
	}
	public Color kolorn() {
		return kolor;
	}
	public Color dukolorn() {
		return dukolor;
	}
	@Override
	public void definigad() {
		super.definigad();
		Random r = new Random();
		setXn(r.nextInt((int) ((QefObjektj.map.yn().length/Vicperant.plejLudant)*0.75)) +
				(QefObjektj.map.yn().length/Vicperant.plejLudant)*id +
				(QefObjektj.map.yn().length/Vicperant.plejLudant)*0.12);
		setYn(QefObjektj.map.yn((int) xn()));
		
		nunangul = r.nextInt(ANTAWDEFINITPLEJANGUL-90)+90;
		potenc = plejpotenc/2;
		nunBild = statn((int) xn());
		brulazh = plejbrulazh;
		
		anim();
	}
	@Override
	public Rectangle nunposiciare() {
		if(nunuzitKampfort==null) {
			final int o = (int) (offsetLudantX<0? -offsetLudantX: offsetLudantX);
			final int od = (int) (offsetLudantX<0? -1: 1);
			return new Rectangle((int) (xn() - (largxVivazhKolici>>1) + Math.sqrt(o)*od), (int) (yn() + (altVivazh>>1)), largxVivazhKolici, altVivazhKolici);
		} else
			return new Rectangle((int) (xn() - (nunuzitKampfort.largxVivazh>>1) + offsetLudantX), (int) (yn() +
					largxVivazhKolici - (nunuzitKampfort.largxVivazh>>1)), nunuzitKampfort.largxVivazh,
					nunuzitKampfort.largxVivazh);
	}

	public void forigKampfortn() {
		nunuzitKampfort = null;
	}
	public Kampfort nunuzitKampfortn() {
		return nunuzitKampfort;
	}

	public int reviviln() {
		return revivil;
	}
	public int brulazhn() {
		return brulazh;
	}
	public int nunKampfortn() {
		return nunKampfort;
	}

	public int plejvivn() {
		return plejviv;
	}
	@Override
	public void writeExternal(ObjectOutput o) throws IOException {
		o.writeObject(nomn());
		o.writeDouble(monn());
		o.writeDouble(resistencn());
		o.writeDouble(eficientBrulazh);
		
		o.writeInt(teleirazhj);
		o.writeInt(plejvivn());
		o.writeInt(reviviln());
		o.writeInt(plejbrulazh);
		
		o.writeObject(armilarn());
		o.writeObject(kampfortnombrjn());
		
		o.writeObject(kolorn());
		o.writeObject(dukolorn());
	}
	@Override
	public void readExternal(ObjectInput o) throws IOException, ClassNotFoundException {
		nom = (String) o.readObject();
		mon = o.readDouble();
		resistenc = o.readDouble();
		eficientBrulazh = o.readDouble();

		teleirazhj = o.readInt();
		plejviv = o.readInt();
		revivil = o.readInt();
		plejbrulazh = o.readInt();

		armilar = (int[]) o.readObject();
		kampfortnombrj = (int[]) o.readObject();

		kolor = (Color) o.readObject();
		dukolor = (Color) o.readObject();
		
		definigad();
		
		ordenBildj(Konstantj.canonAngulnombr, Konstantj.armil);
		ordenBildj(1, new SpriteFoli(Konstantj.ITENER_LUDANT + 0 + ".png",
				Transparency.TRANSLUCENT, 24, 24, kolor).spritejn());
	}
}
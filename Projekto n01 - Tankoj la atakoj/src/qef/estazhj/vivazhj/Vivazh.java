package qef.estazhj.vivazhj;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.Estazh;
import qef.ilj.Bildperant;
import qef.ilj.BruGeneril;
import qef.inventar.Objektregistril;
import qef.inventar.armil.Armil;
import qef.son.Son;
import qef.sprite.SpriteFoli;

public abstract class Vivazh implements Estazh {
	/*
	 * 
	 * 0:supre aux sube
	 * 1:maldekstre
	 * 2:dekstre
	 * 
	 */
	private double x, y;
	protected final Rectangle[] LIMJ;
	protected BufferedImage[] bildj;
	protected boolean movante;
	protected int nunBild;
	protected int frekvenciAnimaci;
	protected Vivazharmilar vivazharmilar;
	
	protected int direkt;
	protected static final int KVANTDIREKTJ = 8;
	protected static final int KVANTSTATJ = 16;
	protected final int rotaciplejNombr = KVANTSTATJ*2;
	protected final double rotaci = 2*Math.PI/rotaciplejNombr;
	protected int vivazhstat = 0;
	protected int animacistat;
	protected double rapidec;
	
	protected int largxVivazh, altVivazh;
	protected int brulazh;
	protected int viv, plejviv;
	private int damagx;
	protected ArrayList<Rectangle> nunatingec;
	
	protected Son damagxit;
	protected long longDamagxit, venontDamagxit;

	public Vivazh(final int ordenSpec, final int limj, final SpriteFoli sprite, final String itenerSon) {
		
		this.largxVivazh = 32;
		this.altVivazh = 32;
		this.animacistat = 0;
		this.nunBild = 0;
		this.rapidec = 1;
		brulazh = 20000;
		direkt = 1;
		movante = false;
		frekvenciAnimaci = 10;
		x = 0;
		y = 0;
		viv = 100;
		plejviv = viv;
		damagx = 100;
		nunatingec = new ArrayList<>();
		vivazharmilar = new Vivazharmilar((Armil) Objektregistril.objektjn(599));
		LIMJ = new Rectangle[limj];
		
		damagxit = new Son(itenerSon, 0);
		longDamagxit = damagxit.longsonn();
		
		ordenBildj(ordenSpec, sprite.spritejn());
		
	}
	
	public Vivazh(final int ordenSpec, final float rapidec, final int largxVivazh, final int altVivazh, final 
			int plejviv, final Rectangle[] limj, final SpriteFoli sprite, final String itenerSon) {
		
		this.largxVivazh = largxVivazh;
		this.altVivazh = altVivazh;
		this.animacistat = 0;
		this.nunBild = 0;
		this.rapidec = rapidec;
		this.movante = false;
		this.direkt = 1;
		this.frekvenciAnimaci = 10;
		this.viv = plejviv;
		this.plejviv = plejviv;
		LIMJ = limj;

		nunatingec = new ArrayList<>();
		vivazharmilar = new Vivazharmilar((Armil) Objektregistril.objektjn(599));

		damagxit = new Son(itenerSon, 0);
		longDamagxit = damagxit.longsonn();
		
		ordenBildj(ordenSpec, sprite.spritejn());
	}
	
	private void ordenBildj(final int spec, final BufferedImage[] tempbildj) {
		switch(spec) {
			case 0:
				bildj = new BufferedImage[64];
				//oeste
				bildj[0 ] = Bildperant.volvBildn(tempbildj[0], 0.7853981633974483D);
				bildj[8 ] = Bildperant.volvBildn(bildj[0], 0.7853981633974483D);
				bildj[16] = Bildperant.volvBildn(bildj[8], 0.7853981633974483D);
				bildj[24] = Bildperant.volvBildn(bildj[16], 0.7853981633974483D);
				bildj[32] = Bildperant.volvBildn(bildj[24], 0.7853981633974483D);
				bildj[40] = Bildperant.volvBildn(bildj[32], 0.7853981633974483D);
				bildj[48] = Bildperant.volvBildn(bildj[40], 0.7853981633974483D);
				bildj[56] = Bildperant.volvBildn(bildj[48], 0.7853981633974483D);
				//sur
				bildj[1] = tempbildj[2];
				bildj[9] = bildj[1];
				bildj[17] = tempbildj[3];
				bildj[25] = bildj[17];
				bildj[33] = bildj[1];
				bildj[41] = bildj[1];
				bildj[49] = bildj[17];
				bildj[57] = bildj[17];
				//suroeste
				bildj[2] = Bildperant.volvBildn(bildj[1], 0.7853981633974483D);
				bildj[10] = bildj[2];
				bildj[18] = Bildperant.volvBildn(bildj[17], 0.7853981633974483D);
				bildj[26] = bildj[18];
				bildj[34] = bildj[2];
				bildj[42] = bildj[2];
				bildj[50] = bildj[18];
				bildj[58] = bildj[18];
				//nordo
				bildj[3] = bildj[1];
				bildj[11] = bildj[1];
				bildj[19] = bildj[17];
				bildj[27] = bildj[17];
				bildj[35] = bildj[1];
				bildj[43] = bildj[1];
				bildj[51] = bildj[17];
				bildj[59] = bildj[17];
				//noroeste
				bildj[4] = Bildperant.volvBildn(bildj[1], 0.7853981633974483D);
				bildj[12] = bildj[4];
				bildj[20] = Bildperant.volvBildn(bildj[17], 0.7853981633974483D);
				bildj[28] = bildj[20];
				bildj[36] = bildj[4];
				bildj[44] = bildj[4];
				bildj[52] = bildj[20];
				bildj[60] = bildj[20];
				//este
				bildj[5] = bildj[56];
				bildj[13] = bildj[48];
				bildj[21] = bildj[40];
				bildj[29] = bildj[32];
				bildj[37] = bildj[24];
				bildj[45] = bildj[16];
				bildj[53] = bildj[8];
				bildj[61] = bildj[0];
				//sureste
				bildj[6] = Bildperant.volvBildn(bildj[1], -0.7853981633974483D);
				bildj[14] = bildj[6];
				bildj[22] = Bildperant.volvBildn(bildj[17], -0.7853981633974483D);
				bildj[30] = bildj[22];
				bildj[38] = bildj[6];
				bildj[46] = bildj[6];
				bildj[54] = bildj[22];
				bildj[62] = bildj[22];
				//noreste-------------------------
				bildj[7] = Bildperant.volvBildn(bildj[1], -0.7853981633974483D);
				bildj[15] = bildj[6];
				bildj[23] = Bildperant.volvBildn(bildj[17], -0.7853981633974483D);
				bildj[31] = bildj[22];
				bildj[39] = bildj[6];
				bildj[47] = bildj[6];
				bildj[55] = bildj[22];
				bildj[63] = bildj[22];
				
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
	
/*	protected void mov() {
		if(animacistat >= 31)
			animacistat = 0;
		else
			animacistat++;
		
		nunBild = direkt + (animacistat/4) * KVANTDIREKT - 1;
		movante = false;
	}*/
	
	protected void anim() {
		
	}

	protected void yangxMapn() {
/*		if(QefObjektj.map.arejVenontMapn().intersects(LIMJ[0])) {
			
			QefObjektj.map = new Map(QefObjektj.map.venontMapn());
			
			x = QefObjektj.map.xLudantn();
			y = QefObjektj.map.yLudantn();
			
		}*/
	}
	
	protected boolean qnekolicie(final int direkt) {
/*		final int direktX;
		final int direktY;
		switch(direkt) {
			case 0:
				direktX = 0;
				direktY = -1;
				break;
			case 1:
				direktX = 0;
				direktY = 1;
				break;
			case 2:
				direktX = 1;
				direktY = 0;
				break;
			case 3:
				direktX = -1;
				direktY = 0;
				break;
			default:
				direktX = 0;
				direktY = 0;
		}
		
		for(int i = 0; i < map.arejKolici.size();i++) {
			final Rectangle area = map.arejKolici.get(i);
			
			final int origenX = area.x + (direktX * (int) rapidec << 1);
			final int origenY = area.y + (direktY * (int) rapidec << 1);
			
			/*final int origenX = area.x + direktX * (int) Math.round(rapidec) + 3 * (int) rapidec; //por fari pli reala
			final int origenY = area.y + direktY * (int) Math.round(rapidec) + 3 * (int) Math.round(rapidec);*/
			
			/*if (LIMJ[direkt].intersects(new Rectangle(origenX, origenY, Konstantj.SPRITELARGX, Konstantj.SPRITEALT))) {
				return false;
			}
		}*/
		return true;
	}
	
	protected boolean qena() {
		final int estontecX;
		final int estontecY;
		
		switch(direkt) {
			case 1:
				estontecX = (int) (x + rapidec);
				estontecY = (int) (y);
				break;
			case 2:
				estontecX = (int) (x);
				estontecY = (int) (y + rapidec);
				break;
			case 3:
				estontecX = (int) (x - rapidec);
				estontecY = (int) (y + rapidec);
				break;
			case 4:
				estontecX = (int) (x);
				estontecY = (int) (y - rapidec);
				break;
			case 5:
				estontecX = (int) (x + rapidec);
				estontecY = (int) (y - rapidec);
				break;
			case 6:
				estontecX = (int) (x - rapidec);
				estontecY = (int) (y);
				break;
			case 7:
				estontecX = (int) (x + rapidec);
				estontecY = (int) (y + rapidec);
				break;
			case 8:
				estontecX = (int) (x - rapidec);
				estontecY = (int) (y - rapidec);
				break;
			default:
				estontecX = (int) (x + rapidec);
				estontecY = (int) (y + rapidec);
		}
		Rectangle margxenMap = QefObjektj.map.margxen(estontecX, estontecY);
		
		if(LIMJ[0].intersects(margxenMap) || LIMJ[1].intersects(margxenMap) || LIMJ[2].intersects(margxenMap) ||
				LIMJ[3].intersects(margxenMap)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void desegn() {}
	
	@Override
	public void gxisdatig() {
		if(venontDamagxit > 0)
			venontDamagxit -= 1000000/60;
	}
	
	public double rapidecn() {
		return rapidec;
	}
	public void rapidec(final float rapidec) {
		this.rapidec = rapidec;
	}
	
	public int damagxn() {
		return damagx;
	}
	public int vivn() {
		return viv;
	}
	public int largxVivazhn() {
		return largxVivazh;
	}
	public int altVivazhn() {
		return altVivazh;
	}
/*	public Integer resistencn() {
		return resistenc;
	}*/

	public Rectangle[] LIMJN() {
		return LIMJ;
	}
	public double xn() {
		int xx =(int)x + Konstantj.duonLudLargx;
		if(x>=0) {
		}else if(x<0) {
//			setYn(QefObjektj.map.yn()[BruGeneril.mapgrandecn()-1]);
//			setXn(BruGeneril.mapgrandecn()-1);
		}
		return x;
	}
	public double yn() {
		return y;
	}
	
	public void pliX() {
		x += rapidec;
		brulazh -= rapidec;
	}
	public void pliY() {
		y += rapidec;
		brulazh -= rapidec;
	}
	public void mlpliX() {
		x -= rapidec;
		brulazh -= rapidec;
	}
	public void mlpliY() {
		y -= rapidec;
		brulazh -= rapidec;
	}
	public void setXn(final int x) {
		this.x = x;
	}
	public void setYn(final int y) {
		this.y = y;
	}
	public Vivazharmilar vivazharmilarn() {
		return vivazharmilar;
	}
	public void setSpriteFoli(final SpriteFoli foli, final int ordenSpec) {
		ordenBildj(ordenSpec, foli.spritejn());
	}
/*	public void setResistenc(final int resistenc) {
		this.resistenc = resistenc;
	}*/
	public ArrayList<Rectangle> nunatingecn() {
		return nunatingec;
	}
	public int direktn() {
		return direkt;
	}
	public Rectangle nunposiciare() {
		return new Rectangle((int) x, (int) y, largxVivazh, altVivazh);
	}


	public void malgajnVivn(int damagx) {
		if(venontDamagxit <= 0) {
			damagxit.play();
			venontDamagxit = longDamagxit;
		}
		
        if (viv - damagx < 0)
            viv = 0;
        else
            viv -= damagx;
	}
	
}
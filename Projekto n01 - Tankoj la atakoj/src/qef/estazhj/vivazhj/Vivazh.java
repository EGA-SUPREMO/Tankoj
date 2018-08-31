package qef.estazhj.vivazhj;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import qef.Konstantj;
import qef.estazhj.Estazh;
import qef.ilj.Bildperant;
import qef.map.Map;
import qef.sprite.SpriteFoli;

public abstract class Vivazh implements Estazh {
	/*
	 * 
	 * 0:supro
	 * 1:subo
	 * 2:dekstro
	 * 3:maldekstro
	 * 
	 */
	protected double x, y;
	protected final Rectangle[] LIMJ = new Rectangle[4];
	protected BufferedImage[] bildj;
	protected boolean movante;
	protected int nunBild;
	protected int frekvenciAnimaci;
	/* x = 8, y = 8
	 * 
	 * x =
	 * oeste = 1
	 * sur = 2
	 * suroeste = 3
	 * norte = 4
	 * noroeste = 5
	 * este = 6
	 * sureste = 7
	 * noreste = 8
	 * 
	 * y =
	 * statoj de animacio = 8
	 * 
	 */
	protected int direkt;
	protected static final int KVANTDIREKTJ = 8;
	protected static final int KVANTSTATJ = 8;
	protected int vivazhstat = 0;
	protected int animacistat;
	private int tempAkumulita = 0;
	protected float rapidec;
/*	private float kurrapidec, normalrapidec;//faru privata la varieblo kaj faru metodon por sxangxi la rapidecon, tio inkluzas la frek-
	private boolean qkur;					//vcio de la Animacion*/
	private Map map;
	protected int largxVivazh, altVivazh;
	protected Integer /*resistenc = Konstantj.plejResistenc,*/ restarigad = 0;//resistenco kaj re-starigado
	protected int viv;
	private int damagx;

	public Vivazh(final Map map,  final int ordenSpec, final SpriteFoli sprite) {
		
		this.largxVivazh = 16;
		this.altVivazh = 16;
		this.animacistat = 0;
		this.nunBild = 0;
		this.rapidec = 0.7f;
/*		this.normalrapidec = 0.7f;
		this.kurrapidec = 2.8f;
		this.rapidec = normalrapidec;*/
		this.direkt = 1;
		this.movante = false;
		this.frekvenciAnimaci = 10;
		this.map = map;
		this.x = map.xLudantn();
		this.y = map.yLudantn();
		this.viv = 100;
		this.damagx = 100;
		this.LIMJ[0] = new Rectangle(Konstantj.duonLudLargx - largxVivazh + 1, Konstantj.duonLudAlt - altVivazh,
				Konstantj.SPRITELARGX - 2, 1);
		this.LIMJ[1] = new Rectangle(Konstantj.duonLudLargx - largxVivazh + 1, Konstantj.duonLudAlt + altVivazh - 1,
				Konstantj.SPRITELARGX - 2, 1);
		this.LIMJ[2] = new Rectangle(Konstantj.duonLudLargx - largxVivazh, Konstantj.duonLudAlt - altVivazh + 1, 1,
				Konstantj.SPRITEALT - 2);
		this.LIMJ[3] = new Rectangle(Konstantj.duonLudLargx + largxVivazh, Konstantj.duonLudAlt - altVivazh + 1, 1,
				Konstantj.SPRITEALT - 2);
		
		ordenBildj(ordenSpec, sprite.spritejn());
		
	}
	
	public Vivazh(final Map map, final int ordenSpec, final float rapidec, final int largxVivazh, final int altVivazh, final
			int viv, final Rectangle[] limj, final SpriteFoli sprite) {
		
		this.largxVivazh = largxVivazh;
		this.altVivazh = altVivazh;
		this.animacistat = 0;
		this.nunBild = 0;
		this.rapidec = rapidec;
		this.movante = false;
		this.direkt = 1;
		this.frekvenciAnimaci = 10;
		this.map = map;
		this.viv = viv;
		for(int i = 0; i < limj.length;i++)
			this.LIMJ[i] = limj[i];
		
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
	
	protected void anim(final boolean movant) {
		
		if(movant) {
			
			if(qena())
				tempAkumulita++;
			
			if(tempAkumulita%frekvenciAnimaci == 0){
				animacistat++;
				if(!qena())
					tempAkumulita++;
				
				if(animacistat >= KVANTSTATJ)
					animacistat = 0;
				
			}
			
			nunBild = direkt + animacistat * KVANTDIREKTJ - 1;
			movante = false;
			
		}
		
	}
	
	protected boolean qnekolicie(final int direkt) {
		final int direktX;
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
		
/*		for(int i = 0; i < map.arejKolici.size();i++) {
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
		Rectangle margxenMap = map.margxen(estontecX, estontecY);
		
		if(LIMJ[0].intersects(margxenMap) || LIMJ[1].intersects(margxenMap) || LIMJ[2].intersects(margxenMap) ||
				LIMJ[3].intersects(margxenMap)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void desegn() {}
	
	public void gxisdatig() {}
	
	public Map mapn() {
		return map;
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
	public int restarigadn() {
		return restarigad;
	}
	public Rectangle[] LIMJN() {
		return LIMJ;
	}
	public double xn() {
		return x;
	}
	public double yn() {
		return y;
	}
	
	public void pliX() {
		if(qena()) {
			this.x += rapidec;
		}
	}
	public void pliY() {
		if(qena()) {
			this.y += rapidec;
		}
	}
	public void mlpliX() {
		if(qena()) {
			this.x -= rapidec;
		}
	}
	public void mlpliY() {
		if(qena()) {
			this.y -= rapidec;
		}
	}
	public void setX(final int x) {
		this.x = x;
	}
	public void setY(final int y) {
		this.y = y;
	}
/*	public void setResistenc(final int resistenc) {
		this.resistenc = resistenc;
	}*/
	
}
package qef.estazhj.vivazhj;

import java.awt.Rectangle;

import qef.QefObjektj;
import qef.estazhj.Estazh;
//import qef.son.Son;
import qef.ilj.Vicperant;

public abstract class Vivazh implements Estazh {
	
	private double x, y;
	protected final Rectangle[] LIMJ;
	protected int nunBild;

	protected static final int KVANTSTATJ = 64;
	protected static final int rotaciplejNombr = 128*2;
	protected static final int duonrotaciplejNombr = rotaciplejNombr/2;
	protected static final double ROTACI = 2*Math.PI/rotaciplejNombr;
	public double rapidecX, rapidecY;
	
	protected int largxVivazh, altVivazh;
	protected double viv, plejviv;
	protected int damagx;
	
	//protected Son damagxit;
	protected long longDamagxit, venontDamagxit;
	protected boolean qmovant = false;
	protected double resistenc = 1;

	public Vivazh(final int limj, final int damagxo, final String itenerSon) {
		
		this.largxVivazh = 32;
		this.altVivazh = 32;
		this.nunBild = 0;
		this.rapidecX = 1;
		x = 0;
		y = 0;
		viv = 100;
		plejviv = viv;
		damagx = damagxo;
		definigad();
		LIMJ = new Rectangle[limj];

		//damagxit = new Son(itenerSon, 0);
		//longDamagxit = damagxit.longsonn();
		
	}
	
	public Vivazh(final float rapidec, final int largxVivazh, final int altVivazh, final 
			int plejviv, final Rectangle[] limj, final String itenerSon) {
		
		this.largxVivazh = largxVivazh;
		this.altVivazh = altVivazh;
		this.nunBild = 0;
		this.rapidecX = rapidec;
		this.viv = plejviv;
		this.plejviv = plejviv;
		LIMJ = limj;
		
		definigad();
		//damagxit = new Son(itenerSon, 0);
		//longDamagxit = damagxit.longsonn();
	}
	
	protected void anim() {
		
	}

	protected void yangxMapn() {
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
	@Override
	public void desegn() {}
	
	@Override
	public void gxisdatig() {}
	
	public double rapidecXn() {
		return rapidecX;
	}
	public void rapidecX(final float rapidec) {
		rapidecX = rapidec;
	}
	
	public int damagxn() {
		return damagx;
	}
	public double vivn() {
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
		return x;
	}
	public double yn() {
		return y;
	}
	
	public void pliXn() {
		x += rapidecX;
		if(x<QefObjektj.map.yn().length) {
		} else {
			x = rapidecX;
		}
	}
	public void pliYn() {
		y += rapidecY;
	}
	public void mlpliXn() {
		if(x>0) {
			x -= rapidecX;
		} else {
			x = QefObjektj.map.yn().length - rapidecX;
		}
	}
	public void mlpliYn() {
		y -= rapidecY;
	}
	public void setXn(final double xo) {
		if(xo<0) {
			final int xFaktor = (int) (-xo/QefObjektj.map.yn().length + 0.9999);
			x = xFaktor*QefObjektj.map.yn().length + xo;
		} else if(xo > QefObjektj.map.yn().length) {
			final int xFaktor = (int) (xo/QefObjektj.map.yn().length);
			x = xo - xFaktor*QefObjektj.map.yn().length;
		} else
			x = xo;
	}
	public void setSenmidifXn(final double xo) {
		x = xo;
	}
	public void setSenmidifYn(final double yo) {
		y = yo;
	}
	public void setYn(final double y) {
		this.y = y;
	}
	public Rectangle nunposiciare() {
		return new Rectangle((int) x, (int) y, largxVivazh, altVivazh);
	}
	
	public void definigad() {
	}
	
	public void resetVivn() {
		viv = plejviv;
	}
	public void mlgajnVivn(double d, final int plejdamagx, final int nunLudant) {
		if(viv<=0d) {
			return;
		}
		viv -= d/resistenc;
        if (viv < 0) {
    		if(Vicperant.ludantj[nunLudant]!=this)
    			d += -Math.sqrt(-viv)*1.50 - plejviv;
        	viv = 0;
        	System.out.println(viv + " - " + d + " - " + Vicperant.ludantj[nunLudant].monn() + " - " +
        			Vicperant.ludantj[nunLudant].nomn());
        }
        
		final double potenc = d/plejdamagx;
		if(Vicperant.ludantj[nunLudant]==this)
			Vicperant.ludantj[nunLudant].pliMonn(-Math.pow(potenc*plejdamagx, 2)/(plejdamagx*plejdamagx)*plejdamagx);
		else
			Vicperant.ludantj[nunLudant].pliMonn(Math.pow(potenc*plejdamagx, 2)/(plejdamagx*plejdamagx)*plejdamagx);
		Vicperant.qaktivLudant();
	}
	public double resistencn() {
		return resistenc;
	}
}
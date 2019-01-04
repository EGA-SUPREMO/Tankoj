package qef.estazhj.vivazhj.misil;

import qef.ilj.Vicperant;

public class Multmisil extends Misil {
	
	private Misil[] misilj;
	
	public Multmisil(final int ekangulo, final int potenco, final int damagxo, final double ekXo, final double ekYo) {
		super(ekangulo, potenco, damagxo, ekXo, ekYo);
		ega = false;
	}
	
	@Override
	public void gxisdatig() {
		if(misilj == null)
			super.gxisdatig();
		else {
			int j = misilj.length;
			for(int i = 0; i < misilj.length; i++) {
				if(misilj[i]!=null) {
					j--;
					misilj[i].gxisdatig();
				}
			}
			if(j==0) {
				Vicperant.setNunMisiln(null);
				Vicperant.venontNunLudantn();
			}
		}
	}
	
	@Override
	public void desegn() {
		if(misilj == null)
			super.desegn();
		else
			for(int i = 0; i < misilj.length; i++)
				if(misilj[i]!=null)
					misilj[i].desegn();
	}
	
	@Override
	public void exploci() {
		misilj = new Misil[5];
		for(int i = 0; i < misilj.length; i++) {
			misilj[i] = new Misil(180/misilj.length*i, 7, 15, xn(), Math.sin(Math.PI*2/i)*grandec + yn());
			misilj[i].ega = false;
		}
		
		super.exploci();
	}
	
	@Override
	protected void forigMisiln() {
	}
}
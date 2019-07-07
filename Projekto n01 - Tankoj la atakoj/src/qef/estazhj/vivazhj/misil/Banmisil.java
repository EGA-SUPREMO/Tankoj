package qef.estazhj.vivazhj.misil;

public class Banmisil extends Multmisil {

	private double antawX, antawY;
	
	public Banmisil(final int ekangulo, final int potenco, final int damagxo, final double ekXo,
			final double ekYo) {
		super(ekangulo, potenco, damagxo, ekXo, ekYo);
	}

	@Override
	public void gxisdatig() {
		antawX = xn();
		antawY = yn();
		super.gxisdatig();
		nunBild = ((int) Math.toDegrees(Math.atan2(antawY - yn(), antawX - xn())) + 180);
		
		if(misilj == null && nunBild>180)
			exploci();
	}
	
	@Override
	public void exploci() {
		misilj = new Misil[5];
		final double offsetRad = 0;

		for(int i = 0; i < misilj.length; i++) {
			misilj[i] = new Misilet(trajekt.n(), 15, offsetRad, i+1, this);
			misilj[i].trajekt.setMisiln(misilj[i]);

			misilj[i].rapidecX -= misilj[i].rapidecX*(0.066*(i+1));
		}
		
	}
	
}
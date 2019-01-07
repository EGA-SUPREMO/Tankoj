package qef.estazhj.vivazhj.misil;

public class Misilet extends Misil {
	
	private final Multmisil multmisil;
	private final int id;
	
	public Misilet(int ekangulo, int potenco, int damagxo, final int ido, final Multmisil multmisilo) {
		super(ekangulo, potenco, damagxo, multmisilo.xn() + Math.cos(Math.PI*2/ido)*multmisilo.damagxLargxX,
				Math.sin(Math.PI*2/ido)*multmisilo.damagxaltec + multmisilo.yn());
		multmisil = multmisilo;
		id = ido;
	}
	
	public void gxisdatig() {
		super.gxisdatig();
		System.out.println(xn() + " - " + id);
	}
	
	@Override
	protected void venontVicn() {
		multmisil.misilj[id] = null;
	}
}
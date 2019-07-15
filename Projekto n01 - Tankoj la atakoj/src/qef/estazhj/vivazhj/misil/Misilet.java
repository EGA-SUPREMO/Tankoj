package qef.estazhj.vivazhj.misil;

import java.awt.Color;

import qef.ilj.Vicperant;

public class Misilet extends Misil {
	
	private final Multmisil multmisil;
	private final int id;

	public Misilet(final int ekangulo, final int potenco, final int damagxo, final double offset, final int ido,
			final Multmisil multmisilo) {
		super(ekangulo, potenco, damagxo, multmisilo.xn() + Math.cos(Math.PI*2/ido + offset)*(multmisilo.damagxLargxX/2),
				Math.sin(Math.PI*2/ido + offset)*(multmisilo.damagxaltec/2) + multmisilo.yn(), Color.YELLOW.darker());
		multmisil = multmisilo;
		id = ido-1;
	}
	@Override
	public void gxisdatig() {
		for(int i = 0; i < Vicperant.ludantj.length; i++)
			kolicij[i] = Vicperant.ludantj[i].nunposiciare();
		super.gxisdatig();
	}
	
	public Misilet(final KalkuliTrajektn trajekto, final int damagxo, final double offset, final int ido,
			final Multmisil multmisilo) {
		super(trajekto, damagxo, multmisilo.xn(), multmisilo.yn(), Color.YELLOW.darker());
		multmisil = multmisilo;
		id = ido-1;
	}
	@Override
	protected void venontVicn() {
		multmisil.misilj[id] = null;
	}
	
	
}
package qef.inventar.armil;

import qef.Konstantj;

public class Senarma extends Armil{
	
	public Senarma(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako) {
		super(id, nomo, priskribo, plejatako, mlplejatako, false, 0, Konstantj.ITENER_SONJ_LUDANT + "pom.wav");
	}
	
}
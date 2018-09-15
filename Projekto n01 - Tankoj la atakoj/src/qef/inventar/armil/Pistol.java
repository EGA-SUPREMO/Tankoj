package qef.inventar.armil;

public class Pistol extends Armil {
	
	public Pistol(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako, final boolean penetrante,
			final double ataquesPorSegundo, final String itenerson) {
		super(id, nomo, priskribo, plejatako, mlplejatako, penetrante, ataquesPorSegundo, itenerson);
	}
	
	//dekstre = 1; maldekstre = 6; sub = 2; supre = 4; supre-dekstre = 5; supre-maldekstre = 8; sube-dekstre = 7

	
}

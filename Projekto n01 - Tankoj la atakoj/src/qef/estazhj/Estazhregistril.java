package qef.estazhj;

import qef.ilj.Vicperant;

public class Estazhregistril {

	public static Estazh estaezhjn(final int id) {
		switch(id) {
			case 0:
				return new Misil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 10,
						Vicperant.nunludantn().xn(), Vicperant.nunludantn().yn());
			case 1:
				return new Misil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 200,
						Vicperant.nunludantn().xn(), Vicperant.nunludantn().yn());
			case 2:
				return new Misil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 400,
						Vicperant.nunludantn().xn(), Vicperant.nunludantn().yn());
			default:
				return null;
		}
	}
}
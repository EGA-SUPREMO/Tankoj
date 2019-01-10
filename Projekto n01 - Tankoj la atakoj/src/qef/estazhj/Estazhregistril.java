package qef.estazhj;

import qef.estazhj.vivazhj.misil.Atommisil;
import qef.estazhj.vivazhj.misil.Atommisileg;
import qef.estazhj.vivazhj.misil.Misil;
import qef.estazhj.vivazhj.misil.Misileg;
import qef.estazhj.vivazhj.misil.Multmisil;
import qef.ilj.Vicperant;

public class Estazhregistril {

	public static Estazh estaezhjn(final int id) {
		switch(id) {
			case 0:
				return new Misil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 10,
						Vicperant.nunludantn().xn(), Vicperant.nunludantn().yn());
			case 1:
				return new Misileg(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 30,
						Vicperant.nunludantn().xn(), Vicperant.nunludantn().yn(), 0, 11);
			case 2:
				return new Atommisil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 100,
						Vicperant.nunludantn().xn(), Vicperant.nunludantn().yn(), 1, 15);
			case 3:
				return new Atommisileg(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 300,
						Vicperant.nunludantn().xn(), Vicperant.nunludantn().yn(), 2, 23);
			case 4:
				return new Multmisil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 15,
						Vicperant.nunludantn().xn(), Vicperant.nunludantn().yn());
			default:
				return null;
		}
	}
}
package qef.estazhj.vivazhj.misil;

import java.awt.Color;

import qef.ilj.Vicperant;

public class Misilregistril {

	public static Misil misiljn(final int id) {
		switch(id) {
			case 0:
				return new Misil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 10,
						Vicperant.nunludantn().xn() + Vicperant.nunludantn().offsetLudantXn(),
						Vicperant.nunludantn().yn() + (Vicperant.nunludantn().altVivazhn()>>1), Color.BLACK);
			case 1:
				return new Misileg(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 30,
						Vicperant.nunludantn().xn() + Vicperant.nunludantn().offsetLudantXn(),
						Vicperant.nunludantn().yn() + (Vicperant.nunludantn().altVivazhn()>>1), 0, 11);
			case 2:
				return new Multmisil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 15,
						Vicperant.nunludantn().xn() + Vicperant.nunludantn().offsetLudantXn(),
						Vicperant.nunludantn().yn() + (Vicperant.nunludantn().altVivazhn()>>1), Color.RED.darker());
			case 3:
				return new Atommisil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 125,
						Vicperant.nunludantn().xn() + Vicperant.nunludantn().offsetLudantXn(),
						Vicperant.nunludantn().yn() + (Vicperant.nunludantn().altVivazhn()>>1), 1, 15);
			case 4:
				return new Atommisileg(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 350,
						Vicperant.nunludantn().xn() + Vicperant.nunludantn().offsetLudantXn(),
						Vicperant.nunludantn().yn() + (Vicperant.nunludantn().altVivazhn()>>1), 2, 23);
			case 5:
				return new Banmisil(Vicperant.nunludantn().nunanguln(), Vicperant.nunludantn().potenc, 35,
						Vicperant.nunludantn().xn() + Vicperant.nunludantn().offsetLudantXn(),
						Vicperant.nunludantn().yn() + (Vicperant.nunludantn().altVivazhn()>>1));
			default:
				return null;
		}
	}
}
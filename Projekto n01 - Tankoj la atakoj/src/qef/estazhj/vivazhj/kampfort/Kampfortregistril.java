package qef.estazhj.vivazhj.kampfort;

import qef.ilj.Vicperant;

public class Kampfortregistril {

	public static Kampfort kampfortjn(final int id) {

		switch(id) {
			case 0:
				return new Kampfort(50, Vicperant.nunludantn(), 4, "");
			case 1:
				return new Kampfort(150, Vicperant.nunludantn(), 1, "");
			case 2:
				return new Kampfort(450, Vicperant.nunludantn(), 2, "");
			case 3:
				return new Kampfort(1000, Vicperant.nunludantn(), 3, "");
			default:
				return null;
		}
		
	}
}
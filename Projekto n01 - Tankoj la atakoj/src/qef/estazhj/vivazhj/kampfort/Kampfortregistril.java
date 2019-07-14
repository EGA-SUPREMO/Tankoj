package qef.estazhj.vivazhj.kampfort;

import qef.ilj.Vicperant;

public class Kampfortregistril {

	public static Kampfort kampfortjn(final int id) {

		switch(id) {
			case 0:
				return new Kampfort(50, Vicperant.nunludantn(), "");
			case 1:
				return new Kampfort(200, Vicperant.nunludantn(), "");
			case 2:
				return new Kampfort(4000, Vicperant.nunludantn(), "");
			case 3:
				return new Kampfort(80000, Vicperant.nunludantn(), "");
			default:
				return null;
		}
		
	}
}
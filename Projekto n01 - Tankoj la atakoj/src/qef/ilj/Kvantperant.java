package qef.ilj;

import qef.Konstantj;
import qef.QefObjektj;

public class Kvantperant {
	
	public static double koordenadXalekranPosicin(final double koordenad) {
		return koordenad - Vicperant.ludantj[Vicperant.nunLudantn()].xn() + Konstantj.duonLudLargx;
	}
	
	public static double koordenadYalekranPosicin(final double koordenad) {
		return QefObjektj.map.offsetMap - koordenad;
	}
	
	public static double koordenadEkranPosicialXn(final double koordenad) {
		return koordenad + Vicperant.ludantj[Vicperant.nunLudantn()].xn() + Konstantj.duonLudLargx;
	}
	
	public static double koordenadEkranPosicialYn(final double koordenad) {
		return QefObjektj.map.offsetMap + koordenad;
	}

    public static double kakulDistancn(final int x1, final int y1, final int x2, final int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

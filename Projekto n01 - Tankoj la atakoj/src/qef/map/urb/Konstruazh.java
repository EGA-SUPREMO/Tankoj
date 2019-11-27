package qef.map.urb;

public class Konstruazh {
	
	public static void kreKonstruazhjn(final double[] yo, int xo, final int largxo,final int alteco) {
		final int mlnovXo = xo;
		for(int i = 0; i < largxo; i++) {
			if(i+xo<yo.length) {
				yo[i+xo] = yo[mlnovXo] + alteco;
			} else {
				xo = 0;
			}
			
		}
	}
	
}

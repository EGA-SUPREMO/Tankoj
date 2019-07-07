package qef.map.urb;

public class Konstruazh {
	
	public static void kreKonstruazhjn(final double[] yo, final int xo, final int largxo,final int alteco) {
		for(int i = 0; i < largxo; i++)
			yo[i+xo] = yo[xo] + alteco;
	}
	
}

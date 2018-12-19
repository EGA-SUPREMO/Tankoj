package qef.map.mes;

import java.util.Random;

public class Partmesmont {
	
	final static Random r = new Random();
	
	public static double[] partmesmontn(final int largx, final int alt) {
		final double[] y = new double[largx];
		double largxExtrem = largx/3;
		final double transextremLargx = largxExtrem/12;
		largxExtrem -= transextremLargx; 
		final double extremplejalt = largx*largx;
		final double supr = alt*4;
		final double altecTransextrem = (alt-((largxExtrem*largxExtrem/extremplejalt)*supr))/transextremLargx;

		for(int i = 0; i < largxExtrem; i++)
			y[i] = (i*i/extremplejalt)*supr;
		
		for(int i = 0; i < transextremLargx; i++)
			y[(int) largxExtrem + i] = y[(int) largxExtrem] + altecTransextrem*i;
		
		for(int i = (int) (largxExtrem + transextremLargx); i<largx - largxExtrem - transextremLargx; i++)
			y[i] = alt*2;
		
		for(int i = 0; i < largxExtrem; i++)
			y[(int) (largx - i - 1)] = (i*i/extremplejalt)*supr;

		for(int i = 0; i < transextremLargx; i++)
			y[(int) (largx - largxExtrem - i - 1)] = y[(int) (largx - largxExtrem)] + altecTransextrem*i;
		
		
		
		return y;
	}
	
}

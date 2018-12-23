package qef.map.mes;

import java.util.Random;

public class Partmesmont {
	
	final static Random r = new Random();
	final double[] y;
	double largxExtrem;
	final double transextremLargx;
	final double extremplejalt;
	final double supr;
	final double altecTransextrem;
	
	public Partmesmont(final int largx, final int alt) {
		y = new double[largx];
		largxExtrem = largx/3;
		transextremLargx = largxExtrem/12;
		largxExtrem -= transextremLargx; 
		extremplejalt = largx*largx;
		supr = alt*4;
		altecTransextrem = (alt-((largxExtrem*largxExtrem/extremplejalt)*supr))/transextremLargx;

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
		
	}
	
}

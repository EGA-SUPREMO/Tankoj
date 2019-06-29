package qef.map.mes;

import java.util.Random;

public class Partmesmont {
	
	final static Random r = new Random();
	final double[] y;
	double largxExtrem;
	double transextremLargx;
	final double extremplejalt;
	final double supr;
	final double altecTransextrem;
	
	public Partmesmont(final int largx, final int alt) {
		y = new double[largx];//72
		largxExtrem = largx/3;//24.333
		transextremLargx = largxExtrem/12;//2.02777
		largxExtrem -= transextremLargx;//22.3
		extremplejalt = largx*largx;
		supr = alt*4;
		altecTransextrem = (alt-((largxExtrem*largxExtrem/extremplejalt)*supr))/transextremLargx;
		
		largxExtrem = Math.round(largxExtrem);
		transextremLargx = Math.round(transextremLargx);

		for(int i = 0; i <= largxExtrem; i++)
			y[i] = (i*i/extremplejalt)*supr;
		
		for(int i = 0; i < transextremLargx; i++)
			y[(int) largxExtrem + i] = y[(int) largxExtrem] + altecTransextrem*i;
		
		for(int i = (int) (largxExtrem + transextremLargx); i<largx - largxExtrem - transextremLargx; i++)
			y[i] = alt*2;
		
		for(int i = 0; i < largxExtrem; i++)
			y[(int) (largx - i - 1)] = (i*i/extremplejalt)*supr;

		for(int i = 0; i < transextremLargx; i++)
			y[(int) (largx - largxExtrem - i - 1)] = y[(int) (largx - largxExtrem)] + altecTransextrem*i;
		
		for(int i = 0; i < y.length; i++)
			if(y[i] == 0 && (i>0 || i < y.length - 2)) {
				for(int j = 0; j < y.length; j++)
					System.out.println(j + ": " + y[j]);
				System.out.println(largxExtrem + " - " + transextremLargx + " - " +
					(int) (largxExtrem + transextremLargx) + " - ");
				break;
			}
		
	}
	
}

package qef.ilj;

import java.util.Random;

import qef.Konstantj;

public class BruGeneril {
	private static int altgrandec;// = 50;//popo = 15 estas tre bona nombro
	private static Random r = new Random();
	
	public static double[] generMapn(final int[] frekvencj, final float[] amplitudes, final int altgrandeco) {
		altgrandec = altgrandeco;
		final double[][] bruj = new double[frekvencj.length][Konstantj.mapgrandec];
		for(int ii = 0; ii<frekvencj.length; ii++) 
			bruj[ii] = brun(frekvencj[ii]);
		
		return weighted_sum(amplitudes, bruj);
	}
	
	private static double[] weighted_sum(final float[] amplitudes, final double[][] bruj) {
		double[] finBru = new double[Konstantj.mapgrandec];
		for(int k = 0; k < bruj.length; k++)
			for(int x = 0; x < Konstantj.mapgrandec; x++)
				finBru[x] += amplitudes[k] * bruj[k][x];
		return finBru;
	}
	
	private static double[] brun(final int frekvenc) {
		double[] output = new double[Konstantj.mapgrandec];
		double phase = r.nextDouble()*2*Math.PI;
		for(int x = 0; x < Konstantj.mapgrandec; x++)
			output[x] = altgrandec*Math.sin(2*Math.PI*frekvenc*x/Konstantj.mapgrandec + phase);
		return output;
	}
	
}
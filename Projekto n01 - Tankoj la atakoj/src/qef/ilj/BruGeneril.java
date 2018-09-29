package qef.ilj;

import java.util.Random;

import qef.Konstantj;

public class BruGeneril {
	private static int popo = 50;//popo = 15 estas tre bona nombro
	private static Random r = new Random();
	private static int mapgrandec = Konstantj.ludLargx;
	
	public static double[] generMapn(final int[] frekvencj, final float[] amplitudes) {
		final double[][] bruj = new double[frekvencj.length][mapgrandec];
		for(int ii = 0; ii<frekvencj.length; ii++) 
			bruj[ii] = brun(frekvencj[ii]);
		
		return weighted_sum(amplitudes, bruj);
	}
	
	private static double[] weighted_sum(final float[] amplitudes, final double[][] bruj) {
		double[] finBru = new double[mapgrandec];
		for(int k = 0; k < bruj.length; k++)
			for(int x = 0; x < mapgrandec; x++)
				finBru[x] += amplitudes[k] * bruj[k][x];
		return finBru;
	}
	
	private static double[] brun(final int frekvenc) {
		double[] output = new double[mapgrandec];
		double phase = r.nextDouble() + 2*Math.PI;
		for(int x = 0; x < mapgrandec; x++)
			output[x] = (int) Math.round(popo*Math.sin(2*Math.PI*frekvenc*x/mapgrandec + phase));
		return output;
	}
	
	public static int mapgrandecn() {
		return mapgrandec;
	}
}
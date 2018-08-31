package qef.ilj;

public class BruGeneril {
	static int mapsize=0;
	
	private static int[] weighted_sum(final float[] amplitudes, final int[][] noises) {
		int[] output = new int[mapsize];
		for(int k = 0; k < noises.length; k++)
			for(int x = 0; x < mapsize; x++)
				output[x] += amplitudes[k] * noises[k][x];
		return output;
	}
	
	private static int[] noise(final int freq) {
		int[] output = new int[mapsize];
		double phase = Math.random() + 2*Math.PI;
		for(int x = 0; x < mapsize; x++)
			output[x] = (int) Math.round(15*Math.sin(2*Math.PI * freq*x/mapsize + phase));
		return output;
	}
	
}

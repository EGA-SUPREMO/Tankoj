package qef.map.mes;

public class Mesmont {
	
	public final double[] y;
	
	public Mesmont(final int largx, final int alt) {
		y = new double[largx];
		int altgrandec = alt;
		
		final int hazard = (int) (Math.random()*100);
		final int plejMontj = hazard<53? 2 : hazard<81? 3 : 4;
		int antawlargx = largx;
		for(int i = 0; i < plejMontj; i++) {
			Partmesmont partmesmont = new Partmesmont((int) (Math.random()*antawlargx),
					altgrandec*2);
			if(i==0)
				antawlargx = partmesmont.y.length;
			
			for(int j = 0; j < partmesmont.y.length; j++)
				y[j] = y[j] + partmesmont.y[j];
		}
	}
	
}

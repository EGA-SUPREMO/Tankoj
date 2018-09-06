package qef.map;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.YargxilAzhj;

public class Map {
	
	private final int largx, alt;
	private final int xLudant;
	private final int yLudant;
	private final int bruec;
	private BufferedImage[] map;
	private BufferedImage[] spritear;
	private final Color[] kolorj;
	public ArrayList<Rectangle> arejKolici;
	
	public Map(final int spec) {
		
		final String[] enhav = YargxilAzhj.yargxTextn(Konstantj.ITENER_MAP + spec + Konstantj.SUFIX_MAP).split("@");
		
		largx = Integer.parseInt(enhav[0]);
		alt = Integer.parseInt(enhav[1]);
		
		kolorj = elKolorj(enhav[2].split("\\."));
		
		spritear = elSprites(enhav[3].split("\\."), spec);
		bruec = Integer.parseInt(enhav[4]);
		map = elMapn(enhav[5]);

		if(alt%2 != 0 && bruec == 0)
			JOptionPane.showMessageDialog(null, "El mapa " + spec + " no tiene el alto en numeros pares.");
		
		xLudant = Konstantj.largxCentr;
		yLudant = Konstantj.altCentr;
		
		
	}
	
	private BufferedImage[] elMapn(final String s) {
		BufferedImage[] sprites = new BufferedImage[largx * alt];
		int[] map = new int[sprites.length];
			if(s.length() == sprites.length && bruec == 0) {
				for(int x = 0; x < largx; x++) 
					for(int y = 0; y < alt; y++)
						sprites[x + y * largx] = spritear[s.charAt(x + y * largx)];
			} else {
			}
			
		return sprites;
	}

	public void gxisdatig() {
	}
	
	public void desegn() {
		
		for(int y = 0; y < alt; y++)
			for(int x = 0; x < largx; x++)
				DebugDesegn.desegnBildn(map[x + y * largx], (int)
						(Kvantperant.koordenadXalekranPosicin(x*Konstantj.SPRITELARGX)), (int)
						(Kvantperant.koordenadYalekranPosicin(y*Konstantj.SPRITEALT)));
		
	}
	private Color[] elKolorj(final String[] datumojKolorj) {
		Color[] koloroj = new Color[datumojKolorj.length];
		final int[] nombrojKolorj = new int[datumojKolorj.length*3];
		
		for(int x = 0; x<datumojKolorj.length; x++) { 
			final String[] nombrj = datumojKolorj[x].split("_");
			for(int y = 0; y<3;y++) 
				nombrojKolorj[x + y * 2] = Integer.parseInt(nombrj[y]);
		}
		for(int x = 0; x<datumojKolorj.length; x++)
			koloroj[x] = new Color(nombrojKolorj[x + 0*2], nombrojKolorj[x + 1*2], nombrojKolorj[x + 2*2]);
		
		return koloroj;
	}
	//tomorrow starts today
	private BufferedImage[] elSprites(final String[] sprite, final int spec) {
	//	if(sprite.equals("null")) {
			final BufferedImage[] sprites = new BufferedImage[kolorj.length];
			for(int i = 0; i < sprites.length; i++)
				sprites[i] = Bildperant.kreBildn(kolorj[i]);
			
			return sprites;
	//	}
//		return null;
	}
	
	public BufferedImage[] spritesn() {
		return spritear;
	}
	
	public Rectangle margxen(final int x, final int y) {
        int posicioX = (Konstantj.duonLudLargx - x + QefObjektj.ludant.largxVivazhn()) + Konstantj.SPRITELARGX;
        int posicioY = (Konstantj.duonLudAlt - y + QefObjektj.ludant.altVivazhn()) + Konstantj.SPRITEALT;

        int largx = (this.largx * Konstantj.SPRITELARGX - (Konstantj.SPRITELARGX * 3)) - QefObjektj.ludant.largxVivazhn() * 2;
        int alt = (this.alt * Konstantj.SPRITEALT - (Konstantj.SPRITEALT * 3)) - QefObjektj.ludant.altVivazhn() * 2;

        return new Rectangle(posicioX, posicioY, largx, alt);
	}
	
	public int xLudantn() {
		return xLudant;
	}
	public int yLudantn() {
		return yLudant;
	}
	
	
}
package qef.ilj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import qef.Konstantj;
import qef.QefObjektj;
import qef.uzantinterfac.Slider;

public class Bildperant {
	
	public static BufferedImage atingecMisil(final int[] punktj) {
		if(punktj.length==0)
			return null;
		int plejX = 0, mlplejX = punktj[0], plejY = punktj[punktj.length-1], mlplejY = punktj[1];
		final int largx = punktj.length/2;
		int largxbild;
		final int altbild;
		
		for(int x = 0; x < punktj.length; x+=2) {
			if(plejX<punktj[x])
				plejX = punktj[x];
			else if(mlplejX>punktj[x])
				mlplejX = punktj[x];
		}
		
		largxbild = plejX - mlplejX;
		altbild = plejY - mlplejY;
		
		if(altbild<1)
			return null;
		if(largxbild<1)
			largxbild++;
		else if(largxbild<1)
			return null;
		
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration().createCompatibleImage(largxbild, altbild, Transparency.TRANSLUCENT);
		Graphics g = bild.getGraphics();
		
		if(Konstantj.altGrafik)
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Konstantj.KOLOR_ATINGEC);
		for(int x = 2; x < largx; x++)
			g.drawLine(punktj[0 + (x-1)*2] - mlplejX, plejY - punktj[1 + (x-1)*2],
					punktj[0 + x*2] - mlplejX, plejY - punktj[1 + x*2]);
		
		g.dispose();
		
		return bild;
	}
	
	public static BufferedImage kreBildn(final Color c) {
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration().createCompatibleImage(Konstantj.SPRITEALT, Konstantj.SPRITELARGX,
						Transparency.OPAQUE);
		Graphics g = bild.getGraphics();
		
		g.setColor(c);
		g.fillRect(0, 0, bild.getWidth(), bild.getHeight());
		g.dispose();
		
		return bild;
	}
	
	public static BufferedImage gxisdatigMapn(final int ekx, final int largx) {
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration(). createCompatibleImage(largx, QefObjektj.map.altMap, Transparency.OPAQUE);
		Graphics g = bild.getGraphics();
		
		g.setColor(Konstantj.AKV_MAP_KOLOR);//FIXME LA AKVO ESTAS STRANGA DE CXI TIU METODO
		g.fillRect(0, 0, largx, QefObjektj.map.altMap);
		g.setColor(Konstantj.CXIEL_MAP_KOLOR);
		g.fillRect(0, 0, largx, QefObjektj.map.altMap - 100);
		g.setColor(Konstantj.PLANK_NEGX_MAP_KOLOR);
		
		for(int x = 0; x < largx; x++)
			g.drawLine(x, (int) Kvantperant.koordenadYalekranPosicin(QefObjektj.map.yn()[ekx + x]), x, 
					QefObjektj.map.altMap);
		if(Konstantj.altGrafik)
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.dispose();
		
		return bild;
	}
	
	public static BufferedImage volvBildn(final BufferedImage devenBild, final double radian) {//devenBildradian
		AffineTransform rotad = new AffineTransform();
		rotad.rotate(radian, devenBild.getWidth() / 2, devenBild.getHeight() / 2);
		
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().
				createCompatibleImage(devenBild.getWidth(), devenBild.getHeight(), Transparency.TRANSLUCENT);
		
		Graphics g = bild.getGraphics();
		((Graphics2D)g).drawImage(devenBild, rotad, null);
		g.dispose();
		
		return bild;
	}
	
	public static BufferedImage volvBildn(final BufferedImage devenBild, final int xCentr, final int yCentr,
			final double radian) {
				
		AffineTransform rotad = new AffineTransform();
		rotad.rotate(radian, xCentr, yCentr);
		
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().
				createCompatibleImage(devenBild.getWidth(), devenBild.getHeight(), Transparency.TRANSLUCENT);
		
		Graphics g = bild.getGraphics();
		((Graphics2D)g).drawImage(devenBild, rotad, null);
		g.dispose();
		
		return bild;
	}
	
	public static BufferedImage yangxKolorn(final BufferedImage devenBild, final int rugx, final int verd,
			final int blu) {
		//FIXME CXI TIO ESTAS TRE NEEFIKA
		int[] pixelj = ((DataBufferInt) devenBild.getRaster().getDataBuffer()).getData();
		devenBild.getRGB(0, 0, devenBild.getWidth(), devenBild.getHeight(), pixelj, 0, devenBild.getWidth());
		
		BufferedImage koloritbild = new BufferedImage(devenBild.getWidth(), devenBild.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		for(int i = 0; i<pixelj.length; i++)
			if((pixelj[i])<=0xFF000000 || pixelj[i]>=0x00FFFFFF)
				pixelj[i] = new Color(rugx, verd, blu, new Color(pixelj[i], true).getAlpha()).getRGB();
		
		koloritbild.setRGB(0, 0, devenBild.getWidth(), devenBild.getHeight(), pixelj, 0, devenBild.getWidth());
		
		return koloritbild;
	}

	public static BufferedImage kreButon(final int largx, final int kolor, final int spec, final int qdukolora,
			final String texto) {
		final int offset;
		switch(spec) {
			case 0:
				offset = 4;
				break;
			case 1:
				offset = 0;
				break;
			default:
				offset = 4;
		}
		final int index = kolor + 5*spec;
		
		int[] pixelj = ((DataBufferInt) Konstantj.BUTON_SPRITE[index].getRaster().getDataBuffer()).getData();
		Konstantj.BUTON_SPRITE[index].getRGB(0, 0, Konstantj.BUTON_SPRITE[index].getWidth(),
				Konstantj.BUTON_SPRITE[index].getHeight(), pixelj, 0, Konstantj.BUTON_SPRITE[index].getWidth());
		
		BufferedImage bild = new BufferedImage(largx, Konstantj.BUTON_SPRITE[index].getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		int[] bildpixelj = ((DataBufferInt) bild.getRaster().getDataBuffer()).getData();
		
		for(int x = 0; x<Konstantj.MARGXEN_BUTON; x++)
			for(int y = 0; y<bild.getHeight(); y++) 
				bildpixelj[x + y*bild.getWidth()] = pixelj[x + y*Konstantj.BUTON_SPRITE[index].getWidth()];
		
		final int max = largx - Konstantj.MARGXEN_BUTON;
		int i = Konstantj.MARGXEN_BUTON;
		
		for(; i<max; i++)
			for(int y = 0; y<bild.getHeight(); y++)
				bildpixelj[i + y*bild.getWidth()] = pixelj[Konstantj.MARGXEN_BUTON +
						y*Konstantj.BUTON_SPRITE[index].getWidth()];
		
		final int diferenc = largx - Konstantj.BUTON_SPRITE[index].getWidth();
		
		for(; i<largx; i++)
			for(int y = 0; y<bild.getHeight(); y++)
				bildpixelj[i + y*bild.getWidth()] = pixelj[i - diferenc +
						y*Konstantj.BUTON_SPRITE[index].getWidth()];
		
		bild.setRGB(0, 0, bild.getWidth(), bild.getHeight(), bildpixelj, 0, bild.getWidth());

		Graphics g = bild.getGraphics();
		g.setFont(Konstantj.KUTIM_FONT_BUTON.deriveFont(26f));
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Konstantj.KOLORJ_BUTON[(kolor + qdukolora)* qdukolora]);
		g.drawString(texto, (bild.getWidth() - StringKvantil.largxStringn(g, texto))>>1,
				(bild.getHeight() - offset)/2 + StringKvantil.altStringn(g, texto)/2 - StringKvantil.altStringn(g,
						texto)/5);
		g.dispose();
		
		return bild;
	}
	
	public static BufferedImage krePaneln(final int largx, final int alt, final int kolor, final String texto) {
		BufferedImage antawbild = kreButon(alt, kolor + 10, 0, 0, "");
		AffineTransform rotad = new AffineTransform();
		rotad.rotate(Math.PI/2, 0, antawbild.getHeight());
		rotad.translate(-antawbild.getHeight(), 0);
		
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration().createCompatibleImage(antawbild.getHeight(), alt,
						Transparency.TRANSLUCENT);
		{
			Graphics g = bild.getGraphics();
			((Graphics2D)g).drawImage(antawbild, rotad, null);
			g.dispose();
		}
		
		Konstantj.BUTON_SPRITE[Konstantj.BUTON_SPRITE.length-1] = bild;
		BufferedImage finbild = kreButon(largx, Konstantj.BUTON_SPRITE.length-1, 0, 0, "");
		
		Graphics g = finbild.getGraphics();
		g.setFont(Konstantj.KUTIM_FONT_BUTON.deriveFont(26f));
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString(texto, (finbild.getWidth() - StringKvantil.largxStringn(g, texto))>>1,
				Konstantj.MARGXEN_BUTON*2 - 2 + StringKvantil.altStringn(g, texto) -
				StringKvantil.altStringn(g, texto)/5);
		g.dispose();
		
		return finbild;
	}
	
	public static BufferedImage kreLineoSlidern(final Slider slider) {
		Konstantj.BUTON_SPRITE[Konstantj.BUTON_SPRITE.length-1] = Konstantj.SLIDER_SPRITE[5];
		
		
		BufferedImage antawbild = kreButon(slider.largx - Konstantj.SLIDER_SPRITE[6].getWidth()*2,
				Konstantj.BUTON_SPRITE.length - 1, 0, 0, "");
		
		Graphics gg = antawbild.getGraphics();
		((Graphics2D) gg).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		gg.setFont(Konstantj.KUTIM_FONT_BUTON.deriveFont(16f));
		gg.dispose();
		
		final int mlplejX = (int)(Konstantj.SLIDER_SPRITE[6].getHeight()/(float) 2 -
				(float) StringKvantil.largxStringn(gg, slider.mlplej + "")/2);
		final int plejX = (int) (slider.largx - Konstantj.SLIDER_SPRITE[6].getHeight()/(float) 2 -
				(float) StringKvantil.largxStringn(gg, slider.plejn() + "")/2 +
				StringKvantil.largxStringn(gg, slider.plejn() + ""));
		final int offsetX = mlplejX<0? -mlplejX : 0;
		slider.mlplejOffsetX = offsetX;
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration().createCompatibleImage(offsetX + plejX, 40,
						Transparency.TRANSLUCENT);
		
		Graphics g = bild.getGraphics();
		g.setFont(Konstantj.KUTIM_FONT_BUTON.deriveFont(16f));
		g.setColor(Konstantj.KOLORJ_BUTON[5]);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(Konstantj.SLIDER_SPRITE[6], offsetX, 0, null);
		g.drawImage(antawbild, Konstantj.SLIDER_SPRITE[6].getWidth() + offsetX, 3, null);
		g.drawImage(Konstantj.SLIDER_SPRITE[6], slider.largx - Konstantj.SLIDER_SPRITE[6].getWidth() + offsetX, 0,
				null);
		g.drawString("" + slider.mlplej, mlplejX + offsetX,
				(int) (StringKvantil.altStringn(g, "" + slider.mlplej)*1.3));
		g.drawString("" + slider.plejn(), plejX - StringKvantil.largxStringn(g, slider.plejn() + "") + offsetX,
				(int) (StringKvantil.altStringn(g, "" + slider.plejn())*1.3));
		g.dispose();
		
		return bild;
	}
	
	public static BufferedImage kreSlidern(final int nombr, final int kolor, final int qdukolora) {
		final int offset = 3;
		final int offset2 = 10;
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration().createCompatibleImage(Konstantj.SLIDER_SPRITE[kolor].getWidth(),
						Konstantj.SLIDER_SPRITE[kolor].getHeight(), Transparency.TRANSLUCENT);
		
		Graphics g = bild.getGraphics();
		g.drawImage(Konstantj.SLIDER_SPRITE[kolor], 0, 0, null);
		g.setFont(Konstantj.KUTIM_FONT_BUTON.deriveFont(16f));
		g.setColor(Konstantj.KOLORJ_BUTON[(kolor + qdukolora)* qdukolora]);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString("" + nombr, ((bild.getWidth() - StringKvantil.largxStringn(g, "" + nombr))>>1) +
				StringKvantil.largxStringn(g, "" + nombr)/5, (bild.getHeight() - offset - offset2)/2 +
				StringKvantil.altStringn(g, nombr + "")/2 - StringKvantil.altStringn(g, "" + nombr)/5 + offset2);
		
		return bild;
	}
	
}
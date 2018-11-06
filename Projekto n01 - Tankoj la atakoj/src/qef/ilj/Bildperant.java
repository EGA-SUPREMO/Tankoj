package qef.ilj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
//import java.awt.geom.AffineTransformOp;
//import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import qef.Konstantj;
import qef.QefObjektj;

public class Bildperant {
/*	private AffineTransform at;
	private int alturaImagen;
	private int anchoImagen;
	private double grados;
	
	public Bildperant(int alturaImagen, int anchuraImagen) {
		at = new AffineTransform();
		this.alturaImagen = alturaImagen;
		this.anchoImagen = anchuraImagen;
	}
	
	public void rotate(double grados) {
		this.grados = grados;
		at.rotate(grados, anchoImagen / 2, alturaImagen / 2);
	}*/
	
/*	public void findTranslation() {
		Point2D p2din, p2dout;
		p2din = hallarPtoATraslacion();
		p2dout = at.transform(p2din, null);
		double ytrans = p2dout.getY();
		
		p2din = hallarPtoBTraslacion();
		p2dout = at.transform(p2din, null);
		double xtrans = p2dout.getX();
		AffineTransform tat = new AffineTransform();
		
		tat.translate(-xtrans, -ytrans);
		at.preConcatenate(tat);
	}
	
	private Point2D hallarPtoATraslacion() {
		Point2D p2din;
		if (grados >= 0 && grados <= 90) {
			p2din = new Point2D.Double(0.0, 0.0);
		} else if (grados > 90 && grados <= 180) {
			p2din = new Point2D.Double(0.0, alturaImagen);
		} else if (grados > 180 && grados <= 270) {
			p2din = new Point2D.Double(anchoImagen, alturaImagen);
		} else {
			p2din = new Point2D.Double(anchoImagen, 0.0);
		}
		return p2din;
	}
	
	private Point2D hallarPtoBTraslacion() {
		Point2D p2din;
		if (grados >= 0 && grados <= 90) {
			p2din = new Point2D.Double(0.0, alturaImagen);
		} else if (grados > 90 && grados <= 180) {
			p2din = new Point2D.Double(anchoImagen, alturaImagen);
		} else if (grados > 180 && grados <= 270) {
			p2din = new Point2D.Double(anchoImagen, 0.0);
		} else {
			p2din = new Point2D.Double(0.0, 0.0);
		}
		return p2din;
	}*/
/*	
	public AffineTransform getTransform() {
		return at;
	}*/
	
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
		
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().
				createCompatibleImage(largxbild, altbild, Transparency.TRANSLUCENT);
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
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().
				createCompatibleImage(Konstantj.SPRITEALT, Konstantj.SPRITELARGX, Transparency.OPAQUE);
		Graphics g = bild.getGraphics();
		
		g.setColor(c);
		g.fillRect(0, 0, bild.getWidth(), bild.getHeight());
		g.dispose();
		
		return bild;
	}
	
	public static BufferedImage gxisdatigMapn(final int ekx, final int largx) {
		BufferedImage bild = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().
				createCompatibleImage(largx, QefObjektj.map.altMap, Transparency.OPAQUE);
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

	public static void kreButon(int largx, int alt, int kolor, String texto) {
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
}
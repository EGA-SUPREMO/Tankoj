package qef.ilj;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import qef.Konstantj;
import qef.estazhj.vivazhj.Ludant;
//import javax.sound.sampled.FloatControl;

public class YargxilAzhj {
	
	public static BufferedImage yargxBildn(final String itener, final int diafanec) {//Carga una imagen compatible
		
		Image i = null;
		
		try{
			i = ImageIO.read(ClassLoader.class.getResource("/images" + itener));
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("/images" + itener);
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getLocalizedMessage());
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		BufferedImage bild = gc.createCompatibleImage(i.getWidth(null), i.getHeight(null), diafanec);//Imagen Acelerada
		
		Graphics g = bild.getGraphics();
		g.drawImage(i, 0, 0, null);
		g.dispose();
		
		return bild;
		
	}
	public static BufferedImage yargxBildn(final String itener, final int diafanec, final Color kolor) {//Carga una imagen compatible
		
		Image i = null;
		
		try{
			i = ImageIO.read(ClassLoader.class.getResource("/images" + itener));
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("/images" + itener);
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getLocalizedMessage());
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		BufferedImage bild = gc.createCompatibleImage(i.getWidth(null), i.getHeight(null), diafanec);//Imagen Acelerada
		
		Graphics g = bild.getGraphics();
		g.drawImage(i, 0, 0, null);
		g.dispose();
		
		return Bildperant.yangxKolorn(bild, kolor.getRed(), kolor.getGreen(), kolor.getBlue());
	}

	public static BufferedImage yargxBildn(final String itener, final int diafanec, final int ie) {//Carga una imagen compatible opaca
		
		Image i = null;
		
		try{
			i = ImageIO.read(ClassLoader.class.getResource("/images" + itener));
			i = i.getScaledInstance((int) (i.getWidth(null)/ie), (int) (i.getHeight(null)/ie), Image.SCALE_SMOOTH);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("/images" + itener);
			//System.out.println(e.getMessage());
			//System.out.println(e.getCause().getLocalizedMessage());
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		BufferedImage bild = gc.createCompatibleImage(i.getWidth(null), i.getHeight(null), diafanec);//Imagen Acelerada
		
		Graphics g = bild.getGraphics();
		g.drawImage(i, 0, 0, null);
		g.dispose();
		
		return bild;
		
	}
	public static BufferedImage yargxSkalitBildn(final String itener, final int diafanec, final int largx) {//Carga una imagen compatible opaca
		
		Image i = null;
		
		try{
			i = ImageIO.read(ClassLoader.class.getResource("/images" + itener));
			i = i.getScaledInstance(largx, -1, Image.SCALE_SMOOTH);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("/images" + itener);
			//System.out.println(e.getMessage());
			//System.out.println(e.getCause().getLocalizedMessage());
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		BufferedImage bild = gc.createCompatibleImage(i.getWidth(null), i.getHeight(null), diafanec);//Imagen Acelerada
		
		Graphics g = bild.getGraphics();
		g.drawImage(i, 0, 0, null);
		g.dispose();
		
		return bild;
		
	}
	public static BufferedImage yargxSkalitBildn(final String itener, final int diafanec, final int largx,
			final int alt) {
		
		Image i = null;
		
		try{
			i = ImageIO.read(ClassLoader.class.getResource("/images" + itener));
			i = i.getScaledInstance(largx, alt, Image.SCALE_SMOOTH);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("/images" + itener);
			//System.out.println(e.getMessage());
			//System.out.println(e.getCause().getLocalizedMessage());
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		BufferedImage bild = gc.createCompatibleImage(i.getWidth(null), i.getHeight(null), diafanec);//Imagen Acelerada
		
		Graphics g = bild.getGraphics();
		g.drawImage(i, 0, 0, null);
		g.dispose();
		
		return bild;
		
	}
	public static BufferedImage yargxBildn(final String itener, final int diafanec, final int x, final int y) {//Carga una imagen compatible opaca
		
		Image i = null;
		
		try{
			i = ImageIO.read(ClassLoader.class.getResource("/images" + itener));
			i = i.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("/images" + itener);
			//System.out.println(e.getMessage());
			//System.out.println(e.getCause().getLocalizedMessage());
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		BufferedImage bild = gc.createCompatibleImage(i.getWidth(null), i.getHeight(null), diafanec);//Imagen Acelerada
		
		Graphics g = bild.getGraphics();
		g.drawImage(i, 0, 0, null);
		g.dispose();
		
		return bild;
		
	}
	public static BufferedImage yargxBildn(final String itener, final int diafanec, final int x, final int y,
			final Color kolor) {//Carga una imagen compatible opaca
		
		Image i = null;
		
		try{
			i = ImageIO.read(ClassLoader.class.getResource("/images" + itener));
			i = i.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("/images" + itener);
			//System.out.println(e.getMessage());
			//System.out.println(e.getCause().getLocalizedMessage());
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		BufferedImage bild = gc.createCompatibleImage(i.getWidth(null), i.getHeight(null), diafanec);//Imagen Acelerada
		
		Graphics g = bild.getGraphics();
		g.drawImage(i, 0, 0, null);
		g.dispose();
		
		return Bildperant.yangxKolorn(bild, kolor.getRed(), kolor.getGreen(), kolor.getBlue());
		
	}

	public static String yargxTextn(final String itener) {
		String enhav = "";
		
		InputStream bajtenir = ClassLoader.class.getResourceAsStream("/files" + itener);
		BufferedReader r = new BufferedReader(new InputStreamReader(bajtenir));
		
		String line;
		
		try {
			while((line = r.readLine()) != null)
				enhav += line;
			
		} catch(IOException e) {
			e.getStackTrace();
		} finally {
			try {
				if(bajtenir != null)
					bajtenir.close();
				if(r != null)
					r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return enhav;
	}
	public static String skribTextn(final String itener) {
		String enhav = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					new File("res/files" + itener + 0 + ".txt").getAbsolutePath()));
			for(int i = 0; i < Vicperant.ludantj.length; i++) {
				enhav += Vicperant.ludantj[i].nomn();
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].monn();
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].teleirazhj;
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].plejvivn();
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].reviviln();
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].eficientBrulazh;
				enhav += "qjqjq";
				for(int e = 0; e < Vicperant.ludantj[i].armilarn().length; e++) {
					enhav += ", ";
					enhav += Vicperant.ludantj[i].armilarn()[e];
				}
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].resistencn();
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].plejbrulazh;
				enhav += "qjqjq";
				for(int e = 0; e < Vicperant.ludantj[i].kampfortnombrjn().length; e++) {
					enhav += ", ";
					enhav += Vicperant.ludantj[i].kampfortnombrjn()[e];
				}
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].kolorn();
				enhav += "qjqjq";
				enhav += Vicperant.ludantj[i].dukolorn();
				enhav += "kxkxk";
			}
			bw.write(enhav);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public static Font yargxFontn(final String itener) {
		
		Font font;
		
		InputStream bajtenir = ClassLoader.class.getResourceAsStream("/files/fonts" + itener);
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, bajtenir);
		} catch (FontFormatException | IOException e) {
			System.out.println("CONO DE SU MAQUINA");
			e.printStackTrace();
			font = new Font(Font.SANS_SERIF, Font.PLAIN, 9);
		}
		
		font = font.deriveFont(Font.PLAIN, 12);
		
		return font;
	}
	
	public static Clip yargxSonn(final String itener, final int mlplivolum) {
		Clip clip = null;
		
		try {
			InputStream is = ClassLoader.class.getResourceAsStream(itener);
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
//			FloatControl gainControl = 
//				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//			gainControl.setValue(-mlplivolum);
			//FIXME NO FUNCIONA CON OPENJDK Y PULSEAUDIO EN NUCLEOS UBUNTU
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clip;
	}
}
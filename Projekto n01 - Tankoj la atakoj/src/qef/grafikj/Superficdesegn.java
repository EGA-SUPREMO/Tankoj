package qef.grafikj;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.DebugDatum;
import qef.ilj.DebugDesegn;
import qef.ilj.StringKvantil;
import qef.ilj.Vicperant;
import qef.kontrolj.Kontrolperant;
import qef.kontrolj.Muy;
import qef.statmayin.Statperant;
import qef.uzantinterfac.Text;

public class Superficdesegn extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	private int largx, alt;
	private Muy muy;
	
	public Superficdesegn() {
		
		this.largx = Konstantj.ludLargx;
		this.alt = Konstantj.ludAlt;
		this.muy = new Muy(this);
		
		setIgnoreRepaint(true);
		setCursor(muy.kursorn());
		setPreferredSize(new Dimension(largx, alt));
		addKeyListener(Kontrolperant.klavar);
		addMouseListener(muy);
		setFocusable(true);
		requestFocus();
		
	}
	
	public void desegn(final Statperant sp) {
		
		final BufferStrategy bufer = getBufferStrategy();
		
		if(bufer==null) {
			createBufferStrategy(4);//mi havas taskon relatita al tio
			return;
		}
		
		final Graphics g = bufer.getDrawGraphics();
		
		DebugDesegn.definigad(g);
		StringKvantil.definigad(g);
		
		DebugDesegn.setColor(Color.BLACK);//TODO mi havas taskon relatita al tiu
		DebugDesegn.desegnRectangle(0, 0, Konstantj.plejfenestrLargx, Konstantj.plejfenestrAlt);
		
		g.setFont(Konstantj.KUTIM_FONT);
		
		if(Konstantj.faktorX != 1 || Konstantj.faktorY != 1)
			((Graphics2D) g).scale(Konstantj.faktorX, Konstantj.faktorY);
		
		DebugDesegn.setColor(Konstantj.ANTAWDEFINIT_KOLOR);
		DebugDesegn.yangxGrafikn();
		sp.desegn();
		
		DebugDesegn.setColor(Konstantj.ANTAWDEFINIT_KOLOR);
		DebugDesegn.desegnString("APS: " + Konstantj.aps, 10, 20);
		DebugDesegn.desegnString("FPS: " + Konstantj.fps, 10, 30);
		
		if(Kontrolperant.klavar.debug) {
			DebugDatum.addDatumn("X: " + Vicperant.ludantj[Vicperant.nunLudantn()].xn());
			DebugDatum.addDatumn("Y: " + Vicperant.ludantj[Vicperant.nunLudantn()].yn());
			DebugDatum.addDatumn("Sekundoj pasitaj: " + Konstantj.sekundjPasita);
			try {
			DebugDatum.addDatumn("Promedio de fps po sekundo: " + Konstantj.qiufps/Konstantj.sekundjPasita);
			}catch(ArithmeticException e) {/*e.printStackTrace();*/}
			DebugDatum.addDatumn("Res: " + Text.RES.kvantn());
			DebugDatum.addDatumn("Faktoro X: " + Konstantj.faktorX);
			DebugDatum.addDatumn("Faktoro Y: " + Konstantj.faktorY);
	/*		DebugDatum.addDatumn("Venonta mapo: " + QefObjektj.map.venontMapn());
			DebugDatum.addDatumn("Komenca posicio X: " + QefObjektj.map.xLudantn());
			DebugDatum.addDatumn("Komenca posicio Y: " + QefObjektj.map.yLudantn());*/
			
			DebugDatum.addDatumn("RX: " + muy.posicin().x);
			DebugDatum.addDatumn("RY: " + muy.posicin().y);
			DebugDatum.addDatumn("Reskalita RX: " + muy.rectangleReskalitPosicin().x);
			DebugDatum.addDatumn("Reskalita RY: " + muy.rectangleReskalitPosicin().y);
			DebugDatum.addDatumn("Vento: " + (QefObjektj.map.ventn()*200));
			
			if(sp.qStatludn()) {
				DebugDesegn.desegnKolicijn();
			}
			
			DebugDatum.addDatumn("OPF: " + DebugDesegn.objektjDesegnitan());
			DebugDatum.desegn();
		}
		
		DebugDatum.malplenigDatumjn();
		
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
		
		bufer.show();
		
	}
	
	public int largxn() {
		return largx;
	}
	
	public int altn() {
		return alt;
	}
	
	public Muy muyn() {
		return muy;
	}
	
}
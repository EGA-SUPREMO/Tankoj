package swing;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class MapGeneril extends JFrame implements KeyListener, ChangeListener {
	
	private int[] seed = new int[100];
	private int amplitud = 15, offsetMap = 200, indiceR = 0;
	Random phase;
	private static int mapsize = 1024;
//	private static float[] amplitudes = {0.2f, 0.5f, 1.0f, 0.7f, 0.5f, 0.4f};
	private static float[] amplitudes = {1.0f, 0.7f, 0.46f, 0.71f, 0.14f, 0.1f};
//	private static int[] frequencies = {1, 2, 4, 8, 16, 32};
	private static int[] frequencies = {1, 1, 2, 3, 4, 8};
	private Graphics ger;
	int[][] noises = new int[frequencies.length][mapsize];
	int[] y = new int[mapsize];
	int xLudant = 0;
	int xx;
	JPanel p = new JPanel();
	Canvas canvas = new Canvas();
	JPanel sud = new JPanel(), sudsud = new JPanel(), sudcentr = new JPanel();
	JPanel internA = new JPanel(), internF = new JPanel();
	JSpinner[] JSPAmplitudes = new JSpinner[amplitudes.length], JSPFrequencies = new JSpinner[frequencies.length];
	JSpinner JSPSeed = new JSpinner(), JSPAmplitud = new JSpinner();
	JSlider[] JSAmplitudes = new JSlider[amplitudes.length];
	JSlider[] JSFrequencies = new JSlider[frequencies.length];
	JSlider JSAmplitud = new JSlider(0, 100, amplitud);
	JRadioButton[] JBBru = new JRadioButton[5];
	ButtonGroup ar = new ButtonGroup();
	private boolean dextren = false, mldextren = false, montr = false;
	JTextField kod = new JTextField(12);
	String kodo = "";
	
	public static void main(String[] args) {
		MapGeneril h = new MapGeneril();
		h.setVisible(true);
		while(true) {
			h.generMap();
			h.mov();
			h.printt();
		}	
	}
	public MapGeneril() {
		Random r = new Random(0);
		for(int i = 0; i < 100; i++)
			seed[i] = (int) (r.nextDouble() * 10000);
		for(int i = 0; i < amplitudes.length; i++) {
			JSAmplitudes[i] = new JSlider(0, 100, (int) (amplitudes[i]*100));
			JSPAmplitudes[i] = new JSpinner();
		}
		for(int i = 0; i < frequencies.length; i++) {
			JSFrequencies[i] = new JSlider(0, 64, (int) (frequencies[i]));
			JSPFrequencies[i] = new JSpinner();
		}
		for(int i = 0; i < JBBru.length; i++) {
			JBBru[i] = new JRadioButton();
			ar.add(JBBru[i]);
		}
		
		JSFrequenciesListener jsfl = new JSFrequenciesListener(JSFrequencies, this);
		JSAmplitudesListener jsal = new JSAmplitudesListener(JSAmplitudes, this);
		
		phase = new Random(seed[indiceR]);
		setSize(mapsize, 560);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Mapo");
		setContentPane(p);
		canvas.addKeyListener(this);
		
		JBBru[0].setText("Rugxa bruo");
		JBBru[1].setText("Rozkolora bruo");
		JBBru[2].setText("Blanka bruo");
		JBBru[3].setText("Blua bruo");
		JBBru[4].setText("Violkolora bruo");
		
		sud.setLayout(new BorderLayout());
		sud.add(sudsud, BorderLayout.SOUTH);
		sud.add(sudcentr, BorderLayout.CENTER);
		sudcentr.setLayout(new GridLayout(1,2));
		p.setLayout(new BorderLayout());
		p.add(canvas, BorderLayout.CENTER);
		sudcentr.setBackground(Color.PINK);
		sudcentr.add(internA);
		sudcentr.add(internF);
		internA.setLayout(new GridLayout(7, 3));
		internF.setLayout(new GridLayout(7, 3));
		p.add(sud, BorderLayout.SOUTH);

		for(int i = 0; i < amplitudes.length; i++) {
			internA.add(JSAmplitudes[i]);
			internA.add(JSPAmplitudes[i]);
			JSAmplitudes[i].addChangeListener(jsal);
		}
		for(int i = 0; i < frequencies.length; i++) {
			internF.add(JSFrequencies[i]);
			internF.add(JSPFrequencies[i]);
			JSFrequencies[i].addChangeListener(jsfl);
		}

		for(int i = 0; i < JBBru.length; i++) {
			sudsud.add(JBBru[i]);
		}
		sudsud.add(JSPSeed);
		sudsud.add(JSAmplitud);
		sudsud.add(JSPAmplitud);
		sudsud.add(kod);
		
		JSPSeed.addChangeListener(this);
		JSAmplitud.addChangeListener(this);
		JSPAmplitud.addChangeListener(this);
		
		
		JSPSeed.setSize(40, 30);
		
	}
	
	private static int[] weighted_sum(final float[] amplitudes, final int[][] noises) {
		int[] output = new int[mapsize];
		for(int k = 0; k < noises.length; k++)
			for(int x = 0; x < mapsize; x++)
				output[x] += amplitudes[k] * noises[k][x];
		return output;
	}
	
	private int[] noise(final int freq) {
		int[] output = new int[mapsize];
		//phase.setSeed(seed[indiceR]);
		double phased = phase.nextDouble()*2*Math.PI;
		for(int x = 0; x < mapsize; x++)
			output[x] = (int) Math.round(amplitud*Math.sin(2*Math.PI * freq*x/mapsize + phased));
		return output;
	}
	public void printt() {
		final BufferStrategy bufer = canvas.getBufferStrategy();
		
		if(bufer==null) {
			canvas.createBufferStrategy(4);//mi havas taskon relatita al tio
			return;
		}
		
		ger = bufer.getDrawGraphics();
		
		canvas.setIgnoreRepaint(true);
		ger.setColor(Color.CYAN);
		ger.fillRect(0, 0, mapsize, offsetMap + 155);
		ger.setColor(Color.GREEN);
		for(int x = 0; x < mapsize; x++) {
			xx = x + xLudant;
			if(xx<0) 
				ger.drawLine(xx + mapsize, offsetMap - y[x], xx + mapsize, offsetMap + 155);
			else if(xx>mapsize) 
				ger.drawLine(xx - mapsize, offsetMap - y[x], xx - mapsize, offsetMap + 155);
			else
				ger.drawLine(xx, offsetMap - y[x], xx, offsetMap + 155);
		}
		//gr.fillRect(50, 50, 50, 50);
		ger.dispose();

		bufer.show();
/*		indiceR++;
		if(indiceR>=100)
			indiceR = 0;*/
		if(montr) {
			for(int i = 0; i < frequencies.length; i++) {
				kodo = kodo + "," + frequencies[i];
			}
			for(int i = 0; i < amplitudes.length; i++) {
				kodo = kodo + "," + amplitudes[i];
			}
			kodo = kodo + "," + amplitud;
			kod.setText(kodo);
			montr = !montr;
		}
	}
	public void mov() {
		if(mldextren)
			xLudant++;
		if(dextren)
			xLudant--;
	}
	
	public void generMap() {
		phase.setSeed(seed[indiceR]);
		for(int ii = 0; ii<frequencies.length; ii++) 
			noises[ii] = noise(frequencies[ii]);
		
		y = weighted_sum(amplitudes, noises);
	}

	public static int[] frequenciesn() {
		return frequencies;
	}
	public static void setFrequencies(int[] frequencies) {
		MapGeneril.frequencies = frequencies;
	}
	public void setFrequencies(final int frequencie, final int i) {
		frequencies[i] = frequencie;
		JSPFrequencies[i].setValue(frequencie);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_A:
				mldextren = true;
				break;
			case KeyEvent.VK_D:
				dextren = true;
				break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_A:
				mldextren = false;
				break;
			case KeyEvent.VK_D:
				dextren = false;
				break;
			case KeyEvent.VK_S:
				montr = true;
				break;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		Object obj = e.getSource();
		if(obj.equals(JSPSeed)) {
			indiceR = Integer.parseInt(JSPSeed.getValue().toString());
			return;
		}
		if(obj.equals(JSPAmplitud)) {
			amplitud = Integer.parseInt(JSPAmplitud.getValue().toString());
			JSAmplitud.setValue(amplitud);
			return;
		}
		if(obj.equals(JSAmplitud)) {
			amplitud = JSAmplitud.getValue();
			JSPAmplitud.setValue(amplitud);
			return;
		}
	}
	public void setAmplitudes(final int value, final int i) {
		amplitudes[i] = value/100f;
		JSPAmplitudes[i].setValue(value);
	}
}

class JSFrequenciesListener implements ChangeListener {
	
	JSlider[] JSliders;
	MapGeneril hazard;
	
	public JSFrequenciesListener(final JSlider[] js, final MapGeneril haz) {
		hazard = haz;
		JSliders = js;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		for(int i = 0; i < JSliders.length; i++)
			hazard.setFrequencies(JSliders[i].getValue(), i);
	}
}

class JSAmplitudesListener implements ChangeListener {
	
	JSlider[] JSliders;
	MapGeneril hazard;
	
	public JSAmplitudesListener(final JSlider[] js, final MapGeneril haz) {
		hazard = haz;
		JSliders = js;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		for(int i = 0; i < JSliders.length; i++)
			hazard.setAmplitudes(JSliders[i].getValue(), i);
	}
}
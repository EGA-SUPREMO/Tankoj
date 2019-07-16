package qef.kontrolj;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Ludant;
import qef.ilj.Vicperant;
import qef.ilj.YargxilAzhj;

public class Klavar extends KeyAdapter {

	public Klav supr = new Klav();
	public Klav sub = new Klav();
	public Klav dextr = new Klav();
	public Klav mldextr = new Klav();
	public boolean kuri = false;
	public boolean debug = false;
	public boolean aktivInventari = false;
	public boolean qkolekt = false;
	public boolean qatak = false;
	public boolean subiPotenc = false;
	public boolean supriPotenc = false;
	public boolean subiArmil = false;
	public boolean supriArmil = false;
	public boolean subiKampfort = false;
	public boolean supriKampfort = false;
	public boolean uziKampfort = false;
	public boolean teleirazh = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case Konstantj.SUPR:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					supr.puls();
				break;
			case Konstantj.SUB:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					sub.puls();
				break;
			case Konstantj.DEXTR:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					dextr.puls();
				break;
			case Konstantj.MLDEXTR:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					mldextr.puls();
				break;
			case Konstantj.KURI_KAJ_TELIR:
				kuri = true;
				
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					teleirazh = true;
				
				Konstantj.ANGULRAPIDEC = 3;
				break;
			case Konstantj.SUBIPOTENC:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					subiPotenc = true;
				break;
			case Konstantj.SUPRIPOTENC:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					supriPotenc = true;
				break;
			case Konstantj.DEBUG:
				debug = !debug;
				break;
			case Konstantj.AKTIV_INVENTARI:
				aktivInventari = !aktivInventari;
				break;
			case Konstantj.QKOLEKT:
				qkolekt = true;
				break;
			case Konstantj.ATAKI:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					qatak = true;
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case Konstantj.SUPR:
				supr.mlpuls();
				break;
			case Konstantj.SUB:
				sub.mlpuls();
				break;
			case Konstantj.DEXTR:
				dextr.mlpuls();
				break;
			case Konstantj.MLDEXTR:
				mldextr.mlpuls();
				break;
			case Konstantj.SUBIPOTENC:
				subiPotenc = false;
				break;
			case Konstantj.SUPRIPOTENC:
				supriPotenc = false;
				break;
			case Konstantj.SUBIARMIL:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					subiArmil = true;
				break;
			case Konstantj.SUPRIARMIL:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					supriArmil = true;
				break;
			case Konstantj.KURI_KAJ_TELIR:
				Konstantj.ANGULRAPIDEC = 1;
				for(int i = 0; i < Vicperant.ludantj.length; i++)
					Vicperant.ludantj[i].rapidecX = 1;
				kuri = false;
				teleirazh = false;
				break;
			case Konstantj.ELIRI:
				elir();
				break;
			case Konstantj.REVIVIL:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					Vicperant.nunludantn().uzReviviln();
				break;
			case Konstantj.TELEIR:
				if(teleirazh) {
					teleirazh = false;
					Ludant.teleir();
				}
				break;
			case Konstantj.QKOLEKT:
				qkolekt = false;
				break;
			case Konstantj.UZIKAMPFORT:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					uziKampfort = true;
				break;
			case Konstantj.FORIGIKAMPFORT:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					Vicperant.nunludantn().forigKampfortn();
				break;
			case Konstantj.SUBIKAMPFORT:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					subiKampfort = true;
				break;
			case Konstantj.SUPRIKAMPFORT:
				if(Vicperant.nunMisiln()==null && QefObjektj.statp.qStatludn())
					supriKampfort = true;
				break;
			case Konstantj.GRAFIK:
				Konstantj.altGrafik = !Konstantj.altGrafik;
				break;
		}
	}
	
	public void elir() {
		YargxilAzhj.skribTextn(Konstantj.ITENER_SAVJ);
		System.exit(0);
	}
	
}
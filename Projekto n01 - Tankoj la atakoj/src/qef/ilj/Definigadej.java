package qef.ilj;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.kampfort.Kampfort;
import qef.estazhj.vivazhj.misil.Misileg;
import qef.grafikj.Fenestr;
import qef.map.Map;
import qef.statmayin.Statperant;
import qef.uzantinterfac.suprmenu.Suprmenu;

public class Definigadej {
	
	public static int i = 0;
	
	public static void definigj() {

		for(; i < Konstantj.PLEJ_BIOMJ - 1;) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Map.definigBildarn(i++);
				}
			}).start();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Ludantperant.definigadj();
				QefObjektj.suprmenu = new Suprmenu();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Misileg.definigadMisiljn();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Kampfort.definigadj();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				new Fenestr("Tankoj la atakoj");
			}
		}).start();
		//try {
		//	while(QefObjektj.statp == null)
		//		if(Vicperant.ludantj==null)
		//			Thread.currentThread().wait();
		//		else
					QefObjektj.statp = new Statperant();
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
	}
}
package qef.inventar.armil;

import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.Misil;
import qef.estazhj.vivazhj.Vivazh;
import qef.inventar.Objekt;
import qef.son.Son;
import qef.sprite.SpriteFoli;

public abstract class Armil extends Objekt {
	
	public static SpriteFoli ArmilSpriteFoli = new SpriteFoli(Konstantj.ITENER_OBJEKT_ARMIL + 0 + ".png",
			Konstantj.SPRITEFLANK, Transparency.TRANSLUCENT);
	
	protected int plejatak;
	protected int mlplejatak;
	public Son pafson;
    protected boolean automatica;
    protected boolean penetrante;
    protected double ataquesPorSegundo;
    protected int actualizacionesParaSiguienteAtaque;
	
	public Armil(final int id, final String nomo, final String priskribo, final int plejatako,
			final int mlplejatako, final boolean penetrante,
			final double ataquesPorSegundo, final String itenerson) {
		super(id, nomo, priskribo);

		plejatak = plejatako;
		mlplejatak = mlplejatako;
		this.penetrante = penetrante;
		this.ataquesPorSegundo = ataquesPorSegundo;
		actualizacionesParaSiguienteAtaque = 0;
		pafson = new Son(itenerson, 0);
	}
	
	@Override
	public BufferedImage spriten() {
		return ArmilSpriteFoli.spritejn(Konstantj.KVANT_KONSUMEBL_OBJEKT - id);
	}

	public abstract ArrayList<Rectangle> atingec(Vivazh vivazh);
	
	public void gxisdatig() {
        if (actualizacionesParaSiguienteAtaque > 0) {
            actualizacionesParaSiguienteAtaque--;
        }
	}
	
	public void atak() {
		if (actualizacionesParaSiguienteAtaque > 0)  {
			return;
		}
		actualizacionesParaSiguienteAtaque = (int) (ataquesPorSegundo * 60);
		
		pafson.play();
		QefObjektj.ludant.m = new Misil(QefObjektj.ludant.nunAngul, 100, (int) QefObjektj.ludant.xn(), (int) QefObjektj.ludant.yn());
		/*for (Vivazh vivazh : vivazhj) {
			vivazh.malgajnVivn(atakkvantn());
		}*/
	}
	
	private int atakkvantn() {
        return new Random().nextInt(plejatak - mlplejatak) + mlplejatak;
	}
	
	public boolean penetranten() {
		return penetrante;
	}
}
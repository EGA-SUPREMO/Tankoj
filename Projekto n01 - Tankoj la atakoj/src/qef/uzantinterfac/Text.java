package qef.uzantinterfac;

import qef.Konstantj;
import qef.ilj.Vicperant;

public enum Text {
	VIV(Vicperant.ludantj[Vicperant.nunLudantn()].vivn(), 100), RES(Konstantj.plejResistenc, Konstantj.plejResistenc),
	ANG(Vicperant.ludantj[Vicperant.nunLudantn()].nunangul, Konstantj.canonAngulnombr),
	ATK(Vicperant.ludantj[Vicperant.nunLudantn()].potenc, Vicperant.ludantj[Vicperant.nunLudantn()].plejpotenc);
	
	private Integer kvant;
	private Integer plejkvant;
	
	private Text(Integer kvant, Integer plejkvant) {
		this.kvant = kvant;
		this.plejkvant = plejkvant;
	}
	public void pliigKvantn() {
		kvant++;
	}
	public void mlpliigKvantn() {
		kvant--;
	}
	public void nuligKvantn() {
		kvant = 0;
	}
	public void mlnuligKvantn() {
		kvant = plejkvant;
	}
	public int kvantn() {
		return kvant;
	}
	public int plejkvantn() {
		return plejkvant;
	}
	
}
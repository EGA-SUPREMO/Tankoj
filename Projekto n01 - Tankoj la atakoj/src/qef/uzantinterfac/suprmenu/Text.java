package qef.uzantinterfac.suprmenu;

import qef.ilj.Vicperant;

public enum Text {
	VIV((int) Vicperant.ludantj[Vicperant.nunLudantn()].vivn(), 100),
	ANG(Vicperant.ludantj[Vicperant.nunLudantn()].nunanguln(), 180),
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
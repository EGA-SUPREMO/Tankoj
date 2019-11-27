package qef.uzantinterfac.suprmenu;

import qef.ilj.Vicperant;

public enum Text {
	VIV((int) Vicperant.nunludantn().vivn(), 100),
	ANG(Vicperant.nunludantn().nunanguln(), 180),
	ATK(Vicperant.nunludantn().potenc, Vicperant.nunludantn().plejpotenc);
	
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
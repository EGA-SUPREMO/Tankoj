package qef.ilj;

import java.awt.Graphics;

public class StringKvantil {
	
	public static int largxStringn(final Graphics g, final String str) {
		return g.getFontMetrics().stringWidth(str);
	}
	public static int altStringn(final Graphics g, final String str) {
		return (int) g.getFontMetrics().getLineMetrics(str, g).getHeight();
	}
	
}
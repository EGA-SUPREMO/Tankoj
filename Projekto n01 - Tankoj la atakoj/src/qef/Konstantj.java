package qef;

import java.awt.Color;
import java.awt.Font;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import qef.ilj.YargxilAzhj;
import qef.map.Biom;

public abstract class Konstantj {
	
	public static final int SPRITEFLANK = 32;
	public static final int SPRITELARGX = 480;
	
	public static final int DUONSPRITEFLANK = SPRITEFLANK >> 1;
	
	public static int ludLargx = 960;
	public static int ludAlt = 540;
	
	public final static int altSubmenu = 64;//La alto de la submenu
	
	/*
	 * public static int plejfenestrLargx =
	 * Toolkit.getDefaultToolkit().getScreenSize().width; public static int
	 * plejfenestrAlt = Toolkit.getDefaultToolkit().getScreenSize().height;
	 */
	
	public static int plejfenestrLargx = ludLargx;
	public static int plejfenestrAlt = ludAlt;
	
	public static double faktorX = 1;
	public static double faktorY = 1;
	
//public static double faktorX = ((int) ((double) plejfenestrLargx/(double) ludLargx*10d))/10d;
//public static double faktorY = Double.parseDouble(String.format("%.1f", (double) plejfenestrAlt/(double) ludAlt));
//public static double faktorY = ((int) ((double) plejfenestrAlt/(double) ludAlt*10d))/10d;
	
	public static int duonLudLargx = ludLargx >> 1;
	public static int duonLudAlt = ludAlt >> 1;
	
	public static int altCentr = duonLudAlt - DUONSPRITEFLANK;
	public static int largxCentr = duonLudLargx - DUONSPRITEFLANK;
	
	public final static int PLEJ_BIOMJ = 7;
	public final static int PLEJ_MISILJ = 6;
	public final static int LUDANTPLEJNOMBR = 8;
	public static final int plejnombrspecmisileg = 3;
	public static final int PLEJ_KAMPFORTJ = 6;
	
	public final static int nombroKlablj = 256;
	
	public final static int SUPR = KeyEvent.VK_W;
	public final static int SUB = KeyEvent.VK_S;
	public final static int MLDEXTR = KeyEvent.VK_Q;
	public final static int DEXTR = KeyEvent.VK_D;
	public final static int KURI_KAJ_TELIR = KeyEvent.VK_SHIFT;
	public final static int ELIRI = KeyEvent.VK_ESCAPE;
	public final static int TELEIR = KeyEvent.VK_T;
	public final static int DEBUG = KeyEvent.VK_F1;
	public final static int AQETI = KeyEvent.VK_C;
	public final static int SUBIPOTENC = KeyEvent.VK_K;
	public final static int SUPRIPOTENC = KeyEvent.VK_I;
	public final static int SUBIARMIL = KeyEvent.VK_J;
	public final static int SUPRIARMIL = KeyEvent.VK_L;
	public final static int ATAKI = KeyEvent.VK_SPACE;
	public final static int REVIVIL = KeyEvent.VK_R;
	public final static int GRAFIK = KeyEvent.VK_G;
	public final static int UZIKAMPFORT = KeyEvent.VK_COMMA;
	public final static int FORIGIKAMPFORT = KeyEvent.VK_PERIOD;
	public final static int SUBIKAMPFORT = KeyEvent.VK_M;
	public final static int SUPRIKAMPFORT = KeyEvent.VK_N;
	/*
	 * public final static int SUPR = KeyEvent.VK_W; public final static int SUB
	 * = KeyEvent.VK_S; public final static int MLDEXTR = KeyEvent.VK_A; public
	 * final static int DEXTR = KeyEvent.VK_D; public final static int KURI =
	 * KeyEvent.VK_SHIFT; public final static int ELIRI = KeyEvent.VK_ESCAPE;
	 * public final static int REKOMENCI = KeyEvent.VK_K; public final static
	 * int DEBUG = KeyEvent.VK_F1; public final static int QKOLEKT =
	 * KeyEvent.VK_C; public final static int SUBIPOTENC = KeyEvent.VK_F; public
	 * final static int SUPRIPOTENC = KeyEvent.VK_R; public final static int
	 * SUBIARMIL = KeyEvent.VK_Z; public final static int SUPRIARMIL =
	 * KeyEvent.VK_X; public final static int ATAKI = KeyEvent.VK_SPACE;
	 */
	
	public final static int AKTIV_INVENTARI = KeyEvent.VK_E;
	public final static int GRANDECFENESTR = KeyEvent.VK_F10;
	
	public static int qiufps = 0, fps = 0, aps = 0, sekundjPasita = 0;
	public static boolean qyangxSpriteFoli = false;
	public static int canonAngulnombr = 360;
	public static final byte LUDRAPIDEC = 1;
	public static final double MISILRAPIDEC = 0.03;//0.03
	public static int ANGULRAPIDEC = 1;
	
	public final static String SUFIX_MAP = ".egam";
	public final static String ITENER_MAP = "/maps/";
	public final static String ITENER_TILESET_MAP = "/blocks/";
	
	public final static String ITENER_VIVAZH = "/entities/";
	public final static String ITENER_LUDANT = ITENER_VIVAZH + "player_";
	public final static String ITENER_LUDANT_CANON = ITENER_VIVAZH + "canon_";
	public final static String ITENER_MISIL = ITENER_VIVAZH + "misil_";
	public final static String ITENER_ATOMMISIL = ITENER_VIVAZH + "atom_misil_";
	
	public static final String ITENER_SAVJ = "/saves/";
	
	public final static String ITENER_SONJ = "/sounds/";
	public final static String ITENER_SONJ_LUDANT = "player/";
	public static final String ITENER_SON_MISIL = ITENER_SONJ_LUDANT + "pom.wav";

	public static final String ITENER_IKON = "/icons/";
	public static final String ITENER_OBJEKTJ = "/objects/";
	
	
	public static final String ITENER_KAMPFORTJ = ITENER_OBJEKTJ + "shield_";
	
	public static final String ITENER_RUGX = ITENER_IKON + "red_";
	public static final String ITENER_BLU = ITENER_IKON + "blue_";
	public static final String ITENER_FLAV = ITENER_IKON + "yellow_";
	public static final String ITENER_VERD = ITENER_IKON + "green_";
	public static final String ITENER_GRIZ = ITENER_IKON + "grey_";
	
	public static final String ITENER_RUGX_BUTON = ITENER_RUGX + "button_";
	public static final String ITENER_BLU_BUTON = ITENER_BLU + "button_";
	public static final String ITENER_FLAV_BUTON = ITENER_FLAV + "button_";
	public static final String ITENER_VERD_BUTON = ITENER_VERD + "button_";
	public static final String ITENER_GRIZ_BUTON = ITENER_GRIZ + "button_";
	
	public static final String ITENER_RUGX_SLIDER = ITENER_RUGX + "slider";
	public static final String ITENER_BLU_SLIDER = ITENER_BLU + "slider";
	public static final String ITENER_FLAV_SLIDER = ITENER_FLAV + "slider";
	public static final String ITENER_VERD_SLIDER = ITENER_VERD + "slider";
	public static final String ITENER_GRIZ_SLIDER = ITENER_GRIZ + "slider";
	
	public final static Font KUTIM_FONT = YargxilAzhj.yargxFontn("/kenvector_future_thin.ttf");
	public final static Font KUTIM_FONT_BUTON = YargxilAzhj.yargxFontn("/kenvector_future.ttf");
	public final static Font KUTIM_FONT_BUTON1 = YargxilAzhj.yargxFontn("/Arvin Regular.ttf");
	
	public final static Color ANTAWDEFINIT_KOLOR = Color.BLUE;
	
	public final static Color KOLOR_SUPR_BANNER = Color.CYAN;
	public final static Color KOLOR_SUB_BANNER = Color.CYAN.darker();
	public final static Color FONKOLOR_INVENTARI = Color.WHITE;
	
	public final static Color KOLOR_FONSUBMENU = Color.WHITE.darker();
	
	public final static Color KOLOR_FONKOMENCMENU = new Color(255, 204, 0);
	
	public final static Color KOLOR_ATINGEC = new Color(0xCCFCB032, true).darker();
	
	public final static Color AKTIV_ETIKED_BOTON_KOLOR = KOLOR_SUB_BANNER.darker();
	
	public final static Color PLANK_NEGX_MAP_KOLOR = new Color(0xFFFFFF);
	public final static Color PLANK_MAP_KOLOR = new Color(0x55EC06);
	public final static Color SABL_MAP_KOLOR = new Color(0xE6D457);
	public final static Color CXIEL_MAP_KOLOR = new Color(0x99CCFF);
	public final static Color AKV_MAP_KOLOR = new Color(0, 171, 192).brighter();
	
	public final static int butonspec = 1;
	
	public final static BufferedImage[] BUTON_SPRITE = {
	        YargxilAzhj.yargxBildn(ITENER_BLU_BUTON + butonspec + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_RUGX_BUTON + butonspec + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_FLAV_BUTON + butonspec + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_VERD_BUTON + butonspec + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_GRIZ_BUTON + butonspec + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_BLU_BUTON + (butonspec + 2) + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_RUGX_BUTON + (butonspec + 2) + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_FLAV_BUTON + (butonspec + 2) + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_VERD_BUTON + (butonspec + 2) + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_GRIZ_BUTON + (butonspec + 2) + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_BLU_BUTON + 5 + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_RUGX_BUTON + 5 + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_FLAV_BUTON + 5 + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_VERD_BUTON + 5 + ".png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_GRIZ_BUTON + 5 + ".png", Transparency.TRANSLUCENT), null };
	
	public final static BufferedImage[] SLIDER_SPRITE = {
	        YargxilAzhj.yargxBildn(ITENER_BLU_SLIDER + "Up.png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_RUGX_SLIDER + "Up.png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_FLAV_SLIDER + "Up.png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_VERD_SLIDER + "Up.png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_GRIZ_SLIDER + "Up.png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_GRIZ_SLIDER + "_1.png", Transparency.TRANSLUCENT),
	        YargxilAzhj.yargxBildn(ITENER_GRIZ_SLIDER + "End.png", Transparency.TRANSLUCENT) };
	
	public final static Color[] KOLORJ_BUTON = {Color.WHITE, new Color(23, 133, 180).darker(),
	        new Color(205, 92, 16).darker(), new Color(142, 112, 0), new Color(61, 112, 37), new Color(153, 153, 153)};
	
	public final static BufferedImage TEXTKAMP_SPRITE = YargxilAzhj.yargxBildn(ITENER_IKON + "text_field.png",
	        Transparency.TRANSLUCENT);
	
	public static boolean altGrafik = true;
	
	public final static int HORIZONTAL_MARGXEN = 20;
	public final static int ETIKED_LARGX = 100;
	public final static int ETIKED_ALT = 20;
	public final static int VERTIKAL_MARGXEN = ETIKED_ALT;
	
	public final static int MARGXEN_BUTON = 6;
	public final static int KOMENC_MENU_ALT_BUTON = 49;
	public final static int KOMENC_MENU_VERTIKAL_MARGXEN = KOMENC_MENU_ALT_BUTON / 7;
	public final static int KOMENC_MENU_BUTONPLEJTEMP = 16;
	public final static int KOMENC_MENU_DUONBUTONPLEJTEMP = KOMENC_MENU_BUTONPLEJTEMP >> 1;

	public final static BufferedImage[] QEFFONETJ_BIOMJ = {
	        YargxilAzhj.yargxSkalitBildn("/background0_mini.png", Transparency.OPAQUE,
	                145 - Konstantj.MARGXEN_BUTON * 2, 74 - 4 - MARGXEN_BUTON*2),
	        YargxilAzhj.yargxSkalitBildn("/background1_mini.png", Transparency.OPAQUE,
	                145 - Konstantj.MARGXEN_BUTON * 2, 74 - 4 - MARGXEN_BUTON*2),
	        YargxilAzhj.yargxSkalitBildn("/background2_mini.png", Transparency.OPAQUE,
	                145 - Konstantj.MARGXEN_BUTON * 2, 74 - 4 - MARGXEN_BUTON*2),
	        YargxilAzhj.yargxSkalitBildn("/background3_mini.png", Transparency.OPAQUE,
	                145 - Konstantj.MARGXEN_BUTON * 2, 74 - 4 - MARGXEN_BUTON*2),
	        YargxilAzhj.yargxSkalitBildn("/background4_mini.png", Transparency.OPAQUE,
	                145 - Konstantj.MARGXEN_BUTON * 2, 74 - 4 - MARGXEN_BUTON*2),
	        YargxilAzhj.yargxSkalitBildn("/background0_mini.png", Transparency.OPAQUE,
	                145 - Konstantj.MARGXEN_BUTON * 2, 74 - 4 - MARGXEN_BUTON*2),
	        YargxilAzhj.yargxSkalitBildn("/background1_mini.png", Transparency.OPAQUE,
	                145 - Konstantj.MARGXEN_BUTON * 2, 74 - 4 - MARGXEN_BUTON*2),
	        YargxilAzhj.yargxSkalitBildn("/background2_mini.png", Transparency.OPAQUE,
	                145 - Konstantj.MARGXEN_BUTON * 2, 74 - 4 - MARGXEN_BUTON*2)};
	
	public final static BufferedImage[] QEFFONJ_BIOMJ =
			new BufferedImage[Konstantj.ludLargx/Konstantj.SPRITELARGX*PLEJ_BIOMJ];
	
	public final static int largxArrayQEFFONJ_BIOMJ = QEFFONJ_BIOMJ.length/PLEJ_BIOMJ;
	
	public final static BufferedImage IX = YargxilAzhj.yargxBildn(Konstantj.ITENER_GRIZ + "cross.png",
	        Transparency.TRANSLUCENT);
	public final static BufferedImage CHECK = YargxilAzhj.yargxBildn(Konstantj.ITENER_GRIZ + "checkmark.png",
	        Transparency.TRANSLUCENT);
	
	public final static float FONTGRANDEC = 22f;
	public static final int[] misileggrandecj = {11, 15, 23};
	public static final Color[] misilegKolorj = {Color.BLACK, Color.RED.darker(), Color.RED};
	public static final String[] armilarnomj = {"Misil pequegno", "Misil", "Bomba Multiple",
			"Bomba atomica pequegna", "Bomba atomica", "Bagno Caliente"};
	public static final int[] armilarprecj = {0, 30, 50, 125, 350, 90};
	public static final Color[] armilarkolorj = {Color.BLACK, Color.DARK_GRAY, Color.ORANGE, Color.RED.darker(),
			Color.RED, Color.ORANGE.darker()};
	public static final String[] kampfortnomj = {"1Escudo debil", "2Escudo", "3Escudo debil", "4Escudo", "5Escudo fuerte", "6Escudo super fuerte"};
	
	public static final int[] tankazhprecj = {15, 20, 70, 0, 25, 50, 40, 25, 25, 100, 300, 700};
	public static Biom[] biomj;
	
	public static int mapgrandec = Konstantj.ludLargx;
	public static int plejtempVent = 12000;
	public static final BufferedImage armil = YargxilAzhj.yargxBildn(ITENER_LUDANT_CANON + 0 + ".png",
			Transparency.TRANSLUCENT, 27, 29);
	public static final BufferedImage[] KAMPFORTBILDJ = new BufferedImage[PLEJ_KAMPFORTJ];
	
}
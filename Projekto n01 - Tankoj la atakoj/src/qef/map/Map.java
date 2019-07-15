package qef.map;

import java.awt.Color;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.ParseException;
//import org.json.simple.parser.JSONParser;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;
import qef.ilj.YargxilAzhj;
import qef.kontrolj.Kontrolperant;
import qef.map.mes.Mes;
import qef.map.urb.Urb;

public class Map {
	
	private Random r;
	private int rangoX, rangoY;
	@SuppressWarnings("unused")
	private int limiteX, limiteY;
	private int tileeMaplargx;
	private int tileeMapalt;
	
	public int spec;
	public double mldurec;
	private double vent;
	public int nunbiom;
	
	private static final int xAxenVideblTilej = (int) ((float)Konstantj.ludLargx/Konstantj.SPRITEFLANK + 2.99);
	private static final int yAxenVideblTilej = (int) ((float)Konstantj.ludAlt/Konstantj.SPRITEFLANK + 0.99);
	private static final int mldextrenVideblTilej = (int) ((float)(xAxenVideblTilej-2)/2 + 0.99);
	private static final int suprenVideblTilej = (int) ((float)yAxenVideblTilej/2 + 0.99);
	
	public int komencpunktX;
	public int komencpunktY;
	
	//private ArrayList<Spritetavol> spritetavolj;
	
	private BufferedImage[] map;
	
	public ArrayList<Vivazh> vivazhar;
	private double[] y;
	public int offsetMap;
	public int altMap;
	
	private boolean qmodifit = true;
	
	public Map(final int nunbiomo) {
		nunbiom = nunbiomo;
		definigBiomj();
		r = new Random();
		vent = 0.2d + r.nextDouble()*r.nextDouble()*0.08d;
		if(r.nextBoolean())
			vent = -vent;
		rangoX = 0;
		rangoY = 0;
		limiteX = 0;
		limiteY = 0;
		
		vivazhar = new ArrayList<>();
		//spritetavolj = new ArrayList<>();
		
		
		y = Konstantj.biomj[nunbiom].yn();
		offsetMap = 400;
		altMap = offsetMap + 155;
		map = new BufferedImage[Konstantj.ludLargx/Konstantj.SPRITELARGX];//TODO ALJXETAS ERAROJ SE LA NOMBRO NE ...
		
		
		mldurec = Konstantj.biomj[nunbiom].mldurec;
		
		/*
		final JSONObject globalJSON = JSONObjektn(enhav);
		tileeMaplargx = intAlJSONn(globalJSON, "width");
		tileeMapalt = intAlJSONn(globalJSON, "height");
		
		final JSONObject komencPunkt = JSONObjektn(globalJSON.get("start").toString());
		komencpunktX = intAlJSONn(komencPunkt, "x"); 
		komencpunktY = intAlJSONn(komencPunkt, "y");
		
		final JSONArray tavolj = JSONArrayn(globalJSON.get("layers").toString());
		
		spritetavolj = new ArrayList<>();
		final ArrayList<Kolizitavol> kolizitavolj = new ArrayList<>();
		
		//INICIAR CAPAS
		for (int i = 0; i < tavolj.size(); i++) {
			JSONObject tavoldatumj = JSONObjektn(tavolj.get(i).toString());

//			int anchoCapa = obtenerIntDesdeJSON(datosCapa, "width");
//			int altoCapa = obtenerIntDesdeJSON(datosCapa, "height");
			int tavollargx = tileeMaplargx;
			int tavolalt = tileeMapalt;
			int tavolX = intAlJSONn(tavoldatumj, "x");
			int tavolY = intAlJSONn(tavoldatumj, "y");
			
			switch(tavoldatumj.get("type").toString()) {
			case "tilelayer":
				JSONArray spritej = JSONArrayn(tavoldatumj.get("data").toString());
				int[] spritejTavol = new int[spritej.size()];
				for (int j = 0; j< spritej.size(); j++) {
					int spriteId = Integer.parseInt(spritej.get(j).toString());
					spritejTavol[j] = spriteId - 1;
				}
				spritetavolj.add(new Spritetavol(tavollargx, tavolalt, tavolX, tavolY, spritejTavol));
				break;
			case "objectgroup":
				JSONArray rectangulos = JSONArrayn(tavoldatumj.get("objects").toString());
				Rectangle[] rectangulosCapa = new Rectangle[rectangulos.size()];
				for (int j = 0; j < rectangulos.size(); j++) {
					JSONObject datosRectangulo = JSONObjektn(rectangulos.get(j).toString());
					
					int x = intAlJSONn(datosRectangulo, "x");
					int y = intAlJSONn(datosRectangulo, "y");
					int largx = intAlJSONn(datosRectangulo, "width");
					int alt = intAlJSONn(datosRectangulo, "height");
					/*boolean qtransenebl = false;
					if(datosRectangulo.get("properties")!=null) {
						JSONObject pasable = JSONObjektn(datosRectangulo.get("properties").toString());
						String passable = pasable.get("passable").toString();
						qtransenebl = passable != null && passable.equals("true");
					}
					System.out.println(qtransenebl);*//*
					if (x == 0) x = 1;
					if (y == 0) y = 1;
					if (largx == 0) largx = 1;
					if (alt == 0) alt = 1;
					
					Rectangle rectangulo = new Rectangle(x, y, largx, alt);
					rectangulosCapa[j] = rectangulo;
				}
				kolizitavolj.add(new Kolizitavol(tavollargx, tavolalt, tavolX, tavolY, rectangulosCapa));
				
				break;
			}
		}
		
		//COMBINAR COLISIONES EN UN SOLO ARRAYLIST POR EFICIENCIA
		arejKolici = new ArrayList<>();
		for (int i = 0; i < kolizitavolj.size(); i++) {
			Rectangle[] rectangulos = kolizitavolj.get(i).obtenerColisionables();
			
			for (int j = 0; j < rectangulos.length; j++) {
				arejKolici.add(rectangulos[j]);
			}
		}
		
		//AVERIGUAR TOTAL DE SPRITES EXISTENTES EN TODAS LAS CAPAS
		JSONArray coleccionesSprites = JSONArrayn(globalJSON.get("tilesets").toString());
		int totalSprites = 0;
		for (int i = 0; i < coleccionesSprites.size(); i++) {
			JSONObject datosGrupo = JSONObjektn(coleccionesSprites.get(i).toString());
			totalSprites += intAlJSONn(datosGrupo, "tilecount");
		}
		paletrsprite = new BufferedImage[totalSprites];
		
		//ASIGNAR SPRITES NECESARIOS A LA PALETA A PARTIR DE LAS CAPAS
		for (int i = 0; i < coleccionesSprites.size(); i++) {
			JSONObject datosGrupo = JSONObjektn(coleccionesSprites.get(i).toString());
			
			int anchoTiles = intAlJSONn(datosGrupo, "tilewidth");
			SpriteFoli hoja = new SpriteFoli(Konstantj.ITENER_TILESET_MAP + datosGrupo.get("image").toString(),
					anchoTiles, Transparency.BITMASK);
			
			int primerSpriteColeccion = intAlJSONn(datosGrupo, "firstgid") - 1;
			int ultimoSpriteColeccion = primerSpriteColeccion + intAlJSONn(datosGrupo, "tilecount") - 1;
			
			for (int j = 0; j < this.spritetavolj.size(); j++) {
				Spritetavol capaActual = this.spritetavolj.get(j);
				int[] spritesCapa = capaActual.obtenerArraySprites();
				
				for (int k = 0; k < spritesCapa.length; k++) {
					int idSpriteActual = spritesCapa[k];
					if (idSpriteActual >= primerSpriteColeccion && idSpriteActual <= ultimoSpriteColeccion) {
						if (paletrsprite[idSpriteActual] == null) {
							paletrsprite[idSpriteActual] = hoja.spritejn(idSpriteActual - primerSpriteColeccion);
						}
					}
				}
			}	
		}
		
		//OBTENER OBJETOS
		objektarj = new ArrayList<>();
		JSONArray coleccionObjetos = JSONArrayn(globalJSON.get("objetos").toString());
		for (int i = 0; i < coleccionObjetos.size(); i++) {
			JSONObject datosObjeto = JSONObjektn(coleccionObjetos.get(i).toString());
			
			int idObjeto = intAlJSONn(datosObjeto, "id");
			int cantidadObjeto = intAlJSONn(datosObjeto, "cantidad");
			int xObjeto = intAlJSONn(datosObjeto, "x");
			int yObjeto = intAlJSONn(datosObjeto, "y");
			
			Point posicionObjeto = new Point(xObjeto, yObjeto);
			Objekt objeto = Objektregistril.objektjn(idObjeto);
			//Objektar objetoUnico = new Objektar(posicionObjeto, objeto, 1);
			//objetosMapa.add(objetoUnico);
		}
		
		//OBTENER ENEMIGOS
		vivazhar = new ArrayList<>();
		JSONArray coleccionEnemigos = JSONArrayn(globalJSON.get("enemigos").toString());
		for (int i = 0; i < coleccionEnemigos.size(); i++) {
			JSONObject datosEnemigo = JSONObjektn(coleccionEnemigos.get(i).toString());
			
			int idEnemigo = intAlJSONn(datosEnemigo, "id");
			int xEnemigo = intAlJSONn(datosEnemigo, "x");
			int yEnemigo = intAlJSONn(datosEnemigo, "y");
			
			
/////////////////////////////////////GRAVA KODO///////////////////////////////////////////////////////////
			
			
			Point posicionEnemigo = new Point(xEnemigo, yEnemigo);
			//Vivazh enemigo = (Vivazh) Estazhregistril.estazhjn(idEnemigo);
			//enemigo.setX(xEnemigo);
			//enemigo.setY(yEnemigo);
			
			//vivazhar.add(enemigo);
		}
		*/
	}
	
	public void gxisdatig() {
		gxisdatigRangojn();
		gxisdatigVivazhjn();
		gxisdatigAtakjn();
		Vent.forigBrun(y);
	}
	private void gxisdatigRangojn() {
		if(Vicperant.ludantj[Vicperant.nunLudantn()].xn()/Konstantj.SPRITEFLANK-mldextrenVideblTilej>=0)
			rangoX = (int) (Vicperant.ludantj[Vicperant.nunLudantn()].xn()/Konstantj.SPRITEFLANK-mldextrenVideblTilej);
		if(Vicperant.ludantj[Vicperant.nunLudantn()].yn()/Konstantj.SPRITEFLANK-suprenVideblTilej>=0)
			rangoY = (int) (Vicperant.ludantj[Vicperant.nunLudantn()].yn()/Konstantj.SPRITEFLANK-suprenVideblTilej);
		if(rangoX+xAxenVideblTilej<=this.tileeMaplargx)
			limiteX = rangoX+xAxenVideblTilej;
		if(rangoY+yAxenVideblTilej<=this.tileeMapalt)
			limiteY = rangoY+yAxenVideblTilej;
	}
	
	private void gxisdatigVivazhjn() {
		if (!vivazhar.isEmpty()) {
			for (Vivazh vivazh:vivazhar) {
				vivazh.gxisdatig();
			}
		}
	}

	private void gxisdatigAtakjn() {
		if (Kontrolperant.klavar.qatak) {
		}
	}
	public void desegn() {
		if(qmodifit) {
			gxisdatigMapn();
			qmodifit = false;
		}
		desegnMapn();
		for (int i = 0; i < vivazhar.size(); i++) {
			vivazhar.get(i).desegn();
		}
	}
	private void gxisdatigMapn() {
		for(int i = 0; i < map.length; i++)
			map[i] = Bildperant.gxisdatigMapn(i*Konstantj.SPRITELARGX, Konstantj.SPRITELARGX);
	}
	private void desegnMapn() {
		DebugDesegn.yangxGrafikn(false);
		for(int i = 0; i < map.length; i++)
			DebugDesegn.desegnBildn(map[i], (int) Kvantperant.koordenadXalekranPosicin(i*Konstantj.SPRITELARGX), 0);
		DebugDesegn.yangxGrafikn();
	}
	/*
	private JSONObject JSONObjektn(final String JSONkod) {
		JSONParser lector = new JSONParser();
		JSONObject JSONObjekt = null;
		
		try {
			JSONObjekt = (JSONObject) lector.parse(JSONkod);
		} catch(ParseException e) {
			System.out.println("Posicio: " + e.getPosition());
			System.out.println(e);
		}
		
		return JSONObjekt;
	}
	
	private JSONArray JSONArrayn(final String JSONkod) {
		JSONParser lector = new JSONParser();
		JSONArray JSONArray = null;
		
		try {
			JSONArray = (JSONArray) lector.parse(JSONkod);
		} catch(ParseException e) {
			System.out.println("Posicio: " + e.getPosition());
			System.out.println(e);
		}
		
		return JSONArray;
	}
	
	private int intAlJSONn(final JSONObject objektJSON, final String clave) {
		return Integer.parseInt(objektJSON.get(clave).toString());
	}*/
	
	public double[] yn() {//TODO FORIRGU CXI TIUN METODON
		return y;
	}
	public double yn(int xo) {
		if(xo<0)
			xo = y.length + xo;
		else if(xo >= QefObjektj.map.yn().length)
			xo = xo - y.length;
		
		return y[xo];
	}
	public void setYn(int x, final double yo) {
		if(x<0)
			x = y.length + x;
		else if(x >= QefObjektj.map.yn().length)
			x = x - y.length;
		
		y[x] = yo;
		
		qmodifit = true;
	}
	
	public static double xn(final int x, final int kvant) {
		int xx = x + kvant;
		if(xx<0) {
			xx = QefObjektj.map.yn().length + xx;
		} else if(xx >= QefObjektj.map.yn().length) {
			xx = xx - QefObjektj.map.yn().length;
		}
		return xx;
	}
	public double ventn() {
		return vent;
	}
	public double venontVentn() {
		return vent = (r.nextDouble()/10-0.038)*(r.nextBoolean()? -1: 1)+vent;
	}
	public void venontVicn() {
		venontVentn();
		
	}
	public void setQmodifitn(final boolean qmodif) {
		qmodifit = qmodif;
	}

	static int[] frekvencij = {1, 1, 2, 3, 4, 8};
	static float[] amplitudes = {1.0f, 0.7f, 0.46f, 0.71f, 0.14f, 0.1f};

	static int[] urbfrekvencij = {3, 2};//TODO tempa
	static float[] urbamplitudes = {0.71f, 0.8f};//tempa
	
	static int[] mesfrekvencij = {10, 23, 5, 2, 1};//TODO tempa
	static float[] mesamplitudes = {0.03f, 0.05f, 0.13f, 0.1f, 0.26f};//tempa
	
	public void definigBiomj() {
		Konstantj.biomj = new Biom[Konstantj.PLEJ_BIOMJ];
			
		Konstantj.biomj[0] = new Biom(frekvencij, amplitudes, 15, 1, Konstantj.PLANK_MAP_KOLOR);
		Konstantj.biomj[1] = new Urb(urbfrekvencij, urbamplitudes, 4, 0.33, Color.GRAY);
		Konstantj.biomj[2] = new Mes(mesfrekvencij, mesamplitudes, 35/*5*/, 0.75, new Color(185, 50, 10));
		Konstantj.biomj[3] = new Biom(frekvencij, amplitudes, 50, 0.85, Konstantj.PLANK_NEGX_MAP_KOLOR);
		Konstantj.biomj[4] = new Biom(frekvencij, amplitudes, 10, 1.85, Konstantj.SABL_MAP_KOLOR);
	}
	
	public static void definigBildarn() {
		for(int i = 0; i < Konstantj.PLEJ_BIOMJ; i++) {
			final BufferedImage[] tempBildarj = Bildperant.dividBildnLawLargxspriten(
					YargxilAzhj.yargxSkalitBildn("/background" + i + ".png", Transparency.OPAQUE,
							Konstantj.ludLargx));
			for(int j = 0; j < tempBildarj.length; j++) {
				Konstantj.QEFFONJ_BIOMJ[j + i*tempBildarj.length] = tempBildarj[j];
			}
		}
	}
}
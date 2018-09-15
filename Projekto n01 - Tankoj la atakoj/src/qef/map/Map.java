package qef.map;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.Estazhregistril;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.BruGeneril;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;
import qef.ilj.YargxilAzhj;
import qef.inventar.Objekt;
import qef.inventar.Objektar;
import qef.inventar.Objektregistril;
import qef.inventar.armil.Senarma;
import qef.kontrolj.Kontrolperant;
import qef.sprite.SpriteFoli;

public class Map {
	
	private int rangoX, rangoY;
	private int limiteX, limiteY;
	private int tileeMaplargx;
	private int tileeMapalt;
	
	private double vent;
	private int xx;
	
	private static final int xAxenVideblTilej = (int) ((float)Konstantj.ludLargx/Konstantj.SPRITEFLANK + 2.99);
	private static final int yAxenVideblTilej = (int) ((float)Konstantj.ludAlt/Konstantj.SPRITEFLANK + 0.99);
	private static final int mldextrenVideblTilej = (int) ((float)(xAxenVideblTilej-2)/2 + 0.99);
	private static final int suprenVideblTilej = (int) ((float)yAxenVideblTilej/2 + 0.99);
	
	public int komencpunktX;
	public int komencpunktY;
	
	private ArrayList<Spritetavol> spritetavolj;
	
	private BufferedImage[] paletrsprite;
	
	public ArrayList<Vivazh> vivazhar;
	private int[] y;
	public int offsetMap;
	public Map(final int itener) {
		vent = 0;
		rangoX = 0;
		rangoY = 0;
		limiteX = 0;
		limiteY = 0;
		
		vivazhar = new ArrayList<>();
		spritetavolj = new ArrayList<>();
		
		int[] frequencies = {1, 1, 2, 3, 4, 8};
		float[] amplitudes = {1.0f, 0.7f, 0.46f, 0.71f, 0.14f, 0.1f};
		y = BruGeneril.generMapn(frequencies, amplitudes);
		offsetMap = 400;
		/*String enhav = YargxilAzhj.yargxTextn(Konstantj.ITENER_MAP + itener + ".tmx");
		
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

//			int anchoCapa = obtenerIntDesdeJSON(datosCapa, "width");TODO MI PETEGAS VIN(MIN) KE "FIX"-U CXI TIO
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

		if (Kontrolperant.klavar.qatak)
			Vicperant.ludantj[Vicperant.nunLudantn()].vivazharmilarn().armil1n().atak();
		gxisdatigVivazhjn();
		gxisdatigAtakjn();
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

		DebugDesegn.setColor(Color.BLUE);
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, offsetMap + 155);
		DebugDesegn.setColor(Color.CYAN);
		DebugDesegn.desegnRectangle(0, 0, Konstantj.ludLargx, offsetMap + 55);
		DebugDesegn.setColor(Color.GREEN);
		for(int x = 0; x < Konstantj.ludLargx; x++) {
			xx = (int) (Kvantperant.koordenadXalekranPosicin(x));
			if(xx<0) 
				DebugDesegn.desegnLine(xx + Konstantj.ludLargx, offsetMap - y[x], xx + Konstantj.ludLargx, offsetMap + 155);
			else if(xx>Konstantj.ludLargx) 
				DebugDesegn.desegnLine(xx - Konstantj.ludLargx, offsetMap - y[x], xx - Konstantj.ludLargx, offsetMap + 155);
			else
				DebugDesegn.desegnLine(xx, offsetMap - y[x], xx, offsetMap + 155);
		}
		for (int i = 0; i < vivazhar.size(); i++) {
			vivazhar.get(i).desegn();
		}
	}
	
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
	}
	
	public int[] yn() {
		return y;
	}
	public int yn(int x) {
		if(x<0) {
			x = QefObjektj.map.yn().length - 1;
		} else if(x >= QefObjektj.map.yn().length) {
			x = 0;
		}
		return y[x];
	}
	
	public static double xn(final int x, final int kvant) {
		int xx =(int)x + kvant;
		if(xx<0) {
			xx = QefObjektj.map.yn().length - kvant;
		} else if(xx >= QefObjektj.map.yn().length) {
			xx = kvant;
		}
		return xx;
	}
	public double ventn() {
		return vent;
	}
	
}
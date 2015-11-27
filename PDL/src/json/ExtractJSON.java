package json;


import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.json.*;
import object.*;


public class ExtractJSON implements GlobalJSON{

	public ExtractJSON() {
	}

	public boolean isGameExiste(int idGame) {

		return false;
	}
	public boolean isGameExiste(Game g) {

		return false;
	}

	public boolean isOpeningExiste(Opening o) {
		// TODO Verifier dans le fichier
		return false;
	}

	public boolean isPlayerExiste(Player p) {
		// TODO Verifier dans le fichier
		return false;
	}

	public HashMap<Integer, List<Integer>> extractScoresGames(){
		//TODO
		return new HashMap<Integer, List<Integer>>();
	}

	public FEN extractFENAfterMove(Move m){
		FEN fen = new FEN("null", null);
		return fen;
	}


	/**
	 * Create an Object game from the Json File
	 * @param idGame
	 * @return
	 * @throws IOException 
	 */
	public Game getGame(int idGame) throws IOException{
		JSONArray gamesArray = readJSONFile(GlobalJSON.GAME_FILE);

		for(int i = 0; i < gamesArray.length(); i++) {
			JSONObject gameObject = gamesArray.getJSONObject(i);
			
			if (idGame == gameObject.getInt("id")){
				Player whitePlayer = new Player(gameObject.getInt("id_white"));
				Player blackPlayer = new Player(gameObject.getInt("id_black"));
				String date = gameObject.getString("date");
				int inconnu = 0;
				List<Move> allMoves = null;
				String pgn = "";
				
				Game game = new Game(idGame, allMoves, whitePlayer, blackPlayer, null, null, inconnu, date, inconnu, inconnu, pgn);
				return game;
			}
		}
		return null;
	}

	public static JSONArray deleteJsonObject(JSONObject myJsonObject, String objectName){
		JSONArray jsonArray = readJSONFile(objectName);

		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject gameObject = jsonArray.getJSONObject(i);
			if (gameObject.getInt("id") == myJsonObject.getInt("id")){
				jsonArray.remove(i);
				break;
			}
		}
		return jsonArray;
	}

	/**
	 *  TEST JSON
	 */
	public void testParcoursJson(){
		JSONArray gamesArray = readJSONFile(GlobalJSON.GAME_FILE);
		for(int i = 0; i < gamesArray.length(); i++) {
			JSONObject game = gamesArray.getJSONObject(i);

			System.out.println("name: " + game.getString("name"));
			System.out.println("version: " + game.getString("version"));
			System.out.println("description: " + game.getString("description"));
			JSONArray nbErrors = game.getJSONArray("errors");
			for(int j = 0; j < nbErrors.length(); j++) {
				JSONObject jObject = nbErrors.getJSONObject(j);
				System.out.println("idGame: " + jObject.getInt("idGame"));
				System.out.println("nbError: " + jObject.getInt("nbError"));
			}
		}
	}

	public static JSONArray readJSONFile(String objectName){

		String result = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(PATH + objectName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}

		if (result.isEmpty()){
			return null;
		}else{
			JSONArray jsonArray = new JSONArray(result);
			return jsonArray;
		}
	}
	/**
	 * Fin TEST JSON
	 */



	/**
	 * Read the Json Object to find the game with this id
	 * @param idGame
	 * @return JsonObject Game or NULL
	 * @throws IOException
	 */
	public JSONObject getJsonGame(int idGame) throws IOException{
		JSONArray gamesArray = readJSONFile(GlobalJSON.GAME_FILE);

		for(int i = 0; i < gamesArray.length(); i++) {
			JSONObject gameObject = gamesArray.getJSONObject(i);
			if (idGame == gameObject.getInt("id")){
				return gameObject;
			}
		}
		return null;
	}

	/**
	 * Read the Json Object to find the opening with this id
	 * @param idOpening
	 * @return JsonObject Opening or NULL
	 * @throws IOException
	 */
	public JSONObject getJsonOpening(int idOpening) throws IOException{
		JSONArray openingsArray = readJSONFile(GlobalJSON.OPENING_FILE);
		for(int i = 0; i < openingsArray.length(); i++) {
			JSONObject openingObject = openingsArray.getJSONObject(i);
			if (idOpening == openingObject.getInt("id")){
				return openingObject;
			}
		}
		return null;
	}
	
	public JSONObject getJsonPlayer(int idPlayer) throws IOException{
		
		return null;
	}


	/**
	 * Remove a game to the Json file
	 * @param JsonObjectGame
	 * @throws IOException
	 */
	public JSONArray deleteJsonGame(JSONObject JsonObjectGame) throws IOException{
		JSONArray jsonArrayAll = readJSONFile(GlobalJSON.GAME_FILE);
		//TODO : A voir suivant ce que tu veux faire
		jsonArrayAll.remove(JsonObjectGame);

		JsonArrayBuilder gamesBuilder = Json.createArrayBuilder();
		JsonArray jsonArray = gamesBuilder.build();

		return jsonArray;
	}
}
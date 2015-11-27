package json;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.*;
import object.*;


public class ExtractJSON implements GlobalJSON{

	public ExtractJSON() {
	}

	public HashMap<Integer, List<Integer>> extractScoresGames(){
		//TODO extractScoresGames
		return new HashMap<Integer, List<Integer>>();
	}

	public FEN extractFENAfterMove(Move m){
		// TODO extractFENAfterMove
		return null;
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
	 * Read the Json Object to find the game with this id
	 * @param idGame
	 * @return JsonObject Game or NULL
	 * @throws IOException
	 */
	public JSONObject getJsonGame(int idGame) throws IOException{
		// TODO getJsonGame
		return null;
	}

	/**
	 * Read the Json Object to find the opening with this id
	 * @param idOpening
	 * @return JsonObject Opening or NULL
	 * @throws IOException
	 */
	public JSONObject getJsonOpening(int idOpening) throws IOException{
		// TODO getJsonOpening
		return null;
	}
	
	public Player getJsonPlayer(int idPlayer) throws IOException{
		// TODO getJsonPlayer
		return null;
	}
}
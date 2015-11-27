package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.json.JsonWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import object.FEN;
import object.Game;
import object.Opening;
import object.Player;



public class TreatmentJSON implements ITreatmentJSON, GlobalJSON {

	protected String path = "D:/wamp/www/PDL Website/json/";

	private static ExtractJSON extractJSON = new ExtractJSON();

	public void saveAllScoreToJSON(Game g, List<FEN> scores){	
		JSONObject game = extractJSON.getJsonGame(g.getId());
		boolean exists = true;
		if (game == null){
			game = createGameJson(g);
			exists = false;
		}
		JSONArray scoresJson = new JSONArray();
		int nbMove = 1;
		for(FEN fen : scores){
			JSONObject score = new JSONObject();
			score.put("number_move", nbMove);
			score.put("score", fen.getScore());
			score.put("FEN", fen.getRawFEN());

			scoresJson.put(score);
			nbMove ++;

		}

		game.put("scores", scoresJson);

		this.saveInFile(game, GlobalJSON.GAME_FILE, exists);

	}




	public void saveAverageVariation(Game g, double variable) throws IOException{

		// Get the JsonObject from the game id
		JsonObject gameJson = extractJSON.getJsonGame(g.getId());

		JsonObjectBuilder gameBuilder = Json.createObjectBuilder();

		// If the game is in the Json
		if(gameJson != null){

			// Recreate the game already set
			// TODO add the "move_average" to je JsonObject
			gameBuilder.add("", gameJson).add("move_average", variable);

			// Update the game
			//			gameBuilder.add("move_average", variable);		

		}else{

			// Create a new game in the jsonFile			
			gameBuilder.add("id", g.getId());
			gameBuilder.add("id_white", g.getWhitePlayer().getId());
			gameBuilder.add("id_black", g.getBlackPlayer().getId());
			gameBuilder.add("date", g.getDate());
			gameBuilder.add("move_average", variable);			
		}
		// Create the JsonObject
		JsonObject gameJsonObject = gameBuilder.build();

		// Save the game
		saveInFile(gameJsonObject, GAME_FILE);
	}

	public void saveBestFenToJSON(String pos, FEN fen){
		JSONArray outputJSON = new JSONArray();			
		JSONObject position = new JSONObject();

		// Create a new opening in the jsonFile
		position.put("position", position);
		position.put("evol_score_global", fen.getPosition());

		outputJSON.put(position);

		// Save the rankingPosition
		saveInFile(outputJSON, RANKINGPOSITION_FILE);
	}

	@Override
	public void saveWinRateOpening(Opening o, int nbWhite, int nbBlack, int exaequo) throws IOException {
		// Get the JsonObject from the game id
		JSONObject openingJson = extractJSON.getJsonOpening(o.getId());
		boolean exists = true;
		// If the game is in the Json
		if(openingJson == null){
			openingJson = createOpening(o);
			exists = false;
		}
		
		JSONObject white = new JSONObject();
		white.put("name", "White");
		white.put("y", nbWhite);
		white.put("color", "#F6F3EE");
		
		JSONObject black = new JSONObject();
		black.put("name", " Black");
		black.put("y", nbBlack);
		black.put("color", "#494847");
		
		JSONObject deuce = new JSONObject();
		deuce.put("name", "Deuce");
		deuce.put("y", exaequo);
		deuce.put("color", "#A4A3A3'");
		
		JSONArray rate = new JSONArray();
		rate.put(white);
		rate.put(black);
		rate.put(deuce);
		openingJson.put("data", rate);

		// Save the game
		saveInFile(openingJson, OPENING_FILE, exists);
	}


	public void saveBestFenToJSON(String pos, FEN fen){
		JSONArray outputJSON = new JSONArray();			
		JSONObject position = new JSONObject();

		// Create a new opening in the jsonFile
		position.put("position", position);
		position.put("evol_score_global", fen.getPosition());

		outputJSON.put(position);

		// Save the rankingPosition
		saveInFile(outputJSON, RANKINGPOSITION_FILE);
	}

	/**
	 * Save all the players with their errors
	 * 
	 */
	public void saveErrorToJSON(HashMap<Player,HashMap<Integer,Integer>> players){

		JsonArray playersJson = extractJSON.readJSONFile(OPENING_FILE);

		JsonArrayBuilder playersBuilder = Json.createArrayBuilder();
		JsonObjectBuilder playerBuiler = Json.createObjectBuilder();
		JsonArrayBuilder errorsBuilder = Json.createArrayBuilder();
		JsonObjectBuilder errorBuilder = Json.createObjectBuilder();		

		for (Map.Entry<Player, HashMap<Integer, Integer>> player : players.entrySet()) {

			int idPlayer = player.getKey().getId();
			playerBuiler.add("id", idPlayer);

			JsonObject myPlayerObject;
			boolean playerFinded = false;
			for (int i = 0; i < playersJson.size() && playerFinded; i++){
				JsonObject playerJson = playersJson.getJsonObject(i);
				JsonObject playerObject = (JsonObject)playerJson;
				if (idPlayer == playerObject.getInt("id")){
					playerObject = myPlayerObject;
					playerFinded = true;
				}
			}

			for (Map.Entry<Integer, Integer> error : errors.entrySet()) {

			}
			playersBuilder.add(playerBuiler);
		}
		// If the game is in the Json
		if(playerJson != null){
			// Recreate the game already set
			// TODO add the "average_win_rate" to je JsonObject
			playerBuiler.add("", playerJson).add("average_win_rate", rate);

			// Update the game
			// gameBuilder.add("average_win_rate", rate);	

		}else{
			// Create a new game in the jsonFile			
			playerBuiler.add("id", o.getId());
			playerBuiler.add("name", o.getName());
			playerBuiler.add("move", o.getMoves());
			playerBuiler.add("average_win_rate", rate);			
		}
		// Create the JsonObject
		JsonObject openingJsonObject = playerBuiler.build();

		// Save the game
		saveInFile(openingJsonObject, OPENING_FILE);
	}

	public void saveInFile(JSONObject jsonObject, String objectName, boolean exists) throws IOException{
		JsonArray jsonArray;

		switch (objectName) {
		case GlobalJSON.GAME_FILE:
			jsonArray = extractJSON.deleteJsonGame(jsonObject);
			break;
		case GlobalJSON.OPENING_FILE:

			break;
		case GlobalJSON.PLAYER_FILE:

			break;
		case GlobalJSON.RANKINGPOSITION_FILE:

			break;
		default:
			break;
		}

		writeJSONFile(jsonArray, objectName);		
	}

	/**
	 * Write the new file 
	 * @param jsonArray
	 * @param objectName
	 * @throws FileNotFoundException
	 */
	public static void writeJSONFile(JsonArray jsonArray, String objectName) throws FileNotFoundException{
		OutputStream os = new FileOutputStream(GlobalJSON.PATH + objectName);
		JsonWriter jsonWriter = Json.createWriter(os);

		jsonWriter.writeArray(jsonArray);
		jsonWriter.close();
	}

	@Override
	public void saveAverageVariation(int idGame, int averageVariation) {
		// TODO Auto-generated method stub

	}


	private JSONObject createGameJson(Game g) {
		JSONObject object = new JSONObject();

		object.put("id", g.getId());
		object.put("id_white", g.getWhitePlayer().getId());
		object.put("id_black", g.getBlackPlayer().getId());
		object.put("PGN", g.getPGN());
		object.put("evol_score_move", "");
		object.put("move_average", "");
		object.put("date", g.getDate());
		object.put("score_total_variation", "");
		object.put("id_opening", g.getOpening().getId());
		object.put("scores", "");

		return object;
	}


	private JSONObject createOpening(Opening o) {
		JSONObject object = new JSONObject();

		object.put("id", o.getId());
		object.put("name_opening", o.getName() + "-" + o.getVariation());
		object.put("nb_move", o.getNbMoves());
		object.put("move", o.getMoves());
		object.put("win", "");

		return object;
	}
}

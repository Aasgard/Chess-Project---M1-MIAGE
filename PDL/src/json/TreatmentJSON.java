package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.json.Json;
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
		JSONArray outputJSON = new JSONArray();			
		JSONObject game = new JSONObject();
		
		if(extractJSON.isGameExiste(g)){
			// TODO Update game in JSON
		}else{
			// Create a new game in the jsonFile
			game.put("id", g.getId());
			
//			Iterator it = scores.iterator();
//			
//			JSONArray scoresJson = new JSONArray();			
//			JSONObject score = new JSONObject();
			
			
			outputJSON.put(game);
		}
		
		// Save the game
		this.saveInFile(outputJSON, GAME_FILE);
	}

	public void saveTotalScoreToJSON(Game g, int totalScore){
		
		JSONArray outputJSON = new JSONArray();			
		JSONObject game = new JSONObject();
		
		if(extractJSON.isGameExiste(g)){
			// TODO Update game in JSON
		}else{
			// Create a new game in the jsonFile
			game.put("id", g.getId());
			game.put("score_total", totalScore);
			
			outputJSON.put(game);
		}
		
		// Save the game
		this.saveInFile(outputJSON, GAME_FILE);
	}
	
	public void saveAverageVariation(int idGame, double averageVariation){
		
	}


	public void saveAverageVariation(Game g, double variable){
		
		// Get the JsonObject from the game id
		JsonObject gameJson = extractJSON.getJsonGame(g.getId());
		
		JsonObjectBuilder gameBuilder = Json.createObjectBuilder();
        
		// If the game is in the Json
		if(gameJson != null){
		
			// Recreate the game already set
			gameBuilder.add("game", gameJson);
			
			// Update the game
			gameBuilder.add("move_average", variable);		
			
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
		this.saveInFile(gameJsonObject, GAME_FILE);		
	}

	public void saveBestFenToJSON(String pos, FEN fen){
		JSONArray outputJSON = new JSONArray();			
		JSONObject position = new JSONObject();
		
		// Create a new opening in the jsonFile
		position.put("position", position);
		position.put("evol_score_global", fen.getPosition());
		
		outputJSON.put(position);
		
		// Save the rankingPosition
		this.saveInFile(outputJSON, RANKINGPOSITION_FILE);
	}

	public void saveWinRateOpening(Opening o, double rate){
		JSONArray outputJSON = new JSONArray();			
		JSONObject opening = new JSONObject();
		
		if(extractJSON.isOpeningExiste(o)){
			// TODO Update the rate for an opening in JSON
		}else{
			// Create a new opening in the jsonFile
			opening.put("id", o.getId());
			opening.put("name", o.getName());
			opening.put("move", o.getMoves());
			opening.put("average_win_rate", rate);
			
			outputJSON.put(opening);
		}
		
		// Save the game
		this.saveInFile(outputJSON, OPENING_FILE);
	}

	// on est supposé sauvegarder les erreurs par partie
	// mais je ne peux pas lié une partie avec une erreur avec ces parametres
	public void saveErrorToJSON(Player p, int nbError){
		JSONArray outputJSON = new JSONArray();			
		JSONObject player = new JSONObject();
		
		if(extractJSON.isPlayerExiste(p)){
			// TODO Update number of error
		}else{
			// Create a new player in the jsonFile
			player.put("id", p.getId());
			player.put("nb_of_error", nbError);
			
			outputJSON.put(player);
		}
		
		// Save the game
		this.saveInFile(outputJSON, PLAYER_FILE);
	}

	
	/**
	 * Create or erase a file to put the new json Array
	 * @param jsonArray
	 */
	private void saveInFile(JsonObject jsonObject, String objectName){
		OutputStream os;
		
		// Get all the game from the json File
		
		// We delete the jsonObject we add
		
		// Overwrite the json File
		try {
			os = new FileOutputStream(PATH + objectName);
			JsonWriter jsonWriter = Json.createWriter(os);
	        jsonWriter.writeObject(jsonObject);
	        jsonWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
	}

}

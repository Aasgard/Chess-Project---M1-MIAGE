package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import object.FEN;
import object.Game;
import object.Opening;
import object.Player;



public class TreatmentJSON implements ITreatmentJSON, IGlobalJSON {

	private static ExtractJSON extractJSON = new ExtractJSON();

	public void saveAllScoreToJSON(Game g, int score_total_variation, List<FEN> scores){	
		JSONObject game = null;
		try {
			game = extractJSON.getJsonGame(g.getId());
			game.remove(SCORE_TOTAL_VAR);
			
		} catch (IOException e) {
			// TODO : Intégrer à la classe d'erreur ? : erreur lecture json (game n'existe pas ou erreur de fichier)
			e.printStackTrace();
		}
		boolean exists = true;
		if (game == null){
			game = createGameJson(g);
			exists = false;
		}
		game.put(SCORE_TOTAL_VAR , score_total_variation);
		
		JSONArray scoresJson = new JSONArray();
		int nbMove = 1;
		for(FEN fen : scores){
			JSONObject score = new JSONObject();
			score.put( NUMBER_MOVE , nbMove);
			score.put( SCORE , fen.getScore());
			score.put( FEN, fen.getRawFEN());

			scoresJson.put(score);
			nbMove ++;

		}
		game.put(SCORES, scoresJson);

		saveInFile(game, IGlobalJSON.GAME_FILE, exists);
	}

	// TODO : refaire fonction 
	public void saveBestFenToJSON(String pos, FEN fen){
		boolean exists = false;
		JSONArray outputJSON = new JSONArray();			
		JSONObject position = new JSONObject();

		// Create a new opening in the jsonFile
		position.put("position", position);
		position.put("evol_score_global", fen.getPosition());

		outputJSON.put(position);

		// Save the rankingPosition
		saveInFile(outputJSON, RANKINGPOSITION_FILE, exists);
	}

	@Override
	public void saveWinRateOpening(Opening o, int nbWhite, int nbBlack, int exaequo) throws IOException {
		// Get the JsonObject from the game id
		JSONObject openingJson = extractJSON.getJsonOpening(o.getId());
		boolean exists = true;
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


	/**
	 * Save all the players with their errors
	 * 
	 */
	//TODO : refaire fonction
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

	public static void saveInFile(JSONObject jsonObject, String objectName, boolean exist){

		JSONArray allData;
		if (exist){
			allData = ExtractJSON.deleteJsonObject(jsonObject, objectName);
		} else {
			allData = ExtractJSON.readJSONFile(objectName);
		}

		try {
			System.out.println(PATH + objectName);
			PrintWriter writer = new PrintWriter(PATH + objectName, "UTF-8");
			
			StringBuilder myNewFile = new StringBuilder();
			
			// Creation d'un nouveau fichier
			writer.println("[");
			if (allData == null){
				
				writer.println(jsonObject.toString(1));
				
				System.out.println("New File..");

			// Fichier déja existant
			} else {
				int i;
				for(i = 0; i < allData.length()-1; i++) {
					JSONObject object = allData.getJSONObject(i);
					writer.print(object.toString(1));
					writer.println(",");
				}
				writer.print(jsonObject.toString(1));

			}
			writer.println("]");
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + myNewFile.toString());
			writer.close();
		} catch (IOException e) {
		}
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

	@Override
	public void saveGlobalStatsToJSON(int nb_games, int nb_players, int nb_events) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGlobalBestPlayersToJSON(Player[] players) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGlobalBestGamesToJSON(Game[] games) {
		// TODO Auto-generated method stub
		
	}




}

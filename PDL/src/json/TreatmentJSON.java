package json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import object.Game;
import object.Opening;
import object.Player;
import object.Position;

public class TreatmentJSON implements ITreatmentJSON {

	private String path = "D:/wamp/www/PDL Website/json/";

	private static ExtractJSON extractJSON = new ExtractJSON();

	public void saveAllScoreToJSON(Game g, List<Integer> scores){
		
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
		this.saveInFile(outputJSON, "Game");
	}
	
	public void saveAverageVariation(int idGame, double averageVariation){
		
	}


	public void saveAverageVariation(Game g, double variable){
		JSONArray outputJSON = new JSONArray();			
		JSONObject game = new JSONObject();
		
		if(extractJSON.isGameExiste(g)){
			// TODO Update game in JSON
		}else{
			// Create a new game in the jsonFile
			game.put("id", g.getId());
			game.put("move_average", variable);
			
			outputJSON.put(game);
		}
		
		// Save the game
		this.saveInFile(outputJSON, "Game");
	}

	public void saveBestMoveToJSON(Position p, String bestFEN){
		JSONArray outputJSON = new JSONArray();			
		JSONObject position = new JSONObject();
		
		// Create a new opening in the jsonFile
	//	position.put("id", p.getId());
	//	position.put("position", p.position());
		position.put("evol_score_global", bestFEN);
		
		outputJSON.put(position);
		
		// Save the rankingPosition
		this.saveInFile(outputJSON, "RankingPosition");
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
		this.saveInFile(outputJSON, "Opening");
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
		this.saveInFile(outputJSON, "Player");
	}

	
	/**
	 * Create or erase a file to put the new json Array
	 * @param jsonArray
	 */
	private void saveInFile(JSONArray jsonArray, String objectName){
		FileWriter fw;

		try {
			File f1 = new File(this.path + objectName + ".txt");
			fw = new FileWriter(f1);
			fw.write(jsonArray.toString(2));
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}

package json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.text.Position;

import org.json.JSONArray;
import org.json.JSONObject;

import object.Game;
import object.Opening;
import object.Player;

public class TreatmentJSON implements ITreatmentJSON {

	private String path = "D:/wamp/www/PDL Website/json/test2.json";

	private static ExtractJSON extractJSON = new ExtractJSON();

	public void saveAllScoreToJSON(Game g, List<Integer> scores){

	}

	public void saveTotalScoreToJSON(Game g, int totalScore){
		
		JSONArray outputJSON = new JSONArray();			
		JSONObject game = new JSONObject();
		
		if(extractJSON.isGameExiste(g)){
			// TODO Update game in JSON
		}else{
			game.put("id", g.getId());
			game.put("score_total", totalScore);
			
			outputJSON.put(game);
		}
		
		// Save the game
		this.saveInFile(outputJSON);
	}

	public void saveAverageVariation(Game g, double variable){

	}

	public void saveBestMoveToJSON(Position g, String FEN){

	}

	public void saveWinRateOpening(Opening o, double rate){

	}

	public void saveErrorToJSON(Player p, int nbError){

	}

	private void saveInFile(JSONArray jsonArray){
		FileWriter fw;

		try {
			File f1 = new File(this.path);
			fw = new FileWriter(f1);
			fw.write(jsonArray.toString(2));
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


}

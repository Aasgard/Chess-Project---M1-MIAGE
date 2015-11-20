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
	
	private String path = "D:/wamp/www/PDL Website/json/test2.json";

	public void saveAllScoreToJSON(Game g, List<Integer> scores){
		
	}
	
	public void saveTotalScoreToJSON(Game g, int totalScore){
		
	}
	
	public void saveAverageVariation(int idGame, double averageVariation) {
		
	}
	
	public void saveBestMoveToJSON(Position bestPosition, String FEN){
		
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

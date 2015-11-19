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

public class TreatmentJSON implements ITreatmentJSON{

	public void saveAllToJSON(Game g, List<Integer> scores){
		
	}
	
	public void saveTotalScoreToJSON(Game g, int totalScore){
		
	}
	
	public void saveAverageVariation(Game g, double variable){
		
	}
	
	public void saveBestMoveToJSON(Position g, String FEN){
		
	}
	
	public void saveWinRateOpening(Opening o, double rate){
		
	}
	
	public void saveErrorToJSON(Player p, int nbError){
		
	}
	
}

package json;

import java.util.HashMap;
import java.util.List;

import object.*;

public interface ITreatmentJSON {

	public void saveAllScoreToJSON(Game g, HashMap<FEN, Integer> scores);
	
	public void saveTotalScoreToJSON(Game g, int totalScore);
	
	public void saveAverageVariation(int idGame, double averageVariation);
	
	public void saveBestFenToJSON(Position bestPosition, String FEN);

	public void saveWinRateOpening(Opening o, double rate);
	
	public void saveErrorToJSON(Player p, int nbError);
	
	
}
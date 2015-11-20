package json;

import java.util.List;

import javax.swing.text.Position;

import object.*;

public interface ITreatmentJSON {

	public void saveAllScoreToJSON(Game g, List<Integer> scores);
	
	public void saveTotalScoreToJSON(Game g, int totalScore);
	
	public void saveAverageVariation(Game g, double variable);
	
	public void saveBestMoveToJSON(Position p, String FEN);
	
	public void saveWinRateOpening(Opening o, double rate);
	
	public void saveErrorToJSON(Player p, int nbError);
	
	
}

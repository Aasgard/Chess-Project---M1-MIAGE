package json;

import java.util.List;

import javax.swing.text.Position;

import object.*;
import util.*;

public interface TreatmentJSON {

	public void saveAllToJSON(Game g, List<Integer> scores) throws SaveAllJsonException;
	
	public void saveTotalScoreToJSON(Game g, int totalScore) throws SaveTotalScoreJsonException;
	
	public void saveAverageVariation(Game g, double variable) throws SaveAverageVariationException;
	
	public void saveBestMoveToJSON(Position g, String FEN) throws SaveBestMoveToJSONException;
	
	public void saveWinRateOpening(Opening o, double rate) throws saveWinRateOpeningException;
	
	public void saveErrorToJSON(Player p, int nbError) throws saveErrorToJSONException;
	
	
}

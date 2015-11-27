package json;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import object.*;

public interface ITreatmentJSON {

	public void saveAllScoreToJSON(Game g, List<FEN> scores);
	
	public void saveAverageVariation(int idGame, double averageVariation);
	
	public void saveBestFenToJSON(String FEN, FEN bestPosition);
	
	public void saveErrorToJSON(HashMap<Player, HashMap<Integer, Integer>> players);

	public void saveWinRateOpening(Opening o, int nbWhite, int nbBlack, int exaequo)throws IOException;
	
	
}
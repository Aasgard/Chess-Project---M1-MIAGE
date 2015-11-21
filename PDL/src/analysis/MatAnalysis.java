package analysis;

import java.util.HashMap;
import java.util.Map;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class MatAnalysis {

	private static HashMap<Player, Integer> playerErrors;
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();

	public static void checkBlunderMat(Game game) {
		int score;
		
		for(Move move : game.getAlMoves()) {
			
		}
	}
	
	public static void addErrorToPlayer(Player p) {
		if(playerErrors.containsKey(p)) {
			int nbErrors = playerErrors.get(p);
			playerErrors.put(p, nbErrors++);
		}
		else {
			playerErrors.put(p, 1);
		}
	}
	
	public static void saveErrorsToJSON() {
		for(Map.Entry<Player, Integer> entry : playerErrors.entrySet()) {
			Player p = entry.getKey();
			int nbErrors = entry.getValue();
			
			treatmentJSON.saveErrorToJSON(p, nbErrors);
		}
	}

}

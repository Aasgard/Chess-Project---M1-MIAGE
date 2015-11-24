package analysis;

import java.util.HashMap;
import java.util.Map;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class MatAnalysis {

	private static HashMap<Player, Integer> playerErrors;
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	private static Player whitePlayer;
	private static Player blackPlayer;
	

	public static void checkBlunderMat(Game game) {
		whitePlayer = game.getWhitePlayer();
		blackPlayer = game.getBlackPlayer();
		boolean previousIsMateWhite = false;
		boolean currentIsMateWhite = false;
		boolean previousIsMateBlack = false;
		boolean currentIsMateBlack = false;
		
		for(Move move : game.getAlMoves()) {
			
			if(move.getHalfMove()%2 == 0) {
				currentIsMateWhite = move.isMate();
				
				if(previousIsMateWhite && !currentIsMateWhite) {
					addErrorToPlayer(whitePlayer);
				}
				
				previousIsMateWhite = currentIsMateWhite;
			}
			else {
				currentIsMateBlack = move.isMate();
				
				if(previousIsMateBlack && !currentIsMateBlack) {
					addErrorToPlayer(blackPlayer);
				}
				
				previousIsMateBlack = currentIsMateBlack;
			}
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

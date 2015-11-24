package analysis;

import java.util.HashMap;
import java.util.Map;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class MatAnalysis {

	private static Player whitePlayer;
	private static Player blackPlayer;
	private static HashMap<Player, Integer> playerErrors;
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();

	/**
	 * 
	 * @param game
	 */
	public static void checkBlunderMat(Game game) {
		whitePlayer = game.getWhitePlayer();
		blackPlayer = game.getBlackPlayer();
		boolean previousIsMateWhite = false;
		boolean currentIsMateWhite = false;
		boolean previousIsMateBlack = false;
		boolean currentIsMateBlack = false;
		
		for(Move move : game.getAlMoves()) {
			
			// whitePlayer is playing
			if(move.getHalfMove()%2 == 0) {
				currentIsMateWhite = move.isMate();
				
				if(previousIsMateWhite && !currentIsMateWhite) {
					addErrorToPlayer(whitePlayer);
				}
				
				previousIsMateWhite = currentIsMateWhite;
			}
			// blackPlayer is playing
			else {
				currentIsMateBlack = move.isMate();
				
				if(previousIsMateBlack && !currentIsMateBlack) {
					addErrorToPlayer(blackPlayer);
				}
				
				previousIsMateBlack = currentIsMateBlack;
			}
		}
	}
	
	/**
	 * 
	 * @param p
	 */
	public static void addErrorToPlayer(Player p) {
		if(playerErrors.containsKey(p)) {
			int nbErrors = playerErrors.get(p);
			playerErrors.put(p, nbErrors++);
		}
		else {
			playerErrors.put(p, 1);
		}
	}
	
	/**
	 * 
	 */
	public static void saveErrorsToJSON() {
		for(Map.Entry<Player, Integer> entry : playerErrors.entrySet()) {
			Player p = entry.getKey();
			int nbErrors = entry.getValue();
			
			treatmentJSON.saveErrorToJSON(p, nbErrors);
		}
	}

}

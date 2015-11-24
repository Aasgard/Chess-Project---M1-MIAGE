package analysis;

import java.util.HashMap;
import java.util.Map;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class MatAnalysis {

	private static Player whitePlayer;
	private static Player blackPlayer;
	private static HashMap<Integer, Integer> errorsPerGame;
	private static HashMap<Player, HashMap<Integer, Integer>> playerErrors;
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
					addErrorToPlayer(whitePlayer, game.getId());
				}
				
				previousIsMateWhite = currentIsMateWhite;
			}
			// blackPlayer is playing
			else {
				currentIsMateBlack = move.isMate();
				
				if(previousIsMateBlack && !currentIsMateBlack) {
					addErrorToPlayer(blackPlayer, game.getId());
				}
				
				previousIsMateBlack = currentIsMateBlack;
			}
		}
	}
	
	/**
	 * 
	 * @param p
	 */
	public static void addErrorToPlayer(Player p, int idGame) {
		
		if(playerErrors.containsKey(p)) {
			errorsPerGame = playerErrors.get(p);
			
			if(errorsPerGame.containsKey(idGame)) {
				int nbErrors = errorsPerGame.get(idGame);
				errorsPerGame.put(idGame, nbErrors++);
			}
		}
		else {
			errorsPerGame.put(idGame, 1);
		}
		
		playerErrors.put(p, errorsPerGame);
	}
	
	/**
	 * 
	 */
	public static void saveErrorsToJSON() {
		treatmentJSON.saveErrorToJSON(playerErrors);
	}

}

package analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;
import tools.Blunder;

public class MatAnalysis {

	private static Player whitePlayer;
	private static Player blackPlayer;
	private static List<Blunder> blundersWhitePlayer = new ArrayList<Blunder>();
	private static List<Blunder> blundersBlackPlayer = new ArrayList<Blunder>();
	private static HashMap<Player, List<Blunder>> playerErrors;
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
		blundersWhitePlayer = new ArrayList<Blunder>();
		blundersBlackPlayer = new ArrayList<Blunder>();
		Blunder blunderWhitePlayer = new Blunder(game.getId(), 0);
		Blunder blunderBlackPlayer = new Blunder(game.getId(), 0);
		
		for(Move move : game.getAlMoves()) {
			
			// whitePlayer is playing
			if(move.getHalfMove()%2 == 0) {
				currentIsMateWhite = move.isMate();
				
				if(previousIsMateWhite && !currentIsMateWhite) {
					int nbErrors = blunderWhitePlayer.getNbErrors();
					blunderWhitePlayer.setNbErrors(nbErrors++);
					blunderWhitePlayer.addPositionError(move.getFen());
				}
				
				previousIsMateWhite = currentIsMateWhite;
			}
			// blackPlayer is playing
			else {
				currentIsMateBlack = move.isMate();
				
				if(previousIsMateBlack && !currentIsMateBlack) {
					int nbErrors = blunderBlackPlayer.getNbErrors();
					blunderBlackPlayer.setNbErrors(nbErrors++);
					blunderBlackPlayer.addPositionError(move.getFen());
				}
				
				previousIsMateBlack = currentIsMateBlack;
			}
		}
		
		if(blunderWhitePlayer.getNbErrors() != 0) {
			blundersWhitePlayer.add(blunderWhitePlayer);
			
			addErrorToPlayer(whitePlayer, blundersWhitePlayer);
		}
		if(blunderBlackPlayer.getNbErrors() != 0) {
			blundersBlackPlayer.add(blunderBlackPlayer);
			addErrorToPlayer(blackPlayer, blundersBlackPlayer);
		}
	}
	
	/**
	 * 
	 * @param p
	 */
	public static void addErrorToPlayer(Player p, List<Blunder> blundersPlayer) {

		playerErrors.put(p, blundersPlayer);
		
	}
	
	/**
	 * 
	 */
	public static void saveErrorsToJSON() {
		treatmentJSON.saveErrorToJSON(playerErrors);
	}

}

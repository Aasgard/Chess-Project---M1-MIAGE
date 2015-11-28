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
		
		Blunder blunderWhitePlayer = new Blunder(game.getId(), 0);
		Blunder blunderBlackPlayer = new Blunder(game.getId(), 0);
		
		for(Move move : game.getAlMoves()) {
			
			// whitePlayer is playing
			if(move.getHalfMove()%2 == 0) {
				currentIsMateWhite = move.isMate();
				
				if(previousIsMateWhite && !currentIsMateWhite) {
					addErrorToPlayer(whitePlayer, blunderWhitePlayer, move.getFen());
				}
				
				previousIsMateWhite = currentIsMateWhite;
			}
			// blackPlayer is playing
			else {
				currentIsMateBlack = move.isMate();
				
				if(previousIsMateBlack && !currentIsMateBlack) {
					addErrorToPlayer(blackPlayer, blunderBlackPlayer, move.getFen());
				}
				
				previousIsMateBlack = currentIsMateBlack;
			}
		}
		
		if(blunderWhitePlayer.getNbErrors() != 0) {
			blundersWhitePlayer.add(blunderWhitePlayer);
			playerErrors.put(whitePlayer, blundersWhitePlayer);
		}
		if(blunderBlackPlayer.getNbErrors() != 0) {
			blundersBlackPlayer.add(blunderBlackPlayer);
			playerErrors.put(blackPlayer, blundersBlackPlayer);
		}
	}
	
	/**
	 * 
	 * @param p
	 */
	public static void addErrorToPlayer(Player p, Blunder blunder, FEN fen) {

		int nbErrors = blunder.getNbErrors();
		blunder.setNbErrors(nbErrors++);
		blunder.addPositionError(fen);
		
	}
	
	/**
	 * 
	 */
	public static void saveErrorsToJSON() {
		//treatmentJSON.saveErrorToJSON(playerErrors);
	}

}

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
	private static List<ErrorPlayer> blundersWhitePlayer = new ArrayList<ErrorPlayer>();
	private static List<ErrorPlayer> blundersBlackPlayer = new ArrayList<ErrorPlayer>();
	private static HashMap<Player, List<ErrorPlayer>> playerErrors;
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
		
		ErrorPlayer errorWhitePlayer = new ErrorPlayer(game.getId(), 0);
		ErrorPlayer errorBlackPlayer = new ErrorPlayer(game.getId(), 0);
		
		for(Move move : game.getAlMoves()) {
			
			// whitePlayer is playing
			if(move.getHalfMove()%2 == 0) {
				currentIsMateWhite = move.isMate();
				
				if(previousIsMateWhite && !currentIsMateWhite) {
					addErrorToPlayer(whitePlayer, errorWhitePlayer, move.getFen().getPosition());
				}
				
				previousIsMateWhite = currentIsMateWhite;
			}
			// blackPlayer is playing
			else {
				currentIsMateBlack = move.isMate();
				
				if(previousIsMateBlack && !currentIsMateBlack) {
					addErrorToPlayer(blackPlayer, errorBlackPlayer, move.getFen().getPosition());
				}
				
				previousIsMateBlack = currentIsMateBlack;
			}
		}
		
		if(errorWhitePlayer.getNb_of_error() != 0) {
			blundersWhitePlayer.add(errorWhitePlayer);
			playerErrors.put(whitePlayer, blundersWhitePlayer);
		}
		if(errorBlackPlayer.getNb_of_error() != 0) {
			blundersBlackPlayer.add(errorBlackPlayer);
			playerErrors.put(blackPlayer, blundersBlackPlayer);
		}
	}
	
	/**
	 * 
	 * @param p
	 */
	public static void addErrorToPlayer(Player p, ErrorPlayer error, String fen) {

		int nbErrors = error.getNb_of_error();
		error.setNb_of_error(nbErrors++);
		error.addErrorFen(fen);
		
	}
	
	/**
	 * 
	 */
	public static void saveErrorsToJSON() {
		treatmentJSON.saveErrorToJSON(playerErrors);
	}

}

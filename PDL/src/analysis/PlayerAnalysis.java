package analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;
import tools.Blunder;

public class PlayerAnalysis {

	private static Player whitePlayer;
	private static Player blackPlayer;
	private static List<Player> players = new ArrayList<Player>();
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();

	/**
	 * 
	 * @param game
	 */
	public static void getPlayerStats(Game game) {
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
					addErrorToErrorPlayer(errorWhitePlayer, move.getFen().getPosition());
				}
				
				previousIsMateWhite = currentIsMateWhite;
			}
			// blackPlayer is playing
			else {
				currentIsMateBlack = move.isMate();
				
				if(previousIsMateBlack && !currentIsMateBlack) {
					addErrorToErrorPlayer(errorBlackPlayer, move.getFen().getPosition());
				}
				
				previousIsMateBlack = currentIsMateBlack;
			}
		}
		
		addStatsToPlayers(game, errorWhitePlayer, errorBlackPlayer);
		players.add(whitePlayer);
		players.add(blackPlayer);
	}
	
	/**
	 * 
	 * @param p
	 */
	public static void addErrorToErrorPlayer(ErrorPlayer error, String fen) {

		error.addNbError();
		error.addErrorFen(fen);
		
	}
	
	public static void addStatsToPlayers(Game game, ErrorPlayer errorWhitePlayer, ErrorPlayer errorBlackPlayer) {
		// add Winner
		if(game.getResult() == 0) {
			whitePlayer.addNbGameWin();
		}
		else if (game.getResult() == 1) {
			blackPlayer.addNbGameWin();
		}
		
		// add nbGamePlayed
		whitePlayer.addNbGamePlayed();
		blackPlayer.addNbGamePlayed();
		
		// add errors
		if(errorWhitePlayer.getNb_of_error() > 0) {
			whitePlayer.addError(errorWhitePlayer);
		}
		if(errorBlackPlayer.getNb_of_error() > 0) {
			blackPlayer.addError(errorBlackPlayer);
		}
	}
	
	/**
	 * 
	 */
	public static void savePlayersToJSON() {
		treatmentJSON.savePlayersToJSON(players);
	}

}

package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class PlayerAnalysis {

	private Player whitePlayer;
	private Player blackPlayer;
	private List<Player> players;

	private ITreatmentJSON treatmentJSON = new TreatmentJSON();
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * 
	 * @param game
	 */
	
	public PlayerAnalysis(){
		players = new ArrayList<Player>();
	}
	public void getPlayerStats(Game game) {
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
		
		// set the winner
		boolean whiteWinner = false;
		boolean blackWinner = false;		
		if(game.getResult() == 0) {
			whiteWinner = true;
			blackWinner = false;
		}
		else if (game.getResult() == 1) {
			whiteWinner = false;
			blackWinner = true;
		}
		
		// add error
		if(errorWhitePlayer.getNb_of_error() > 0) {
			whitePlayer.addError(errorWhitePlayer);
		}
		if(errorBlackPlayer.getNb_of_error() > 0) {
			blackPlayer.addError(errorBlackPlayer);
		}

		// add player to the list
		addPlayer(whitePlayer, whiteWinner);
		addPlayer(blackPlayer, blackWinner);
	}
	
	/**
	 * 
	 * @param p
	 */
	public void addErrorToErrorPlayer(ErrorPlayer error, String fen) {

		error.addNbError();
		error.addErrorFen(fen);
		
	}
	
	public void addPlayer(Player player, boolean winner) {
		boolean exists = false;
		Iterator<Player> it = players.iterator();
		
		while(it.hasNext() && !exists) {
			Player p = it.next();
			
			if(p.getId() == player.getId()) {
				exists = true;
				
				// add errors
				for(ErrorPlayer e : player.getErrors()) {
					p.addError(e);
				}
				
				// if winner
				if(winner) {
					p.addNbGameWin();
				}
				
				// add nbGamePlayed
				p.addNbGamePlayed();
			}
		}

		if(!exists) {
			if(winner) {
				player.addNbGameWin();
			}
			
			player.addNbGamePlayed();
			
			players.add(player);
		}
	}
	
	public void addStatsToPlayers(Game game, ErrorPlayer errorWhitePlayer, ErrorPlayer errorBlackPlayer) {
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
	public void savePlayersToJSON() {
		treatmentJSON.savePlayersToJSON(players);
	}

}

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
	
	public PlayerAnalysis(){
		players = new ArrayList<Player>();
	}
	
	/**
	 * Enregistre les stats et les erreurs de chaque joueur pour un game donné
	 * 
	 * @param game
	 */
	public void getPlayerStats(Game game) {
		// récupération des players
		whitePlayer = game.getWhitePlayer();
		blackPlayer = game.getBlackPlayer();
		
		// instanciation des ErrorPlayer pour le game
		ErrorPlayer errorWhitePlayer = new ErrorPlayer(game.getId(), 0);
		ErrorPlayer errorBlackPlayer = new ErrorPlayer(game.getId(), 0);
		
		// repérer les erreurs
		checkBlunderMat(game.getAlMoves(), errorWhitePlayer, errorBlackPlayer);
		
		// ajout des erreurs s'il y en a eu
		if(errorWhitePlayer.getNb_of_error() > 0) {
			whitePlayer.addError(errorWhitePlayer);
		}
		if(errorBlackPlayer.getNb_of_error() > 0) {
			blackPlayer.addError(errorBlackPlayer);
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
		
		// add player to the list
		addPlayer(whitePlayer, whiteWinner);
		addPlayer(blackPlayer, blackWinner);
	}
	
	/**
	 * Ajout d'une erreur dans un ErrorPlayer
	 * Met à jour le nombre d'erreurs et ajoute la position de l'erreur
	 * 
	 * @param error
	 * @param fen
	 */
	public void addErrorToErrorPlayer(ErrorPlayer error, String fen) {

		error.addNbError();
		error.addErrorFen(fen);
		
	}
	
	/**
	 * Repérer les erreurs de chaque joueur pour une liste de Move donnée
	 * 
	 * @param moves
	 * @param errorWhitePlayer
	 * @param errorBlackPlayer
	 */
	public void checkBlunderMat(List<Move> moves, ErrorPlayer errorWhitePlayer, ErrorPlayer errorBlackPlayer) {
		
		boolean previousIsMateWhite = false;
		boolean currentIsMateWhite = false;
		boolean previousIsMateBlack = false;
		boolean currentIsMateBlack = false;
		
		for(Move move : moves) {
			
			// whitePlayer is playing
			if(move.getHalfMove()%2 == 0) {
				currentIsMateWhite = move.isMate();
				if(currentIsMateWhite) {
					System.out.println("mate");
				}
				
				// erreur du joueur blanc
				if(previousIsMateWhite && !currentIsMateWhite) {
					addErrorToErrorPlayer(errorWhitePlayer, move.getFen().getPosition());
					System.out.println("\n Blunder \n");
				}
				
				previousIsMateWhite = currentIsMateWhite;
			}
			// blackPlayer is playing
			else {
				currentIsMateBlack = move.isMate();
				if(currentIsMateBlack) {
					System.out.println("mate");
				}
				
				// erreur du joueur noir
				if(previousIsMateBlack && !currentIsMateBlack) {
					addErrorToErrorPlayer(errorBlackPlayer, move.getFen().getPosition());
					System.out.println("\n Blunder \n");
				}
				
				previousIsMateBlack = currentIsMateBlack;
			}
		}
	}
	
	/**
	 * Ajout du player dans la liste avec ses stats mises à jour
	 * Vérifie si le player est déjà présent ou non dans la liste
	 * 
	 * @param player
	 * @param winner
	 */
	public void addPlayer(Player player, boolean winner) {
		boolean exists = false;
		Iterator<Player> it = players.iterator();
		
		while(it.hasNext() && !exists) {
			Player p = it.next();
			
			// si le player est dans la liste
			if(p.getId() == player.getId()) {
				exists = true;
				
				// add errors
				for(ErrorPlayer e : player.getErrors()) {
					p.addError(e);
				}
				// add nbGameWin
				if(winner) {
					p.addNbGameWin();
				}	
				// add nbGamePlayed
				p.addNbGamePlayed();
			}
		}
		// le player n'est pas dans la liste
		if(!exists) {
			// add nbGameWin
			if(winner) {
				player.addNbGameWin();
			}
			// add nbGamePlayed
			player.addNbGamePlayed();
			// add player to the list
			players.add(player);
		}
	}
	
	/**
	 * Enregistre tous les players dans un json
	 */
	public void savePlayersToJSON() {
		treatmentJSON.savePlayersToJSON(players);
	}

}

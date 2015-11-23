package json;


import java.util.HashMap;
import java.util.List;

import object.Move;
import object.Position;

import object.Game;
import object.Opening;
import object.Player;
import object.FEN;


public class ExtractJSON {

	public ExtractJSON() {
	}

	public boolean isGameExiste(Game g) {
		// TODO Verifier dans le fichier
		return false;
	}
	
	public boolean isOpeningExiste(Opening o) {
		// TODO Verifier dans le fichier
		return false;
	}
	
	public boolean isPlayerExiste(Player p) {
		// TODO Verifier dans le fichier
		return false;
	}
	
	public Position extractScoreAfterMove(Move m){
		//TODO
		Position positionSuivante = null;
		return positionSuivante;
	}
	
	public HashMap<Integer, List<Integer>> extractScoresGames(){
		//TODO
		return new HashMap<Integer, List<Integer>>();
	}
	
	public FEN extractFenAfterMove(Move m){
		FEN fen = new FEN();
		return fen;
	}
}
package analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import json.ExtractJSON;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.FEN;
import object.Move;

public class ScoreFromPositionAnalysis {

	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	private FEN bestFEN;
	
	public ScoreFromPositionAnalysis(){
		setBestFEN(new FEN(new String(), new String()));
	}
	
	/**
	 * Sauvegarde le meilleur move pour un FEN
	 * @param Position
	 * @param movesByGame
	 */
	public void getEvolScore(String Position, HashMap<Integer, List<Move>> movesByGame){
		
		// Parcours les differentes parties
		for(Entry<Integer, List<Move>> fenMoves :  movesByGame.entrySet()){
			List<Move> moves = fenMoves.getValue();
			
			// Parcours les moves d'une partie
			for(Move move: moves){
				this.isBestMove(ExtractJSON.extractFENAfterMove(move));
			}
		}

		treatmentJSON.saveBestFenToJSON(Position, getBestFEN());
	}
	
	private void isBestMove(FEN fen ){
		if(fen.getScore() > getBestFEN().getScore()){
			getBestFEN().setPosition(fen.getPosition());
			getBestFEN().setScore(fen.getScore());
		}
	}

	public FEN getBestFEN() {
		return bestFEN;
	}

	public void setBestFEN(FEN bestFEN) {
		this.bestFEN = bestFEN;
	}
}
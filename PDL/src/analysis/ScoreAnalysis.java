package analysis;

import java.util.*;

import json.*;
import object.FEN;
import object.Game;
import object.Move;

public class ScoreAnalysis {
	
	private static List<FEN> scores;
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	/**
	 * Analyze the score of a game
	 * @param game to analyze
	 */
	public static void analyzeScoreGame(Game game) {
		scores = new ArrayList<FEN>();
		for(Move move : game.getAlMoves()){
			FEN fen = move.getFen();
			scores.add(fen); 
		}
		treatmentJSON.saveAllScoreToJSON(game, scores);		
		
	}
	
	

}

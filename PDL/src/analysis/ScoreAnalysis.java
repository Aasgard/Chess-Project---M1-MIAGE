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
	
	public static void analyzeScore(Game game){
		
		int previousScore = 0;
		int sumScoreVariation = 0;
		scores = new ArrayList<FEN>();
		
		for(Move move : game.getAlMoves()){
			
			FEN fen = move.getFen();
			scores.add(fen); 
			
			sumScoreVariation =+ calculVariationScore(previousScore, fen.getScore());
			previousScore = fen.getScore();
		}
		treatmentJSON.saveAllScoreToJSON(game, scores);
		treatmentJSON.saveAverageVariation(game, sumScoreVariation);
	}
	
	private static int calculVariationScore(int previousScore, int score){
		return (Math.abs(score - previousScore));
	}
	

}

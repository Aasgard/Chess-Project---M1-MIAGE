package analysis;

import java.util.*;

import json.*;
import object.FEN;
import object.Game;
import object.Move;
import tools.Tools;

public class ScoreAnalysis {
	
	private static HashMap<FEN, Integer> scores;
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	/**
	 * Analyze the score of a game
	 * @param game to analyze
	 */
	public static void analyzeScoreGame(Game game) {
		scores = new HashMap<FEN,Integer>();
		for(Move move : game.getAlMoves()){
			int score = move.getFen().getScore();
			scores.put(move.getFen(), score); 
		}
		treatmentJSON.saveAllScoreToJSON(game, scores);
		List<Integer> list = new ArrayList(scores.values());
		int sumScore = Tools.getSommeAL(list);
		
		treatmentJSON.saveTotalScoreToJSON(game, sumScore);
	}
	
	

}

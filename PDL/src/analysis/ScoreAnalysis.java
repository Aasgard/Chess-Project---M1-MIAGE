package analysis;

import java.util.*;

import json.*;
import object.Game;
import object.Move;
import tools.Tools;

public class ScoreAnalysis {
	
	private static List<Integer> scores;
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	/**
	 * Analyze the score of a game
	 * @param game to analyze
	 */
	public static void analyzeScoreGame(Game game) {
		scores = new ArrayList<Integer>();
		for(Move move : game.getAlMoves()){
			int score = move.getHigherDepthScore();
			scores.add(score);
		}
		treatmentJSON.saveAllScoreToJSON(game, scores);
		
		int sumScore = Tools.getSommeAL(scores);
		
		treatmentJSON.saveTotalScoreToJSON(game, sumScore);
	}
	
	

}

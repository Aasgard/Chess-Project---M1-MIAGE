package analysis;

import java.util.List;

import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.Game;

public class ScoreVariationAnalysis {
	
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	public static void getAverageVariationGame(Game game, List<Integer> scores) {
		int previousScore = 0;
		int sumScoreVariation = 0;
		for(Integer score : scores){
			sumScoreVariation =+ calculVariationScore(previousScore, score);
			previousScore = score;
		}
		treatmentJSON.saveAverageVariation(game, sumScoreVariation);
	}

	private static int calculVariationScore(int previousScore, int score){
		return (Math.abs(score - previousScore));
	}
	
}

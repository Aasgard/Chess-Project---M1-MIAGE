package analysis;

import java.util.List;

import json.ITreatmentJSON;
import json.TreatmentJSON;

public class ScoreVariationAnalysis {
	
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	public static void getAverageVariationGame(Integer idGame, List<Integer> scores) {
		int previousScore = 0;
		int sumScoreVariation = 0;
		for(Integer score : scores){
			sumScoreVariation =+ calculVariationScore(previousScore, score);
			previousScore = score;
		}
		
		treatmentJSON.saveAverageVariation(idGame, 	sumScoreVariation/scores.size());
	}

	private static int calculVariationScore(int previousScore, int score){
		return (score - previousScore);
	}
	
}

package analysis;

import java.util.List;

import json.ITreatmentJSON;
import json.TreatmentJSON;

public class ScoreVariationAnalysis {
	
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	public static void getAverageVariationGame(Integer idGame, List<Integer> scores) {
		int scorePrecedent = 0;
		int sumScoreVariation = 0;
		for(Integer score : scores){
			sumScoreVariation =+ calculVariationScore(scorePrecedent, score);
			scorePrecedent = score;
		}
		treatmentJSON.saveAverageVariation(idGame, 	sumScoreVariation/scores.size());
	}

	private static int calculVariationScore(int scorePrecedent, int score){
		return (score - scorePrecedent);
	}
	
}

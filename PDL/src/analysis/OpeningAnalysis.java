package analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class OpeningAnalysis {
	
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	/**
	 * Calcul and save win rate for the opening
	 * @param o
	 * @param games
	 * @throws IOException 
	 */
	public static HashMap<Opening, List<Integer>> getWinRateOpening(Opening o, List<Integer> value){
		HashMap<Opening, List<Integer>> results = new HashMap<Opening, List<Integer>>(); 
		List<Integer> total = new ArrayList<Integer>();
		
		int nbWhite = 0;
		int nbBlack = 0;
		int exaequo = 0;
		
		for(int result : value){
			//White player win
			if(result == 0)
				nbWhite++;
			else if(result == 1)
				nbBlack ++;
			else
				exaequo++;
		}
		
		// Ajoute les totaux 
		total.add(nbWhite);
		total.add(nbBlack);
		total.add(exaequo);
		
		// Ajoute le total des resultats
		results.put(o, total);
		
		return results;
	}

}

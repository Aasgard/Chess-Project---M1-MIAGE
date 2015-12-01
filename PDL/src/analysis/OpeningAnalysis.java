package analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class OpeningAnalysis {
	
	/**
	 * Calcul and save win rate for the opening
	 * @param o
	 * @param games
	 * @throws IOException 
	 */
	public static List<Integer> getWinRateOpening(List<Integer> value){
		List<Integer> results = new ArrayList<Integer>();
		
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
		results.add(nbWhite);
		results.add(nbBlack);
		results.add(exaequo);
		
		return results;
	}

}

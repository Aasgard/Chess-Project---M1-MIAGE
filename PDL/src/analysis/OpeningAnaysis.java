package analysis;

import java.util.List;

import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class OpeningAnaysis {
	
	private static int nbWhite;
	private static int nbBlack;
	private static int exaequo;
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	/**
	 * Calcul and save win rate for the opening
	 * @param o
	 * @param games
	 */
	public static void getWinRateOpening(Opening o, List<Integer> value) {
		nbWhite = 0;
		nbBlack = 0;
		exaequo = 0;
		for(int result : value){
			//White player win
			if(result == 0)
				nbWhite++;
			else if(result == 1)
				nbBlack ++;
			else
				exaequo++;
		}
		
		treatmentJSON.saveWinRateOpening(o, nbWhite, nbBlack, exaequo);
	}

}

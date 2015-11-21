package analysis;

import java.util.List;

import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.*;

public class OpeningAnaysis {
	
	private static int nbWin;
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	/**
	 * Calcul and save win rate for the opening
	 * @param o
	 * @param games
	 */
	public static void getWinRateOpening(Opening o, List<Game> games){
		nbWin = 0;
		for(Game game : games){
			//White player win
			if(game.getResult() == 0)
				nbWin++;
		}
		
		treatmentJSON.saveWinRateOpening(o, nbWin/games.size());
		
	}

}

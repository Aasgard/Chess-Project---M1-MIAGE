package analysis;

import java.util.HashMap;
import java.util.List;

import database.*;
import object.Game;
import object.Move;
import object.Opening;

public class Analysis {
	private static IExtractDB extractDB = new ExtractDB();
	
	
	public static void analyzeScoreGame(){
		List<Game> games = extractDB.extractGames();
		
		for(Game game : games){
			ScoreAnalysis.analyzeScoreGame(game);
		}
	}
}

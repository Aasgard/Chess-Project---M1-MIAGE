package analysis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import database.*;
import json.ExtractJSON;
import object.*;

public class Analysis {

	private static IExtractDB extractDB = new ExtractDB();


	public static void analyzeScoreGame(){
		List<Game> games = extractDB.extractGames();

		for(Game game : games){
			ScoreAnalysis.analyzeScoreGame(game);
		}
	}

	public static void analyzeScoreEvolutionFromPosition(){

		HashMap<String, List<Move>> mapFENMoves= extractDB.extractGameAndMoveByPosition();

		for(Entry<String, List<Move>> fenMoves :  mapFENMoves.entrySet()){
			ScoreFromPositionAnalysis.getEvolScore(fenMoves.getValue());
		}
	}

	public static void analyzeScoreVariation(){
		ExtractJSON extractJSON = new ExtractJSON();

		List<Game> listGames = extractJSON.extractScoresGames();

		for(Game g : listGames){
			List<Integer> listeScore = new ArrayList<Integer>();
			for(Move m : g.getAlMoves()){
				listeScore.add(m.getFen().getScore());
			}
			ScoreVariationAnalysis.getAverageVariationGame(g, listeScore);

		}
	}

	public static void analyzeOpenings(){
		HashMap<Opening, List<Game>> mapgameByOpening = extractDB.extractGamesByOpening();

		for(Entry<Opening, List<Game>> gameByOpening : mapgameByOpening.entrySet()){
			OpeningAnaysis.getWinRateOpening(gameByOpening.getKey(), gameByOpening.getValue());
		}
	}

	public static void analyzeBlunderMat() {
		List<Game> games = extractDB.extractGames();

		for(Game game : games){
			MatAnalysis.checkBlunderMat(game);
		}	
		MatAnalysis.saveErrorsToJSON();
	}

}

package analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import database.*;
import json.ExtractJSON;
import object.*;

public class Analysis {

	private List<Game> games;
	
	public Analysis(){
		this.setGames(ExtractDB.extractGames());
	}
	
	public void analyzeScoreGame(){
		
		for(Game game : this.getGames()){
			ScoreAnalysis.analyzeScoreGame(game);
		}
	}

	public static void analyzeScoreEvolutionFromPosition(){

		HashMap<String, List<Move>> mapFENMoves= ExtractDB.extractGameAndMoveByPosition();

		for(Entry<String, List<Move>> fenMoves :  mapFENMoves.entrySet()){
			ScoreFromPositionAnalysis.getEvolScore(fenMoves.getValue());
		}
	}

	public static void analyzeScoreVariation() throws IOException{
		ExtractJSON extractJSON = new ExtractJSON();

		List<Game> listGames = new ArrayList<Game>();
		// TODO : revoir extractScoreGames, à quoi correspondent les differents int
		//= extractJSON.extractScoresGames();

		for(Game g : listGames){
			List<Integer> listeScore = new ArrayList<Integer>();
			for(Move m : g.getAlMoves()){
				listeScore.add(m.getFen().getScore());
			}
			ScoreVariationAnalysis.getAverageVariationGame(g, listeScore);

		}
	}

	public static void analyzeOpenings() throws IOException{
		HashMap<Opening, List<Integer>> mapgameByOpening = ExtractDB.extractResultsByOpening();

		for(Entry<Opening, List<Integer>> gameByOpening : mapgameByOpening.entrySet()){
			OpeningAnaysis.getWinRateOpening(gameByOpening.getKey(), gameByOpening.getValue());
		}
	}

	public void analyzeBlunderMat() {	
		for(Game game : this.getGames()){
			MatAnalysis.checkBlunderMat(game);
		}	
		MatAnalysis.saveErrorsToJSON();
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

}

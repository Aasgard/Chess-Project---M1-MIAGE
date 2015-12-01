package analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import database.*;
import object.*;

public class Analysis {

	private List<Game> games;
	
	public Analysis(){
		this.setGames(ExtractDB.extractGames());
	}
	
	public void analyzeScoreGame(){
		
		for(Game game : this.getGames()){
			ScoreAnalysis.analyzeScore(game);
		}
	}

	public static void globalPlayer(){
		//TODO : a voir
	}
	
	public void globalStats(){
		GlobalStats.getGlobalStats(games.size());
	}
	
	public void globalBestGame(){
		GlobalStats.getGlobalBestVar(games);
	}
	
	public static void analyzeScoreEvolutionFromPosition(){

		HashMap<String, List<Move>> mapFENMoves= ExtractDB.extractGameAndMoveByPosition();

		for(Entry<String, List<Move>> fenMoves :  mapFENMoves.entrySet()){
			ScoreFromPositionAnalysis.getEvolScore(fenMoves.getValue());
		}
	}

	public void analyzeOpenings() throws IOException{
		HashMap<Opening, List<Integer>> mapgameByOpening = new HashMap<Opening, List<Integer>>();
		for(Game g : games){
			List<Integer> results = mapgameByOpening.get(g.getOpening());
			if(results == null){
				results = new ArrayList<Integer>();
			}
			results.add(g.getResult());
			mapgameByOpening.put(g.getOpening(), results);
		}
		
		for(Entry<Opening, List<Integer>> gameByOpening : mapgameByOpening.entrySet()){
			OpeningAnaysis.getWinRateOpening(gameByOpening.getKey(), gameByOpening.getValue());
		}
	}

	public void analyzePlayers() {	
		for(Game game : this.getGames()){
			PlayerAnalysis.getPlayerStats(game);
		}	
		PlayerAnalysis.savePlayersToJSON();
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

}

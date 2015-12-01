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

	public void analyzeOpenings(){
		HashMap<Integer, ResultsByOpening> mapgameByOpening = new HashMap<Integer, ResultsByOpening>();
		for(Game g : games){
			ResultsByOpening results = mapgameByOpening.get(g.getOpening().getId());
			
			if(results == null){
				results = new ResultsByOpening(g.getOpening());
			}
			results.addResult(g.getResult());
			mapgameByOpening.put(g.getOpening().getId(), results);
		}
		
		for(Entry<Integer, ResultsByOpening> gameByOpening : mapgameByOpening.entrySet()){
			OpeningAnaysis.getWinRateOpening(gameByOpening.getValue().getOpening(), gameByOpening.getValue().getResults());
		}
	}

	public void analyzePlayers() {
		PlayerAnalysis pa = new PlayerAnalysis();
		for(Game game : this.getGames()){
			pa.getPlayerStats(game);
		}	
		pa.savePlayersToJSON();
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public void bestPlayers() {
		GlobalStats.getGlobalBestPlayers();
		
	}

}

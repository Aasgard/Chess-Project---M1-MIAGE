package analysis;

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
	
	public void globalStats(){
		GlobalStats.getGlobalStats(games.size());
	}
	
	public void globalBestGame(){
		GlobalStats.getGlobalBestVar(games);
	}
	
	public void analyzeScoreEvolutionFromPosition(){

		HashMap<String, HashMap<Integer, List<Move>>> mapFenMoves = new HashMap<String, HashMap<Integer, List<Move>>>();
		
		// Parcours de toutes les games
		for(Game game: games){
			HashMap<Integer, List<Move>> myMove = new HashMap<Integer, List<Move>>();
			
			// On récupère tous les moves de la games
			List<Move> AllMoves = game.getAlMoves();
			
			// Ajoute le move avec l'id de la game
			myMove.put(game.getId(), AllMoves);
			
			// Parcours des moves
			for(Move move: AllMoves) {
				String Position = move.getFen().getPosition();			
				
				mapFenMoves.put(Position, myMove);
			}
		}

		// Sauvegarde le meilleur Fen pour une position
		//TODO : merde ! clement
		ScoreFromPositionAnalysis sfpa = new ScoreFromPositionAnalysis();
		for(Entry<String, HashMap<Integer, List<Move>>> fenMoves :  mapFenMoves.entrySet()){
			sfpa.getEvolScore(fenMoves.getKey(), fenMoves.getValue());
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
		GlobalStats.getGlobalBestPlayers(pa.getPlayers());
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}


}

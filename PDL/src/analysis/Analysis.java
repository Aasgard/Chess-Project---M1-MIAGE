package analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

		HashMap<String, List<GameAndNextMove>> mapFenMoves = new HashMap<String, List<GameAndNextMove>>();

		// Parcours de toutes les games
		for(Game game: games){
			// On récupère tous les moves de la games
			List<Move> allMoves = game.getAlMoves();
			Iterator<Move> it = allMoves.iterator();
			if(it.hasNext()){

				Move currentMove = it.next();
				// Parcours des moves
				while (currentMove != null) {

					if(it.hasNext()){

						List<GameAndNextMove> gameAndMoveList = mapFenMoves.get(currentMove.getFen().getPosition());
						if(gameAndMoveList == null){
							gameAndMoveList = new ArrayList<GameAndNextMove>();
						}
						Move next = it.next();
						GameAndNextMove ganm = new GameAndNextMove(game.getId(), next);
						gameAndMoveList.add(ganm);

						mapFenMoves.put(currentMove.getFen().getPosition(), gameAndMoveList);
						currentMove = next;
					}else{
						currentMove = null;
					}
				}

			}
		}
		// Sauvegarde le meilleur Fen pour une position
		
		ScoreFromPositionAnalysis sfpa = new ScoreFromPositionAnalysis();
		System.out.println("mapFenMoves.entrySet() " + mapFenMoves.entrySet().size());
		for(Entry<String, List<GameAndNextMove>> fenMoves :  mapFenMoves.entrySet()){
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

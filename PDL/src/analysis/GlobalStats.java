package analysis;

import java.util.List;

import database.ExtractDB;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.Game;
import object.Player;

public class GlobalStats {

	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();

	/*
	 * Get nb_total : players, games and events to save in JSON
	 */
	public static void getGlobalStats(int nb_games){
		int nb_players = ExtractDB.extractNumberPlayers();
		int nb_events = ExtractDB.extractNumberEvents();
		treatmentJSON.saveGlobalStatsToJSON(nb_games, nb_players, nb_events); 
	}

	/*
	 * Create a board which contains 5 BestPlayers
	 * 
	 */
	public static void getGlobalBestPlayers(List<Player> players){
		Player tableaubest_Players[] = new Player[5];
		for(int i = 0; i<5; i++){
			tableaubest_Players[i] = new Player();
		}
		for(Player p: players){	
			int j = 0;
			boolean find = false;
			while(j < tableaubest_Players.length && !find){
				if(tableaubest_Players[j].getNbGameWin() <= p.getNbGameWin()){
					for(int k = tableaubest_Players.length ; k < j+1 ; k--){
						tableaubest_Players[k] = tableaubest_Players[k-1];
					}
					tableaubest_Players[j] = p;
					find = true;
				}
				j++;
			}
		} 
		treatmentJSON.saveGlobalBestPlayersToJSON(tableaubest_Players);
	}
	/*
	 * Create board which contains 5 BestGames
	 */
	public static void getGlobalBestVar(List<Game> games){

		Game tableaubest_Games[] = new Game[5];
		for(int i = 0; i < tableaubest_Games.length ; i++){
			Game ga = new Game();
			tableaubest_Games[i] = ga;
		}

		for(Game g : games){
			System.out.println("le score total de la game : "+g.getScoreTotalVariation());
			int j = 0;
			boolean find = false;
			while(j < tableaubest_Games.length && !find){
				if(tableaubest_Games[j].getScoreTotalVariation() <= g.getScoreTotalVariation()){
					for(int k = tableaubest_Games.length ; k < j+1 ; k--){
						tableaubest_Games[k] = tableaubest_Games[k-1];
					}
					tableaubest_Games[j] = g;
					find = true;
				}
				j++;
			}
		}
		treatmentJSON.saveGlobalBestGamesToJSON(tableaubest_Games);
	}
}

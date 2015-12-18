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
	 * @param nb_games
	 */
	public static void getGlobalStats(int nb_games){
		int nb_players = ExtractDB.extractNumberPlayers();
		int nb_events = ExtractDB.extractNumberEvents();
		treatmentJSON.saveGlobalStatsToJSON(nb_games, nb_players, nb_events); 
	}
	
	/*
	 * Get nb_total : players, games and events to save in a specific JSON
	 * @param nb_games
	 * @param fileName
	 */
	public static void getGlobalStats(int nb_games, String fileName){
		int nb_players = ExtractDB.extractNumberPlayers();
		int nb_events = ExtractDB.extractNumberEvents();
		treatmentJSON.saveGlobalStatsToJSON(nb_games, nb_players, nb_events, fileName); 
	}

	/*
	 * Create a board which contains 5 BestPlayers
	 * @param players
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
					
					for(int k = tableaubest_Players.length-1 ; k > j ; k--){
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
	 * Create a board which contains 5 BestPlayers
	 * in a specific file
	 * @param players
	 * @param fileName
	 */
	public static void getGlobalBestPlayers(List<Player> players, String fileName){
		Player tableaubest_Players[] = new Player[5];
		for(int i = 0; i<5; i++){
			tableaubest_Players[i] = new Player();
		}
		System.out.println("taille de la liste de players : "+players.size());

		for(Player p: players){	
			int j = 0;
			boolean find = false;
			System.out.println(p.getName() + " et son nombre de victoire " + p.getNbGameWin());
			while(j < tableaubest_Players.length && !find){
				if(tableaubest_Players[j].getNbGameWin() <= p.getNbGameWin()){
					System.out.println("test " + tableaubest_Players.length);

					int m = j+1;
					for(int k = tableaubest_Players.length-1 ; k > j ; k--){
						tableaubest_Players[k] = tableaubest_Players[k-1];
					}
					tableaubest_Players[j] = p;
					find = true;
				}
				j++;
			}
		} 
		for(int i = 0; i<5; i++){
			System.out.println("Nom dans le tableau : "+tableaubest_Players[i].getName());
		}
		treatmentJSON.saveGlobalBestPlayersToJSON(tableaubest_Players, fileName);
	}
	
	/*
	 * Create board which contains 5 BestGames
	 * @param games
	 */
	public static void getGlobalBestVar(List<Game> games){

		Game tableaubest_Games[] = new Game[5];
		for(int i = 0; i < tableaubest_Games.length ; i++){
			Game ga = new Game();
			tableaubest_Games[i] = ga;
		}

		for(Game g : games){
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
	
	/*
	 * Create board which contains 5 BestGames
	 * In a specific file (fileName)
	 * @param games
	 * @param fileName
	 */
	public static void getGlobalBestVar(List<Game> games, String fileName){

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
		treatmentJSON.saveGlobalBestGamesToJSON(tableaubest_Games, fileName);
	}
}

package analysis;

import java.io.IOException;

import database.ExtractDB;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.Game;
import object.Player;
import json.ExtractJSON;

public class GlobalStats {

	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	private static ExtractJSON extractJSON = new ExtractJSON();

	public void getGlobalStats(int nb_games){
		int nb_players = ExtractDB.extractNumberPlayers();
		int nb_events = ExtractDB.extractNumberEvents();
		treatmentJSON.saveGlobalStatsToJSON(nb_games, nb_players, nb_events); 
	}

	/*
	 * Create a board which contains 5 BestPlayers
	 * 
	 */
	public void getGlobalBestPlayers() throws IOException{
		Player tableaubest_Players[] = new Player[4];
			int nb_players = ExtractDB.extractNumberPlayers();
			for(int i = 0 ; i < nb_players; i++){
				Player p = extractJSON.getJsonPlayer(i);
				for(int j = 0 ; j < tableaubest_Players.length ; j++){				
					if(tableaubest_Players[j].getNbGameWin()<=p.getNbGameWin()){
						for(int k = tableaubest_Players.length ; k < j; k--){
							tableaubest_Players[k] = tableaubest_Players[k-1];
						}
						tableaubest_Players[i] = p;
						
					}
				}
			} 
		treatmentJSON.saveGlobalBestPlayersToJSON(tableaubest_Players);
	}

	public void getGlobalBestVar(int nb_games) throws IOException{
		Game tableaubest_Games[] = new Game[4];
		for(int i = 0; i< nb_games ; i++){
			Game g = extractJSON.getGame(i);
			for(int j = 0 ; j < tableaubest_Games.length ; j++){ 
				if(tableaubest_Games[j].getScoreTotalVariation() <= g.getScoreTotalVariation()){
					for(int k = tableaubest_Games.length ; k < j ; k--){
						tableaubest_Games[k] = tableaubest_Games[k-1];
					}
					tableaubest_Games[i] = g;
				}
			}
		}
		treatmentJSON.saveGlobalBestGamesToJSON(tableaubest_Games);
	}
}

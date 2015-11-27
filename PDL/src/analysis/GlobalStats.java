package analysis;

import java.io.IOException;

import database.ExtractDB;
import json.ITreatmentJSON;
import json.TreatmentJSON;
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
		try	{
			int nb_players = ExtractDB.extractNumberPlayers();
			int nb_win = 0;
			for(int i = 0 ; i < nb_players; i++){
				Player p = extractJSON.getJsonPlayer(i);
				for(int j = 0 ; j < tableaubest_Players.length ; j++){				
					if(p.getNbGameWin()<=nb_win){
						for(int k = tableaubest_Players.length ; k < j; k--){
							tableaubest_Players[k] = tableaubest_Players[k-1];
						}
						tableaubest_Players[i] = p;
						
					}
				}
			}
		}catch (Exception e) {
			//TODO : Erreur class à faire
			e.printStackTrace();
		}	 
		treatmentJSON.saveGlobalBestPlayersToJSON(tableaubest_Players);
	}

	public void getGlobalBestVar(){

	}
}

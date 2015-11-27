package analysis;

import database.ExtractDB;

public class GlobalStats {

	public void getGlobalStats(ExtractDB extract, int nb_games){
		int nb_players = extract.extractNumberPlayers();
		int nb_events = extract.extractNumberEvents();
		saveGlobalStatToJSON(nb_games, nb_players, nb_events);
	}
	
	public void getGlobalBestPlayers(){
		
	}
	
	public getGlobalBestVar(){
		
	}
}

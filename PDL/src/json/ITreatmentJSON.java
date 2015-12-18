package json;

import java.util.List;
import java.util.Map;

import object.*;

public interface ITreatmentJSON {

	public void saveAllScoreToJSON(Game g, int score_total_variation , List<FEN> scores);
	
	public void saveGames(List<Game> games);
	
	public void savePlayersToJSON(List<Player> players);

	public void saveWinRateOpening(Opening o, int nbWhite, int nbBlack, int exaequo);

	public void saveGlobalStatsToJSON(int nb_games, int nb_players, int nb_events);
	
	public void saveGlobalStatsToJSON(int nb_games, int nb_players, int nb_events, String fileName);
	
	public void saveGlobalBestPlayersToJSON(Player[] players);
	
	public void saveGlobalBestPlayersToJSON(Player[] players, String fileName);
	
	public void saveGlobalBestGamesToJSON(Game[] games);
	
	public void saveGlobalBestGamesToJSON(Game[] games, String fileName);

	public void saveBestFenToJSON(Map<String, GameAndNextMove[]> map_fen_GameAndNextMove_tab);
	
}
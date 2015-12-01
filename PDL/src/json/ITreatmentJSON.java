package json;

import java.util.List;

import object.*;

public interface ITreatmentJSON {

	public void saveAllScoreToJSON(Game g, int score_total_variation , List<FEN> scores);
	
	public void savePlayersToJSON(List<Player> players);

	public void saveWinRateOpening(Opening o, int nbWhite, int nbBlack, int exaequo);

	public void saveGlobalStatsToJSON(int nb_games, int nb_players, int nb_events);
	
	public void saveGlobalBestPlayersToJSON(Player[] players);
	
	public void saveGlobalBestGamesToJSON(Game[] games);

	public void saveBestFenToJSON(String position, GameAndNextMove[] tableaubest_GameAndNextMove);
	
	
}
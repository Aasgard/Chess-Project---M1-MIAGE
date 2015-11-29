package json;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import object.*;

public interface ITreatmentJSON {

	public void saveAllScoreToJSON(Game g, int score_total_variation , List<FEN> scores);
	
	public void saveBestFenToJSON(String FEN, FEN bestPosition);
	
	public void saveErrorToJSON(HashMap<Player, List<ErrorPlayer>> playerErrors);

	public void saveWinRateOpening(Opening o, int nbWhite, int nbBlack, int exaequo)throws IOException;

	public void saveGlobalStatsToJSON(int nb_games, int nb_players, int nb_events);
	
	public void saveGlobalBestPlayersToJSON(Player[] players);
	
	public void saveGlobalBestGamesToJSON(Game[] games);
	
	
}
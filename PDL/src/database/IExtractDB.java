package database;

import java.util.HashMap;
import java.util.List;

import object.*;

public interface IExtractDB {
	
	/**
	 * Extract all move FROM a game ID (from DB)
	 * @return
	 */
	List<Move> extractMovesByGame(int idGame);
	
	/**
	 * Extract all games from DB
	 * @return
	 */
	List<Game> extractGames();
	
	
}

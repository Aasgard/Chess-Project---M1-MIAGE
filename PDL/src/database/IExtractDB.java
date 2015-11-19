package database;

import java.util.HashMap;
import java.util.List;

import object.*;

public interface IExtractDB {
	
	/**
	 * Extract all games from DB
	 * @return
	 */
	List<Game> extractGames();
	
	/**
	 * Extract games ordered by opening
	 * @return 
	 */
	HashMap<Opening, Game> extractGamesByOpening();
	
	/**
	 * extract next move after each position
	 * @return
	 */
	HashMap<String, List<Move>> extractGameAndMoveByPosition();
	
}

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
	
	/**
	 * Extract games ordered by opening 
	 * @return 
	 */
	HashMap<Opening, List<Game>> extractGamesByOpening();
	
	/**
	 * extract next move after each position
	 * @return
	 */
	HashMap<String, List<Move>> extractGameAndMoveByPosition();
	
}

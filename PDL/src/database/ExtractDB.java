package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import object.Game;
import object.Move;
import object.Opening;
import tools.MySQL;

public class ExtractDB implements IExtractDB{

	@Override
	public List<Move> extractMovesByGame(int idGame){
		List<Move> alMoves = new ArrayList<Move>();
		String query = "SELECT Move.id, Move.halfMove, FEN.id, FEN.log FROM Move, FEN WHERE Move.idFEN = FEN.id AND Move.idGame = " + idGame;
		ResultSet rs = MySQL.getInstance().query(query);
		
		try {
			while(rs.next()){
				Move currentMove = Move(rs.getInt(1),rs.getInt(2),new FEN(rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alMoves;
	}

	@Override
	public List<Game> extractGames() {
		List<Game> alGames = new ArrayList<Game>();
		List<Move> alMoves = new ArrayList<Move>();
		
		try {
			while(MySQL.getInstance().query("SELECT Game.id, Game.whiteId, j1.name,Game.blackId, j2.name, date, Opening.id, Opening.opening, Opening.variation, Opening.moves, Opening.nbMoves, Game.result,Event.id, Event.name, Event.city FROM Player j1, Player j2, Game, Opening, Event WHERE Opening.id = Game.ecoId AND Game.eventId = Event.id AND j1.id = Game.whiteId AND j2.id = Game.blackId").next()){
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alGames;
	}

	@Override
	public HashMap<Opening, List<Game>> extractGamesByOpening() {
		// TODO Auto-generated method s tub
		return null;
	}

	@Override
	public HashMap<String, List<Move>> extractGameAndMoveByPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

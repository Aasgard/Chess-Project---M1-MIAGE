package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import object.Event;
import object.FEN;
import object.Game;
import object.Move;
import object.Opening;
import object.Player;
import tools.MySQL;

public class ExtractDB{

	public static List<Move> extractMovesByGame(int idGame){
		List<Move> alMoves = new ArrayList<Move>();
		String query = "SELECT Move.id, Move.halfMove, FEN.id, FEN.log FROM Move, FEN WHERE Move.idFEN = FEN.id AND Move.idGame = " + idGame;
		
		try {
			ResultSet rs = MySQL.getInstance().query(query);
			while(rs.next()){
				Move currentMove = new Move(rs.getInt(1),rs.getInt(2),new FEN(rs.getString(3), rs.getString(4)));
				alMoves.add(currentMove);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alMoves;
	}


	public static List<Game> extractGames() {
		List<Game> alGames = new ArrayList<Game>();
		String query = "SELECT Game.id, Game.whiteId, j1.name, Game.whiteElo, Game.blackId, j2.name, Game.blackElo, date, Opening.id, Opening.opening, Opening.variation, Opening.moves, Opening.nbMoves, Game.result,Event.id, Event.name, Event.city FROM Player j1, Player j2, Game, Opening, Event WHERE Opening.id = Game.ecoId AND Game.eventId = Event.id AND j1.id = Game.whiteId AND j2.id = Game.blackId";
		
		try {
			ResultSet rs = MySQL.getInstance().query(query);
			while(rs.next()){
				Game currentGame = new Game(rs.getInt(1), ExtractDB.extractMovesByGame(rs.getInt(1)), new Player(rs.getInt(2), rs.getString(4)), new Player(rs.getInt(5), rs.getString(6)), new Opening(rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)), new Event(rs.getInt(15), rs.getString(16), rs.getString(17)), rs.getInt(14), rs.getString(8), rs.getInt(4), rs.getInt(7));
				alGames.add(currentGame);
				System.out.println(currentGame.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alGames;
	}


	public HashMap<Opening, List<Game>> extractGamesByOpening() {
		// TODO Auto-generated method s tub
		return null;
	}


	public HashMap<String, List<Move>> extractGameAndMoveByPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

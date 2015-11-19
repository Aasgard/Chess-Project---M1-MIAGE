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

	private ArrayList<Game> getGamesByOpening(int idOpening){
		ArrayList<Game> res = new ArrayList<Game>();
		String query = "SELECT Game.id FROM Game WHERE ecoId = " + idOpening;
		try {
			ResultSet rs = MySQL.getInstance().query(query);
			while(rs.next()){
				//res.add(new Game(rs.getInt(1)));
			}
		} catch (SQLException e) { e.printStackTrace(); }

		return res;
	}

	@Override
	public List<Game> extractGames() {
		
		List<Move>alMoves = new ArrayList<Move>();
		//try {
			// TODO revoir la fonction pour récupérer tous les games (methode déplacée de la classe Game)
			//ResultSet rs = MySQL.getInstance().query("SELECT Move.id, FEN.log, Move.halfMove FROM Move, FEN WHERE FEN.id = Move.idFEN AND Move.idGame = " + ident + " AND FEN.log IS NOT NULL;");
			//while(rs.next()){
//			Move currentMove = new Move(rs.getInt(1), rs.getString(2), rs.getInt(3));
//			alMoves.add(currentMove);
//		}
//	} catch (SQLException e) { e.printStackTrace(); }
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Opening, Game> extractGamesByOpening() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, List<Move>> extractGameAndMoveByPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

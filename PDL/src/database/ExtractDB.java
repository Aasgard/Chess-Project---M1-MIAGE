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
				res.add(new Game(rs.getInt(1)));
			}
		} catch (SQLException e) { e.printStackTrace(); }

		return res;
	}

	@Override
	public List<Game> extractGames() {
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

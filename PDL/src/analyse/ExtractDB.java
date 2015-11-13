package analyse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.MySQL;
import classes.Game;

public class ExtractDB {

	public static ArrayList<Game> getGamesByOpening(int idOpening){
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
	
}

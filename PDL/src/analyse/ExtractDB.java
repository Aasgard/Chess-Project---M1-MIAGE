package analyse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.MySQL;
import classes.Game;

public class ExtractDB {

	public static ArrayList<Game> getGamesByOpening(){
		ArrayList<Game> res = new ArrayList<Game>();
		String query = "SELECT Game.id FROM Game WHERE ";
		try {
			ResultSet rs = MySQL.getInstance().query(query);
		} catch (SQLException e) { e.printStackTrace(); }
		
		
		return res;
	}
	
}

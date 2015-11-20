package analyse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.MySQL;
import classes.FEN;
import classes.Game;
import classes.Opening;

public class ExtractDB {
	
	public static ArrayList<Opening> getAllOpenings(){
		ArrayList<Opening> listOpenings = new ArrayList<Opening>();
		String query = "SELECT * FROM Opening";
		try {
			ResultSet rs = MySQL.getInstance().query(query);
			while(rs.next()){
				listOpenings.add(new Opening(rs.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOpenings;
	}

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
	
	public static ArrayList<FEN> getAllFEN(){
		ArrayList<FEN> listFEN = new ArrayList<FEN>();
		String query = "SELECT FEN.id,FEN.log FROM FEN";
		try {
			ResultSet rs = MySQL.getInstance().query(query);
			while(rs.next()){
				listFEN.add(new FEN(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listFEN;
	}
	
}

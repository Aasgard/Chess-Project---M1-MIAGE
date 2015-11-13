package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import bdd.MySQL;

public class Opening {

	private int id;
	private String name;
	private String variation;
	private String moves;
	private int nbMoves;
	
	public Opening(int id) {
		String query = "SELECT * FROM Opening WHERE Opening.id = " + id;
		try {
			ResultSet rs = MySQL.getInstance().query(query);
			while(rs.next()){
				this.id = rs.getInt(1);
				this.name = rs.getString(3);
				this.variation = rs.getString(4);
				this.moves = rs.getString(5);
				this.nbMoves = rs.getInt(6);
			}
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public String toString(){
		return "L'Opening " + this.name+" - " + this.variation + " [Numéro " + this.id + "] comporte " + this.nbMoves + " HalfMoves. [ " + this.moves + " ]";
	}
	
	
	
	
	
}

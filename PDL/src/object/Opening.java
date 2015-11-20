package object;

import java.sql.ResultSet;
import java.sql.SQLException;

import tools.MySQL;

public class Opening {

	private int id;
	private String name;
	private String variation;
	private String moves;
	private int nbMoves;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVariation() {
		return variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}

	public String getMoves() {
		return moves;
	}

	public void setMoves(String moves) {
		this.moves = moves;
	}

	public int getNbMoves() {
		return nbMoves;
	}

	public void setNbMoves(int nbMoves) {
		this.nbMoves = nbMoves;
	}

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

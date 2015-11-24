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
	
	public String toString(){
		return "L'Opening " + this.name+" - " + this.variation + " [Numéro " + this.id + "] comporte " + this.nbMoves + " HalfMoves. [ " + this.moves + " ]";
	}
	
	
	
	
	
}

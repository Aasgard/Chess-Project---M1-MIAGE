package object;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.MySQL;

public class Game {

	private int id;
	private ArrayList<Move> alMoves;
	
	public Game(int ident){
		this.id = ident;
		alMoves = new ArrayList<Move>();
		try {
			ResultSet rs = MySQL.getInstance().query("SELECT Move.id, FEN.log, Move.halfMove FROM Move, FEN WHERE FEN.id = Move.idFEN AND Move.idGame = " + ident + " AND FEN.log IS NOT NULL;");
			while(rs.next()){
				Move currentMove = new Move(rs.getInt(1), rs.getString(2), rs.getInt(3));
				alMoves.add(currentMove);
			}
		} catch (SQLException e) { e.printStackTrace(); }
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Move> getAlMoves() {
		return alMoves;
	}

	public void setAlMoves(ArrayList<Move> alMoves) {
		this.alMoves = alMoves;
	}
	
	public int getNbMoves(){
		return this.alMoves.size();
	}
	
	public void printGame(){
		System.out.println("Numéro : " + this.id);
		System.out.println("Moves : " + this.alMoves);
		System.out.println("Nombre de Moves : " + this.alMoves.size());
	}
	
}

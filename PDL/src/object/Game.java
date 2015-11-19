package object;

import java.util.List;

public class Game {

	private int id;
	private List<Move> alMoves;
	private String log;
	
	public Game(int id, List<Move> moves, String log){
		this.id = id;
		this.alMoves = moves;
		this.log = log;		
	}
	
	// TODO à supprimer
	public Game(){}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Move> getAlMoves() {
		return alMoves;
	}

	public void setAlMoves(List<Move> alMoves) {
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

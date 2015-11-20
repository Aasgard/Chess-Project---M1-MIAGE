package object;

import java.util.List;

public class Game {

	private int id;
	private List<Move> alMoves;
	
	public Game(int id, List<Move> moves){
		this.id = id;
		this.alMoves = moves;	
	}
	
	// TODO à supprimer
	public Game(){}

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

package tools;

import java.util.ArrayList;
import java.util.List;

import object.FEN;

public class Blunder {

	private int idGame;
	private int nbErrors;
	private List<FEN> positionsErrors;
	
	public Blunder(int idGame, int nbErrors) {
		this.idGame = idGame;
		this.nbErrors = nbErrors;
		this.positionsErrors = new ArrayList<FEN>();
	}
	
	public int getIdGame() {
		return idGame;
	}
	
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	
	public int getNbErrors() {
		return nbErrors;
	}
	
	public void setNbErrors(int nbErrors) {
		this.nbErrors = nbErrors;
	}
	
	public List<FEN> getPositionsErrors() {
		return positionsErrors;
	}
	
	public void setPositionsErrors(List<FEN> positionsErrors) {
		this.positionsErrors = positionsErrors;
	}
	
	public void addPositionError(FEN fen) {
		this.positionsErrors.add(fen);
	}
	
}

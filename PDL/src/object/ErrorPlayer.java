package object;

import java.util.ArrayList;
import java.util.List;

public class ErrorPlayer {

	private int idGame;
	private int nb_of_error;
	private List<String> error_fen;
	
	public ErrorPlayer(int idGame, int nb_of_error, List<String> error_fen){
		this.setIdGame(idGame);
		this.nb_of_error = nb_of_error;
		this.error_fen = error_fen;
	}
	
	public ErrorPlayer(int idGame, int nb_of_error) {
		this.idGame = idGame;
		this.nb_of_error = nb_of_error;
		this.error_fen = new ArrayList<String>();
	}
	
	public int getIdgame() {
		return idGame;
	}
	
	public void setIdgame(int idgame) {
		this.idGame = idgame;
	}
	
	public int getNb_of_error() {
		return nb_of_error;
	}
	
	public void setNb_of_error(int nb_of_error) {
		this.nb_of_error = nb_of_error;
	}
	
	public List<String> getError_fen() {
		return error_fen;
	}
	
	public void setError_fen(List<String> error_fen) {
		this.error_fen = error_fen;
	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	
	public void addNbError() {
		this.nb_of_error++;
	}
	
	public void addErrorFen(String fen) {
		this.error_fen.add(fen);
	}
	
}

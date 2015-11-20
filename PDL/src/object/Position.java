package object;

public class Position {

	private int score;
	private String fen;
	
	public Position(int score, String fen){
		this.score = score;
		this.fen= fen;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getFen() {
		return fen;
	}
	
	public void setFen(String fen) {
		this.fen = fen;
	}
	
	
}

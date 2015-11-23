package object;

public class Move {

	private int num;
	private int halfMove;
	private FEN fen;
	
	public Move(int n, String log, int hm, FEN fen){
		this.num = n;
		this.halfMove = hm;
		this.fen = fen;
	}

	public FEN getFen() {
		return fen;
	}

	public void setFen(FEN fen) {
		this.fen = fen;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public int getHalfMove() {
		return halfMove;
	}

	public void setHalfMove(int hm) {
		this.halfMove = hm;
	}
		
}
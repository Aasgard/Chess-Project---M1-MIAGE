package object;

public class GameAndNextMove {

	private Move nextMove;
	private int gameID;
	
	public GameAndNextMove( int gameID, Move nextMove) {
		super();
		this.nextMove = nextMove;
		this.gameID = gameID;
	}
	
	public GameAndNextMove(){
		nextMove = new Move();
		gameID =-1;
	}
	
	public Move getMove() {
		return nextMove;
	}
	public void setMove(Move move) {
		this.nextMove = move;
	}
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
}

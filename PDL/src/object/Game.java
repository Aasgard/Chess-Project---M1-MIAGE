package object;

import java.util.List;

public class Game {

	private int id;
	private List<Move> alMoves;
	private Player whitePlayer;
	private Player blackPlayer;
	private int whiteElo;
	private int blackElo;
	private Opening opening;
	private Event event;
	private int result;
	private String date;
	private String PGN;
	private int score_total_variation;
	
	public Game(){
		this.score_total_variation = 0;
	}
	
	public Game(int id, List<Move> alMoves, Player whitePlayer, Player blackPlayer, Opening opening, Event event,int result, String date, int whiteElo, int blackElo, String PGN, int score_total_variation) {
		this.id = id;
		this.alMoves = alMoves;
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.opening = opening;
		this.event = event;
		this.result = result;
		this.date = date;
		this.blackElo = blackElo;
		this.whiteElo = whiteElo;
		this.PGN = PGN;
		this.score_total_variation = score_total_variation;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Player getWhitePlayer() {
		return whitePlayer;
	}

	public void setWhitePlayer(Player whitePlayer) {
		this.whitePlayer = whitePlayer;
	}

	public Player getBlackPlayer() {
		return blackPlayer;
	}

	public void setBlackPlayer(Player blackPlayer) {
		this.blackPlayer = blackPlayer;
	}

	public int getWhiteElo() {
		return whiteElo;
	}

	public void setWhiteElo(int whiteElo) {
		this.whiteElo = whiteElo;
	}

	public int getBlackElo() {
		return blackElo;
	}

	public void setBlackElo(int blackElo) {
		this.blackElo = blackElo;
	}

	
	public Opening getOpening() {
		return opening;
	}

	public void setOpening(Opening opening) {
		this.opening = opening;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	
	public String getPGN() {
		return PGN;
	}

	public void setPGN(String PGN) {
		this.PGN = PGN;
	}

	public int getScoreTotalVariation() {
		return score_total_variation;
	}

	public void setScoreTotalVariation(int score_total_variation) {
		this.score_total_variation = score_total_variation;
	}


}

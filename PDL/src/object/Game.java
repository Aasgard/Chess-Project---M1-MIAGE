package object;

import java.util.List;

public class Game {

	private int id;
	private List<Move> alMoves;
	private Player whitePlayer;
	private Player blackPlayer;
	private Opening opening;
	private Event event;
	private int result;
	private String date;

	public Game(int id, List<Move> alMoves, Player whitePlayer, Player blackPlayer, Opening opening, Event event,int result, String date) {
		super();
		this.id = id;
		this.alMoves = alMoves;
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.opening = opening;
		this.event = event;
		this.result = result;
		this.date = date;
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
	
}

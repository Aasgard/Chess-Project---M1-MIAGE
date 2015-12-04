package object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Player {

	private int id;
	private String name;
	private List<ErrorPlayer> errors;
	private int nbGamePlayed;
	private int nbGameWin;
	private Map<String, Integer> elos;
	
	
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.nbGamePlayed = 0;
		this.nbGameWin = 0;
		this.errors = new ArrayList<ErrorPlayer>();
		this.elos = new TreeMap<String, Integer>(new DateCompare());
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNb_game_played() {
		return nbGamePlayed;
	}
	public void setNb_game_played(int nb_game_played) {
		this.nbGamePlayed = nb_game_played;
	}
	
	public Player() {
	}
	
	public Player(int id){
		this.id = id;
	}

	public int getNbGameWin() {
		return nbGameWin;
	}

	public void setNbGameWin(int nbGameWin) {
		this.nbGameWin = nbGameWin;
	}

	public List<ErrorPlayer> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorPlayer> errors) {
		this.errors = errors;
	}
	
	public void addError(ErrorPlayer error) {
		this.errors.add(error);
	}
	
	public void addNbGameWin() {
		this.nbGameWin++;
	}
	
	public void addNbGamePlayed() {
		this.nbGamePlayed++;
	}
	
	public void addElo(String date, int elo) {
		this.elos.put(date, elo);
	}
	
	public Map<String, Integer> getElos() {
		return this.elos;
	}
}

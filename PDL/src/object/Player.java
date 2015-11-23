package object;

import java.util.List;

public class Player {

	private int id;
	private String name;
	private int nb_game_played;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNb_game_played() {
		return nb_game_played;
	}
	public void setNb_game_played(int nb_game_played) {
		this.nb_game_played = nb_game_played;
	}
	
	public Player() {
	}
}

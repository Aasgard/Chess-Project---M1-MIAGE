package object;

public class Player {

	private int id;
	private String name;
	private int nbGamePlayed;
	
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.nbGamePlayed = 0;
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
}

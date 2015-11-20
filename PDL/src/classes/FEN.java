package classes;

public class FEN {

	private String id;
	private String log;
	private String straightFEN;
	
	public FEN(String id, String log) {
		super();
		this.id = id;
		this.log = log;
		this.straightFEN = this.id.split(" ")[0];
	}

	public String getStraightFEN() {
		return straightFEN;
	}

	public void setStraightFEN(String straightFEN) {
		this.straightFEN = straightFEN;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
	
}

package object;

public class FEN {
	private String Position;
	private int Score;
	private String RawFEN;
	private String Log;
	
	
	public FEN(String rawFEN) {
		super();
		this.RawFEN = rawFEN;
		this.Position = this.RawFEN.split(" ")[0];
	}
	
	public String getPosition() {
		return Position;
	}
	
	public void setPosition(String position) {
		Position = position;
	}
	
	public int getScore() {
		return Score;
	}
	
	public void setScore(int score) {
		Score = score;
	}
	
	public String getRawFEN() {
		return RawFEN;
	}
	
	public void setRawFEN(String rawFEN) {
		RawFEN = rawFEN;
	}
	
	public String getLog() {
		return Log;
	}
	
	public void setLog(String log) {
		Log = log;
	}
	
	
	public int getHigherDepthScore(){
		String[] splittedLogs = this.Log.split("\\. ");
		String chaineVoulue = splittedLogs[splittedLogs.length - 2];
		int scoreVoulu = Integer.parseInt(chaineVoulue.split(" ")[9]);
		return scoreVoulu;
	}
	
}

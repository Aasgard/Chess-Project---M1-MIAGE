package object;

public class FEN {
	private String Position;
	private int Score;
	private String RawFEN;
	private String Log;
	
	public FEN(String rawFEN, String log) {
		this.Log = log;
		this.RawFEN = rawFEN;
		this.Position = this.RawFEN.split(" ")[0];
		this.Score = getHigherDepthScore();
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
	
	private int getHigherDepthScore(){
		int scoreVoulu = 0;
		try{
			String[] splittedLogs = this.Log.split(". ");
			String chaineVoulue = splittedLogs[splittedLogs.length - 2];
			System.out.println("la chaine voulue : "+chaineVoulue);
			scoreVoulu = Integer.parseInt(chaineVoulue.split(" ")[9]);
		}catch(Exception e){ System.out.println( "Exception du parse");}
		
		return scoreVoulu;
	}
	
	public String toString(){
		return "[ FEN : " +this.RawFEN + " - " + this.Log + " ]";
	}
	
}

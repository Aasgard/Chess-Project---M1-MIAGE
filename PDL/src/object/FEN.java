package object;

public class FEN {
	private String position;
	private int score;
	private String rawFEN;
	private String log;
	
	public FEN(){
		this.score = Integer.MIN_VALUE;
	}
	
	
	public FEN(String rawFEN, String log) {
		this.log = log;
		this.rawFEN = rawFEN;
		this.position = this.rawFEN.split(" ")[0];
		this.score = this.getHigherDepthScore();
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		position = position;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		score = score;
	}
	
	public String getRawFEN() {
		return rawFEN;
	}
	
	public void setRawFEN(String rawFEN) {
		rawFEN = rawFEN;
	}
	
	public String getLog() {
		return log;
	}
	
	public void setLog(String log) {
		log = log;
	}
	
	private int getHigherDepthScore(){
		int scoreVoulu = 0;
		try{
			String[] splittedLogs = this.log.split("\\. ");
			String higherdepthlog = splittedLogs[splittedLogs.length - 2];
			scoreVoulu = Integer.parseInt(higherdepthlog.split(" ")[9]);
		}catch(Exception e){}
		
		return scoreVoulu;
	}
	
	public String toString(){
		return "[ FEN : " +this.rawFEN + " - " + this.log + " ]";
	}
	
}

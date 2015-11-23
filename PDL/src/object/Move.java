package object;

public class Move {

	private int num;
	private String log;
	private int halfMove;
	private boolean isMate;
	
	public Move(int n, String log, int hm){
		this.num = n;
		this.log = log;
		this.halfMove = hm;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
	public int getHalfMove() {
		return halfMove;
	}

	public void setHalfMove(int hm) {
		this.halfMove = hm;
	}
	
	public int getHigherDepthScore(){
		String[] splittedLogs = this.log.split("\\. ");
		String chaineVoulue = splittedLogs[splittedLogs.length - 2];
		int scoreVoulu = Integer.parseInt(chaineVoulue.split(" ")[9]);
		return scoreVoulu;
	}
	
	public boolean isMate() {
		
		try {
			String[] splittedLogs = this.log.split("\\. ");
			String chaineVoulue = splittedLogs[splittedLogs.length - 2];
			String mate = chaineVoulue.split(" ")[8];
			
			if(mate == "mate") {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
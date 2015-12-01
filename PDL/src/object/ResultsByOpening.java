package object;

import java.util.ArrayList;
import java.util.List;

public class ResultsByOpening {
	private List<Integer> results;
	private Opening opening;
	
	
	
	public ResultsByOpening(Opening opening) {
		super();
		this.opening = opening;
		this.results = new ArrayList<Integer>();
	}
	
	
	public List<Integer> getResults() {
		return results;
	}
	public void setResults(List<Integer> results) {
		this.results = results;
	}
	
	public void addResult(int result){
		this.results.add(result);
	}
	
	public Opening getOpening() {
		return opening;
	}
	public void setOpening(Opening opening) {
		this.opening = opening;
	}
}

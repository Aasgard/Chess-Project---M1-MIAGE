package analysis;

import java.util.Iterator;
import java.util.List;

import database.ExtractDB;
import object.*;

public class MatAnalysis {
	
	public void checkBlunderMat(Game game) {
		List<Move> moves = game.getAlMoves();
		Iterator<Move> it = moves.iterator();
		String log;
		
		while(it.hasNext()) {
			log = it.next().getLog();
			
			
		}
	}

}

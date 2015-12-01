package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import analysis.ScoreAnalysis;
import object.FEN;
import object.Game;
import object.Move;

public class TestScoreAnalysis {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void analyzeScore(){
		// Resultats a comparer
		int expected = 120;
		
		Game g = new Game();
		List<Move> moves =  new ArrayList<Move>();
		
		// Définition du move 1
		FEN fenM1 = new FEN(null, null);
		fenM1.setScore(100);
		Move m1 = new Move(1, 0, fenM1);
		moves.add(m1);
		
		// Définition du move 2
		FEN fenM2 = new FEN(null, null);
		fenM2.setScore(-20);
		Move m2 = new Move(2, 0, fenM2);
		moves.add(m2);
		
		g.setAlMoves(moves);
		
		// Fonction a tester
		ScoreAnalysis.analyzeScore(g);
		
		int actual = g.getScoreTotalVariation();
		
		assertEquals(expected, actual);
	}
}

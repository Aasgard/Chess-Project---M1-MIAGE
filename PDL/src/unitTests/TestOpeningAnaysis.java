package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import analysis.OpeningAnalysis;
import junit.framework.TestCase;
import object.Opening;

public class TestOpeningAnaysis{	
	
	@Test
	public void testGetWinRateOpening(){
		
		// Résultats attendu
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(3);
		expected.add(1);
		expected.add(1);
		
		// Initialisation
		Opening o = new Opening(1, "Ruy Lopez", "none", "", 4);
		List<Integer> stats = new ArrayList<Integer>();
		
		// Ajout de resultats de partie
		stats.add(0);
		stats.add(0);
		stats.add(2);
		stats.add(0);
		stats.add(1);
		
		// Ma fonction a tester
		List<Integer> actual = OpeningAnalysis.getWinRateOpening(stats);
		
		assertEquals(expected, actual);
	}

	
}

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
	public void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testGetWinRateOpening(){
		
		// Résultats attendu
		HashMap<Opening, List<Integer>> expected = new HashMap<Opening, List<Integer>>();
		Opening openingExpected = null;
		List<Integer> stats = new ArrayList<Integer>();
		expected.put(openingExpected, stats);
		
		// Initialisation
		Opening o = new Opening(1, "Ruy Lopez", "none", "", 4);
		List<Integer> values = new ArrayList<Integer>();
		
		// Ajout de resultats de partie
		values.add(0);
		values.add(0);
		values.add(2);
		values.add(0);
		values.add(1);
		
		// Ma fonction a tester
		OpeningAnalysis.getWinRateOpening(o, values);
		
		
	}

	
}

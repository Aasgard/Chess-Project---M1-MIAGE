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
	public void analyzeScore1(){
		
		// Resultats a comparer
		int expected = 120;
		
		Game g = new Game();
		List<Move> moves =  new ArrayList<Move>();
		
		// Définition du move 1
		// Le Fen et log ne sont pas tester
		FEN fenM1 = new FEN("1B1b4/p6p/4p1p1/k2p1p2/Pp1P4/1P1bPPPP/3N1K2/8 b - - 2 37", "info depth 1 seldepth 1 multipv 1 score cp 16 nodes 33 nps 3300 time 10 pv a7a6. info depth 2 seldepth 2 multipv 1 score cp 44 nodes 88 nps 8800 time 10 pv a7a6 f3f4. info depth 3 seldepth 4 multipv 1 score cp 21 nodes 229 nps 20818 time 11 pv a7a6 h3h4 g6g5. info depth 4 seldepth 6 multipv 1 score cp 32 nodes 448 nps 40727 time 11 pv a7a6 g3g4 f5g4 h3g4 d8h4 f2g2. info depth 5 seldepth 6 multipv 1 score cp 14 nodes 1350 nps 122727 time 11 pv a5b6 b8d6 a7a5 d6e5 g6g5. info depth 6 seldepth 6 multipv 1 score cp 21 nodes 1649 nps 109933 time 15 pv a5b6 b8d6 a7a5 d6e5 h7h6 h3h4. info depth 7 seldepth 7 multipv 1 score cp 19 nodes 2012 nps 125750 time 16 pv a5b6 b8d6 a7a5 d6e5 h7h6 h3h4 g6g5. info depth 8 seldepth 9 multipv 1 score cp 49 nodes 4838 nps 284588 time 17 pv a5b6 b8e5 a7a5 e5d6 b6c6 d6e5 d8e7 h3h4. info depth 9 seldepth 10 multipv 1 score cp 48 nodes 7624 nps 245935 time 31 pv a5b6 f3f4 a7a5 b8d6 b6c6 d6e5 d3c2 f2f3 c2d1 f3f2. info depth 10 seldepth 12 multipv 1 score cp 53 nodes 13890 nps 277800 time 50 pv a5b6 g3g4 a7a5 f2g3 f5g4 h3g4 b6c6 b8f4 d8e7 f4e5. info depth 11 seldepth 12 multipv 1 score cp 48 nodes 19964 nps 322000 time 62 pv a5b6 g3g4 a7a5 f2g3 f5g4 h3g4 b6c6 b8e5 d3c2 g3f4 c2d1 f4g3. info depth 12 seldepth 18 multipv 1 score cp 29 nodes 43537 nps 308773 time 141 pv a5b6 b8f4 a7a5 h3h4 b6c6 f4g5 d8c7 g5f4 c7b6 f4g5 h7h5 g5f4 b6d8 f4g5 d8c7 g5f4 c7f4 g3f4. info depth 13 seldepth 19 multipv 1 score cp 30 nodes 57003 nps 306467 time 186 pv a5b6 h3h4 a7a5 b8f4 b6c6 f4g5 d8c7 g5f4 c7d6 f4g5 c6d7 g5f4 d6f8 f4g5 d3c2 g5f4 f8e7 f4e5. info depth 14 seldepth 22 multipv 1 score cp 33 nodes 64533 nps 273444 time 236 pv a5b6 h3h4 a7a5 b8f4 b6c6 f4g5 d8c7 g5f4 c7d6 f4g5 c6d7 g5f4 d6f8 f4e5 f8e7 e5f4 e7d6. info depth 15 seldepth 23 multipv 1 score cp 38 nodes 87105 nps 276523 time 315 pv a5b6 h3h4 a7a5 b8f4 b6c6 f4g5 d8c7 g5f4 c7d6 f4d6 c6d6 g3g4 e6e5 g4f5 d3f5 e3e4 f5e6 f2e3 e5d4 e3d4 d5e4 d2e4 d6c6. info depth 16 seldepth 27 multipv 1 score cp 42 nodes 106239 nps 261029 time 407 pv a5b6 h3h4 a7a5 b8f4 b6c6 f4g5 d8c7 g5f4 c7d6 f4d6 c6d6 g3g4 f5g4 f3g4 h7h6 f2g3 g6g5 h4g5 h6g5 d2f3 d3c2. info depth 17 seldepth 27 multipv 1 score cp 36 nodes 125972 nps 248465 time 507 pv a5b6 h3h4 a7a5 b8f4 b6c6 f4g5 d8c7 g5f4 c7d6 f4d6 c6d6 f3f4 h7h6 f2f3 d3c2 f3e2 d6c6 e2f2. info depth 18 seldepth 27 multipv 1 score cp 59 nodes 595869 nps 251846 time 2366 pv a5b6 h3h4 g6g5 h4g5 d8g5 b8d6 a7a5 f3f4 g5f6 d2f3 d3c2 f3d2 b6c6 d6e5 f6e7 f2e2 h7h6 e2f3 h6h5 f3e2 e7d8 e2f3 c2d1 f3f2. info depth 19 seldepth 28 multipv 1 score cp 53 upperbound nodes 818544 nps 252247 time 3245 pv a5b6 b8e5. info depth 19 seldepth 28 multipv 1 score cp 52 nodes 875371 nps 252705 time 3464 pv a5b6 b8e5 a7a5 e5g7 d8e7 f3f4 g6g5 f4g5 e7g5 g7e5 b6c6 f2f3 h7h5 f3f2 g5e7 h3h4 e7f8 f2f3 d3c2 f3e2. info depth 20 seldepth 28 multipv 1 score cp 51 nodes 964443 nps 252736 time 3816 pv a5b6 b8e5 a7a5 e5g7 d8e7 f3f4 g6g5 f4g5 e7g5 g7e5 b6c6 f2f3 g5e7 f3f4 d3c2 e5g7 c6d7 g7e5 c2d1 e5b8 d1c2. bestmove a5b6 ponder b8e5. ");
		fenM1.setScore(100);
		Move m1 = new Move(1, 0, fenM1);
		moves.add(m1);
		
		// Définition du move 2
		FEN fenM2 = new FEN("1B4k1/5p2/pp4p1/6P1/1K6/5r2/PP6/8 w - - 0 52", "info depth 1 seldepth 1 multipv 1 score cp -233 nodes 40 nps 20000 time 2 pv b8c7. info depth 2 seldepth 3 multipv 1 score cp -228 nodes 140 nps 70000 time 2 pv b8e5 b6b5. info depth 3 seldepth 4 multipv 1 score cp -263 nodes 470 nps 235000 time 2 pv b8c7 f3f2 b2b3. info depth 4 seldepth 4 multipv 1 score cp -271 nodes 773 nps 386500 time 2 pv b8c7 f3f2 b2b3 b6b5. info depth 5 seldepth 6 multipv 1 score cp -274 nodes 1536 nps 512000 time 3 pv b8c7 f3f5 a2a4 f5g5 c7b6. info depth 6 seldepth 7 multipv 1 score cp -280 nodes 2701 nps 450166 time 6 pv b8c7 f3f2 b2b3 f2f5 a2a4 a6a5 b4a3 f5g5. info depth 7 seldepth 9 multipv 1 score cp -290 nodes 6201 nps 689000 time 9 pv b8c7 f3f5 c7d8 f5f2 b2b3 b6b5 a2a4 f2f4 b4a5 b5a4. info depth 8 seldepth 9 multipv 1 score cp -301 nodes 10644 nps 626117 time 17 pv b8e5 f3f2 a2a3 f2g2 e5f6 g8f8 b2b3 g2g4 b4c3. info depth 9 seldepth 15 multipv 1 score cp -281 nodes 21949 nps 731633 time 30 pv b8e5 a6a5 b4a4 f3f2 a2a3 f2g2 e5f6 g2d2 b2b3 d2g2. info depth 10 seldepth 15 multipv 1 score cp -284 nodes 38239 nps 721490 time 53 pv b8e5 f3f5 e5f6 g8f8 b2b3 f5f4 b4c3 f4g4 a2a4 f8e8 f6d4. info depth 11 seldepth 18 multipv 1 score cp -299 nodes 73664 nps 751673 time 98 pv b8e5 f3f5 e5f6 f5f4 b4c3 f4g4 b2b3 b6b5 f6e7 g4g2 a2a4 b5a4 b3a4 g2g4. info depth 12 seldepth 19 multipv 1 score cp -296 nodes 194723 nps 740391 time 263 pv b8e5 f3f5 e5f6 g8f8 b4c3 f8e8 b2b3 e8d7 c3d4 d7e6 d4e4 f5c5 f6d4. info depth 13 seldepth 21 multipv 1 score cp -298 nodes 297999 nps 733987 time 406 pv b8c7 f3f5 c7d8 f5b5 b4c3 b5c5 c3b4 g8f8 a2a4 a6a5 b4a3 f8e8 d8b6 c5g5 b2b4 g5g3 a3b2 a5b4 b6c5 g6g5 c5b4. info depth 14 seldepth 21 multipv 1 score cp -298 nodes 324280 nps 732009 time 443 pv b8c7 f3f5 c7d8 f5b5 b4c3 b5c5 c3b4 g8f8 a2a4 a6a5 b4a3 f8e8 d8b6 c5g5 b2b4 g5g3 a3b2 a5b4 b6c5 g6g5 c5b4. info depth 15 seldepth 24 multipv 1 score cp -298 nodes 414788 nps 732840 time 566 pv b8e5 f3f5 e5f6 g8f8 b4c3 f8e8 c3d3 e8d7 d3e3 d7e6 b2b3 b6b5 e3e4 f5f2 a2a3 f2g2. info depth 16 seldepth 28 multipv 1 score cp -306 nodes 693205 nps 723596 time 958 pv b8e5 f3f5 e5f6 g8f8 b4c3 f8e8 a2a3 e8d7 c3d4 a6a5 d4e3 a5a4 e3d3 f5d5 d3e3 d7c6 e3e4 b6b5. info depth 17 seldepth 28 multipv 1 score cp -309 nodes 876970 nps 722976 time 1213 pv b8c7 f3f5 c7d8 f5f4 b4c3 b6b5 c3d3 f7f5 g5f6 f4f2 d3c3 g8f7 d8b6 f2f3 c3d4 f3f6 b6c5 g6g5 d4e4 f6f4 e4e5 f4a4 a2a3 a4c4. info depth 18 seldepth 29 multipv 1 score cp -319 nodes 1614312 nps 718749 time 2246 pv b8d6 f3e3 a2a3 e3e2 b4c3 f7f5 g5f6 g8f7 d6c7 b6b5 c7b6 f7f6 c3d3 e2h2 d3e4 f6e6 b6d4 g6g5. info depth 19 seldepth 30 multipv 1 score cp -332 upperbound nodes 2394951 nps 719853 time 3327 pv b8d6 f3e3. info depth 19 seldepth 30 multipv 1 score cp -332 nodes 2762135 nps 721938 time 3826 pv b8d6 f3e3 b2b3 e3e4 b4c3 b6b5 a2a3 g8g7 c3d3 e4g4 d6e7 g4g3 d3c2 f7f5 g5f6 g7f7 a3a4 g3f3 a4b5 a6b5 e7b4 g6g5 b4d6 f7f6. info depth 20 seldepth 30 multipv 1 score cp -339 upperbound nodes 3194631 nps 722930 time 4419 pv b8d6 f3e3. info depth 20 seldepth 30 multipv 1 score cp -332 lowerbound nodes 3664447 nps 723912 time 5062 pv b8c7. info depth 20 seldepth 30 multipv 1 score cp -339 upperbound nodes 3705290 nps 723689 time 5120 pv b8c7 f3f5. info depth 20 seldepth 31 multipv 1 score cp -331 lowerbound nodes 3874333 nps 723498 time 5355 pv b8c7. info depth 20 seldepth 31 multipv 1 score cp -330 nodes 3913830 nps 723577 time 5409 pv b8c7 f3f5 c7d8 f5f4 b4c3 b6b5 a2a3 g8f8 c3d3 f8e8 d8f6 e8d7 d3e3 f4a4 e3f3 d7e6 f6c3 a4h4 f3g3 h4c4 c3f6 e6f5 b2b3 c4c6 g3f3. bestmove b8c7 ponder f3f5. ");
		fenM2.setScore(-20);
		Move m2 = new Move(2, 0, fenM2);
		moves.add(m2);
		
		g.setAlMoves(moves);
		
		// Fonction à tester
		ScoreAnalysis.analyzeScore(g);
		
		assertEquals(expected, g.getScoreTotalVariation());
	}
}

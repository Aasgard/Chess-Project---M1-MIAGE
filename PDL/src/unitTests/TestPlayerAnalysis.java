package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import analysis.PlayerAnalysis;
import object.ErrorPlayer;
import object.FEN;
import object.Game;
import object.Move;
import object.Player;

public class TestPlayerAnalysis {
	
	public List<Move> moves = new ArrayList<Move>();
	
	@Before
	public void setUpMovesWithOneBlunder(){
		
		// Fen
		FEN fen0 = new FEN("1Q6/p1kN1p2/2b1p1p1/1p1qP2p/5R1P/2P5/5PPK/4r3 b - - 4 38", "info depth 1 seldepth 1 multipv 1 score mate -1 nodes 6 nps 6000 time 1 pv c7d7 f4f7. info depth 2 seldepth 3 multipv 1 score mate -1 nodes 10 nps 10000 time 1 pv c7d7 f4f7. info depth 3 seldepth 3 multipv 1 score mate -1 nodes 14 nps 14000 time 1 pv c7d7 f4f7. info depth 4 seldepth 3 multipv 1 score mate -1 nodes 18 nps 18000 time 1 pv c7d7 f4f7. info depth 5 seldepth 3 multipv 1 score mate -1 nodes 22 nps 22000 time 1 pv c7d7 f4f7. info depth 6 seldepth 3 multipv 1 score mate -1 nodes 26 nps 26000 time 1 pv c7d7 f4f7. info depth 7 seldepth 3 multipv 1 score mate -1 nodes 30 nps 30000 time 1 pv c7d7 f4f7. info depth 8 seldepth 3 multipv 1 score mate -1 nodes 34 nps 34000 time 1 pv c7d7 f4f7. info depth 9 seldepth 3 multipv 1 score mate -1 nodes 38 nps 38000 time 1 pv c7d7 f4f7. info depth 10 seldepth 3 multipv 1 score mate -1 nodes 42 nps 42000 time 1 pv c7d7 f4f7. info depth 11 seldepth 3 multipv 1 score mate -1 nodes 46 nps 46000 time 1 pv c7d7 f4f7. info depth 12 seldepth 3 multipv 1 score mate -1 nodes 50 nps 50000 time 1 pv c7d7 f4f7. info depth 13 seldepth 3 multipv 1 score mate -1 nodes 54 nps 54000 time 1 pv c7d7 f4f7. info depth 14 seldepth 3 multipv 1 score mate -1 nodes 58 nps 58000 time 1 pv c7d7 f4f7. info depth 15 seldepth 3 multipv 1 score mate -1 nodes 62 nps 62000 time 1 pv c7d7 f4f7. info depth 16 seldepth 3 multipv 1 score mate -1 nodes 66 nps 66000 time 1 pv c7d7 f4f7. info depth 17 seldepth 3 multipv 1 score mate -1 nodes 70 nps 70000 time 1 pv c7d7 f4f7. info depth 18 seldepth 3 multipv 1 score mate -1 nodes 74 nps 74000 time 1 pv c7d7 f4f7. info depth 19 seldepth 3 multipv 1 score mate -1 nodes 78 nps 78000 time 1 pv c7d7 f4f7. info depth 20 seldepth 3 multipv 1 score mate -1 nodes 82 nps 82000 time 1 pv c7d7 f4f7. bestmove c7d7 ponder f4f7.");
		FEN fen1 = new FEN("1Q6/p2r1pkp/4p1p1/1pn5/3qP3/1B1P1R1P/PP3PP1/6K1 w - - 6 28", "info depth 1 seldepth 1 multipv 1 score cp 6 nodes 132 nps 132000 time 1 pv b8b5 c5d3. info depth 2 seldepth 2 multipv 1 score cp 6 nodes 225 nps 225000 time 1 pv b8b5 c5d3. info depth 3 seldepth 3 multipv 1 score cp 0 nodes 445 nps 222500 time 2 pv b8b5 c5d3 a2a3 d3b2. info depth 4 seldepth 5 multipv 1 score cp -21 nodes 1435 nps 717500 time 2 pv a2a3 d4b2 b8b5 b2a1 g1h2. info depth 5 seldepth 6 multipv 1 score cp 30 nodes 4799 nps 959800 time 5 pv b8c8 c5b3 a2b3 f7f6 h3h4. info depth 6 seldepth 7 multipv 1 score cp -31 nodes 9171 nps 1146375 time 8 pv b8e8 a7a6 h3h4 d4b2 g1h2 b2e5 g2g3. info depth 7 seldepth 8 multipv 1 score cp -33 nodes 10921 nps 455041 time 24 pv b8b5 c5d3 b5c4 d4c4 b3c4 d3b2 f3c3 d7d1 g1h2 b2c4. info depth 8 seldepth 9 multipv 1 score cp -33 nodes 12770 nps 510800 time 25 pv b8b5 c5d3 b5c4 d4c4 b3c4 d3b2 f3c3 d7d1 g1h2. info depth 9 seldepth 14 multipv 1 score cp -41 nodes 59570 nps 518000 time 115 pv b8b5 c5d3 b3a4 d7d8 f3e3 d3b2 a4c2 b2c4 e3d3. info depth 10 seldepth 16 multipv 1 score cp -43 nodes 73646 nps 537562 time 137 pv b8b5 c5d3 b3c2 d3e1 f3c3 e1c2 c3c2 d4d1 g1h2 d1c2 b5d7 c2f2. info depth 11 seldepth 16 multipv 1 score cp 0 nodes 97650 nps 545530 time 179 pv b8c8 d7d8 c8c7 d8d7 c7c8. info depth 12 seldepth 16 multipv 1 score cp 0 nodes 107215 nps 541489 time 198 pv b8c8 d7d8 c8c7 d8d7 c7c8. info depth 13 seldepth 16 multipv 1 score cp 0 nodes 116672 nps 569131 time 205 pv b8c8 d7d8 c8c7 d8d7 c7c8. info depth 14 seldepth 21 multipv 1 score cp -35 nodes 383290 nps 417072 time 919 pv g2g3 h7h6 b8b5 c5d3 b3c2 d3b2 b5a5 b2c4 a5c3 c4d2 c3d4 d7d4 f3d3 e6e5 g1g2 a7a6 d3d4 e5d4. info depth 15 seldepth 23 multipv 1 score cp -22 nodes 608101 nps 385117 time 1579 pv g2g3 h7h6 b8b5 c5d3 b3c2 d3b2 b5a5 b2c4 a5c3 c4d2 c3d4 d7d4 f3a3 d2e4 c2e4 d4e4 a3a7 e4e2 a2a4 e2a2 g1g2. info depth 16 seldepth 27 multipv 1 score cp -31 nodes 1068185 nps 408796 time 2613 pv g2g3 h7h5 b8b5 c5d3 b5c4 a7a5 c4d4 d7d4 b3c2 d3c1 a2a3 d4d2 c2a4 c1d3 a4e8 d3e5 f3c3 d2b2 c3c7. info depth 17 seldepth 27 multipv 1 score cp -18 lowerbound nodes 1286916 nps 417423 time 3083 pv g2g3. info depth 17 seldepth 27 multipv 1 score cp -15 nodes 1566037 nps 420525 time 3724 pv g2g3 h7h6 b8b5 c5d3 b3c2 d3b2 b5a5 b2c4 a5c3 c4d2 f3e3 d4c3 e3c3 d7b7 g1g2 b7b2 a2a4 a7a5 e4e5. info depth 18 seldepth 27 multipv 1 score cp -21 upperbound nodes 1693867 nps 418032 time 4052 pv g2g3 h7h6. info depth 18 seldepth 27 multipv 1 score cp -27 upperbound nodes 1811375 nps 414977 time 4365 pv g2g3 h7h6. info depth 18 seldepth 27 multipv 1 score cp -37 upperbound nodes 2278513 nps 405645 time 5617 pv g2g3 a7a6. info depth 18 seldepth 30 multipv 1 score cp -29 lowerbound nodes 2601736 nps 408371 time 6371 pv b8b5. info depth 18 seldepth 31 multipv 1 score cp -27 nodes 2870229 nps 410443 time 6993 pv b8b5 c5d3 b5c4 d4b2 f3d3 b2b1 d3d1 d7d1 b3d1 b1d1 g1h2 d1d2 f2f3 a7a5 h3h4 g7f6 h2g3 d2e1 g3h3 e1a1 g2g4 h7h6 c4e2 a1h1 h3g3 h1g1 g3h3 g1d4 h3g2. info depth 19 seldepth 36 multipv 1 score cp -20 lowerbound nodes 3571487 nps 420224 time 8499 pv b8b5. info depth 19 seldepth 36 multipv 1 score cp -23 nodes 3775905 nps 419545 time 9000 pv b8b5 c5d3 b5c4 d4b2 f3d3 b2b1 d3d1 d7d1 b3d1 b1d1 g1h2 d1d2 f2f3 d2f4 h2g1 f4e5 g1f2 h7h6 c4e2 h6h5 e2d2 h5h4 f2e2 g6g5 e2d3. info depth 20 seldepth 36 multipv 1 score cp -17 lowerbound nodes 4505803 nps 420395 time 10718 pv b8b5. info depth 20 seldepth 36 multipv 1 score cp -23 upperbound nodes 4766034 nps 421400 time 11310 pv b8b5 c5d3. info depth 20 seldepth 36 multipv 1 score cp -19 nodes 4896967 nps 420520 time 11645 pv b8b5 c5d3 b5c4 d4b2 f3d3 b2b1 d3d1 d7d1 b3d1 b1d1 g1h2 d1d2 f2f3 g7f6 c4c7 a7a6 a2a4 d2d4 h2g3 d4e5 c7e5 f6e5 g3f2 f7f5 e4f5 e6f5. bestmove b8b5 ponder c5d3. ");
		
		FEN fen2 = new FEN("1R2n3/2r2k1p/2Pp2p1/p2P1p2/2P1pP2/8/4B1PP/6K1 w - - 2 33", "info depth 1 seldepth 1 multipv 1 score cp 72 nodes 28 nps 28000 time 1 pv g1f2. info depth 2 seldepth 2 multipv 1 score cp 75 nodes 96 nps 96000 time 1 pv b8a8 a5a4. info depth 3 seldepth 3 multipv 1 score cp 75 nodes 135 nps 135000 time 1 pv b8a8 a5a4 a8a4. info depth 4 seldepth 4 multipv 1 score cp 113 nodes 248 nps 248000 time 1 pv b8a8 h7h5 a8a5 h5h4. info depth 5 seldepth 5 multipv 1 score cp 68 nodes 675 nps 337500 time 2 pv b8a8 f7e7 a8a5 e8f6 g2g3. info depth 6 seldepth 6 multipv 1 score cp 71 nodes 949 nps 474500 time 2 pv b8a8 a5a4 a8a4 e8f6 g2g3 f7e7. info depth 7 seldepth 7 multipv 1 score cp 71 nodes 1553 nps 776500 time 2 pv b8a8 f7e7 a8a5 e8f6 e2d1 h7h6 g2g3. info depth 8 seldepth 9 multipv 1 score cp 187 nodes 8657 nps 1442833 time 6 pv b8a8 f7e7 g1f2 a5a4 f2e3 e8f6 a8a4 h7h6. info depth 9 seldepth 9 multipv 1 score cp 188 nodes 10110 nps 1444285 time 7 pv b8a8 f7e7 g1f2 a5a4 f2e3 e8f6 a8a4 h7h6 a4a8. info depth 10 seldepth 15 multipv 1 score cp 175 nodes 25777 nps 1611062 time 16 pv g1f2 c7e7 b8a8 e4e3 f2f3 e8f6 c4c5 f6e4 c5d6 e4d2 f3g3 d2e4 g3h4 e4d6 a8a5. info depth 11 seldepth 19 multipv 1 score cp 188 nodes 32095 nps 1689210 time 19 pv g1f2 c7e7 b8a8 e4e3 f2f3 e8f6 c4c5 f6e4 c5d6 e4d2 f3g3 d2e4 g3h4 e4d6 a8d8 d6e4 d5d6. info depth 12 seldepth 21 multipv 1 score cp 210 nodes 72224 nps 1719619 time 42 pv g1f2 a5a4 b8a8 f7e7 f2e3 h7h6 e2d1 a4a3 g2g3 e8f6 a8a3 e7d8 a3a8 c7c8. info depth 13 seldepth 21 multipv 1 score cp 212 nodes 104567 nps 1742783 time 60 pv g1f2 e8f6 b8a8 e4e3 f2e3 c7e7 e3d3 f6e4 d3d4 e4c5 e2d1 e7e4 d4c3 e4e3 c3d2 e3d3 d2c2. info depth 14 seldepth 22 multipv 1 score cp 212 nodes 169553 nps 1730132 time 98 pv g1f2 e4e3 f2e3 c7e7 e3d3 e8c7 e2d1 c7a6 b8a8 a6c5 d3d4 e7e4 d4c3 e4e3 c3d2 e3e7 a8a5 c5e4 d2c2. info depth 15 seldepth 29 multipv 1 score cp 224 nodes 533564 nps 1721174 time 310 pv g1f2 c7e7 b8a8 h7h6 f2e3 f7f6 a8a5 e8c7 e3d4 e7e8 a5a7 e8e7 a7b7 g6g5 f4g5 h6g5. info depth 16 seldepth 29 multipv 1 score cp 232 nodes 710368 nps 1707615 time 416 pv g1f2 c7e7 b8a8 e8c7 a8a5 e7e8 a5a7 e8e7 a7b7 f7f6 g2g4 c7a6 g4f5 g6f5 f2e3 a6c7 e2h5 h7h6. info depth 17 seldepth 29 multipv 1 score cp 232 nodes 1106711 nps 1664227 time 665 pv g1f2 c7e7 b8a8 h7h6 f2e3 e8c7 a8a5 g6g5 e3d4 e4e3 d4d3 g5f4 c4c5 c7e8 g2g3 f4g3 h2g3 d6c5. info depth 18 seldepth 31 multipv 1 score cp 231 nodes 1572279 nps 1655030 time 950 pv g1f2 c7e7 b8a8 h7h6 f2e3 e8c7 a8a5 e7e8 a5a7 e8e7 a7b7 h6h5 e3d4 c7a6 c4c5 d6c5 d4e3 e7b7 c6b7 a6b8. info depth 19 seldepth 31 multipv 1 score cp 237 nodes 1813513 nps 1633795 time 1110 pv g1f2 c7e7 b8a8 h7h6 f2e3 e8c7 a8a5 e7e8 a5a7 e8e7 a7b7 h6h5 g2g3 f7f6 h2h3 c7a6 g3g4 e7b7 c6b7 h5g4 h3g4 f6e7 g4f5 g6f5. info depth 20 seldepth 37 multipv 1 score cp 258 nodes 4589028 nps 1603433 time 2862 pv g1f2 c7e7 b8a8 a5a4 a8a4 h7h6 a4a8 e7c7 f2e3 e8f6 e3d4 g6g5 c4c5 f7e7 c5d6 e7d6 a8f8 f6d5 f8d8 d6e6 d8d5 c7c6 g2g4. bestmove g1f2 ponder c7e7. ");
		FEN fen3 = new FEN("1R2r1k1/6p1/Q6p/2pp1q2/8/2P4P/P3rPP1/5RK1 w - - 0 28", "info depth 1 seldepth 1 multipv 1 score cp 62 nodes 59 nps 7375 time 8 pv g2g4. info depth 2 seldepth 2 multipv 1 score cp 428 nodes 134 nps 10307 time 13 pv g2g4 e8b8 g4f5. info depth 3 seldepth 3 multipv 1 score cp 428 nodes 209 nps 16076 time 13 pv g2g4 e8b8 g4f5. info depth 4 seldepth 4 multipv 1 score cp 433 nodes 300 nps 23076 time 13 pv g2g4 e8b8 g4f5 c5c4. info depth 5 seldepth 5 multipv 1 score cp 433 nodes 472 nps 36307 time 13 pv g2g4 e8b8 g4f5 c5c4 a2a3. info depth 6 seldepth 8 multipv 1 score cp 557 nodes 1286 nps 91857 time 14 pv g2g4 f5f2 f1f2 e2e1 f2f1 e1f1 g1f1 e8b8 a6e6 g8f8. info depth 7 seldepth 10 multipv 1 score cp 564 nodes 1604 nps 106933 time 15 pv g2g4 f5f2 f1f2 e2e1 f2f1 e1f1 g1f1 e8b8 a6e6 g8h7 e6d5. info depth 8 seldepth 11 multipv 1 score cp 138 nodes 9901 nps 267594 time 37 pv b8e8 e2e8 a6b5 f5e4 b5c5 h6h5 c5b5 g7g5 a2a3. info depth 9 seldepth 14 multipv 1 score cp 141 nodes 23804 nps 258739 time 92 pv b8e8 e2e8 a6b5 f5c8 a2a4 e8e6 f1d1 c8c7 a4a5 g8f7 a5a6 e6e5. info depth 10 seldepth 16 multipv 1 score cp 134 nodes 51756 nps 252468 time 205 pv b8e8 e2e8 a6b5 e8a8 b5c5 a8c8 c5d6 c8c3 a2a4 c3c2 a4a5 c2a2 a5a6. info depth 11 seldepth 17 multipv 1 score cp 143 nodes 69604 nps 254029 time 274 pv b8e8 e2e8 a6b5 e8a8 b5c5 a8a2 f1d1 f5e5 c3c4 a2a1 d1a1 e5a1 g1h2 d5c4 c5c4 g8h8. info depth 12 seldepth 20 multipv 1 score cp 136 nodes 88522 nps 254373 time 348 pv b8e8 e2e8 a6b5 e8a8 b5c5 a8a2 f1d1 f5e5 c3c4 a2a1 d1a1 e5a1 g1h2 d5c4 c5c4 g8h8. info depth 13 seldepth 22 multipv 1 score cp 126 nodes 300034 nps 266223 time 1127 pv b8e8 e2e8 a2a4 f5e5 a6c6 d5d4 c3d4 c5d4 a4a5 e5e6 c6b5 e8d8 f1d1 d4d3 d1d3 d8d3 b5d3 e6e1 g1h2 e1a5. info depth 14 seldepth 26 multipv 1 score cp 150 nodes 409206 nps 266583 time 1535 pv b8e8 e2e8 a2a4 f5e5 a6c6 d5d4 c3d4 c5d4 a4a5 e5e6 c6b5 e8d8 b5d3 e6d5 a5a6 d5a2 f1c1 d8a8 d3d4 a2a6 d4d5 g8h8. info depth 15 seldepth 26 multipv 1 score cp 145 nodes 651827 nps 263470 time 2474 pv b8e8 e2e8 a2a4 f5e6 a6b5 d5d4 c3d4 c5d4 a4a5 e8d8 b5d3 e6a2 a5a6 d8f8 f2f4 f8a8 d3d4 a8a6 f1d1 a6a3. info depth 16 seldepth 28 multipv 1 score cp 139 upperbound nodes 924761 nps 260202 time 3554 pv b8e8 e2e8. info depth 16 seldepth 28 multipv 1 score cp 145 lowerbound nodes 991450 nps 259677 time 3818 pv b8e8. info depth 16 seldepth 28 multipv 1 score cp 139 upperbound nodes 1130880 nps 259138 time 4364 pv b8e8 e2e8. info depth 16 seldepth 28 multipv 1 score cp 147 lowerbound nodes 1325712 nps 259231 time 5114 pv b8e8. info depth 16 seldepth 28 multipv 1 score cp 153 nodes 1571857 nps 258955 time 6070 pv b8e8 e2e8 a2a4 f5e6 a6b5 d5d4 c3d4 c5d4 a4a5 e8d8 b5d3 e6a2 a5a6 d8f8 f2f4 f8a8 f1b1 a8d8 b1b6. info depth 17 seldepth 28 multipv 1 score cp 147 upperbound nodes 1829985 nps 258801 time 7071 pv b8e8 e2e8. info depth 17 seldepth 28 multipv 1 score cp 141 upperbound nodes 1885456 nps 259062 time 7278 pv b8e8 e2e8. info depth 17 seldepth 28 multipv 1 score cp 147 lowerbound nodes 1992424 nps 258789 time 7699 pv b8e8. info depth 17 seldepth 28 multipv 1 score cp 139 upperbound nodes 2159391 nps 259230 time 8330 pv b8e8 e2e8. info depth 17 seldepth 28 multipv 1 score cp 143 nodes 2268819 nps 259145 time 8755 pv b8e8 e2e8 a2a4 f5c2 a6c6 e8d8 c6b6 d8a8 b6c5 a8a4 c5d5 g8h7 f1d1 a4a2 d5f3 a2a3 f3d3 c2d3 d1d3 a3a4 d3d1 a4c4 d1c1 g7g5. info depth 18 seldepth 28 multipv 1 score cp 150 lowerbound nodes 2343535 nps 259441 time 9033 pv b8e8. info depth 18 seldepth 28 multipv 1 score cp 150 nodes 2372436 nps 259282 time 9150 pv b8e8 e2e8 a2a4 f5c2 a6c6 e8d8 c6b6 d8a8 b6c5 a8a4 c5d5 g8h7 f1d1 a4a2 d5f3 a2a3 f3d3 c2d3 d1d3 h7g6 g1h2 a3a2 h2g3. info depth 19 seldepth 29 multipv 1 score cp 156 lowerbound nodes 2564711 nps 257294 time 9968 pv b8e8. info depth 19 seldepth 29 multipv 1 score cp 150 upperbound nodes 2743126 nps 252822 time 10850 pv b8e8 e2e8. info depth 19 seldepth 29 multipv 1 score cp 140 upperbound nodes 2846822 nps 250160 time 11380 pv b8e8 e2e8. info depth 19 seldepth 29 multipv 1 score cp 126 upperbound nodes 3150564 nps 248193 time 12694 pv b8e8 e2e8. info depth 19 seldepth 37 multipv 1 score cp 137 lowerbound nodes 4424509 nps 234547 time 18864 pv b8e8. info depth 19 seldepth 37 multipv 1 score cp 139 nodes 4522442 nps 233548 time 19364 pv b8e8 e2e8 a2a4 f5e5 a6b5 e8a8 f1c1 e5d6 c1d1 a8d8 a4a5 d8b8 b5c4 d5c4 d1d6 b8a8 a5a6 g8f7 d6d7 f7e8 d7g7 a8a6 g7h7. info depth 20 seldepth 37 multipv 1 score cp 145 lowerbound nodes 5543394 nps 225542 time 24578 pv b8e8. info depth 20 seldepth 37 multipv 1 score cp 151 lowerbound nodes 6239342 nps 225043 time 27725 pv b8e8. info depth 20 seldepth 37 multipv 1 score cp 145 upperbound nodes 6844793 nps 224008 time 30556 pv b8e8 e2e8. info depth 20 seldepth 37 multipv 1 score cp 153 lowerbound nodes 7474659 nps 223057 time 33510 pv b8e8. info depth 20 seldepth 37 multipv 1 score cp 142 upperbound nodes 7590184 nps 223358 time 33982 pv b8e8 e2e8. info depth 20 seldepth 37 multipv 1 score cp 141 nodes 7857999 nps 224527 time 34998 pv b8e8 e2e8 a6b5 e8a8 a2a4 f5e5 f1c1 e5d6 c1d1 a8b8 b5d3 b8d8 a4a5 d6f6 d1a1 c5c4 d3e3 d8a8 e3d2 f6c6 a5a6 a8a6. bestmove b8e8 ponder e2e8. ");
		
		// Moves
		Move move0 = new Move(0, 0, fen0);
		Move move1 = new Move(1, 1, fen1);
		Move move2 = new Move(2, 2, fen2);
		Move move3 = new Move(3, 3, fen3);
		
		// - white
		moves.add(move0);
		moves.add(move2);
	
		// - black
		moves.add(move1);
		moves.add(move3);
	}
	
	@Test
	public void testIsMate(){
		System.out.println(moves.get(0).getFen().getLog());
		assertTrue(moves.get(0).isMate());
	}
	
	@Test
	public void testAddPlayer(){
		
		// Initilisation
		Player player = new Player(4, "ganjo");
		Boolean winner = true;
		Boolean other = false;
		String date = "2013-06-20";
		int elo = 1470;
		
		// Fonction a tester
		PlayerAnalysis playerAnalysis = new PlayerAnalysis();
		playerAnalysis.addPlayer(player, winner, other, date, elo);
		
		// Comparaison des résultats
		Player playerRes = playerAnalysis.getPlayers().get(0);
		assertEquals(1, playerAnalysis.getPlayers().size());
		assertEquals(player, playerRes);
	}

	/**
	 * Test pour une erreur
	 */
	@Test
	public void testCheckBlunderMat(){
		
		/* Expected */
		// Définit une erreur pour le joueur blanc
		ErrorPlayer expErrorWHite = new ErrorPlayer(1, 1);
		
		
		// ErrorPlayer
		ErrorPlayer errorWhite = new ErrorPlayer(1, 0);
		ErrorPlayer errorBlack = new ErrorPlayer(1, 0);
		
		// Ma fonction à tester
		PlayerAnalysis playerAnalysis = new PlayerAnalysis();
		playerAnalysis.checkBlunderMat(moves, errorWhite, errorBlack);
		
		// Test si le joueur blanc a une erreur
		assertEquals(expErrorWHite.getNb_of_error(), errorWhite.getNb_of_error());
	}
	
	
	@Test
	public void testGetPlayerStats(){
		
		/* Initialisation */		
		Player whitePlayer = new Player(1, "blanc");
		Player blackPlayer = new Player(2, "noir");
		
		
		// - Game
		Game g = new Game();
		g.setId(1);
		g.setAlMoves(moves);
		g.setDate("2014-07-25");
		g.setResult(1);
		g.setWhitePlayer(whitePlayer);
		g.setBlackPlayer(blackPlayer);

		
		// Ma fonction à tester
		PlayerAnalysis playerAnalysis = new PlayerAnalysis();
		playerAnalysis.getPlayerStats(g);
		
		// Comparaison des résultats
		List<Player> players = playerAnalysis.getPlayers();
		
		assertEquals(2, players.size());
		assertEquals(whitePlayer, players.get(0));
		assertEquals(blackPlayer, players.get(1));
		
		
	}
}

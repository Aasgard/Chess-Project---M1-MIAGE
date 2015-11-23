<<<<<<< HEAD
package analysis;

import java.util.List;

import json.ExtractJSON;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.Move;
import object.Position;

public class ScoreFromPositionAnalysis {

	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	private static ExtractJSON extractJSON = new ExtractJSON();
	private static FEN bestFEN = new FEN();
	
	public static void getEvolScore(List<Move> moves){
		fen = moves.get(0).getLog();
		for(Move move : moves){
			isBestMove(extractJSON.extractFENAfterMove(move));
		}

		treatmentJSON.saveBestFenToJSON(fen, bestPosition);
	}
	
	private static void isBestMove(FEN fen){
		if(fen.getScore() > bestFEN.getScore()){
			bestFEN.setPosition(fen.getPosition());
			bestFEN.setScore(fen.getScore());
		}
	}
}
=======
package analysis;

import java.util.List;

import json.ExtractJSON;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.FEN;
import object.Move;
import object.Position;

public class ScoreFromPositionAnalysis {

	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	private static ExtractJSON extractJSON = new ExtractJSON();
	private static FEN bestFEN = new FEN("");
	
	public static void getEvolScore(List<Move> moves){
		fen = moves.get(0).getLog();
		for(Move move : moves){
			isBestMove(extractJSON.extractFENAfterMove(move));
		}
		treatmentJSON.saveBestFENToJSON(fen);
	}
	
	private static void isBestMove(FEN fen){
		if(fen.getScore() > bestFEN.getScore()){
			bestFEN.setPosition(fen.getPosition());
			bestFEN.setScore(fen.getScore());
		}
	}
}
>>>>>>> branch 'master' of https://github.com/Aasgard/Chess-Project---M1-MIAGE.git

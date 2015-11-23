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
			isBestMove(extractJSON.extractScoreAfterMove(move));
		}
		treatmentJSON.saveBestFENToJSON(FEN fen);
	}
	
	private static void isBestMove(FEN fen){
		if(fen.getScore() > bestFEN.getScore()){
			bestFEN.setPosition(fen.getPosition());
			bestFEN.setScore(fen.getScore());
		}
	}
}

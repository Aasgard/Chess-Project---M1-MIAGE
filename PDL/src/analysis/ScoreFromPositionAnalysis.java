package analysis;

import java.util.List;

import json.ExtractJSON;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.FEN;
import object.Move;

public class ScoreFromPositionAnalysis {

	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	private static ExtractJSON extractJSON = new ExtractJSON();
	private static FEN bestFEN = new FEN(new String(), new String());
	
	public static void getEvolScore(List<Move> moves){
		String fen = moves.get(0).getFen().getPosition();
		for(Move move : moves){
			isBestMove(extractJSON.extractFENAfterMove(move));
		}

		treatmentJSON.saveBestFenToJSON(fen, bestFEN);
	}
	
	private static void isBestMove(FEN fen ){
		if(fen.getScore() > bestFEN.getScore()){
			bestFEN.setPosition(fen.getPosition());
			bestFEN.setScore(fen.getScore());
		}
	}
}
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
	private static String fen;
	private static Position bestPosition = null;
	
	public static void getEvolScore(List<Move> moves){
		fen = moves.get(0).getLog();
		for(Move move : moves){
			isBestMove(extractJSON.extractScoreAfterMove(move));
		}
		treatmentJSON.saveBestMoveToJSON(bestPosition , fen);
	}

	private static void isBestMove(Position position){
		if(position.getScore() > bestPosition.getScore()){
			bestPosition = position;
		}
	}
}

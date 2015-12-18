package analysis;

import java.util.List;
import object.GameAndNextMove;

public class ScoreFromPositionAnalysis {

	public ScoreFromPositionAnalysis(){
	}

	/**
	 * Sauvegarde le meilleur move pour un FEN
	 * @param position
	 * @param movesByGame
	 */
	public GameAndNextMove[] getEvolScore(String position, List<GameAndNextMove> movesByGame){
		GameAndNextMove tableaubest_GameAndNextMove[] = new GameAndNextMove[5];
		for(int i = 0; i<5; i++){
			tableaubest_GameAndNextMove[i] = new GameAndNextMove();
		}
		for(GameAndNextMove gameAndNextMove : movesByGame){
			int j = 0;
			boolean find = false;
			while(j < tableaubest_GameAndNextMove.length && !find){
				if(tableaubest_GameAndNextMove[j].getMove().getFen().getScore() <= gameAndNextMove.getMove().getFen().getScore()){

					for(int k = tableaubest_GameAndNextMove.length-1 ; k > j ; k--){
						tableaubest_GameAndNextMove[k] = tableaubest_GameAndNextMove[k-1];
					}
					tableaubest_GameAndNextMove[j] = gameAndNextMove;
					find = true;
				}
				j++;
			} 
		}
		return tableaubest_GameAndNextMove;
	}



}
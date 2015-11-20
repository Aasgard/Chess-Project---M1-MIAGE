package tests;

import java.util.ArrayList;

<<<<<<< HEAD
import analyse.ExtractDB;
import classes.FEN;
=======
import database.ExtractDB;
import object.Game;
>>>>>>> branch 'master' of https://github.com/Aasgard/Chess-Project---M1-MIAGE.git

public class testExtract {

	public static void main(String[] args) {
		
		//ArrayList<Game> listGames = ExtractDB.getGamesByOpening(2006);
<<<<<<< HEAD
		/*ArrayList<Opening> allOpenings = ExtractDB.getAllOpenings();
		
		for(Opening o : allOpenings){
			o.getId();
		}*/
		
		ArrayList<FEN> allFEN = ExtractDB.getAllFEN();
		
		for(FEN fen : allFEN){
			System.out.println(fen.getStraightFEN());
		}
		
		System.out.println("Il y a " + allFEN.size() + " dans la base de données.");
=======
>>>>>>> branch 'master' of https://github.com/Aasgard/Chess-Project---M1-MIAGE.git
		
	}

}

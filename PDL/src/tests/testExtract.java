package tests;

import java.util.List;

import database.ExtractDB;
import object.Game;

public class testExtract {

	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		
		/*System.out.println("Extraction des Moves de la Game n°1 : ");
		System.out.println("Nombre de moves : " + ExtractDB.extractMovesByGame(5).size());
		System.out.println("Extraction des Moves de la Game n°1 : TERMINE !");*/
		
		System.out.println("Extraction des Games : ");
		List<Game> alGame = ExtractDB.extractGames();
		System.out.println("Nombre de Games : " + alGame.size());
		
		double endTime =timer.elapsedTime();
		
		System.out.println("Temps d'exécution des requêtes : " + endTime + " sec.\n");
		System.out.println("Temps par Game : " + alGame.size()/endTime + " sec.");
	}

}

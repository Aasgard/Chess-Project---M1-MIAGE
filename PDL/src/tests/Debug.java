package tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.*;

import analysis.Analysis;
import object.Game;
import object.Move;
import object.Opening;
import tools.Tools;

import java.util.Iterator;

public class Debug {

	private static FileWriter fw;

	public static void main(String[] args) {
		
/*		Game g1 = new Game(1);
		
		ArrayList<Move> alMoves = g1.getAlMoves();
		
		ArrayList<Integer> alJ1Moves = new ArrayList<Integer>();
		ArrayList<Integer> alJ2Moves = new ArrayList<Integer>();
		
		Iterator<Move> it = alMoves.iterator();
		
		while(it.hasNext()){
			Move currentMove = it.next();
			if(currentMove.getNum()%2 == 1){
				alJ1Moves.add(currentMove.getHigherDepthScore());
				System.out.println("Move n° " + currentMove.getHalfMove() + "\t Joueur 1 \t Score : " + currentMove.getHigherDepthScore());
			}else{
				alJ2Moves.add(currentMove.getHigherDepthScore());
				System.out.println("Move n° " + currentMove.getHalfMove() + "\t Joueur 2 \t Score : " + currentMove.getHigherDepthScore());
			}
		}
		
		System.out.println();
		System.out.println("Scores du Joueur 1 : " + alJ1Moves);
		System.out.println("Scores du Joueur 2 : " + alJ2Moves);
		
		System.out.println();
		System.out.println("Total cumulé du Joueur 1 : " + Tools.getSommeAL(alJ1Moves));
		System.out.println("Total cumulé du Joueur 2 : " + Tools.getSommeAL(alJ2Moves));
		
		System.out.println("Cette game comporte " + g1.getNbMoves() +  " moves");
		
		JSONArray outputJSON = new JSONArray();
		
		JSONObject objJoueur1 = new JSONObject();
		JSONObject objJoueur2 = new JSONObject();

		objJoueur1.put("name", "Joueur 1");
		objJoueur1.put("data", alJ1Moves);
		
		objJoueur2.put("name", "Joueur 2");
		objJoueur2.put("data", alJ2Moves);
		
		outputJSON.put(objJoueur1);
		outputJSON.put(objJoueur2);
		
		try {
			File f1 = new File("D:/wamp/www/PDL Website/json/test2.json");
			fw = new FileWriter(f1);
			fw.write(outputJSON.toString(2));
			fw.flush();
			fw.close();
		} catch (IOException e1) { e1.printStackTrace(); }
		
		Opening op = new Opening(85);
		System.out.println(op.toString());*/
		
		// test commit
		
		Analysis anal = new Analysis();
		anal.globalStats();
	}
}
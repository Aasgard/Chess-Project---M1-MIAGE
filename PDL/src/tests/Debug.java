package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.*;
import java.util.Iterator;

import classes.Game;
import classes.Move;
import outils.Tools;

public class Debug {

	private static FileWriter fw;

	public static void main(String[] args) {
		
		Game g1 = new Game(1);
		
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
		
		JSONObject obj = new JSONObject();
		obj.put("name", "Joueur 1");
		
		JSONArray jsa = new JSONArray();
		jsa.put(-5);
		jsa.put(-29);
		jsa.put(16);
		obj.put("data", jsa);
		
		try {
			File f1 = new File("D:/wamp/www/PDL Website/json/test2.json");
			fw = new FileWriter(f1);
			fw.write(obj.toString(2));
			fw.flush();
			fw.close();
		} catch (IOException e1) { e1.printStackTrace(); }
	}

}
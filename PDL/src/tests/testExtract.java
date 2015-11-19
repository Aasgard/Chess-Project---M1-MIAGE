package tests;

import java.util.ArrayList;

import analysis.ExtractDB;
import object.Game;

public class testExtract {

	public static void main(String[] args) {
		
		ArrayList<Game> listGames = ExtractDB.getGamesByOpening(2006);
		
	}

}

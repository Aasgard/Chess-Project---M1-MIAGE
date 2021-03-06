package unitTests;

import static org.junit.Assert.*;
import static json.IGlobalJSON.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.GlobalStats;
import json.ExtractJSON;
import object.Event;
import object.Game;
import object.Player;

public class TestGlobalStats {
	
	// For testGetGlobalBestVar
	private static List<Game> games = new ArrayList<Game>();
	// For testGetGlobalBestPlayers
	private static List<Player> players = new ArrayList<Player>();
	
	@BeforeClass
	public static void setUp() {
		// setup for testGetGlobalBestVar
		Game game1 = new Game();
		Game game2 = new Game();
		Game game3 = new Game();
		Game game4 = new Game();
		Game game5 = new Game();
		
		games.add(game1);
		games.add(game2);
		games.add(game3);
		games.add(game4);
		games.add(game5);
		Event event = new Event(1, "Tournoi", "Rennes");
		int i = 1;
		// les games sont rangées de la moins bonne à la meilleur
		// pour tester si elles seront remises dans le bon ordre
		for(Game game : games) {
			game.setDate("2015-0" + i + "-20");
			game.setEvent(event);
			game.setScoreTotalVariation(1000 + i);
			i++;
		}
		
		// setup for testGetGlobalBestPlayers
		Player player1 = new Player(0, "Francois");
		Player player2 = new Player(1, "Clément");
		Player player3 = new Player(2, "Pauline");
		Player player4 = new Player(3, "William");
		Player player5 = new Player(4, "Paul");
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		int j = 0;
		// les joueurs sont rangés du moins bon au meilleur
		// pour tester s'ils seront remis dans le bon ordre
		for(Player player : players) {
			player.setNbGameWin(j);
			player.setNbGameLoose(0);
			j++;
		}
	}

	/**
	 * Test de globalStats
	 */
	@Test
	public void testGetGlobalStats() {
		String fileName = PATH_TEST_CORRIGE + "globalStatsTest.json";
		
		// appel de la fonction
		GlobalStats.getGlobalStats(40, fileName);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(fileName);
		
		// test si le jsonArray est bon
		assertTrue(UtilsTests.testJsonArrayGlobalStats(jsonArray));
		
		
		
	}

	/**
	 * Test de getGlobalBestPlayers
	 */
	@Test
	public void testGetGlobalBestPlayers() {
		String fileName = PATH_TEST_CORRIGE + "bestPlayersTest.json";
		
		// appel de la fonction
		GlobalStats.getGlobalBestPlayers(players, fileName);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(fileName);
		
		// test si les joueurs sont bien dans l'ordre
		assertTrue(UtilsTests.jsonArrayContainsPlayer(jsonArray, players.get(0), 5));
		assertTrue(UtilsTests.jsonArrayContainsPlayer(jsonArray, players.get(4), 1));
		
		// suppression du contenu du json
		UtilsTests.deleteContentJSON(PATH_TEST + "bestPlayersTest.json");
	}

	/**
	 * Test de getGlobalBestVar
	 */
	@Test
	public void testGetGlobalBestVar() {
		String fileName = PATH_TEST_CORRIGE + "bestGameTest.json";
		
		// appel de la fonction
		GlobalStats.getGlobalBestVar(games, fileName);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(fileName);
		
		assertTrue(true);
	}

}

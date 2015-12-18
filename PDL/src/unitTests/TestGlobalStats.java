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
		int i = 6;
		for(Game game : games) {
			game.setDate("2015-0" + i + "-20");
			game.setEvent(event);
			game.setScoreTotalVariation(1000 - i);
			i--;
		}
		
		// setup for testGetGlobalBestPlayers
		Player player1 = new Player(0, "Francis Heaulme");
		Player player2 = new Player(1, "Emile Louis");
		Player player3 = new Player(2, "Pierrot le fou");
		Player player4 = new Player(3, "Le désanusseur de Nottingham Forest");
		Player player5 = new Player(4, "Rumen le bulgare");
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		int j = 0;
		for(Player player : players) {
			player.setNbGameWin(j);
			player.setNbGameLoose(0);
			j++;
		}
	}

	@Test
	public void testGetGlobalStats() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGlobalBestPlayers() {
		String fileName = "bestPlayersTest.json";
		
		// appel de la fonction
		GlobalStats.getGlobalBestPlayers(players, PATH_TEST_CORRIGE + fileName);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		// test si les joueurs sont bien dans l'ordre
		assertTrue(UtilsTests.jsonArrayContainsPlayer(jsonArray, players.get(0), 5));
		assertTrue(UtilsTests.jsonArrayContainsPlayer(jsonArray, players.get(4), 1));
	}

	@Test
	public void testGetGlobalBestVar() {
		String fileName = "bestGameTest.json";
		
		// appel de la fonction
		GlobalStats.getGlobalBestVar(games, PATH_TEST_CORRIGE + fileName);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		assertTrue(true);
	}

}

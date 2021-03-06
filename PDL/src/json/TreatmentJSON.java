package json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import object.ErrorPlayer;
import object.Game;
import object.GameAndNextMove;
import object.Move;
import object.Opening;
import object.Player;



public class TreatmentJSON implements ITreatmentJSON, IGlobalJSON {

	public void saveWinRateOpening(HashMap<Opening, List<Integer>> openings) {
		
		try {
			System.out.println(PATH + OPENING_FILE);
			PrintWriter writer = new PrintWriter(PATH + OPENING_FILE, "UTF-8");
			writer.print('[');
			int n = 0;
			for(Entry<Opening , List<Integer>> opening : openings.entrySet()){
				n++;
				

				int nbWhite = opening.getValue().get(0);
				int nbBlack = opening.getValue().get(1);
				int exaequo = opening.getValue().get(2);
				 JSONObject openingJson = createOpening(opening.getKey());


					JSONObject white = new JSONObject();
					white.put(NAME, "White");
					white.put(Y, nbWhite);
					white.put(COLOR, "#F6F3EE");

					JSONObject black = new JSONObject();
					black.put(NAME, "Black");
					black.put(Y, nbBlack);
					black.put(COLOR, "#494847");

					JSONObject deuce = new JSONObject();
					deuce.put(NAME, "Deuce");
					deuce.put(Y, exaequo);
					deuce.put(COLOR, "#A4A3A3'");

					JSONArray rate = new JSONArray();
					rate.put(white);
					rate.put(black);
					rate.put(deuce);
					openingJson.put(DATA, rate);
				
				if(n <= openings.size() && n != 1){
					writer.print(',');
				}

				writer.print(openingJson);
			}


			writer.print(']');
			System.out.println("New File..");

			System.out.println("Successfully Copied JSON Object to File...");
			writer.close();
		} catch (IOException e) {
		}		
	}


	/**
	 * Save all the players with their errors
	 * 
	 */
	public void savePlayersToJSON(List<Player> players) {
		JSONObject playerJSON;
		JSONArray errorsJSONArray;
		JSONArray elosJSONArray;
		try {
			System.out.println(PATH + PLAYER_FILE);
			PrintWriter writer = new PrintWriter(PATH + PLAYER_FILE, "UTF-8");
			writer.print('[');
			int n = 0;
			for(Player player : players) {
				n++;
				playerJSON = new JSONObject();
				

				// add errors
				errorsJSONArray = new JSONArray();
				for(ErrorPlayer error : player.getErrors()) {
					JSONObject errorJSON = new JSONObject();		
					errorJSON.put( ID_GAME , error.getIdGame());
					errorJSON.put( NB_OF_ERROR , error.getNb_of_error());
					String[] FenErrors = error.getError_fen().toArray(new String[error.getError_fen().size()]);
					errorJSON.put( ERRORS_FEN , FenErrors);

					errorsJSONArray.put(errorJSON);
				}

				// add elos
				elosJSONArray = new JSONArray();
				for(Map.Entry<String, Integer> entry : player.getElos().entrySet()) {
					JSONObject eloJSON = new JSONObject();
					eloJSON.put( DATE , entry.getKey());
					eloJSON.put( ELO , entry.getValue());

					elosJSONArray.put(eloJSON);
				}

				playerJSON.put(ID, player.getId());
				playerJSON.put( NAME , player.getName());
				playerJSON.put( NB_GAME_PLAYED , player.getNb_game_played());
				playerJSON.put( NB_GAME_WIN , player.getNbGameWin());	
				playerJSON.put( NB_GAME_LOOSE, player.getNbGameLoose());
				playerJSON.put( ERRORS , errorsJSONArray);
				playerJSON.put( ELOS , elosJSONArray);
				if(n <= players.size() && n != 1){
					writer.print(',');
				}
				writer.print(playerJSON);
			}
			writer.println(']');
			System.out.println("New File..");

			System.out.println("Successfully Copied JSON Object to File...");
			writer.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Sauvegarde un jsonObject dans un fichier donné
	 * 
	 * @param jsonObject
	 * @param objectName
	 * @param exist
	 */
	public static void saveInFile(JSONObject jsonObject, String objectName, boolean exist){

		JSONArray allData;
		if (exist){
			allData = ExtractJSON.deleteJsonObject(jsonObject, objectName);
		} else {
			allData = ExtractJSON.readJSONFile(objectName);
		}

		try {
			PrintWriter writer = new PrintWriter(PATH + objectName, "UTF-8");


			// Creation d'un nouveau fichier
			writer.println("[");
			if (allData == null){

				writer.println(jsonObject.toString(1));

				System.out.println("New File..");

				// Fichier d�ja existant
			} else {
				int i;
				for(i = 0; i < allData.length(); i++) {
					JSONObject object = allData.getJSONObject(i);
					writer.print(object.toString(1));
					writer.println(",");
				}
				writer.print(jsonObject.toString(1));

			}
			writer.println("]");
			//System.out.println("Successfully Copied JSON Object to File...");
			writer.close();
		} catch (IOException e) {
		}
	}

	private JSONObject createOpening(Opening o) {
		JSONObject object = new JSONObject();

		object.put( ID , o.getId());
		object.put( NAME_OPENING, o.getName() + "-" + o.getVariation());
		object.put( NB_MOVES, o.getNbMoves());
		object.put( MOVES , o.getMoves());

		return object;
	}

	/**
	 * Save nb of games played, nb of players and nb of events in a json file
	 * @param nb_games
	 * @param nb_players
	 * @param nb_events
	 */
	@Override
	public void saveGlobalStatsToJSON(int nb_games, int nb_players, int nb_events) {
		JSONObject object = new JSONObject();
		boolean exists = false;
		if(ExtractJSON.readJSONFile(GLOBALSTAT_FILE) != null){
			exists = true;
		}

		JSONArray objectArray = new JSONArray();

		JSONObject object1 = new JSONObject();
		object1.put(LIBELLE, NB_GAMES);
		object1.put(VALEUR, nb_games);
		objectArray.put(object1);

		JSONObject object2 = new JSONObject();
		object2.put(LIBELLE, NB_PLAYERS);
		object2.put(VALEUR, nb_players);
		objectArray.put(object2);

		JSONObject object3 = new JSONObject();
		object3.put(LIBELLE, NB_EVENT);
		object3.put(VALEUR, nb_events);
		objectArray.put(object3);

		object.put(ID, 1);
		object.put(GLOBAL_STATS, objectArray);
		saveInFile( object, GLOBALSTAT_FILE , exists);
	}
	
	/**
	 * Save nb of games played, nb of players and nb of events in a json file
	 * @param nb_games
	 * @param nb_players
	 * @param nb_events
	 */
	@Override
	public void saveGlobalStatsToJSON(int nb_games, int nb_players, int nb_events, String fileName) {
		JSONObject object = new JSONObject();
		boolean exists = false;
		if(ExtractJSON.readJSONFile(fileName) != null){
			exists = true;
		}

		JSONArray objectArray = new JSONArray();

		JSONObject object1 = new JSONObject();
		object1.put(LIBELLE, NB_GAMES);
		object1.put(VALEUR, nb_games);
		objectArray.put(object1);

		JSONObject object2 = new JSONObject();
		object2.put(LIBELLE, NB_PLAYERS);
		object2.put(VALEUR, nb_players);
		objectArray.put(object2);

		JSONObject object3 = new JSONObject();
		object3.put(LIBELLE, NB_EVENT);
		object3.put(VALEUR, nb_events);
		objectArray.put(object3);

		object.put(ID, 1);
		object.put(GLOBAL_STATS, objectArray);
		saveInFile( object, fileName , exists);
	}

	/**
	 * Save the best players in JSON file
	 * @param players
	 */
	@Override
	public void saveGlobalBestPlayersToJSON(Player[] players) {
		JSONObject object = new JSONObject();
		JSONArray objectPlayers = new JSONArray();

		boolean exists = false;
		if(ExtractJSON.readJSONFile(GLOBALBESTPLAYER_FILE) != null){
			exists = true;
		}

		int rang = 1;
		for(int i = 0 ; i < players.length ; i++){
			JSONObject player = new JSONObject();
			player.put( RANG_PLAYER, rang);
			player.put( NAME , players[i].getName());
			player.put( NB_GAME_WIN , players[i].getNbGameWin());
			player.put(NB_GAME_LOOSE, players[i].getNbGameLoose());
			objectPlayers.put(player);
			rang++;
		}
		object.put(ID, 1);
		object.put( BEST_PLAYERS , objectPlayers);
		saveInFile(object, GLOBALBESTPLAYER_FILE, exists);	
	}
	
	/**
	 * Save the best players in specific JSON file
	 * @param players
	 * @param fileName
	 */
	@Override
	public void saveGlobalBestPlayersToJSON(Player[] players, String fileName) {
		JSONObject object = new JSONObject();
		JSONArray objectPlayers = new JSONArray();

		boolean exists = false;
		if(ExtractJSON.readJSONFile(fileName) != null){
			exists = true;
		}

		int rang = 1;
		for(int i = 0 ; i < players.length ; i++){
			JSONObject player = new JSONObject();
			player.put( RANG_PLAYER, rang);
			player.put( NAME , players[i].getName());
			player.put( NB_GAME_WIN , players[i].getNbGameWin());
			player.put(NB_GAME_LOOSE, players[i].getNbGameLoose());
			objectPlayers.put(player);
			rang++;
		}
		object.put(ID, 1);
		object.put( BEST_PLAYERS , objectPlayers);
		saveInFile(object, fileName, exists);	
	}

	/**
	 * Sauvegarde les meilleures parties dans un json
	 * 
	 * @param games
	 */
	@Override
	public void saveGlobalBestGamesToJSON(Game[] games) {
		JSONObject object = new JSONObject();
		JSONArray objectGames = new JSONArray();

		boolean exists = false;
		if(ExtractJSON.readJSONFile(GLOBALBESTGAME_FILE) != null){
			exists = true;
		}

		for(int i = 0 ; i < games.length ; i++){
			JSONObject game = new JSONObject();
			game.put( RANG_GAME , i+1);
			game.put( DATE_GAME , games[i].getDate());
			game.put( EVENT , games[i].getEvent().getName());
			game.put( SCORE_GLOBAL , games[i].getScoreTotalVariation());
			objectGames.put(game);
		}
		object.put(ID, 1);
		object.put( BEST_GAMES , objectGames);
		saveInFile(object, GLOBALBESTGAME_FILE, exists);	
	}

	/**
	 * Sauvegarde les meilleures parties dans un json
	 * 
	 * @param games
	 */
	@Override
	public void saveGlobalBestGamesToJSON(Game[] games, String fileName) {
		JSONObject object = new JSONObject();
		JSONArray objectGames = new JSONArray();

		boolean exists = false;
		if(ExtractJSON.readJSONFile(fileName) != null){
			exists = true;
		}

		for(int i = 0 ; i < games.length ; i++){
			JSONObject game = new JSONObject();
			game.put( RANG_GAME , i+1);
			game.put( DATE_GAME , games[i].getDate());
			game.put( EVENT , games[i].getEvent().getName());
			game.put( SCORE_GLOBAL , games[i].getScoreTotalVariation());
			objectGames.put(game);
		}
		object.put(ID, 1);
		object.put( BEST_GAMES , objectGames);
		saveInFile(object, fileName, exists);	
	}

	/**
	 * @param position
	 * @param gameAndNextMove
	 */
	@Override
	public void saveBestFenToJSON(Map<String, GameAndNextMove[]> map_fen_GameAndNextMove_tab){

		try {
			System.out.println(PATH + RANKINGPOSITION_FILE);
			PrintWriter writer = new PrintWriter(PATH + RANKINGPOSITION_FILE, "UTF-8");

			writer.print('[');
			int n = 0;
			for(Entry<String , GameAndNextMove[]> fen_GameAndNextMove_tab : map_fen_GameAndNextMove_tab.entrySet()){
				n++;
				String position = fen_GameAndNextMove_tab.getKey();
				GameAndNextMove[] gameAndNextMove = fen_GameAndNextMove_tab.getValue();
				JSONArray objectGamesAndNextMove = new JSONArray();
				for(int i = 0 ; i < gameAndNextMove.length ; i++){
					int idGame = gameAndNextMove[i].getGameID();
					if(idGame != -1){

						JSONObject gameAndNextMoveJSON = new JSONObject();
						int score = gameAndNextMove[i].getMove().getFen().getScore();
						String positionNext = gameAndNextMove[i].getMove().getFen().getPosition();
						int idMove = gameAndNextMove[i].getMove().getNum();
						gameAndNextMoveJSON.put( ID_GAME , idGame);
						gameAndNextMoveJSON.put(ID_MOVE, idMove);
						gameAndNextMoveJSON.put( SCORE , score);
						gameAndNextMoveJSON.put( FEN_NEXT_POSITION , positionNext );
						objectGamesAndNextMove.put(gameAndNextMoveJSON);
					}
				}
				JSONObject object = new JSONObject();
				object.put(ID, position);
				object.put(NEXTS, objectGamesAndNextMove);
				
				if(n <= map_fen_GameAndNextMove_tab.size() && n != 1){
					writer.print(',');
				}

				writer.print(object);
			}


			writer.print(']');
			System.out.println("New File..");

			System.out.println("Successfully Copied JSON Object to File...");
			writer.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Sauvegarde une liste de games dans un JSON
	 * @param games
	 */
	@Override
	public void saveGames(List<Game> games) {	

		try {
			System.out.println(PATH + GAME_FILE);
			PrintWriter writer = new PrintWriter(PATH + GAME_FILE, "UTF-8");

			writer.print('[');
			Iterator<Game> it = games.iterator();
			boolean hasNext = false;
			if(it.hasNext()){
				hasNext = true;
			}
			while(hasNext){
				Game g = it.next();
				JSONObject obj = new JSONObject();

				obj.put(ID_GAME, g.getId());
				obj.put(ID_WHITE, g.getWhitePlayer().getId());
				obj.put(NAME_WHITE, g.getWhitePlayer().getName());
				obj.put(ID_BLACK, g.getBlackPlayer().getId());
				obj.put(NAME_BLACK, g.getBlackPlayer().getName());
				obj.put(EVENT_NAME, g.getEvent().getName());
				obj.put(NAME_OPENING, g.getOpening().getName());
				obj.put(ID_OPENING, g.getOpening().getId());
				obj.put(RESULT, g.getResult());
				obj.put(DATE, g.getDate());
				obj.put(PGN, g.getPGN());

				JSONArray scores = new JSONArray();
				int i = 0;
				for(Move m : g.getAlMoves()){
					JSONObject score = new JSONObject();
					score.put(ID, i);
					score.put(SCORE, m.getFen().getScore());
					scores.put(score);
					i++;
				}
				obj.put(SCORES, scores);
				writer.print(obj);
				hasNext = it.hasNext();
				if(hasNext)
					writer.print(",");
			}

			writer.print(']');
			System.out.println("New File..");

			System.out.println("Successfully Copied JSON Object to File...");
			writer.close();
		} catch (IOException e) {
		}

	}





}

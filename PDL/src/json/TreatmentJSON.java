package json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import object.ErrorPlayer;
import object.FEN;
import object.Game;
import object.Opening;
import object.Player;



public class TreatmentJSON implements ITreatmentJSON, IGlobalJSON {


	public void saveAllScoreToJSON(Game g, int score_total_variation, List<FEN> scores){	
		JSONObject game = null;
		try {
			game = ExtractJSON.getJsonGame(g.getId());
			game.remove(SCORE_TOTAL_VAR);

		} catch (IOException e) {
			// TODO : Intégrer à la classe d'erreur ? : erreur lecture json (game n'existe pas ou erreur de fichier)
			e.printStackTrace();
		}
		boolean exists = true;
		if (game == null){
			game = createGameJson(g);
			exists = false;
		}
		game.put(SCORE_TOTAL_VAR , score_total_variation);

		JSONArray scoresJson = new JSONArray();
		int nbMove = 1;
		for(FEN fen : scores){
			JSONObject score = new JSONObject();
			score.put( NUMBER_MOVE , nbMove);
			score.put( SCORE , fen.getScore());
			score.put( FEN, fen.getRawFEN());

			scoresJson.put(score);
			nbMove ++;

		}
		game.remove( SCORES );
		game.put( SCORES , scoresJson);

		saveInFile(game, GAME_FILE, exists);
	}

	// TODO : refaire fonction 
	public void saveBestFenToJSON(String pos, FEN fen){
		/*	boolean exists = false;
		JSONArray outputJSON = new JSONArray();			
		JSONObject position = new JSONObject();

		// Create a new opening in the jsonFile
		position.put("position", position);
		position.put("evol_score_global", fen.getPosition());

		outputJSON.put(position);

		// Save the rankingPosition
		saveInFile(outputJSON, RANKINGPOSITION_FILE, exists);*/
	}

	public void saveWinRateOpening(Opening o, int nbWhite, int nbBlack, int exaequo) {
		// Get the JsonObject from the game id
		JSONObject openingJson;
		try {
			openingJson = ExtractJSON.getJsonOpening(o.getId());

			boolean exists = true;
			if(openingJson == null){
				openingJson = createOpening(o);
				exists = false;
			}

			JSONObject white = new JSONObject();
			white.put(NAME, "White");
			white.put(Y, nbWhite);
			white.put(COLOR, "#F6F3EE");

			JSONObject black = new JSONObject();
			black.put(NAME, " Black");
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

			// Save the game
			saveInFile(openingJson, OPENING_FILE, exists);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Save all the players with their errors
	 * 
	 */
	public void savePlayersToJSON(List<Player> players) {
		JSONObject playerJSON;
		JSONArray errorsJSON;
		boolean exists;

		for(Player player : players) {
			playerJSON = null;
			exists = true;

			try {
				playerJSON = ExtractJSON.getJsonFilePlayer(player.getId());
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}

			if(playerJSON == null) {
				exists = false;
				playerJSON = new JSONObject();
			}

			errorsJSON = new JSONArray();
			for(ErrorPlayer error : player.getErrors()) {
				JSONObject errorJSON = new JSONObject();		
				errorJSON.put( ID_GAME , error.getIdGame());
				errorJSON.put( NB_OF_ERROR , error.getNb_of_error());
				String[] FenErrors = error.getError_fen().toArray(new String[error.getError_fen().size()]);
				errorJSON.put( ERRORS_FEN , FenErrors);

				errorsJSON.put(errorJSON);
			}
			playerJSON.put(ID, player.getId());
			playerJSON.put( NAME , player.getName());
			playerJSON.put( NB_GAME_PLAYED , player.getNb_game_played());
			playerJSON.put( NB_GAME_WIN , player.getNbGameWin());
			playerJSON.put( ERRORS , errorsJSON);

			saveInFile(playerJSON, PLAYER_FILE, exists);		
		}
	}

	public static void saveInFile(JSONObject jsonObject, String objectName, boolean exist){

		JSONArray allData;
		if (exist){
			allData = ExtractJSON.deleteJsonObject(jsonObject, objectName);
		} else {
			allData = ExtractJSON.readJSONFile(objectName);
		}

		try {
			System.out.println(PATH + objectName);
			PrintWriter writer = new PrintWriter(PATH + objectName, "UTF-8");


			// Creation d'un nouveau fichier
			writer.println("[");
			if (allData == null){

				writer.println(jsonObject.toString(1));

				System.out.println("New File..");

				// Fichier déja existant
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
			System.out.println("Successfully Copied JSON Object to File...");
			writer.close();
		} catch (IOException e) {
		}
	}

	private JSONObject createGameJson(Game g) {
		JSONObject object = new JSONObject();

		object.put( ID , g.getId());
		object.put( ID_WHITE , g.getWhitePlayer().getId());
		object.put( ID_BLACK , g.getBlackPlayer().getId());
		object.put( PGN , g.getPGN());
		object.put( EVOL_SCORE_MOVE , "");
		object.put( MOVE_AVERAGE , "");
		object.put( DATE , g.getDate());
		object.put( SCORE_TOTAL_VAR , "");
		object.put( ID_OPENING , g.getOpening().getId());
		object.put( SCORES , "");

		return object;
	}


	private JSONObject createOpening(Opening o) {
		JSONObject object = new JSONObject();

		object.put( ID , o.getId());
		object.put( NAME_OPENING, o.getName() + "-" + o.getVariation());
		object.put( NB_MOVES, o.getNbMoves());
		object.put( MOVES , o.getMoves());

		return object;
	}

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

	@Override
	public void saveGlobalBestPlayersToJSON(Player[] players) {
		JSONObject object = new JSONObject();
		JSONArray objectPlayers = new JSONArray();
		int rang = 1;
		for(int i = 0 ; i < players.length ; i++){
			JSONObject player = new JSONObject();
			player.put( RANG_PLAYER, rang);
			player.put( NAME , players[i].getName());
			player.put( NB_GAME_WIN , players[i].getNbGameWin());
			objectPlayers.put(player);
			rang++;
		}
		object.put( BEST_PLAYERS , objectPlayers);
		saveInFile(object, GLOBALBESTPLAYER_FILE, false);	
	}

	@Override
	public void saveGlobalBestGamesToJSON(Game[] games) {
		JSONObject object = new JSONObject();
		JSONArray objectGames = new JSONArray();

		for(int i = 0 ; i < games.length ; i++){
			JSONObject game = new JSONObject();
			game.put( RANG_GAME , i+1);
			game.put( DATE_GAME , games[i].getDate());
			game.put( EVENT , games[i].getEvent().getName());
			game.put( SCORE_GLOBAL , games[i].getScoreTotalVariation());
			objectGames.put(game);
		}
		object.put( BEST_GAMES , objectGames);
		saveInFile(object, GLOBALBESTGAME_FILE, false);	

	}




}

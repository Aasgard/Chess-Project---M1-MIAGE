package json;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.*;
import object.*;


public class ExtractJSON implements IGlobalJSON{

	public static FEN extractFENAfterMove(Move m){
		// TODO extractFENAfterMove
		return null;
	}


	/**
	 * Create an Object game from the Json File
	 * @param idGame
	 * @return
	 * @throws IOException 
	 */
	public static Game getGame(int idGame) throws IOException{
		JSONArray gamesArray = readJSONFile( GAME_FILE );
		if(gamesArray == null){
			gamesArray = new JSONArray();
		}

		for(int i = 0; i < gamesArray.length(); i++) {
			JSONObject gameObject = gamesArray.getJSONObject(i);

			if (idGame == gameObject.getInt( ID )){
				Player whitePlayer = new Player(gameObject.getInt( ID_WHITE ));
				Player blackPlayer = new Player(gameObject.getInt( ID_BLACK ));
				String date = gameObject.getString( DATE );
				int inconnu = 0;
				List<Move> allMoves = null;
				String pgn = "";
				int score_total_variation = 0;

				Game game = new Game(idGame, allMoves, whitePlayer, blackPlayer, null, null, inconnu, date, inconnu, inconnu, pgn, score_total_variation );
				return game;
			}
		}
		return null;
	}

	public static JSONArray deleteJsonObject(JSONObject myJsonObject, String objectName){
		JSONArray jsonArray = readJSONFile(objectName);

		if(!myJsonObject.toString().equals("{}")) {
			int i = 0;
			boolean find = false;
			while (i < jsonArray.length() && !find){
				JSONObject gameObject = jsonArray.getJSONObject(i);
				if (gameObject.get(ID).equals(myJsonObject.get(ID))){
					jsonArray.remove(i);
					find = true;
				}
			}
		}
		return jsonArray;
	}

	public static JSONArray readJSONFile(String objectName){

		String result = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(PATH + objectName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		JSONArray jsonArray = null;

		if (!result.isEmpty()){
			jsonArray= new JSONArray(result);
		}
		return jsonArray;
	}



	/**
	 * Read the Json Object to find the game with this id
	 * @param idGame
	 * @return JsonObject Game or NULL
	 * @throws IOException
	 */
	public static JSONObject getJsonGame(int idGame){
		JSONArray gamesArray = readJSONFile( GAME_FILE );

		JSONObject gameFind = null;

		if (gamesArray == null){
			gamesArray = new JSONArray();
		}

		int i = 0;
		boolean find = false;
		while(i< gamesArray.length() && !find){
			JSONObject gameObject = gamesArray.getJSONObject(i);

			if(gameObject.get(ID).equals(idGame)){
				find = true;
				gameFind = gameObject;
			}
			i++;
		}		
		return gameFind;
	}

	/**
	 * Read the Json Object to find the opening with this id
	 * @param idOpening
	 * @return JsonObject Opening or NULL
	 * @throws IOException
	 */
	public static JSONObject getJsonOpening(int idOpening) throws IOException{
		JSONArray openingArray = readJSONFile( OPENING_FILE );

		JSONObject openingFind = null;

		if (openingArray == null){
			openingArray = new JSONArray();
		}

		int i = 0;
		boolean find = false;
		while(i< openingArray.length() && !find){
			JSONObject openingObject = openingArray.getJSONObject(i);

			if(openingObject.get(ID).equals(idOpening)){
				find = true;
				openingFind = openingObject;
			}
			i++;
		}		
		return openingFind;
	}


	/**
	 * Read the Json Object to find the opening with this id
	 * 
	 * @param position
	 * @return
	 * @throws IOException
	 */
	public static JSONObject getJsonPosition(String position){

		JSONArray positionArray = readJSONFile( RANKINGPOSITION_FILE );

		JSONObject positionFind = null;

		if (positionArray == null){
			positionArray = new JSONArray();
		}

		int i = 0;
		boolean find = false;
		while(i< positionArray.length() && !find){
			JSONObject positionObject = positionArray.getJSONObject(i);

			if(positionObject.get(ID).equals(position)){
				find = true;
				positionFind = positionObject;
			}
			i++;
		}		
		return positionFind;
	}

	public static Player getJsonPlayer(int idPlayer) throws IOException{
		JSONArray playersArray = readJSONFile( PLAYER_FILE );
		Player player = null;
		for(int i = 0; i < playersArray.length(); i++) {
			JSONObject playerObject = playersArray.getJSONObject(i);

			if (idPlayer == playerObject.getInt( ID )){
				String name = playerObject.getString( NAME );
				List<ErrorPlayer> errors = new ArrayList<ErrorPlayer>();
				JSONArray errorsArray = playerObject.getJSONArray( ERRORS );
				for(int j = 0; j < errorsArray.length() ; j++){
					JSONObject errorObject = errorsArray.getJSONObject(j);
					int idgame = errorObject.getInt( ID_GAME );
					int nb_of_error = errorObject.getInt( NB_OF_ERROR );
					List<String> errorfen = new ArrayList<String>();
					JSONArray errorfenArray = errorObject.getJSONArray( ERRORS_FEN );
					for(int k = 0; k<errorfenArray.length(); k++){
						errorfen.add(errorfenArray.getString(k));
					}
					ErrorPlayer ep = new ErrorPlayer(idgame, nb_of_error, errorfen);
					errors.add(ep);
				}
				int nb_game_played = playerObject.getInt( NB_GAME_PLAYED );
				int nb_win = playerObject.getInt( NB_GAME_WIN );

				player = new Player();
				player.setId(idPlayer);
				player.setName(name);
				player.setErrors(errors);
				player.setNb_game_played(nb_game_played);
				player.setNbGameWin(nb_win);

			}
		}
		return player;
	}

	public static JSONObject getJsonFilePlayer(int idPlayer) throws IOException {
		JSONArray playersArray = readJSONFile( PLAYER_FILE );

		if(playersArray == null){
			playersArray = new JSONArray();
		}
		for(int i = 0; i < playersArray.length(); i++) {
			JSONObject playerObject = playersArray.getJSONObject(i);

			if(idPlayer == playerObject.getInt(ID)) {
				return playerObject;
			}
		}

		return null;
	}


	public static JSONObject getJsonOpening(String position) {
		// TODO Auto-generated method stub
		return null;
	}
}
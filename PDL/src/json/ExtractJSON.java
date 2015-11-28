package json;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.*;
import object.*;


public class ExtractJSON implements IGlobalJSON{

	public ExtractJSON() {
	}

	public FEN extractFENAfterMove(Move m){
		// TODO extractFENAfterMove
		return null;
	}


	/**
	 * Create an Object game from the Json File
	 * @param idGame
	 * @return
	 * @throws IOException 
	 */
	public Game getGame(int idGame) throws IOException{
		JSONArray gamesArray = readJSONFile( GAME_FILE );

		for(int i = 0; i < gamesArray.length(); i++) {
			JSONObject gameObject = gamesArray.getJSONObject(i);
			
			if (idGame == gameObject.getInt( ID )){
				Player whitePlayer = new Player(gameObject.getInt( ID_WHITE ));
				Player blackPlayer = new Player(gameObject.getInt( ID_BLACK ));
				String date = gameObject.getString( DATE );
				int inconnu = 0;
				List<Move> allMoves = null;
				String pgn = "";
				double score_total_variation = 0;
			
				Game game = new Game(idGame, allMoves, whitePlayer, blackPlayer, null, null, inconnu, date, inconnu, inconnu, pgn, score_total_variation );
				return game;
			}
		}
		return null;
	}

	public static JSONArray deleteJsonObject(JSONObject myJsonObject, String objectName){
		JSONArray jsonArray = readJSONFile(objectName);

		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject gameObject = jsonArray.getJSONObject(i);
			if (gameObject.getInt("id") == myJsonObject.getInt("id")){
				jsonArray.remove(i);
				break;
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

		if (result.isEmpty()){
			return null;
		}else{
			JSONArray jsonArray = new JSONArray(result);
			return jsonArray;
		}
	}



	/**
	 * Read the Json Object to find the game with this id
	 * @param idGame
	 * @return JsonObject Game or NULL
	 * @throws IOException
	 */
	public JSONObject getJsonGame(int idGame) throws IOException{
		// TODO getJsonGame
		return null;
	}

	/**
	 * Read the Json Object to find the opening with this id
	 * @param idOpening
	 * @return JsonObject Opening or NULL
	 * @throws IOException
	 */
	public JSONObject getJsonOpening(int idOpening) throws IOException{
		// TODO getJsonOpening
		return null;
	}
	
	public Player getJsonPlayer(int idPlayer) throws IOException{
		JSONArray playersArray = readJSONFile( PLAYER_FILE );

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
					JSONArray errorfenArray = errorObject.getJSONArray( ERROR_FEN );
					for(int k = 0; k<errorfenArray.length(); k++){
						errorfen.add(errorfenArray.getString(k));
					}
					ErrorPlayer ep = new ErrorPlayer(idgame, nb_of_error, errorfen);
					errors.add(ep);
				}
				int nb_game_played = playerObject.getInt( NB_GAME_PLAYED );
				int nb_win = playerObject.getInt( NB_GAME_WIN );
			
				Player player = new Player();
				player.setId(idPlayer);
				player.setName(name);
				player.setErrors(errors);
				player.setNb_game_played(nb_game_played);
				player.setNbGameWin(nb_win);
				
				return player;
			}
		}
		return null;
	}
}
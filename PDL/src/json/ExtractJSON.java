package json;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.json.*;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.json.JSONObject;

import object.Move;

import object.Game;
import object.Opening;
import object.Player;
import object.FEN;


public class ExtractJSON implements GlobalJSON{

	public ExtractJSON() {
	}

	public boolean isGameExiste(int idGame) {

		return false;
	}
	public boolean isGameExiste(Game g) {
		
		return false;
	}

	public boolean isOpeningExiste(Opening o) {
		// TODO Verifier dans le fichier
		return false;
	}

	public boolean isPlayerExiste(Player p) {
		// TODO Verifier dans le fichier
		return false;
	}

	public HashMap<Integer, List<Integer>> extractScoresGames(){
		//TODO
		return new HashMap<Integer, List<Integer>>();
	}

	public FEN extractFENAfterMove(Move m){
		FEN fen = new FEN("null", null);
		return fen;
	}


	/**
	 * Create an Object game from the Json File
	 * @param idGame
	 * @return
	 * @throws IOException 
	 */
	public Game getGame(int idGame) throws IOException{
		JsonArray gamesArray = readJSONFile(GlobalJSON.GAME_FILE);
		
		for (JsonValue gameJsonValue : gamesArray) {
			JsonObject gameObject = (JsonObject)gameJsonValue;
			if (idGame == gameObject.getInt("id")){
				Game game = new Game();
				game.setId(gameObject.getInt("id"));
				game.setWhitePlayer(new Player(gameObject.getInt("id_white")));
				game.setBlackPlayer(new Player(gameObject.getInt("id_black")));
				game.setDate(gameObject.getString("date"));
				return game;
			}
		}
		return null;
	}

	/**
	 * Read the Json Object to find the game with this id
	 * @param idGame
	 * @return JsonObject Game or NULL
	 * @throws IOException
	 */
	public JsonObject getJsonGame(int idGame) throws IOException{
		JsonArray gamesArray = readJSONFile(GlobalJSON.GAME_FILE);

		for (JsonValue game : gamesArray) {
			JsonObject gameObject = (JsonObject)game;
			if (idGame == gameObject.getInt("id")){
				return gameObject;
			}
		}

		return null;
	}


	/**
	 * Remove a game to the Json file
	 * @param JsonObjectGame
	 * @throws IOException
	 */
	public void deleteJsonGame(JsonObject JsonObjectGame) throws IOException{
		JsonArray jsonArrayAll = readJSONFile(GlobalJSON.GAME_FILE);

		jsonArrayAll.remove(JsonObjectGame);

		JsonArrayBuilder gamesBuilder = Json.createArrayBuilder();
		JsonArray jsonArray = gamesBuilder.build();
		// Write in the file
		writeJSONFile(jsonArray, GlobalJSON.GAME_FILE);
	}

	/**
	 * Get the Json file 
	 * @param objectName
	 * @return
	 * @throws IOException
	 */
	private JsonArray readJSONFile(String objectName) throws IOException{

		InputStream file = new FileInputStream(GlobalJSON.PATH + objectName);

		JsonReader jsonReader = Json.createReader(file);
		JsonArray jsonArray = jsonReader.readArray();

		jsonReader.close();
		file.close();

		return jsonArray;		
	}

	/**
	 * Write the new file 
	 * @param jsonArray
	 * @param objectName
	 * @throws FileNotFoundException
	 */
	public void writeJSONFile(JsonArray jsonArray, String objectName) throws FileNotFoundException{
		OutputStream os = new FileOutputStream(GlobalJSON.PATH + objectName);
		JsonWriter jsonWriter = Json.createWriter(os);

		jsonWriter.writeArray(jsonArray);
		jsonWriter.close();
	}
}
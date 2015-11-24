package json;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.json.*;
import javax.json.Json;
import javax.json.stream.JsonParser;


import org.json.JSONObject;

import object.Move;

import object.Game;
import object.Opening;
import object.Player;
import object.FEN;


public class ExtractJSON {

	public ExtractJSON() {
	}

<<<<<<< HEAD
	public boolean isGameExiste(int idGame) {
=======
	public boolean isGameExiste(Game g) {
		String file = readJSONFile(GlobalJSON.GAME_FILE);
		
		JSONObject jsonObj = new JSONObject(file);
		
		
		//ouvre / lire le fichier
		//check la cle
		// TODO Verifier dans le fichier
>>>>>>> branch 'master' of https://github.com/Aasgard/Chess-Project---M1-MIAGE.git
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
<<<<<<< HEAD

	public FEN extractFenAfterMove(Move m){
=======
	
	public FEN extractFENAfterMove(Move m){
>>>>>>> branch 'master' of https://github.com/Aasgard/Chess-Project---M1-MIAGE.git
		FEN fen = new FEN("null");
		return fen;
	}
<<<<<<< HEAD

	
	/**
	 * Create an Object game from the Json File
	 * @param idGame
	 * @return
	 * @throws IOException 
	 */
	public Game getGame(int idGame) throws IOException{
		InputStream file = new FileInputStream("D:/wamp/www/PDL Website/json/");

		JsonReader jsonReader = Json.createReader(file);
		JsonObject jsonObject = jsonReader.readObject();

		jsonReader.close();
		file.close();
		
		JsonArray gameArray = jsonObject.getJsonArray("game");
		
		for(JsonValue value : gameArray){
			JsonObject innerJsonObject = jsonObject.getJsonObject(value.toString());

			if (idGame == innerJsonObject.getInt("id")){
				Game game = new Game();
				game.setId(innerJsonObject.getInt("id"));
				game.setWhitePlayer(new Player(innerJsonObject.getInt("id_white")));
				game.setBlackPlayer(new Player(innerJsonObject.getInt("id_black")));
				game.setDate(innerJsonObject.getString("date"));
				return game;
			}
		}
		return null;
	}
	
	
	public JsonObject getJsonGame(int idGame) throws IOException{
		InputStream file = new FileInputStream("D:/wamp/www/PDL Website/json/");

		JsonReader jsonReader = Json.createReader(file);
		JsonObject jsonObject = jsonReader.readObject();

		jsonReader.close();
		file.close();
		
		JsonArray gameArray = jsonObject.getJsonArray("game");
		
		for(JsonValue value : gameArray){
			JsonObject innerJsonObject = jsonObject.getJsonObject(value.toString());

			if (idGame == innerJsonObject.getInt("id")){
				return innerJsonObject;
			}
		}
		return null;
=======
	
	private String readJSONFile(String objectName){
		
		return null;
		
>>>>>>> branch 'master' of https://github.com/Aasgard/Chess-Project---M1-MIAGE.git
	}
}
package unitTests;

import java.io.FileWriter;

import javax.annotation.processing.ProcessingEnvironment;

import org.json.JSONArray;
import org.json.JSONObject;

import json.ExtractJSON;
import object.Game;
import object.GameAndNextMove;
import object.Player;

public class UtilsTests {

	/**
	 * Compare deux JSONArray
	 * @param jsonArray1
	 * @param jsonArray2
	 * @return Boolean
	 */
	public static boolean jsonArrayEquals(JSONArray jsonArray1, JSONArray jsonArray2) {
		if(jsonArray1.length() == jsonArray2.length()) {
			for(int i=0; i < jsonArray1.length(); i++) {
				JSONObject jsonObj1 = jsonArray1.getJSONObject(i);
				JSONObject jsonObj2 = jsonArray2.getJSONObject(i);
				
				String sobj1 = jsonObj1.toString();
				String sobj2 = jsonObj2.toString();
				if(!sobj1.equals(sobj2)) {
					return false;
				}	
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Test si un JSONArray contient un JSONObject donné
	 * @param jsonArray
	 * @param jsonObject
	 * @return
	 */
	public static boolean jsonArrayContains(JSONArray jsonArray, JSONObject jsonObject) {
		for(int i=0; i < jsonArray.length(); i++) {
			JSONObject jsonObjArray = jsonArray.getJSONObject(i);
			String sobj1 = jsonObjArray.toString();
			String sobj2 = jsonObject.toString();
			if(sobj1.equals(sobj2)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Test si un JSONArray contient une game donnée selon son rang
	 * @param jsonArray
	 * @param game
	 * @return bool
	 */
	public static boolean jsonArrayContainsGame(JSONArray jsonArray, Game game, int rang) {
		boolean isInJson = false;
		JSONObject jsonObj = jsonArray.getJSONObject(0);
		JSONArray bestGameArray = (JSONArray) jsonObj.get("best_games");
		
		System.out.println(bestGameArray.toString());

		for(int i=0; i < bestGameArray.length(); i++) {
			JSONObject jsonObjTemp = bestGameArray.getJSONObject(i);
			
			if((int)jsonObjTemp.get("rang") == rang) {
				isInJson = true;
				
				if(
						(int)jsonObjTemp.get("score global") != game.getScoreTotalVariation() ||
						!jsonObjTemp.get("date").equals(game.getDate()) ||
						!jsonObjTemp.get("evenement").equals(game.getEvent().getName())
					) {
					return false;
				}
			}
		}
		if(!isInJson) {
			return false;
		}
		return true;
	}
	
	/**
	 * Test si un JSONArray contient un player donné selon son rang
	 * @param jsonArray
	 * @param game
	 * @return bool
	 */
	public static boolean jsonArrayContainsPlayer(JSONArray jsonArray, Player player, int rang) {
		boolean isInJson = false;
		JSONObject jsonObj = jsonArray.getJSONObject(0);
		JSONArray bestGameArray = (JSONArray) jsonObj.get("best_players");

		for(int i=0; i < bestGameArray.length(); i++) {
			JSONObject jsonObjTemp = bestGameArray.getJSONObject(i);
			
			if((int)jsonObjTemp.get("rang") == rang) {
				isInJson = true;
				
				if(
						(int)jsonObjTemp.get("nb_games_loose") != player.getNbGameLoose() ||
						!jsonObjTemp.get("name").equals(player.getName()) ||
						!jsonObjTemp.get("nb_games_win").equals(player.getNbGameWin())
					) {
					return false;
				}
			}
		}
		if(!isInJson) {
			return false;
		}
		return true;
	}
	
	/**
	 * Test si le jsonArray de GlobalStats est bon
	 * @param jsonArray
	 */
	public static boolean testJsonArrayGlobalStats(JSONArray jsonArray) {
		JSONObject jsonObj = jsonArray.getJSONObject(0);
		JSONArray bestGameArray = (JSONArray) jsonObj.get("global_stats");

		for(int i=0; i < bestGameArray.length(); i++) {
			JSONObject jsonObjTemp = bestGameArray.getJSONObject(i);
			
			if(!jsonObjTemp.has("valeur") || !jsonObjTemp.has("libelle")){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Supprime le contenu d'un json
	 * @param fileName
	 */
	public static void deleteContentJSON(String fileName) {
		System.out.println(fileName);
    	try{   		
    		FileWriter file = new FileWriter(fileName);	
    		file.flush();
    	}catch(Exception e){ 		
    		e.printStackTrace();   		
    	}
	}
	
	public static boolean rightOrderBestMoves(GameAndNextMove tableaubest_GameAndNextMove[]) {
		for(int i=1; i < tableaubest_GameAndNextMove.length; i++) {
			GameAndNextMove prevMove = tableaubest_GameAndNextMove[i-1];
			GameAndNextMove nextMove = tableaubest_GameAndNextMove[i];
			
			if(prevMove.getMove().getFen().getScore() < nextMove.getMove().getFen().getScore()) {
				return false;
			}
		}
		return true;
	}
	
	public static void deleteJsonObjectFromFile(JSONObject jsonObject, String objectName) {
		JSONArray jsonArray = ExtractJSON.deleteJsonObject(jsonObject, objectName);
		
		JSONObject newJson = new JSONObject();
		
	}
	
}

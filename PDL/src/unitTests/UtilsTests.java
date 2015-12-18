package unitTests;

import org.json.JSONArray;
import org.json.JSONObject;

import json.ExtractJSON;
import object.Game;

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
	 * Test si un JSONArray contient une game donnée
	 * @param jsonArray
	 * @param game
	 * @return
	 */
	public static boolean jsonArrayContainsGame(JSONArray jsonArray, Game game, int rang) {
		boolean isInJson = false;
		JSONObject jsonObj = jsonArray.getJSONObject(0);
		JSONArray bestGameArray = (JSONArray) jsonObj.get("best_games");
		
		System.out.println(bestGameArray.toString());

		for(int i=0; i < bestGameArray.length(); i++) {
			JSONObject jsonObjTemp = jsonArray.getJSONObject(i);
			
			if((int)jsonObj.get("rang") == rang) {
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
	
	public static void deleteJsonObjectFromFile(JSONObject jsonObject, String objectName) {
		JSONArray jsonArray = ExtractJSON.deleteJsonObject(jsonObject, objectName);
		
		JSONObject newJson = new JSONObject();
		
	}
	
}

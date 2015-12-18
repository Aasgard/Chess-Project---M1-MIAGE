package json;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.*;

public class ExtractJSON implements IGlobalJSON{


	/**
	 * Retourne un JSONArray qui ne contient pas le myJsonObject
	 * 
	 * @param myJsonObject
	 * @param objectName
	 * @return
	 */
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
				i++;
			}
		}
		return jsonArray;
	}

	/**
	 * Retourne le JSONArray du fichier objectName
	 * 
	 * @param objectName
	 * @return
	 */
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
}
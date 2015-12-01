package unitTests;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
}

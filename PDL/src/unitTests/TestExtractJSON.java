package unitTests;

import static org.junit.Assert.*;
import static json.IGlobalJSON.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import json.ExtractJSON;

public class TestExtractJSON {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test de suppression d'un JSONObject dans un fichier
	 */
	@Test
	public void testdeleteJsonObject() {
		JSONObject jsonObj = new JSONObject();
		String fileName = "baseTest.json";
		
		jsonObj.put("id", 1);
		
		JSONArray jsonArray = ExtractJSON.deleteJsonObject(jsonObj, PATH_TEST_CORRIGE + fileName);
		
		assertFalse(jsonArrayContains(jsonArray, jsonObj));
	}

	/**
	 * Test de lecture d'un fichier existant
	 */
	@Test
	public void testreadJSONFile1() {
		String fileName = "baseTest.json";
		JSONObject jsonObj1 = new JSONObject();
		JSONObject jsonObj2 = new JSONObject();
		
		jsonObj1.put("id", 1);
		jsonObj1.put("attr1", "test attr1");
		jsonObj1.put("attr2", 2);
		
		jsonObj2.put("id", 2);
		jsonObj2.put("attr1", "test attr1");
		jsonObj2.put("attr2", 2);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(jsonObj1);
		jsonArray.put(jsonObj2);
		
		JSONArray jsonArrayRes = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		assertTrue(jsonArrayEquals(jsonArray, jsonArrayRes));
	}
	
	/**
	 * Test de lecture d'un fichier non existant
	 */
	@Test
	public void testreadJSONFile2() {
		String fileName = "not.json";
		JSONArray jsonArrayRes = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		assertNull(jsonArrayRes);
	}
	
	/**
	 * Compare deux JSONArray
	 * @param jsonArray1
	 * @param jsonArray2
	 * @return Boolean
	 */
	public boolean jsonArrayEquals(JSONArray jsonArray1, JSONArray jsonArray2) {
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
	public boolean jsonArrayContains(JSONArray jsonArray, JSONObject jsonObject) {
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

package unitTests;

import static org.junit.Assert.*;
import static json.IGlobalJSON.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import json.ExtractJSON;
import unitTests.UtilsTests;;

public class TestExtractJSON {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test de suppression d'un JSONObject dans un fichier existant
	 */
	@Test
	public void testdeleteJsonObject1() {
		// variables utilisées dans deleteJsonObject
		JSONObject jsonObj = new JSONObject();
		String fileName = "baseTest.json";
		
		// remplissage du jsonObj
		jsonObj.put("id", 1);
		
		// suppression du jsonObj dans le fichier
		JSONArray jsonArray = ExtractJSON.deleteJsonObject(jsonObj, PATH_TEST_CORRIGE + fileName);
		
		// test si le jsonArray ne contient plus le jsonObj
		assertFalse(UtilsTests.jsonArrayContains(jsonArray, jsonObj));
	}
	
	/**
	 * Test de suppression d'un JSONObject vide dans un fichier existant
	 */
	@Test
	public void testdeleteJsonObject2() {
		// variables utilisées dans deleteJsonObject
		JSONObject jsonObj = new JSONObject();
		String fileName = "baseTest.json";
		
		// suppression du jsonObj dans le fichier
		JSONArray jsonArray = ExtractJSON.deleteJsonObject(jsonObj, PATH_TEST_CORRIGE + fileName);
		
		// test si le jsonArray ne contient pas le jsonObj
		assertFalse(UtilsTests.jsonArrayContains(jsonArray, jsonObj));
	}
	
	/**
	 * Test de suppression d'un JSONObject vide dans un fichier inexistant
	 */
	@Test
	public void testdeleteJsonObject3() {
		// variables utilisées dans deleteJsonObject
		JSONObject jsonObj = new JSONObject();
		String fileName = "not.json";
		
		// suppression du jsonObj dans le fichier
		JSONArray jsonArray = ExtractJSON.deleteJsonObject(jsonObj, PATH_TEST_CORRIGE + fileName);
		
		// test si le jsonArray est null
		assertNull(jsonArray);
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
		
		assertTrue(UtilsTests.jsonArrayEquals(jsonArray, jsonArrayRes));
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
	
}

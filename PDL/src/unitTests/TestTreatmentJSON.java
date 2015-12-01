package unitTests;

import static org.junit.Assert.*;
import static json.IGlobalJSON.*;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import json.ExtractJSON;
import json.TreatmentJSON;

public class TestTreatmentJSON {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * Save JSONObject dans un fichier existant
	 */
	@Test
	public void testsaveInFile1() {
		JSONObject jsonObj = new JSONObject();
		String fileName = "treatmentJSONTest.json";
		boolean exists = true;
		
		jsonObj.put("id", 3);
		jsonObj.put("attr1", "test attr1");
		jsonObj.put("attr2", 2);
		
		TreatmentJSON.saveInFile(jsonObj, PATH_TEST_CORRIGE + fileName, exists);
		
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObjFor = jsonArray.getJSONObject(i);
			if (jsonObjFor.getInt("id") == jsonObj.getInt("id")){
				String sobj1 = jsonObjFor.toString();
				String sobj2 = jsonObj.toString();
				System.out.println(sobj1);
				System.out.println(sobj2);
				assertTrue(sobj1.equals(sobj2));
			}
		}
	}
	
	/**
	 * Save JSONObject dans un fichier inexistant
	 */
	@Test
	public void testsaveInFile2() {
		JSONObject jsonObj = new JSONObject();
		String fileName = "treatmentJSONTest2.json";
		boolean exists = false;
		
		jsonObj.put("id", 3);
		jsonObj.put("attr1", "test attr1");
		jsonObj.put("attr2", 2);
		
		TreatmentJSON.saveInFile(jsonObj, PATH_TEST_CORRIGE + fileName, exists);
		
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObjFor = jsonArray.getJSONObject(i);
			if (jsonObjFor.getInt("id") == jsonObj.getInt("id")){
				String sobj1 = jsonObjFor.toString();
				String sobj2 = jsonObj.toString();
				assertTrue(sobj1.equals(sobj2));
			}
		}
		
		// suppression du fichier créé
    	try{   		
    		File file = new File(PATH_TEST + fileName);	
    		file.delete();  	   
    	}catch(Exception e){ 		
    		e.printStackTrace();   		
    	}
	}

	@Test
	public void testsaveGlobalBestGamesToJSON() {
		fail("Not yet implemented");
	}
}

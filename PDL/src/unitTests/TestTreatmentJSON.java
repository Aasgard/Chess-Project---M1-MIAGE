package unitTests;

import static org.junit.Assert.*;
import static json.IGlobalJSON.*;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import json.ExtractJSON;
import json.TreatmentJSON;
import unitTests.UtilsTests;;

public class TestTreatmentJSON {
	
	/**
	 * Save JSONObject dans un fichier existant
	 */
	@Test
	public void testsaveInFile1() {
		// variables utilisées dans saveInFile
		JSONObject jsonObj = new JSONObject();
		String fileName = "treatmentJSONTest.json";
		boolean exists = true;
		
		// remplissage du jsonObj
		jsonObj.put("id", 3);
		jsonObj.put("attr1", "test attr1");
		jsonObj.put("attr2", 2);
		
		// sauvegarde du jsonObj dans le fichier
		System.out.println(PATH_TEST_CORRIGE + fileName);
		TreatmentJSON.saveInFile(jsonObj, PATH_TEST_CORRIGE + fileName, exists);
		System.out.println("out saveInFile");
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		// test si le jsonArray contient le jsonObj
		assertTrue(UtilsTests.jsonArrayContains(jsonArray, jsonObj));
	}
	
	/**
	 * Save JSONObject dans un fichier inexistant
	 */
	@Test
	public void testsaveInFile2() {
		// variables utilisées dans saveInFile
		JSONObject jsonObj = new JSONObject();
		// fichier non existant
		String fileName = "treatmentJSONTest2.json";
		boolean exists = false;
		
		// remplissage du jsonObj
		jsonObj.put("id", 3);
		jsonObj.put("attr1", "test attr1");
		jsonObj.put("attr2", 2);
		
		// sauvegarde du jsonObj dans le fichier
		TreatmentJSON.saveInFile(jsonObj, PATH_TEST_CORRIGE + fileName, exists);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		// test si le jsonArray contient le jsonObj
		assertTrue(UtilsTests.jsonArrayContains(jsonArray, jsonObj));
		
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

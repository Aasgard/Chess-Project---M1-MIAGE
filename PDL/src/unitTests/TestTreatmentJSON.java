package unitTests;

import static org.junit.Assert.*;
import static json.IGlobalJSON.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import json.ExtractJSON;
import json.ITreatmentJSON;
import json.TreatmentJSON;
import object.Event;
import object.FEN;
import object.Game;
import object.Move;
import unitTests.UtilsTests;;

public class TestTreatmentJSON {

	// For testSaveInFile
	private static JSONObject jsonObj = new JSONObject();
	// For testsaveGlobalBestGamesToJSON
	private static Game[] games = {new Game(), new Game(), new Game()};
	
	private static ITreatmentJSON treatmentJSON = new TreatmentJSON();
	
	@BeforeClass
	public static void setUp() {
		// Create JSONObject
		jsonObj.put("id", 3);
		jsonObj.put("attr1", "test attr1");
		jsonObj.put("attr2", 2);
		
		Event event = new Event(1, "Tournoi", "Rennes");
		for(int i=1; i <= 3; i++) {
			games[i-1].setDate("2015-0" + i + "-20");
			games[i-1].setEvent(event);
			games[i-1].setScoreTotalVariation(i+1000);
		}
	}
	
	/**
	 * Save JSONObject dans un fichier existant
	 * JSONObject non présent
	 */
	@Test
	public void testsaveInFile1() {
		// variables utilisées dans saveInFile
		String fileName = "treatmentJSONTest.json";
		boolean exists = false;
		
		// sauvegarde du jsonObj dans le fichier
		TreatmentJSON.saveInFile(jsonObj, PATH_TEST_CORRIGE + fileName, exists);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		// test si le jsonArray contient le jsonObj
		assertTrue(UtilsTests.jsonArrayContains(jsonArray, jsonObj));
		
		// suppression du contenu du fichier
    	try{   		
    		FileWriter file = new FileWriter(PATH_TEST + fileName);	
    		file.flush();
    	}catch(Exception e){ 		
    		e.printStackTrace();   		
    	}
	}
	
	/**
	 * Save JSONObject dans un fichier existant
	 * JSONObject déjà présent
	 */
	@Test
	public void testsaveInFile2() {
		// variables utilisées dans saveInFile
		String fileName = "treatmentJSONTest2.json";
		boolean exists = true;
		
		// sauvegarde du jsonObj dans le fichier
		TreatmentJSON.saveInFile(jsonObj, PATH_TEST_CORRIGE + fileName, exists);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		// test si le jsonArray contient le jsonObj
		assertTrue(UtilsTests.jsonArrayContains(jsonArray, jsonObj));
		
		// suppression du contenu du fichier
    	try{   		
    		FileWriter file = new FileWriter(PATH_TEST + fileName);	
    		file.flush();
    	}catch(Exception e){ 		
    		e.printStackTrace();   		
    	}
	}
	
	/**
	 * Save JSONObject dans un fichier inexistant
	 */
	@Test
	public void testsaveInFile3() {
		// variables utilisées dans saveInFile
		// fichier non existant
		String fileName = "treatmentJSONTest3.json";
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

	/**
	 * Test save BestGames
	 */
	@Test
	public void testsaveGlobalBestGamesToJSON() {
		
		String fileName = "bestGameTest.json";
		
		// appel de la méthode testée
		treatmentJSON.saveGlobalBestGamesToJSON(games, PATH_TEST_CORRIGE + fileName);
		
		// récupération du fichier dans un jsonArray
		JSONArray jsonArray = ExtractJSON.readJSONFile(PATH_TEST_CORRIGE + fileName);
		
		// test si les games on bien été ajoutés
		assertTrue(UtilsTests.jsonArrayContainsGame(jsonArray, games[0], 1));
		assertTrue(UtilsTests.jsonArrayContainsGame(jsonArray, games[1], 2));
		assertTrue(UtilsTests.jsonArrayContainsGame(jsonArray, games[2], 3));
		
		// suppression du contenu du fichier
    	try{   		
    		FileWriter file = new FileWriter(PATH_TEST + fileName);	
    		file.flush();
    	}catch(Exception e){ 		
    		e.printStackTrace();   		
    	}
		
	}
}

package unitTests;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import json.ExtractJSON;
import json.TreatmentJSON;
import tests.*;

public class TestTreatmentJSON {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testsaveInFile1() {
		JSONObject jsonObj = new JSONObject();
		String fileName = "Tests/baseTest.json";
		boolean exists = true;
		
		jsonObj.put("id", 3);
		jsonObj.put("attr1", "test attr1");
		jsonObj.put("attr2", 2);
		
		TreatmentJSON.saveInFile(jsonObj, fileName, exists);
		
		JSONArray jsonArray = ExtractJSON.readJSONFile(fileName);
		
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

	@Test
	public void testsaveGlobalBestGamesToJSON() {
		fail("Not yet implemented");
	}
}

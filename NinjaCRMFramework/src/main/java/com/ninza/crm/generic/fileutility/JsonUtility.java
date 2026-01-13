package com.ninza.crm.generic.fileutility;

import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String Key) throws Throwable,ParseException {
		FileReader fr = new FileReader("./src/test/resources/commondata.json");
		JSONParser parser = new JSONParser();
		Object javaObj = parser.parse(fr);
		JSONObject jObj = (JSONObject) javaObj;
		String value = jObj.get(Key).toString();
		return value;
	}

}

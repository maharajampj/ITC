package com.createCombination;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.utilities.readFile;

public class magic2 {

	static JsonArray x=new JsonArray();
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		readFile read=new readFile();
		JsonObject obj=read.readJson("testData.json");
		
		System.out.println(obj);
	}
	
	void createObject(JsonObject obj)
	{
		
	}
		

}

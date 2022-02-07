package com.createCombination;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.utilities.readFile;

public class magic {

	static JsonArray x=new JsonArray();
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		readFile read=new readFile();
		JsonObject obj=read.readJson("testData.json");
		System.out.println(obj);
		int sizeObj=obj.size();
		System.out.println("<==========================================>");
		createObject(obj);
		System.out.println(x);
	}
	
	public static void createObject(JsonObject obj)
	{
		JsonObject object=new JsonObject();
		Gson gson=new Gson();
		for(Map.Entry<String, JsonElement> map:obj.entrySet())
		{
			List<String> data=gson.fromJson(map.getValue(), List.class);
			if((data.size()>1))
			{
						
				for(int i=0;i<data.size();i++)
				{
				object.addProperty(map.getKey(), data.get(i));
				obj.get(map.getKey()).getAsJsonArray().remove(0);
				//obj.remove(map.getKey());
				createObject(obj);
				}
				
			}
			else
			{
				object.addProperty(map.getKey(), data.get(0));
			}
			
			x.add(object) ;
		}


		
	}

}

package com.utilities;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class writeFile
{
	
	public void writeJson(JsonArray obj,String path) throws IOException
	  {
		  FileWriter file=new FileWriter(System.getProperty("user.dir")+"//src//main//resources//data//"+path);
		  Gson gson = new GsonBuilder()
			        .setPrettyPrinting()
			        .create();
			 
			String jsonOutput = gson.toJson(obj);
		  file.write(jsonOutput);
		  file.flush();
		  file.close();
	  }
}

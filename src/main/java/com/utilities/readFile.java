package com.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class readFile 
{
  public JsonObject readJson(String path) throws FileNotFoundException
  {
	  FileReader file=new FileReader(System.getProperty("user.dir")+"//src//main//resources//data//"+path);
	  Gson gson= new Gson();
	  JsonObject object=gson.fromJson(file,JsonObject.class);
	  return object;
	  
  }
}

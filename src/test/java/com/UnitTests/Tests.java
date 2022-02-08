package com.UnitTests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.createCombination.workingMagic;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class Tests extends workingMagic
{

		@Test
		public void testCombinationOutput()
		{
			String[] a= {"1","2","3"};
			String[] b= {"4","5"};
			String[] c= {"6"};
			JsonObject obj=new JsonObject();
			Gson gson=new Gson();
			obj.addProperty("a", gson.toJson(a));
			obj.addProperty("b", gson.toJson(b));
			obj.addProperty("c", gson.toJson(c));
			List<List<String>> listString=printCombinations(consolidatedList(obj), obj);
			Assert.assertTrue(listString.size()==20);
			
		}
	
}

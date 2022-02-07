package com.createCombination;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.paukov.combinatorics3.Generator;

import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.utilities.readFile;

public class magic3 {

	public static void main(String args[]) throws FileNotFoundException {
		readFile read = new readFile();
		JsonObject obj = read.readJson("testData.json");	
		List<List<String>> listString = printCombinations(consolidatedList(obj), obj);
		List<List<String>>output=filterCombinations(listString, nodeObjectList(obj), obj);
		System.out.println(output);
	}
	
	static List<List<String>> nodeObjectList(JsonObject obj)
	{
		List<List<String>> nodeObj = new ArrayList<List<String>>();

		for (Map.Entry<String, JsonElement> map : obj.entrySet()) {
			List<String> simpleList = new ArrayList<String>();

			for (JsonElement s : map.getValue().getAsJsonArray()) {
				simpleList.add(s.getAsString());
			}
			nodeObj.add(simpleList);
		}
		return nodeObj;
	}
	static List<String> consolidatedList(JsonObject obj)
	{
		List<String> listObj = new ArrayList<>();
		Iterator it = obj.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			for (JsonElement element : obj.get(key).getAsJsonArray()) {
				listObj.add(element.getAsString());
			}
		}
		return listObj;
	}
	static List<List<String>> printCombinations(List<String> sequence, JsonObject obj) {

		List<List<String>> combinations = Generator.combination(sequence).simple(obj.size()).stream()
				.collect(Collectors.toList());
		return combinations;

	}

	static List<List<String>> filterCombinations(List<List<String>> sequence, List<List<String>> simpleList, JsonObject obj) {

		List<List<String>> filteredList = new ArrayList<List<String>>();
		System.out.println(sequence.size());
		for (int i = 0; i < sequence.size(); i++) {
			int count = 1;
			for (int j = 0; j < simpleList.size(); j++) {
				List<String> temp1 = sequence.get(i);
				List<String> temp2 = simpleList.get(j);

				if (compareTwoList(temp1, temp2)) {
					count++;
				}

				if (count == obj.size()) {
					filteredList.add(temp1);
				}
			}
		}

		return filteredList;

	}

	static boolean compareTwoList(List<String> list1, List<String> list2) {
		boolean flag = false;
		List<String> tempx = new ArrayList<String>(list1);
		List<String> tempy = new ArrayList<String>(list2);
		tempx.retainAll(tempy);
		if (tempx.size() == 1) {
			flag = true;
		}
		return flag;
	}
}

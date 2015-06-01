package com.assign.edgeNw;

import java.util.ArrayList;
import java.util.HashMap;

public class WordMap 
{
	ArrayList<HashMap<String ,Integer>> theMap;
	HashMap<String ,Integer> theTotalMap;
	
	WordMap(ArrayList<ArrayList<String>> all)
	{
		for(ArrayList<String> temp : all)
		{
			theMap.add(createMap(temp));
		}
	}
	
	HashMap<String , Integer> createMap(ArrayList<String> temp)
	{
		HashMap<String , Integer> theFileMap = new HashMap<String,Integer>();
		// Now you got to apply regex
		
		
		
		return new HashMap<String ,Integer>();
	}
}

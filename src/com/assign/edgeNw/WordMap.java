package com.assign.edgeNw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordMap 
{
	ArrayList<HashMap<String ,Integer>> theMap;
	HashMap<String ,Integer> theTotalMap;
	Pattern p = Pattern.compile("[\\w-]+");
	Matcher m;
	
	WordMap(ArrayList<ArrayList<String>> all)
	{
		theMap = new ArrayList<HashMap<String ,Integer>>();
		for(ArrayList<String> temp : all)
		{
			theMap.add(createMap(temp));
		}
	}
	
	ArrayList<HashMap<String ,Integer>> retTheMap()
	{
		return theMap;
	}
	
	HashMap<String , Integer> createMap(ArrayList<String> temp)
	{
		
		HashMap<String , Integer> theFileMap = new HashMap<String , Integer>();
		String jlt;
		
		for(String s: temp)
		{	
			m = p.matcher(s);
			while(m.find())
			{
				jlt = m.group().toLowerCase();
				if(theFileMap.containsKey(jlt))
				{
					theFileMap.put(jlt, theFileMap.get(jlt) + 1);
				}
				else
				{
					theFileMap.put(jlt, 1);
				}
			}
		}
		
		return theFileMap;
	}
}

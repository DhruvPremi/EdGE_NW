package com.assign.edgeNw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordMap 
{
	ArrayList<HashMap<String ,Double>> theMap;
	HashMap<String ,Double> theTotalMap;
	Pattern p = Pattern.compile("[\\w-]+");
	Matcher m;
	
	WordMap(ArrayList<ArrayList<String>> all)
	{
		theMap = new ArrayList<HashMap<String ,Double>>();
		theTotalMap = new HashMap<String ,Double>();
		
		for(ArrayList<String> temp : all)
		{
			theMap.add(createMap(temp));
		}
		
	}
	
	ArrayList<HashMap<String ,Double>> retTheMap()
	{
		return theMap;
	}
	
	
	HashMap<String ,Double> retTheTotalMap()
	{
		return theTotalMap;
	}
	
	// Customize it
	boolean check(String take)
	{
		if((take.length() > 2) && (!take.matches("[0-9-]+")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	HashMap<String , Double> createMap(ArrayList<String> temp)
	{
		HashMap<String , Double> theFileMap = new HashMap<String , Double>();
		String jlt;
		
		HashMap<String , Integer> stopWords = new StopwordsRemoval().getStopWordList();
		for(String s: temp)
		{	
			m = p.matcher(s);
			while(m.find())
			{
				jlt = m.group().toLowerCase();
				
				if(check(jlt))
				{
					if(theTotalMap.containsKey(jlt))
					{
						theTotalMap.put(jlt, theTotalMap.get(jlt) + 1);
					}
					else
					{
						if(!stopWords.containsKey(jlt))
						{
							theTotalMap.put(jlt, 1.0);
						}
					}
					if(theFileMap.containsKey(jlt))
					{
						theFileMap.put(jlt, theFileMap.get(jlt) + 1);
					}
					else
					{
						if(!stopWords.containsKey(jlt))
						{
							theFileMap.put(jlt, 1.0);
						}
					}
				
				}
			}
		}
		
		return theFileMap;
	}
}

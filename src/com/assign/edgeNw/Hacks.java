package com.assign.edgeNw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Hacks 
{
	ArrayList<ArrayList<String>> allFilesString;
	ValueComparator bvc;
	 
	Hacks(ArrayList<ArrayList<String>> allFilesString)
	{
		this.allFilesString = allFilesString;
	}
	
	HashMap<String ,Double> termFrequency()
	{
		WordMap wm = new WordMap(allFilesString);
		return wm.retTheTotalMap();
	}
	
	HashMap<String , Double> documentFrequency()
	{
		WordMap wm = new WordMap(allFilesString);
		ArrayList<HashMap<String , Double>> temp = wm.retTheMap();
		
		HashMap<String ,Double> map = new HashMap<String , Double>();
		
		for(HashMap<String , Double> a : temp)
		{
			for(String s: a.keySet())
			{
				if(map.containsKey(s))
				{
					map.put(s, map.get(s) + 1);
				}
				else
				{
					map.put(s, 1.0);
				}
			}
		}
		return map;
	}
	
	ArrayList<HashMap<String , Double>> eachDocumentTermFrequncy()
	{
		WordMap wm = new WordMap(allFilesString);
		return wm.retTheMap();
	}
	
	void printSortedList(HashMap<String , Double> map ,  String message)
	{
		bvc = new ValueComparator(map);
		TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
		sorted_map.putAll(map);
		System.out.println(message+ "  " + sorted_map);
	}
}

class ValueComparator implements Comparator<String> {

    Map<String, Double> base;
    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}

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
	
	HashMap<String ,Integer> termFrequency()
	{
		WordMap wm = new WordMap(allFilesString);
		return wm.retTheTotalMap();
	}
	
	void printSortedList(HashMap<String , Integer> map)
	{
		bvc = new ValueComparator(map);
		TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);
		sorted_map.putAll(map);
		System.out.println("results: "+sorted_map);
	}
}

class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;
    public ValueComparator(Map<String, Integer> base) {
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

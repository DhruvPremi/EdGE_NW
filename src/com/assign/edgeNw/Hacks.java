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
	ValueComparatorLong lbvc;
	 
	Hacks(ArrayList<ArrayList<String>> allFilesString)
	{
		this.allFilesString = allFilesString;
	}
	
	HashMap<String , Long> unigramList()
	{
		Unigram wm = new Unigram();
		return wm.getUnigramList();
	}
	
	ArrayList<HashMap<String , Double>> algoOneSkillsPerDocument(double threshold , boolean useRules)
	{
		ArrayList<HashMap<String , Double>> toBe = new ArrayList<HashMap<String , Double>>();
		HashMap<String , Double> temp;
		HashMap<String ,Double> overallImpSkills = rateByDocumentFrequencyAndUnigram(threshold);
		
		ArrayList<HashMap<String ,Double>> funda;
		if(useRules)
		{
			funda = new Rules(allFilesString , false , true).theMap;
		}
		else
		{
			funda = new WordMap(allFilesString).theMap;
		}
		
		for(HashMap<String ,Double> eachDoc : funda)
		{
			temp = new HashMap<String , Double>();
			for(String s : eachDoc.keySet())
			{
				if(overallImpSkills.containsKey(s))
				{
					temp.put(s, overallImpSkills.get(s) * eachDoc.get(s));
				}
			}
			toBe.add(temp);
		}
		return toBe;
	}
		

	HashMap<String ,Double> rateByDocumentFrequencyAndUnigram(double threshold)
	{
		Unigram wm = new Unigram();
		HashMap<String , Long> unigram = wm.getUnigramList();
		HashMap<String , Double> dFrequency = documentFrequency();
		HashMap<String , Double> rating = new HashMap<String , Double>();
		
		int size = allFilesString.size();
		double critical = size * threshold;
		
		double total = 1;
		for(String s : dFrequency.keySet())
		{
			if(dFrequency.get(s) >= critical)
			{
				if(unigram.containsKey(s))
				{
					rating.put(s, (double)unigram.get(s));
					total = total + (double)unigram.get(s);
				}
				else
				{
					rating.put(s, 1.0);
					total = total + 1;
				}
			}
		}
		
		for(String s: rating.keySet())
		{
			rating.put(s, Math.log(total/rating.get(s)));
		}
		
		return rating;
	}
	
	ArrayList<HashMap<String , Long>> eachTermInEachDocumentUnigramFrequeny()
	{
		Unigram ug = new Unigram();
		HashMap<String , Long> temp = ug.getUnigramList();
		
		ArrayList<HashMap<String , Long>> toBe = new ArrayList<HashMap<String , Long>>();
		
		for(HashMap<String ,Double> eachDoc : new WordMap(allFilesString).theMap)
		{
			HashMap<String , Long> each = new HashMap<String , Long>();
			for(String s: eachDoc.keySet())
			{
				if(temp.containsKey(s))
				{
					each.put(s, temp.get(s));
				}
				else
				{
					each.put(s, new Long(1));
				}
			}
			toBe.add(each);
		}
		
		return toBe;
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
	
	void printSortedListLong(HashMap<String , Long> map ,  String message)
	{
		lbvc = new ValueComparatorLong(map);
		TreeMap<String,Long> sorted_map = new TreeMap<String,Long>(lbvc);
		sorted_map.putAll(map);
		System.out.println(message+ "  " + sorted_map);
	}
}


class ValueComparatorLong implements Comparator<String> {

    Map<String, Long> base;
    public ValueComparatorLong(Map<String, Long> base) {
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

class ValueComparator implements Comparator<String> 
{
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

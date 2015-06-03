package com.assign.edgeNw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bigram 
{
	ReadFiles rf;
	ArrayList<ArrayList<String>> allFiles;
	Pattern p = Pattern.compile("[\\w-]+");
	Matcher m;
	HashMap<String, HashMap<String , Double>> bigram;
	int size;
	
	Bigram()
	{
		rf = new ReadFiles();
		allFiles = rf.getAllFileObject();
		size = allFiles.size();
		
		makeBigram();
	}
	
	HashMap<String , HashMap<String , Double>> reduceBigram(double threshold)
	{
		HashMap<String , HashMap<String , Double>> toBe = new HashMap<String , HashMap<String , Double>>();
		double capacity = threshold*size;
		HashMap<String , Double> temp;
		
		for(String s : bigram.keySet())
		{
			for(String t : bigram.get(s).keySet())
			{
				if(bigram.get(s).get(t) > capacity)
				{
					if(toBe.containsKey(s))
					{
						temp = bigram.get(s);
						temp.put(t, bigram.get(s).get(t));
					}
					else
					{
						temp = new HashMap<String,Double>();
						temp.put(t, bigram.get(s).get(t));
						toBe.put(s, temp);
					}
				}
			}
		}
		return toBe;
	}
	
	HashMap<String, HashMap<String , Double>> retBigram()
	{
		return bigram;
	}
	
	void makeBigram()
	{
		HashMap<String , Integer> stopWords = new StopwordsRemoval().getStopWordList();
		String jlt;
		bigram = new HashMap<String, HashMap<String , Double>>();
		HashMap<String , Double> temp;
		
		for(ArrayList<String> eachDoc : allFiles)
		{
			for(String s: eachDoc)
			{	
				String pre = null;
				m = p.matcher(s);
				
				while(m.find())
				{
					jlt = m.group().toLowerCase();
					if(check(jlt))
					{
						if(pre == null)
						{
							// This is the first word after some time 
							if(!stopWords.containsKey(jlt))
							{
								pre = jlt;
							}
						}
						else
						{
							if(!stopWords.containsKey(jlt))
							{
								if(bigram.containsKey(pre))
								{
									temp = bigram.get(pre);
									if(temp.containsKey(jlt))
									{
										temp.put(jlt, temp.get(jlt) + 1);
									}
									else
									{
										temp.put(jlt, 1.0);
									}
								}
								else
								{
									temp = new HashMap<String , Double>();
									temp.put(jlt, 1.0);
									bigram.put(pre, temp);
								}
								pre = jlt;
							}
							else
							{
								pre = null;
							}
						}
						
					}
					else
					{
						pre = null;
					}
				}
			}
		}
		
		
	}
	
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

}

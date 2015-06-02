package com.assign.edgeNw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class StopwordsRemoval 
{
	HashMap<String , Integer> wordList;
	BufferedReader br = null;
	String stopWordDir = "./Files/stopwords";
	
	StopwordsRemoval()
	{
		wordList = new HashMap<String , Integer>();		
		try 
		{
			String sCurrentLine;
			br = new BufferedReader(new FileReader(stopWordDir));
 
			while ((sCurrentLine = br.readLine()) != null) 
			{
				String[] temp = sCurrentLine.split("\\s+");
				for(String every:temp)
				{
					if(!wordList.containsKey(every))
					{
						wordList.put(every, 1);
					}
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (br != null)br.close();
			} 
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}	
	}
	
	HashMap<String , Integer> getStopWordList()
	{
		return wordList;
	}
}

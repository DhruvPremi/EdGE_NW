package com.assign.edgeNw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Unigram 
{
	HashMap<String , Long> wordList;
	BufferedReader br = null;
	String unigramDir = "./Files/count_1w";
	
	Unigram()
	{
		wordList = new HashMap<String , Long>();		
		try 
		{
			String sCurrentLine;
			br = new BufferedReader(new FileReader(unigramDir));
 
			while ((sCurrentLine = br.readLine()) != null) 
			{
				String[] temp = sCurrentLine.split("\\s+");
				wordList.put(temp[0] , Long.valueOf(temp[1]));
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
	
	HashMap<String , Long> getUnigramList()
	{
		return wordList;
	}
}
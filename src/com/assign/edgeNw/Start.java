package com.assign.edgeNw;

import java.util.ArrayList;
import java.util.HashMap;

public class Start {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// First I will go to a Folder , check all the files
		// Read them one by one and then do whatever i want 
		
		ReadFiles rf = new ReadFiles();
		ArrayList<ArrayList<String>> allFiles = rf.getAllFileObject();
		
		// Just Check out For each File all the possible words
		// Print them and Check it out
		
		WordMap wm = new WordMap(allFiles);
		
		ArrayList<HashMap<String ,Integer>> theMap = wm.retTheMap();
		
		HashMap<String , Integer> temp = theMap.get(0);
		
		for(String s : temp.keySet())
		{
			System.out.println(s + "  ==  " + temp.get(s) );
		}
		
	}

}

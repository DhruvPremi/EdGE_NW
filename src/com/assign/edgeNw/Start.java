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
		
		// Make the Hack Object
		Hacks hack = new Hacks(allFiles);
		
		// Term Frequency and printing the Sorted out List
		HashMap<String ,Integer> theMap = hack.termFrequency();
		hack.printSortedList(theMap);
		
		
		
		/*
		for(String s : theMap.keySet())
		{
			if(theMap.get(s) > 2)
			{
				System.out.print(s + "  ==  " + theMap.get(s) + "  ,, " );
			}
		}
		*/
		
	}
}

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
		
		// Overall Document Term Frequency and printing the Sorted out List
		HashMap<String ,Double> theMap = hack.termFrequency();
		hack.printSortedList(theMap , "Overall Document Term Frequency");
		
		// Each Document Term Frequency and printing the Sorted List
		ArrayList<HashMap<String ,Double>> eachDocumentMap = hack.eachDocumentTermFrequncy();
		int i = 1;
		for(HashMap<String ,Double> map : eachDocumentMap)
		{
			hack.printSortedList(map, i + " Document Term Frequency ");
			i++;
		}
		
		
		// Document Frequency for each term
		hack.printSortedList(hack.documentFrequency(), "Document Frequency for each term");
		
		
		// Unigram Model
		
		
	}
}

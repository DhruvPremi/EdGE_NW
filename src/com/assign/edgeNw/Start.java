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
		HashMap<String , Long> bawliee = hack.unigramList();
		System.out.println(bawliee.get("experience"));
		System.out.println(bawliee.get("java"));
		/*
			System.out.println(bawliee.get("apache"));
			System.out.println(bawliee.get("javascript"));
			System.out.println(bawliee.get("skills"));
			System.out.println(bawliee.get("knowledge"));
		*/
		System.out.println(bawliee.get("hibernate"));
		
		// For Each Document and each term in it ,their UniGram Value
		ArrayList<HashMap<String ,Long>> eachDocumentUnigramMap = hack.eachTermInEachDocumentUnigramFrequeny();
		i = 1;
		for(HashMap<String , Long> map : eachDocumentUnigramMap)
		{
			hack.printSortedListLong(map, i + " Document's Unigram Frequency ");
			i++;
		}
		
		// Rate Skills by Document Frequency 
		hack.printSortedList(hack.rateByDocumentFrequencyAndUnigram(.3) , "\n\nRatings when Document Frequency and Unigram are used");
		
		// For every Document Skills based on Document Frequency , Unigram  and term frequency
		ArrayList<HashMap<String , Double>> algoOneSkillsPerDocument = hack.algoOneSkillsPerDocument(.3);
		i = 1;
		for(HashMap<String , Double> map : algoOneSkillsPerDocument)
		{
			hack.printSortedList(map, i + " Document's Top Skills in Sorted order ");
			i++;
		}
		
	}
}

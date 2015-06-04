package com.assign.edgeNw;

import java.util.ArrayList;
import java.util.HashMap;

public class Start 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// First I will go to a Folder , check all the files
		// Read them one by one and then apply Hacks
		ReadFiles rf = new ReadFiles();
		ArrayList<ArrayList<String>> allFiles = rf.getAllFileObject();
		
		// Make the Hack Object
		Hacks hack = new Hacks(allFiles);
		
		// Overall Document Term Frequency and printing the Sorted out List
		// HashMap<String ,Double> theMap = hack.termFrequency();
		// hack.printSortedList(theMap , "\n\nOverall Document's Term Frequency");
		
		
		// Each Document Term Frequency and printing the Sorted List , Just to Have a Closer look at the Data
		ArrayList<HashMap<String ,Double>> eachDocumentMap = hack.eachDocumentTermFrequncy();
		int i = 1;
		for(HashMap<String ,Double> map : eachDocumentMap)
		{
			hack.printSortedList(map, i + " Document Term Frequency ");
			i++;
		}
		
		// Document Frequency for each term
		hack.printSortedList(hack.documentFrequency(), "\n\nDocument Frequency for each term");
		
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
		
		// Rate Skills by Document Frequency ,Overall Ratings for all the Documents
		hack.printSortedList(hack.rateByDocumentFrequencyAndUnigram(.3) , "\n\nRatings when Document Frequency and Unigram are used");
		
		// For every Document Skills based on Document Frequency , Unigram  and term frequency
		System.out.println("\n\n\n");
		ArrayList<HashMap<String , Double>> algoOneSkillsPerDocument = hack.algoOneSkillsPerDocument(.3 , false);
		i = 1;
		for(HashMap<String , Double> map : algoOneSkillsPerDocument)
		{
			hack.printSortedList(map, i + " Document's Top Skills in Sorted order ");
			i++;
		}
		
		// Including Rules , For every Document Skills based on Document Frequency , Unigram  and term frequency
		System.out.println("\n\n\n");
		System.out.println("Rules are taken into Account when scoring");
		algoOneSkillsPerDocument = hack.algoOneSkillsPerDocument(.3 , true);
		i = 1;
		for(HashMap<String , Double> map : algoOneSkillsPerDocument)
		{
			hack.printSortedList(map, i + " Document's Top Skills in Sorted order (Rules are taken into account) ");
			i++;
		}
		
		// Make the Bigram and printing out the Maximum strength Bigrams , depending upon the threshold
		System.out.println("\n\n\n Bigram Most Frequent terms , Gives a key Insight into the Skills for all the Documents");
		HashMap<String, HashMap<String , Double>> bigram = new Bigram().reduceBigram(.3);
		System.out.println("\n\n" + bigram.toString());
		
	}
}

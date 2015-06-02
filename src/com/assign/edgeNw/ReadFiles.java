package com.assign.edgeNw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFiles 
{
	BufferedReader br = null;
	String[] paths;
	File file = null;
	String dataDir = "./Data/";
	ArrayList<ArrayList<String>> allFiles = new ArrayList<ArrayList<String>>();
	
	ReadFiles()
	{	
		file = new File(dataDir);
		paths = file.list();
		
		ArrayList<String> temp;
		for(String path:paths)
		{
			// System.out.println("\n **************** New File *******************  ");
			
			temp = new ArrayList<String>();
			try 
			{
				String sCurrentLine;
				br = new BufferedReader(new FileReader(dataDir + path));
	 
				while ((sCurrentLine = br.readLine()) != null) 
				{
					// System.out.println(sCurrentLine);
					temp.add(sCurrentLine);
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
			allFiles.add(temp);
		}
	}
	
	public ArrayList<ArrayList<String>> getAllFileObject()
	{
		return allFiles;
	}
	
}

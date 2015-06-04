package com.assign.edgeNw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rules 
{
	ArrayList<HashMap<String ,Double>> theMap;
	
	Pattern p = Pattern.compile("[\\w-]+");
	Pattern p_comma = Pattern.compile(",");
	Pattern p_skill = Pattern.compile("skill");
	
	Matcher m_skill;
	Matcher m_comma;
	Matcher m;
	
	Boolean checkForCommaRule;
	Boolean checkForSkillWordRule;
	
	Rules(ArrayList<ArrayList<String>> all ,Boolean checkForCommaRule , Boolean checkForSkillWordRule)
	{
		theMap = new ArrayList<HashMap<String ,Double>>();
		
		this.checkForCommaRule = checkForCommaRule;
		this.checkForSkillWordRule = checkForSkillWordRule;
		
		
		for(ArrayList<String> temp : all)
		{
			theMap.add(createMap(temp));
		}
	}
	
	// Customize it
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
		
	HashMap<String , Double> createMap(ArrayList<String> temp)
	{
		HashMap<String , Double> theFileMap = new HashMap<String , Double>();
		String jlt;
		
		boolean b_skill = false;
		boolean b_comma = false;
		int i;
		HashMap<String , Integer> stopWords = new StopwordsRemoval().getStopWordList();
		for(String s: temp)
		{	
			b_skill = false;
			b_comma = false;
			
			i = 0;
			
			m = p.matcher(s);
			m_skill = p_skill.matcher(s.toLowerCase());
			m_comma = p_comma.matcher(s);
			
			if(m_skill.find())
			{
				b_skill = true;
			}
			
			while(m_comma.find())
			{
				i++;
			}
			if(i > 2)
			{
				b_comma = true;
			}
			
			if(checkForCommaRule == false)
			{
				b_comma = false;
			}
			if(checkForSkillWordRule == false)
			{
				b_skill = false;
			}
			
			while(m.find())
			{
				jlt = m.group().toLowerCase();
				
				if(check(jlt))
				{
					if(theFileMap.containsKey(jlt))
					{
						if((b_skill == true) || (b_comma == true))
						{
							theFileMap.put(jlt, theFileMap.get(jlt) + 2);
						}
						else
						{
							theFileMap.put(jlt, theFileMap.get(jlt) + 1);
						}
					}
					else
					{
						if(!stopWords.containsKey(jlt))
						{
							if((b_skill == true) || (b_comma == true))
							{
								theFileMap.put(jlt, 2.0);
							}
							else
							{
								theFileMap.put(jlt, 1.0);
							}
						}
					}
				}
			}
		}
		
		return theFileMap;
		
	}
}

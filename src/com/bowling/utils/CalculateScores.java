package com.bowling.utils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalculateScores {
	
	public static int totalScore(List<Integer> list) {
		int total = 0;
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer score = (Integer) iterator.next();
			total = score + total;			
		}
		return total;
		
	}
	
	public static Map<String,Integer> prepareBoard(Map<String, List<Integer>> scoreBoard) {
		Iterator<Entry<String, List<Integer>>> it = scoreBoard.entrySet().iterator();
		
		Map<String, Integer> result = new HashMap<String,Integer>(); 
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String playerName = (String) pair.getKey();
            List list = (ArrayList<Integer>) pair.getValue();
            int playerScore = totalScore(list);
            result.put(playerName, playerScore);           
        }
		
        return result;
		
	}
	
	public static List<String> decideWinner(Map<String,Integer> pointsSummery) {
		Iterator<Entry<String, Integer>> it = pointsSummery.entrySet().iterator();
		
		List<Integer> list = new ArrayList<Integer>(pointsSummery.size());
		
		while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Integer value = (Integer) pair.getValue();
            list.add(value) ;                   
        }
		
		Collections.sort(list);
		
		int maxScore = list.get(list.size()-1);
		
		List<String> matchingKeys = new ArrayList<String>();
		for (String key : pointsSummery.keySet()) {
		    if(pointsSummery.get(key) == maxScore) {
		        matchingKeys.add(key);
		    }
		}		
		
		return matchingKeys ;
	}

}

package com.bowling.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bowling.helper.BowlingAssistant;
import com.bowling.helper.InputValidator;
import com.bowling.helper.ProgressBar;
import com.bowling.utils.CalculateScores;



public class PlayBowling {

	public static void main(String[] args) throws IOException {	
		
		
		Map<String, List<Integer>> scoreBoard = new HashMap<String, List<Integer>>();
		
		// Step - 1 : Game Initialization
		
		BowlingAssistant.speak("************************************************************");
		BowlingAssistant.speak("       Hello !  Welcome to Ten-pin Bowling Game!   ");
		BowlingAssistant.speak("************************************************************");
		BowlingAssistant.speak(" ");
		BowlingAssistant.speak("This is your bowling assistance and I will help you to");
		BowlingAssistant.speak("play your fun game today....Are you ready ?  Lets start...");
		BowlingAssistant.speak(" ");
		BowlingAssistant.speak("************************************************************");
		BowlingAssistant.speak(" ");
		BowlingAssistant.speak("Let's create a game first");
		BowlingAssistant.speak("What will be the name of your game ?");
        
		BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
		String name = InputValidator.stringValidator(br); 
       
        BowlingAssistant.speak("Alright, you have created your game successfully and the name is : " + name);
        
        // Step - 2 : Game Setup
        
        BowlingAssistant.speak("How many players will play today");
        
          
        int totalPlayer = InputValidator.numberValidator(br,10);
        BowlingAssistant.speak(" "); 
        
        if(totalPlayer < 2) {
        	BowlingAssistant.speak(" ");
        	BowlingAssistant.speak("OOPS ! I need atleast 2 player to play the game..");
        	BowlingAssistant.speak(" ");
        	BowlingAssistant.speak("Are you crazy ? You don't want your friend to play with you ");
        	BowlingAssistant.speak(" ");
        	BowlingAssistant.speak("Let me know how many players will play today once again ?");        	
        	BowlingAssistant.speak("This is your last chance to enter total players correctly");
        	       
                
        	totalPlayer = InputValidator.numberValidator(br,10);
            
            if(totalPlayer < 2) {
            	BowlingAssistant.speak("Are you joking....");
            	BowlingAssistant.speak("I will not able to assist you to play this game with less than 2 players");
            	BowlingAssistant.speak("Good Luck and start again");
            	System.exit(0);
            	
            }
        }       
        
        BowlingAssistant.speak("OK, We will play this game with " + totalPlayer + " players");
        
        BowlingAssistant.speak("Can you tell me their names   ..so that I can customize the game for you..");
        BowlingAssistant.speak("Let's get their names one by one...is that cool ?");
        BowlingAssistant.speak(" ");
        
        
        List<String> playerlist = new ArrayList<String>(totalPlayer);
        
        for (int i = 1; i <= totalPlayer; i++) {
        	BowlingAssistant.speak("What will be name for Player  number :  "+ i + "?");
        	        	
        	playerlist.add(InputValidator.stringValidator(br));			
			
		}
        
        BowlingAssistant.speak(" ");
        BowlingAssistant.speak("Great Job! So we will play with the following players today... !");
        for (Iterator<String> iterator = playerlist.iterator(); iterator.hasNext();) {
			String player = (String) iterator.next();
			BowlingAssistant.speak(player);
			
		}
        
        BowlingAssistant.speak(" ");
        BowlingAssistant.speak("You did your job.Let me quickly set up the game for you....");
        BowlingAssistant.speak("Are you ready ?  Say y oy n");
                
        String choice = InputValidator.stringValidator(br);
        
        if (choice.equalsIgnoreCase("n")) {
        	BowlingAssistant.speak("Good Luck and start again");
        	System.exit(0);
        }else {        	
        	 
        	ProgressBar.showProgressBar();
        }
        
        BowlingAssistant.speak(" ");
        
        BowlingAssistant.speak("All-right. Your game is ready... ");
        BowlingAssistant.speak(" ");
        BowlingAssistant.speak("Name of the game is :  " + name + "  ... I remembered it correctly, right!");
        
        // Step - 3 : Game Play
        
        BowlingAssistant.speak("To make our rounds simple we will play one by one starting with the first player... ");
        BowlingAssistant.speak(" ");
        
        for (Iterator<String> iterator = playerlist.iterator(); iterator.hasNext();) {
			String player = (String) iterator.next();
			BowlingAssistant.speak(player);			
		}
        
        BowlingAssistant.speak(" ");
        BowlingAssistant.speak("Let's bowl now ...");
        BowlingAssistant.speak("There will be 10 frames and 2 rolls each round ...You can hit strike and spare to get bonus roll(s)");
        BowlingAssistant.speak(" ");
        BowlingAssistant.speak("************************************************************");
        BowlingAssistant.speak(" ");
        BowlingAssistant.speak("Quick Question ! Do you want to change total number of frames to play ?");        
        BowlingAssistant.speak("Say y oy n");        
        
        String showResult =  InputValidator.stringValidator(br);
        
        int totalframes = 10;
        
        if (showResult.equalsIgnoreCase("n")) {
        	BowlingAssistant.speak("Alright...We will play with 10 frames for each player");        	
        }else {
        	
        	BowlingAssistant.speak("Ok ! How may frames you want to play ?"); 
        	totalframes =  InputValidator.numberValidator(br, 10);
        	BowlingAssistant.speak("I modified your game and we will play with : " + totalframes + " frames for each player. ");
        }
                
        List<Integer> result = new ArrayList<Integer>();
        int frame = 1;
        
        for (Iterator<String> iterator = playerlist.iterator(); iterator.hasNext();) {
			String player = (String) iterator.next();
			BowlingAssistant.speak(" ");
			BowlingAssistant.speak("Let's play for player name : " + player);
			
			// reset frame
			frame = 1;
			int roll = 1;
			BowlingAssistant.speak("Your points has to be between 1 to 10");
			int bonus = 0;
			while (frame <= totalframes) {	
				
				while(roll <=2) {
					
					if(roll == 2) {
						 int lastScore = result.get(result.size()-1); 
						 if(lastScore == 10) {
							 BowlingAssistant.speak("Bravo ! You hit a strike !!!");
							 BowlingAssistant.speak("************************************************************"); 							 
							 bonus = bonus +2;
							 break;
						 }
						 else {
							 int balance = 10 - lastScore;
							 BowlingAssistant.speak("How much is the scored for frame : " + frame + " and roll :" + roll);
							 BowlingAssistant.speak("You scored " + lastScore + " in first roll. So you are allowed enter points between " + 1 + " and " + balance);
							 
							 int score = InputValidator.numberValidator(br,balance);								 
							 result.add(score); 
							 if((lastScore + score) == 10) {
								BowlingAssistant.speak("WoW ....you hit  a spare"); 
								bonus++;
							 }
						 }
						 
					}else {
						 BowlingAssistant.speak("How much is the scored for frame : " + frame + " and roll :" + roll);	
						 int score = InputValidator.numberValidator(br,10);						 
						 result.add(score);
					}					
			        roll++;
					
				}				
				frame++;
				roll = 1;				
			}
			
			BowlingAssistant.speak(" ");
			BowlingAssistant.speak("************************************************************");
			BowlingAssistant.speak(" ");			
			
			if(bonus > 0) {
				BowlingAssistant.speak("Your have bonus point : " + bonus + " to play more...lets play your bonus points");	
				
				for (int i = 1; i <= bonus; i++) {
					 BowlingAssistant.speak("How much You scored for bonus : " + i );						 
					 int score = InputValidator.numberValidator(br,10);					 
					 result.add(score);				
				}
			}else {
				BowlingAssistant.speak("You don't have any bonus to play more");
				BowlingAssistant.speak(" ");
			}
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp = (ArrayList<Integer>) result; 			
			scoreBoard.put(player, (List<Integer>) temp.clone());
			result.clear();
					
		}
        
        // Step - 4 : Game Score 
        
        BowlingAssistant.speak("Game over ! you all played " + (frame-1) + " frame each");
        BowlingAssistant.speak("Do you want to see who win the game ? ");
        BowlingAssistant.speak("Say y oy n");        
            
        showResult =  InputValidator.stringValidator(br);
        
        if (showResult.equalsIgnoreCase("n")) {
        	BowlingAssistant.speak("Alright...Bye for now");
        	System.exit(0);
        }else {
        	
        	 BowlingAssistant.speak(" ");
        	 BowlingAssistant.speak("Calculating Score ....");
        	 BowlingAssistant.speak(" ");        	 
        	 ProgressBar.showProgressBar();
        }     
        
        
        Map<String,Integer> pointsSummery = CalculateScores.prepareBoard(scoreBoard);
        
        BowlingAssistant.speak(" ");
        BowlingAssistant.speak("************************************************************");
        BowlingAssistant.speak("               SCORE BOARD          ");
        BowlingAssistant.speak("************************************************************");
        
        
        for(Map.Entry<String,Integer> entry : pointsSummery.entrySet()) {
          String key = entry.getKey();
      	  Integer value = entry.getValue();      	  
          BowlingAssistant.speak("       Total points for " + key + " is : " + value);        	  
       }         
        
       BowlingAssistant.speak("************************************************************");
       BowlingAssistant.speak("               WINNER NAME(S)   :   " +  CalculateScores.decideWinner(pointsSummery).toString());
       BowlingAssistant.speak("************************************************************");
       
       System.exit(0);

	}
	

}

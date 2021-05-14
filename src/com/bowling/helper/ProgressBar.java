package com.bowling.helper;

public class ProgressBar {
	
	public static void showProgressBar() {
		int i = 0;
		 while (i < 100) { 
			i = i+ 10; 
			System.out.print("Processing: " + i + "% " + "\r");
			try {
		         Thread.sleep(100);
		     } catch (InterruptedException e) {
		         e.printStackTrace();
		     } 
		 }
	}

}

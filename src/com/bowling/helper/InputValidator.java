package com.bowling.helper;

import java.io.BufferedReader;
import java.io.IOException;

public class InputValidator {
	
	public static String stringValidator(BufferedReader in) {
		
		String errorMessage = "Please enter a correct value: \n";
	    boolean invalid = true;
	    String output = null;

		    do {
		        try {
		        	if(invalid && output != null) {
		        		System.out.print(errorMessage);
		        	}
		            output = in.readLine();
		            if(output.length() > 0 && output.matches("^[a-zA-Z]*$")) {
		            	 invalid = false;
		            }	            
		        }catch(IOException e) {
		            e.printStackTrace();
		            System.out.print(errorMessage);
		        }
		    } while(invalid);

	    return output;
	}
	
public static int numberValidator(BufferedReader in, int limit) {
		
	String errorMessage = "Please enter a valid number between : 0 to " + limit + "\n";
    boolean invalid = true;
    int output = -1;

	    do {
	        try {
	        	if(invalid && output != -1) {
	        		System.out.print(errorMessage);
	        	}
	            output = Integer.parseInt(in.readLine());
	            if( output >=0  && output <= limit) {
	            	invalid = false;
	            }            
	        } catch(NumberFormatException e) {
	            System.out.print(errorMessage);
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	        
	    } while(invalid);

	    return output;
	}

}

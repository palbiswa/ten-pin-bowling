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
		        	System.out.print(errorMessage);		            		            
		        }
		    } while(invalid);

	    return output;
	}
	
public static int numberValidator(BufferedReader in, int minLimit, int maxLimit) {
		
	String errorMessage = "Please enter a valid number between : " + minLimit + " to " + maxLimit + "\n";
    boolean invalid = true;
    int output = -1;
    boolean msgPrinted = false;

	    do {
	        try {
	        	if(!msgPrinted && invalid && output != -1) {
	        		System.out.print(errorMessage);
	        	}
	            output = Integer.parseInt(in.readLine());
	            if( output >= minLimit  && output <= maxLimit) {
	            	invalid = false;
	            }else {
	            	throw new NumberFormatException();
	            }
	        } catch(NumberFormatException e) {	
	        	System.out.print(errorMessage);	 
	        	msgPrinted = true;
	        } catch(IOException e) {
	        	System.out.print(errorMessage);
	        	msgPrinted = true;
	        }
	        
	    } while(invalid);

	    return output;
	}

}

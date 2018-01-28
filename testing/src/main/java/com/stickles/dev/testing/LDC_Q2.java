package com.stickles.dev.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LDC_Q2 
{
	//Creating all of the important variables
	static String goldBox;
	static Boolean goldBoxChanged;
	static String silverBox;
	static Boolean silverBoxChanged;
	static String leadBox;
	static Boolean leadBoxChanged;
	static String boxChose;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String input;
	
    public static void main( String[] args ) { 
    	Question();	//Start the main program
    	returnToMain(null);	//when done, restart the program
    }
    
    public static void returnToMain(String[] args) {	//this code waits for the enter key, then returns to main menu
    	System.out.println("Press the enter key to continue.");
    	try {
         	input = reader.readLine();
         } catch (IOException e) {
             e.printStackTrace();
         }
         main(args);
    }
    
    public static void Question() {	//Choose to either learn what the LDC is, or calculate the answer
    	System.out.println("Welcome to the LDC! Type 1 to find the answer, or 2 to learn more!");
        try {
        	input = reader.readLine();	//Reads the user's response
        } catch (IOException e) {
            e.printStackTrace();
        }

    	if (input.equals("1")) { //Time to calculate!!
    		Calculate();
    		return;
    		
    	} else if (input.equals("2")) {	//Displays the description on screen
    		System.out.println(description());
    		returnToMain(null);
    		return;
    		
    	} else {	//if you type something random, it should re-ask you the question
    		Question();
    		return;
    	}
    }
    		
	static void init() {	//resets the variables for code use
		goldBox = "unknown";
		goldBoxChanged = false;
		silverBox = "unknown";
		silverBoxChanged = false;
		leadBox = "unknown";
		leadBoxChanged = false;
	}
    
	public static void Calculate() {	//figure out where the image is!
		
		for (int i = 1; i < 4; i++) {	//loops through 3 scenarios (gold is true, silver is true, lead is true)
		
			init();
			
			if (i==1) {	//if gold box statement is true...
				boxChose = "gold";
				System.out.println(String.format("\r\nIf the %s box is true:",boxChose));
				goldBoxStatement(true);	//do what gold box says
				silverBoxStatement(false);	//do opposite of what silver box says
				leadBoxStatement(false);	//do opposite of what lead box says
			}
			else if (i==2) {	//if silver box statement is true...
				boxChose = "sliver";
				System.out.println(String.format("\r\nIf the %s box is true:",boxChose));
				goldBoxStatement(false);
				silverBoxStatement(true);
				leadBoxStatement(false);
			}
			else if (i==3) {	//if lead box statement is true...
				boxChose = "lead";
				System.out.println(String.format("\r\nIf the %s box is true:",boxChose));
				goldBoxStatement(false);
				silverBoxStatement(false);
				leadBoxStatement(true);
			}
			
			System.out.println(String.format("Gold Box = %s \r\n"	//displays the results calculated
	    			+ "Silver Box = %s \r\n"
	    			+ "Lead Box = %s"
	    			,goldBox, silverBox, leadBox));
			
			Boolean goldBool = null;
			Boolean silverBool = null;
			Boolean leadBool = null;
			
			//turning strings (the text message in the result) into booleans (variables that can only equal true or false)
			try {goldBool = Boolean.parseBoolean(goldBox);} finally {}
			try {silverBool = Boolean.parseBoolean(silverBox);} finally {}
			try {leadBool = Boolean.parseBoolean(leadBox);} finally {}
			
			if (goldBool.equals(silverBool) && goldBool) 
				System.out.println("The gold and silver box cannot both be true");
			else if (silverBool.equals(leadBool) && silverBool)
				System.out.println("The silver and lead box cannot both be true");
			else if (leadBool.equals(goldBool) && leadBool) 
				System.out.println("The lead and gold box cannot both be true");
			else if (goldBool)
				System.out.println("The picture is in the gold box!");
			else if (silverBool)
				System.out.println("The picture is in the silver box!");
			else if (leadBool)
				System.out.println("The picture is in the lead box!");
		}
	}
	
	public static String description() {
    			return "The Lauren Davis Challenge Question #2\r\n" + 
            			" It's some logic question asked in my Adv. Algebra 2 class\r\n" + 
            			" Honestly I don't know why I'm doing this.\r\n" + 
            			" \r\n" + 
            			" Long ago in a land far away from Arlington, the fair maiden Rowena wishes to wed. And her \r\n" + 
            			" father, the evil king (there always has to be a villain in the story to make it interesting, chillens!), \r\n" + 
            			" has devised a way to drive off suitors. He has a little quiz for them, and here it is.\r\n" + 
            			" \r\n" + 
            			" There are three boxes on the table. One is made of gold. One is made of silver. And the third is \r\n" + 
            			" made of lead. Inside one of these boxes is a picture of the fair Rowena, and it is the job of the \r\n" + 
            			" knight, the white night, to figure out - without opening them, of course - which one has her \r\n" + 
            			" picture. Now, to assist him in this endeavor there are inscriptions on each of the boxes.\r\n" + 
            			" \r\n" + 
            			" The gold box says, \"Rowena's picture is in this box.\"\r\n" + 
            			" \r\n" + 
            			" The silver box says, \"The picture ain't in this box.\"\r\n" + 
            			" \r\n" + 
            			" And the lead box says, \"The picture ain't in the gold box.\"\r\n" + 
            			" \r\n" + 
            			" And then the king, not being entirely decrepit, give's a hint: One of the statements, and only \r\n" + 
            			" one, is true.\r\n" + 
            			" \r\n" + 
            			" The LDC question is thus a simple one: Where's the picture?";
    		}
    
    public static void changeBoxValue(String boxType, Boolean value) {	//function that does what the boxes say; warns if something is wrong
    	if (boxType == "gold") {
    		if (goldBoxChanged && value.toString() != goldBox) {
    			System.out.println("The statements have conflicting information on the gold box!");
    			goldBox = "logical EXTREME";
    		} else {
    		goldBox = value.toString();
    		goldBoxChanged = true;
    		}
    	}
    	else if (boxType == "silver") {
    		if (silverBoxChanged && value.toString() != silverBox) {
    			System.out.println("The statements have conflicting information on the silver box!");
    			silverBox = "logical EXTREME";
    		} else {
    		silverBox = value.toString();
    		silverBoxChanged = true;
    		}
    	}
    	else if (boxType == "lead") {
    		if (leadBoxChanged && value.toString() != leadBox) {
    			System.out.println("The statements have conflicting information on the lead box!");
    			leadBox = "logical EXTREME";
    		} else {
    		leadBox = value.toString();
    		leadBoxChanged = true;
    		}
    	}
    	else {
    		System.out.println(String.format("The box %s does not exist!", boxType));
    		System.exit(1);
    	}
    }
    
    public static void goldBoxStatement(boolean isTrue) {	//Rowena's picture is in this box
    	if (isTrue)
    		changeBoxValue("gold",true);
    	else
    		changeBoxValue("gold",false);
    }
    
    public static void silverBoxStatement(boolean isTrue) {	//The picture ain't in this box
    	if (isTrue)
    		changeBoxValue("silver",false);
    	else
    		changeBoxValue("silver",true);
    }
    
    public static void leadBoxStatement(boolean isTrue) {	//The picture ain't in the gold box
    	if (isTrue)
    		changeBoxValue("gold",false);
    	else
    		changeBoxValue("gold",true);
    }
}

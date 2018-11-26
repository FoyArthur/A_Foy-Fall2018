//@auuthor Arthur Foy
//11/19/2018
package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Input fractions.");
    	String input = userInput.nextLine();
    	while(input.equals("quit") != true) {
    		System.out.println(produceAnswer(input));
    		System.out.println("Input fractions");
    		input = userInput.nextLine();
    	}
    	

   	}
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        String[] fractionDecomposed = new String[3];
        fractionDecomposed = input.split(" ");
        String firstOperand = fractionDecomposed[0];
        String operator = fractionDecomposed[1];
        String secondOperand = fractionDecomposed[2];
        String wholeFirst = null;
        String wholeSecond = null;
        String numeratorFirst = null;
        String numeratorSecond = null;
        String denominatorFirst = null;
        String denominatorSecond = null;
        if(firstOperand.indexOf("_") != -1){
        	wholeFirst = firstOperand.substring(firstOperand.indexOf("_") - 1, firstOperand.indexOf("_"));
        }else {
        	wholeFirst = "0";
        }
        
        if(secondOperand.indexOf("_") != -1){
        	wholeSecond = secondOperand.substring(secondOperand.indexOf("_") - 1, secondOperand.indexOf("_"));
        }else {
        	wholeSecond = "0";
        }
        
        if(firstOperand.indexOf("/") != -1) {
        	numeratorFirst = firstOperand.substring(firstOperand.indexOf("/") - 1, firstOperand.indexOf("/"));
        }
        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}

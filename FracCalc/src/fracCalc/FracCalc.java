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
        }else if(firstOperand.indexOf("/") != -1) {
        	wholeFirst = "0";
        }else {
        	wholeFirst = firstOperand;
        }
        
        if(secondOperand.indexOf("_") != -1){
        	wholeSecond = secondOperand.substring(secondOperand.indexOf("_") - 1, secondOperand.indexOf("_"));
        }else if(secondOperand.indexOf("/") != -1){
        	wholeSecond = "0";
        }else {
        	wholeSecond = secondOperand;
        }
        //first numerator and denominator
        if(firstOperand.indexOf("/") != -1 && firstOperand.indexOf("_") != -1) {
        	numeratorFirst = firstOperand.substring(firstOperand.indexOf("_") + 1, firstOperand.indexOf("/"));
        	denominatorFirst = firstOperand.substring(firstOperand.indexOf("/") + 1);
        } else if(firstOperand.indexOf("/")!= -1) {
        	numeratorFirst = firstOperand.substring(0, firstOperand.indexOf("/"));
        	denominatorFirst = firstOperand.substring(firstOperand.indexOf("/") + 1);
        }else {
        	numeratorFirst = "0";
        	denominatorFirst = "1";		
        }
        //secondNumerator and denominator
        if(secondOperand.indexOf("/") != -1 && secondOperand.indexOf("_") != -1) {
        	numeratorSecond = secondOperand.substring(secondOperand.indexOf("_") + 1, secondOperand.indexOf("/"));
        	denominatorSecond = secondOperand.substring(secondOperand.indexOf("/") + 1);
        } else if(secondOperand.indexOf("/")!= -1) {
        	numeratorSecond = secondOperand.substring(0, secondOperand.indexOf("/"));
        	denominatorSecond = secondOperand.substring(secondOperand.indexOf("/") + 1);
        }else {
        	numeratorSecond = "0";
        	denominatorSecond = "1";		
        }
        int numeratorOne = Integer.parseInt(numeratorFirst);
        int numeratorTwo = Integer.parseInt(numeratorSecond);
        int wholeOne = Integer.parseInt(wholeFirst);
        int wholeTwo = Integer.parseInt(wholeSecond);
        int denominatorOne = Integer.parseInt(denominatorFirst);
        int denominatorTwo = Integer.parseInt(denominatorSecond);
        
        String improperFirst = toImproperFrac(wholeOne, numeratorOne, denominatorOne);
        String improperSecond = toImproperFrac(wholeTwo, numeratorTwo, denominatorTwo);
        String finalAnswer = null;
        if(operator.equals("+") == true) {
        	finalAnswer = addition(improperFirst, improperSecond);
        }
        return(finalAnswer);
    }
    public static String toImproperFrac(int wholeNum, int numerator, int denominator) {
    	int newNumerator = 0;
    	if(wholeNum >= 0) {
    		newNumerator =  wholeNum * denominator + numerator;
    	}else {
    		newNumerator = wholeNum * denominator;
    	}
		return newNumerator + "/" + denominator;
	}
    
    public static String addition(String one, String two) {
    	int[] operandOne = new int[2];
    	int[] operandTwo = new int[2];
    	operandOne[0] = Integer.parseInt(one.substring(0, one.indexOf("/")));
    	operandOne[1] = Integer.parseInt(one.substring(one.indexOf("/") + 1));
    	operandTwo[0] = Integer.parseInt(two.substring(0, two.indexOf("/")));
    	operandTwo[1] = Integer.parseInt(two.substring(two.indexOf("/") + 1));
    	int numeratorAnswer = 0;
    	int denominatorAnswer = 0;
    	if(operandOne[1] - operandTwo[1] == 0) {
    		numeratorAnswer = operandOne[0] + operandTwo[0];
    		denominatorAnswer = operandOne[1];
    	}else {
    		numeratorAnswer = (operandOne[0] * operandTwo[1]) + operandTwo[0] * operandOne[1];
    		denominatorAnswer = (operandOne[1] * operandTwo[1]);
    	}
    	String finalValue= numeratorAnswer + "/" + denominatorAnswer;
    	return(finalValue);
    	sd;
    }
    
    public static String multiplication(String one, String two) {

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}

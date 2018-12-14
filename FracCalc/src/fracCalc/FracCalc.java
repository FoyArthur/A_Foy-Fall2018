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
        	wholeFirst = firstOperand.substring(0, firstOperand.indexOf("_"));
        }else if(firstOperand.indexOf("/") != -1) {
        	wholeFirst = "0";
        }else {
        	wholeFirst = firstOperand;
        }
        
        if(secondOperand.indexOf("_") != -1){
        	wholeSecond = secondOperand.substring(0, secondOperand.indexOf("_"));
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
     
        int[] improperFirst = toImproperFrac(wholeOne, numeratorOne, denominatorOne);
        int[] improperSecond = toImproperFrac(wholeTwo, numeratorTwo, denominatorTwo);
        
        int[] finalAnswer = new int[2];
        if(operator.equals("+") == true) {
        	finalAnswer = addition(improperFirst, improperSecond);
        }else if(operator.equals("*") == true) {
        	finalAnswer = multiplication(improperFirst, improperSecond);
        }else if(operator.equals("-") == true) {
        	finalAnswer = subtraction(improperFirst, improperSecond);
        }else if(operator.equals("/") == true) {
        	finalAnswer = division(improperFirst, improperSecond);
        }
        System.out.println(finalAnswer[0] + " " + finalAnswer[1]);
        return(toMixedNum(finalAnswer[0], finalAnswer[1]));
    }
    
    public static int[] toImproperFrac(int wholeNum, int numerator, int denominator) {
    	int newNumerator = 0;
    	if(wholeNum >= 0) {
    		newNumerator =  (wholeNum * denominator) + numerator;
    	}else {
    		newNumerator = wholeNum * denominator - numerator;
    	}
		int[] answer = {newNumerator, denominator};
		return answer;
	}
    
    public static int[] addition(int[] one, int[] two) {
    	int numeratorAnswer = 0;
    	int denominatorAnswer = 0;
    	if(one[1] - two[1] == 0) {
    		numeratorAnswer = one[0] + two[0];
    		denominatorAnswer = one[1];
    	}else {
    		numeratorAnswer = (one[0] * two[1]) + two[0] * one[1];
    		denominatorAnswer = (one[1] * two[1]);
    	}
    	int[] finalValue = {numeratorAnswer, denominatorAnswer};
    	return finalValue;
    }
    public static int[] subtraction(int[] one, int[] two) {
    	int numeratorAnswer = 0;
    	int denominatorAnswer = 0;
    	if(one[1] - two[1] == 0) {
    		numeratorAnswer = one[0] - two[0];
    		denominatorAnswer = one[1];
    	}else {
    		numeratorAnswer = (one[0] * two[1]) - two[0] * one[1];
    		denominatorAnswer = (one[1] * two[1]);
    	}
    	int[] finalValue = {numeratorAnswer, denominatorAnswer};
    	return finalValue;
    }
    
    public static int[] multiplication(int[] one, int[] two) {
    	int numeratorAnswer = one[0] * two[0];
    	int denominatorAnswer = one[1] * two[1];
    	int[] finalValue = {numeratorAnswer, denominatorAnswer};
    	return finalValue;
    }
    
    public static int[] division(int[] one, int[] two) {
    	int numeratorAnswer = one[0] * two[1];
    	int denominatorAnswer = one[1] * two[0];
    	int[] finalValue = {numeratorAnswer, denominatorAnswer};
    	return(finalValue);
    }
    
    public static String toMixedNum(int numerator, int denominator) {
    	String finalAnswerr = null;
    	int wholeNum = 0;
    	int gcf = 0;
    	if(numerator < 0 && denominator < 0) {
    		numerator *= -1;
    		denominator *= -1;
    	}
    	if(denominator == 1) {
    		finalAnswerr = (numerator + "");
    	}else if(numerator == denominator) {
    		finalAnswerr = 1 + "";
    	}else if(absValue(numerator) > absValue(denominator)){
    		wholeNum = numerator/denominator;
    		numerator = numerator - (wholeNum * denominator);
    		if(numerator < 0) {
    			numerator *= -1;
    		}
    		if(denominator < 0) {
    			denominator *= -1;
    		}
    		gcf = gcf(numerator, denominator);
    		numerator = (numerator/gcf);
    		denominator = (denominator/gcf);
    		System.out.println(numerator + " " + denominator);
    		if(numerator == 0) {
    			return(wholeNum + "");
    		}else {
    			finalAnswerr = (wholeNum + "_" + numerator + "/" + denominator);
    		}
    	}else {
    		gcf = gcf(absValue(numerator), absValue(denominator));
    		numerator = numerator/gcf;
    		denominator = denominator/gcf;
    		if(denominator < 0) {
    			denominator *= -1;
    			numerator *= -1;
    		}
    		finalAnswerr = numerator + "/" + denominator;
    	}
    	if(numerator == 0) {
    		finalAnswerr = 0 + "";
    	}
    	return finalAnswerr;
	}
    
	public static int gcf(int num1, int num2){
		int gcFactor = 1;
		for(int i = 2; i <= min(num1, num2); i++) {
			if(isDivisibleBy(num1, i) == true && isDivisibleBy(num2, i) == true){
				gcFactor = i;
			}
		}
		return gcFactor;
	}
	
	public static boolean isDivisibleBy(int num1, int num2) {
		if(num2 == 0) throw new IllegalArgumentException ("The second number cannot be zero");
		if(num1 % num2 == 0 || num2 % num1 == 0) {
			return true;
		} else {
			return false;
		}
	}
    
	public static int absValue(int number) {
		if(number < 0) {
			return number * -1;
		}else {
			return number;
		}
	}
	public static int min(int num1, int num2){
		if(num1 <= num2){
			return num1;
		} else{
			return num2;
		}
	}

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}


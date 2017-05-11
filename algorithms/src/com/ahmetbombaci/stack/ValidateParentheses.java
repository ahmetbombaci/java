package com.ahmetbombaci.stack;

import java.util.Stack;

public class ValidateParentheses {
	
	public static int validate(String S)  {
        Stack<Character> check = new Stack<>();
        
        for(char c:S.toCharArray()) {
            if(c=='[' || c=='{' || c=='(') {
                check.push(c);
            }
            else {
                if(check.isEmpty())
                    return 0;
                
                char s = check.pop();
                if(s == '{') {
                    if(c!='}')
                        return 0;
                } 
                else if(s == '[') {
                    if(c!=']')
                        return 0;
                } 
                else if(s == '(') {
                    if(c!=')')
                        return 0;
                }            
            }    
        }
        
        
        if(check.isEmpty())
            return 1;
        
        return 0;
        
    }
	
	private static void displayTestCase(String testInput, int expectedOutput, int testOutput) {
		System.out.println("Input <" + testInput + ">  Expected Result: " + expectedOutput + "  Output: " + testOutput);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testInput = "";
		displayTestCase(testInput, 1, validate(testInput));
		
		testInput = "(ahmet){[12(bombaci)]}";
		displayTestCase(testInput, 1, validate(testInput));
		
		testInput = "((())";
		displayTestCase(testInput, 0, validate(testInput));
		
		testInput = "{{{}}}}";
		displayTestCase(testInput, 0, validate(testInput));
		

	}

}

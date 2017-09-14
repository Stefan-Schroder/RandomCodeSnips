/**
* @author Stefan Schroder
* @version 2016-09-19
*
* This program is used to check that the brackets or bracces used in a string are valid.
* They have all got open and closing pairs in the correct places.
* () - valid
* )() - not valid
* [(]) - not valid
* etc..
*/

import java.util.Scanner;

class Question2{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a string to test:");
		String line = input.nextLine();
		line = line.replace(" ","");
		
		Stack<Character> open = new Stack<Character>();
		
		boolean deadList = false;// used to check if there are still starting brackets left in the stack
		boolean unfixable = false;// used to check if list is still valid at the end of the loop
		
		/**
		* This loops through the list of characters in the string input.
		* first checks to see if the character is a starting/opening bracket and then adds it to a stack of open brackets
		* after all the opening brackets are extracted, the program then checks to make sure that the input has closing brackets for them in the correct places.
		* if a correct close is found then the bracket is popped, if there is an error(such as an incorrect close "<]") then teh loop is broken.
		* if the characters have not all been looped through and there are no more objects in the stack, then one more loop is done to make sure that the next character is not adding a bracket but if still not;
		* then list is declared broken and the rest of the character array is printed out.
		* after the loop is done, all the characters left in the stack are printed out, as they dont have any closing pairs.
		* if the stack and the character array are both finished at the same time, then the string is taken to be correct.
		*/
		for(Character c : line.toCharArray()){
			if(!deadList){
				if(c=='(' 	||
				   c=='{'	||
				   c=='['	||
				   c=='<'){
					open.push(c);
					
				}else{
					if(!open.isEmpty()){	
						if(open.polar(c)){
							open.pop();
							
						}else{
							System.out.println("error: '"+c+"' does not match with '"+open.peek()+"'.");
							unfixable = true;
							break;
							
						}//polar
					}else{
						deadList = true;
						
					}//empty
				}//open
			}//dead
			if(deadList){
				System.out.println("error at end: the close bracket '"+c+"' does not have a corresponding opening bracket.");
				
			}//dead
		}//c
		
		if(!deadList && !unfixable){
			if(!open.isEmpty()){
				open.outputList();
			
			}else{
				System.out.println("The string is correct! There are no mismatched brackets.");
				
			}//still left
		}//boken
	}//main
}//class
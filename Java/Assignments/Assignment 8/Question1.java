/**
* @author Stefan Schroder
* @version 2016-09-19
* 
* all inputs are taken untill an x is inputed.
* all inputs other than an O are put into a queue,
* when an O is inputted, the first item in the queue is dequeueed.
*/

import java.util.Scanner;

class Question1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		Queue<String> inputQueue = new Queue<String>();
		String line = input.nextLine();
		
		while(!line.equals("X")){
			if(line.equals("O")){
				if(inputQueue.isEmpty()){
					System.out.println("Buffer empty");
					
				}else{
					System.out.println("Data: "+inputQueue.dequeue());
					
				}//
			}else{
				inputQueue.enqueue(line);
			
			}//
			line = input.nextLine();
			
		}//
	}
}
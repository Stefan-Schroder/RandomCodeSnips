/*
1
Fanta Orange 500
1
Fanta Orange 400
1
Coke Silver 500
1
Coke Red 500
2
*/
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

class Question1{
	public static void main(String[] args){
		ArrayList <SoftDrink> drinks = new ArrayList();
		Scanner input = new Scanner(System.in);
		
		int answer;
		do{
			System.out.println("Enter option: (1) add soft drink (2) quit:");
			answer = input.nextInt();
			
			if(answer==1){
				System.out.println("Enter name, colour and volume in ml separated by space");
				String name = input.next();
				String colour = input.next();
				int volume = input.nextInt();
				SoftDrink currentOrder = new SoftDrink(name,colour,volume);
				drinks.add(currentOrder);
			}//end if
		}while(answer!=2);
		
		Collections.sort(drinks);
		
		for(SoftDrink s: drinks){
			System.out.println(s.toString());
		}
	}
}
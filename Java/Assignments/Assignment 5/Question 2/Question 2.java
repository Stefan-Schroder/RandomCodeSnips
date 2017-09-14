import java.util.Scanner;
class Question 2{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String choice;
		do(){
			System.out.println("Welcome to Great International Food Court");
			System.out.println("MENU: add (P)izza, add (C)urry, add (S)oft drink, (D)elete, (L)ist, (Q)uit");
			choice = input.nextLine();
			
			switch(choice){
				case "p":
					break;
				case "c":
					break;
				case "s":
					break;
				case "d":
					break;
				case "l":
					break;
			}
			
		}while(choice!="Q");
	}
}
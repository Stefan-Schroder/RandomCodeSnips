import java.util.Scanner;
import java.util.ArrayList;

class Question2{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String choice;
		ArrayList<menu> list = new ArrayList<menu>();
		System.out.println("Welcome to Great International Food Court");
		do{
			System.out.println("MENU: add (P)izza, add (C)urry, add (S)oft drink, (D)elete, (L)ist, (Q)uit");
			choice = input.next();
			
			String itemNumber;
			String size;
			
			switch(choice){
				case "p"://Pizza
					System.out.println("Enter the menu item number");
					itemNumber = input.next();
					
					System.out.println("Enter the size");
					size = input.next();
					
					System.out.println("Enter the base");
					String base = input.next();
					
					System.out.println("Enter extra cheese");
					String cheese = input.next();
					boolean hasCheese = false;
					if(cheese.equals("Yes")) hasCheese = true;
						
					System.out.println("Enter extra garlic");
					String garlic = input.next();
					boolean hasGarlic = false;
					if(garlic.equals("Yes")) hasGarlic = true;
					
					Pizza orderPizza = new Pizza(itemNumber, size, base, hasCheese, hasGarlic);
					list.add(orderPizza);
					System.out.println("Done");
					break;
					
				case "c"://Curry
					System.out.println("Enter the menu item number");
					itemNumber = input.next();
					
					System.out.println("Enter the size");
					size = input.next();
					
					System.out.println("Enter the curry type");
					String type = input.next();
					
					Curry orderCurry = new Curry(itemNumber, size, type);
					list.add(orderCurry);
					System.out.println("Done");
					break;
					
				case "s"://SoftDrink
					System.out.println("Enter the menu item number");
					itemNumber = input.next();
					
					System.out.println("Enter the size");
					size = input.next();
					
					System.out.println("Enter the flavour");
					String flavour = input.next();
					
					System.out.println("Enter whether it is a bottle or can");
					String container = input.next();
					
					SoftDrink orderDrink = new SoftDrink(itemNumber, size, flavour, container);
					list.add(orderDrink);
					System.out.println("Done");
					break;
					
				case "d"://delete
					System.out.println("Enter the menu item number");
					itemNumber = input.next();
					
					boolean found = false;
					for(int i=0;i<list.size();i++){
						if(list.get(i).getMenuNumber()==itemNumber){
							found = true;
							list.remove(i);
							break;
						}
					}//end loop
					
					if(found){
						System.out.println("Done");
					}else{
						System.out.println("Not found");
					}//end ifs
					break;
					
				case "l"://list
					for(int i=0;i<list.size();i++){
						System.out.println(list.get(i).toString());
					}//end loops
					System.out.println("Done");
					break;
					
				case "q"://quit
					break;
					
				default: //wrong input
					System.out.println("Not found");
					break;
			}//end switch
			
		}while(!choice.equals("q"));
	}
}
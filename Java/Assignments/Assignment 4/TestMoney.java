
/**
 * Simple test harness for Money
 * 
 * @author Stephan Jamieson
 * @version 8/8/2015
 */
import java.util.Scanner;
//
public class TestMoney{

    private TestMoney() {}
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a currency code:");
        String code = scanner.nextLine(); 
        
        System.out.println("Enter a currency symbol:");
        String symbol = scanner.nextLine();

        System.out.println("Enter the number of minor currency units per major currency unit.");
        int minorToMajor = scanner.nextInt();

        System.out.println("Creating currency object.");
        Currency currency = new Currency(symbol, code, minorToMajor);
        
        System.out.println("Enter a sum of money e.g. R199.99 (assuming currency is ZAR): ");
        String stringAmount = scanner.next();
        System.out.println("Creating a Money object representing that amount.");
        Money money = new Money(stringAmount, currency);
        
        System.out.println("\nMake a selection and press return:");
        System.out.println("0. Quit.");
        System.out.println("1. Test longAmount().");
        System.out.println("2. Test currency().");
        System.out.println("3. Test toString().");
        System.out.println("4. Test add().");
        System.out.println("5. Test subtract().");
        
        int selection = scanner.nextInt();
        
        while (selection!=0) {
            if (selection==1) { System.out.println("longAmount(): "+money.longAmount()); }
            else if (selection==2) { System.out.println("Currency(): Currency("+money.currency().symbol()+", "+money.currency().code()+", "+money.currency().minorPerMajor()+")"); }
            else if (selection==3) { System.out.println("toString(): "+money.toString()); }
            else if (selection==4 || selection==5) {
                System.out.println("Enter a sum of money e.g. R199.99 (assuming currency is ZAR):");
                if (scanner.hasNext()) {
                    stringAmount = scanner.next();
                    Money otherMoney = new Money(stringAmount, currency);
                    if (selection==4) {
                        Money result = money.add(otherMoney);
                        System.out.println(money.toString()+"+"+otherMoney.toString()+"="+result.toString()); 
                    }
                    else {
                        Money result = money.subtract(otherMoney);
                        System.out.println(money.toString()+"-"+otherMoney.toString()+"="+result.toString()); 
                    }
                }
                else {
                    System.out.println("Couldn't process input. Something wrong?");
                }                
                
            }
            else {
                System.out.println("That selection was not recognised.");
            }

            System.out.println("\nMake a selection and press return:");
            System.out.println("0. Quit.");
            System.out.println("1. Test longAmount().");
            System.out.println("2. Test currency().");
            System.out.println("3. Test toString().");
            System.out.println("4. Test add().");
            System.out.println("5. Test subtract().");
            
            selection = scanner.nextInt();
        }
        
        scanner.close();
    }

}

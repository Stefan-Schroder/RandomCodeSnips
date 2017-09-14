
/**
 * Simple test harness for Currency
 * 
 * @author Stephan Jamieson
 * @version 8/8/2015
 */
import java.util.Scanner;
//
public class TestCurrency{

    private TestCurrency() {}
    
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
        
        System.out.println("\nMake a selection and press return:");
        System.out.println("0. Quit.");
        System.out.println("1. Test symbol().");
        System.out.println("2. Test code().");
        System.out.println("3. Test minorPerMajor().");
        System.out.println("4. Test format().");
        System.out.println("5. Test parse().");

        int selection = scanner.nextInt();
        
        while (selection!=0) {
            if (selection==1) { System.out.println("symbol(): "+currency.symbol()); }
            else if (selection==2) { System.out.println("code(): "+currency.code()); }
            else if (selection==3) { System.out.println("minorPerMajor(): "+currency.minorPerMajor()); }
            else if (selection==4) {
                System.out.println("Enter the quantity of minor units:");
                if (scanner.hasNextInt()) {
                    int amount = scanner.nextInt();
                    System.out.println("format("+amount+"): "+currency.format(amount)); 
                }
                else {
                    System.out.println("Couldn't process input. Something wrong?");
                }                
                
            }
            else if (selection==5) {
                System.out.println("Enter the currency amount e.g. R23.10:");
                if (scanner.hasNext()) {
                    String amount = scanner.next();
                    System.out.println("parse("+amount+"): "+currency.parse(amount));
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
            System.out.println("1. Test symbol().");
            System.out.println("2. Test code().");
            System.out.println("3. Test minorPerMajor().");
            System.out.println("4. Test format().");
            System.out.println("5. Test parse().");
            
            selection = scanner.nextInt();
        }
        
        scanner.close();
    }

}

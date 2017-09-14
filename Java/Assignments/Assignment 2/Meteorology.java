import java.util.Scanner;

class Meteorology{
	public static void main(String[] args){
		Scanner readLine = new Scanner(System.in);
		
		Collator temp = new Collator("Temperature");
		Collator press = new Collator("Pressure");
		Collator humi = new Collator("Humidity");
		
		int option = 0;
		do{
			System.out.println(	"Make a selection and press return:\n"+
								"1.\tRecord a temperature reading.\n"+
								"2.\tRecord a pressure reading.\n"+
								"3.\tRecord a humidity reading.\n"+
								"4.\tPrint maximum values.\n"+
								"5.\tPrint minimum values.\n"+
								"6.\tPrint average values.\n"+
								"7.\tQuit.");
			
			option = readLine.nextInt();
			
			switch(option){
				case 1:
					System.out.println("Enter value:");
					temp.recordReading(readLine.nextInt());
					break;
				case 2:
					System.out.println("Enter value:");
					press.recordReading(readLine.nextInt());
					break;
				case 3:
					System.out.println("Enter value:");
					humi.recordReading(readLine.nextInt());
					break;
				case 4:
					System.out.println("Maximum temperature: "+((temp.maximum()==0) ? "-" : temp.maximum()));
					System.out.println("Maximum pressure: "+((press.maximum()==0) ? "-" : press.maximum()));
					System.out.println("Maximum humidity: "+((humi.maximum()==0) ? "-" : humi.maximum()));
					break;
				case 5:
					System.out.println("Minimum temperature: "+((temp.minimum()==0) ? "-" : temp.minimum()));
					System.out.println("Minimum pressure: "+((press.minimum()==0) ? "-" : press.minimum()));
					System.out.println("Minimum humidity: "+((humi.minimum()==0) ? "-" : humi.minimum()));
					break;
				case 6:
					System.out.println("Average temperature: "+((temp.average()==0) ? "-" : (int)temp.average()));
					System.out.println("Average pressure: "+((press.average()==0) ? "-" : (int)press.average()));
					System.out.println("Average humidity: "+((humi.average()==0) ? "-" : (int)humi.average()));
					break;
			}//end switch
			
		}while(option!=7); 
	}
}

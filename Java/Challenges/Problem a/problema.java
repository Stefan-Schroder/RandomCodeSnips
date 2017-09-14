import java.util.Scanner;

class problema{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int testCases = Integer.valueOf(input.next());
		while(testCases!=0){
			System.out.println("here");
			/*String axisCoords = input.nextLine();
			System.out.println(axisCoords);
			int xCo = Integer.valueOf(axisCoords.substring(0,axisCoords.indexOf(" ")));
			int yCo = Integer.valueOf(axisCoords.substring(axisCoords.indexOf(" ")+1));
			*/
			
			int xCo = Integer.valueOf(input.next());
			int yCo = Integer.valueOf(input.next());
			
			for(int i=0;i<testCases;i++){
				/*String placeCoords = input.nextLine();
				int xPlace = Integer.valueOf(placeCoords.substring(0,placeCoords.indexOf(" ")));
				int yPlace = Integer.valueOf(placeCoords.substring(placeCoords.indexOf(" ")+1));
				*/
				int xPlace = Integer.valueOf(input.next());
				int yPlace = Integer.valueOf(input.next());
				if(xPlace==xCo){
					System.out.println("umda");
				}else if(yPlace==yCo){
					System.out.println("umda");
				}else if(yPlace<yCo){
					System.out.print("S");
				}else if(yPlace>yCo){
					System.out.print("N");
				}else if(xPlace<xCo){
					System.out.println("W");
				}else if(xPlace>xCo){
					System.out.println("E");
				}//end ifs
			}//end for
			testCases = input.nextInt();
		}//end while
	}//end main
}
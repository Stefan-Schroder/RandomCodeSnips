import java.util.ArrayList;
import java.lang.Math;

class StringSolver{
	private void printEquation(ArrayList<String> equation){
		System.out.print(equation+" => ");
		for(String s : equation){
			System.out.print(s);
		}
		System.out.println();
	}
	
	public double solve(ArrayList<String> equation){
		printEquation(equation);
		//repition is done to keep order of operations
		if(equation.contains("(")){
			//solves brackets first
			ArrayList<String> smallPart = new ArrayList<String>();
			boolean start = false;
			
			//finding the position of the first brackets
			int startBracket = equation.indexOf("(");
			int endBracket = -1;
			int bracCounter = 0;
			for(int i=startBracket;i<equation.size();i++){
				if(equation.get(i).equals("(")) bracCounter++;
				else if(equation.get(i).equals(")")) bracCounter--;
				if(bracCounter==0){
					endBracket = i;
					break;
				}//seaching for closing of the first bracket
			}//looping through
			
			for(int i=0;i<equation.size();i++){
				if(start) smallPart.add(equation.get(i));
				
				if(i==startBracket){
					start = true;
				}else if(i==endBracket){
					start = false;
				}//checking for brackets
				
			}//loop through equation
			smallPart.remove(smallPart.size()-1);
			//get answer
			double bracketAnswer = solve(smallPart);
			
			//Checking if there was anything before equation
			boolean hasBefore = false;
			if(startBracket!=0){
				if(equation.get(startBracket-1).equals("abs")){
					bracketAnswer = absoluteValue(bracketAnswer);
					hasBefore = true;
				}
			}
				
			//create equation without bracket
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<startBracket || i>endBracket){
					newArray.add(equation.get(i));
				}else if(i==startBracket){
					newArray.add(String.valueOf(bracketAnswer));
				}//checking to add
			}//looping through
			
			if(hasBefore) newArray.remove(startBracket-1);
			
			return solve(newArray);
		}
		else if(equation.contains("^")){
			//solving the Power
			int powerPos = equation.indexOf("^");
			double powAnswer = Math.pow(	Double.valueOf(equation.get(powerPos-1)),
											Double.valueOf(equation.get(powerPos+1)));
			
			//setting to a new array
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<powerPos-1 || i>powerPos+1){
					newArray.add(equation.get(i));
				}else if(i==powerPos){
					newArray.add(String.valueOf(powAnswer));
				}
			}//loop-through
			
			return solve(newArray);
		}
		else if(equation.contains("*")){
			//solving the multiplication
			int multiPos = equation.indexOf("*");
			double multiAnswer = Double.valueOf(equation.get(multiPos-1))*Double.valueOf(equation.get(multiPos+1));
			
			//setting to a new array
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<multiPos-1 || i>multiPos+1){
					newArray.add(equation.get(i));
				}else if(i==multiPos){
					newArray.add(String.valueOf(multiAnswer));
				}
			}//loop-through
			
			return solve(newArray);
		}
		else if(equation.contains("-")){
			//solving the subtraction
			int minusPos = equation.indexOf("-");
			double minusAnswer = Double.valueOf(equation.get(minusPos-1))-Double.valueOf(equation.get(minusPos+1));
			
			//setting to a new array
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<minusPos-1 || i>minusPos+1){
					newArray.add(equation.get(i));
				}else if(i==minusPos){
					newArray.add(String.valueOf(minusAnswer));
				}
			}//loop-through
			
			return solve(newArray);
		}
		else if(equation.contains("+")){
			//solving the addition
			int addPos = equation.indexOf("+");
			double addAnswer = Double.valueOf(equation.get(addPos-1))+Double.valueOf(equation.get(addPos+1));
			
			//setting to a new array
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<addPos-1 || i>addPos+1){
					newArray.add(equation.get(i));
				}else if(i==addPos){
					newArray.add(String.valueOf(addAnswer));
				}
			}//loop-through
			
			return solve(newArray);
		}
		else{
			return Double.valueOf(equation.get(0));
		}
	}
	
	public double absoluteValue(double number){
		if(number<0){
			number*=-1;
		}
		return number;
	}
	
	public static void main(String[] args){
		StringSolver calculator = new StringSolver();
		// String equation = "((3*2-3)*2)^2-(3*2^2*3)+(-3)";
		String equation = "abs(abs(-5+1)*-1+5)";
		
		StringSplitter split = new StringSplitter();
		ArrayList<String> splitEquation = split.splitThis(equation);
		
		// System.out.println(Split.toString());
		System.out.println(calculator.solve(splitEquation));
	}
}
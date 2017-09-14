import java.util.ArrayList;
import java.lang.Math;

class ComplexStringSolver{
	
	ComplexNumber complexOperation = new ComplexNumber();
	
	public ComplexStringSolver(){};
	
	public ArrayList<String> complexFormat(ArrayList<String> equation, ComplexNumber z){
		// System.out.println(equation);
		// ComplexNumber z = new ComplexNumber(real,imag);
		
		//convert array to complex numbers
		for(int i=0;i<equation.size();i++){
			if(equation.get(i).equals("z")){
				equation.set(i,String.valueOf(z.getReal())+"+"+String.valueOf(z.getImaginary())+"i");
				
			}else if(	!equation.get(i).equals("+") && 
						!equation.get(i).equals("^") &&
						!equation.get(i).equals("-") &&
						!equation.get(i).equals("*") &&
						!equation.get(i).equals("|") &&
						!equation.get(i).equals("(") &&
						!equation.get(i).equals(")") &&
						!equation.get(i).equals("Re")&&
						!equation.get(i).equals("Im")&&
						!equation.get(i).equals("abs")&&
						!equation.get(i).equals("conj")){
			
				if(equation.get(i).equals("i")){
					equation.set(i,"0+1i");
				}else{
					equation.set(i,equation.get(i)+"+0i");
				}//if i
			}//if z
		}//loop-through
		
		
		return equation;
	}
	
	public ComplexNumber solve(ArrayList<String> equation){
		// System.out.println(equation);
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
			ComplexNumber bracketAnswer = new ComplexNumber(solve(smallPart).toString());
			
			//Checking if there was anything before equation
			boolean hasBefore = false;
			if(startBracket!=0){
				if(equation.get(startBracket-1).equals("abs")){
					bracketAnswer = absoluteValue(bracketAnswer);
					hasBefore = true;
				}else if(equation.get(startBracket-1).equals("conj")){
					bracketAnswer = conjegateValue(bracketAnswer);
					hasBefore = true;
				}else if(equation.get(startBracket-1).equals("Re")){
					bracketAnswer = new ComplexNumber(bracketAnswer.getReal(),0);
					hasBefore = true;
				}else if(equation.get(startBracket-1).equals("Im")){
					bracketAnswer = new ComplexNumber(bracketAnswer.getImaginary(),0);
					hasBefore = true;
				}
			}//
			
			//create equation without bracket
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<startBracket || i>endBracket){
					newArray.add(equation.get(i));
				}else if(i==startBracket){
					newArray.add(bracketAnswer.toString());
				}//checking to add
			}//looping through
			
			if(hasBefore) newArray.remove(startBracket-1);
			
			return solve(newArray);
		}
		else if(equation.contains("^")){
			//solving the Power
			int powerPos = equation.indexOf("^");
			ComplexNumber powAnswer = new ComplexNumber(equation.get(powerPos-1));
			ComplexNumber powOG = new ComplexNumber(equation.get(powerPos-1));
			ComplexNumber toPower = new ComplexNumber(equation.get(powerPos+1));
			int power = (int)((new ComplexNumber(equation.get(powerPos+1))).getReal());
			for(int i=1;i<power;i++){
				powAnswer.multiply(powOG);
			}
			
			//setting to a new array
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<powerPos-1 || i>powerPos+1){
					newArray.add(equation.get(i));
				}else if(i==powerPos){
					newArray.add(powAnswer.toString());
				}
			}//loop-through
			
			return solve(newArray);
		}
		else if(equation.contains("*")){
			//solving the multiplication
			int multiPos = equation.indexOf("*");
			ComplexNumber multiAnswer = new ComplexNumber(equation.get(multiPos-1));
			multiAnswer.multiply(new ComplexNumber(equation.get(multiPos+1)));
			
			//setting to a new array
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<multiPos-1 || i>multiPos+1){
					newArray.add(equation.get(i));
				}else if(i==multiPos){
					newArray.add(multiAnswer.toString());
				}
			}//loop-through
			
			return solve(newArray);
		}
		else if(equation.contains("-")){
			//solving the subtraction
			int minusPos = equation.indexOf("-");
			ComplexNumber minusAnswer = new ComplexNumber(equation.get(minusPos-1));
			minusAnswer.minus(new ComplexNumber(equation.get(minusPos+1)));
			
			//setting to a new array
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<minusPos-1 || i>minusPos+1){
					newArray.add(equation.get(i));
				}else if(i==minusPos){
					newArray.add(minusAnswer.toString());
				}
			}//loop-through
			
			return solve(newArray);
		}
		else if(equation.contains("+")){
			//solving the addition
			int addPos = equation.indexOf("+");
			ComplexNumber addAnswer = new ComplexNumber(equation.get(addPos-1));
			addAnswer.plus(new ComplexNumber(equation.get(addPos+1)));
			
			//setting to a new array
			ArrayList<String> newArray = new ArrayList<String>();
			for(int i=0;i<equation.size();i++){
				if(i<addPos-1 || i>addPos+1){
					newArray.add(equation.get(i));
				}else if(i==addPos){
					newArray.add(addAnswer.toString());
				}
			}//loop-through
			
			return solve(newArray);
		}
		else{
			return new ComplexNumber(equation.get(0));
		}
	}
	
	public ComplexNumber absoluteValue(ComplexNumber z){
		double number = Math.sqrt(Math.pow(z.getReal(),2)+Math.pow(z.getImaginary(),2));
		ComplexNumber absolute = new ComplexNumber(number,0);
		return absolute;
	}
	
	public ComplexNumber conjegateValue(ComplexNumber z){
		return new ComplexNumber(z.getReal(),z.getImaginary()*-1);
	}
	
	
	public static void main(String[] args){
		ComplexStringSolver calculator = new ComplexStringSolver();
		StringSplitter splits = new StringSplitter();
		
		String equation = "(2*3)-5";
		ComplexNumber z = new ComplexNumber(2,3);
		ArrayList<String> splitEquation = splits.splitThis(equation);
		// System.out.println(splitEquation);
		splitEquation = calculator.complexFormat(splitEquation,z);//2+3i
		System.out.println(calculator.solve(splitEquation));
	}
}
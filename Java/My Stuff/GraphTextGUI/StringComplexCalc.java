import java.util.ArrayList;

public class StringComplexCalc{
	
	private StringSplitter splits = new StringSplitter();
	private StringSolver nonComplexSolve = new StringSolver();
	private ComplexStringSolver complexSolve = new ComplexStringSolver();
	
	public StringComplexCalc(){}
	
	
	/**
	* Works out if the equation is true for the conditions given
	* 1 for true - 0 for false - 2 for error
	*/
	public int check(ArrayList<String> conditions, double real, double imag){
		int counter = 0;
		for(String s: conditions){
			if(singleCheck(s,real,imag)==1) counter++;
			
		}
		if(counter==conditions.size()){
			return 1;
		}else{
			return 0;
		}
	}
	
	private int singleCheck(String condition, double real, double imag){
		ComplexNumber number = new ComplexNumber(real,imag);
		
		//find out what type of sum it is
		char sumSign;
		if(condition.contains("<")){
			sumSign = '<';
		}else if(condition.contains(">")){
			sumSign = '>';
		}else if(condition.contains("=")){
			sumSign = '=';
		}else{
			return 2;
		}
		
		String calculationLeft = condition.substring(0,condition.indexOf(sumSign));
		String calculationRight = condition.substring(condition.indexOf(sumSign)+1);
		//solver here
		
		ComplexNumber left = simplify(calculationLeft,number);
		ComplexNumber right = simplify(calculationRight,number);
		
		if(sumSign=='<'){
			if(left.getReal()<=right.getReal() && left.getImaginary()<=right.getImaginary()) return 1;
			else return 0;
		}else if(sumSign=='>'){
			if(left.getReal()>=right.getReal() && left.getImaginary()>=right.getImaginary()) return 1;
			else return 0;
		}else if(sumSign=='='){
			if(left.getReal()==right.getReal() && left.getImaginary()==right.getImaginary()) return 1;
			else return 0;
		}
		return 2;
	}//
	
	private ComplexNumber simplify(String equation, ComplexNumber z){
		ArrayList<String> splitEquation = splits.splitThis(equation);
		splitEquation = complexSolve.complexFormat(splitEquation,z);
		return complexSolve.solve(splitEquation);
	}
	
	public static void main(String[] args){
		StringComplexCalc calc = new StringComplexCalc();
		ArrayList <String> conditions = new ArrayList<String>();
		conditions.add("Re(z)=Im(z)");
		System.out.println(calc.check(conditions,2,2));
	}
}
import java.util.ArrayList;

class StringSplitter{
	public StringSplitter(){}
	
	public ArrayList<String> splitThis(String equation){
		ArrayList<String> splitEquation = new ArrayList<String>();
	
		equation = equation.replace(" ","");
		
		int point1 = 0;
		String lookingFor = "not";
		for(int i=0;i<equation.length();i++){
			char c = equation.charAt(i); 
			
			try{
				double number = Double.valueOf(String.valueOf(c));

				if(!lookingFor.equals("Double")){
					String substring = equation.substring(point1,i);
					splitEquation.add(substring);
					lookingFor="Double";
					point1 = i;
					
				}//looking for double
				
			}catch(Exception e){
				if(c=='.'){
					continue;
				}else if(/*!lookingFor.equals("Nothing") &&*/(c=='(' || c==')' || c=='*' || c=='+' || c=='-' || c=='^' || c=='z' || c=='i')){//possbaly put it back xD
					String substring = equation.substring(point1,i);
					splitEquation.add(substring);
					point1 = i;
					lookingFor="Nothing";
					
				}else if(!lookingFor.equals("String")){
					String substring = equation.substring(point1,i);
					splitEquation.add(substring);
					point1 = i;
					lookingFor="String";
				}
				
			}//catch exception
		
		}//loop though
		
		String substring = equation.substring(point1);
		splitEquation.add(substring);		
		
		splitEquation.remove(0);//dont use -z.. rather -1*z
		
		//changes [2,+,-,1] to [2,+,-1]
		for(int i=0;i<splitEquation.size();i++){
			if(splitEquation.get(i).equals("-")){
				//checking if the next value is a double
				try{
					Double.valueOf(splitEquation.get(i+1));//if this works then the next item is a number
					boolean makeNegitive = false;
					if(i==0){
						makeNegitive = true;
					}else if(splitEquation.get(i-1).length()==1){
						char c = splitEquation.get(i-1).charAt(0);
						// System.out.println(c);
						if(c=='(' || c=='*' || c=='+' || c=='-' || c=='^'){//avoid |-1+3i| => use |(-1)+3i|
							makeNegitive = true;
						}
					}
					
					if(makeNegitive){
						splitEquation.add(i,"-"+splitEquation.get(i+1));
						splitEquation.remove(i+1);
						splitEquation.remove(i+1);
					}
				}catch(Exception e){
					continue;
				}//checking for double
			}
		}
		
		return splitEquation;
	}
	
	public static void main(String[] args){
		StringSplitter split = new StringSplitter();
		String equation = "--abs(z^2)-abs(z)^2";
		System.out.println(split.splitThis(equation));
	
	}//main
}//class
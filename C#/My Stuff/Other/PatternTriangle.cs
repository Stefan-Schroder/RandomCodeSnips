using System;

class PatternTriangle{
	
	public static void Main(string [] args){
		Functions FunctionObj = new Functions();
		int [] pattern = FunctionObj.GenSequence(7);
		
		for(int i=0;i<pattern.Size();i++){
			Console.WriteLine(pattern[i]);
		}
		System.Console.ReadLine();
	}
	
}

class Functions{
	public int[] GenSequence(int level){
		int [] pattern = new int[level];
		
		for(int i=0;i<level;i++){
			/*	Generating each number for the final pattern answers	 */
			int answer = 0;
			
			for(int j=0;j<=level;j++){
				/*	going through each variable (x^2) for x^2+x^1+x^0=n 
				 *	and adding it to the final answer 
				 */
				answer += Convert.ToInt32(Math.Pow(i,j));
			}
			
			//System.Console.Write("{0}, ",answer);
			pattern[i] = answer;
		}
		
		return pattern;
	}
}
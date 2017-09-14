class EquationTest{
	public static void main(String[] args){
		String equation = "x+5-x*x";
		for(int i=0;i<5;i++){
			int answer = Integer.valueOf(equation.replace("x",String.valueOf(i)));
			System.out.println(i+") "+answer);
		}
	}
}
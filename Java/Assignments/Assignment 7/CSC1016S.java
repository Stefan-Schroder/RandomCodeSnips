class CSC1016S implements Student{
	private String name;
	private float pracMark;
	private float pracTestMark;
	private float testMark;
	private float examMark;
	
	public CSC1016S(){
		name = "";
		pracMark = 0;
		pracTestMark = 0;
		testMark = 0;
		examMark = 0;
		
	}
	
	public void setName ( String name ){
		this.name = name;
	}
	
	public String getName (){
		return this.name;
	}
	
	public void setMark ( String category, int mark ){
		switch(category){
			case "pracs":
				pracMark = (float)mark;
				break;
				
			case "practests":
				pracTestMark = (float)mark;
				break;
				
			case "tests":
				testMark = (float)mark;
				break;
				
			case "exam":
				examMark = (float)mark;
				break;
		}
	}
	
	public float getFinal (){
		return (pracMark+pracTestMark+testMark+examMark)/4;
	}
}
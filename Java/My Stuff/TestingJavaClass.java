class TestingJavaClass{
	private String name;
	private int number;
	
	public TestingJavaClass(){
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public boolean equals(TestingJavaClass a){
		if(a.number==this.number){
			return true;
		}
		return false;
	}
}
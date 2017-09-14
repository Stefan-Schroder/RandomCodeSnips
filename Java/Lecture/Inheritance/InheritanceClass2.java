class InheritanceClass2 extends InheritanceClass{
	private String studentNumber;
	private String univercity;

	public InheritanceClass2(String name,int age, String studentNumber){
		super(name,age);
		this.studentNumber = studentNumber;
	}
	
	public void setStudentNumber(String studentNumber){
		this.studentNumber = studentNumber;
	}
	
	public void setUnivercity(String univercity){
		this.univercity = univercity;
	}
	
	public String getStudentNumber(){
		return studentNumber;
	}
	
	public String getUnivercity(){
		return univercity;
	}
}
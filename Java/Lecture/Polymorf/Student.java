class Student extends Person{
	public String studentNumber;
	public String course;
	
	public Student(String name, int age, String studentNumber, String course){
		super(name,age);
		this.studentNumber = studentNumber;
		this.course = course;
	}
	
	public void add(String a){
		this.studentNumber+= a;
	}
	
	public String toString(){
		return "Student: " + name + " " + studentNumber+" "+course;
	}
}
class Person{
	public String name;
	public int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void add(String a, int n){
		this.name+=a;
		this.age+=n;
	}
	
	public String toString(){
		return "Person: "+ name +" "+String.valueOf(age);
	}
}
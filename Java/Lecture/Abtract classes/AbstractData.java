/*
1)
the base class has the abstract class.
you can not make objects of an abstract class

			person
			|	|
		-----	---------
		|				|
	Student	   		  Tutor
	
with abstract methods you can only have a student or a tutor object and not a person.
you have to declare the person as abstract, and you have to override the methods in the abstract class, in its children
 
 
2)
what if a person was a studnet and a tutor.
Interfaces.
it is not a class
it must contain the name interface.
all methods must not contain any data only the headings
and no initaliastion of any variables.

*/
class AbstractData{
	public static void main(String[] args){
		// 1)
		// Person p = new Person(); You cannot declare a person object because it is abstract... run to crash your progam
		Student s = new Student();
		Tutor t = new Tutor();
		
		System.out.println(s.greet());
		System.out.println(t.greet());
		
		// 2)
		// an interface is not a class
	}
}
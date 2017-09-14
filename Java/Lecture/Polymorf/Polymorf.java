class Polymorf{
	public static void main(String[] args){
		Person p = new Person("Stefan",19);
		Student s = new Student("Bob",21,"BOBSTE054","ECE");
		
		System.out.println("Original");
		System.out.println(p.toString());
		System.out.println(s.toString());
		
		//=======================================================
		
		p = s;
		
		System.out.println("\np=s");
		System.out.println(p.toString());
		System.out.println(s.toString());
		
		//=======================================================
		
		p = new Person("Stefan",19);
		s = new Student("Bob",21,"BOBSTE054","ECE");
		
		p = (Person)s;
		
		System.out.println("\np=(Person)s");
		System.out.println(p.toString());
		System.out.println(s.toString());
		
		//=======================================================
		
		p = new Person("Stefan",19);
		s = new Student("Bob",21,"BOBSTE054","ECE");
		Tutor t = new Tutor("Sam",40,"Maths",5);
		
		Person [] pArray = new Person[5];
		pArray[0] = (Person)s;
		pArray[1] = (Person)p;
		pArray[2] = (Person)t;
		pArray[3] = (Person)new Student("John",18,"JOHFLK001","BSC");
		pArray[4] = (Person)new Tutor("Len",28,"Science",2);
		
		System.out.println("\nPollyarray "+s.getClass());
		
		for(int i=0;i<pArray.length;i++){
			try{
				if(pArray[i].getClass() == p.getClass()){
					pArray[i].add("a",1);
				}
				else if(pArray[i].getClass() == s.getClass()){
					pArray[i].add("b");
				}
				else if(pArray[i].getClass() == t.getClass()){
					pArray[i].add(2);
				}
			}catch(Exception e){
				System.out.println(e);
			}
			System.out.println(i+") "+pArray[i].toString()+" -class: "+pArray[i].getClass());
		}
		
		System.out.println("");
		
		for(Person q: pArray){
			System.out.println(q);
		}
	}
}
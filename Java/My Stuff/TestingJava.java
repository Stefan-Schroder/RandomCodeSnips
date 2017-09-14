class TestingJava{
	public static void main(String[] args){
		/*int i=1;
		if(1==i++){
			System.out.println("pp After");
		}if(2==i++){
			System.out.println("2 pp after");
		}
		i=1;
		if(2==++i){
			System.out.println("2 pp Befor");
		}
		
		System.out.println("i is "+i);
		System.out.println("=======");
		
		i=1;
		if(i==2 | ++i==2 && i*2==4){
			System.out.println("Both if i=2");
		}
		System.out.println("i is "+i);
		
		if(true&&(false||true)){
			System.out.println("Here");
		}*/
		
		TestingJavaClass b = new TestingJavaClass();
		b.setName("Stefan");
		b.setNumber(84854);
		if(b.equals(b)){
			System.out.println("Equals");
		}
	}
}
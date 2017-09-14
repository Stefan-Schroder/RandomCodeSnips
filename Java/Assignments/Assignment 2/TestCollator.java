class TestCollator{
	public static void main(String[] args){
		Tester t = new Tester();
		int totalRecords =0;
		int max =0;
		int min =0;
		int totalAdd =0;
		String label = "First";
		
		Collator One = new Collator(label);
		System.out.println("Test 1");
		if(One.label().equals(label)){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		System.out.println("Test 2");
		One.recordReading(1);
		totalRecords++;
		totalAdd=1;
		max = 1;
		min = 1;
		if(t.testValues(totalRecords,max,min,totalAdd,label,One)){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		System.out.println("Test 3");
		One.recordReading(-1);
		totalRecords++;
		totalAdd=0;
		max=1;
		min =-1;
		if(t.testValues(totalRecords,max,min,totalAdd,label,One)){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		System.out.println("Test 4");
		Collator Two = new Collator("Second");
		totalRecords=0;
		totalAdd = 0;
		max =0;
		min = 0;
		if(t.testValues(totalRecords,max,min,totalAdd,label,Two)){
			System.out.println("Fail");
		}else{
			System.out.println("Pass");
		}
		
		System.out.println("Test 5");
		label = "Second";
		if(Two==One){
			System.out.println("Fail");
		}else{
			System.out.prinltn("Pass");
		}//end if
		
		
	}
	
	
}

class Tester{
	public Tester(){}
	
	public boolean testValues(int totalRecords,int max,int min,int totalAdd,String label, Collator a){
		boolean working = true;
		if(!label.equals(a.label())){
			working = false;
		}
		if(max!=a.maximum()){
			working = false;
		}
		if(min!=a.minimum()){
			working = false;
		}
		if(totalRecords!=0 && totalAdd/totalRecords!=a.average()){
			working = false;
		}
		if(totalRecords!=a.numberOfReadings()){
			working = false;
		}
		return working;
	}
}
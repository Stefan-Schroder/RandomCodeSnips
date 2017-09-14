class TestJumpRecord{
	public static void main(String[] args){
		JumpRecord One = new JumpRecord();
		
		System.out.println("Test 1");
		if(One.jumps()==0 &&
		   One.finished()==false &&
		   One.foulJumps()==0){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		One.recordFoulJump();
		System.out.println("Test 2");
		try{
			One.getLongest();
			System.out.println("Pass");
		}catch(Exception e){
			System.out.println("Fail");
		}
		
		System.out.println("Test 3");
		try{
			One.getJumpDistance(1);
			System.out.println("Pass");
		}catch(Exception e){
			System.out.println("Fail");
		}
		
		One.recordJump(2.5);
		System.out.println("Test 4");
		if(One.getJumpDistance(2)==2.5 &&
		   One.getLongest()==2.5){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		System.out.println("Test 5");
		for(int i=1;i<One.maxJumps()-1;i++){
			One.recordFoulJump();
		}
		try{
			One.recordFoulJump();
			System.out.println("Fail");
		}catch(Exception e){
			System.out.println("Pass");
		}
		
		JumpRecord two = new JumpRecord();
		System.out.println("Test 6");
		if(One==two){
			System.out.println("Fail");
		}else{
			System.out.println("Pass");
		}
		
		System.out.println("Test 7");
		try{
			two.recordJump("2");
			System.out.println("Fail");
		}catch(Exception e){
			System.out.println("Pass");
		}
		
		
	}
}
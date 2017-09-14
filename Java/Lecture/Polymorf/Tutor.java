class Tutor extends Person{
	private String tutCorse;
	private int sessionsPerWeek;
	
	public Tutor(String name,int age, String tutCorse, int sessionsPerWeek){
		super(name,age);
		this.tutCorse = tutCorse;
		this.sessionsPerWeek = sessionsPerWeek;
	}
	
	public void add(int n){
		this.sessionsPerWeek+=n;
	}
	
	public String toString(){
		return "Tutor: "+ name + " " + tutCorse + " " + String.valueOf(sessionsPerWeek);
	}
}
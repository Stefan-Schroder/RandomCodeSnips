class Plane extends Vehicle{
	private String name;
	private int number;
	public Plane(String color, int passengers, String name, int number){
		super(passengers,color);
		this.name = name;
		this.number = number;
	}
	
	public String toString(){
		return super.toString() + " " + name + " " + String.valueOf(number);
	}
}
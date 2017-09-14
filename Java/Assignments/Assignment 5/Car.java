class Car extends Vehicle{
	private int amountOfDoors;
	
	public Car(String color, int passengers, int doors){
		super(passengers,color);
		this.amountOfDoors = doors;
	}
	
	public String toString(){
		return super.toString()+" "+String.valueOf(amountOfDoors)+" doors";
	}
}
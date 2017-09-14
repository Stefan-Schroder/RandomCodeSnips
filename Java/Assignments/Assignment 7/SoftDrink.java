class SoftDrink implements Comparable{
	private String name;
	private String colour;
	private int volume;
	
	public SoftDrink(String name, String colour, int volume){
		this.name = name;
		this.colour = colour;
		this.volume = volume;
	}
	
	public String toString(){
		return name+" "+colour+" "+volume;
	}
	
	public int compareTo(Object o){
		if(this.name.equals(((SoftDrink)o).name)){
			
			if(this.colour.equals(((SoftDrink)o).colour)){
				
				if(this.volume==((SoftDrink)o).volume){
					return 0;
				}else if(this.volume>((SoftDrink)o).volume){
					return 1;
				}else{
					return -1;
				}
				
			}else{
				return this.colour.compareTo(((SoftDrink)o).colour);
			}	
			
		}else{
			return this.name.compareTo(((SoftDrink)o).name);
			
		}
	}
}
class SoftDrink extends menu{
	private String flavour;
	private String bottle;
	
	public SoftDrink(String number, String size, String flavour, String bottle){
		super(number,size);
		this.flavour = flavour;
		this.bottle = bottle;
	}
	
	public String toString(){
		return "Soft Drink: "+super.toString()+flavour+", "+bottle;
	}
}
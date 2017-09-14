class Pizza extends menu{
	private String base;
	private boolean extraCheese;
	private boolean extraGarlic;
	
	public Pizza(String number, String size, String base, boolean cheese, boolean garlic){
		super(number,size);
		this.base = base;
		this.extraCheese = cheese;
		this.extraGarlic = garlic;
	}
	
	public String toString(){
		return "Pizza: "+
				super.toString()+
				base+", "+
				((extraCheese) ? "Yes, " : "No, ")+
				((extraGarlic) ? "Yes" : "No");
	}
}
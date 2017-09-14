class Curry extends menu{
	private String type;
	
	public Curry(String number , String size ,String type){
		super(number,size);
		this.type = type;
	}
	
	public String toString(){
		return "Curry: "+super.toString()+type;
	}
}
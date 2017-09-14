class menu{
	private String menuNumber;
	private String size;
	
	public menu(String menuNumber, String size){
		this.menuNumber = menuNumber;
		this.size = size;
	}
	
	public String getMenuNumber(){
		return menuNumber;
	}
	
	public String toString(){
		return menuNumber+", "+size+", ";
	}
}
class Money{
	private Currency currency;
	private long minorUnitAmount;
	
	public Money(String amount, Currency currency){
		this.currency = currency;
		this.minorUnitAmount = currency.parse(amount);
	}
	
	public Money(long minorUnitAmount, Currency currency){
		this.currency = currency;
		this.minorUnitAmount = minorUnitAmount;
	}
	
	public long longAmount(){
		return minorUnitAmount;
	}
	
	public Currency currency(){
		return currency;
	}
	
	public Money add(Money other){
		if(other.currency().code()==this.currency.code()){
			this.minorUnitAmount+= other.longAmount();
		}
		return minorUnitAmount;
	}
	
	public Money subtract(Money other){
		if(other.currency().code()==this.currency.code()){
			this.minorUnitAmount -= other.longAmount();
		}
		Money newMoney = new Money(this.minorUnitAmount,this.currency);
		return newMoney;
	}
	
	public String toString(){
		return currency.format(minorUnitAmount);
	}
}
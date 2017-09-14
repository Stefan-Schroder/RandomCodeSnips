import java.text.DecimalFormat;

class Currency{
	private String symbol;
	private String code;
	private int minorPerMajor;
	private DecimalFormat df;
	
	public Currency(String symbol, String code, int minorPerMajor){
		this.symbol = symbol;
		this.code = code;
		this.minorPerMajor = minorPerMajor;
		this.df = new DecimalFormat(String.valueOf(minorPerMajor/minorPerMajor));
		this,df = ne
	}
	
	public String symbol(){
		return symbol;
	}
	
	public String code(){
		return code;
	}
	
	public int minorPerMajor(){
		return minorPerMajor;
	}
	
	public String format(long amount){
		double newValue = double.valueOf(amount)/double.valueOf(minorPerMajor);
		String strValue = String.format("%.2f",newValue);
		String value = symbol+newValue;
		return value;
	}
	
	public long parse(String amount){
		int multiplyer = 1;
		if(amount.charAt(0)=='-'){
			multiplyer = -1;
			amount = amount.substring(1);
		}
		amount = amount.substring(1);
		long newAmount = multiplyer*Long.valueOf(amount)*minorPerMajor;
		return newAmount;		
	}
}
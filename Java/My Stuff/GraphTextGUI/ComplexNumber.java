import java.math.*;

public class ComplexNumber{
	private double real;
	private double imaginary;
	
	public ComplexNumber(){
		this.real = 0.0;
		this.imaginary = 0.0;
	}
	
	public ComplexNumber(double real,double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public ComplexNumber(String number){
		this.real = round(Double.valueOf(number.substring(0,number.indexOf("+"))),10);
		this.imaginary = round(Double.valueOf(number.substring(number.indexOf("+")+1,number.indexOf("i"))),10);
	}
	
	public ComplexNumber plus(ComplexNumber n){
		this.real+=n.real;
		this.imaginary+=n.imaginary;
		return this;
	}
	
	public ComplexNumber minus(ComplexNumber n){
		this.real-=n.real;
		this.imaginary-=n.imaginary;
		return this;
	}
	
	public ComplexNumber multiply(ComplexNumber n){
		double first = this.real*n.real;
		double third = this.real*n.imaginary;
		double second = this.imaginary*n.real;
		double fourth = -1*this.imaginary*n.imaginary;
		
		this.real = first+fourth;
		this.imaginary = third+second;
		
		return this;
	}
	
	public double getReal(){
		return real;
	}
	
	public double getImaginary(){
		return imaginary;
	}
	
	public String toString(){
		return real+"+"+imaginary+"i";
	}
	
	public double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
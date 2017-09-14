using System;
class BinaryToDecimal{
	public static void Main(string [] args){
		Console.Write("Enter in Binary number: ");
		long BinaryNumber = Console.ReadLine();
		long Start = 0;
		for(int i=0;i<BinaryNumber.ToString().Length();i++){
			string Bit = BinaryNumber.ToString.CharAt(i);
			Console.WriteLine(Bit);
		}
		Console.ReadLine();
	}//end main
}
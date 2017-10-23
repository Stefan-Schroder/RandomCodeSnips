using System.Collections.Generic;
using System;
using System.Windows.Forms;

class GetAttr{
	public static void Main(string[] args){
		//List<string> get = new List<string>();
		RichTextBox get = new RichTextBox();
		int Counter = 0;
		while(true){
			try{
				Console.WriteLine(get.GetType().GetProperties().GetValue(Counter));
				Counter++;
			}catch(Exception e){
				//Console.WriteLine(e);
			}
		}
		Console.ReadLine();
	}
}
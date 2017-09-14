using System;
using System.Collections;

public class ArrayListTesting{
	public static void Main(string[] args){
		Functions Extra = new Functions();
		
		Arraylist<string> List1 = new Arraylist<string>();
		List1.Add("hello");
		List1.Add("World");

		
		Arraylist<string> List2 = new Arraylist<string>();
		List2.Add("this");
		List2.Add("is");
		List2.Add("a");
		List2.Add("Test");

		//List1.Add(List2);
		//List1.Potato();
		Extra.PrintSentance(List1);
		
		System.Console.ReadLine();//to keep running
	}
	
}

public class Functions{
	public void PrintList(ArrayList List){
		foreach(String item in List){
			Console.WriteLine(item);
		}
	}
	
	public void PrintSentance(ArrayList List){
		foreach(String item in List){
			Console.Write("{0} ",item);
		}
	}
}

public class Arraylist<T> : ArrayList{
	/*public void AddList(Arraylist list){
		foreach(object item in list){
			//not done
		}
	}*/
}
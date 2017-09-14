using System.Collections;
using System.IO.Ports;
using System;
using System.Threading;
public class main{
	public static void Main(string[] args){
		ComTester Test = new ComTester();
		while(true){	
			Test.Update();
		}
	}
}
public class ComTester{
	public static SerialPort sp = new SerialPort("COM2", 115200, Parity.None, 8, StopBits.One);
	public string message, message1;
	public string message2;
	
	public ComTester(){
		OpenConnection();
	}
	
	public void Update(){
		//Console.WriteLine(sp.ReadExisting());
		
		//sp.WriteLine("1");
		try{
		
			message2 = Convert.ToString(sp.ReadLine());
		}catch (TimeoutException) {}
		//Thread.Sleep(200);
		
		sp.WriteLine("2");
		//Console.WriteLine(sp.ReadExisting());
		Console.WriteLine(": "+message2);
	}
	
	public void OpenConnection(){
		Console.WriteLine("1");
		if(sp!=null){
			if(sp.IsOpen){
				Console.WriteLine("2");
				sp.Close();
				message = "Port closed, because it was already open.";
			}else{
				Console.WriteLine("3");
				sp.Open();
				Console.WriteLine("3.1");
				sp.ReadTimeout = 1000;
				Console.WriteLine("3.2");
				message = "Port Opened!";
			}
		}else{
			Console.WriteLine("4");
			if(sp.IsOpen){
				Console.WriteLine("5");
				Console.WriteLine("Port is already Open");
			}else{
				Console.WriteLine("6");
				Console.WriteLine("Port == null");
			}
		}
	}//hullow
	
	void OnApplicationQuit(){
		sp.Close();
	}
}
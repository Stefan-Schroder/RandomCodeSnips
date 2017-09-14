using System;
using System.Windows.Forms;
using System.Threading;

namespace CarController{
	public class Controller :Form{
		public Controller(){
			Console.WriteLine("done");
		}
		
		public static void Main(String[] args){
			Application.Run(new Controller());
		}
	}
	
}
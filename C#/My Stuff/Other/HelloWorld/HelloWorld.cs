using System;
using System.Windows.Forms;

namespace HelloWin{
	public class MyForm : Form{
		private TextBox txtEnter;
		private Label lblDisplay;
		private Button btnOk;
		
		public MyForm(){
			this.txtEnter = new TextBox();
			this.lblDislay = new Label();
			this.btnOk = new Button();
			this.Text = "My HelloWin App!";
			
			//txt Enter
			this.txtEnter.Location = new System.Drawing.Point (16, 32);
			this.txtEnter.Size = new System.Drawing.Size(264, 20);
			
			//lblDisplay
			this.lblDisplay.Location = new System.Drawing.Location(16, 72);
			this.lblDisplay.Size = new System.Drawing.Size(264,128);
			
			//btnOk
			this.btnOk.Location = new System.Drawing.Location(88, 224);
			this.btnOk.Text = "Ok";
			this.btnOk.Click += new System.EventHandler(this.btnOk_Click);
			
			//MyForm 
			this.Controls.AddRange(new Control[] {	this.txtEnter, 
													this.lblDisplay, 
													this.btnOk});
		}//end form
		
		static void Main(){
			Application.Run(new MyForm());
		}//end main
		
		private void btnOk_Click(object sender, System.EventArgs e){
			lblDisplay.Text = txtEnter.Text + "\n" + lblDisplay.Text;
		}//end button click
	}
}

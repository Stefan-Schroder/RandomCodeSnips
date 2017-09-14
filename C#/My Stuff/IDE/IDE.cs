using System;
using System.Drawing;
using System.Windows.Forms;
using System.Threading;
using System.Collections.Generic;

namespace CSharpGUI {
    public class IDE : Form {
		
        public IDE() {
            InitializeComponents();
        }
		
		private void InitializeVariables(){
			LineList = new List<string>();
			LineCounter = 0;
		}
		
		private void Updater(){
			while(true){
				this.Text = "Lines: "+Convert.ToString(LineCounter)/*+
							" - Selection Start: "+Convert.ToString(MainText.SelectionStart)*/;
			}
		}
		
		public void InitializeComponents(){
			Thread StartUpdate = new Thread(Updater);
			StartUpdate.Start();
			
			this.MainText = new RichTextBox();
			
			MainText.Name = "MainText";
            MainText.Size = new Size(1000, 700);
			MainText.BorderStyle = BorderStyle.None;
			MainText.TextChanged += new EventHandler(TextChanged);
			MainText.KeyDown += new KeyEventHandler(MainKeyDown);
			
			//Main Page
			this.ClientSize = new System.Drawing.Size(1500,800);
			this.Controls.Add(this.MainText);
			this.MaximizeBox = true;
			this.Name = "IDE";
			this.Text = "Testing IDE";
			this.ResumeLayout(false);
			
			
		}//end initialize
		
		private void MainKeyDown(object sender, KeyEventArgs e){
			if(e.KeyData == Keys.Return){
				LineCounter++;
				Console.WriteLine(MainText.SelectionStart);
			}
		}
		
		private void TextChanged(object sender, EventArgs e){
			
		}
		
		private void CheckKeyword(string word, Color color, int startIndex)
		{
			if (this.MainText.Text.Contains(word))
			{
				int index = -1;
				int selectStart = this.MainText.SelectionStart;

				while ((index = this.MainText.Text.IndexOf(word, (index + 1))) != -1)
				{
					this.MainText.Select((index + startIndex), word.Length);
					this.MainText.SelectionColor = color;
					this.MainText.Select(selectStart, 0);
					this.MainText.SelectionColor = Color.Black;
				}
			}
		}
		
        public static void Main(String[] args) {
            Application.Run(new IDE());
        }
		
		private int LineCounter;
		private List<string> LineList;		
		private System.Windows.Forms.RichTextBox MainText;
    }
}

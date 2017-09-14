using System;
using System.Drawing;
using System.Windows.Forms;
using System.Threading;
using System.Collections.Generic;
using System.Windows;

namespace CSharpGUI {
    public class IDE2 : Form {
		
        public IDE2() {
			Startup();
            InitializeComponents();
        }
		
		private void Updater(){
			while(true){
				Thread.Sleep(100);
				
				this.Text = "Lines: "+Convert.ToString(LineCounter)+
							" - WantedCaretHeight: "+Convert.ToString(WantedCaretHeight)+
							" - LineShiftDown: "+Convert.ToString(LineShiftDown)+
							" Start:"+Convert.ToString(LineShiftDownStart)+
							" End:"+Convert.ToString(LineShiftDownEnd)+
							" CurrentLine: "+Convert.ToString(CurrentFocusLine);
			}
		}
		
		private void Startup(){
			WantedCaretHeight = -1;
			LineList = new List<RichTextBox>();
			LineCounter = 0;
			CurrentFocusLine = 0;
		}//end startup
		
		private void InitializeComponents(){
			Thread StartUpdate = new Thread(Updater);
			StartUpdate.Start();
			
			//first line
			this.MainText = new RichTextBox();
			AddLine(MainText);
			LineList.Add(MainText);
			
			//Main Page
			this.ClientSize = new System.Drawing.Size(1500,800);
			this.MaximizeBox = true;
			this.Name = "IDE";
			this.Text = "Testing IDE";
			this.ResumeLayout(false);
			
			
		}//end initialize
		
		private void AddLine(RichTextBox Line){
			LineCounter++;
			Line.Name = Convert.ToString(LineCounter);
            Line.Size = new Size(1000, 15);
			Line.BorderStyle = BorderStyle.None;
			Line.Multiline = false;
			Line.HideSelection = false;
            Line.Location = new Point(10,15*LineCounter);
			Line.TextChanged += new System.EventHandler(TextChangedEvent);
			Line.KeyDown += new KeyEventHandler(LineKeyPressed);
			Line.KeyUp += new KeyEventHandler(LineKeyRelease);
			Controls.Add(Line);
			ActiveControl = Line;
		}
		
		private void LineKeyRelease(object sender, KeyEventArgs e){
			RichTextBox Line = (RichTextBox)sender;
			int LineNumber = Convert.ToInt32(Line.Name);
			
			if(Convert.ToString(e.KeyData) == "ShiftKey"){
				LineShiftDown = false;
				LineShiftDownEnd = LineNumber;
			}
		}//end line key release
		
		private void LineKeyPressed(object sender, KeyEventArgs e){
			RichTextBox Line = (RichTextBox)sender;
			int LineNumber = Convert.ToInt32(Line.Name);
			RichTextBox NextLine = (LineNumber<LineCounter) ? LineList[LineNumber] : new RichTextBox();
			RichTextBox PrevLine = (LineNumber>1) ? LineList[LineNumber-2] : new RichTextBox();
			
			
			
			if(e.KeyData == Keys.Enter){//EnterLine
				e.Handled = true;
				e.SuppressKeyPress = true;
				
				this.MainText = new RichTextBox();
				AddLine(MainText);
				LineList.Add(MainText);
				int CurrentLineNumber = Convert.ToInt32(Line.Name);
				if(CurrentLineNumber<LineCounter-1){
					for(int i=LineCounter;i>CurrentLineNumber;i--){
						RichTextBox CurrentLine = (RichTextBox)LineList[i-2];
						RichTextBox PreviousLine = (RichTextBox)LineList[i-1];
						string CurrentLineText = CurrentLine.Text;
						PreviousLine.Text = CurrentLineText;
					}
					RichTextBox TheNewLine = (RichTextBox)LineList[CurrentLineNumber];
					TheNewLine.Text = "";
					ActiveControl = TheNewLine;
					CurrentFocusLine = Convert.ToInt32(TheNewLine.Name);
				}
			}
			
			if(e.KeyData == Keys.Back){//removing line
				if(Line.SelectionStart==0 && Line.Name!="1"){
					e.Handled = true;
					e.SuppressKeyPress = true;
					
					string LeftOverText = Line.Text;
					int CurrentLineNumber = Convert.ToInt32(Line.Name)-1;
					
					ActiveControl = LineList[CurrentLineNumber-1];
					int CaretPosition = LineList[CurrentLineNumber-1].Text.Length;
					LineList[CurrentLineNumber-1].AppendText(LeftOverText);
					//Moveing the caret
					LineList[CurrentLineNumber-1].Select(CaretPosition,0);
					LineList[CurrentLineNumber-1].ScrollToCaret();
					
					//moving lines up
					for(int i=CurrentLineNumber;i<this.LineCounter-1;i++){
						LineList[i].Text = LineList[i+1].Text;
					}
					Controls.Remove(LineList[LineCounter-1]);
					LineList.RemoveAt(LineCounter-1);
					LineCounter--;
					CurrentFocusLine = Convert.ToInt32(PrevLine.Name);
				}
			}
			
			if(e.KeyData == Keys.Delete){//delete key
				if(Line.SelectionStart== Line.Text.Length && Line.Name!=Convert.ToString(LineCounter)){
					string LeftOverText = " "+NextLine.Text;
					int CaretPosition = Line.Text.Length;
					
					Line.AppendText(LeftOverText);
					for(int i=LineNumber;i<LineCounter-1;i++){
						LineList[i].Text = LineList[i+1].Text;
					}
					Controls.Remove(LineList[LineCounter-1]);
					LineList.RemoveAt(LineCounter-1);
					LineCounter--;
					Line.Select(CaretPosition,0);
					Line.ScrollToCaret();
				}
			}
			
			if(e.KeyData == Keys.Up){//up
				if(Line.Name!="1"){
					e.Handled = true;
					e.SuppressKeyPress = true;
					
					if(WantedCaretHeight==-1)
						this.WantedCaretHeight = Line.SelectionStart;
					ActiveControl = LineList[Convert.ToInt32(Line.Name)-2];
					if(PrevLine.Text.Length>WantedCaretHeight){
						PrevLine.Select(WantedCaretHeight,0);
						PrevLine.ScrollToCaret();
					}else{
						PrevLine.Select(PrevLine.Text.Length,0);
						PrevLine.ScrollToCaret();
					}
					
					CurrentFocusLine = Convert.ToInt32(PrevLine.Name);
				}
			}//end up
			
			if(e.KeyData == Keys.Down){//down
				if(Line.Name!=Convert.ToString(LineCounter)){
					e.Handled = true;
					e.SuppressKeyPress = true;
					
					if(WantedCaretHeight==-1)
						this.WantedCaretHeight = Line.SelectionStart;
					ActiveControl = NextLine;
					if(NextLine.Text.Length>WantedCaretHeight){
						NextLine.Select(WantedCaretHeight,0);
						NextLine.ScrollToCaret();
					}else{
						NextLine.Select(NextLine.Text.Length,0);
						NextLine.ScrollToCaret();
					}
					
					CurrentFocusLine = Convert.ToInt32(NextLine.Name);
				}
			}//end down
			
			if(e.KeyData == Keys.Left){//left
				WantedCaretHeight = -1;
				if(Line.SelectionStart==0 && Line.Name!="1"){
					e.Handled = true;
					e.SuppressKeyPress = true;
					
					ActiveControl = PrevLine;
					PrevLine.Select(PrevLine.Text.Length,0);
					PrevLine.ScrollToCaret();
				}
			}//end left
			
			if(e.KeyData == Keys.Right){//right
				WantedCaretHeight = -1;
				if(Line.SelectionStart==Line.Text.Length && Line.Name!=Convert.ToString(LineCounter)){
					e.Handled = true;
					e.SuppressKeyPress = true;
					
					ActiveControl = NextLine;
					NextLine.Select(0,0);
					NextLine.ScrollToCaret();
				}
			}
			
			if(e.Modifiers == Keys.Shift){
				if(e.KeyCode==Keys.Down){
					if(Line.Name!=Convert.ToString(LineCounter)){
						CurrentFocusLine = Convert.ToInt32(NextLine.Name);
						
						e.Handled = true;
						e.SuppressKeyPress = true;
						
						
						if(WantedCaretHeight==-1)
							this.WantedCaretHeight = Line.SelectionStart;
						ActiveControl = NextLine;
						
						if(CurrentFocusLine==LineShiftDownStart){
							Line.SelectionLength = 0;
							NextLine.SelectionLength = 0;
							NextLine.Select(WantedCaretHeight,0);
							NextLine.ScrollToCaret();
						}else if(NextLine.SelectedText!=""){
							Line.SelectionLength = 0;
							NextLine.SelectionLength = 0;
							NextLine.Select(WantedCaretHeight,NextLine.Text.Length);
						}else{
							if(Line.Name==Convert.ToString(LineShiftDownStart)){
								Line.Select(WantedCaretHeight,Line.Text.Length);
							}else{
								Line.SelectAll();
							}	
							
							if(NextLine.Text.Length>WantedCaretHeight){
								NextLine.Select(0,WantedCaretHeight);
							}else{
								NextLine.Select(0,NextLine.Text.Length);
							}
						}
						
						
						
					}//down
				}else if(e.KeyCode==Keys.Up){
					if(Line.Name!="1"){
						CurrentFocusLine = Convert.ToInt32(PrevLine.Name);
						
						e.Handled = true;
						e.SuppressKeyPress = true;
						
						if(WantedCaretHeight==-1)
							this.WantedCaretHeight = Line.SelectionStart;

						ActiveControl = LineList[Convert.ToInt32(Line.Name)-2];
						
						if(CurrentFocusLine==LineShiftDownStart){
							PrevLine.SelectionLength=0;
							Line.SelectionLength=0;
							PrevLine.Select(WantedCaretHeight,0);
							PrevLine.ScrollToCaret();
						}else if(PrevLine.SelectedText!=""){
							PrevLine.SelectionLength=0;
							Line.SelectionLength=0;
							PrevLine.Select(0,WantedCaretHeight);
						}else{
							if(Line.Name==Convert.ToString(LineShiftDownStart)){
								Line.Select(0,WantedCaretHeight);
							}else{
								Line.SelectAll();
							}
							
							if(PrevLine.Text.Length>WantedCaretHeight){
								PrevLine.Select(WantedCaretHeight,PrevLine.Text.Length);
							}else{
								PrevLine.Select(PrevLine.Text.Length,0);
							}
						}
						
					}	
				}
				
				LineShiftDownEnd = LineNumber;
				if(!LineShiftDown){
					LineShiftDownStart = LineNumber;
					LineShiftDownEnd = -1;
				}
				LineShiftDown = true;
			}
			
		}
		private void DoForSelected(string Task){
			switch(Task){
				case "Delete":
					
					break;
			}
		}
		private void TextChangedEvent(object sender, EventArgs e){
			WantedCaretHeight = -1;
			RichTextBox Line = (RichTextBox)sender;
			CheckKeyword(Line, "String", Color.Aqua, 0);
			CheckKeyword(Line, "Char", Color.Green, 0);
		}
		
		private void CheckKeyword(RichTextBox Line, string word, Color color, int startIndex){
			if (Line.Text.Contains(word)){
				int index = -1;
				int selectStart = Line.SelectionStart;

				while ((index = Line.Text.IndexOf(word, (index + 1))) != -1){
					Line.Select((index + startIndex), word.Length);
					Line.SelectionColor = color;
					Line.Select(selectStart, 0);
					Line.SelectionColor = Color.Black;
				}//end while
			}//end if
		}//end checkword
		
        public static void Main(String[] args) {
            Application.Run(new IDE2());
        }
		
		private int WantedCaretHeight;
		private int LineCounter;
		
		//Selection
		private bool LineShiftDown;
		private int LineShiftDownStart;
		private int LineShiftDownEnd;
		private string LineShiftDownPrevKey;
		
		private int CurrentFocusLine;
		
		private System.Windows.Forms.RichTextBox MainText;
		private List<RichTextBox> LineList;
    }
}

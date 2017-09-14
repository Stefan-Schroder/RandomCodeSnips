import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main extends JFrame{
	
	public Main(){
		initialize();
	}
	
	public void initialize(){
		//{ Main
		this.setSize(1000,500);
		this.setTitle("Syther");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//}
		
		//{ Panels
		
			//{ Top
				pnlTop = new JPanel();
				pnlTop.setLayout(new BorderLayout());
				this.add(pnlTop, BorderLayout.NORTH);
			//}
		
			//{ Center
				pnlCenter = new JPanel();
				pnlCenter.setLayout(new GridLayout(1,1));
				this.add(pnlCenter, BorderLayout.CENTER);
			//}
			
			//{ Bottom
				pnlBottom = new JPanel();
				pnlBottom.setLayout(new BorderLayout());
				this.add(pnlBottom, BorderLayout.SOUTH);
			//}
		//}
		
		//{ Items
		
			//{ Setup
			
				//{ Buttons
				
					//{ Save
						btnSave = new JButton("Save");
						btnSave.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								btnSaveAction(e);
							}
						});
					//}
				//}
				
				//{ Text
					
					//{ FileName
						txfFileName = new JTextField();
					//}
					
					//{ Main Area
						txaMain = new JTextArea();
					//}
				//}
			//}
			
			//{ Setout
				
				//{ pnlTop
					pnlTop.add(txfFileName, BorderLayout.CENTER);
					pnlTop.add(btnSave, BorderLayout.EAST);
				//}
			//}
		//}
	}
	
	//{ Listeners
	public void btnSaveAction(ActionEvent e){
		System.exit(0);
	}
	//}
	
	
	public static void main(String [] args){
		Main gui = new Main();
		gui.setVisible(true);
	}
	
	//{ Initialize variables
	//Panels
	private JPanel pnlCenter;
	private JPanel pnlBottom;
	private JPanel pnlTop;
	
	//Buttons
	private JButton btnSyther;
	private JButton btnSave;
	
	//Text
	private JTextArea txaMain;
	private JTextField txfFileName;
	
	//}
}
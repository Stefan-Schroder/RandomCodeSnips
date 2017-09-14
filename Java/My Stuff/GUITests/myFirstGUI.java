import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class myFirstGUI extends JFrame implements ActionListener{
	
	public myFirstGUI(){
		initialize();
		
	}//end constructor
	
	public void initialize(){
		//{ set Layout
		this.setTitle("My first GUI");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//}
		
		//{ add Panels
		pnlSouth = new JPanel();
		pnlEast = new JPanel();
		pnlWest = new JPanel();
		pnlCenter = new JPanel();
		//}
		
		//{ add elements
		mnuColorExit = new JMenu("Move Exit Button");
		mnbMainBar = new JMenuBar();
		
		btnExit = new JButton("Click to end program.");
		lblExit = new JLabel("This is a GUI Test.");
		
		txfAddLabel = new JTextField("Enter text",10);
		btnAddLabel = new JButton("Add Label");
		
		lblMainAreaLabel = new JLabel("Text area:");
		txaMainArea = new JTextArea("Text:",30,30);
		scpMainArea = new JScrollPane();
		//}
		
		//{ mnuColorExit 
		JMenuItem mniWhite = new JMenuItem("WHITE");
		JMenuItem mniBlue = new JMenuItem("BLUE");
		JMenuItem mniRed = new JMenuItem("RED");
		
		mniWhite.addActionListener(this);
		mnuColorExit.add(mniWhite);
		
		mniBlue.addActionListener(this);
		mnuColorExit.add(mniBlue);
		
		mniRed.addActionListener(this);
		mnuColorExit.add(mniRed);
		//}
		
		//{ mnbMainBar
		mnbMainBar.add(mnuColorExit);
		this.setJMenuBar(mnbMainBar);
		//}
		
		//{ pnlWest
		this.add(pnlWest, BorderLayout.WEST);
		pnlWest.setLayout(new GridLayout(2,1));
		//}
		
		//{ pnlEast
		this.add(pnlEast, BorderLayout.EAST);
		pnlEast.setLayout(new GridLayout(10,1));
		//}
		
		//{ pnlSouth
		this.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new BorderLayout());
		//}
		
		//{ pnlCenter
		this.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout());
		//}
		
		//{ btnExit
		pnlSouth.add(btnExit, BorderLayout.EAST);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				exitButtonAction(e);
			}
		});
		//}
		
		//{ lblExit
		this.add(lblExit, BorderLayout.NORTH);
		//}
		
		//{ txfAddLabel
		pnlWest.add(txfAddLabel);	
		//}
		
		//{ btnAddLabel
		pnlWest.add(btnAddLabel);
		btnAddLabel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addLabelButtonAction(e);
			}
		});
		//}
		
		//{ lblMainAreaLabel
		pnlCenter.add(lblMainAreaLabel, BorderLayout.NORTH);
		//}
		
		//{ scpMainArea
		pnlCenter.add(scpMainArea,BorderLayout.CENTER);
		scpMainArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpMainArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//}
		
		//{ txaMainArea
		scpMainArea.setViewportView(txaMainArea);
		//}
		
	}//end initialize
	
	//{ Listeners
	public void exitButtonAction(ActionEvent e){
		System.exit(0);
	
	}//end action performed
	
	public void addLabelButtonAction(ActionEvent e){
		JLabel newLabel = new JLabel(txfAddLabel.getText());
		
		labelArray.add(newLabel);
		pnlEast.add(labelArray.get(labelCounter));
		labelArray.get(labelCounter).setVisible(true);
		
		txfAddLabel.setText("");
		labelCounter++;
		this.revalidate();
		
	}//
	
	public void actionPerformed(ActionEvent e){
		String newName = e.getActionCommand();
		
		switch(newName){
			case "WHITE":
				btnExit.setBackground(Color.WHITE);
				break;
			case "RED":
				btnExit.setBackground(Color.RED);
				break;
			case "BLUE":
				btnExit.setBackground(Color.BLUE);
				break;
		}
		
	}//end default listener
	//}
	
	public static void main(String[] args){
		myFirstGUI GUI = new myFirstGUI();
		GUI.setVisible(true);
	
	}//end run
	
	//{ declare components
	private JPanel pnlSouth;
	private JPanel pnlEast;
	private JPanel pnlWest;
	private JPanel pnlCenter;
	
	private JScrollPane scpMainArea;
	private JTextArea txaMainArea;
	private JLabel lblMainAreaLabel;
	
	private JButton btnExit;
	private JLabel lblExit;
	
	private JMenu mnuColorExit;
	private JMenuBar mnbMainBar;
	
	private JButton btnAddLabel;
	private JTextField txfAddLabel;
	private ArrayList<JLabel> labelArray = new ArrayList<JLabel>();
	private int labelCounter = 0;
	//}
	
}//end main
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class GraphTextGUI extends JFrame implements ActionListener{
	
	public GraphTextGUI(){
		initialize();
	}
	
	public void initialize(){
		//{ Layout
		this.setSize(1000,1000);
		this.setTitle("Text grapher");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//}
		
		//{ Pannels
		
		//{ pnlWest
		pnlWest = new JPanel();
		pnlWest.setLayout(new GridLayout(8,1));
		this.add(pnlWest, BorderLayout.WEST);
		//}
		
		//{ pnlEast
		/*pnlEast = new JPanel();
		pnlEast.setLayout()*/
		//}
		
		//{ pnlNorth
		pnlNorth = new JPanel();
		pnlNorth.setLayout(new FlowLayout());
		this.add(pnlNorth, BorderLayout.NORTH);
		//}
		
		//{ pnlCenter
		pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(1,1));
		this.add(pnlCenter, BorderLayout.CENTER);
		//}
		
		//{ pnlSouth
		pnlSouth = new JPanel();
		pnlSouth.setLayout(new FlowLayout());
		this.add(pnlSouth, BorderLayout.SOUTH);
		//}
		
		//}
		
		//{ Elements
			//{ initialize Elements
				//TextFields
				txfCondition1 = new JTextField(10);
				txfCondition2 = new JTextField(10);
				txfCondition3 = new JTextField(10);
				txfCondition4 = new JTextField(10);
			
				//Labels
				lblCondition1 = new JLabel("Condition1:");
				lblCondition2 = new JLabel("Condition2:");
				lblCondition3 = new JLabel("Condition3:");
				lblCondition4 = new JLabel("Condition4:");
				
				//Buttons
				btnPlot = new JButton("Plot");
				btnPlot.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plotButtonAction(e);
					}
				});
				
				btnReset = new JButton("Reset");
				btnReset.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						resetButtonAction(e);
					}
				});
				
				//Extras
				txaMainGraph = new JTextArea(100,100);
				txaMainGraph.setFont(new Font("Lucida Console",0,13));
				
				scpGraphScroll = new JScrollPane();
				
			//}
			
			//{ add elements
				//WestPanel;
				pnlWest.add(lblCondition1);
				pnlWest.add(txfCondition1);
				
				pnlWest.add(lblCondition2);
				pnlWest.add(txfCondition2);
				
				pnlWest.add(lblCondition3);
				pnlWest.add(txfCondition3);
				
				pnlWest.add(lblCondition4);
				pnlWest.add(txfCondition4);
				
				//CenterPanel
				pnlCenter.add(scpGraphScroll);
				scpGraphScroll.setViewportView(txaMainGraph);
				
				//SouthPanel
				pnlSouth.add(btnPlot);
				pnlSouth.add(btnReset);
			
			//}
		//}
	}//
	
	//{ Listeners
	public void plotButtonAction(ActionEvent e){
		txaMainGraph.setText("");
		for(int y=50;y>=-50;y--){
			for(int x=-50;x<=50;x++){
				
				ArrayList<String> arguments = new ArrayList<String>();
				
				int conditionCount = 0;
				if(!txfCondition1.getText().isEmpty()){ 
					conditionCount++;
					arguments.add(txfCondition1.getText());
				}if(!txfCondition2.getText().isEmpty()){ 
					conditionCount++;
					arguments.add(txfCondition2.getText());
				}if(!txfCondition3.getText().isEmpty()){ 
					conditionCount++;
					arguments.add(txfCondition3.getText());
				}if(!txfCondition4.getText().isEmpty()){
					conditionCount++;
					arguments.add(txfCondition4.getText());
				}
				
					
				//Drawing
				if(calculator.check(arguments,x,y)==1){
					txaMainGraph.append("*");
				}else if(y==0&&x==0){
					txaMainGraph.append("+");
				}else if(y==0){
					txaMainGraph.append("-");
				}else if(x==0){
					txaMainGraph.append("|");
				}else{
					txaMainGraph.append(" ");
				}
				
			}//end-x
			txaMainGraph.append("\n");
			
		}//end-y
		
	}//
	
	public void resetButtonAction(ActionEvent e){
		txfCondition1.setText("");
		txfCondition2.setText("");
		txfCondition3.setText("");
		txfCondition4.setText("");
	}//
	//}
	
	public void actionPerformed(ActionEvent e){
		System.out.println();
	}
	
	public static void main(String[] args){
		GraphTextGUI gui = new GraphTextGUI();
		gui.setVisible(true);
	}
	
	//{ initailization
		//Main panels
		private JPanel pnlWest;
		private JPanel pnlCenter;
		private JPanel pnlEast;
		private JPanel pnlNorth;
		private JPanel pnlSouth;
		
		//Textfields
		private JTextField txfCondition1;
		private JTextField txfCondition2;
		private JTextField txfCondition3;
		private JTextField txfCondition4;
		
		//Labels
		private JLabel lblCondition1;
		private JLabel lblCondition2;
		private JLabel lblCondition3;
		private JLabel lblCondition4;
		
		//Buttons
		private JButton btnPlot;
		private JButton btnReset;
		
		//Extras
		private JTextArea txaMainGraph;
		private JScrollPane scpGraphScroll;
		private StringComplexCalc calculator = new StringComplexCalc();
	//}
	
}//end main
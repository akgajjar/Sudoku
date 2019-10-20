import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.xml.crypto.Data;





class GraphicallyRepresentation extends JFrame implements ActionListener {
	Container con;
	JButton b[][] = new JButton[9][9];
	
	//TextField t[] = new TextField[61];
	JMenuBar mbar;
	JMenu file,  option;
	JMenuItem submit, exit, about, Reset,help,Unduhelp,undu;

	int row , col;
	int flag;
	String value;
	
	 Mylogic ob1 = new Mylogic();
	int[][] cp = new int[9][9];
	int[][] ip = new int[9][9];


	GraphicallyRepresentation() {
		super("Play Sudoku .............(Created by Yesha & Ridhdhi)");
		
		try {

			database.truncate();
		setSize(500, 500);

		con = getContentPane();
		con.setLayout(new GridLayout(9, 9));

		ob1.complet_puzzle();
		ob1.puzzle();

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				b[i][j] = new JButton("" + ip[i][j]);
				b[i][j].setFont(new Font("ARIALBD", Font.BOLD, 20));
				b[i][j].setForeground(Color.BLUE);
				if (ip[i][j] == 0) {
					// b[i][j]=new JButton("");
					b[i][j].setText("");
					b[i][j].setBackground(Color.WHITE);
					b[i][j].addActionListener(this);

				}

				con.add(b[i][j]);

				if (i == 3 || i == 4 || i == 5 || j == 3 || j == 4 || j == 5) {
					if (2 < i && i < 6 && 2 < j && j < 6) {
						b[i][j].setBackground(Color.CYAN);
						continue;
					}
					b[i][j].setBackground(Color.pink);

				}

				else
					b[i][j].setBackground(Color.CYAN);
			}

		mbar = new JMenuBar();
		setJMenuBar(mbar);

		file = new JMenu("File");
		option = new JMenu("Option");
		help = new JMenuItem("Help");
		Unduhelp=new JMenuItem("Undu Help");
		undu=new JMenuItem("Undu");

		
		about = new JMenuItem("About");
		Reset = new JMenuItem("New Game");
		submit = new JMenuItem("Submit");
		exit = new JMenuItem("Exit");

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = 0;
				int tmp=0;
				for (int i = 0; i < 9; i++)
					for (int j = 0; j < 9; j++)
					{
						if(b[i][j].getText()== "")
						{
							tmp=1;
							break;
						}
						if (cp[i][j] != Integer.parseInt(b[i][j].getText())) {
							r = 1;
							break;
						}
					}	
				if(tmp==0)
				{
				for (int i = 0; i < 9; i++) {
					System.out.println();
					for (int j = 0; j < 9; j++) {
						System.out.print(cp[i][j]);
						System.out.print(Integer.parseInt(b[i][j].getText()) + "  ");
					}
				}
				System.out.print("\n" + r);
				if (r == 0)
				{
				
					JOptionPane pane = new JOptionPane(
					        "You Won the Match.");
					    Object[] options = new String[] { "New Game", "Cancel" };
					    pane.setOptions(options);
					    JDialog dialog = pane.createDialog(new JFrame(), "Dilaog");
					    dialog.show();
					    Object obj = pane.getValue(); 
					    int result = -1;
					    for (int k = 0; k < options.length; k++)
					      if (options[k].equals(obj))
					        result = k;
					    if(result==0)
					    {
					    	Reset.doClick();
					    }
					    
		
				}
				
				else
					JOptionPane.showMessageDialog(GraphicallyRepresentation.this, "Wrong Answer ");
				}
				else
					{

					
					
				/*	JOptionPane pane = new JOptionPane(
					        "You Won the Match.");
					    Object[] options = new String[] { "New Game", "Cancel" };
					    pane.setOptions(options);
					    JDialog dialog = pane.createDialog(new JFrame(), "Dilaog");
					    dialog.show();
					    Object obj = pane.getValue(); 
					    int result = -1;
					    for (int k = 0; k < options.length; k++)
					      if (options[k].equals(obj))
					        result = k;
					    if(result==0)
					    {
					    	Reset.doClick();
					    }
					    */

					JOptionPane.showMessageDialog(GraphicallyRepresentation.this, "Incomplete Game");
						
					}
				}

		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

				database.truncate();
			}

		});

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(GraphicallyRepresentation.this,
					"Yesha & Ridhdhi 4th Year AI Project .... Our first project of java language ",
					"About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		Reset.addActionListener(new ActionListener() {
	
			
			public void actionPerformed(ActionEvent e) {
			/*Mylogic l=new Mylogic();
			l.complet_puzzle();
			l.puzzle();
				for (int i = 0; i < 9; i++)
					for (int j = 0; j < 9; j++)
					{
						if(ip[i][j]!=0)
						{
						b[i][j].setText(String.valueOf(ip[i][j]));
						b[i][j].setFont(new Font("ARIALBD", Font.BOLD, 20));
						b[i][j].setForeground(Color.BLUE);

						}
						else
						{
							b[i][j].setText("");

							b[i][j].setFont(new Font("ARIALBD", Font.BOLD, 25));
							b[i][j].setForeground(Color.RED);
								
						}
			
						
					}
*
*/ 
					dispose();
					database.truncate();
			GraphicallyRepresentation g=new GraphicallyRepresentation();
			
			
			}
		});

		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	JOptionPane.showMessageDialog(GraphicallyRepresentation.this, "help");
				
		
				if(flag==1)
				{
					b[row][col].setForeground(Color.RED);
					flag=0;
				}
				int i=0,j = 0;
				for(i=0;i<9;i++)
				{
					for(j=0;j<9;j++)
					{
						if(b[i][j].getText()=="")
						{
							row=i;
							col=j;
							flag=1;
							break;
							
						}
						if(cp[i][j]!=Integer.parseInt(b[i][j].getText()))
						{
							row=i;
							col=j;
							flag=1;
							break;
							
						}
						
						
					}
					if(flag==1)
						break;
					
				}
					if(flag==1)
					{
						value=b[i][j].getText();
					b[i][j].setText(String.valueOf(cp[i][j]));
					b[i][j].setFont(new Font("ARIALBD", Font.BOLD, 25));
		
					b[i][j].setForeground(Color.GREEN);
					undubean a=new undubean();
					a.setRow(i);
					a.setCol(j);
					if(value=="")
						a.setVal(0);
					
						else
						
					a.setVal(Integer.parseInt(value));
					
					database.insert(a);
				
					}
				
				
				
			
			}

		});
		Unduhelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flag==1)
				{
				b[row][col].setText(value);
				b[row][col].setFont(new Font("ARIALBD", Font.BOLD, 25));
				b[row][col].setForeground(Color.RED);
				flag=0;
				undubean a=new undubean();
				a.setRow(row);
				a.setCol(col);
				
				if(value!="")
				{
					a.setVal(Integer.parseInt(value));
					
				}
				else
				{
					a.setVal(0);
				
				}
				database.insert(a);
				
				}
			}
		});
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				database.truncate();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		undu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==1)
				{
					b[row][col].setForeground(Color.RED);
					flag=0;
				}
				undubean a=database.getlast();
				if(a.getVal()!=0)
				{
				b[a.getRow()][a.getCol()].setText(String.valueOf(a.getVal()));
				database.delete(a.getId());
				}
				else
				{
					b[a.getRow()][a.getCol()].setText("");
					database.delete(a.getId());
				}
				System.out.println("undu "+ " row  :"+a.getRow()+" col "+a.getCol()+" val : "+a.getVal());
			}
		});	
		
		file.add(Reset);
		file.add(submit);
		file.addSeparator();
		file.add(exit);
		mbar.add(file);
		mbar.add(option);
		option.add(help);
		option.add(Unduhelp);
		option.add(undu);
		mbar.add(about);

		show();


		MyWindowAdapter mwa = new MyWindowAdapter();
		addWindowListener(mwa);
		}
		catch (Exception ef) {
		}
	}

	class Mylogic extends Logic {
		void complet_puzzle() {
			cp = save();

		}


		void puzzle() {
			ip = hide();
		}

	}

	class MyWindowAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}


	public void actionPerformed(ActionEvent e) {
	
		
		if(flag==1)
		{

			b[row][col].setForeground(Color.RED);
			flag=0;
		}
		try {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (e.getSource() == b[i][j]) {
					String s = JOptionPane.showInputDialog("enter your number");
					int c = Integer.parseInt(s);
					if (0 < c && 10 > c) {
						undubean a=new undubean();
						a.setRow(i);
						a.setCol(j);
						if(b[i][j].getText()!="")
						a.setVal(Integer.parseInt(b[i][j].getText()));
						else
							a.setVal(0);
						b[i][j].setText(s);
						// b[i][j].setBackground(Color.GRAY);
						b[i][j].setFont(new Font("ARIALBD", Font.BOLD, 25));
						b[i][j].setForeground(Color.RED);
						
						
						
						database.insert(a);
					}

					break;
				}
			}
		}
		catch (Exception ef) {
		}
		
	}





	
}
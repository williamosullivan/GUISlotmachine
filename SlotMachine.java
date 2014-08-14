import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/*
This program simulates a slot machine.

@author William O'Sullivan
@version 4/15/2014
*/

public class SlotMachine extends JFrame
{
	private static final double START_DOLLARS = 100;
	private static final double BET = 5;
	private static final int WINDOW_WIDTH = 750;
	private static final int WINDOW_HEIGHT = 175;
   private String[] fruit = { "cherry", "lemon", "orange", "grape", "kiwi" };
   private String[] colors = { "RED", "YELLOW", "ORANGE", "PURPLE", "GREEN" };
   private int slotOne;
   private int slotTwo;
   private int slotThree;
   private double prevTotal;
   private int winnings;
   private String background1;
   private String background2;
   private String background3;
   private int numOfCherries = 0;
   private double currentDollars;
   private String prevTotalString;
	
	JButton button = new JButton("Pull");
	JTextField left = new JTextField("***");
	JTextField center = new JTextField("***");
	JTextField right = new JTextField("***");
	JLabel main = new JLabel("Not Played Yet");
	JLabel total = new JLabel("Total: $" + START_DOLLARS + "0");
	JLabel bet = new JLabel("Betting: $" + BET + "0");
	JLabel prev = new JLabel("(Previous: $ )");
   
   /*
   The SlotMachine method builds the panel and sets all of the
   buttons and text fields for the GUI window.
   */
   
	public SlotMachine()
	{
		super("Slot Machine: by William O'Sullivan");
		
		JPanel panel = new JPanel( new GridLayout(4, 1) );
		JPanel panel2 = new JPanel( new GridLayout(1, 3) );
		panel2.add(left);
		panel2.add(center);
		panel2.add(right);
		left.setEditable(false);
		center.setEditable(false);
		right.setEditable(false);
		left.setHorizontalAlignment(JTextField.CENTER);
		center.setHorizontalAlignment(JTextField.CENTER);
		right.setHorizontalAlignment(JTextField.CENTER);
		panel.add(panel2);
		JPanel panel4 = new JPanel();
		panel4.add(button);
		panel.add(panel4);
		button.addActionListener( new ButtonHandler() );
		panel.add(main);
		main.setHorizontalAlignment(JTextField.CENTER);
		currentDollars = START_DOLLARS;
		JPanel panel3 = new JPanel(new GridLayout(1, 3));
		panel3.add(total);
		panel3.add(bet);
		panel3.add(prev);
		panel.add(panel3);
		add(panel);
		pack();
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
   /*
   The public main method simply calls a new class of the Slot Machine
   game.
   */
   		
   public static void main(String [] args)
   {
      SlotMachine machine = new SlotMachine();	
   }	
	
   /*
   The ButtonHandler class handles all of the action for the program.
   It sets all totals, and sends them to the GUI window through the
   logical decisions and the random integers involved in the slot
   machine action.
   @return All money values to the GUI window
   */
   
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
         Random slot1 = new Random();
         Random slot2 = new Random();
         Random slot3 = new Random();
      
         slotOne = slot1.nextInt(5);
         slotTwo = slot2.nextInt(5);
         slotThree = slot3.nextInt(5);
         left.setText(fruit[slotOne]);
         center.setText(fruit[slotTwo]);
         right.setText(fruit[slotThree]);
         prevTotal = currentDollars;
         prev.setText("Previous: $" + prevTotal + "0");
         
         background1 = colors[slotOne];
         if (background1 == "RED")
         {
            left.setBackground(Color.RED);
            numOfCherries++;
         }   
         else if (background1 == "YELLOW")
            left.setBackground(Color.YELLOW);
         else if (background1 == "ORANGE")
            left.setBackground(Color.ORANGE);
         else if (background1 == "PURPLE")
            left.setBackground(Color.MAGENTA);
         else
            left.setBackground(Color.GREEN); 
            
         background2 = colors[slotTwo];
         if (background2 == "RED")
         {
            center.setBackground(Color.RED);
            numOfCherries++;
         }   
         else if (background2 == "YELLOW")
            center.setBackground(Color.YELLOW);
         else if (background2 == "ORANGE")
            center.setBackground(Color.ORANGE);
         else if (background2 == "PURPLE")
            center.setBackground(Color.MAGENTA);
         else
            center.setBackground(Color.GREEN); 
            
         background3 = colors[slotThree];
         if (background3 == "RED")
         {
            right.setBackground(Color.RED);
            numOfCherries++;
         }   
         else if (background3 == "YELLOW")
            right.setBackground(Color.YELLOW);
         else if (background3 == "ORANGE")
            right.setBackground(Color.ORANGE);
         else if (background3 == "PURPLE")
            right.setBackground(Color.MAGENTA);
         else
            right.setBackground(Color.GREEN);
          
         if (numOfCherries == 0)
         {
            main.setText("No Cherries - LOST your bet");
            currentDollars -= BET;
         } 
         else if (numOfCherries == 1)
         {
            main.setText("One Cherry - got your bet back");
         }
         else if (numOfCherries == 2)
         {
            main.setText("Two Cherries - You DOUBLED money back");
            currentDollars += BET * 2;
         }
         else if (numOfCherries == 3)
         {
            main.setText("Three Cherries - You TRIPLED money back");
            currentDollars += BET * 3;
         }
         
         total.setText("Total: $" + currentDollars + "0");
         numOfCherries = 0;
         
         if (currentDollars <= 0)
         {
            main.setText("Thanks for Playing!");
            button.setVisible(false);
         }  
		}
	}

}
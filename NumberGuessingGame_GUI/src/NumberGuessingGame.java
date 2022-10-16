import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NumberGuessingGame extends JFrame {

	//text field for input	
	private JTextField textFieldInput;
	
	//label for output
	private JLabel lblOutput;
	
	//label for tries
	private JLabel lblTries;
	
	//variable to keep random number
	private int randomNumber;
	
	//to keep count remaining of tries
	private byte tries = 7;  
	
	//highest number of tries
	private byte highestTries = 7;
	
	
	public NumberGuessingGame() {
		//border of window		
		setTitle("Guessing Game");
		getContentPane().setBackground(new Color(0, 153, 153));
		setBackground(new Color(204, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//body  fo window		
		JLabel lblTitle = new JLabel("Number Guessing Game");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblTitle.setBounds(14, 23, 434, 29);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitle);
				
		JLabel lblInstruction = new JLabel("Enter a number between 1 and 100:");
		lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setBounds(112, 75, 239, 29);
		getContentPane().add(lblInstruction);
		
		//shows result when 'enter' key is hit		
		textFieldInput = new JTextField();
		textFieldInput.setBackground(new Color(153, 255, 255));
		textFieldInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calling function when enter is hit				
				checkGuess();
			}
		});
		
		textFieldInput.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldInput.setBounds(188, 115, 86, 32);
		getContentPane().add(textFieldInput);
		textFieldInput.setColumns(10);
		
		//shows result when 'guess' button is hit		
		JButton btnGuess = new JButton("Guess");
		btnGuess.setForeground(Color.WHITE);
		btnGuess.setBackground(new Color(0, 51, 102));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		
		btnGuess.setBounds(188, 158, 89, 35);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Guess the correct number");
		lblOutput.setForeground(Color.WHITE);
		lblOutput.setBackground(Color.BLACK);
		lblOutput.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(34, 204, 414, 20);
		getContentPane().add(lblOutput);
		
		lblTries = new JLabel("");
		lblTries.setForeground(Color.WHITE);
		lblTries.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblTries.setHorizontalAlignment(SwingConstants.CENTER);
		lblTries.setBounds(150, 224, 180, 26);
		getContentPane().add(lblTries);
		
		//adding the initial number of tries left
		lblTries.setText("You've " + tries + " guesses left");
	}
	
	//method for checking guess	
	public void checkGuess() {
		//keeping the input in a variable
		String guessText = textFieldInput.getText();
		//variable to keep result
		String message = "";
		//variable to keep number of tries left
		String messageTries = "";
		
		//for errors and exceptions		
		try {
			//converting to integer
			int guess = Integer.parseInt(guessText);
			
			//decreasing try by 1			
			tries -= 1;
			
			if (guess > randomNumber) {
				message = guess + " is too high. try again!!";
				messageTries = "You've " + tries + " tries left";
				lblOutput.setText(message);
				lblTries.setText(messageTries);
			}
			else if (guess < randomNumber) {
				message = guess + " is too low. try again!! ";
				messageTries = "You've " + tries + " tries left";
				lblOutput.setText(message);
				lblTries.setText(messageTries);
			}
			else {
				tries = (byte)(highestTries - tries);
				message = "Congrats.. Correct Answer!! \n it took you " + tries + " tries";
				lblOutput.setText(message);
				lblTries.setText(messageTries);
				//function to generate another random number so that a new game can be started		
				newGame();
			}
		}
		
		catch(Exception e) {
			lblOutput.setText("Number has to be an integer between 1 and 100");
			lblTries.setText("You've " + tries + " tries left");
		}
		
		finally {
			//method to keep focus on text field		
			textFieldInput.requestFocus();
			
			//selects all the characters in the text field
			textFieldInput.selectAll();
			
			//checking if any try exists			
			if (tries<=0) {
				message = "YOU LOST!!! The number was " +randomNumber+ " wanna play again?";
				lblOutput.setText("");
				
				//to pop up a new window				
				int decision = javax.swing.JOptionPane.showConfirmDialog(null, message);
				
				System.out.println(decision);
				//checking the user's choice				
				if (decision == 0) {
					//function to generate another random number so that a new game can be started	
					newGame();
					lblOutput.setText("Number has to be an integer between 1 and 100");
					lblTries.setText("You've " + tries + " tries left");
				} else {
					//turning off the interface					
					super.setVisible(false);
				}
				
			}
		}
		
	}
	
	//method to create a new game
	public void newGame() {
		//keeping random number in a variable		
		randomNumber = (int)(Math.random()*100 + 1);
		
		//resetting tries
		tries = highestTries;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberGuessingGame game = new NumberGuessingGame();
		game.newGame();
		game.setSize(new Dimension(450, 350));
		game.setVisible(true);
	}
}

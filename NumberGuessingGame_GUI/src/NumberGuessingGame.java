import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NumberGuessingGame extends JFrame {
	//text field for input	
	private JTextField textFieldInput;
	
	//label for output
	private JLabel lblOutput;
	
	//variable to keep random number
	private int randomNumber;
	
	public NumberGuessingGame() {
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Number Guessing Game");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblTitle.setBounds(0, 0, 434, 29);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitle);
		
		JLabel lblInstruction = new JLabel("Enter a number between 1 and 100:");
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setBounds(112, 63, 210, 29);
		getContentPane().add(lblInstruction);
		
		textFieldInput = new JTextField();
		textFieldInput.setBounds(175, 103, 86, 20);
		getContentPane().add(textFieldInput);
		textFieldInput.setColumns(10);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.setBounds(175, 134, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Click Guess to see if your guess is correct or not");
		lblOutput.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 195, 414, 14);
		getContentPane().add(lblOutput);
	}
	
	//method for checking guess	
	public void checkGuess() {
		//keeping the input in a variable
		String guessText = textFieldInput.getText();
		//variable to keep result
		String message = "";
		
		//converting to integer
		int guess = Integer.parseInt(guessText);
		
		if (guess > randomNumber) {
			message = guess + " is too high. try again!!";
			lblOutput.setText(message);
		}
		else if (guess < randomNumber) {
			message = guess + " is too low. try again!!";
			lblOutput.setText(message);
		}
		else {
			message = "Congrats.. Correct Answer!!";
			lblOutput.setText(message);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hey");
	}
}

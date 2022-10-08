//package NumberGuessingGame;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		// object to take input
		Scanner scan = new Scanner(System.in);
		// generating a random number		
		int randomNumber = (int)(Math.random()*100 + 1);
		
		System.out.println(randomNumber);
		
		//default guessed answer		
		int guess = -1; 
		
		//loop will run until the user guesses a correct number		
		while(guess != randomNumber) {
			System.out.println("Guess a number between 1-100: ");
			
			//taking input
			guess = scan.nextInt();
			
			if (guess < randomNumber) 
				System.out.println(guess + " is too low. Try Again!");
			else if (guess > randomNumber)
				System.out.println(guess + " is too high. Try Again!");
			else
				System.out.println(guess + " is correct.");
		}
	}

}

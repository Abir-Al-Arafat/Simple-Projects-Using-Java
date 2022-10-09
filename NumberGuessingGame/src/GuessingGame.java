//package NumberGuessingGame;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		// object to take input
		Scanner scan = new Scanner(System.in);
		
//		System.out.println(randomNumber);
		
		// variable for play again loop		
		String playAgain = "";
		
		
		do {
			//variable to keep track of the wrong inputs
			byte count = 0;
			
			// generating a random number (1-100)		
			int randomNumber = (int)(Math.random()*100 + 1);
			
			//default guessed answer		
			int guess = -1; 
			
			//loop will run until the user guesses a correct number		
			while(guess != randomNumber) {
				System.out.println("Guess a number between 1-100: ");
				
				//taking input
				guess = scan.nextInt();
				
				//adding 1 everytime the user guesses
				count += 1;
				
				if (guess < randomNumber) 
					System.out.println(guess + " is too low. Try Again!");
				else if (guess > randomNumber)
					System.out.println(guess + " is too high. Try Again!");
				else
					System.out.println(guess + " is correct. \nit took you " + count + " tries");
			}
			
			//asking if user want to play again			
			System.out.println("Do you want to play again? (y/n): ");
			//taking input			
			playAgain = scan.next();
			
		}while(playAgain.equalsIgnoreCase("y"));
		
		System.out.println("GAME OVER!!");
	}

}

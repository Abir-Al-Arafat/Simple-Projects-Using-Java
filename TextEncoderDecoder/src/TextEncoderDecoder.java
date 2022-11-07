import TextEncoderDecoder;
//for taking input
import java.util.Scanner;

public class TextEncoderDecoder {

	public static void main(String[] args) {
		//program will run until the user stops giving input		
		while(true) {
		
		System.out.println("Enter a text to encode or decode (Hit enter to stop the program): ");
		//taking input		
		Scanner scan = new Scanner(System.in);
		//storing input 		
		String text = scan.nextLine();
		
		//program stops when "enter" key is hit		
		if (text.length() <= 0) {
			break;
		}
		
		//output
		String out = "";
		
		System.out.print("Enter an inteval key (-26 to 26): ");
		
		//taking interval key input
		int keyInput = Integer.parseInt(scan.nextLine());
		
		//type casting to char
		char key = (char)(keyInput);
		
		//empty char for ASCII value
		char ascii = ' ';
		
		for (int i = 0; i < text.length(); i++) {
			//taking ascii value			
			ascii = text.charAt(i);
			
			//checking for capital letter			
			if (ascii >= 'A' && ascii <='Z') {
				//adding interval for encoding/decoding				
				ascii+=key;
				
				//checking if interval is going out of bound
				if (ascii > 'Z') {
					//subtract 26 if interval goes out of bound					
					ascii -= 26;
				}
				
				if (ascii < 'A') {
					//add 26 if interval goes out of bound					
					ascii += 26;
				}
			}
			
			//checking for small letter
			if (ascii >= 'a' && ascii <='z') {
				//adding interval for encoding/decoding				
				ascii+=key;
				
				//checking if interval is going out of bound
				if (ascii > 'z') {
					//subtract 26 if interval goes out of bound					
					ascii -= 26;
				}
				
				if (ascii < 'a') {
					//add 26 if interval goes out of bound					
					ascii += 26;
				}
			}
			
			//checking numbers
			if (ascii >= '0' && ascii <= '9') {
				//adding interval for encoding/decoding				
				ascii+=key;
				
				//checking if interval is going out of bound
				if (ascii > '9') {
					//subtract 9 if interval goes out of bound					
					ascii -= 9;
				}
				
				if (ascii < '0') {
					//add 9 if interval goes out of bound					
					ascii += 9;
				}
			}
			
			//adding type casted characters 			
			out += ascii;
		}
		
		System.out.println(out);
		}
		System.out.println("Program Stopped");
	}

}

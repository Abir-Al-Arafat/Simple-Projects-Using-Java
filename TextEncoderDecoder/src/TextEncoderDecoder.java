import TextEncoderDecoder;
//for taking input
import java.util.Scanner;

public class TextEncoderDecoder {

	public static void main(String[] args) {
		System.out.println("Enter a text to encode or decode: ");
		//taking input		
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		
		//output
		String out = "";
		
		//ASCII interval
		char key = 13;
		
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
					ascii -= key*2;
				}
			}
			
			//checking for small letter
			if (ascii >= 'a' && ascii <='z') {
				//adding interval for encoding/decoding				
				ascii+=key;
				//checking if interval is going out of bound
				if (ascii > 'z') {
					//subtract 26 if interval goes out of bound					
					ascii -= key*2;
				}
			}
			
			//adding type casted characters 			
			out += ascii;
		}
		
		System.out.println(out);
		
	}

}

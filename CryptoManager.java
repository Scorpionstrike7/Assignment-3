/**
 * Class: CMSC203 
 *  Program: Assignment #3
 *  Instructor: Dr. Grinberg
 * Description: (Give a brief description for each Program)
   A program that requires you to encrypt and decrypt Text using two different ciphers.
 * Due: MM/DD/YYYY (<03/14/2022>)
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Bradley Hughes
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		//Sets up a boolean statement
		boolean valid = true;
		
		//Sets a for statement to check each letter until the length of the text is reached.
		for (int i = 0; i < plainText.length(); i++) {
			
			//Sets up a char variable for the current char
			char c = plainText.charAt(i);
			
			//Creates an if statement that checks each character. If a character is outside the range, the statement is false. If not, the statement is true.
			if (c < LOWER_BOUND || c > UPPER_BOUND) {
				valid = false;
			}
			else {
				valid = true;
			}
		}
		return valid;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		//if statement for if the plainText is out of bounds, it returns as an empty string.
		if (!stringInBounds(plainText)) { 
			return ""; 
		}
		
		// Sets up a String variable 
		String encryptC = "";
		
		// Loop statement that goes through each character of the plainText
		for (int i = 0; i < plainText.length(); i++) {
			
			//Sets up a char variable for the current char of the plainText
			char c = plainText.charAt(i);
			
			//Sets up a variable that takes the c value and and turns into an integer. Its then added by the key value each time
			int ec = (int)c;
			ec += key;
			
			//While loop takes any ec value that is above the upper bound and subtracts it from the the range
			while (ec > UPPER_BOUND) { 
				ec -= RANGE; 
			}
			//each ec variable is turned into a char value and added to the encryptC variable
			encryptC += (char)ec;
		}
		return encryptC;
	}
		
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		//Sets up an empty string variable to be returned
		String encryptB = "";
		//Sets up a variable as the string length of the bellasso string
		int be = bellasoStr.length();
		
		//Loop statement that goes through each character of the plainText
		for (int i = 0; i < plainText.length(); i++) {
			// Variables
			char c = plainText.charAt(i);
			
			//This variable does the math required to encrypt the plainText character into a character following the bellaso cipher.
			int eb = (int)c + (int)bellasoStr.charAt(i % be);
			//The c value is then converted to an integer and is subtracted to the eb variable 

			//While loop takes any eb value that is above the upper bound and subtracted from the the range
			while (eb > UPPER_BOUND) { 
				eb -= RANGE;
				}

			//each eb variable is turned into a char value and added to the encryptB variable
			encryptB += (char)eb;
		}
		// Return
		return encryptB;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// Sets up a String variable 
		String decryptC = "";
		// Loop statement that goes through each character of the encryptedText
		for (int i = 0; i < encryptedText.length(); i++) {
			//Sets up a char variable for the current char of the encryptedText
			char c = encryptedText.charAt(i);
			//Sets up a variable that takes the c value and and turns into an integer. It then subtracts the key value each time
			int dc = (int)c;
			dc -= key;
			//While loop takes any dc value that is below the lower bound and adds it from the the range
			while (dc < LOWER_BOUND) { 
				dc += RANGE; 
			}
			//each dc variable is turned into a char value and added to the decryptC variable
			decryptC += (char)dc;
		}
		return decryptC;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		//Sets up an empty string variable to be returned
		String decryptB = "";
		//Sets up a variable as the string length of the bellasso string
		int be = bellasoStr.length();
		
		//Loop statement that goes through each character of the encryptedText
		for (int i = 0; i < encryptedText.length(); i++) {
			// Variables
			char c = encryptedText.charAt(i);
			
			//This variable does the math required to decrypt the encryptedText character into a character following the bellaso cipher.
			int db = (int)c - (int)bellasoStr.charAt(i % be);
			//The c value is then converted to an integer and is subtracted from the db variable 

			//While loop takes any db value that is below the lower bound and adds it to the range
			while (db < LOWER_BOUND) { 
				db += RANGE; 
				}

			//each db variable is turned into a char value and added to the decryptB variable
			decryptB += (char)db;
		}

		// Return
		return decryptB;
	}
}

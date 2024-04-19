package lab7part3;

	import java.util.Scanner;

	/**
	 * The PalindromeChecker class provides a method to check if a given string is a palindrome.
	 */
	public class palindrome {

	    /**
	     * Main method which serves as the entry point of the program.
	     * @param args Not used in this application.
	     */
	    public static void main(String[] args) {
	        Scanner S = new Scanner(System.in); // Scanner object for capturing user input
	        
	        System.out.println("Enter a string to check if it's a palindrome:");
	        String inputString = S.nextLine(); // Reads the user input
	        
	        if (isPalindrome(inputString)) {
	            System.out.println("'" + inputString + "' is a palindrome.");
	        } else {
	            System.out.println("'" + inputString + "' is not a palindrome.");
	        }
	    }

	    /**
	     * Checks if a given string is a palindrome.
	     * This method ignores case sensitivity and non-alphanumeric characters.
	     * @param str The string to be checked.
	     * @return true if the string is a palindrome, false otherwise.
	     */
	    public static boolean isPalindrome(String str) {
	        str = str.replaceAll("[\\W_]+", "").toLowerCase(); // Removes non-alphanumeric characters and converts to lowercase
	     // Starting index of the string
	        int left = 0; 
	        // Ending index of the string
	        
	        int right = str.length() - 1;
	        
	        while (left < right) {
	            // Compare characters from the beginning and the end of the string
	            if (str.charAt(left) != str.charAt(right))
	            	// Not a palindrome if mismatch occurs
	            {
	                return false; 
	            }
	            left++; // Move towards the center from the left
	            right--; // Move towards the center from the right
	        }
	        return true; // The string is a palindrome
	    }
	}



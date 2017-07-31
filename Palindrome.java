import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;



/**
 * I have solved this problem before and I think it is the best solution, so I included it
 * in method isPalindromeDefault.
 * 
 * To challenge myself I decide to try and solve it in away that I never seen tried. So that
 * is what I did in method isPalindrome. This is a Java 6+ solution only(I'll let you figure out why).
 * 
 * @author Gino Balcacer
 *
 */
public class Palindrome {
	// REGEX expression that removes everything except proper alphabetic characters.
	private static final String REPLACE = "[^A-Za-z]";
	
	static boolean isPalindrome(String line)
	{
		// Collection to store word/sentence to process
		ArrayDeque<String> deck = new ArrayDeque<String>();
		// clean inputed string of non-alphabetic characters, make all lowercase and split into an array.
        deck.addAll(Arrays.asList(line.replaceAll(REPLACE, "").toLowerCase().split("(?!^)")));
        
        while(!deck.isEmpty())
        {   
        	// popoff each character at each end and compare to each other.
        	// if the are not equal stop processing and return false.
        	if(!deck.pollFirst().equals(deck.pollLast()))
        	{
        		return false;
        	}	
        }
        // if we got to this point everything compared equally, return true.
        return true;
	}
	
	static boolean isPalindromeDefault(String line) {
		// clean inputed string of non-alphabetic characters, make all lowercase.
		String modified = line.replaceAll(REPLACE, "").toLowerCase();
		// reverse the string and compare to original.
	    return modified.equals(new StringBuilder().append(modified).reverse().toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(args[0]));
			// process each line of file.
			while (scanner.hasNextLine())
			{
				if(isPalindrome(scanner.nextLine()))
					System.out.println("Is Palindrome!");
				else
					System.out.println("Is not Palindrome!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
		

	}

}

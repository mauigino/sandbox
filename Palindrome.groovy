/**
 * This is a test groovy implementation of the java version of Palindrome. 
 * 
 * NOTE: I'm not impling this is a better or more efficient implementation. This is merely a playground
 * for trying different groovy concepts, and it's a work in progress.
 *
 * @author Gino Balcacer
 */
class Palindrome {
	static REPLACE = "[^A-Za-z]"
	
	static def isPalindrome(def line){
		// Collection to store word/sentence to process
		def deck = new ArrayDeque();
		// clean inputed string of non-alphabetic characters, make all lowercase and split into an array.
		deck.addAll(line.replaceAll(REPLACE, "").toLowerCase().split("(?!^)"));
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
	
	static def isPalindromeDefault(line) {
			// clean inputed string of non-alphabetic characters, make all lowercase.
			def modified = line.replaceAll(REPLACE, "").toLowerCase();
			// reverse the string and compare to original.
		    return modified.equals(new StringBuilder().append(modified).reverse().toString());
		}
		
	static def main(args) {
				Scanner scanner = null;
				try {
					scanner = new Scanner(new File(args[0]));
					// process each line of file.
					while (scanner.hasNextLine())
					{
						if(isPalindrome(scanner.nextLine()))
							println("Is Palindrome!");
						else
							println("Is not Palindrome!");
					}
				} catch (e) {
					e.printStackTrace();
				}
				finally
				{
					scanner.close();
				}
			}
}
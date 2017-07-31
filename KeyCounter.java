import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Assumptions:
 * 1)Standalone app that wont be multithreaded.
 * 2)It is assumed that a name can consist of any combination of characters.
 * 3)Only integers can be used for values.
 * 4)If any problem arise during processing of file the app will fail-fast and provide an error message.
 * 
 * This design was chosen because a HashMap is perfectly suited for this type of operation because of its
 * speed, efficient storage system and the keys(name) is already immutable.
 * 
 * I decided to use a pojo to store the data values for each line to encapsulated the data validation
 * and to allow for it to be used in any future enhancements.
 * 
 * @author Gino Balcacer
 *
 */

public class KeyCounter {
	// Collection to store name/value data.
	private static final Map<String,Integer> counts = new HashMap<String,Integer>();
	
	/**
	 * Count and store values per name.
	 * @param line name/value data
	 */
	static void countValuesByName(String line)
	{
		// create name/value pojo.
		NameValue nv = new NameValue(line);
		// check if name already exists, if so store current value
		Integer value = counts.get(nv.getName());
	    if(value==null) // add first entry for this name.
	    	counts.put(nv.getName(), nv.getValue());
	    else // add already existing value to new value and store
	    	counts.put(nv.getName(), nv.getValue()+value);

	}
	/**
	 * Outputs to console the counts per name.
	 */
	static void printCounts()
	{
		for(Map.Entry<String,Integer> entry : counts.entrySet())
		{
			System.out.println("The total for " + entry.getKey() + " is " + entry.getValue());
		}
	}

	/**
	 * Write a function that sums up keys in a text file. 
	 * The file contains data in the format of "key,count" where key is a string and count is an integer.
	 * Each line will only contain one key-count pair.
	 * 
	 * The output should contain each key occurring in the file along
	 * with the sum of the count for all occurrences of a given key.
	 * 
	 * Example:
	 * John,2
	 * Jane,3
	 * John,4
	 * Jane,5
	 * 
	 * 
	 * Would result in the output: "The total for John is 6. The total for Jane is 8."
	 * 
	 * @param args Fully qualified file name
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
				
		try {
			scanner = new Scanner(new File(args[0]));
			// process each line of file.
			while (scanner.hasNextLine())
			{
				countValuesByName(scanner.nextLine());
			}
			printCounts();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			scanner.close();
		}

	}

}

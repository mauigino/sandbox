/**
 * Pojo used to a name/value pair consisting of a String and Integer respectively.
 * 
 * @author Gino Balcacer
 *
 */
public class NameValue {
	
	private final String name;
	private final Integer value;
	
	public NameValue(String line) throws IllegalArgumentException
	{
		try{
			// create array of string values
			String[] split = line.toString().split(",");
			// Must have 2 values per line
			if(split.length != 2)
				throw new IllegalArgumentException("Missing input value.");
			this.name = split[0];
			// convert string to integer value
			this.value = Integer.valueOf(split[1]);
		}
		catch(NumberFormatException e)
		{
			throw new IllegalArgumentException(e.getMessage()+" which is not a proper number value.");
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException(e.getMessage());
		}			
	}
	public String getName() {
		return name;
	}
	public Integer getValue() {
		return value;
	}	

}

/**
 * This is a test groovy implementation of the java version of KeyCounter. In this version i did
 * away with the NameValue class for simplicity and to play around with some groovy concepts.
 * 
 * NOTE: I'm not impling this is a better or more efficient implementation. This is merely a playground
 * for trying different groovy concepts, and it's a work in progress.
 *
 * @author Gino Balcacer
 */
class KeyCounter {
	static def counts = [:]
	
	static def countValuesByName(line) {
		def nameValue = line.split(",")
		
		def value = counts.get(nameValue[0])
		if(value == null){
			counts.put(nameValue[0],nameValue[1])
		}
		else{
			counts.put(nameValue[0],nameValue[1].toInteger()+value.toInteger())
		}			
	}
	
	static def printCounts(){
		counts.each{ k, v -> println "The total for ${k} is ${v}"}
	}
	
	static def main(args){
		Scanner scanner = null
		try {
			scanner = new Scanner(new File(args[0]));
			// process each line of file.
			while (scanner.hasNextLine())
			{
				countValuesByName(scanner.nextLine());
			}
			printCounts();			
		}
		catch(e)
		{
			e.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
	}
}
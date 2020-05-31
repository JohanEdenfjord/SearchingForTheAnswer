package a.start.of.the.crisp;

public class SplittingTheSearch {

	public String[] destroyAndAssemble(String string) {
		
		//splits the string from Search and putting it in an Array. 
		String[] words = null;
		
		words = string.split("\\s+");
		
		
		//cleaning up the input from all that is not a-z and A-Z and 0-9
		for (int j = 0; j < words.length; j++) {
			words[j] = words[j].replaceAll("[^a-zA-Z0-9]", "");
		}			
	
		return words;
		
	}
}

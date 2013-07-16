package moten.david.util.words;

/**
 * Dictionary for word validity.
 * 
 * @author dave
 * 
 */
public interface Dictionary extends Iterable<String> {
	/**
	 * Returns true if and only if the word is a valid word in the dictionary.
	 * 
	 * @param word
	 * @return
	 */
	boolean isValid(String word);

}

package com.github.davidmoten.util.words;

import java.util.Iterator;

/**
 * This Dictionary allows every word as valid.
 * 
 * @author dave
 * 
 */
public class DictionaryAlwaysValid implements Dictionary {

	@Override
	public boolean isValid(String word) {
		return true;
	}

	@Override
	public Iterator<String> iterator() {
		throw new RuntimeException("not implemented");
	}

}

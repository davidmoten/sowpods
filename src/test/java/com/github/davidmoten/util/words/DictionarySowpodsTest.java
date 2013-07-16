package com.github.davidmoten.util.words;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.github.davidmoten.util.words.Dictionary;
import com.github.davidmoten.util.words.DictionarySowpods;

public class DictionarySowpodsTest {

	private final Dictionary dictionary = new DictionarySowpods();

	@Test
	public void testDictionaryContainsAValidWord() {
		assertTrue(dictionary.isValid("garbage"));
	}

	@Test
	public void testDictionaryIsCaseInsensitive() {
		assertTrue(dictionary.isValid("GARBAGE"));
		assertTrue(dictionary.isValid("garBage"));
	}

	@Test
	public void testDictionaryDoesNotContainBogusWord() {
		assertFalse(dictionary.isValid("ZZUZZQQQ"));
	}

	@Test
	public void testSet() {
		String base = "earthquakethrowingfloundersvideopoliticisingamdaljfomebazcainvetrartoryieuonepeewbliasuxsodton"
				.toUpperCase();
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return ((Integer) o1.length()).compareTo(o2.length());
			}
		};
		List<String> list = new ArrayList<String>();
		for (String word : dictionary) {
			String s = base;
			boolean matches = true;
			for (int i = 0; i < word.length(); i++) {
				int pos = s.indexOf(word.charAt(i));
				if (pos < 0) {
					matches = false;
					break;
				}
				s = s.substring(0, pos) + s.substring(pos + 1);
			}
			if (matches) {
				System.out.println(word);
				list.add(word);
			}
		}
		Collections.sort(list, comp);
		System.out.println("----------------------------");
		for (String word : list)
			System.out.println(word.toLowerCase());
	}
}

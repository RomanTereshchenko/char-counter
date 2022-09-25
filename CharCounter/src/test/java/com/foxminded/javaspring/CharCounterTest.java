package com.foxminded.javaspring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CharCounterTest {

	@Test
	void buildCharCounterList_returnsNewlyBuiltOutput_nonRepeatedStrings() {
		List<String> testList = new ArrayList<>();
		testList.add("Hello, world!");
		testList.add("Any other String");
		assertEquals("Hello, world!\n"
				+ "\"H\" - 1\n"
				+ "\"e\" - 1\n"
				+ "\"l\" - 3\n"
				+ "\"o\" - 2\n"
				+ "\",\" - 1\n"
				+ "\" \" - 1\n"
				+ "\"w\" - 1\n"
				+ "\"r\" - 1\n"
				+ "\"d\" - 1\n"
				+ "\"!\" - 1\n"
				+ "\n"
				+ "Any other String\n"
				+ "\"A\" - 1\n"
				+ "\"n\" - 2\n"
				+ "\"y\" - 1\n"
				+ "\" \" - 2\n"
				+ "\"o\" - 1\n"
				+ "\"t\" - 2\n"
				+ "\"h\" - 1\n"
				+ "\"e\" - 1\n"
				+ "\"r\" - 2\n"
				+ "\"S\" - 1\n"
				+ "\"i\" - 1\n"
				+ "\"g\" - 1\n"
				+ "\n"
				+ "", CharCounter.buildCharCounterList(testList));
	}
	
	@Test
	void buildCharCounterList_returnsStringsFromCache_inputContainsRepeatedStrings() {
		List<String> testList = new ArrayList<>();
		testList.add("Hello, world!");
		testList.add("Hello, world!");
		testList.add("Any other String");
		assertEquals("Hello, world!\n"
				+ "\"H\" - 1\n"
				+ "\"e\" - 1\n"
				+ "\"l\" - 3\n"
				+ "\"o\" - 2\n"
				+ "\",\" - 1\n"
				+ "\" \" - 1\n"
				+ "\"w\" - 1\n"
				+ "\"r\" - 1\n"
				+ "\"d\" - 1\n"
				+ "\"!\" - 1\n"
				+ "\n"
				+ "Hello, world!\n"
				+ "\"H\" - 1\n"
				+ "\"e\" - 1\n"
				+ "\"l\" - 3\n"
				+ "\"o\" - 2\n"
				+ "\",\" - 1\n"
				+ "\" \" - 1\n"
				+ "\"w\" - 1\n"
				+ "\"r\" - 1\n"
				+ "\"d\" - 1\n"
				+ "\"!\" - 1\n"
				+ "Output taken from cache\n"
				+ "Any other String\n"
				+ "\"A\" - 1\n"
				+ "\"n\" - 2\n"
				+ "\"y\" - 1\n"
				+ "\" \" - 2\n"
				+ "\"o\" - 1\n"
				+ "\"t\" - 2\n"
				+ "\"h\" - 1\n"
				+ "\"e\" - 1\n"
				+ "\"r\" - 2\n"
				+ "\"S\" - 1\n"
				+ "\"i\" - 1\n"
				+ "\"g\" - 1\n"
				+ "\n"
				+ ""

, CharCounter.buildCharCounterList(testList));
	}

}

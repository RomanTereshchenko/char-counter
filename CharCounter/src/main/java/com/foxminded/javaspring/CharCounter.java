package com.foxminded.javaspring;

import java.util.*;

public class CharCounter {

	static String buildCharCounterList(List<String> inputStringList) {
		Map<String, String> cacheMap = new HashMap<>();
		List<String> outputCountersList = new ArrayList<>();

		for (String inputString : inputStringList) {
			if (cacheMap.containsKey(inputString)) {
				outputCountersList.add(
						new StringBuilder(inputString + "\n" + cacheMap.get(inputString) + "Output taken from cache\n")
								.toString());
			} else {
				outputCountersList
						.add(new StringBuilder(inputString + "\n" + buildOutputString(inputString) + "\n").toString());

				cacheMap.put(inputString, buildOutputString(inputString));
			}
		}

		StringBuilder output = new StringBuilder();

		for (String string : outputCountersList) {
			output.append(string).toString();
		}

		return output.toString();

	}

	private static String buildOutputString(String inputString) {

		return charCounterMapToString(buildCharCounterMap(inputString), inputString);
	}

	private static Map<Character, Integer> buildCharCounterMap(String inputString) {

		List<Character> inputStringList = new ArrayList<>();
		for (Character character : inputString.toCharArray()) {
			inputStringList.add(character);
		}

		Set<Character> inputStringSet = new HashSet<>();
		for (Character character : inputStringList) {
			inputStringSet.add(character);
		}

		Map<Character, Integer> charCounterMap = new HashMap<>();

		for (Character charInTheSet : inputStringSet) {
			Integer charCounter = 0;
			for (Character charInTheList : inputStringList) {
				if (charInTheSet.equals(charInTheList)) {
					charCounter++;
				}
				charCounterMap.put(charInTheSet, charCounter);

			}
		}
		return charCounterMap;
	}

	private static String charCounterMapToString(Map<Character, Integer> outputMap, String inputString) {

		StringBuilder uniqueCharsInOrder = new StringBuilder();
		Set<Character> origSet = new LinkedHashSet<>();
		for (int i = 0; i < inputString.length(); i++) {
			if (origSet.add(inputString.charAt(i))) {
				uniqueCharsInOrder.append(inputString.charAt(i));
			}
		}

		StringBuilder output = new StringBuilder();
		for (Character uniqueChar : uniqueCharsInOrder.toString().toCharArray()) {
			output.append("\"" + uniqueChar + "\" - " + outputMap.get(uniqueChar) + "\n");

		}

		return output.toString();
	}

	public static void main(String[] args) {

		List<String> testList = new ArrayList<>();
		testList.add("Hello, world!");
		testList.add("Any other String");

		System.out.println(buildCharCounterList(testList));

	}
}

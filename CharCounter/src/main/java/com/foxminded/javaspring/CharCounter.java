package com.foxminded.javaspring;

import java.util.*;

public class CharCounter {

	static String buildCharCounterList(List<String> inputStringList) {
		Map<String, String> cacheMap = new HashMap<>();
		List<String> outputCountersList = new ArrayList<>();


		for (String inputString : inputStringList) {
			String outputString = charCounterMapToString(buildCharCounterMap(inputString), inputString);
			if (cacheMap.containsKey(inputString)) {
				outputCountersList.add(
						new StringBuilder(inputString + "\n" + cacheMap.get(inputString) + "Output taken from cache\n")
								.toString());
			} else {
				outputCountersList
						.add(new StringBuilder(inputString + "\n" + outputString + "\n").toString());

				cacheMap.put(inputString, outputString);
			}
		}

		return String.join("", outputCountersList);


	}

	private static Map<Character, Integer> buildCharCounterMap(String inputString) {

		Map<Character, Integer> charCounterMap = new HashMap<>();
		
		for (Character character : inputString.toCharArray()) {
			charCounterMap.compute(character, (key, value) -> {
				if (Objects.isNull(value)) {
					return 1;
				} else {
					return ++ value;
				}
			});
			
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
		testList.add("Hello, world!");
		testList.add("Any other String");

		System.out.println(buildCharCounterList(testList));

	}
}

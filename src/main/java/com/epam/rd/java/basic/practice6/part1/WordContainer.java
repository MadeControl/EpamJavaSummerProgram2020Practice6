package com.epam.rd.java.basic.practice6.part1;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class WordContainer {

	private static final Logger LOGGER = Logger.getLogger(WordContainer.class.getName());

	public static void main(String[] args) {

		Map<String, Word> wordTreeMap = new TreeMap<>();

		try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

			List<String> listWords = new ArrayList<>();
			String tempString;

			while ((tempString = bf.readLine()) != null){

				listWords.addAll(Arrays.asList(tempString.split("\\s")));

			}

			for(String word : listWords) {

				if(word.equals("stop")) {
					break;
				}

				Word newWord = createWordObject(word, wordTreeMap);

				wordTreeMap.put(word, newWord);

			}

			wordTreeMap.entrySet().stream()
					.sorted(Map.Entry.<String , Word>comparingByValue().reversed())
					.forEach(x -> System.out.println(x.getKey() + " : " + x.getValue().getFrequency()));

		} catch (IOException e) {
			LOGGER.warning(e.getMessage());
		}

	}

	public static Word createWordObject(String word, Map<String, Word> map) {

		Word newWord;

		if(map.containsKey(word)){
			Word oldWord = map.get(word);
			newWord = new Word(word, oldWord.getFrequency() + 1);
		} else {
			newWord = new Word(word, 1);
		}

		return newWord;

	}
	
}

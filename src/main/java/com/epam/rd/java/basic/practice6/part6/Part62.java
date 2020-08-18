package com.epam.rd.java.basic.practice6.part6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Part62 {

    private static final String INDENTATION = " ==> ";

    private final StringBuilder resultOfTask = new StringBuilder();
    private final List<String> listNonUniqueWords;

    private List<String> listUniqueWords;
    private List<Integer> listLengthsOfEachWord;

    public Part62(String[] wordsArray) {

        this.listNonUniqueWords = new ArrayList<>(Arrays.asList(wordsArray));

    }

    public String doTaskLength() {

        listUniqueWords = listNonUniqueWords.stream()
                .distinct()
                .collect(Collectors.toList());

        listLengthsOfEachWord = new ArrayList<>();

        listUniqueWords.forEach(x -> listLengthsOfEachWord.add(x.length()));

        /////////////////////////////////
        List<Integer> listOfThreeHigherLengths = listLengthsOfEachWord.stream()
                .sorted()
                .collect(Collectors.toList());

        Collections.reverse(listOfThreeHigherLengths);

        listOfThreeHigherLengths = listOfThreeHigherLengths.stream()
                .limit(3)
                .collect(Collectors.toList());
        /////////////////////////////////

        for(int i : listOfThreeHigherLengths) {

            int count = (int) listOfThreeHigherLengths.stream().filter(x -> x == i).count();
            String newInfo;

            if(count == 1) {

                newInfo = returnInfoWhenCountIsOne(i);

            } else {

                newInfo = returnInfoWhenCountMoreOne(i);

            }
            resultOfTask.append(newInfo);

        }

        String[] stringsResult = resultOfTask.toString().split("\n");

        StringBuilder sb = new StringBuilder();

        for(String s : stringsResult) {
            sb.append(s).append("\n");
        }

        return sb.toString();

    }

    public String returnInfoWhenCountIsOne(int lengthWord) {

        int index = listLengthsOfEachWord.indexOf(lengthWord);
        String word = listUniqueWords.get(index);

        deleteElementsFromAllLists(word, lengthWord);

        return assembleString(word, lengthWord);

    }

    public String returnInfoWhenCountMoreOne(int lengthWord) {

        int index = 0;
        String word = null;

        for(int i : listLengthsOfEachWord) {

            if(i == lengthWord) {

                index = listLengthsOfEachWord.indexOf(i);
                word = listUniqueWords.get(index);

                break;

            }

        }

        if (word == null || index == 0) {
            return "";
        }

        String newInfo = assembleString(word, lengthWord);
        deleteElementsFromAllLists(word, lengthWord);

        return newInfo;

    }

    public String assembleString(String word, int quantityWords) {

        return word + INDENTATION + quantityWords + "\n";

    }

    public void deleteElementsFromAllLists(String word, int lengthWord) {

        int index = listLengthsOfEachWord.indexOf(lengthWord);
        int count = (int) listNonUniqueWords.stream().filter(x -> x.equals(word)).count();

        for(int i = 0; i < count; i++) {
            listNonUniqueWords.remove(word);
        }

        listUniqueWords.remove(word);
        listLengthsOfEachWord.remove(index);

    }

}

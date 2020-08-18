package com.epam.rd.java.basic.practice6.part6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part63 {

    private final StringBuilder resultOfTask = new StringBuilder();
    private final List<String> listNonUniqueWords;

    public Part63(String[] wordsArray) {

        this.listNonUniqueWords = new ArrayList<>(Arrays.asList(wordsArray));

    }

    public String doTaskDuplicates() {

        List<String> listUniqueWords = listNonUniqueWords.stream()
                .distinct()
                .collect(Collectors.toList());

        List<Integer> listQuantitiesOfEachWord = new ArrayList<>();

        listUniqueWords.forEach(x ->
                listQuantitiesOfEachWord.add((int) listNonUniqueWords.stream()
                        .filter(t -> t.equals(x))
                        .count()));

        int countWords = 0;

        for(String word : listNonUniqueWords) {

            int index = listUniqueWords.indexOf(word);
            int countWordDuplicates = listQuantitiesOfEachWord.get(index);

            if(countWordDuplicates >= 2) {

                StringBuilder sb = new StringBuilder(word.toUpperCase()).reverse();

                resultOfTask.append(sb).append("\n");

                countWords++;

            }

            if(countWords == 3) {

                return resultOfTask.toString();

            }

        }

        return "";

    }

}

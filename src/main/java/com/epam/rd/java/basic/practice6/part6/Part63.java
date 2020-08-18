package com.epam.rd.java.basic.practice6.part6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Part63 {

    private final StringBuilder resultOfTask = new StringBuilder();
    private final List<String> listNonUniqueWords;

    public Part63(String[] wordsArray) {

        this.listNonUniqueWords = new ArrayList<>(Arrays.asList(wordsArray));

    }

    public String doTaskDuplicates() {

        int foundWords = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : listNonUniqueWords) {


            Integer count = map.get(word);

            if (count == null) {

                count = 0;

            }

            if (count == 1) {

                StringBuilder sb = new StringBuilder(word.toUpperCase()).reverse();

                resultOfTask.append(sb).append("\n");

                foundWords++;

            }

            if (foundWords == 3) {

                return resultOfTask.toString();

            }

            map.put(word, count + 1);

        }

        return "";

    }

}

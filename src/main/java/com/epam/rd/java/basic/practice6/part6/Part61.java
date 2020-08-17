package com.epam.rd.java.basic.practice6.part6;

import java.util.*;
import java.util.stream.Collectors;

public class Part61 {

    private static final String INDENTATION = " ==> ";
    private List<String> listNonUniqueWords;
    private List<String> listUniqueWords;
    private List<Integer> listQuantitiesOfEachWord;
    private List<Integer> listOfThreeHigherQuantities;
    private StringBuilder resultOfTask = new StringBuilder();

    public Part61(String[] wordsArray) {

        this.listNonUniqueWords = new ArrayList<>(Arrays.asList(wordsArray));

    }

    public String doTaskFrequency() {

        listUniqueWords = listNonUniqueWords.stream()
                .distinct()
                .collect(Collectors.toList());

        listQuantitiesOfEachWord = new ArrayList<>();

        listUniqueWords.forEach(x ->
                listQuantitiesOfEachWord.add((int) listNonUniqueWords.stream()
                                                                        .filter(t -> t.equals(x))
                                                                        .count()));
        /////////////////////////////////
        listOfThreeHigherQuantities = listQuantitiesOfEachWord.stream()
                .sorted()
                .collect(Collectors.toList());

        Collections.reverse(listOfThreeHigherQuantities);

        listOfThreeHigherQuantities = listOfThreeHigherQuantities.stream()
                .limit(3)
                .collect(Collectors.toList());
        /////////////////////////////////

        for(int i : listOfThreeHigherQuantities) {

            int count = (int) listOfThreeHigherQuantities.stream().filter(x -> x == i).count();
            String newInfo;

            if(count == 1) {

                newInfo = returnNewInfo(i);

            } else {

                newInfo = returnNewInfo(i, count);

            }
            resultOfTask.append(newInfo);

        }

        String[] stringsResult = resultOfTask.toString().split("\n");

        List<String> list = Arrays.asList(stringsResult);
        Collections.sort(list);
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();

        for(String s : list) {
            sb.append(s).append("\n");
        }

        return sb.toString();

    }

    public String returnNewInfo(int quantityRepeats) {

        int index = listQuantitiesOfEachWord.indexOf(quantityRepeats);
        String word = listUniqueWords.get(index);

        deleteElementsFromAllLists(word, quantityRepeats);

        return assembleString(word, quantityRepeats);

    }

    public String returnNewInfo(int number, int quantityRepeats) {

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        while (true) {

            for(String word : listNonUniqueWords) {

                Integer count = map.get(word);

                if(count == null) {

                    count = 0;

                }

                if(count == number-1) {

                    String newInfo = assembleString(word, number);
                    deleteElementsFromAllLists(word, quantityRepeats);

                    return sb.append(newInfo).toString();

                }

                map.put(word, count + 1);

            }

        }

    }

    public String assembleString(String word, int quantityWords) {

        return word + INDENTATION + quantityWords + "\n";

    }

    public void deleteElementsFromAllLists(String word, int quantityRepeats) {

        for(int i = 0; i < quantityRepeats; i++) {
            listNonUniqueWords.remove(word);
        }

        listUniqueWords.remove(word);
        listQuantitiesOfEachWord.remove(quantityRepeats);

    }
}

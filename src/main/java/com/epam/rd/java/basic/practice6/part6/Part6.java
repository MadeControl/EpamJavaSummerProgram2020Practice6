package com.epam.rd.java.basic.practice6.part6;

import java.io.*;
import java.util.logging.Logger;

public class Part6 {

    private static final String FREQUENCY = "frequency";
    private static final String LENGTH = "length";
    private static final String DUPLICATES = "duplicates";
    private static final Logger LOGGER = Logger.getLogger(Part6.class.getSimpleName());

    public static void main(String[] args) {

        String[] input;

        if (args == null) {
            throw new NullPointerException();
        } else {
            input = args;
        }

        if (args.length != 4) {
            return;
        }

        if (!checkInput(input)) {
            return;
        }

        final String fileName = args[1];
        final String taskName = args[3];

        String[] wordsArray = readFromFile(fileName).split(" ");

        System.out.print(doTask(taskName, wordsArray));

    }

    public static boolean checkInput(String[] array) {

        if(array.length != 4) {
            return false;
        }

        if (!array[0].equals("-i") && !array[0].equals("--input")) {
            return false;
        }

        if (!array[2].equals("-t") && !array[2].equals("--task")) {
            return false;
        }

        return array[3].equals(FREQUENCY) || array[3].equals(LENGTH) || array[3].equals(DUPLICATES);

    }

    public static String readFromFile(String fileName) {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {

            String string;

            while ((string = bf.readLine()) != null) {

                sb.append(string).append(" ");

            }

        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }

        return sb.toString().replaceAll("\\s+", " ");

    }

    public static String doTask(String taskName, String[] wordsArray) {

        if (taskName.equals(FREQUENCY)) {

            Part61 task = new Part61(wordsArray);
            return task.doTaskFrequency();

        } else if (taskName.equals(LENGTH)) {

            Part62 task = new Part62(wordsArray);
            return task.doTaskLength();

        } else {

            Part63 task = new Part63(wordsArray);
            return task.doTaskDuplicates();

        }

    }

}

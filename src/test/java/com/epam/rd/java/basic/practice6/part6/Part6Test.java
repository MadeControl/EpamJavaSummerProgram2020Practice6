package com.epam.rd.java.basic.practice6.part6;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part6Test {

    private static final String FILE_NAME = "part6.txt";

    @Test
    public void shouldCorrectlyReadFromFile() {

        final String expectedString = "jaguar chimpanzee bison whale " +
                "marmot bison lemur panther camel lizard wolf bear " +
                "gecko " +
                "mongoose leopard sable sable dingo whale jaguar " +
                "rat lemur lemur gorilla zebra tortoise " +
                "asp lion tapir tortoise gorilla cheetah bison marten " +
                "marmot cheetah camel " +
                "snake marmot " +
                "zebra asp cheetah lizard gecko gorilla asp lion tortoise " +
                "kangaroo whale penguin yak cheetah mouse panther ";

        final String actualString = Part6.readFromFile(FILE_NAME);

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void shouldReturnTrue_WhenInputCorrectData() {

        final String input = "--input part6.txt -t frequency";
        final String[] inputForMethod = input.split("\\s");

        boolean expectedTrue = Part6.checkInput(inputForMethod);

        Assert.assertTrue(expectedTrue);

    }

    @Test
    public void shouldReturnFalse_WhenInputIncorrectData() {

        final String input1 = "-input part6.txt ----t frequency";
        final String input2 = "length";
        final String input3 = "";
        final String input4 = "--input part.txt -t";

        final String[] inputForMethod1 = input1.split("\\s");
        final String[] inputForMethod2 = input2.split("\\s");
        final String[] inputForMethod3 = input3.split("\\s");
        final String[] inputForMethod4 = input4.split("\\s");

        boolean expectedFalse1 = Part6.checkInput(inputForMethod1);
        boolean expectedFalse2 = Part6.checkInput(inputForMethod2);
        boolean expectedFalse3 = Part6.checkInput(inputForMethod3);
        boolean expectedFalse4 = Part6.checkInput(inputForMethod4);

        Assert.assertFalse(expectedFalse1);
        Assert.assertFalse(expectedFalse2);
        Assert.assertFalse(expectedFalse3);
        Assert.assertFalse(expectedFalse4);

    }

    @Test
    public void shouldCorrectDoTask() {

        final String[] inputData1 = "--input part6.txt --task frequency".split("\\s");
        final String[] inputData2 = "--input part6.txt -t length".split("\\s");
        final String[] inputData3 = "-i part6.txt -t duplicates".split("\\s");

        final String expectedString1 = "whale ==> 3\n" +
                "cheetah ==> 4\n" +
                "bison ==> 3\n";

        final String expectedString2 = "chimpanzee ==> 10\n" +
                "mongoose ==> 8\n" +
                "tortoise ==> 8\n";

        final String expectedString3 = "NOSIB\n" +
                "ELBAS\n" +
                "ELAHW\n";

        final String actualString1 = readResult_Part6_Main_Method(inputData1);
        final String actualString2 = readResult_Part6_Main_Method(inputData2);
        final String actualString3 = readResult_Part6_Main_Method(inputData3);

        Assert.assertEquals(expectedString1, actualString1);
        Assert.assertEquals(expectedString2, actualString2);
        Assert.assertEquals(expectedString3, actualString3);

    }

    public static String readResult_Part6_Main_Method(String[] args) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        Part6.main(args);

        System.setIn(System.in);
        System.setOut(System.out);

        return byteArrayOutputStream.toString();

    }

    @Test
    public void allMethodsShouldCorrectlyExecute() {

        final String[] input = new String[] {"-i", "part6.txt", "-t", "frequency"};

        Assert.assertTrue(Part6.checkInput(input));

        Assert.assertNotNull(Part6.doTask("frequency", input));

        Assert.assertNotNull(Part6.readFromFile("part6.txt"));


    }

    @Test
    public void part61MethodsShouldCorrectlyExecute() {

        String text = Part6.readFromFile("part6.txt");

        Part61 part61 = new Part61(text.split("\\s"));

        Assert.assertNotNull(part61.returnInfoWhenRepeatsIsOne(3));
        Assert.assertNotNull(part61.returnInfoWhenRepeatsMoreOne(3));
        Assert.assertNotNull(part61.doTaskFrequency());
        Assert.assertNotNull(part61.assembleString("word", 3));

    }

    @Test
    public void part62MethodsShouldCorrectlyExecute() {

        String text = Part6.readFromFile("part6.txt");

        Part61 part61 = new Part61(text.split("\\s"));

        Assert.assertNotNull(part61.returnInfoWhenRepeatsIsOne(3));
        Assert.assertNotNull(part61.returnInfoWhenRepeatsMoreOne(3));
        Assert.assertNotNull(part61.doTaskFrequency());
        Assert.assertNotNull(part61.assembleString("word", 3));

    }

    @Test
    public void part63MethodsShouldCorrectlyExecute() {

        String text = Part6.readFromFile("part6.txt");

        Part61 part61 = new Part61(text.split("\\s"));

        Assert.assertNotNull(part61.doTaskFrequency());

    }
    
}

package com.epam.rd.java.basic.practice6.part2;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Part2Test {

    @Test
    public void shouldGetLegalFormatResult_WhenUseMethod_RemoveByIndex() {

        final List<Integer> list = Part2.createArrayList();
        final long timeRun = Part2.removeByIndex(list, Part2.K);

        final String expectedString = "ArrayList#Index: " + timeRun + " ms";
        final String actualString = Part2.getResult(list, timeRun, Part2.STRING_INDEX);

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void shouldGetLegalFormatResult_WhenUseMethod_RemoveByIterator() {

        final List<Integer> list = Part2.createLinkedList();
        final long timeRun = Part2.removeByIterator(list, Part2.K);

        final String expectedString = "LinkedList#Index: " + timeRun + " ms";
        final String actualString = Part2.getResult(list, timeRun, Part2.STRING_INDEX);

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void shouldCreateList(){

        final List<Integer> expectedList = new ArrayList<>();
        final List<Integer> actualList = Part2.createFullList();

        for(int i = 0; i < Part2.N; i++) {
            expectedList.add(i);
        }

        final String expectedString = expectedList.toString();
        final String actualString = actualList.toString();

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void shouldCreateArrayList(){

        final List<Integer> expectedList = new ArrayList<>();
        final List<Integer> actualList = Part2.createArrayList();

        final String expectedString = expectedList.getClass().getSimpleName();
        final String actualString = actualList.getClass().getSimpleName();

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void shouldCreateLinkedList(){

        final List<Integer> expectedList = new LinkedList<>();
        final List<Integer> actualList = Part2.createLinkedList();

        final String expectedString = expectedList.getClass().getSimpleName();
        final String actualString = actualList.getClass().getSimpleName();

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void shouldGetCorrectResult_WhenItUsesMethod_Part2Main() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        Part2.main(null);

        final String actualString = byteArrayOutputStream.toString();

        System.setIn(System.in);
        System.setOut(System.out);

        Assert.assertNotNull(actualString);

    }

    @Test
    public void part2ClassMethodsShouldCorrectlyExecute() {

        List<Integer> list1 = new ArrayList<>(Part2.createArrayList());
        List<Integer> list2 = new LinkedList<>(Part2.createLinkedList());

        Assert.assertNotNull(Part2.createArrayList());
        Assert.assertNotNull(Part2.createLinkedList());
        Assert.assertNotNull(Part2.createFullList());
        Assert.assertNotEquals(Part2.removeByIndex(list1, 3), Part2.removeByIterator(list2, 3));

        Assert.assertNotNull(Part2.getResult(list1, Part2.removeByIterator(list1, 3), "Title"));
    }
    
}
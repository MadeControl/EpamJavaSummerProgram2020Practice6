package com.epam.rd.java.basic.practice6.part2;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Part2Test {

    @Test
    public void shouldGetLegalFormatResult() {

        final List<Integer> list = Part2.createArrayList();
        final long timeRun = Part2.removeByIndex(list, Part2.K);

        final String expectedString = "ArrayList#Index: " + timeRun + " ms";
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
    
}
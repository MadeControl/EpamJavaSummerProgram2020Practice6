package com.epam.rd.java.basic.practice6.part1;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordContainerTest {

    @Test
    public void shouldCreateNotExistWordInMapAndReturnFrequencyOne() {

        final Map<String, Word> map = new TreeMap<>();

        map.put("1", new Word("1", 1));
        map.put("2", new Word("2", 1));
        map.put("3", new Word("3", 1));

        Word word = WordContainer.createWordObject("4", map);
        int expectedFrequency = 1;
        int actualFrequency = word.getFrequency();

        Assert.assertEquals(expectedFrequency, actualFrequency);

    }

    @Test
    public void shouldCreateExistWordInMapAndReturnFrequencyTwo() {

        final Map<String, Word> map = new TreeMap<>();

        map.put("1", new Word("1", 1));
        map.put("2", new Word("2", 1));
        map.put("3", new Word("3", 1));

        Word word = WordContainer.createWordObject("3", map);
        int expectedFrequency = 2;
        int actualFrequency = word.getFrequency();

        Assert.assertEquals(expectedFrequency, actualFrequency);

    }
    
}

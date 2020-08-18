package com.epam.rd.java.basic.practice6.part1;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
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

    @Test
    public void shouldCorrectlyDoMainMethod() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        final String content =
                "asd 43 asdf asd 43\n" +
                        "434 asdf\n" +
                        "kasdf asdf stop asdf\n" +
                        "stop";

        System.setIn(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));

        WordContainer.main(null);

        final String expectedString = "asdf : 3\r\n" +
                                        "43 : 2\r\n" +
                                        "asd : 2\r\n" +
                                        "434 : 1\r\n" +
                                        "kasdf : 1\r\n";

        final String actualString = byteArrayOutputStream.toString();

        System.setIn(System.in);
        System.setOut(System.out);

        Assert.assertEquals(expectedString, actualString);

    }
    
}

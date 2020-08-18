package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class RangeTest {

    @Test
    public void shouldIterateWithoutReversedMode() {

        final Range range = new Range(3, 10);
        StringBuilder sb = new StringBuilder();

        Iterator<Integer> iter;

        Assert.assertNotNull(iter = range.iterator());

        while (iter.hasNext()) {

            sb.append(iter.next()).append(" ");

        }

        final String expectedString = "3 4 5 6 7 8 9 10 ";
        final String actualString = sb.toString();

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void shouldIterateWithReversedMode() {

        final Range range = new Range(3, 10, true);
        StringBuilder sb = new StringBuilder();

        for (Integer integer : range) {
            sb.append(integer).append(" ");
        }

        final String expectedString = "10 9 8 7 6 5 4 3 ";
        final String actualString = sb.toString();

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void shouldGetCorrectResult_WhenItUsesMethod_Part3Main() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        Part4.main(null);

        final String expectedString = "3 4 5 6 7 8 9 10 \r\n" +
                                      "10 9 8 7 6 5 4 3 ";

        final String actualString = byteArrayOutputStream.toString();

        System.setIn(System.in);
        System.setOut(System.out);

        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void iteratorShouldCorrectlyDoActions() {

        final Range range = new Range(3, 10);

        final Integer expectedInteger = 3;

        Iterator<Integer> iter = range.iterator();

        Assert.assertTrue(iter.hasNext());

        Assert.assertNotNull(range.iterator());

        Assert.assertEquals(expectedInteger, iter.next());

    }

}

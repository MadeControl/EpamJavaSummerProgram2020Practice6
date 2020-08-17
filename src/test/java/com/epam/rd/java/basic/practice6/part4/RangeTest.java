package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Test;

public class RangeTest {

    @Test
    public void shouldIterateWithoutReversedMode() {

        final Range range = new Range(3, 10);
        StringBuilder sb = new StringBuilder();

        for (Integer integer : range) {
            sb.append(integer).append(" ");
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

}

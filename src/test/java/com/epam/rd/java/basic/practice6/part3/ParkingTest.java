package com.epam.rd.java.basic.practice6.part3;

import com.epam.rd.java.basic.practice6.part1.WordContainer;
import com.epam.rd.java.basic.practice6.part5.Tree;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ParkingTest {

    @Test
    public void shouldCreateStateParking() {

        final Parking parking = new Parking(4);

        final String expectedStateParking = "0000";
        final String actualStateParking = parking.createStateParking();

        Assert.assertEquals(expectedStateParking, actualStateParking);

    }

    @Test
    public void shouldReturnTrueAndLegalArrive() {

        final Parking parking = new Parking(4);

        final boolean actualBoolean = parking.arrive(2);

        final String expectedStateParking = "0010";
        final String actualStateParking = parking.getStateParking();

        Assert.assertTrue(actualBoolean);

        Assert.assertEquals(expectedStateParking, actualStateParking);

    }

    @Test
    public void shouldReturnFalseAndLegalArrive() {

        final Parking parking = new Parking(4);

        parking.arrive(2);
        parking.arrive(2);
        parking.arrive(2);
        parking.arrive(2);
        final boolean actualBoolean = parking.arrive(2);

        final String expectedStateParking = "1111";
        final String actualStateParking = parking.getStateParking();

        Assert.assertFalse(actualBoolean);

        Assert.assertEquals(expectedStateParking, actualStateParking);

    }

    @Test
    public void shouldReturnTrueAndLegalDepart() {

        final Parking parking = new Parking(4);

        parking.arrive(2);

        final boolean actualBoolean = parking.depart(2);

        final String expectedStateParking = "0000";
        final String actualStateParking = parking.getStateParking();

        Assert.assertTrue(actualBoolean);

        Assert.assertEquals(expectedStateParking, actualStateParking);

    }

    @Test
    public void shouldReturnFalseAndLegalDepart() {

        final Parking parking = new Parking(4);

        final boolean actualBoolean = parking.depart(2);

        final String expectedStateParking = "0000";
        final String actualStateParking = parking.getStateParking();

        Assert.assertFalse(actualBoolean);

        Assert.assertEquals(expectedStateParking, actualStateParking);

    }

    @Test
    public void shouldGetCorrectResult_WhenItUsesMethod_Part3Main() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        Part3.main(null);

        final String expectedString = "true\r\n" +
                "0010\r\n" +
                "true\r\n" +
                "0011\r\n" +
                "true\r\n" +
                "1011\r\n" +
                "true\r\n" +
                "1111\r\n" +
                "false\r\n" +
                "1111\r\n" +
                "true\r\n" +
                "1011\r\n" +
                "false\r\n" +
                "1011\r\n";

        final String actualString = byteArrayOutputStream.toString();

        System.setIn(System.in);
        System.setOut(System.out);

        Assert.assertEquals(expectedString, actualString);

    }
}
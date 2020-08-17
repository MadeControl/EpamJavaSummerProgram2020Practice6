package com.epam.rd.java.basic.practice6.part3;

import org.junit.Assert;
import org.junit.Test;

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
    
}
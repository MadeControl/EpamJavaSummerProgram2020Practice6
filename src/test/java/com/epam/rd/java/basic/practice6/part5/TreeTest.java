package com.epam.rd.java.basic.practice6.part5;

import org.junit.Assert;
import org.junit.Test;

public class TreeTest {

    @Test
    public void shouldAddThreeElements_AndReturnThreeTrue() {

        final Tree<Integer> tree = new Tree<>();

        Assert.assertTrue(tree.add(1));

        Assert.assertTrue(tree.add(2));

        Assert.assertTrue(tree.add(4));

    }

    @Test
    public void itWillAddThreeElements_But_ItShouldAddOnlyTwoElements_AndReturnTwoTrue_AndOneFalse() {

        final Tree<Integer> tree = new Tree<>();

        Assert.assertTrue(tree.add(1));

        Assert.assertTrue(tree.add(2));

        Assert.assertFalse(tree.add(2));

    }

    @Test
    public void shouldAddAllElementsFromArrayToTree_AndReturnAllFalse_WhenItWillAddAllTheSameElements() {

        final Integer[] array = new Integer[] {1, 4, 6, 2};
        final Tree<Integer> tree = new Tree<>();

        tree.add(array);

        for(Integer i : array) {

            Assert.assertFalse(tree.add(i));

        }
    }
    
}

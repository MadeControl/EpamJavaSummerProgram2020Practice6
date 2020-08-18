package com.epam.rd.java.basic.practice6.part5;

import com.epam.rd.java.basic.practice6.part3.Part3;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    public void treeObjectShouldCorrectlyDoActions() {

        final Tree<Integer> tree = new Tree<>();

        tree.add(3);
        tree.add(5);
        tree.add(1);

        Assert.assertTrue(tree.remove(3));

        Assert.assertTrue(tree.add(3));

        Assert.assertFalse(tree.remove(100));

        final int expectedSmallestElement = 1;
        final int actualSmallestElement = tree.findSmallestValue(tree.root);

        Assert.assertEquals(expectedSmallestElement, actualSmallestElement);

        Assert.assertTrue(tree.putElement(tree.root, 10));

        Assert.assertTrue(tree.deleteRecursive(tree.root, 10));

        Tree.Node<Integer> node = tree.returnNodeOfElementThatWillBeDeleted(tree.root, 10);

        Assert.assertNotNull(node);

    }

    @Test
    public void shouldGetCorrectResult_WhenItUsesMethod_TreePrint() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        final Tree<Integer> tree = new Tree<>();

        tree.add(3);
        tree.add(1);
        tree.add(5);

        tree.print();

        tree.print(tree.root, "");

        final String expectedString = "  1\r\n" +
                "3\r\n" +
                "  5\r\n";

        final String actualString = byteArrayOutputStream.toString();

        System.setIn(System.in);
        System.setOut(System.out);

        Assert.assertEquals(expectedString + expectedString, actualString);

    }


}

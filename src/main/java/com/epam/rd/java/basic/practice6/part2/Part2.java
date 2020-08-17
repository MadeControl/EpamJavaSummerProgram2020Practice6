package com.epam.rd.java.basic.practice6.part2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part2 {

    public static final int N = 10000;
    public static final int K = 4;
    public static final String STRING_INDEX = "Index";
    public static final String STRING_ITERATOR = "Iterator";

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = (ArrayList<Integer>) createArrayList();
        LinkedList<Integer> linkedList = (LinkedList<Integer>) createLinkedList();

        System.out.println(getResult(arrayList, removeByIndex(arrayList, K), STRING_INDEX));
        System.out.println(getResult(linkedList, removeByIndex(linkedList, K), STRING_INDEX));

        arrayList = (ArrayList<Integer>) createArrayList();
        linkedList = (LinkedList<Integer>) createLinkedList();

        System.out.println(getResult(arrayList, removeByIterator(arrayList, K), STRING_ITERATOR));
        System.out.println(getResult(linkedList, removeByIterator(linkedList, K), STRING_ITERATOR));

    }

    public static long removeByIndex(final List<Integer> list, final int k) {

        long startTime = System.currentTimeMillis();
        int counter = 0;

        while (list.size() != 1) {

            counter += k-1;

            while (counter >= list.size()) {
                counter = counter - list.size();
            }

            list.remove(counter);

        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public static long removeByIterator(final List<Integer> list, int k) {

        long startTime = System.currentTimeMillis();
        int counter = k;

        while (list.size() != 1) {

            ListIterator<Integer> iter = list.listIterator();

            for(int i = 0; i < counter; i++){
                iter.next();
            }

            counter += k-1;

            while (counter >= list.size()) {
                counter = counter - list.size() + 1;
            }

            iter.remove();

        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public static List<Integer> createArrayList() {

        List<Integer> list = createFullList();

        return new ArrayList<>(list);

    }

    public static List<Integer> createLinkedList() {

        List<Integer> list = createFullList();

        return new LinkedList<>(list);

    }

    public static List<Integer> createFullList() {

        return Stream.iterate(0, x -> x+1)
                        .limit(N)
                        .collect(Collectors.toList());

    }

    public static String getResult(List<Integer> list, long time, String titleMethod) {

        String nameClass = list.getClass().getSimpleName();

        return nameClass + "#" + titleMethod + ": " + time + " ms";

    }
}

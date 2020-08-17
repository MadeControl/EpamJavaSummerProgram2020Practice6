package com.epam.rd.java.basic.practice6.part5;

public class Part5 {
    
    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<>();

        System.out.println(tree.add(1));
        System.out.println(tree.add(5));
        System.out.println(tree.add(7));
        System.out.println(tree.add(7));

        tree.print();

        System.out.println("----------------------------");

        System.out.println(tree.remove(7));

        tree.print();

    }
    
}

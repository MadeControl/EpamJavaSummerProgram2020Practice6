package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;
import com.epam.rd.java.basic.practice6.part5.Part5;
import com.epam.rd.java.basic.practice6.part6.Part6;

public class Demo {

    private static final String FILE_NAME = "part6.txt";

    public static void main(String[] args) {

        Part1.main(null);
        Part2.main(null);
        Part3.main(null);
        Part4.main(null);
        Part5.main(null);

        
        System.out.println("\n---FREQUENCY---");
        Part6.main(new String[]{"--input", FILE_NAME, "--task", "frequency"});
        System.out.println("\n---LENGTH---");
        Part6.main(new String[]{"-i", FILE_NAME, "-t", "length"});
        System.out.println("\n---DUPLICATES---");
        Part6.main(new String[]{"--input", FILE_NAME, "-t", "duplicates"});

    }

}

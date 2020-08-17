package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class Part1 {

	public static final String CONTENT =
						"asd 43 asdf asd 43\n" +
						"434 asdf\n" +
						"kasdf asdf stop asdf\n" +
						"stop";

	public static void main(String[] args) {

		System.setIn(new ByteArrayInputStream(CONTENT.getBytes(StandardCharsets.UTF_8)));

		WordContainer.main(args);

	}

}

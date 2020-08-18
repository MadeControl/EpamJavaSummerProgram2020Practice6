package com.epam.rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

	private final String content;
	
	private final int frequency;

    public Word(String content, int frequency) {
        this.content = content;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (frequency != word.frequency) return false;
        return content.equals(word.content);
    }

    @Override
    public int hashCode() {
        int result = content.hashCode();
        result = 31 * result + frequency;
        return result;
    }

    @Override
    public int compareTo(Word o) {
        if (this.frequency == o.frequency){
            return -this.content.length() + o.content.length();
        }
        return this.frequency - o.frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}

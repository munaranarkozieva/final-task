package com.epam.training.munara_narkozieva.task3;

public class StringAnalyzer {

    private String input;

    public StringAnalyzer(String input) {
        this.input = input;
    }
    public int findMaxConsecutiveIdenticalChars() {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int current = 1;
        int maxSequence = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                current++;
            } else {
                current = 1;
            }
            if (current > maxSequence) {
                maxSequence = current;
            }
        }

        return maxSequence;
    }

    public int findMaxUnequalConsecutiveCharacters() {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int current = 1;
        int maxSequence = 1;

        for (int i = 1; i < input.length(); i ++) {
            if (input.charAt(i) != input.charAt(i-1)) {
                current ++;
            } else {
                current = 1;
            }
            if (current > maxSequence) {
                maxSequence = current;
            }
        } return maxSequence;
    }

    public int findMaxConsecutiveIdenticalLetters() {
        int currentSequence = 1;
        int maxSequence = 0;
        for (int i = 1; i < input.length(); i ++) {
        if (Character.isLetter(input.charAt(i)) && input.charAt(i) == input.charAt(i-1)) {
            currentSequence ++;
        } else {
            currentSequence = 1;
        }

        if (currentSequence > maxSequence) {
            maxSequence = currentSequence;
        }

        } return  maxSequence;
    }



    public int findMaxConsecutiveIdenticalDigits() {
        int currentSequence = 1;
        int maxSequence = 0;

        for  (int i = 1; i < input.length(); i ++) {
            if (Character.isDigit(input.charAt(i)) && input.charAt(i) == input.charAt(i - 1)) {
                currentSequence ++;
            } else {
                currentSequence = 1;
            }
            if (currentSequence > maxSequence) {
                maxSequence = currentSequence;
            }
        } return maxSequence;
    }
}



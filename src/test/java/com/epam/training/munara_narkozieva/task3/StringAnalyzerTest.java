package com.epam.training.munara_narkozieva.task3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringAnalyzerTest {

    @Test

    public void findMaxUnequalConsecutiveCharacters () {
        String input = "aabbcde";
        StringAnalyzer analyzer = new StringAnalyzer(input);
        int result = analyzer.findMaxUnequalConsecutiveCharacters();
        assertEquals(4, result);
    }
@Test
    public void findMaxConsecutiveIdenticalLetters() {
        StringAnalyzer analyzer = new StringAnalyzer("hheeelllloo");
        int result = analyzer.findMaxConsecutiveIdenticalLetters();
        assertEquals(4, result, "The max consecutive identical letters should be 4");
    }

    @Test
    public void findMaxConsecutiveIdenticalDigits() {
        String input = "11223334444abc123";
        StringAnalyzer analyzer = new StringAnalyzer(input);
        int result = analyzer.findMaxConsecutiveIdenticalDigits();
        assertEquals(4, result);
    }
    @Test
    public void findMaxConsecutiveIdenticalChars() {
        String input = "aajjrroonnnnnoo";
        StringAnalyzer analyzer = new StringAnalyzer(input);
        int result = analyzer.findMaxConsecutiveIdenticalChars();
        assertEquals(5, result);
    }



}

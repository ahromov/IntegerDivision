/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andrii
 */
public class Anagram {

    public void printRevertedString(String input) {
        System.out.println(createAnagramedWords(input));
    }

    public String createAnagramedWords(String input) {
        return String.join(" ", getAnagramedWords(splitWords(input)));
    }

    private List<String> splitWords(String input) {
        return Arrays.asList(input.split(" "));
    }

    private List<String> getAnagramedWords(List<String> words) {
        List<String> anagramedWords = new ArrayList<>();
        words.forEach(word -> anagramedWords.add(reverseWord(word)));
        return anagramedWords;
    }

    private String reverseWord(String word) {
        return putNonLetters(getNonLetters(word), reverseLetters(word));
    }

    private Map<Integer, Character> getNonLetters(String word) {
        Map<Integer, Character> nonLetters = new HashMap<>();
        for (int j = 0; j < word.length(); j++) {
            int symbol = word.charAt(j);
            if (!Character.isLetter(symbol)) {
                nonLetters.put(j, (char)symbol);
            }
        }
        return nonLetters;
    }

    private String reverseLetters(String word) {
        StringBuilder sb = new StringBuilder();
        for (int j = word.length() - 1; j >= 0; j--) {
            int letter = word.charAt(j);
            if (Character.isLetter(letter)) {
                sb.append((char) letter);
            }
        }
        return sb.toString();
    }

    private String putNonLetters(Map<Integer, Character> m, String revertedWord) {
        StringBuilder sb = new StringBuilder(revertedWord);
        m.entrySet().forEach(entry -> sb.insert((int)entry.getKey(), entry.getValue()));
        return sb.toString();
    }

}

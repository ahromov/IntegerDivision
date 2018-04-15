/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andrii Hromov
 */
public class Main {

    private static final char EMPTY_SYMBOL = '\u0000';

    public static void main(String[] args) {
        if (args.length > 0) {
            printRevertedString(args[0]);
        } else {
            System.out.println("No argument(s)! USAGE: java Anagram \"Some line\"");
        }
    }

    public static void printRevertedString(String input) {
        System.out.println(createAnagramedWords(input));
    }

    public static String createAnagramedWords(String words) {
        List<String> wordsList = splitWords(words);
        StringBuilder anagramedWords = new StringBuilder();
        wordsList.forEach((word) -> {
            anagramedWords.append(reverseWord(word)).append(" ");
        });
        return anagramedWords.toString();
    }

    private static List<String> splitWords(String input) {
        return Arrays.asList(input.split(" "));
    }

    private static String reverseWord(String word) {
        char[] reversedChars = getNonLetters(word);
        return putReverseLetters(reversedChars, word);
    }

    private static char[] getNonLetters(String word) {
        char[] reversedChars = new char[word.length()];
        for (int j = 0; j < word.length(); j++) {
            int symbol = word.charAt(j);
            if (Character.isLetter(symbol)) {
                reversedChars[j] = EMPTY_SYMBOL;
            } else {
                reversedChars[j] = (char) symbol;
            }
        }
        return reversedChars;
    }

    private static String putReverseLetters(char[] chars, String word) {
        char[] charsCopy = Arrays.copyOf(chars, chars.length);
        for (int j = 0; j < word.length(); j++) {
            int symbol = word.charAt(j);
            if (Character.isLetter(symbol)) {
                for (int k = charsCopy.length - 1; k >= 0; k--) {
                    if (isEmptySymbol(charsCopy[k])) {
                        charsCopy[k] = (char) symbol;
                        break;
                    }
                }
            }
        }
        return Arrays.toString(charsCopy);
    }

    private static boolean isEmptySymbol(char symbol) {
        return symbol == EMPTY_SYMBOL;
    }

}

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
        System.out.println(createAnagramedString(input));
    }

    public static String createAnagramedString(String words) {
        List<String> wordsList = createWordsList(words);
        StringBuilder anagramedStringBuilder = new StringBuilder();
        for (int i = 0; i < wordsList.size(); i++) {
            anagramedStringBuilder.append(reverseWord(wordsList.get(i))).append(" ");
        }
        return anagramedStringBuilder.toString();
    }

    private static List<String> createWordsList(String input) {
        return Arrays.asList(input.split(" "));
    }

    private static String reverseWord(String word) {
        int symbol = 0;
        char[] arrayForNewReverseWord = putNonLetters(word);
        for (int j = 0; j < word.length(); j++) {
            symbol = word.charAt(j);
            putReversedLetters(symbol, arrayForNewReverseWord);
        }
        return Arrays.toString(arrayForNewReverseWord);
    }

    private static char[] putNonLetters(String word) {
        int symbol;
        char[] charsArray = new char[word.length()];
        for (int j = 0; j < word.length(); j++) {
            symbol = word.charAt(j);
            if (Character.isLetter(symbol)) {
                charsArray[j] = EMPTY_SYMBOL;
            } else {
                charsArray[j] = (char) symbol;
            }
        }
        return charsArray;
    }

    private static void putReversedLetters(int symbol, char[] arrayForNewReverseWord) {
        if (Character.isLetter(symbol)) {
            for (int k = arrayForNewReverseWord.length - 1; k >= 0; k--) {
                if (isEmptySymbol(arrayForNewReverseWord[k])) {
                    arrayForNewReverseWord[k] = (char) symbol;
                    break;
                }
            }
        }
    }

    private static boolean isEmptySymbol(char symbol) {
        return symbol == EMPTY_SYMBOL;
    }

}

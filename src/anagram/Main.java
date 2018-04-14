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

    public static void main(String[] args) {
        if (args.length > 0) {
            reverseEachWordOfString(args[0]);
        } else {
            System.out.println("No argument! USAGE: java Anagram \"Some line\"");
        }
    }

    public static void reverseEachWordOfString(String input) {
        String[] words = input.split(" ");
        List<String> wordsList = Arrays.asList(words);
        StringBuilder newLineBuffer = new StringBuilder("");
        String reverseString = parseEachWordsOnCharsAndPuttReverseIntoArray(wordsList, newLineBuffer);
        System.out.println(input);
        System.out.println(reverseString);
    }

    private static String parseEachWordsOnCharsAndPuttReverseIntoArray(List<String> words, StringBuilder reverseString) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            char[] arrayForNewReverseWord = parseWordOnChars(word);
            reverseEachWord(word, arrayForNewReverseWord);
            reverseString.append(String.valueOf(arrayForNewReverseWord)).append(" ");
        }
        return reverseString.toString();
    }

    private static void reverseEachWord(String word, char[] arrayForNewReverseWord) {
        for (int j = 0; j < word.length(); j++) {
            if (Character.isLetter(word.charAt(j))) {
                for (int k = arrayForNewReverseWord.length - 1; k >= 0; k--) {
                    if (arrayForNewReverseWord[k] == '\u0000') {
                        arrayForNewReverseWord[k] = word.charAt(j);
                        break;
                    }
                }
            }
        }
    }

    private static char[] parseWordOnChars(String word) {
        char[] arrayForNewReverseWord = new char[word.length()];
        for (int j = 0; j < word.length(); j++) {
            if (Character.isLetter(word.charAt(j))) {
                arrayForNewReverseWord[j] = '\u0000';
            } else {
                arrayForNewReverseWord[j] = word.charAt(j);
            }
        }
        return arrayForNewReverseWord;
    }

}

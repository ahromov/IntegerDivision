/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

/**
 *
 * @author Andrii Hromov
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 0) {
            Anagram anagram = new Anagram();
            printAnagramedString(anagram, args);
        } else {
            printWarningMessage();
        }
    }

    private static void printWarningMessage() {
        System.out.println("No argument(s)! USAGE: java Anagram \"Some line\"");
    }

    private static void printAnagramedString(Anagram anagram, String[] args) {
        System.out.println(anagram.createAnagramedWords(args[0]));
    }

   

}

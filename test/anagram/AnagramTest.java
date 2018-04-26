/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Andrii
 */
public class AnagramTest {
    
    @Test (expected = NullPointerException.class)
    public void whenStringNullThenExceptionThrown() {
        String input = null;
        Anagram instance = new Anagram();
        instance.createAnagramedWords(input);
    }
    
    @Test
    public void whenStringIsEmptyThenBackEmptyString() {
        String input = "";
        Anagram instance = new Anagram();
        String expResult = "";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void whenWordsConsistsOfLettersOnlyThenCreateAnagramedWords() {
        String input = "its test method";
        Anagram instance = new Anagram();
        String expResult = "sti tset dohtem";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void whenStringConsistsOfDigitsOnlyThenDigitsStayOnSamePlaces() {
        String input = "123 45678 90";
        Anagram instance = new Anagram();
        String expResult = "123 45678 90";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void whenWordsConsistsOfSpecSymbolsOnlyThenSymbolsStayOnSamePlaces() {
        String input = "!@ #$% ^&*()";
        Anagram instance = new Anagram();
        String expResult = "!@ #$% ^&*()";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void whenWordsConsistsOfLettersAndDigitsThenReverseLettersNumbersStayOnSamePlaces() {
        String input = "1ts te5t meth0d";
        Anagram instance = new Anagram();
        String expResult = "1st te5t dhte0m";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void whenWordsConsistsOfLettersAndSpecSymbolsThenReverseLettersSymbolsStayOnSamePlaces() {
        String input = "!ts test& meth0d";
        Anagram instance = new Anagram();
        String expResult = "!st tset& dhte0m";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void whenStringConsistsOfDigitsAndSpecSymbolsThenTheyStayOnSamePlaces() {
        String input = "!1@2 #3$4%5 ^6&7";
        Anagram instance = new Anagram();
        String expResult = "!1@2 #3$4%5 ^6&7";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void whenWordsConsistsOfLettersDigitsSpecSymbolsThenReverseLettersSymbolsDigitsStayOnSamePlaces() {
        String input = "!1ts te5t& meth0d&";
        Anagram instance = new Anagram();
        String expResult = "!1st te5t& dhte0m&";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
}

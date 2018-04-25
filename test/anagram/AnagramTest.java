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
    
    public AnagramTest() {
    }
    
    /**
     * Test of printRevertedString method, of class Anagram.
     */
    @Test
    public void testPrintRevertedString() {
        System.out.println("printRevertedString");
        String input = "";
        Anagram instance = new Anagram();
        String expResult = "";
        instance.printRevertedString(input);
        assertEquals(expResult, input);
    }

    /**
     * Test of createAnagramedWords method, of class Anagram.
     */
    @Test
    public void testCreateAnagramedWords() {
        System.out.println("createAnagramedWords");
        String input = "Hello1";
        Anagram instance = new Anagram();
        String expResult = "olleH1";
        String result = instance.createAnagramedWords(input);
        assertEquals(expResult, result);
    }
    
}

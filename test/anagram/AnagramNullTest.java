/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Andrii Hromov
 */
public class AnagramNullTest {
    
    Anagram anagram;
    
    public AnagramNullTest() {
        this.anagram = new Anagram();
    }
    
    @Test(expected = NullPointerException.class)
    public final void whenStringIsNullThenExceptionThrown() {
        assertEquals("Expected NullPointerException wasn't thrown", anagram.createAnagramedWords(null));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 */
public class NumericParserTest {

    NumericParser numericParser;

    public NumericParserTest() {
        numericParser = new NumericParser("-12345");
    }

    /**
     * Test of checkIsEmpty method, of class NumericParser.
     */
    @Test
    public void testCheckIsEmpty() {
        System.out.println("checkIsEmpty");
        NumericParser instance = numericParser;
        boolean expResult = false;
        boolean result = instance.checkIsEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumeric method, of class NumericParser.
     */
    @Test
    public void testGetNumeric() {
        NumericParser instance = numericParser;
        int expResult = -12345;
        int result = instance.getNumeric();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkIfSined method, of class NumericParser.
     */
    @Test
    public void testCheckIfSined() {
        NumericParser instance = numericParser;
        boolean expResult = true;
        boolean result = instance.checkIfSined();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSing method, of class NumericParser.
     */
    @Test
    public void testGetSing() {
        NumericParser instance = numericParser;
        String expResult = "-";
        String result = instance.getSing();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDigitsNumber method, of class NumericParser.
     */
    @Test
    public void testGetDigitsNumber() {
        NumericParser instance = numericParser;
        int expResult = 5;
        int result = instance.getDigitsNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElement method, of class NumericParser.
     */
    @Test
    public void testGetElement() {
        int position = 1;
        NumericParser instance = numericParser;
        int expResult = 2;
        int result = instance.getElement(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeElement method, of class NumericParser.
     */
    @Test
    public void testRemoveElement() {
        int i = 0;
        NumericParser instance = numericParser;
        instance.removeElement(i);
        int expDigitsNumber = 4;
        assertEquals(expDigitsNumber, numericParser.getDigitsNumber());
    }

    /**
     * Test of getNextElement method, of class NumericParser.
     */
    @Test
    public void testGetNextElement() {
        NumericParser instance = numericParser;
        int expResult = 1;
        int result = instance.getNextElement();
        assertEquals(expResult, result);
    }

}

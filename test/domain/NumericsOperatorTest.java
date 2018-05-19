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
public class NumericsOperatorTest {

    NumericsOperator numericsOperator;
    NumericParser devidedNumeric;
    NumericParser deviderNumeric;

    public NumericsOperatorTest() {
        numericsOperator = new NumericsOperator();
        devidedNumeric = new NumericParser("1000");
        deviderNumeric = new NumericParser("5");
    }

    /**
     * Test of getIncompletePartial method, of class NumericsOperator.
     */
    @Test
    public void testGetIncompletePartial() {
        NumericsOperator instance = numericsOperator;
        int expResult = 10;
        int result = instance.getIncompletePartial(devidedNumeric, deviderNumeric);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNewDevidedNumeric method, of class NumericsOperator.
     */
    @Test
    public void testGetNewDevidedNumeric() {
        numericsOperator.getIncompletePartial(devidedNumeric, deviderNumeric);
        int odd = 5;
        NumericParser npDevided = devidedNumeric;
        NumericsOperator instance = numericsOperator;
        int expResult = 50;
        int result = instance.getNewDevidedNumeric(odd, npDevided);
        assertEquals(expResult, result);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Andrew Hromov
 */
public class NumericParser {

    private int numeric;
    private List<String> elementsOfNumeric = new LinkedList<>();
    private boolean isSined = false;
    private int numberOfDigits;

    public NumericParser(String numeric) {
        this.numeric = Integer.parseInt(numeric);
        if (numeric.charAt(0) == '-') {
            isSined = true;
            Character.toString(numeric.charAt(0));
            for (int i = 1; i < numeric.length(); i++) {
                elementsOfNumeric.add(Character.toString(numeric.charAt(i)));
            }
            numberOfDigits = elementsOfNumeric.size();
        } else {
            for (int i = 0; i < numeric.length(); i++) {
                elementsOfNumeric.add(Character.toString(numeric.charAt(i)));
            }
            numberOfDigits = elementsOfNumeric.size();
        }
    }

    public boolean checkIsEmpty() {
        return elementsOfNumeric.isEmpty();
    }

    public int getNumeric() {
        return numeric;
    }

    public boolean checkIfSined() {
        return isSined;
    }

    public int getDigitsNumber() {
        return numberOfDigits;
    }

    public int getElement(int position) {
        return Integer.parseInt(elementsOfNumeric.get(position));
    }

    public void removeElement(int i) {
        elementsOfNumeric.remove(i);
        numberOfDigits = elementsOfNumeric.size();
    }

    public int getNextElement() {
        ListIterator<String> li = elementsOfNumeric.listIterator();
        if (li.hasNext()) {
            return Integer.parseInt((String) li.next());
        }
        return 0;
    }

}

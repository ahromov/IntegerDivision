/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author Andrew Hromov
 */
public class NumericParser {

    private int numeric;

    private List<String> elementsOfNumeric = new LinkedList<>();
    private boolean isSined = false;
    private String sing;
    private int numberOfDigits;

    public NumericParser(String numeric) {
        this.numeric = Integer.parseInt(numeric);
        if (numeric.charAt(0) == '-') {
            isSined = true;
            sing = Character.toString(numeric.charAt(0));
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

    public String getSing() {
        return sing;
    }

    public int getDigitsNumber() {
        return numberOfDigits;
    }

    /**
     *
     * @param position start from 1 if numeric is sined.
     * @return digit as integer by index.
     */
    public int getElement(int position) {
        return Integer.parseInt(elementsOfNumeric.get(position));
    }

    public void removeElement(int i){
        elementsOfNumeric.remove(i);
    }
    
    public void removePreviosElement() {
        ListIterator li = elementsOfNumeric.listIterator();
        if (li.hasPrevious()) {
            elementsOfNumeric.remove((String) li.previous());
        }
    }

    public int getNextElement() {
        ListIterator li = elementsOfNumeric.listIterator();
        if (li.hasNext()) {
            return Integer.parseInt((String) li.next());
        }
        return 0;
    }

}

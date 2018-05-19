/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Andrew Hromov
 */
public class NumericsOperator {

    public int getIncompletePartial(NumericParser devidedNumeric, NumericParser deviderNumeric) {
        StringBuilder sb = new StringBuilder();
        int firstElement = 0;
        if (deviderNumeric.getDigitsNumber() == 1) {
            sb.append(devidedNumeric.getNextElement());
            devidedNumeric.removeElement(firstElement);
        } else {
            for (int i = 0; i < deviderNumeric.getDigitsNumber(); i++) {
                sb.append(devidedNumeric.getNextElement());
                if (!devidedNumeric.checkIsEmpty()) {
                    devidedNumeric.removeElement(firstElement);
                }
            }
        }
        String incompletePartial = sb.toString();
        if (Integer.parseInt(incompletePartial) >= deviderNumeric.getNumeric()) {
            return Integer.parseInt(incompletePartial);
        } else {
            incompletePartial = sb.append(devidedNumeric.getNextElement()).toString();
            if (!devidedNumeric.checkIsEmpty()) {
                devidedNumeric.removeElement(firstElement);
            }
        }
        return Integer.parseInt(incompletePartial);
    }

    public int getNewDevidedNumeric(int odd, NumericParser npDevided) {
        StringBuilder sb = new StringBuilder(odd);
        int firstElement = 0;
        sb.append(odd).append(npDevided.getNextElement());
        if (!npDevided.checkIsEmpty()) {
            npDevided.removeElement(firstElement);
        }
        return Integer.parseInt(sb.toString());
    }

}

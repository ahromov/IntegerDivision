/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.NumericParser;
import domain.NumericsOperator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andrew Hromov
 */
public class Main {

    public static void main(String[] args) {
        String devidedNumeric = "78945";
        String deviderNumeric = "4";

        NumericParser npDevidedNum = new NumericParser(devidedNumeric);
        NumericParser npDeviderNum = new NumericParser(deviderNumeric);
        NumericsOperator nOper = new NumericsOperator();

        List<Integer> devisionResults = new LinkedList<>();
        List<Integer> multiplResults = new LinkedList<>();
        List<Integer> submisioResults = new LinkedList<>();
        List<Integer> newDevidedNumerics = new LinkedList<>();

        int incPart, devRes, multRes, submRes, newDevided;

        incPart = nOper.getIncompletePartial(npDevidedNum, npDeviderNum);
        newDevidedNumerics.add(incPart);
        devRes = incPart / npDeviderNum.getNumeric();
        devisionResults.add(devRes);
        multRes = devRes * npDeviderNum.getNumeric();
        multiplResults.add(multRes);
        submRes = incPart - multRes;
        submisioResults.add(submRes);

        while (!npDevidedNum.checkIsEmpty()) {
            newDevided = nOper.getNewDevidedNumeric(submRes, npDevidedNum);
            newDevidedNumerics.add(newDevided);
            devRes = newDevided / npDeviderNum.getNumeric();
            devisionResults.add(devRes);
            multRes = devRes * npDeviderNum.getNumeric();
            multiplResults.add(multRes);
            submRes = newDevided - multRes;
            submisioResults.add(submRes);
        }

        System.out.println("_" + npDevidedNum.getNumeric() + "\t|" + npDeviderNum.getNumeric());
        System.out.println(" " + incPart + "\t|---------");
        System.out.println(" " + "-" + "\t|" + devisionResults.toString());
        System.out.println("_" + newDevidedNumerics.get(1));
        System.out.println(" " + multiplResults.get(1));
        System.out.println(" " + "--");
        System.out.println(" " + "_" + newDevidedNumerics.get(2));
        System.out.println(" " + " " + multiplResults.get(2));
        System.out.println(" " + " " + "--");
        System.out.println(" " + " " + "_" + newDevidedNumerics.get(3));
        System.out.println(" " + " " + " " + multiplResults.get(3));
        System.out.println(" " + " " + " " + "--");
        System.out.println(" " + " " + " " + "_" + newDevidedNumerics.get(4));
        System.out.println(" " + " " + " " + " " + multiplResults.get(4));
        System.out.println(" " + " " + " " + " " + "--");
        System.out.println(" " + " " + " " + " " + " " + submisioResults.get(4));
    }

}

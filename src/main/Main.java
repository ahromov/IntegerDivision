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
        StringBuilder devisionResults = new StringBuilder();
        List<Integer> multiplResults = new LinkedList<>();
        List<Integer> submisioResults = new LinkedList<>();
        List<Integer> newDevidedNumerics = new LinkedList<>();
        int incPart = nOper.getIncompletePartial(npDevidedNum, npDeviderNum);
        newDevidedNumerics.add(incPart);
        int devRes = incPart / npDeviderNum.getNumeric();
        devisionResults.append(devRes);
        int multRes = devRes * npDeviderNum.getNumeric();
        multiplResults.add(multRes);
        int submRes = incPart - multRes;
        while (!npDevidedNum.checkIsEmpty()) {
            int newDevided = nOper.getNewDevidedNumeric(submRes, npDevidedNum);
            newDevidedNumerics.add(newDevided);
            devRes = newDevided / npDeviderNum.getNumeric();
            devisionResults.append(devRes);
            multRes = devRes * npDeviderNum.getNumeric();
            multiplResults.add(multRes);
            submRes = newDevided - multRes;
        }
        System.out.println(" _" + npDevidedNum.getNumeric() + "\t|" + npDeviderNum.getNumeric());
        System.out.println("  " + multiplResults.get(0) + "\t|" + printDeshes(devisionResults.length()));
        System.out.println("  " + printDeshes(newDevidedNumerics.get(0).toString().length()) + "\t|" + devisionResults.toString());
        printToColumn(newDevidedNumerics, multiplResults);
        System.out.println(addBackspaces(newDevidedNumerics.size() + 1) + submRes);
    }

    private static void printToColumn(List<Integer> newDevidedNumerics, List<Integer> multiplResults) {
        for (int i = 1; i < newDevidedNumerics.size(); i++) {
            System.out.println(addBackspaces(i) + "_" + newDevidedNumerics.get(i));
            System.out.println(addBackspaces(i) + " " + multiplResults.get(i));
            System.out.println(addBackspaces(i) + " " + printDeshes(newDevidedNumerics.get(i).toString().length()));
        }
    }

    private static String addBackspaces(int count) {
        StringBuilder sb = new StringBuilder();
        if (count < 1) {
            return sb.toString();
        } else {
            for (int i = 0; i < count; i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String printDeshes(Integer numLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numLength; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}

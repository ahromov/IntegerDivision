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
 * @author Andrii Hromov
 */
public class Main {
    public static void main(String[] args) {
        String InputDevidedNumeric = "-78945";
        String outputDeviderNumeric = "4";
        NumericParser parsedDevided = new NumericParser(InputDevidedNumeric);
        NumericParser parsedDevider = new NumericParser(outputDeviderNumeric);
        NumericsOperator numericsOperator = new NumericsOperator();
        StringBuilder devisionResults = new StringBuilder();
        List<Integer> multipleResults = new LinkedList<>();
        List<Integer> newDevidedNumerics = new LinkedList<>();
        int incompletePartial = numericsOperator.getIncompletePartial(parsedDevided, parsedDevider);
        newDevidedNumerics.add(incompletePartial);
        int devisionResult = incompletePartial / parsedDevider.getNumeric();
        devisionResults.append(devisionResult);
        int multipleResult = devisionResult * parsedDevider.getNumeric();
        multipleResults.add(multipleResult);
        int submisionResult = incompletePartial - multipleResult;
        while (!parsedDevided.checkIsEmpty()) {
            int newDevided = numericsOperator.getNewDevidedNumeric(submisionResult, parsedDevided);
            newDevidedNumerics.add(newDevided);
            devisionResult = newDevided / parsedDevider.getNumeric();
            devisionResults.append(devisionResult);
            multipleResult = devisionResult * parsedDevider.getNumeric();
            multipleResults.add(multipleResult);
            submisionResult = newDevided - multipleResult;
        }
        System.out.println(backspaceCheckerBeforeSined(parsedDevided) + "_" + parsedDevided.getNumeric() + "\t|" + parsedDevider.getNumeric());
        System.out.println("  " + multipleResults.get(0) + "\t|" + printDeshes(devisionResults.length()));
        System.out.println("  " + printDeshes(newDevidedNumerics.get(0).toString().length()) + "\t|" + signChecker(parsedDevided, parsedDevider) + devisionResults.toString());
        printToColumn(newDevidedNumerics, multipleResults);
        System.out.println(addBackspaces(newDevidedNumerics.size() + 1) + submisionResult);
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

    public static String backspaceCheckerBeforeSined(NumericParser np) {
        if (np.checkIfSined()) {
            return "";
        }
        return " ";
    }

    public static String signChecker(NumericParser devided, NumericParser devider) {
        if (devided.checkIfSined() || devider.checkIfSined()) {
            return "-";
        }
        return "";
    }

    private static String printDeshes(Integer numLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numLength; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}

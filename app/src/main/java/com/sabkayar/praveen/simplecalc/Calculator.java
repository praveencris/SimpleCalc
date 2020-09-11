package com.sabkayar.praveen.simplecalc;

/**
 * Utility class for SimpleCalc to perform the actual calculations.
 */
public class Calculator {

    //Available Operators
    public enum Operators {ADD, SUB, DIV, MUL}


    /**
     * Addition Operation
     */
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    /**
     * Subtraction Operation
     */
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * Division Operation
     */
    public double div(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    /**
     * Multiplication Operation
     */
    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

   /* private Calculator() {
    }*/
}

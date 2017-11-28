//**********************************************************************
// Copyright (c) 2017 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package br.org.fitec.cpi.tdd.ex1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

public class MyCalculator implements Calculator
{
	
	private static final String SEPARATOR = ",";
	
	private DoublePredicate filterDoubleNumbersLessThanZero = number -> number < 0;
	private IntPredicate filterIntNumbersLessThanZero = number -> number < 0;
	private DoublePredicate filterDoubleNumbersAllowedToOperate = number -> number >= 0 && number < 1000;
	private IntPredicate filterIntNumbersAllowedToOperate = number -> number >= 0 && number < 1000;
	private DoublePredicate filterDoubleNumbersEqualsZero = number -> number == 0;
	
	// Convert String of numbers into Integer Array
	private int[] convertStringToIntArray(String numbers) {
		if (numbers == null || numbers.length() == 0) {
			return new int[0];
		}
		return Arrays.stream(numbers.split(SEPARATOR)).mapToInt(number -> Integer.parseInt(number.trim())).toArray();
	}
	
	// Convert String of numbers into Double Array
	private double[] convertStringToDoubleArray(String numbers) {
		if (numbers == null || numbers.length() == 0) {
			return new double[0];
		}
		return Arrays.stream(numbers.split(SEPARATOR)).mapToDouble(number -> Double.parseDouble(number.trim())).toArray();
	}	
	
	// Add numbers
    @Override
    public int add(String numbers) throws NegativeNumberException {
    	int[] numbersArray = convertStringToIntArray(numbers);
    	int[] numbersLessThanZero = Arrays.stream(numbersArray).filter(filterIntNumbersLessThanZero).toArray();
        
        if(numbersLessThanZero.length > 0) {
        	throw new NegativeNumberException(numbersLessThanZero);
        }
        else {
        	return Arrays.stream(numbersArray).filter(filterIntNumbersAllowedToOperate).sum();
        }
    }

    // Subtract numbers
    @Override
	public int subtract(String numbers) throws NegativeNumberException {
    	int[] numbersArray = convertStringToIntArray(numbers);
    	int[] numbersLessThanZero = Arrays.stream(numbersArray).filter(filterIntNumbersLessThanZero).toArray();
    	
        if(numbersLessThanZero.length > 0) {
        	throw new NegativeNumberException(numbersLessThanZero);
        }
        else {
        	return Arrays.stream(numbersArray).filter(filterIntNumbersAllowedToOperate).reduce((a, b) -> a - b).orElse(0);
        }
	}

    // Multiply numbers
    @Override
	public double multiply(String numbers) throws NegativeNumberException {
    	double[] numbersArray = convertStringToDoubleArray(numbers);
    	double[] numbersLessThanZero = Arrays.stream(numbersArray).filter(filterDoubleNumbersLessThanZero).toArray();
    	
        if(numbersLessThanZero.length > 0) {
        	throw new NegativeNumberException(numbersLessThanZero);
        }
        else {
        	Double result = Arrays.stream(numbersArray).filter(filterDoubleNumbersAllowedToOperate).reduce((a, b) -> a * b).orElse(0.0);
        	return BigDecimal.valueOf(result).setScale(1, RoundingMode.UP).doubleValue();
        }
	}

	// Divide numbers
    @Override
	public double divide(String numbers) throws NegativeNumberException, DivisionByZeroNumberException {
    	double[] numbersArray = convertStringToDoubleArray(numbers);
    	double[] numbersLessThanZero = Arrays.stream(numbersArray).filter(filterDoubleNumbersLessThanZero).toArray();
    	double[] numbersAllowedToOperate = Arrays.stream(numbersArray).filter(filterDoubleNumbersAllowedToOperate).toArray();
    	double[] numbersEqualsZero = Arrays.stream(numbersArray).filter(filterDoubleNumbersEqualsZero).toArray();
    	
        if(numbersLessThanZero.length > 0) {
        	throw new NegativeNumberException(numbersLessThanZero);
        }
        else if(numbersEqualsZero.length > 1 || (numbersEqualsZero.length == 1 && numbersAllowedToOperate[0] != 0)) {
        	throw new DivisionByZeroNumberException("Division by Zero");
        }
        else {
        	Double result = Arrays.stream(numbersAllowedToOperate).reduce((a, b) -> a / b).orElse(0.0);
        	return BigDecimal.valueOf(result).setScale(1, RoundingMode.UP).doubleValue();
        }
	}

}

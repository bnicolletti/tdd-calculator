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

import java.util.Arrays;
import java.util.stream.Collectors;

public class NegativeNumberException extends Exception
{

    private static final long serialVersionUID = 1L;
    
    private static final String NEGATIVE_NOT_ALLOWED = "negatives not allowed: ";
	private static final String SEPARATOR = ",";

	public NegativeNumberException(int[] numbersLessThanZero)
    {
		super(NEGATIVE_NOT_ALLOWED.concat(Arrays.stream(numbersLessThanZero).mapToObj(Integer::toString).collect(Collectors.joining(SEPARATOR))));
    }

	public NegativeNumberException(double[] numbersLessThanZero) {
		super(NEGATIVE_NOT_ALLOWED.concat(Arrays.stream(numbersLessThanZero).mapToInt(number -> (int) number).mapToObj(Integer::toString).collect(Collectors.joining(SEPARATOR))));
	}

}

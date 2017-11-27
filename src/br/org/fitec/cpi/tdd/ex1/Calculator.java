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

public interface Calculator
{
	// Add numbers
    public int add(String numbers) throws NegativeNumberException;
    
    // Subtract numbers
    public int subtract(String numbers) throws NegativeNumberException;
    
    // Multiply numbers
    public double multiply(String numbers) throws NegativeNumberException;
    
    // Divide numbers
    public double divide(String numbers) throws NegativeNumberException, DivisionByZeroNumberException;
}

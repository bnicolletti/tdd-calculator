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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyCalculatorTest
{

    Calculator myCalculator;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        myCalculator = new MyCalculator();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        myCalculator = null;
    }

    
    // SUM - Start
    @Test
    public void testSumTwoNumbersSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(3, myCalculator.add("1,2"));
    }

    @Test
    public void testSumOneNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(1, myCalculator.add("1"));
    }

    @Test
    public void testSumNoNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(0, myCalculator.add(""));
        Assert.assertEquals(0, myCalculator.add(null));
    }

    @Test
    public void testSumAnyNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(45, myCalculator.add("1,2,3,4,5,6,7,8,9,0"));
    }

    @Test
    public void testSumOneNegativeNumberShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.add("-1");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -1", e.getMessage());
        }
    }

    @Test
    public void testSumOneNegativeOnePositiveNumbersShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.add("3,-1");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -1", e.getMessage());
        }
    }

    @Test
    public void testSumTwoNegativeNumberShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.add("-2,-5");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -2,-5", e.getMessage());
        }
    }

    @Test
    public void testSumThreeNegativeNumberWithSpaceShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.add(" -2,-4 , -6 ");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -2,-4,-6", e.getMessage());
        }
    }
    
    @Test
    public void testSumAnyNumbersWithThousandInitialMissSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(475, myCalculator.add("2000,300,100,50,25"));
    }
    
    @Test
    public void testSumAnyNumbersWithThousandMissSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(185, myCalculator.add("100,1001,50,2000,25,10"));
    }
    
    @Test
    public void testSumAnyNumbersWithZeroInitialSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(835, myCalculator.add("0,200,10,500,125"));
    }
    
    @Test
    public void testSumAnyNumbersWithZeroSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(213, myCalculator.add("10,1001,0,200,2,1"));
    }
    
    @Test
    public void testSumAnyNumbersWithZeroAndInitialZeroSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(345, myCalculator.add("0,10,1500,0,2300,225,110"));
    }
    // SUM - Finish
    
    
    // SUBTRACT - Start
    @Test
    public void testSubtractTwoNumbersSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(-1, myCalculator.subtract("1,2"));
    }
    
    @Test
    public void testSubtractOneNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(2, myCalculator.subtract("2"));
    }
    
    @Test
    public void testSubtractNoNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(0, myCalculator.subtract(""));
        Assert.assertEquals(0, myCalculator.subtract(null));
    }

    @Test
    public void testSubtractAnyNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(45, myCalculator.subtract("100,10,9,8,7,6,5,4,3,2,1"));
    }

    @Test
    public void testSubtractOneNegativeNumberShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.subtract("-3");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -3", e.getMessage());
        }
    }

    @Test
    public void testSubtractOneNegativeOnePositiveNumbersShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.subtract("5,-2");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -2", e.getMessage());
        }
    }

    @Test
    public void testSubtractTwoNegativeNumberShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.subtract("-3,-1");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -3,-1", e.getMessage());
        }
    }

    @Test
    public void testSubtractTwoNegativeNumberWithSpaceShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.subtract("-2 , -1, -3 ");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -2,-1,-3", e.getMessage());
        }
    }
    
    @Test
    public void testSubtractAnyNumbersWithThousandInitialMissSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(125, myCalculator.subtract("2000,300,100,50,25"));
    }
    
    @Test
    public void testSubtractAnyNumbersWithThousandMissSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(15, myCalculator.subtract("100,1001,50,2000,25,10"));
    }
    
    @Test
    public void testSubtractAnyNumbersWithZeroInitialSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(-170, myCalculator.subtract("0,30,10,5,125"));
    }
    
    @Test
    public void testSubtractAnyNumbersWithZeroSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(265, myCalculator.subtract("800,1800,0,500,2600,25,10"));
    }
    
    @Test
    public void testSubtractAnyNumbersWithZeroAndInitialZeroSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(-23, myCalculator.subtract("0,10,1200,5,2900,0,7,1"));
    }
    // SUBTRACT - Finish
    
    
    // MULTIPLY - Start
    @Test
    public void testMultiplyTwoNumbersSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(2, myCalculator.multiply("1,2"), 0.1);
    }
    
    @Test
    public void testMultiplyOneNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(7, myCalculator.multiply("7"), 0.1);
    }
    
    @Test
    public void testMultiplyNoNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(0, myCalculator.multiply(""), 0.1);
        Assert.assertEquals(0, myCalculator.multiply(null), 0.1);
    }

    @Test
    public void testMultiplyAnyNumberSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(3628800, myCalculator.multiply("1,2,3,4,5,6,7,8,9,10"), 0.1);
    }

    @Test
    public void testMultiplyOneNegativeNumberShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.multiply("-7");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -7", e.getMessage());
        }
    }

    @Test
    public void testMutiplyOneNegativeOnePositiveNumbersShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.multiply("4,-5");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -5", e.getMessage());
        }
    }

    @Test
    public void testMutiplyTwoNegativeNumberShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.multiply("-6,-8");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -6,-8", e.getMessage());
        }
    }

    @Test
    public void testMultiplyTwoNegativeNumberWithSpaceShouldFailException() throws NegativeNumberException
    {
        try
        {
            myCalculator.multiply(" -9,-1 , -4 ");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -9,-1,-4", e.getMessage());
        }
    }
    
    @Test
    public void testMutiplyAnyNumbersWithThousandInitialMissSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(1440, myCalculator.multiply("2000,8,30,6"), 0.1);
    }
    
    @Test
    public void testMutiplyAnyNumbersWithThousandMissSuccess() throws NegativeNumberException
    {
        Assert.assertEquals(1000, myCalculator.multiply("10,1001,5,2000,20"), 0.1);
    }
    // MULTIPLY - Finish
    
    
    // DIVIDE - Start
    @Test
    public void testDivideTwoNumbersSuccess() throws NegativeNumberException, DivisionByZeroNumberException
    {
        Assert.assertEquals(1.3, myCalculator.divide("4,3"), 0.1);
    }
    
    @Test
    public void testDivideOneNumberSuccess() throws NegativeNumberException, DivisionByZeroNumberException
    {
        Assert.assertEquals(6, myCalculator.divide("6"), 0.1);
    }
    
    @Test
    public void testDivideNoNumberSuccess() throws NegativeNumberException, DivisionByZeroNumberException
    {
        Assert.assertEquals(0, myCalculator.divide(""), 0.1);
        Assert.assertEquals(0, myCalculator.divide(null), 0.1);
    }

    @Test
    public void testDivideAnyNumberSuccess() throws NegativeNumberException, DivisionByZeroNumberException
    {
        Assert.assertEquals(0.2, myCalculator.divide("900,10,9,5,4,2"), 0.1);
    }

    @Test
    public void testDivideOneNegativeNumberShouldFailException() throws NegativeNumberException, DivisionByZeroNumberException
    {
        try
        {
            myCalculator.divide("-7");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -7", e.getMessage());
        }
    }

    @Test
    public void testDivideOneNegativeOnePositiveNumbersShouldFailException() throws NegativeNumberException, DivisionByZeroNumberException
    {
        try
        {
            myCalculator.divide("4,-5");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -5", e.getMessage());
        }
    }

    @Test
    public void testDivideTwoNegativeNumberShouldFailException() throws NegativeNumberException, DivisionByZeroNumberException
    {
        try
        {
            myCalculator.divide("-6,-8");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -6,-8", e.getMessage());
        }
    }

    @Test
    public void testDivideTwoNegativeNumberWithSpaceShouldFailException() throws NegativeNumberException, DivisionByZeroNumberException
    {
        try
        {
            myCalculator.divide(" -9,-1 , -4 ");
        }
        catch (NegativeNumberException e)
        {
            Assert.assertEquals("negatives not allowed: -9,-1,-4", e.getMessage());
        }
    }
    
    @Test
    public void testDivideAnyNumbersWithThousandInitialMissSuccess() throws NegativeNumberException, DivisionByZeroNumberException
    {
        Assert.assertEquals(0.2, myCalculator.divide("2000,40,20,10"), 0.1);
    }
    
    @Test
    public void testDivideAnyNumbersWithThousandMissSuccess() throws NegativeNumberException, DivisionByZeroNumberException
    {
        Assert.assertEquals(2.5, myCalculator.divide("300,1001,6,2000,5,4"), 0.1);
    }
    
    @Test
    public void testDivideNumberByZeroShouldFailException() throws NegativeNumberException, DivisionByZeroNumberException
    {
    	try
        {
            myCalculator.divide("20,1000,0,30,5");
        }
        catch (DivisionByZeroNumberException e)
        {
            Assert.assertEquals("division by zero", e.getMessage());
        }
    }
    
    @Test
    public void testDivideNumberByZeroInitialZeroShouldFailException() throws NegativeNumberException, DivisionByZeroNumberException
    {
    	try
        {
            myCalculator.divide("0,100,0,30,5");
        }
        catch (DivisionByZeroNumberException e)
        {
            Assert.assertEquals("division by zero", e.getMessage());
        }
    }
    
    @Test
    public void testDivideNumbersByZeroAndNumbersStartWithZeroSuccess() throws NegativeNumberException, DivisionByZeroNumberException
    {
    	Assert.assertEquals(0, myCalculator.divide("0,1001,10,2000,5"), 0.1);
    }
    // DIVIDE - Finish
}

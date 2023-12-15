package com.esg.util;
import org.junit.jupiter.api.*;

import com.esg.util.CheckNegativeValues.NegativesNotAllowedException;

public class StringCalculatorTest {

	private StringCalculator sc = new StringCalculator();

	@Test
    public void emptyString(){
    	Assertions.assertEquals(sc.Add(""), 0);
    }

	@Test
    public void emptyStringWithSpace(){
    	Assertions.assertEquals(sc.Add(" "), 0);
    }

	@Test
	public void singleNumber(){
    	Assertions.assertEquals(sc.Add("1"), 1);
    }
	
	@Test
    public void multipleNumbers(){
    	Assertions.assertEquals(sc.Add("10, 20, 30, 40"), 100);
    }

	@Test
    public void withNewLine(){
    	Assertions.assertEquals(sc.Add("10\n 20, 30"), 60);
    }

	@Test
    public void withDelimiter(){
    	Assertions.assertEquals(sc.Add("//;\\n1;2"), 3);
    }

	@Test
    public void checkNegative() {
        try {
            sc.Add("-1,-2,3");
        } catch (CheckNegativeValues.NegativesNotAllowedException e) {
        	System.out.println(e.getMessage());
        	Assertions.assertEquals(e.getMessage(), "Negatives not allowed: -1 -2 ");
        }
    }

	@Test
    public void checkNegativeWithDelimiter() {
        try {
            sc.Add("//%\\n1%-1%-2%-3%4");
        } catch (CheckNegativeValues.NegativesNotAllowedException e) {
        	Assertions.assertEquals(e.getMessage(), "Negatives not allowed: -1 -2 -3 ");
        }
    }

	@Test
    public void greaterThan1000(){
    	Assertions.assertEquals(sc.Add("//-\\n1001-1-2-3-2002"), 6);
    }

	@Test
    public void longDelimiter(){
    	Assertions.assertEquals(sc.Add("//%\\n1%2"), 3);
    }
    
	@Test
	public void longDelimiterWithBrace(){
    	Assertions.assertEquals(sc.Add("//[^^]\\n1^^2^^3"), 6);
    }

	@Test
    public void longDelimiterWithStar(){
    	Assertions.assertEquals(sc.Add("//[^^][%%][**]\\n1**2%%3^^4"), 10);
    }
}
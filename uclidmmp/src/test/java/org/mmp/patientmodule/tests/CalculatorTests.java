package org.mmp.patientmodule.tests;

import org.junit.Test;
import org.uclidmmp.javaprograms.Calculator;

import junit.framework.Assert;

public class CalculatorTests {
	
	@Test
	public void validateAdd()
	{
		Calculator cal = new Calculator();
		int actual = cal.add(2,3);
		int expected = 5;
		Assert.assertEquals(actual, expected);
	}

}

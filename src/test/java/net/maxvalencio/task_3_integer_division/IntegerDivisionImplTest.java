package net.maxvalencio.task_3_integer_division;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for IntegerDivisionImpl.
 */

public class IntegerDivisionImplTest {

	IntegerDivisionImpl integerDivision = new IntegerDivisionImpl();
	
	@Test
	public void divideInteger_correct() {
		String actual = integerDivision.divideInteger(78945, 4);
		String expected = "_78945|4\n" +
						  " 4    |-----\n" +
						  " -    |19736\n" +
						  "_38\n" +
						  " 36\n" +
						  " --\n" +
						  " _29\n" +
						  "  28\n" +
						  "  --\n" +
						  "  _14\n" +
						  "   12\n" +
						  "   --\n" +
						  "   _25\n" +
						  "    24\n" +
						  "    --\n" +
						  "     1\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_resultNegative_correct() {
		String actual = integerDivision.divideInteger(-78945, 4);
		String expected = "_78945|4\n" +
						  " 4    |------\n" +
						  " -    |-19736\n" +
						  "_38\n" +
						  " 36\n" +
						  " --\n" +
						  " _29\n" +
						  "  28\n" +
						  "  --\n" +
						  "  _14\n" +
						  "   12\n" +
						  "   --\n" +
						  "   _25\n" +
						  "    24\n" +
						  "    --\n" +
						  "     1\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_divedentZero_correct() {
		String actual = integerDivision.divideInteger(0, 5);
		String expected = "0 / 5 = 0";
		assertEquals(expected, actual);
	}

	@Test
	public void divideInteger_deviderZero_correct() {
		String actual = integerDivision.divideInteger(3, 0);
		String expected = "Error!!! Divider = 0 , division by zero ";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_ZeroByZero_correct() {
		String actual = integerDivision.divideInteger(0, 0);
		String expected = "Error!!! Divider = 0 , division by zero ";
		assertEquals(expected, actual);
	}
}

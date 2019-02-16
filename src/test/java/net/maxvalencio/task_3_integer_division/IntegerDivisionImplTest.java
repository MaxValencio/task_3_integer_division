package net.maxvalencio.task_3_integer_division;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for IntegerDivisionImpl.
 */

public class IntegerDivisionImplTest {

	private IntegerDivisionImpl integerDivision = new IntegerDivisionImpl();
	
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
	public void divideInteger_dividendZero_correct() {
		String actual = integerDivision.divideInteger(0, 5);
		String expected = "0 / 5 = 0";
		assertEquals(expected, actual);
	}

	@Test
	public void divideInteger_absoluteDividendLessAbsoluteDivider_correct() {
		String actual = integerDivision.divideInteger(-1, -11);
		String expected = "-1 / -11 = 0";
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
	
	@Test
	public void divideInteger_positiveByPositive_correct() {
		String actual = integerDivision.divideInteger(1, 1);
		String expected = "_1|1\n" + 
						  " 1|-\n" + 
						  " -|1\n" + 
						  " 0\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_positiveByNegative_correct() {
		String actual = integerDivision.divideInteger(1, -1);
		String expected = "_1|-1\n" + 
						  " 1|--\n" + 
						  " -|-1\n" + 
						  " 0\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_negativeByPositive_correct() {
		String actual = integerDivision.divideInteger(-1, 1);
		String expected = "-1|1\n" + 
						  " 1|--\n" + 
						  " -|-1\n" + 
						  " 0\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_negativeByNegative_correct() {
		String actual = integerDivision.divideInteger(-1, -1);
		String expected = "-1|-1\n" + 
						  " 1|--\n" + 
						  " -|1\n" + 
						  " 0\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_billionByThousand_correct() {
		String actual = integerDivision.divideInteger(1000000000, 1000);
		String expected = "_1000000000|1000\n" + 
				          " 1000      |-------\n" + 
				          " ----      |1000000\n" + 
				          "          0\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_zerosInResult_correct() {
		String actual = integerDivision.divideInteger(100, 99);
		String expected = "_100|99\n" + 
						  "  99|--\n" + 
				          "  --|1\n" + 
				          "   1\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideInteger_zerosInNegativeResult_correct() {
		String actual = integerDivision.divideInteger(200100, -100);
		String expected = "_200100|-100\n" + 
				          " 200   |-----\n" + 
				          " ---   |-2001\n" + 
				          "   _100\n" + 
			           	  "    100\n" + 
				          "    ---\n" + 
				          "      0\n";
		assertEquals(expected, actual);
	}
}

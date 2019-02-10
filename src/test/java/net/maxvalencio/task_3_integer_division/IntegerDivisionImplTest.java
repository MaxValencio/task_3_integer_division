package net.maxvalencio.task_3_integer_division;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for IntegerDivisionImpl.
 */

public class IntegerDivisionImplTest {

	IntegerDivisionImpl integerDivision = new IntegerDivisionImpl();

	@Test
	public void division_divedentZero_correct() {
		String actual = integerDivision.doDivision(0, 5);
		String expected = "0 / 5 = 0";
		assertEquals(expected, actual);
	}

	@Test
	public void division_deviderZero_correct() {
		String actual = integerDivision.doDivision(3, 0);
		String expected = "Error!!! Divider = 0 , division by zero ";
		assertEquals(expected, actual);
	}
}

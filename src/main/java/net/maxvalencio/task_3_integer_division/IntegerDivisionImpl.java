package net.maxvalencio.task_3_integer_division;

public class IntegerDivisionImpl implements IntegerDivision {

	public String divideInteger(int dividend, int divider) {
		StringBuilder quotient = new StringBuilder();
		StringBuilder divisionView = new StringBuilder();

		if (divider == 0) {
			return "Error!!! Divider = 0 , division by zero ";
		}
		if (Math.abs(dividend) < Math.abs(divider) && divider != 0) {
			return dividend + " / " + divider + " = 0";
		}

		createTableDivision(divisionView, quotient, dividend, divider);
		addQuotient(quotient, dividend, divider);
		addHeaderTableDivision(divisionView, quotient, dividend, divider);
		return divisionView.toString();
	}

	private void createTableDivision(StringBuilder divisionView, StringBuilder quotient, int dividend, int divider) {
		String remainder = "0";
		String[] dividendNumbers = String.valueOf(Math.abs(dividend)).split("");
		for (int i = 0; i < dividendNumbers.length; i++) {
			if (Integer.parseInt(remainder) == 0) {
				remainder = dividendNumbers[i];
			} else {
				remainder += dividendNumbers[i];
			}

			quotient.append(Integer.parseInt(remainder) / Math.abs(divider));

			String calculationIntermediate = String.valueOf((Integer.parseInt(remainder) / divider) * divider);

			if (Integer.parseInt(remainder) >= Math.abs(divider)) {
				addColumn(divisionView, remainder, calculationIntermediate, i);
			}

			remainder = String.valueOf(Integer.parseInt(remainder) % Math.abs(divider));

			if (i == dividendNumbers.length - 1) {
				addRemainder(divisionView, remainder, i);
			}
		}
	}

	private void addColumn(StringBuilder divisionView, String remainder, String intermediateСalculation, int i) {
		divisionView.append(String.format("%" + (i + 2) + "s", "_" + remainder)).append("\n");
		divisionView.append(String.format("%" + (i + 2) + "s", intermediateСalculation)).append("\n");
		divisionView.append(String.format("%" + (i + 2) + "s", addSymbolsLine(intermediateСalculation.length(), '-')))
				.append("\n");
	}

	private StringBuilder addSymbolsLine(int size, char symbol) {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < size; i++) {
			line.append(symbol);
		}
		return line;
	}

	private void addRemainder(StringBuilder divisionView, String remainder, int i) {
		divisionView.append(String.format("%" + (i + 2) + "s", remainder)).append("\n");
	}
	
	private void addQuotient(StringBuilder quotient, int dividend, int divider) {
		String buffer = quotient.toString().replaceFirst("^0*", "");
		quotient.setLength(0);
		quotient.append(buffer);
		if (isQuotientNegative(dividend, divider)) {
			quotient.insert(0, "-");
		}
	}

	private boolean isQuotientNegative(int dividend, int divider) {
		return (dividend / Math.abs(dividend)) * (divider / Math.abs(divider)) < 0;
	}

	private void addHeaderTableDivision(StringBuilder divisionView, StringBuilder quotient, int dividend, int divider) {
		int[] linesHeader = searchLinesHeader(divisionView);
		createHeader(linesHeader, divisionView, quotient, dividend, divider);
	}

	private int[] searchLinesHeader(StringBuilder divisionView) {
		int[] tableLines = new int[3];
		for (int i = 0, j = 0; i < divisionView.length(); i++) {
			if (divisionView.charAt(i) == '\n') {
				tableLines[j] = i;
				j++;
			}
			if (j == 3) {
				break;
			}
		}
		return tableLines;
	}

	private void createHeader(int[] linesHeader, StringBuilder divisionView, StringBuilder quotient, int dividend, int divider) {
		int quantitySpaces = calculateLineLength(Math.abs(dividend)) + 1 - linesHeader[0];
		divisionView.insert(linesHeader[2], addSymbolsLine(quantitySpaces, ' ') + "|" + quotient.toString());
		divisionView.insert(linesHeader[1], addSymbolsLine(quantitySpaces, ' ') + "|"
				+ addSymbolsLine(getMaxLengthNumbers(quotient, divider), '-'));
		divisionView.insert(linesHeader[0], "|" + divider);
		divisionView.replace(0, linesHeader[0], dividend < 0 ? String.valueOf(dividend) : "_" + dividend);
	}
	
	private int calculateLineLength(int i) {
		return (int) Math.log10(i) + 1;
	}

	private int getMaxLengthNumbers(StringBuilder quotient, Integer divider) {
		if (quotient.length() < divider.toString().length()) {
			return divider.toString().length();
		} else {
			return quotient.length();
		}
	}
}

package net.maxvalencio.task_3_integer_division;

public class IntegerDivisionImpl implements IntegerDivision {

	public String divideInteger(int dividend, int divider) {
		StringBuilder result = new StringBuilder();
		StringBuilder viewDivision = new StringBuilder();

		if (divider == 0) {
			return "Error!!! Divider = 0 , division by zero ";
		}
		if (dividend < divider && dividend >= 0) {
			return dividend + " / " + divider + " = 0";
		}

		boolean isResultNegative = checkResult(dividend, divider);
		boolean isDividendNegative = checkDividend(dividend);
		boolean isDividerNegative = checkDivider(divider);

		dividend = Math.abs(dividend);
		divider = Math.abs(divider);

		createViewDivision(viewDivision, result, dividend, divider);

		result = editResult(isResultNegative, result);
		dividend = editDividend(isDividendNegative, dividend);
		divider = editDivider(isDividerNegative, divider);

		modifyViewDivision(viewDivision, result, dividend, divider);
		return viewDivision.toString();
	}

	private boolean checkResult(int dividend, int divider) {
		if (dividend < 0 && divider > 0) {
			return true;
		}
		if (dividend > 0 && divider < 0) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkDividend(int dividend) {
		if (dividend < 0) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkDivider(int divider) {
		if (divider < 0) {
			return true;
		} else {
			return false;
		}
	}

	private void createViewDivision(StringBuilder viewDivision, StringBuilder result, int dividend, int divider) {
		String digitDividend = "";
		String[] numbersDividend = String.valueOf(dividend).split("");
		for (int i = 0; i < numbersDividend.length; i++) {
			if (i == 0) {
				digitDividend = numbersDividend[i];
			} else {
				digitDividend += numbersDividend[i];
			}

			result.append(Integer.parseInt(digitDividend) / divider);
			int multiply = (Integer.parseInt(digitDividend) / divider) * divider;

			if (Integer.parseInt(digitDividend) >= divider) {
				viewDivision.append(String.format("%" + (i + 2) + "s", "_" + digitDividend)).append("\n");
				viewDivision.append(String.format("%" + (i + 2) + "s", multiply)).append("\n");
				viewDivision.append(String.format("%" + (i + 2) + "s", createLine(String.valueOf(multiply).length())))
						.append("\n");
			}

			digitDividend = String.valueOf(Integer.parseInt(digitDividend) % divider);

			if (i == numbersDividend.length - 1) {
				viewDivision.append(String.format("%" + (i + 2) + "s", digitDividend)).append("\n");
			}
		}
	}

	private StringBuilder createLine(int size) {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < size; i++) {
			line.append("-");
		}
		return line;
	}

	private StringBuilder editResult(boolean isResultNegative, StringBuilder result) {
		StringBuilder resultChecked = new StringBuilder();
		String temp = result.toString().replaceAll("^0*", ""); // -> 123
		result.toString().replaceFirst("^0*", "");
		resultChecked.append(temp);

		if (isResultNegative) {
			resultChecked.insert(0, "-");
		}
		return resultChecked;
	}

	private int editDividend(boolean isDividendNegative, int dividend) {
		if (isDividendNegative) {
			dividend = -(dividend);
		}
		return dividend;
	}

	private int editDivider(boolean isDividerNegative, int divider) {
		if (isDividerNegative) {
			divider = -(divider);
		}
		return divider;
	}

	private void modifyViewDivision(StringBuilder view, StringBuilder result, Integer dividend, Integer divider) {
		int[] index = new int[3];
		for (int i = 0, j = 0; i < view.length(); i++) {
			if (view.charAt(i) == '\n') {
				index[j] = i;
				j++;
			}

			if (j == 3) {
				break;
			}
		}

		int tab = calculateDigit(Math.abs(dividend)) + 1 - index[0];
		view.insert(index[2], assemblyString(tab, ' ') + "|" + result.toString());
		view.insert(index[1], assemblyString(tab, ' ') + "|" + assemblyString(result.length(), '-'));
		view.insert(index[0], "|" + divider);
		view.replace(0, index[0], dividend < 0 ? dividend.toString() : "_" + Math.abs(dividend));
	}

	private int calculateDigit(int i) {
		return (int) Math.log10(i) + 1;
	}

	private String assemblyString(int numberOfSymbols, char symbol) {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < numberOfSymbols; i++) {
			string.append(symbol);
		}
		return string.toString();
	}
}

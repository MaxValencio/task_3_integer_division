package net.maxvalencio.task_3_integer_division;

public class IntegerDivisionImpl implements IntegerDivision {

	public String divideInteger(int divident, int divider) {
		StringBuilder result = new StringBuilder();
		StringBuilder viewResult = new StringBuilder();
		String digitDivident = "";
		Integer multiply;
		boolean isResultNegative = false;

		if (divider == 0) {
			return "Error!!! Divider = 0 , division by zero ";
		}
		if (divident < divider && divident >= 0) {
			return divident + " / " + divider + " = 0";
		}

		if (divident < 0 || divider < 0) {
			isResultNegative = true;
		}
		if (divident < 0 && divider < 0) {
			isResultNegative = false;
		}

		divident = Math.abs(divident);
		divider = Math.abs(divider);

		String[] numbersDivident = String.valueOf(divident).split("");

		for (int i = 0; i < numbersDivident.length; i++) {
			if (i == 0) {
				digitDivident = numbersDivident[i];
			} else {
				digitDivident += numbersDivident[i];
			}

			result.append(Integer.parseInt(digitDivident) / divider);
			multiply = (Integer.parseInt(digitDivident) / divider) * divider;

			if (Integer.parseInt(digitDivident) >= divider) {
				viewResult.append(String.format("%" + (i + 2) + "s", "_" + digitDivident)).append("\n");
				viewResult.append(String.format("%" + (i + 2) + "s", multiply)).append("\n");
				viewResult.append(String.format("%" + (i + 2) + "s", createLine(String.valueOf(multiply).length())))
						.append("\n");
			}

			digitDivident = String.valueOf(Integer.parseInt(digitDivident) % divider);

			if (i == numbersDivident.length - 1) {
				viewResult.append(String.format("%" + (i + 2) + "s", digitDivident)).append("\n");
			}
		}

		result = checkResult(result, isResultNegative);
		modifyViewResult(divident, divider, viewResult, result);
		return viewResult.toString();
	}

	private StringBuilder createLine(int size) {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < size; i++) {
			line.append("-");
		}
		return line;
	}

	private StringBuilder checkResult(StringBuilder result, boolean isResultNegative) {
		if (result.charAt(0) == '0') {
			result.deleteCharAt(0);
		}

		if (isResultNegative) {
			result.insert(0, "-");
		}
		return result;
	}

	private void modifyViewResult(Integer dividend, Integer divider, StringBuilder view, StringBuilder result) {
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

		int tab = calculateDigit(dividend) + 1 - index[0];
		view.insert(index[2], assemblyString(tab, ' ') + "|" + result.toString());
		view.insert(index[1], assemblyString(tab, ' ') + "|" + assemblyString(result.length(), '-'));
		view.insert(index[0], "|" + divider);
		view.replace(1, index[0], dividend.toString());
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

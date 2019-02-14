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

		createCollumsDivision(viewDivision, result, dividend, divider);
		createFullTableDivision(viewDivision, result, dividend, divider);
		return viewDivision.toString();
	}

	private void createCollumsDivision(StringBuilder viewDivision, StringBuilder result, int dividend, int divider) {
		dividend = Math.abs(dividend);
		divider = Math.abs(divider);
		String digitDividend = "";
		String[] numbersDividend = String.valueOf(dividend).split("");
		for (int i = 0; i < numbersDividend.length; i++) {
			if (i == 0) {
				digitDividend = numbersDividend[i];
			} else {
				digitDividend += numbersDividend[i];
			}

			result.append(Integer.parseInt(digitDividend) / divider);
			String multiply = String.valueOf((Integer.parseInt(digitDividend) / divider) * divider);

			if (Integer.parseInt(digitDividend) >= divider) {
				viewDivision.append(String.format("%" + (i + 2) + "s", "_" + digitDividend)).append("\n");
				viewDivision.append(String.format("%" + (i + 2) + "s", multiply)).append("\n");
				viewDivision.append(String.format("%" + (i + 2) + "s", addLineSymbols(multiply.length(),'-'))).append("\n");
			}

			digitDividend = String.valueOf(Integer.parseInt(digitDividend) % divider);

			if (i == numbersDividend.length - 1) {
				viewDivision.append(String.format("%" + (i + 2) + "s", digitDividend)).append("\n");
			}
		}
	}

	private StringBuilder addLineSymbols(int size, char symbol) {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < size; i++) {
			line.append(symbol);
		}
		return line;
	}

	private void createFullTableDivision(StringBuilder view, StringBuilder result, Integer dividend, Integer divider) {
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
		result = modifyResult(result, dividend, divider );
		int quantitySpaces = calculateDigits(Math.abs(dividend)) + 1 - index[0];
		view.insert(index[2], addLineSymbols(quantitySpaces,' ') + "|" + result.toString());
		view.insert(index[1], addLineSymbols(quantitySpaces,' ') + "|" + addLineSymbols(getMaxLengthNumbers(result, divider),'-'));
		view.insert(index[0], "|" + divider);
		view.replace(0, index[0], dividend < 0 ? dividend.toString() : "_" + dividend);
	}
	
	private StringBuilder modifyResult(StringBuilder result, int dividend, int divider) {
		StringBuilder resultChecked = new StringBuilder();	
		resultChecked.append(result.toString().replaceFirst("^0*", ""));

		if ((dividend < 0) ^ (divider < 0)) {
			resultChecked.insert(0, "-");
		}
		return resultChecked;
	}

	private int calculateDigits(int i) {
		return (int) Math.log10(i) + 1;
	}
	
	private int getMaxLengthNumbers(StringBuilder result, Integer divider) {
		if(result.length() < divider.toString().length()) {
			return divider.toString().length();
		} else {
			return result.length();
		}
	}
}

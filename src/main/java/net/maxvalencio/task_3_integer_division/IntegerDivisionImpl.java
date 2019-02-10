package net.maxvalencio.task_3_integer_division;

public class IntegerDivisionImpl implements IntegerDivision {

	public String doDivision(int divident, int divider) {
		boolean negativeResult = false;
		StringBuilder result = new StringBuilder();
		StringBuilder view = new StringBuilder();
		String[] buffer = String.valueOf(divident).split("");
		String dividentDigit = "";
		Integer multiply;

		if (divider == 0) {
			return "Error!!! Divider = 0 , division by zero ";
		}

		if (divident < divider) {
			return divident + " / " + divider + " = 0";
		}

		if (divident < 0 || divider < 0) {
			negativeResult = true;
		}

		if (divident < 0 && divider < 0) {
			negativeResult = false;
		}

		divident = Math.abs(divident);
		divider = Math.abs(divider);

		for (int i = 0; i < buffer.length; i++) {

			if (i == 0) {
				dividentDigit = buffer[i];
			} else {
				dividentDigit += buffer[i];
			}

			result.append(Integer.parseInt(dividentDigit) / divider);
			multiply = (Integer.parseInt(dividentDigit) / divider) * divider;

			if (Integer.parseInt(dividentDigit) >= divider) {
				view.append(String.format("%" + (i + 2) + "s", "_" + dividentDigit)).append("\n");
				view.append(String.format("%" + (i + 2) + "s", multiply)).append("\n");
				view.append(String.format("%" + (i + 2) + "s", dashes(String.valueOf(multiply).length()))).append("\n");
			}

			dividentDigit = String.valueOf(Integer.parseInt(dividentDigit) % divider);

			if (i == buffer.length - 1) {
				view.append(String.format("%" + (i + 2) + "s", dividentDigit));
			}
		}

		if (result.charAt(0) == '0') {
			result.deleteCharAt(0);
		}

		if (negativeResult) {
			result.insert(0, "-");
		}

		modifyView(divident, divider, view, result);
		return view.toString();
	}

	private StringBuilder dashes(int size) {
		StringBuilder dashes = new StringBuilder();
		for (int i = 0; i < size; i++) {
			dashes.append("-");
		}
		return dashes;
	}

	private void modifyView(Integer dividend, Integer divider, StringBuilder view, StringBuilder result) {
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
		view.insert(index[2], assemblyString(tab, ' ') + "│" + result.toString());
		view.insert(index[1], assemblyString(tab, ' ') + "│" + assemblyString(result.length(), '-'));
		view.insert(index[0], "│" + divider);
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

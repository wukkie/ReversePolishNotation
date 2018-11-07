package pl.lukaszmatug.rpn.calc.impl.operations;

import pl.lukaszmatug.rpn.calc.IMathOperation;

public class AddOperation implements IMathOperation {	
	private static final String equationSign = "+";

	public double calculate(double a, double b) {
		return a + b;
	}

	public static String getEquationSign() {
		return equationSign;
	}

}

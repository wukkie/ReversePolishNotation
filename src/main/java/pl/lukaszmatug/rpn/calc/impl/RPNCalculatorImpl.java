package pl.lukaszmatug.rpn.calc.impl;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.math.NumberUtils;

import pl.lukaszmatug.rpn.calc.ICalculator;
import pl.lukaszmatug.rpn.calc.IMathOperation;
import pl.lukaszmatug.rpn.calc.IRPNValidator;
import pl.lukaszmatug.rpn.calc.impl.operations.AddOperation;
import pl.lukaszmatug.rpn.calc.impl.operations.MultiplayOperation;
import pl.lukaszmatug.rpn.calc.impl.operations.SubstractionOperation;

public class RPNCalculatorImpl implements ICalculator {
	private Stack<Double> stack = new Stack<Double>();
	private IRPNValidator validator; 
	private Map<String, IMathOperation> operations = RPNOperations.get(); 

	private String[] equationPrepare(String equation) {
		validator.inputIsValid(equation);
		return equation.split("\\s");		
	}
	
	private double performOperation(String sign, double a, double b) {
		if(!operations.containsKey(sign)) {
			throw new IllegalArgumentException(String.format("Sign %s is not allowed", sign));
		}
		return operations.get(sign).calculate(a, b);
	}
	
	private double mathDo(String[] splited) throws IndexOutOfBoundsException {
		Double a,b;
		for(int i = 0, n = splited.length; i < n; i++) {
			if(NumberUtils.isCreatable(splited[i])) {
				stack.push(Double.parseDouble(splited[i]));
			} else {
				a = stack.pop();
				b = stack.pop();	
				stack.push(performOperation(splited[i], b, a));
			}
		}
		return stack.pop();
	}
	
	public double calculate(String equation) throws InvalidParameterException {
			return mathDo(equationPrepare(equation));
	}
	
	public RPNCalculatorImpl(IRPNValidator validator){
		this.validator = validator;
	}

}

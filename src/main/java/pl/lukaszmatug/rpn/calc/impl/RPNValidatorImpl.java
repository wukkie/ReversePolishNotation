package pl.lukaszmatug.rpn.calc.impl;

import java.security.InvalidParameterException;

import pl.lukaszmatug.rpn.calc.IRPNValidator;

public class RPNValidatorImpl implements IRPNValidator{
	
	public boolean inputIsValid(String equation) throws InvalidParameterException {
		if (equation.isEmpty() || equation == null) throw new InvalidParameterException("Empty string");
		return true;
	}

}

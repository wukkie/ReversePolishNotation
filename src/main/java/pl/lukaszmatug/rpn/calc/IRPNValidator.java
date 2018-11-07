package pl.lukaszmatug.rpn.calc;

import java.security.InvalidParameterException;

public interface IRPNValidator {
	public boolean inputIsValid(String equation) throws InvalidParameterException;
}

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction;

import org.junit.Assert;
import org.junit.Test;

import pl.lukaszmatug.rpn.calc.ICalculator;
import pl.lukaszmatug.rpn.calc.impl.RPNCalculatorImpl;
import pl.lukaszmatug.rpn.calc.impl.RPNValidatorImpl;

public class RPNTest {

	
	@Test(expected = InvalidParameterException.class)
	public void StringIsEmpty() {
		String number = "";
		ICalculator calculator = new RPNCalculatorImpl(new RPNValidatorImpl());
		double result = calculator.calculate(number);
		Assert.assertEquals("", 11d, result, 0);
	}


	@Test(expected = InvalidParameterException.class)
	public void StringIsNull() {
		String number = "";
		ICalculator calculator = new RPNCalculatorImpl(new RPNValidatorImpl());
		double result = calculator.calculate(number);
	}
	
	@Test
	public void CaluclateStandardTest() {
		String number = "5 3 2 * +";
		ICalculator calculator = new RPNCalculatorImpl(new RPNValidatorImpl());
		double result = calculator.calculate(number);
		Assert.assertEquals("", 11d, result, 0);
	}

	@Test
	public void SumOperationTest() {
		String number = "5 3 +";
		ICalculator calculator = new RPNCalculatorImpl(new RPNValidatorImpl());
		double result = calculator.calculate(number);
		Assert.assertEquals("", 8d, result, 0);
	}

	@Test
	public void DiversionOperationTest() {
		String number = "6 3 /";
		ICalculator calculator = new RPNCalculatorImpl(new RPNValidatorImpl());
		double result = calculator.calculate(number);
		Assert.assertEquals("", 2d, result, 0);
	}

}

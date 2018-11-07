package pl.lukaszmatug.rpn.calc.impl;

import java.util.HashMap;
import java.util.Map;

import pl.lukaszmatug.rpn.calc.IMathOperation;
import pl.lukaszmatug.rpn.calc.impl.operations.AddOperation;
import pl.lukaszmatug.rpn.calc.impl.operations.DiversionOperation;
import pl.lukaszmatug.rpn.calc.impl.operations.MultiplayOperation;
import pl.lukaszmatug.rpn.calc.impl.operations.SubstractionOperation;

public class RPNOperations {
	private static Map<String, IMathOperation> operations = new HashMap<String, IMathOperation>();
	
	 static  {
		operations.put(AddOperation.getEquationSign(), new AddOperation());
		operations.put(SubstractionOperation.getEquationSign(), new SubstractionOperation());
		operations.put(MultiplayOperation.getEquationSign(), new MultiplayOperation());
		operations.put(DiversionOperation.getEquationSign(), new DiversionOperation());
	}
	
	public static Map<String, IMathOperation> get() {
		return operations;
	}
}
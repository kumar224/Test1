package com.aegon;

import java.util.ArrayList;
import java.util.List;

public class SimpleCaluclateServiceImpl implements SimpleCaluclateService {
	private final int operand1;
	private final int operand2;
	private final char operator;
	private SimpleCaluclatorProvider caluclatorProvider;

	SimpleCaluclateServiceImpl(int operand1, int operand2, char operator) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;
		
		
	}
	
	public int getOperand1() {
		return operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public char getOperator() {
		return operator;
	}


	public List<Double> caluclate(SimpleCaluclatorProvider caluclatorProvider) {
		List<Double> result = new ArrayList<Double>();
		result.add(caluclatorProvider.add(operand1, operand2));
		result.add(caluclatorProvider.substract(operand1, operand2));
		result.add(caluclatorProvider.multiply(operand1, operand2));
		result.add(caluclatorProvider.divide(operand1, operand2));
		return result;
	}

}

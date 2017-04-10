package com.aegon;

public class SimpleCaluclatorProviderImpl implements SimpleCaluclatorProvider{

	public double add(int value1, int value2) {
		return  value1 + value2;
	}

	public double substract(int value1, int value2) {
		return value1 - value2;
	}

	public double multiply(int value1, int value2) {
		return value1 * value2;
	}

	public double divide(int value1, int value2) {
		return value1 / value2;
	}

	
}

package calculator.tests;

import calculator.*;

public class CalculatorTest {
	public static void main(String[] args) {
		TI test = new TI();
		test.setOperandOne(10.5);
		test.setOperandTwo(5.2);
		test.setOperator("+");
		test.performOperation();
		System.out.println(test.getResult());
		
		test.setOperandOne(10.5);
		test.setOperandTwo(5.2);
		test.setOperator("-");
		test.performOperation();
		System.out.println(test.getResult());
	}
}

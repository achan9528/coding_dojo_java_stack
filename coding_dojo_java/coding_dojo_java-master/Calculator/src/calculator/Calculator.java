package calculator;

public abstract class Calculator {
	private String operator;
	private double operandOne;
	private double operandTwo;
	private double result;
	private String calculatorName;
	private static int numCalculators = 0;
	
	public Calculator() {
		this.calculatorName = "Calculator" + Integer.toString(numCalculators);
		numCalculators++;
	}
	
	public Calculator(String name) {
		this.calculatorName = name;
		numCalculators++;
	}

	public void performOperation() {
		try {
			if (this.operator.equals("+")){
				this.result = this.operandOne + this.operandTwo;
			} else if (this.operator.equals("-")) {
				this.result = this.operandOne - this.operandTwo;
			}
		} catch (Exception e) {
			System.out.println("There was an error!\n");
			System.out.println(e.toString());
		}
	}
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getCalculatorName() {
		return calculatorName;
	}

	public void setCalculatorName(String calculatorName) {
		this.calculatorName = calculatorName;
	}
	
	
}

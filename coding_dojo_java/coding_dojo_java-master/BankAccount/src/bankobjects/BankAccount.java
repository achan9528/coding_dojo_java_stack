package bankobjects;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int numberOfAccounts = 0;
	private static double sumTotal = 0;
	
	public BankAccount() {
		this.accountNumber = generateAccountNumber();
		numberOfAccounts++;
	}
	
	private String generateAccountNumber() {
		Random r = new Random();
		String acctNum = "";
		for (int i = 0; i < 10; i ++) {
			String digit = Integer.toString(r.nextInt(9));
			acctNum += digit;
		}
		return acctNum;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public void deposit(String acctType, double deposit) {
		if (acctType.equals("checking")) {
			this.setCheckingBalance(this.getCheckingBalance() + deposit);
		} else if (acctType.equals("savings")) {
			this.setSavingsBalance(this.getSavingsBalance() + deposit);
		}
		sumTotal += deposit;
	}
	
	public void withdraw(String acctType, double withdrawal) {
		if (acctType.equals("checking")) {
			if (this.checkingBalance > withdrawal) {
				this.setCheckingBalance(this.getCheckingBalance() - withdrawal);
				sumTotal -= withdrawal;
			} else {
				System.out.println("Insufficient Funds");
			}
		} else if (acctType.equals("savings")) {
			if (this.savingsBalance > withdrawal) {
				this.setSavingsBalance(this.getSavingsBalance() - withdrawal);
				sumTotal -= withdrawal;
			} else {
				System.out.println("Insufficient Funds");
			}
		}
	}
	
	public static int numberOfAccounts() {
		return numberOfAccounts;
	}
	
	public static double sumTotal() {
		return sumTotal;
	}

}
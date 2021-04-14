package bankobjects.tests;

import bankobjects.*;

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount test = new BankAccount();
		BankAccount test2 = new BankAccount();
		
		test.deposit("checking", 100);
		test2.deposit("savings", 19847123);
		test2.withdraw("checking", 1231232130);
		System.out.println(BankAccount.numberOfAccounts());
		System.out.println(BankAccount.sumTotal());
	}
}

import java.util.Scanner;

class Account {
	protected int accountId;
	protected String accountType;
	protected double balance;

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;
	}
}

class Customer {
	private String customerName;
	private int customerAge;

	public void setCustomerName(String name) {
		this.customerName = name;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerAge(int age) {
		this.customerAge = age;
	}

	public int getCustomerAge() {
		return customerAge;
	}
}

class SavingsAccount extends Account {
	private double minimumBalance = 1000;

	public void setMinimumBalance(double minBalance) {
		this.minimumBalance = minBalance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public boolean withdraw(double amount) {
		if (amount > 20000) {
			System.out.println("Withdrawal failed. Maximum limit of withdrawal in one transaction is Rs.20000.");
			return false;
		} else if ((balance - amount) < minimumBalance) {
			System.out.println("Withdrawal failed. Insufficient balance to maintain the minimum balance.");
			return false;
		} else {
			balance -= amount;
			System.out.println("Withdrawal successful. Balance is: " + balance);
			return true;
		}
	}
}

class Bank {
	private Scanner sc = new Scanner(System.in);
	private SavingsAccount account;
	private Customer customer;

	public void createAccount() {
		customer = new Customer();
		account = new SavingsAccount();

		System.out.print("Enter your name: ");
		customer.setCustomerName(sc.nextLine());

		int age;
		do {
			System.out.print("Enter your age: ");
			age = sc.nextInt();
			if (age < 18) {
				System.out.println("Minimum age should be 18 to create an account.");
			}
		} while (age < 18);
		customer.setCustomerAge(age);

		System.out.print("Enter your account Id: ");
		account.accountId = sc.nextInt();

		sc.nextLine(); // Consume newline
		System.out.print("Enter your account type: ");
		account.setAccountType(sc.nextLine());

		System.out.print("Enter balance: ");
		account.setBalance(sc.nextDouble());

		System.out.print("Enter minimum balance: ");
		((SavingsAccount) account).setMinimumBalance(sc.nextDouble());

		System.out.println("Account created successfully!");
	}

	public void displayAccountInfo() {
		if (account == null || customer == null) {
			System.out.println("No account found. Please create an account first.");
			return;
		}
		System.out.println("Welcome " + customer.getCustomerName() + "! Following are your account details:");
		System.out.println("Age: " + customer.getCustomerAge());
		System.out.println("Account Id: " + account.accountId);
		System.out.println("Account Type: " + account.getAccountType());
		System.out.println("Balance: " + account.getBalance());
		System.out.println("Minimum balance: " + ((SavingsAccount) account).getMinimumBalance());
	}

	public void checkBalance() {
		if (account == null) {
			System.out.println("No account found. Please create an account first.");
			return;
		}
		System.out.println("Balance is: " + account.getBalance());
	}

	public void depositAmount() {
		if (account == null) {
			System.out.println("No account found. Please create an account first.");
			return;
		}
		System.out.print("Enter the amount you want to deposit: ");
		double deposit = sc.nextDouble();
		account.setBalance(account.getBalance() + deposit);
		System.out.println("Amount deposited successfully. Balance is: " + account.getBalance());
	}

	public void withdrawAmount() {
		if (account == null) {
			System.out.println("No account found. Please create an account first.");
			return;
		}
		System.out.print("Enter the amount you want to withdraw: ");
		double amount = sc.nextDouble();
		((SavingsAccount) account).withdraw(amount);
	}
}

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		boolean continueActions = true;

		while (continueActions) {
			System.out.println("1. Create Account");
			System.out.println("2. Display Account");
			System.out.println("3. Check Balance");
			System.out.println("4. Deposit Amount");
			System.out.println("5. Withdraw Amount");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				bank.createAccount();
				break;
			case 2:
				bank.displayAccountInfo();
				break;
			case 3:
				bank.checkBalance();
				break;
			case 4:
				bank.depositAmount();
				break;
			case 5:
				bank.withdrawAmount();
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}

			System.out.print("Do you want to perform more actions? (yes/no): ");
			String response = sc.next();
			if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("y")) {
				continueActions = false;
			}
		}

		System.out.println("Thank you for using our banking system!");
		sc.close();
	}
}


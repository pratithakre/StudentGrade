import java.io.*;
import java.util.*;

class Account 
{
     String accountNumber;
     String accountHolderName;
     double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } 
		else 
            System.out.println("Invalid amount.");
        
    }

    public void withdraw(double amount) 
	{
        if (amount > 0 && amount <= balance)
			{
            balance -= amount;
            System.out.println("Successfully withdraw: " + amount);
            } 
		else 
            System.out.println("Invalid or insufficient balance.");
        
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void saveToFile() throws IOException 
	{
        FileWriter fw = new FileWriter("acn.txt", true);
        fw.write("accountNumber ="+accountNumber + "accountHolderName=" + accountHolderName + "balance" + balance + "\n");
        fw.close();
    }
}

class demo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        Account account = new Account(accountNumber, accountHolderName, initialBalance);

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the Banking System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
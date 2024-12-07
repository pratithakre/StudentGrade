import java.util.*;

class Account {
    String accountHolderName;
    double balance;

    Account(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
}

 class OnlineBankingSystem {
    public static void main(String[] args) {
        HashMap<Integer, Account> accounts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int accountNumber = 1;

        while (true) {
            System.out.println("1. Create Account\n2. Deposit Money\n3. Withdraw Money\n4. Transfer Money\n5. View Account Details\n6. Exit");
			System.out.println("Choose any number");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter account holder name: ");
                    String name = scanner.next();
                    accounts.put(accountNumber, new Account(name, 0.0));
                    System.out.println("Account created successfully. Your account number is: " + accountNumber);
                    accountNumber++;
                    break;

                case 2:
                    System.out.println("Enter account number: ");
                    int depositAcc = scanner.nextInt();
                    if (accounts.containsKey(depositAcc)) {
                        System.out.println("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        accounts.get(depositAcc).balance += depositAmount;
                        System.out.println("Amount deposited successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter account number: ");
                    int withdrawAcc = scanner.nextInt();
                    if (accounts.containsKey(withdrawAcc)) {
                        System.out.println("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (accounts.get(withdrawAcc).balance >= withdrawAmount) {
                            accounts.get(withdrawAcc).balance -= withdrawAmount;
                            System.out.println("Amount withdrawn successfully.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter your account number: ");
                    int senderAcc = scanner.nextInt();
                    System.out.println("Enter receiver account number: ");
                    int receiverAcc = scanner.nextInt();
                    if (accounts.containsKey(senderAcc) && accounts.containsKey(receiverAcc)) {
                        System.out.println("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        if (accounts.get(senderAcc).balance >= transferAmount) {
                            accounts.get(senderAcc).balance -= transferAmount;
                            accounts.get(receiverAcc).balance += transferAmount;
                            System.out.println("Amount transferred successfully.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("One or both accounts not found.");
                    }
                    break;

                case 5:
                    System.out.println("Enter account number: ");
                    int viewAcc = scanner.nextInt();
                    if (accounts.containsKey(viewAcc)) {
                        Account acc = accounts.get(viewAcc);
                        System.out.println("Account Holder: " + acc.accountHolderName);
                        System.out.println("Balance: " + acc.balance);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
 }
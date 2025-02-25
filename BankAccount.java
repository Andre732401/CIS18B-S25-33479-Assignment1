import java.util.Scanner;

public class BankAccount {
    String accountHolderName; //Variables for account information.
    int accountNumber;
    double balance;

    public BankAccount() { // Constructor used to initialize the BankAccount object with default values
        accountHolderName = "John Doe";
        accountNumber = 0;
        balance = 0;
    }

    void deposit(double amount) { // Method used for depositing money to the account
        if (amount > 0) { // This if statement is used to ensure the user inputs a positive number
            balance += amount;
            System.out.println("Deposit Successful! New Balance: $" + balance);
        } else {
            System.out.println("ERROR! Negative numbers cannot be entered!");
        }
    }

    void withdraw(double amount) { // Method used for withdrawing money from the account
        if (amount > 0) { // This if statement is used to ensure the user inputs a positive number
            if (amount <= balance) { // This if statement is used to ensure the user has enough funds in their account to complete the withdrawal
                balance -= amount;
                System.out.println("Withdrawal Successful! New Balance: $" + balance);
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Nice try!");
        }
    }

    void getBalance() { // Method used for getting the balance of the account
        System.out.println("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        BankAccount newBankAccount = new BankAccount(); // This statement creates a new BankAccount object
        System.out.println("Welcome to Simple Bank System");
        try {
            do { // This do statement prints the menu containing the user's options
                System.out.println("1. Create Account\n2. Deposit Money\n3. Withdraw Money\n4. Check Balance\n5. Exit");
                System.out.println("Enter your choice:");
                choice = scanner.nextInt(); // Reads the user's input from their keyboard to select an option
                scanner.nextLine();
                switch (choice) {
                    case 1: // Used when creating an account
                        System.out.println("Enter Account Holder Name: ");
                        newBankAccount.accountHolderName = scanner.nextLine();
                        System.out.println("Enter initial Deposit: ");
                        newBankAccount.balance = scanner.nextDouble();
                        System.out.println("Account created successfully!");
                        break;

                    case 2: // Used when depositing money
                        System.out.println("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        newBankAccount.deposit(depositAmount);
                        break;

                    case 3: // Used when withdrawing money
                        System.out.println("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        newBankAccount.withdraw(withdrawAmount);
                        break;

                    case 4: // Used wehn displaying the current balance
                        newBankAccount.getBalance();
                        break;
                }
            } while (choice > 0 && choice < 5); // The while loop allows the menu to continue displaying until the user decides to exit

            if (choice == 5) {
                System.out.println("Goodbye!"); // If the user selects the "Exit" option, this message will display.
            } else {
                System.out.println("ERROR!"); // If the user enters any invalid number, such as a number below 0 or above 5, this message will display.
            }
        } catch (Exception e) {
            System.out.println("ERROR! Invalid input!"); // If the user enters any invalid input, this message will display.
        }
    }
}


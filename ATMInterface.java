package CodSoft;
import java.util.*;

class Bank{
    private double balance;

    public Bank(double balance){
        this.balance = balance;
    }

    public boolean deposit(double amount){
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount){
        if (amount > 0) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance(){
        return this.balance;
    }
}

class ATM {
    private Bank account;
    private Scanner scanner;

    public ATM(Bank account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + account.checkBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.println("Deposit successful. New balance: " + account.checkBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + account.checkBalance());
    }

    public void start() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice (Withdraw / Deposit / Check Balance / Exit): ");
            
            String choice = scanner.nextLine();

            

            switch (choice) {
                case "Withdraw":
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case "Deposit":
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case "Check Balance":
                    checkBalance();
                    break;
                case "Exit":
                    System.out.println("Exiting ATM. Have a nice day!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
            scanner.nextLine();
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Bank userAccount = new Bank(1000);  
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
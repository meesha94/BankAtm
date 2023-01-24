package org.example;

import java.util.Scanner;

public class BankAccount {
    public int balance;
    public int previousTransaction;
    public String customerName;
    public String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("Options: ");
        System.out.println("\n");
        System.out.println("A - Check Balance");
        System.out.println("\n");
        System.out.println("B- Deposit");
        System.out.println("\n");
        System.out.println("C - Withdraw");
        System.out.println("\n");
        System.out.println("D - Previous Transactions");
        System.out.println("\n");
        System.out.println("E - Exit");

        do {
            System.out.println("------------");
            System.out.println("Enter an option");
            System.out.println("------------");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("------------");
                    System.out.println("Balance: " + balance);
                    System.out.println("------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("------------");
                    System.out.println("Enter an amount to deposit:");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("------------");
                    System.out.println("Enter an amount to withdraw:");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("------------");
                    getPreviousTransaction();
                    System.out.println("------------");
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option");
                    break;
            }
        }
        while (option != 'E');
        System.out.println("Thank you for visiting our services");
    }

}

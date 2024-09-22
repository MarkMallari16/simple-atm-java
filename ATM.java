/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Athlon 3000g
 */
import java.util.ArrayList;
import java.util.List;

public class ATM {

    private double balance = 0;
    private List<String> transactions;

    public ATM() {
        transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        this.balance += amount;
        transactions.add("Deposit $" + amount);
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        transactions.add("Withdraw $" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void displayTransactions() {
        System.out.println("\n\nTransaction History");

        if (transactions.isEmpty()) {
            System.out.println("No transaction yet");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

}

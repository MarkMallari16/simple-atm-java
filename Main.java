/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Athlon 3000g
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void displayATMOptions() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transaction History");
        System.out.println("5. Logout");
        System.out.print("Enter option: ");
    }

    public static void divideDash() {
        System.out.println("============================================================");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        User user1 = new User("Mark", "12345");
      
        
        ATM atm = new ATM();

        String username;
        String password;
        divideDash();
        System.out.println("\t\t\tBDO ATM Machine");
        divideDash();
        System.out.print("Enter your username: ");
        username = input.nextLine();

        divideDash();

        System.out.print("Enter your password: ");
        password = input.nextLine();

        divideDash();
        if (user1.checkUsername(username) && user1.checkPassword(password)) {
            System.out.println("Welcome back " + user1.getUserName() + "!\n\n");

            int option;

            do {

                displayATMOptions();
                if (!input.hasNextInt()) {
                    System.out.println("Invalid option! Please enter a number");
                    input.next();
                    displayATMOptions();
                }
                option = input.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("\nYour balance is: " + atm.getBalance() + "\n");
                        break;
                    case 2:
                        double deposit;
                        System.out.print("\nEnter deposit amount: ");
                        deposit = input.nextDouble();

                        atm.deposit(deposit);

                        System.out.println("\nDeposit Successfully!");
                        break;
                    case 3:
                        double withdraw;

                        System.out.print("\nEnter withdraw amount: ");
                        withdraw = input.nextDouble();

                        if (withdraw > 0) {
                            if (atm.getBalance() >= withdraw) {
                                atm.withdraw(withdraw);
                                System.out.println("\nWithdrawal  successfull!");
                            } else {
                                System.out.println("\nInsufficienct balance.");
                            }
                        } else {
                            System.out.println("\nWithdrawal amount must be positive");
                        }
                        break;
                    case 4:
                        atm.displayTransactions();
                        break;

                    case 5:
                        System.out.println("\n\nLogging out...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } while (option != 5);
        } else {
            System.out.println("Invalid username or password");
        }

        input.close();
    }

}

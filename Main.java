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

    public static void displayATMOptions() {
        System.out.println("\n\n1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transaction History");
        System.out.println("5. User Information");
        System.out.println("6. Logout");
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
            System.out.println("Welcome back " + user1.getUserName() + "!");

            int option;

            do {

                displayATMOptions();
                if (!input.hasNextInt()) {
                    System.out.println("\nInvalid option! Please enter a number");
                    input.next();
                    displayATMOptions();
                }

                option = input.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("\nYour balance is: " + atm.getBalance() + "");
                        break;
                    case 2:
                        double deposit;
                        System.out.print("\nEnter deposit amount: ");
                        while (!input.hasNextDouble()) {
                            System.out.println("Invalid amount! Please enter a valid number.");
                            input.next();
                        }
                        deposit = input.nextDouble();
                        atm.deposit(deposit);

                        divideDash();
                        System.out.println("\nDeposit Successfully!\n");
                        divideDash();
                        break;
                    case 3:
                        double withdraw;

                        System.out.print("\nEnter withdraw amount: ");
                        withdraw = input.nextDouble();

                        if (withdraw > 0) {
                            if (atm.getBalance() >= withdraw) {
                                atm.withdraw(withdraw);
                                divideDash();
                                System.out.println("\nWithdrawal  successfull!\n");
                                divideDash();
                            } else {
                                divideDash();
                                System.out.println("\nInsufficienct balance.\n");
                                divideDash();
                            }
                        } else {
                            divideDash();
                            System.out.println("\nWithdrawal amount must be positive");
                            divideDash();
                        }
                        break;
                    case 4:
                        divideDash();
                        atm.displayTransactions();
                        divideDash();
                        break;
                    case 5:
                        user1.displayUserInformation();
                        int userInfoOption;

                        divideDash();
                        System.out.println("1. Change username");
                        System.out.println("2. Change password");
                        System.out.println("3. Exit");
                        System.out.print("Your option: ");
                        userInfoOption = input.nextInt();

                        input.nextLine();

                        divideDash();

                        switch (userInfoOption) {
                            case 1:
                                String newUsername;

                                System.out.print("\nEnter new username: ");
                                newUsername = input.nextLine();

                                user1.setUsername(newUsername);
                                break;
                            case 2:
                                System.out.println("\nEnter current password: ");
                                String currentPassword = input.nextLine();

                                if (user1.checkPassword(currentPassword)) {
                                    String newPassword;

                                    System.out.println("\nEnter new password: ");
                                    newPassword = input.nextLine();

                                    user1.setPassword(newPassword);
                                } else {
                                    System.out.println("\nInvalid current password");
                                }
                                break;
                            case 3:
                                break;
                            default: 
                                System.out.println("Invalid Value!");
                        }
                        
                        break;
                    case 6:
                        System.out.println("\n\nLogging out...");
                        break;
                    default:
                        System.out.println("\nInvalid option!");
                }
            } while (option != 6);
        } else {
            System.out.println("Invalid username or password");
        }

        input.close();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Athlon 3000g
 */
public class User {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    //check if username is correct
    public boolean checkUsername(String usernmae) {
        return this.username.equals(usernmae);
    }

    //check if password is correct
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void displayUserInformation() {
        String hiddenPassword = "*".repeat(password.length());
        System.out.println("\n\nUser Info");
        System.out.println("Username: " + username);
        System.out.println("Password: " + hiddenPassword + "\n\n");
    }
}

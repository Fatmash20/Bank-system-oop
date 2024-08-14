/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
package banksystem;

import java.util.Scanner;

public class Client extends Person {
    private double balance;

    public void setBalance(double b) {
        boolean valid = Validation.validateBalance(b);
        Scanner scanner = new Scanner(System.in);// todo
        while (!valid) {
            System.out.println("Make sure that your balance meets the requirement ");
            b = scanner.nextDouble();
            valid = Validation.validateBalance(b);
        }
        // scanner.close();
        balance = b;
    }

    public double getBalance() {
        return balance;
    }

    // : We can set the default constructor to private to prevent creating an
    // object without initializing the balance and user info
    public Client() {

    }

    // DONE: add Validation to the constructor
    // done
    // DONE: The super constructor should be called with the right parameters
    public Client(int id, String name, String pass, double balance) {
        super(id, name, pass);
        setBalance(balance);// to prevent the user from entering an invalid balance and repeat the process
                            // of validation
    }

    // DONE: You could check the amount before depositing it (if it's negative or
    // not)
    public void Deposit(double amount) {
        if (amount < 0) {
            System.out.println("Make sure that the amount is positive ");
            return;
        }
        this.balance += amount;
        System.out.println("Successful transaction, Your balance is: " + this.balance);
    }

    public void Withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Make sure that the amount is positive ");
            return;
        }

        if (balance > amount) {
            this.balance -= amount;
            System.out.println("Successful transaction, Your balance is: " + this.balance);
        } else {
            System.out.println("your balance not enough ");
        }
    }

    public void TransferTo(double amount, Client recipient) {
        if (amount < 0) {
            System.out.println("Make sure that the amount is positive ");
            return;
        }
        if (this.balance > amount) {
            this.balance -= amount;
            recipient.balance += amount;
            System.out.println("Successful transaction, Your balance is: " + this.balance);
        } else {
            System.out.println("your balance not enough ");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" Balance : " + this.balance);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

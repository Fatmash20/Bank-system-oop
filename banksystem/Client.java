/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
package banksystem;

public class Client extends Person {
    private double balance;

    public void setBalance(double b) {
        if (Validation.validateBalance(balance)) {
            balance = b;
        } else {
            System.out.println("Make sure that your balance meets the requirement ");
        }
    }

    public double getBalance() {

        return balance;
    }

    public Client() {

    }

    public Client(int id, String pass, String name, double balance) {
        this.balance = balance;
    }

    public void Deposit(double amount) {
        this.balance += amount;
        System.out.println("Successful transaction, Your balance is: "+this.balance);

    }

    public void Withdraw(double amount) {
        if (balance > amount) {
            this.balance -= amount;
            System.out.println("Successful transaction, Your balance is: "+this.balance);
        } else {
            System.out.println("your balance not enough ");
        }

    }

    public void TransferTo(double amount, Client recipient) {
        if (this.balance > amount) {
            this.balance -= amount;
            recipient.balance += amount;
            System.out.println("Successful transaction, Your balance is: "+this.balance);
        } else {
            System.out.println("your balance not enough ");
        }
    }

    @Override
    public void Display() {
        super.Display();
        System.out.println(" Balance : " + this.balance);
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

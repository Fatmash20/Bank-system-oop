package banksystem;

import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Employee extends Person {

    private double salary;
    // Constructors

    public Employee() {

    }

    public Employee(int id, String name, String password, double salary) {
        super(id, name, password);
        setSalary(salary);
    }

    // Setter
    public boolean setSalary(double salary) {
        // Initial validation
        if (Validation.validateSalary(salary)) {
            this.salary = salary;
            return true;
        } else {
            System.out.println("Make sure that your salary meets the requirement.");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                salary = scanner.nextDouble();
                if (Validation.validateSalary(salary)) {
                    this.salary = salary;
                    // scanner.close();
                    return true;
                } else {
                    System.out.println("Invalid salary. Please enter a valid salary:");
                }
            }
        }
    }

    // Getter
    public double getSalary(double salary) {
        return salary;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" Salary : " + this.salary);
    }

    static public void displayClients(List<Client> Clients) {
        for (Client client : Clients) {
            client.display();
        }
    }

    // edit client info method
    public void editClientInfo(Client client, String newName, String newPasseord) {
        if (client != null) {
            client.setName(newName);
            client.setPass(newPasseord);
            System.out.println(" Client info edit Successfully ");
        } else {
            System.out.println("client not found");
        }
    }

    // public static List<Client> getClient() {
    // return client; // Provide public access through a method
    // }

    @Override
    public String toString() {
        return super.toString() + " Salary : " + this.salary;
    }
}

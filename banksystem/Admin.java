package banksystem;

import java.util.ArrayList;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */

// FIXME: Rethink the inheritance relationship between Admin and Employee
// If the admin is an employee, and the priviliges could change, then it's
// better to keep them in the same class and just add an isAdmin field to
// distinguish between admins and regular employees

// FIXME: The Admin class should not have a list of employees and should not be
// storing any of them
public class Admin extends Employee {

    // Constructors
    public Admin() {
        super();
    }

    public Admin(int id, String name, String password, double salary) {
        super(id, name, password, salary);

    }

    @Override
    public void display() {
        super.display();
    }

    static public void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees)
            employee.display();
    }

    public static Employee searchEmployee(List<Employee> employeeList, int id) {
        if (employeeList == null || employeeList.isEmpty()) {
            return null;
        }
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static Employee searchEmployee(List<Employee> employeeList, int id, String pass) {
        if (employeeList == null || employeeList.isEmpty()) {
            return null;
        }

        for (Employee employee : employeeList) {
            if (employee.getId() == id && employee.getPassword().equals(pass)) {
                return employee;
            }
        }
        return null;
    }

    // view all employee
    public void displayAllEmployees(List<Employee> employees) {
        for (Employee employee : employees)
            employee.display();
    }

    // edit employee info
    public void editEmployeeInfo(Employee employee, String newName, String newPassword, double salary) {
        if (employee != null) {
            employee.setName(newName);
            employee.setPass(newPassword);
            employee.setSalary(salary);
            System.out.println("Employee info edit Successfully");
        } else {
            System.out.println("Employee not found");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

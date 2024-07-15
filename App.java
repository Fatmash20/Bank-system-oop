import java.util.Scanner;

import banksystem.Admin;
import banksystem.Client;
import banksystem.Employee;

public class App {
    private static Scanner input = new Scanner(System.in);
    private static Admin admin;

    public static void main(String[] args) throws Exception {
        int choice;
        Admin admin = new Admin(1, "Admin", "adminpass1", 100000);

        while (true) {
            printMainMenu();
            choice = input.nextInt();
            input.nextLine(); // newline
            switch (choice) {
                case 1:
                    clientLogin();
                    break;
                case 2:
                    employeeLogin();
                    break;
                case 3:
                    if (admin != null) {
                        adminLogin(admin);
                    } else {
                        System.out.println("Admin is not initialized.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choise,Try Again");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\nBank System Main Menu:");
        System.out.println("1. Client Login");
        System.out.println("2. Employee Login");
        System.out.println("3. Admin Login");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void clientLogin() {
        int id;
        String pass;
        System.out.println("Enter Client ID: ");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Enter Client Password: ");
        pass = input.nextLine();
        Client client = null;// initial value in case not found client in menu clients
        for (Client c : Employee.getClients()) {
            if (c.getid() == id && c.getpassword().equals(pass)) {
                client = c;
                break;
            }
        }
        if (client != null) {
            clientMenu(client);
        } else {
            System.out.println("Invalid Client ID or Password.");
        }
    }

    private static void clientMenu(Client client) {
        int choice;
        while (true) {

            System.out.println("\nClient Menu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Transfer Money");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    client.Deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    client.Withdraw(withdrawAmount);
                    break;
                case 3:
                    client.getbalance();
                    break;
                case 4:
                    System.out.println("Enter recipient Client ID: ");
                    int recipientID = input.nextInt();
                    input.nextLine();
                    Client recipient = admin.SearchClient(recipientID);
                    if (recipient != null) {
                        System.out.println("Enter amount to transfer: ");
                        double transferAmount = input.nextDouble();
                        client.TransferTo(transferAmount, recipient);

                    } else {
                        System.out.println("Recipient Client not found.");
                    }
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void employeeLogin() {
        System.out.println("Enter Employee ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter Employee Password: ");
        String password = input.nextLine();

        Employee employee = admin.SearchEmployee(id);
        if (employee != null && employee.getpassword().equals(password)) {
            employeeMenu(employee);
        } else {
            System.out.println("Invalid Employee ID or Password.");
        }
    }

    private static void employeeMenu(Employee employee) {
        while (true) {
            System.out.println("\nEmployee Menu:");
            System.out.println("1. Add Client");
            System.out.println("2. Search Client");
            System.out.println("3. List All Clients");
            System.out.println("4. Edit Client Info");
            System.out.println("5. Display Info");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("Enter Client ID: ");
                    int clientId = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter Client Password: ");
                    String clientPass = input.nextLine();
                    System.out.println("Enter Client Name: ");
                    String clientName = input.nextLine();
                    System.out.println("Enter Client Balance: ");
                    double clientBalance = input.nextDouble();
                    Client newClient = new Client(clientId, clientPass, clientName, clientBalance);
                    employee.AddClient(newClient);
                    break;
                case 2:
                    System.out.println("Enter Client ID to search: ");
                    int SearchClientid = input.nextInt();
                    input.nextLine();
                    Client SearchClient = employee.SearchClient(SearchClientid);
                    if (SearchClient != null) {
                        System.out.println("Client found" + SearchClient);
                    } else {
                        System.out.println("Client not found. ");
                    }
                case 3:
                    employee.getAllClient();
                case 4:
                    System.out.print("Enter Client ID to edit: ");
                    int editClientId = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter new Client Name: ");
                    String newClientName = input.nextLine();
                    System.out.print("Enter new Client Password: ");
                    String newClientPassword = input.nextLine();
                    employee.editClientInfo(editClientId, newClientName, newClientPassword);
                    break;
                case 5:
                    employee.Display();
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void adminLogin(Admin admin) {
        System.out.print("Enter Admin ID: ");
        int id = input.nextInt();
        input.nextLine(); // Consume the newline left-over
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        System.out.println("Expected ID: " + admin.getid() + ", Entered ID: " + id);
        System.out.println("Expected Password: " + admin.getpassword() + ", Entered Password: " + password);
        if (admin.getid() == id && admin.getpassword().equals(password)) {
            adminMenu(admin);
        } else {
            System.out.println("Invalid Admin ID or Password.");
        }
    }

    private static void adminMenu(Admin admin) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. List All Employees");
            System.out.println("4. Edit Employee Info");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int employeeId = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String employeeName = input.nextLine();
                    System.out.print("Enter Employee Password: ");
                    String employeePassword = input.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double employeeSalary = input.nextDouble();
                    Employee newEmployee = new Employee(employeeId, employeeName, employeePassword, employeeSalary);
                    admin.AddEmployee(newEmployee);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchEmployeeId = input.nextInt();
                    Employee searchedEmployee = admin.SearchEmployee(searchEmployeeId);
                    if (searchedEmployee != null) {
                        System.out.println("Employee found: " + searchedEmployee);//
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    admin.getAllEmployee();
                    break;
                case 4:
                    System.out.print("Enter Employee ID to edit: ");
                    int editEmployeeId = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter new Employee Name: ");
                    String newEmployeeName = input.nextLine();
                    System.out.print("Enter new Employee Password: ");
                    String newEmployeePassword = input.nextLine();
                    System.out.print("Enter new Employee Salary: ");
                    double newEmployeeSalary = input.nextDouble();
                    admin.editEmployeeInfo(editEmployeeId, newEmployeeName, newEmployeePassword, newEmployeeSalary);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

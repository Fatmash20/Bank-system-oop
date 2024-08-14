import banksystem.Admin;
import banksystem.Client;
import banksystem.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);

    // TODO: Centralize the storage location of the admin, employee, and client
    // objects and store each in a property of array type.
    static List<Admin> adminList = new ArrayList<>();
    static List<Employee> employeeList = new ArrayList<>();
    static List<Client> clientList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int choice;
        clientList.add(new Client(1, "Ahmed", "ahmed123", 1000));
        clientList.add(new Client(2, "Fatima", "fatima123", 2000));
        employeeList.add(new Employee(1, "Arwa", "arwa1234", 10000));
        employeeList.add(new Employee(2, "Abrar", "abrar123", 10000));
        adminList.add(new Admin(1, "Mohammed", "mohammed123", 100000));
        adminList.add(new Admin(2, "Omar", "omar1234", 100000));

        // print client list
        for (Client c : clientList) {
            System.out.println(c);
        }
        // print employee list
        for (Employee e : employeeList) {
            System.out.println(e);
        }
        while (true) {
            printMainMenu();
            if (input.hasNextInt()) {// TODO
                choice = input.nextInt();
                input.nextLine(); // consume newline
                switch (choice) {
                    case 1:
                        clientLogin();
                        break;
                    case 2:
                        employeeLogin();
                        break;
                    case 3:

                        adminLogin();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid Choise,Try Again");
                }
            } else {
                System.out.println("No integer input provided, please enter a valid choice.");
                input.nextLine(); // consume the invalid input to prevent infinite loop
            }

        }
    }

    // TODO: Move this menu to another class
    private static void printMainMenu() {
        System.out.println("\nBank System Main Menu:");
        System.out.println("1. Client Login");
        System.out.println("2. Employee Login");
        System.out.println("3. Admin Login");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // TODO: Move this menu to another class
    private static Client findClientByIdAndPassword(int id, String pass) {
        if (clientList == null || clientList.isEmpty()) {
            return null;
        }
        for (Client c : clientList) {
            if (c.getId() == id && c.getPassword().equals(pass)) {
                return c;
            }
        }
        return null;
    }

    private static Client findClientById(int id) {
        if (clientList == null || clientList.isEmpty()) {
            return null;
        }
        for (Client c : clientList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private static void clientLogin() {
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();
        input.nextLine(); // Consume newline left-over
        System.out.println("Enter Client Password: ");
        String pass = input.nextLine();

        Client client = findClientByIdAndPassword(id, pass);

        if (client != null) {
            clientMenu(client);
        } else {
            System.out.println("Invalid Client ID or Password.");
        }
    }

    // TODO: Move this menu to another class
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
                    System.out.println("Your balance is: " + client.getBalance());
                    break;
                case 4:
                    System.out.println("Enter recipient Client ID: ");
                    int recipientID = input.nextInt();
                    input.nextLine();
                    Client recipient = findClientById(recipientID);
                    if (recipient != null) {
                        System.out.println("Enter amount to transfer: ");
                        double transferAmount = input.nextDouble();
                        client.TransferTo(transferAmount, recipient);
                    } else {
                        System.out.println("Recipient not found.");
                    }
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // TODO: Move this menu to another class
    private static void employeeLogin() {
        System.out.println("Enter Employee ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter Employee Password: ");
        String password = input.nextLine();
        Employee employee = Admin.searchEmployee(employeeList, id, password);

        if (employee != null) {
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
                    Client newClient = new Client(clientId, clientName, clientPass, clientBalance);
                    clientList.add(newClient);
                    break;
                case 2:
                    System.out.println("Enter Client ID to search: ");
                    int SearchClientid = input.nextInt();
                    input.nextLine();
                    Client SearchClient = findClientById(SearchClientid);
                    if (SearchClient != null) {
                        System.out.println("Client found" + SearchClient);
                    } else {
                        System.out.println("Client not found. ");
                    }
                    break;
                case 3:
                    Employee.displayClients(clientList);
                    break;
                case 4:
                    System.out.print("Enter Client ID to edit: ");
                    int editClientId = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter new Client Name: ");
                    String newClientName = input.nextLine();
                    System.out.print("Enter new Client Password: ");
                    String newClientPassword = input.nextLine();
                    Client editedClient = findClientById(editClientId);
                    employee.editClientInfo(editedClient, newClientName, newClientPassword);
                    break;
                case 5:
                    employee.display();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static Admin findAdminByIdAndPassword(int id, String pass) {
        if (adminList == null || adminList.isEmpty()) {
            return null;
        }
        for (Admin a : adminList) {
            if (a.getId() == id && a.getPassword().equals(pass)) {
                return a;
            }
        }
        return null;
    }

    // TODO: Move this menu to another class
    private static void adminLogin() {
        System.out.print("Enter Admin ID: ");
        int id = input.nextInt();
        input.nextLine(); // Consume the newline left-over
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        Admin admin = findAdminByIdAndPassword(id, password);
        if (admin != null) {
            adminMenu(admin);
        } else {
            System.out.println("Invalid Admin ID or Password.");
        }
    }

    // TODO: Move this menu to another class
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
                    System.out.println("Your Employee salary is: " + employeeSalary);
                    Employee newEmployee = new Employee(employeeId, employeeName, employeePassword, employeeSalary);
                    employeeList.add(newEmployee);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchEmployeeId = input.nextInt();
                    Employee searchedEmployee = Admin.searchEmployee(employeeList, searchEmployeeId);
                    if (searchedEmployee != null) {
                        System.out.println("Employee found: " + searchedEmployee);//
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    Admin.displayEmployees(employeeList);
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
                    Employee editedEmployee = Admin.searchEmployee(employeeList, editEmployeeId);
                    admin.editEmployeeInfo(editedEmployee, newEmployeeName, newEmployeePassword, newEmployeeSalary);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

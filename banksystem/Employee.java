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
public class Employee extends Person {

  private double salary;
  protected static List<Client> clients= new ArrayList<>();
  // Constructors
  public Employee() {
    super();
}
public Employee(int id, String name, String password, double salary) {
    super(id, name, password);
    Set_Salary(salary);
}

  // Setter
  public boolean Set_Salary(double salary) {
    if (Validation.Validate_Salary(salary)) {
        this.salary = salary;
        return true;
    } else {
        System.out.println("Invalid salary. Salary must be greater than 0 and less than or equal to 100000.0 ");
        return false;
    }
}

      // Getter
      public double Get_salary ( double salary) 
     {
        return salary;
    }

    @Override
    public void Display() {
        super.Display();
        System.out.println(" Salary : " + this.salary);
    }
    //add client method
    public void AddClient(Client client){
        clients.add(client);
        System.out.println("Client added successfully");
    }
    // search client method 
    public Client SearchClient(int id){
        for (Client client : clients) {
            if(client.getid()==id){
                return client;
            }
        }
        return null;
    
        
    }
    // view all clients method
    public void getAllClient(){
        for (Client client : clients) {
            client.Display();
        }
    }
    //edit client info method
    public void editClientInfo(int ClientId, String newPasseord, String newName){
        Client client = SearchClient(ClientId);
        if(client!=null){
            client.setpass(newPasseord);
            client.setname(newName);
            System.out.println(" Client info edit Successfully ");
        }
        else{
            System.out.println("client not found");
        }
    }
    public static List<Client> getClients() {
        return clients; // Provide public access through a method
    }
}


  
    
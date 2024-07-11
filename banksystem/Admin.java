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
public class Admin extends Employee {
    protected static List<Employee> employees=new ArrayList<>();

      // Constructors
      public Admin() {
        super();
    }

    public Admin(int id, String name, String password, double salary) {
        super(id, name, password, salary);
       
    }
    // add employee
    public void AddEmployee( Employee employee){
        employees.add(employee);
        System.out.println("Employee added Successfuly");
    }
    // search employee
    public Employee SearchEmployee(int id){
        for( Employee employee : employees)
        {
            if(employee.getid()==id)
            return employee;
        }
        return null;
    }
    // view all employee
    public void getAllEmployee(){
        for(Employee employee:employees)
        employee.Display();
    }
     // edit employee info
     public void editEmployeeInfo(int id , String newPassword, String newName,double salary){
        Employee employee = SearchEmployee(id);
        if (employee!=null) {
            employee.setname(newName);
            employee.setpass(newPassword);
            employee.Set_Salary(salary);
            System.out.println("Employee info edit Successfully");
        } else{
            System.out.println("Employee not found");
        }
     }


}


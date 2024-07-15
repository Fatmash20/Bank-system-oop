/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
package banksystem;

public class Person {
  private int id;
  private String name;
  private String password;

  public void setname(String n) {
    if (Validation.Vali_name(name)) {
      name = n;
    } else {
      System.out.println("Make sure your name mattches the requirement ");
    }
  }

  public void setpass(String pass) {
    if (Validation.Vali_pass(pass)) {
      password = pass;
    } else {
      System.out.println("Make sure your passworde mattches the requirement ");
    }
  }

  public void setid(int id) {
    if (Validation.Vali_id(id)) {
      this.id = id;
    } else {
      System.out.println("Make sure your id mattches the requirement ");
    }
  }

  public int getid() {

    return id;
  }

  public String getpassword() {

    return password;
  }

  public String getname() {

    return name;
  }

  public Person() {

  }

  public Person(int id, String name, String pass) {
    this.id = id;
    password = pass;
    this.name = name;
  }

  public void Display() {
    System.out.println("NAME: " + name);
    System.out.println("Password: " + password);
    System.out.println("ID: " + id);
  }
}

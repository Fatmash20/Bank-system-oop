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

  public void setName(String n) {
    if (Validation.validateName(n)) {
      name = n;
    } else {
      System.out.println("Make sure your name mattches the requirement ");//TODO 
    }
  }

  public void setPass(String pass) {
    if (Validation.validatePass(pass)) {
      password = pass;
    } else {
      System.out.println("Make sure your passworde mattches the requirement ");
    }
  }

  public void setId(int id) {

    this.id = id;

  }

  public int getId() {

    return id;
  }

  public String getPassword() {

    return password;
  }

  public String getName() {

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
    System.out.println("ID: " + id);
    System.out.println("NAME: " + name);
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Person{ID=" + id + ", Name='" + name + "'}";
  }
  }


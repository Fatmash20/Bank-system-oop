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

public class Person {
  private int id;
  private String name;
  private String password;

  public void setName(String n) {
    if (Validation.validateName(n)) {
      this.name = n;
    } else {
      System.out.println("Make sure your name matches the requirement");
      Scanner scanner = new Scanner(System.in);
      while (true) {
        n = scanner.nextLine();
        if (Validation.validateName(n)) {
          this.name = n;
          // scanner.close();
          return;
        } else {
          System.out.println("Make sure your name matches the requirement");
        }
      }
    }
  }

  public void setPass(String pass) {
    if (Validation.validatePass(pass)) {
      password = pass;
    } else {
      System.out.println("Make sure your passworde matches the requirement ");
      Scanner scanner = new Scanner(System.in);
      while (true) {
        pass = scanner.nextLine();
        if (Validation.validatePass(pass)) {
          password = pass;
          // scanner.close();
          return;
        } else {
          System.out.println("Make sure your passworde matches the requirement ");
        }
      }
    }
  }

  public void setId(int id) {
    if (id < 0) {
      System.out.println("ID must be positive");
      Scanner scanner = new Scanner(System.in);
      while (true) {
        id = scanner.nextInt();
        if (id >= 0) {
          this.id = id;
          // scanner.close();
          return;
        } else {
          System.out.println("ID must be positive");
        }
      }
    }
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
    setId(id);
    setName(name);
    setPass(pass);
  }

  public void display() {
    System.out.println("ID: " + id);
    System.out.println("NAME: " + name);
  }

  @Override
  public String toString() {
    return "Person{ID=" + id + ", Name='" + name + "'}";
  }
}

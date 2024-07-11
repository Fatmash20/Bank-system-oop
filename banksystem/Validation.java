/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Dell
 */
package banksystem;
public class Validation {
    public static boolean Vali_name(String name) {

        // Check if name length is between 5 and 20 characters
        if (name.length() < 5 || name.length() > 20) {
            return false;
        }

        // Check if each character in the name is alphabetic
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean Vali_pass(String pass) {
        if (pass.length() < 8 || pass.length() > 20) {
            return false;
        }
        return true;
    }

    public static boolean Vali_balance(double balance) {
        if (balance < 1500)
            return true;
        return false;

    }

    static boolean Vali_id(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static boolean Validate_Salary(double salary) {
      
            // Define the maximum salary limit.
            final double MAX_SALARY = 100000.0;
            
              if (salary > 0 && salary <= MAX_SALARY) {
                return true; 
            } else {
                return false; 
        }}
    }


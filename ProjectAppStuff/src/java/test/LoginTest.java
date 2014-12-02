/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.secure.userInfo.*;
import helpers.*;
/**
 *
 * @author Kwangju
 */
public class LoginTest {
    
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        User a = new User("KWANGJU", "KIM", false, false);
        if (DBHandling.SignUp(a)) {
            System.out.println("Signing up successful.");
        } else {
            System.out.println("Signing up failed.");
        }
        if (DBHandling.Login(a)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Log in failed.");
        }
        if (DBHandling.DeleteAccount(a)) {
            System.out.println("Delete Account successful.");
        } else {
            System.out.println("Delete Account failed.");
        }
        User b = new User("m", "m", false, false);
        if (DBHandling.DeleteAccount(b)) {
            System.out.println("Delete Account successful.");
        } else {
            System.out.println("Delete Account failed.");
        }
    }
    
}

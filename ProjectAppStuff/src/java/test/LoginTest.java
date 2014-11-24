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
        User a = new User("KWANGJU", "KIM", true, true);
        User k = new User("ppp", "qqqqq", false, true);
        User f = new User("qgq", "qgqweg", false, false);
        
        System.out.println(DBHandling.Login(k));
        
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
        if (DBHandling.SignUp(k)) {
            System.out.println("Signing up successful.");
        } else {
            System.out.println("Signing up failed.");
        }
        if (DBHandling.Login(k)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Log in failed.");
        }
        if (DBHandling.SignUp(f)) {
            System.out.println("Signing up successful.");
        } else {
            System.out.println("Signing up failed.");
        }
        if (DBHandling.Login(f)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Log in failed.");
        }
    }
    
}

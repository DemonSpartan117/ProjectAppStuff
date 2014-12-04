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
        User a = new User("AAA", "aaa", true, true);
        User b = new User("BBB", "bbb", false, true);
        User c = new User("CCC", "ccc", false, false);
        System.out.println(DBHandling.SignUp(a));
        System.out.println(DBHandling.SignUp(b));
        System.out.println(DBHandling.SignUp(c));
    }
    
}

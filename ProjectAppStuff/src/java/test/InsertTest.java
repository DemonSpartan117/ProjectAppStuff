/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.others.App;
import helpers.DBHandling;

/**
 *
 * @author Kwangju
 */
public class InsertTest {
    
    public static void main(String[] args) {
        java.util.Scanner rd = new java.util.Scanner(System.in);
        System.out.print("Type your app name: ");
        String name = rd.nextLine();
        System.out.print("Type your name: ");
        String developer = rd.nextLine();
        System.out.print("Any descriptions you want to explain your app: ");
        String description = rd.nextLine();
        System.out.print("Which platform(s) is(are) available to run your app: ");
        String[] platform = {rd.nextLine()};
        System.out.print("The link navigating to the app download page: ");
        String link = rd.nextLine();
        try {
            System.out.println(DBHandling.insertApp(new App(name, developer, description, platform, link)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}

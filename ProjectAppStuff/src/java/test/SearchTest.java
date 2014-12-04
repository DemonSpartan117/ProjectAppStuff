/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

<<<<<<< HEAD
import com.App;
=======
>>>>>>> 71677c879cd52361e0863c882ec6896c4ff1001f
import com.others.*;
import helpers.*;
import helpers.servlets.*;

/**
 *
 * @author Kwangju
 */
public class SearchTest {
    
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.ArrayList<App> test = new java.util.ArrayList<App>();
        test.addAll(DBHandling.search("puppy_", false, false, 0));
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i).getName());
        }
<<<<<<< HEAD
=======
        App testApp = test.get(0);
        System.out.println(DBHandling.updateRating(testApp, 7.2));
        System.out.println(DBHandling.deleteApp(new App("n", null, null, null, null)));
>>>>>>> 71677c879cd52361e0863c882ec6896c4ff1001f
    }
    
}

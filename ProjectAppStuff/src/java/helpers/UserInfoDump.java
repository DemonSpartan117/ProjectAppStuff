/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import com.others.*;
import com.secure.userInfo.Guest;
import com.secure.userInfo.User;

/**
 *
 * @author ducketdw
 */
public class UserInfoDump {
    
    private User user;
    private String username;
    private String pass;
    App app;
    private static UserInfoDump me;

    public static UserInfoDump getInstance() {
        if(me == null) {
            me = new UserInfoDump();
        }
        return me;
    }
    
    private UserInfoDump() {
        user = Guest.getInstance();
        username = "Guest";
        pass = "";
        String temp = "temp";
        String[] var = {"part 1","part 2"};
        app = new App(temp, temp, temp, var, temp);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters. Click on the + sign on the left to edit the code.">
    public User getUser() {
        return user;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }// </editor-fold>

    public boolean login() throws Exception {
        boolean isAdmin = true;
        boolean isMod = true;
        /*so the proposed username and password are passed in as parameters
         then you need to search the database for User object with this
         username. Afterwards, check the password and see if it is the same as
         the password associated with the User object associated with the username
         then if it is you are to set the 'user' instance variable equal to the
         User object you got from the database and return true.
         If the username was not found or the password was wrong, then return
         false and I will work on the reprecussions from there*/

        /*also set the staticUser variable equal to the user variable so I can
         get the right information in all the other classes*/
        user = new User(username, pass, isMod, isAdmin);
        return DBHandling.Login(user);
        /*I set everything up the way it is now just for testing purposes and
         * to give an illusion of functionality (so I can know what is not right
         * (again, for testing)) set the User constructor I just called back to
         * protected if you can when you are done here*/
    }


}

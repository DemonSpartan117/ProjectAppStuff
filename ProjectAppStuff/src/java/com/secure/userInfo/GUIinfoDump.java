/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secure.userInfo;

import com.others.*;

/**
 *
 * @author ducketdw
 */
public class GUIinfoDump {
    User user;
    String userName = user.getName();
    boolean isAdmin = user.isAdmin();
    boolean isModerator = user.isModerator();
    
    App app;
    
    public GUIinfoDump() {
        user = new Guest();
    }
    
    public boolean login(String id, String pass) {
        /*so the proposed username and password are passed in as parameters
        then you need to search the database for User object with this
        username. Afterwards, check the password and see if it is the same as
        the password associated with the User object associated with the username
        then if it is you are to set the 'user' instance variable equal to the
        User object you got from the database and return true.
        If the username was not found or the password was wrong, then return
        false and I will work on the reprecussions from there*/
        return false;
    }
}

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
    private String userName = user.getName();
    private boolean isAdmin = user.isAdmin();
    private boolean isModerator = user.isModerator();
    
    App app;
    
    public UserInfoDump() {
        user = new Guest();
    }
    
    public User getUser() {
        return user;
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

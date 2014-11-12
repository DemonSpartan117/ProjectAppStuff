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
        user = new User();
    }
    
    public GUIinfoDump(String name, String password) {
        
    }
}

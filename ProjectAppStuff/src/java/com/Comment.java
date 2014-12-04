/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import helpers.UserInfoDump;

/**
 *
 * @author Kevin
 */
public class Comment {
    
    private String quote;
    private String commenter;
    
    public Comment(String commenter, String quote){
        this.quote = quote;
        this.commenter = commenter;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }
    
    //To be used to verify that the user is the user that posted the comment.
    public boolean verifyUser(){
        UserInfoDump info = UserInfoDump.getInstance();
        String loggedInUser = info.getUsername();
        if (this.getCommenter().equals(loggedInUser)){
            return true;
        }
        return false;
    }
}

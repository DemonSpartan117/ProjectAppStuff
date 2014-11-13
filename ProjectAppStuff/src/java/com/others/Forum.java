package com.others;

import com.secure.userInfo.User;

public class Forum {

    public class Comment {
        public String comment;
        public String commenter;
        
        Comment(User user, String comment) {
            this.comment = comment;
            commenter = user.getName();
        }
        
    }

    /*instance variable that will store all comments*/
    Comment[] comments;
    
    public Comment[] getComments() {
        /*method that translates everything into a simple array of comments*/
        return comments;
    }
}
